package com.techelevator;

import java.sql.Connection;
import java.sql.SQLException;

public class HelloWorld {

    public static void main(String[] args) throws SQLException {
//CityFORTEST state = new CityFORTEST(1,"Philadelphia","PA",2000000,24.3);
//
        Connection myConnect = Dabase.getConnection();

        if(myConnect == null){
            System.out.println("haha");
        }else{
            System.out.println("We are ready to take over the world!!!!!!");
        }
    }

}
