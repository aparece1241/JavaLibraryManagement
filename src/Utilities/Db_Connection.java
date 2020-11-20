package Utilities;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Db_Connection {
    static Connection dbConnection = null;

    private static HashMap<String, String> connection(String url, String user, String password)
    {
        //for error messages and data
        HashMap<String, String> connectionResults = new HashMap<String, String>();

        try {
            Properties info = new Properties();
            info.put("user", user);
            info.put("password", password);

            dbConnection = DriverManager.getConnection(url, info);


            if (dbConnection != null) {
                connectionResults.put("message", "Connected Successfully!");
                connectionResults.put("error", "false");
            }

        } catch (SQLException ex) {
            connectionResults.put("message", ex.getMessage());
            connectionResults.put("error", "true");
        }
        return connectionResults;
    }

    public static Connection getConnection() {
        return dbConnection;
    }

    public static HashMap<String, String> createConnection()
    {
        return connection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12376456",
                "sql12376456",
                "psywcxIWHY");
    }
    public static HashMap<String, String> createConnection(String url, String user, String password)
    {
        return connection(url, user, password);
    }

    public static void destroy(){
        if(dbConnection !=null){
            try{
                dbConnection.close();
            }
            catch(Exception e){}
        }
    }
    public static void close(ResultSet rs){

        if(rs !=null){
            try{
                rs.close();
            }
            catch(Exception e){}

        }
    }

    public static void close(java.sql.Statement stmt){
        if(stmt !=null){
            try{
                stmt.close();
            }
            catch(Exception e){}
        }
    }
}


//            String url = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12376456";
//            String urlv2 = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12376456" +
//                    "?useUnicode=true&" +
//                    "useJDBCCompliantTimezoneShift=true&" +
//                    "useLegacyDatetimeCode=false&" +
//                    "serverTimezone=UTC";



