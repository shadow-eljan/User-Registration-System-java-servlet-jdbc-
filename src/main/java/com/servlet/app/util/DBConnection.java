package com.servlet.app.util;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

        static Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
         static String url = dotenv.get("DB_URL");
         static String user = dotenv.get("DB_USER");
        static  String pass = dotenv.get("DB_PASS");

         static Connection connection = null;
         public static Connection JDBC(){
             try{
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 connection = DriverManager.getConnection(url, user, pass);
                 System.out.println("Database connected successfully!");
             } catch (ClassNotFoundException e) {
                 throw new RuntimeException(e);
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }
             return connection;
         }
}
