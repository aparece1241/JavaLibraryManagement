import Controllers.*;
import Utilities.Db_Connection;
import Views.LoginView;

import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 * This is the main class that
 * serve's as the entry point of
 * our application
 */

public class Main {
    public static void main(String[] args) {
        //create connection from a database (mysql)
        HashMap<String, String> connectionResults = Db_Connection.createConnection();
       
        //check the connection
        if(connectionResults.get("error").equals("true")){
            // for dev
            JOptionPane.showMessageDialog(null,"Something went Wrong!");
            System.err.printf("ERROR: %s", connectionResults.get("message"));
            System.exit(0);
        }

        UserController userController = new UserController(); //the porpuse of this is to get the connection
        BookController bookController = new BookController(); //the porpuse of this is to get the connection
        System.out.println(connectionResults.get("message"));
        UserController.retrieveAllUsers();
        BookController.getBooks();
        LoginView login = new LoginView();
        login.setVisible(true);
    }
}
