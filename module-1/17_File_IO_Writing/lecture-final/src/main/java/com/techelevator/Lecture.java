package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '\' and '/' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		System.out.print("Enter the name of a file you wish to create >>> ");  // C:\windows\system32\virus.exe
		String fileNameAsString = keyboard.nextLine();       // grab a STRING from the user

		File newFile = new File(fileNameAsString);           // turn STRING into FILE object

		// turn FILE object into FILEOUTPUTSTREAM object (which lets PrintWriter append)
		// turn FILEOUTPUTSTREAM object into PRINTWRITER, for output (appends file!)
		//   doing both in try-with-resources
//        try (FileOutputStream fos = new FileOutputStream(newFile, true); PrintWriter printWriter = new PrintWriter(fos)) {

		try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(newFile, false))) {

			printWriter.println("Hello World! Goodbye Old World!");

		} catch (IOException e) {
			System.out.println("Caught IO Exception");
		}



		System.out.println("Done! Landed Gracefully.");

	}

	public static void main2(Scanner keyboard, File newFile) {
		// Just stashing some code

		if (newFile.exists()) {
			System.out.println("Sorry, that exists already!");
		} else {

			System.out.println("Do you want to make that a file or a folder? ");
			String fileOrDir = keyboard.nextLine();

			if (fileOrDir.trim().toLowerCase().startsWith("fi")) {

				try {
					System.out.println("Before: " + newFile.length());

					newFile.createNewFile();
					System.out.println("It exists now!");

					System.out.println("After: " + newFile.length());

				} catch (IOException e) {
					System.out.println("Unable to create file -- " + e.getMessage());
				}
			} else {
				newFile.mkdir();  // creates a folder (no exceptions thrown?)
			}

		}

	}

}
