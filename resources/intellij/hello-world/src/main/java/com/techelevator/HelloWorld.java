package com.techelevator;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.*;
import java.util.Collections;


public class HelloWorld {

    public static void main(String[] args) {
//        BasicDataSource trythis = ConnectToDatabase.getconnected();
//
//        CityDOAImpl connectTopark = new CityDOAImpl(trythis);
//        connectTopark.printEver();

        BasicDataSource catDaddy = new BasicDataSource();
        catDaddy.setUrl("jdbc:postgresql://localhost:5432/UnitedStates");
        catDaddy.setUsername("postgresql");
        catDaddy.setPassword("postgresql1");
        CityDOAImpl haha = new CityDOAImpl(catDaddy);
        if(catDaddy!=null){
            System.out.println("still here");
        }
        haha.printEver();



        String man = "xxxxyyyyabklmopq";
        String lookatHer = "xyaabbbccccdefww";
        String [] cutEm = man.split("");
        String [] youKnowMe = lookatHer.split("");
        List<String>hello =new ArrayList<>();
        for (int i = 0; i < cutEm.length ; i++) {
            if(!hello.contains(cutEm[i])) {
                hello.add(cutEm[i]);
            }
        }
        for (int i = 0; i < youKnowMe.length; i++) {
            if(!hello.contains(youKnowMe[i])){
                hello.add(youKnowMe[i]);
            }
        }
        Collections.sort(hello);
        List<String>tryThis = hello;
        System.out.println(tryThis);



    }


}
