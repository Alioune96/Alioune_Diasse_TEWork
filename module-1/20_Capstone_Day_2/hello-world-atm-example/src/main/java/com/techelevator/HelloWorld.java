package com.techelevator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HelloWorld {

    public static void main(String[] args) {

        System.out.println("Hello!");
        System.out.println("Today is " + LocalDate.now());
        System.out.println("The current time is " + LocalTime.now());

        String path = "src/main/resources/TellerInput.csv";

        ATMCreator atmCreator = new ATMCreator();
        List<AutomatedTellerMachine> atms = atmCreator.createATMsFromFile(path);

        double totalBalance = 0.0;
        for (AutomatedTellerMachine atm : atms) {
            totalBalance += atm.getBalance();
        }

        System.out.println("Total balance of all ATMs is: $" + totalBalance);


    }

}
