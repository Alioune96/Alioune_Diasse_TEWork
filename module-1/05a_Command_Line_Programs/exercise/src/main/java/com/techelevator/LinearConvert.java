package com.techelevator;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner hello =new Scanner(System.in);
		System.out.println("hello User please put number ");
		String hh= hello.nextLine();

		System.out.println("great and would that be meters or feet");
		String unit=hello.nextLine();

		if(unit.equals("f") || unit.equals("F")){
			int gg = Integer.parseInt(hh);
			int resulTere =(int)(gg*0.304);

			System.out.println("the result of this "+unit+" is "+resulTere);

			System.exit(0);

		}
		else if(unit.equals("m")||unit.equals("M")){
			int gg = Integer.parseInt(hh);
			int blue =(int)(gg*3.2808399);

			System.out.println("the result of this "+unit+" is "+blue);

			System.exit(0);
		}
System.exit(0);



	}

}
