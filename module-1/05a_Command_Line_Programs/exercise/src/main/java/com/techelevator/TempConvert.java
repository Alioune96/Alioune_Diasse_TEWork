package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner holder = new Scanner(System.in);
		System.out.println("hello user, please provide me with your name");
		String name = holder.next();
		System.out.println("Wonderful! "+name+ " please provide us an value you would like to convert");
		String numBer= holder.next();
		System.out.println("and would you like to change it to either Celsius:(c) or Fahrenheit:(F), Please only the letter");
		String letter = holder.next();
		if(letter.equals("c")||letter.equals("C")){
			int gretterE= Integer.parseInt(numBer);
			double namme = (gretterE*1.8)+(double)(32);
			int endResult = (int)(namme);
			System.out.println(numBer + "C is equal to " + endResult +" F");
		}
		if(letter.equals("f")||letter.equals("F")){
			//temperatureCelsius = (temperatureFahrenheit - 32) / 1.8
			int tacata= Integer.parseInt(numBer);
			double namme =(double)(tacata-32) / 1.8;
			int storeEnd = (int)(namme);
			System.out.println(numBer + "f is equal to "+storeEnd +"C");
		}

	}

}
