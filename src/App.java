
import java.util.ArrayList;

import Models.Book;
import Views.LoginView;

import java.util.Scanner;
import Views.Register;

/**
 * This project is a library management
 */
public class App {

    // scan inputs
    Scanner in = new Scanner(System.in);
    LoginView login = new LoginView();
    
   public void login() {
        login.setVisible(true);

    }

}

//    // scan inputs
//    Scanner in = new Scanner(System.in);
//
//    public void menu() {
//        System.out.print("Library Management System\n" +
//                "1- Add Book\n" +
//                "2- Search Book\n" +
//                "3- View all Books\n" +
//                "4- Delete Book\n" +
//                "5- Edit Book\n");
//    }
//
//    public String choice() {
//        return in.nextLine();
//    }
//
//    public void Login() {
//
//    }
//
//    public void addBook(){
//    }
//    
//    public void deleteBook(){
//
//    }
//
//    public void modifyBooks(){}
//
//    public void viewBooks(){}
//
//    public void searchByBookName(){}
//
//    public void payment(){}
//

