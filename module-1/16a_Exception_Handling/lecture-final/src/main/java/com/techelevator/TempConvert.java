package com.techelevator;

import java.util.Scanner;

public class TempConvert {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a temperature: ");
            String tempAsString = keyboard.nextLine();

            try {
                int temp = Integer.parseInt(tempAsString);

                System.out.println(temp + " in Celsius is " + (temp * 1.8 + 32) + " in Fahrenheit");
                System.out.println(temp + " in Fahrenheit is " + ((temp - 32) / 1.8) + " in Celsius");
                break;
            } catch (NullPointerException e) {

            } catch (NumberFormatException e) {
                System.out.println("Number format exception!");
                System.out.println("I'm gonna throw my own error!");

            } catch (Exception e) {

                System.out.println("That's not a number!");
            }
        }

    }

}
