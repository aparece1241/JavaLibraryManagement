package Controllers;

import Models.User;
import Utilities.Db_Connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UserController {

    private static User authenticatedUser = null;
    private static Connection dbConnection;
    static ArrayList<User> users = new ArrayList<User>();

    public UserController() {
        Db_Connection.createConnection();
        dbConnection = Db_Connection.getConnection();
    }

    //clear all the user and retrieve them all again
    private static void deleteAndRetrieveUser() {
        users.clear();
        retrieveAllUsers();
    }

    //retrieve all users
    public static ArrayList<User> retrieveAllUsers() {
        try {
            // the mysql select statement
            String query = "SELECT * FROM `user`";

            // create the mysql select Statement
            Statement stmt = dbConnection.createStatement();

            // execute the stmt
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                User user = new User();
                user.setFirstname(result.getString("firstname"));
                user.setLastname(result.getString("lastname"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setPosition(result.getString("position"));
                user.setUserId(result.getInt("id"));

                users.add(user);
            }
            Db_Connection.close(result);
            System.out.println("Successfully selected all from database");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }

    //update user
    public static void updateUser(int id, String firstname, String lastname, String email,
            String password, String position) {
        try {
            String query = "UPDATE `user` SET "
                    + "`firstname`=?,`lastname`=?,`email`=?,"
                    + "`position`=?,`password`=? WHERE id=?";

            PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
            preparedStmt.setString(1, firstname);
            preparedStmt.setString(2, lastname);
            preparedStmt.setString(3, email);
            preparedStmt.setString(4, position);
            preparedStmt.setString(5, password);
            preparedStmt.setInt(6, id);

            preparedStmt.execute();
            System.out.println("Successfully Updated!");
            Db_Connection.close(preparedStmt);
            deleteAndRetrieveUser();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void addUser(String firstname, String lastname, String email, String position,
            String password) {
        try {
            String query = "INSERT INTO `user`(`firstname`, `lastname`, `email`, `position`, `password`) VALUES (?,?,?,?,?)";

            PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
            preparedStmt.setString(1, firstname);
            preparedStmt.setString(2, lastname);
            preparedStmt.setString(3, email);
            preparedStmt.setString(4, position);
            preparedStmt.setString(5, password);

            preparedStmt.execute();
            System.out.println("Successfully added!");
            Db_Connection.close(preparedStmt);
            deleteAndRetrieveUser();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public static void deleteUser(int id) {
        try {
            String query = "DELETE FROM `user` WHERE id=?";
            PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
            preparedStmt.setInt(1, id);

            preparedStmt.execute();
            Db_Connection.close(preparedStmt);
            System.out.println("Successfully deleted!");
            deleteAndRetrieveUser();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static int addBorrower(String firstname, String lastname, String email) throws SQLException {
        int borrowerId = 0;
        try {
            String query = "INSERT INTO `borrower`(`firstname`,`lastname`,`email`,`fine`) VALUES(?,?,?,?)";
            PreparedStatement preparedStmt = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, firstname);
            preparedStmt.setString(2, lastname);
            preparedStmt.setString(3, email);
            preparedStmt.setInt(4, 0);
            preparedStmt.execute();
            ResultSet rs = preparedStmt.getGeneratedKeys();
            if (rs.next()) {
                borrowerId = rs.getInt(1);
            }
            Db_Connection.close(preparedStmt);
            System.out.println("Successfully Added!");
            Db_Connection.close(rs);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return borrowerId;
    }

    public static int deleteBorrower(int id) {
        int borrowerId = 0;
        try {
            String query = "DELETE FROM `borrower` WHERE borrowerId=?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            System.out.println("Successfully deleted!");
            Db_Connection.close(preparedStatement);
            Db_Connection.close(rs);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return borrowerId;
    }

    public static boolean userDoLogin(String email, String password) {
        boolean login = false;
        User chooseUser = null;
        //find the user email
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                chooseUser = user;
                break;
            }
        }

        if (chooseUser == null) {
            JOptionPane.showMessageDialog(null, "Email does'nt match");
            return login;
        }
        if (!chooseUser.getPassword().equals(password)) {
            JOptionPane.showMessageDialog(null, "pasword does'nt match");
            return login;
        }
        authenticatedUser = chooseUser;
        login = true;
        JOptionPane.showMessageDialog(null, "sucessfully login");
        return login;
    }

    public static boolean createUser(String firstname, String lastname, String email,
            String position, String password) {
        boolean registered = false;
        if ("".equals(firstname) || "".equals(lastname) || "".equals(position)
                || "".equals(password) || "".equals(email)) {
            JOptionPane.showMessageDialog(null, "Please supply all the fields!");
            return registered;
        }
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if (!email.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Please add a valid email!");
            return registered;
        }

        addUser(firstname, lastname, email, position, password);
        registered = true;
        JOptionPane.showMessageDialog(null, "Successfully registered");
        return registered;
    }

    public static boolean validateBorrower(String firstname, String lastname, String email) {
        boolean valid = false;
        if (firstname.equals("") || lastname.equals("") || email.equals("")) {
            JOptionPane.showMessageDialog(null, "Please provide the needed information!");
            return valid;
        }
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if (!email.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Please add a valid email!");
            return valid;
        }

        valid = true;
        return valid;
    }

    public static User getAuthenticatedUser() {
        return authenticatedUser;
    }
}
