package com.techelevator;

public class Scratch {

    static int myClassVar;

    public static void main(String[] args) {

        boolean condition1 = true;
        boolean condition2 = false;
        boolean condition3 = true;

        System.out.println(condition1 && (condition2 || condition3));




        /*
        {
           String spiderman = "Tobey";

        }
        {
            String spiderman = "Andrew";
        }
        {
            String spiderman = "Tom";
        }



        String spiderman = getSpiderman();
        System.out.println(spiderman);


        int result = getWholeNumber(5);

        sayHello("Chris");
        sayHello("Bob");
        sayHello("Joe");



        int age = 16;
        boolean hasPermit = true;

        if(age >= 16) {
            //drive
        }
        else if(age >= 15 && hasPermit) {
            //drive
        }
        else {
            // don't drive
        }


        if(age >= 15) {

            if(age >= 16 || hasPermit) {
                //drive;
            }

        }

*/

    }

    public static String saySomethingAppropriate(){
        boolean arriving = true;

        if(arriving) {
            return "Hello";
        } else {
            return "Goodbye";
        }

    }

    // TERNARY STATEMENT:
    public static String saySomethingAppropriate2(){
        boolean arriving = true;

        return arriving ? "Hello" : "Goodbye";

    }



    public static int getWholeNumber(double num){
        return (int) num;
    }

    public static void sayHello(String name){
        System.out.println("Hello " + name + "!");
    }

    //  String - the datatype immediately before the method name
    //           represents the type of data being output
    //  parameters  - Anything inside the parentheses would be considered input to this code block
    public static String getSpiderman(){

        String spiderman = "Tobey";
        return spiderman;
    }

    public static void setMyClassVar(int newValue){
        myClassVar = newValue;
    }

    public static int add(int num1, int num2){
        return num1 + num2;
    }



}
