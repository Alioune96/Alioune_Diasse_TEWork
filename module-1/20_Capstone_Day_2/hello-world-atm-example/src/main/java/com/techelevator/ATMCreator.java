package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMCreator {

    public List<AutomatedTellerMachine> createATMsFromFile(String pathToInputFile) {
        List<AutomatedTellerMachine> atms = new ArrayList<>();

        File inputFileObject = new File(pathToInputFile); // String -> File

        try (Scanner inputStreamer = new Scanner(inputFileObject)) { // File -> Scanner

            while (inputStreamer.hasNextLine()) {
                String line = inputStreamer.nextLine();

                String[] pieces = line.split(","); // CSV file

                String mf = pieces[0];
                double deposits = Double.parseDouble(pieces[1]);
                double withdrawals = Double.parseDouble(pieces[2]);

                AutomatedTellerMachine newATMObject = new AutomatedTellerMachine(mf, deposits, withdrawals);

                atms.add(newATMObject);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't read file from specified path: " + pathToInputFile);
        }

        return atms;
    }
}
