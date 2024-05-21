package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner hell = new Scanner(System.in);
		System.out.println("please enter in a series of decimal value");
		String userInput = hell.nextLine();
		String[] numberasString = userInput.split(" ");
		for (int i = 0; i < numberasString.length; i++) {
			String thisString = numberasString[i];
			int thisNumber = Integer.parseInt(thisString);
			int quotient = thisNumber;
			String solution = "";
			while (quotient>0) {
				int remainder = quotient % 2;
				solution = remainder + solution;
				quotient /= 2;
			}
			System.out.println(thisString + "binary is " + solution);
		}
	}
}