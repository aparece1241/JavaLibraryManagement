package Controllers;

import Models.Book;
import Models.BorrowedBook;
import Utilities.Db_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class BookController {

    private static Connection dbConnection;
    private static ArrayList<Book> books;

    public BookController() {
        dbConnection = Db_Connection.getConnection();
    }
    //retrieve and set 

    private static void retrieveAfter() {
        books = getBooks();
    }

    //retrieve all books
    //temporary
    public static ArrayList<Book> getBooks() {
        books = new ArrayList<>();
        try {
            String query = "SELECT * FROM `book`";
            Statement stmt = dbConnection.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                Book book = new Book();
                book.setId(result.getInt("bookId"));
                book.setAuthor(result.getString("author"));
                book.setGenre(result.getString("genre"));
                book.setTitle(result.getString("title"));
                book.setYear_published(result.getDate("yearPublished"));
                book.setStock_number(result.getInt("stockNumber"));

                books.add(book);
            }
            Db_Connection.close(result);
            System.out.println("Successfully retrieved!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return books;
    }

    public static void addBook(String author, String genre, String title,
            Date yearPublished, int stockNumber) {

        try {
            String query = "INSERT INTO `book`(`title`,`author`, `yearPublished`,"
                    + "`genre`, `stockNumber`) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
            preparedStmt.setString(1, title);
            preparedStmt.setString(2, author);
            preparedStmt.setDate(3, yearPublished);
            preparedStmt.setString(4, genre);
            preparedStmt.setInt(5, stockNumber);
            preparedStmt.execute();

            Db_Connection.close(preparedStmt);
            retrieveAfter();
            System.out.println("Successfully Added Book!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void updateBook(int id, String author, String genre, String title,
            Date yearPublished, int stockNumber) {
        try {
            String query = "UPDATE `book` SET"
                    + "`title`=?,`author`=?,`yearPublished`=?,"
                    + "`genre`=?,`stockNumber`=? WHERE bookId=? ";
            PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
            preparedStmt.setString(1, title);
            preparedStmt.setString(2, author);
            preparedStmt.setDate(3, yearPublished);
            preparedStmt.setString(4, genre);
            preparedStmt.setInt(5, stockNumber);
            preparedStmt.setInt(6, id);

            preparedStmt.execute();

            System.out.println("Successfully Edited!");
            retrieveAfter();
            Db_Connection.close(preparedStmt);
        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
    }

    public static void deleteBook(int id) {
        try {
            String query = "DELETE FROM `book` WHERE bookId=?";
            PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
            preparedStmt.setInt(1, id);
            preparedStmt.execute();

            System.out.println("Successfully deleted!");
            retrieveAfter();
            Db_Connection.close(preparedStmt);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static ArrayList<BorrowedBook> getBorrowedBooks() {
        ArrayList<BorrowedBook> borrowedBooks = new ArrayList<BorrowedBook>();
        try {
            String query = "SELECT borrowedbooks.id, book.title, borrower.firstname,borrower.lastname,\n"
                    + "       borrowedbooks.dueDate,borrowedbooks.issueDate \n"
                    + "FROM borrowedbooks\n"
                    + "JOIN book ON book.bookId = borrowedbooks.bookId\n"
                    + "JOIN borrower ON borrower.borrowerId = borrowedbooks.borrowerId;";
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                BorrowedBook borrowedBook = new BorrowedBook();

                borrowedBook.setId(rs.getInt("id"));
                borrowedBook.setTitle(rs.getString("title"));
                borrowedBook.setBorrowerName(rs.getString("firstname") + " " + rs.getString("lastname"));
                borrowedBook.setDueDate(rs.getDate("dueDate"));
                borrowedBook.setIssueDate(rs.getDate("issueDate"));

                borrowedBooks.add(borrowedBook);
            }
            Db_Connection.close(rs);

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return borrowedBooks;
    }

    public static void deleteBorrowedBook(int borrowerId) {
        try {
            String query = "DELETE FROM `borrowedbooks` WHERE `borrowerId=?`";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, borrowerId);
            preparedStatement.execute();
            System.out.println("Successfully deleted!");
            Db_Connection.close(preparedStatement);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void addBorrowedBook(int bookId, int borrowerId) {
        try {
            Calendar currentCDate = Calendar.getInstance();
            Calendar dueCDate = Calendar.getInstance();
            dueCDate.add(Calendar.DATE, 7);// seven days before return
            Date currentDate = new Date(currentCDate.getTimeInMillis());
            Date dueDate = new Date(dueCDate.getTimeInMillis());
            String query = "INSERT INTO `borrowedbooks`(`returnDate`,`issueDate`,`dueDate`,`bookId`,`borrowerId`)"
                    + " VALUES(?,?,?,?,?)";
            PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
            preparedStmt.setDate(1, null);
            preparedStmt.setDate(2, currentDate);
            preparedStmt.setDate(3, dueDate);
            preparedStmt.setInt(4, bookId);
            preparedStmt.setInt(5, borrowerId);
            preparedStmt.execute();
            Db_Connection.close(preparedStmt);
            System.out.println("Suucessfully Added!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static ArrayList<Book> getArrayBook() {
        return books;
    }
    //validation

    public static boolean validateAndBookInfo(String author, String genre, String title,
            String yearPublished, String stockNumber) {
        boolean valid = false;
        if ("".equals(title) || "".equals(genre) || "".equals(author)
                || "".equals(yearPublished) || "".equals(stockNumber)) {
            JOptionPane.showConfirmDialog(null, "Plaese supply all needed information", "Failed", JOptionPane.ERROR_MESSAGE);
            return valid;
        }
        try {
            Date.valueOf(yearPublished);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid format! Date must be (yyyy-MM-dd or yyyy/MM/dd)", "Date format",
                    JOptionPane.ERROR_MESSAGE);
            return valid;
        }
        valid = true;
        return valid;
    }

}
