package com.techelevator;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;


public class ConnectToDatabase {
    private static String url = "jdbc:postgresql://localhost:5432/SocialMedia";
    private static String user ="postgres";
    private static String password ="postgres1";


   public ConnectToDatabase(){
   }

   public  BasicDataSource getconnected(){
       BasicDataSource manthisCrazy = new BasicDataSource();
       manthisCrazy.setUrl(url);
       manthisCrazy.setUsername(user);
       manthisCrazy.setPassword(password);
       return manthisCrazy;
   }

   public String wasteTime(){
       System.out.println("as you can see we are wasting time let me waste time how about more waste time");
       System.out.println("tell we how you was time");
       Scanner moretime = new Scanner(System.in);
       String userTimewas = moretime.nextLine();
       return userTimewas;
   }



}
