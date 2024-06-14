package com.techelevator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dabase {
    private static String url = "jdbc:AliouneServer://localhost:5432/UnitedStates";
    private static String user ="postgres";
    private static String password ="postgres1";


   public Dabase(){

   }

   public static Connection getConnection() throws SQLException{
       Connection connection =null;
       connection = DriverManager.getConnection(url,user,password);

       return connection;
   }
}
