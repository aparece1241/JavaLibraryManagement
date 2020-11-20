package Controllers;

import Models.Book;
import Utilities.Db_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

public class BookController {
    private static Connection dbConnection;
    private static ArrayList<Book> books = new ArrayList<Book>();

    public BookController() {
        dbConnection = Db_Connection.getConnection();
    }

    //retrieve all books
    //temporary
    public static ArrayList<Book> getBooks() {
        try {
            String query = "SELECT * FROM `book`";
            Statement stmt = dbConnection.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()) {
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
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return books;
    }
    public static void addBook(String author, String genre, String title,
                               Date yearPublished, int stockNumber) {

        try{
            String query = "INSERT INTO `book`(`title`,`author`, `yearPublished`," +
                    "`genre`, `stockNumber`) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
            preparedStmt.setString(1, title);
            preparedStmt.setString(2, author);
            preparedStmt.setDate(3,  yearPublished);
            preparedStmt.setString(4, genre);
            preparedStmt.setInt(5, stockNumber);
            preparedStmt.execute();

            Db_Connection.close(preparedStmt);
            System.out.println("Successfully Added Book!");
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    public static void updateBook(int id, String author, String genre, String title,
                                  Date yearPublished, int stockNumber) {
        try{
            String query = "UPDATE `book` SET" +
                    "`title`=?,`author`=?,`yearPublished`=?," +
                    "`genre`=?,`stockNumber`=? WHERE bookId=? ";
            PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
            preparedStmt.setString(1, title);
            preparedStmt.setString(2, author);
            preparedStmt.setDate(3,  yearPublished);
            preparedStmt.setString(4, genre);
            preparedStmt.setInt(5, stockNumber);
            preparedStmt.setInt(6, id);

            preparedStmt.execute();

            System.out.println("Successfully Edited!");
            Db_Connection.close(preparedStmt);
        }catch (Exception ex) {

            System.err.println(ex.getMessage());
        }
    }
    public static void deleteBook(int id){
        try {
            String query = "DELETE FROM `book` WHERE bookId=?";
            PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
            preparedStmt.setInt(1,id);
            preparedStmt.execute();

            System.out.println("Successfully deleted!");
            Db_Connection.close(preparedStmt);
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}

