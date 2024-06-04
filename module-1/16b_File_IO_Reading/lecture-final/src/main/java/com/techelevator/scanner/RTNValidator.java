package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		printApplicationBanner();
		
		File inputFile = null;
		while (inputFile == null) {
			inputFile = getInputFileFromUser(keyboard);
		}

		System.out.println("We have a valid file! " + inputFile.getAbsolutePath());


		try (Scanner fileStreamer = new Scanner(inputFile)) {

			while (fileStreamer.hasNextLine()) {
				String oneLine = fileStreamer.nextLine();

				if (checksumIsValid(oneLine)) {
					System.out.println(oneLine + " is VALID!");
				} else {
					System.out.println(oneLine + " is NOT valid!");
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find the file specified! -- " + e.getMessage());
		}

		System.out.println("Done! Gracefully landed");
	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 2000");
		System.out.println("******************");
		System.out.println();
	}

	private static File getInputFileFromUser(Scanner keyboard) {

		System.out.print("Please enter path to input file >>> ");
		String path = keyboard.nextLine();
		

		// Creating a new File object, to represent the file that the user just typed in
		File inputFile = new File(path);


		if (inputFile.exists() == false) { // checks for the existence of a file

            System.out.println(path + " does not exist");
            return null;
		} else if (inputFile.isFile() == false) {
            System.out.println(path + " is not a file");
            return null;
		}

		return inputFile;
	}

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for (int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
