package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner holder = new Scanner(System.in);
		System.out.println("hello user, please provide me with your name");
		String name = holder.next();
		System.out.println("Wonderful! "+name+ " we see that you want to convert an your number to either Degree(d) or Fahrethei(f)");
		System.out.println("First thing, please provide us with an number to change");
		String numBer= holder.next();
		System.out.println("and would you like to change it either Degree:(D) or Fahrenheit:(F), Please only the letter");
		String letter = holder.nextLine();
		if(letter.equals("D")||letter.equals("d")){
			int gretterE= Integer.parseInt(numBer);

		}

	}

}
