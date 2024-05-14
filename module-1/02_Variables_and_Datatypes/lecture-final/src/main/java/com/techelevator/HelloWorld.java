package com.techelevator;


public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World");

        int x = 2+3;
        x = x + 5;

        System.out.println("Our variable x is " + x);


        long maxInt;
        maxInt = 1000000000 * 3L;
        System.out.println("Max Int: " + maxInt);


        String name = "Christopher";
        System.out.println(name);

        //I need to figure this out later


        //JIRA ticket 1949

      //  final int INTEREST_RATE =
       // System.out.println(INTEREST_RATE);

        double value = 3.14;
        double value2 = 3.1;
        double value3 = 5.1;
        int intValue = (int)value;
        System.out.println(intValue);

        value = 3.14;
        System.out.println(value);

        value = value + .14;
    }
}
