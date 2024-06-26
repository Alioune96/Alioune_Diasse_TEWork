package com.techelevator;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.io.FileReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Collections;


public class HelloWorld {

    public static void main(String[] alioune) throws SQLException {
HelloWorld man = new HelloWorld();
        System.out.println(man.spinWords("Hey fellow warriors"));




    }

    public String spinWords(String sentence) {
        String lookatThat = "";
        List<String>hahaMan = new ArrayList<>();
        List<String> holdThis = new ArrayList<>();
        String addItBuddy = "";
        int countAmount = 0;
        String []breakdown = sentence.split(" ");
        if(breakdown.length==1){
            String [] eachOne = breakdown[0].split("");
            if(eachOne.length<5){
                return sentence;
            }
            for(int i =0; i<eachOne.length;i++){
                holdThis.add(eachOne[i]);
            }
            Collections.reverse(holdThis);
            for(int i =0; i <holdThis.size();i++){
                addItBuddy+=holdThis.get(i);
            }
            return addItBuddy;
        }
        for(int i = 0; i<breakdown.length;i++){
            String[] letGo = breakdown[i].split("");
            if(letGo.length<5){
                addItBuddy+=breakdown[i]+" ";
            }else{
                lookatThat="";
                for(int k =0; k<letGo.length;k++){
                    hahaMan.add(letGo[k]);
                }
                Collections.reverse(hahaMan);
                for(int j=0; j<hahaMan.size();j++){

                    lookatThat+=hahaMan.get(j);
                }
                addItBuddy+=lookatThat+" ";

                hahaMan=Collections.emptyList();
                hahaMan = new ArrayList<>();


            }

        }


        return addItBuddy.trim();
    }
    }
