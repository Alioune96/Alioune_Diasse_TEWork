package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataProcessing {

    public static void main(String[] args) {
        String path = "candy-data.csv";
        File candyFile = new File(path);   // String -> File Object

        // File Object -> Scanner Object
        try (Scanner inputStream = new Scanner(candyFile); PrintWriter pw = new PrintWriter("candy.sql")) {

            int lineCounter = 0;
            while (inputStream.hasNextLine()) {

                String nextLine = inputStream.nextLine();
                lineCounter++;

                if (lineCounter != 1) {

                    String[] candyPieces = nextLine.split(",");
                    candyPieces[0] = candyPieces[0].replace("'", "''");

                    pw.print("INSERT INTO candy VALUES (DEFAULT,");

                    for (int i = 0; i < candyPieces.length; i++) {

                        if (i == 0) {
                            pw.print("'");
                        }

                        if (i > 0 && i < 10) {
                            if (candyPieces[i].equals("0")) {
                                pw.print("false");
                            } else {
                                pw.print("true");
                            }
                        } else {
                            pw.print(candyPieces[i]);
                        }

                        if (i == 0) {
                            pw.print("'");
                        }

                        if (i != candyPieces.length - 1) {
                            pw.print(",");
                        }
                    }

                    pw.println(");");
                }

            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("You hardcoded the path, and it STILL didn't work.");
        }

        System.out.println("\n\nCompleted successfully!");
    }
}
