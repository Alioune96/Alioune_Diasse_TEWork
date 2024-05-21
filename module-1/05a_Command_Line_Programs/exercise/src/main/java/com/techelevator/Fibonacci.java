package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner helloBuddy = new Scanner(System.in);
		System.out.println("hello user, today we will be working on the fibonacci sequence! if your interested, please provide me an number and i will show you my magic! ");
		String highNumbe = helloBuddy.next();
		int numberAtWork = Integer.parseInt(highNumbe);
		int firstNumber = 0;
		int secondNumber = 1;
		int totalcurrent = 0;
		while (numberAtWork >= firstNumber) {
			System.out.print(firstNumber+ " ");
			totalcurrent = firstNumber + secondNumber;
			firstNumber= secondNumber;
			secondNumber = totalcurrent;
			if(numberAtWork<firstNumber){
				System.out.println(" See magic!!");
			}
		}


	}
}