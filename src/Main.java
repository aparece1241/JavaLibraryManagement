import Controllers.*;
import Utilities.Db_Connection;

import java.util.HashMap;

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
            System.err.printf("ERROR: %s", connectionResults.get("message"));
            System.exit(0);
        }



        new UserController();
        new BookController();
        System.out.println(connectionResults.get("message"));
        UserController.retrieveAllUsers();
        BookController.getBooks();
        //create an instance of the app
        App app = new App();

        app.login();

    }
}
