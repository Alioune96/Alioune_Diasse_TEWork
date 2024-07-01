package com.techelevator.Alioune.Package;

public class Main {


    public static void main(String[] args) {
        WebCall hello = new WebCall();
        for (int i = 0; i <hello.forDisplay().length ; i++) {
            System.out.println(hello.forDisplay()[i].getDescription());
        }
    }
}
