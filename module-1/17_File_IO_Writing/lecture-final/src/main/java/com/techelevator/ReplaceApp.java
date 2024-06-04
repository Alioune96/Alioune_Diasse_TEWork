package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplaceApp {

    public static void main(String[] args) {
        String inputFileName = "TE.txt";
        String outputFileName = "TEnew.txt";


        File inputFileObject = new File(inputFileName);   // STRING -> FILE
        File outputFileObject = new File(outputFileName); // STRING -> FILE


        try (Scanner inputStreamer = new Scanner(inputFileObject);
             PrintWriter printWriter = new PrintWriter(outputFileObject)) {


//            Scanner inputStreamer = new Scanner(inputFileObject);  // FILE -> SCANNER (streaming in)
//            PrintWriter printWriter = new PrintWriter(outputFileObject); // FILE -> PRINTWRITER (writing out)

            int lineCounter = 1;
            while (inputStreamer.hasNextLine()) {           // While I CAN stream
                String thisLine = inputStreamer.nextLine(); // I WILL stream

                if (lineCounter > 25) {
                    String processedLine = thisLine.replace("Elevator", "Escalator").replace("elevator", "escalator").trim(); // Process!
                    if (processedLine.length() > 0) {
                        printWriter.println(processedLine);
                    }
                } else {
                    printWriter.println(thisLine);
                }

                lineCounter++;
            }

        } catch (Exception e) {
            System.out.println("Tom is lazy");
        }



    }

}
