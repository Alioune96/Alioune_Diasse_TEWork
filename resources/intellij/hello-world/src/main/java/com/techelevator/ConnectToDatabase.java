package com.techelevator;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;


public class ConnectToDatabase {
    private static String url = "jdbc:postgresql://localhost:5432/SocialMedia";
    private static String user ="postgres";
    private static String password ="postgres1";


   public ConnectToDatabase(){
   }

   public static BasicDataSource getconnected(){
       BasicDataSource manthisCrazy = new BasicDataSource();
       manthisCrazy.setUrl(url);
       manthisCrazy.setUsername(user);
       manthisCrazy.setPassword(password);
       return manthisCrazy;
   }



}
