package com.techelevator.clientServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TEST {

    public static void main(String[] args) {

    String hereOne = "Hello world !";
    String chamP = alphanumeric(hereOne);
        System.out.println(chamP);

    }




    public static String  alphanumeric(String str){
        String newWord = "";
        String[] splitThem = str.split(" ");
        for(int i = 0; i<splitThem.length;i++){
            if(splitThem[i].contains("!")){
                newWord+=splitThem[i];
                break;
            }
            newWord+=" ";
            String[] newKing = splitThem[i].split("");
            for(int j = 0; j < newKing.length;j++){
                if(j!=0){
                    newWord+=newKing[j];
                }
                if(j==newKing.length-1){
                    String wordded = newKing[0];
                    newWord+=wordded+"ay";
                    break;
                }
            }

        }



        return newWord.trim();
    }

}
