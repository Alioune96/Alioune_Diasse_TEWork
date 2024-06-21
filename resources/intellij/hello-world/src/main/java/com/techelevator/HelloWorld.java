package com.techelevator;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Collections;


public class HelloWorld {

    public static void main(String[] alioune) throws SQLException {



        List<Integer>myDOg = new ArrayList<>();
        myDOg.add(0);
        myDOg.add(0);
        myDOg.add(0);
        myDOg.add(1);
       Collections.reverse(myDOg);
//        System.out.println(myDOg);
        double asdas = myDOg.get(1);
//        System.out.println(asdas);
        ConnectToDatabase asdasd = new ConnectToDatabase();
        ConnectToDatabase asdasdas;
        ConnectToDatabase kke = new ConnectToDatabase();


//        BasicDataSource trythis = ConnectToDatabase.getconnected();
//
//        CityDOAImpl connectTopark = new CityDOAImpl(trythis);
//        connectTopark.printEver();
//        BasicDataSource getConnected = ConnectToDatabase.getconnected();
//        SocialMediaimpl myTime = new SocialMediaimpl(getConnected);
//        if(myTime!=null){
//            System.out.println("We are updated");
//        }
//
////        int total  = myTime.insert("alioune","Diasse","@aliounediasse",27,"145 W. Penn Street");
//        int change = myTime.update("ouma","diasse","@oumaTester",27,"newyork", 3);
//        System.out.println(change);

//
//        BasicDataSource catDaddy = new BasicDataSource();
//        catDaddy.setUrl("jdbc:postgresql://localhost:5432/UnitedStates");
//        catDaddy.setUsername("postgres");
//        catDaddy.setPassword("postgres1");
//        CityDOAImpl haha = new CityDOAImpl(catDaddy);
//        if(catDaddy!=null){
//            System.out.println("still here");
//        }
//        haha.printOf();
//
//String dateNow = "19000127";
//dateNow.
//        LocalDate thisKid = LocalDate.parse("19900127", haha);
//        System.out.println(thisKid);


//        String man = "xxxxyyyyabklmopq";
//        String lookatHer = "xyaabbbccccdefww";
//        String [] cutEm = man.split("");
//        String [] youKnowMe = lookatHer.split("");
//        List<String>hello =new ArrayList<>();
//        for (int i = 0; i < cutEm.length ; i++) {
//            if(!hello.contains(cutEm[i])) {
//                hello.add(cutEm[i]);
//            }
//        }
//        for (int i = 0; i < youKnowMe.length; i++) {
//            if(!hello.contains(youKnowMe[i])){
//                hello.add(youKnowMe[i]);
//            }
//        }
//        Collections.sort(hello);
//        List<String>tryThis = hello;
//        System.out.println(tryThis);
}
    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int moneyTeam = 0;
        List<Integer>biValues = new ArrayList();
        biValues.add(1);
        int whatYourWorth = binary.size();
        int n =1;
        while(n<whatYourWorth){
            int countAmount = (int) Math.pow(2,n);
            biValues.add(countAmount);
            n++;
        }
        List<Integer>realBiValue = biValues;
        for(int i =0; i<binary.size();i++){
            if(binary.get(i)==1){
                moneyTeam+=realBiValue.get(i);
            }
        }




        return moneyTeam;
    }

}
