package com.techelevator;

import java.util.Scanner;


// VIEW  (talks to the end user)
public class UI {

    private Scanner keyboard = new Scanner(System.in);

    public int promptUser(String property) {
        while (true) {
            System.out.print("Enter number of " + property + " >>> ");
            String propertyAsString = keyboard.nextLine();

            try {
                int value = Integer.parseInt(propertyAsString);

                if (value > 0) {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    public void displayFinalCost(int cost) {
        System.out.println("Your final cost is: $" + cost);
    }


}
