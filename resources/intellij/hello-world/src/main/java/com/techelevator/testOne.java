package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class testOne {
    public String javaIsReal;

    public testOne() {

    }

    public static void main(String[] args) {

        String[] yo = " _  _  _  _  _  _  _  _  _ \n".split("");

        List<String>here = new ArrayList<>();

        for (int i = 0; i < yo.length; i++) {
            if(yo[i].contains("_")){
                here.add(yo[i]);
            }
        }

//        System.out.println(here);
        testOne tryBuddy = new testOne();

        char [] james = new char[]{};

        TestCode hereOne = new TestCode("Here Change");
        System.out.println(hereOne.myName);
        hereOne.setThem("Alioune");
        System.out.println(hereOne.myName);
        String KidGye = TestCode.herEOne("LIsten UP");
        System.out.println(KidGye);




        String whatAreyouOne = "Kid You are going to take Over the world They dont even understand at this point HAHAHHAHAAHAHAHAHAHAHAHAHAHAHA";

//      System.out.println(tryBuddy.iwillCreateMyOwn(whatAreyouOne));
//        for (int i = 0; i <tryBuddy.iwillCreateMyOwn(whatAreyouOne).size() ; i++) {
//            System.out.println(tryBuddy.iwillCreateMyOwn(whatAreyouOne).get(i));
//        }










        char[][] body =  {
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuff1thinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray()
        };



        tryBuddy.mutationLocation(body);
        System.out.println();


    }

   public int[] mutationLocation(char[][] body) {

       int[]result = new int[2];
       int numberOne = 0;
       int secondOne = 0;
       String addingWord = "";
       List<String> eachWord = new ArrayList<>();
       for (int k = 0; k < body.length; k++) {
           addingWord="";
           for (Character c:body[k]){
               addingWord+=c;
           }
           eachWord.add(addingWord);
       }
       int whileHere = 1;

       for (int j = 0; j < eachWord.size()-1; j++) {
           if(!eachWord.get(0).contains(eachWord.get(1))&&eachWord.get(1).contains(eachWord.get(2))){
               numberOne = eachWord.indexOf(eachWord.get(0));
           }else if(!eachWord.get(j).contains(eachWord.get(j+1))){
               numberOne = eachWord.indexOf(eachWord.get(j+1));
           }
           String[]secondSplit = eachWord.get(j+1).split("");
           String[]spliAgain = eachWord.get(j).split("");
           for (int k = 0; k <spliAgain.length ; k++) {
               if(!spliAgain[k].contains(secondSplit[k])){
                   secondOne=k;
                   j=eachWord.size();
                   break;
               }

           }
       }


       if(numberOne>=1){
        result[0]=numberOne;
        result[1]=secondOne;

        return result;
    }

       return new int[]{};
    }


    public List<String> iwillCreateMyOwn(String word){
        List<String>here = new ArrayList<>();
        String newGuy ="";
        char[] eachOne = word.toCharArray();
        for (int i = 0; i < eachOne.length; i++) {
            String oneAtTim = String.valueOf(eachOne[i]);
            newGuy+=oneAtTim;
            if(eachOne.length-i==1){
                here.add(newGuy);
            }
            if(word.substring(i,i+1).contains(" ")){
                here.add(newGuy);
                newGuy = "";
            }
        }


        return here;
    }
}






