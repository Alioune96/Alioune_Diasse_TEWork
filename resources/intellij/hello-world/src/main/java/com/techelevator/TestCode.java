package com.techelevator;

public class TestCode {

    public static void main(String[] args) {
        String firstHalf = "10.0.0.10";
        String secondHalf = "10.0.1.0";

        System.out.println( ipsBetween(firstHalf,secondHalf));
    }





        public static long ipsBetween(String start, String end) {
            long returnType= 0;
            String replacedOne = start.replace("."," ").trim();
            String [] splitOne = replacedOne.split(" ");
            String replaceTwo = end.replace("."," ").trim();
            String [] splitTwo = replaceTwo.split(" ");
            for(int i = 0;i<splitOne.length;i++){
                if(i==2&&!splitOne[i].contains(splitTwo[i])){
                    int parseOne = Integer.parseInt(splitOne[i]);
                    int parseTwo = Integer.parseInt(splitTwo[i]);
                    if(parseTwo>parseOne){
                        while(parseTwo>parseOne){
                            returnType+=255;
                            parseOne+=1;
                        }
                    }
                }

                if(i==3||!splitOne[i].contains(splitTwo[i])){
                    int parseOne = Integer.parseInt(splitOne[i]);
                    int parseTwo = Integer.parseInt(splitTwo[i]);
                    if(parseTwo> parseOne){
                        while(parseTwo>parseOne){
                            returnType+=1;
                            parseOne+=1;

                        }
                    }else if (parseOne > parseTwo){
                        while(parseOne>parseTwo){
                            returnType-=1;
                            parseTwo+=1;
                        }
                    }
                }
            }


            return returnType;
        }
    }


