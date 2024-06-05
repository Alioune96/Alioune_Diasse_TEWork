package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

// VIEW layer
public class MovieRentalListPrinter {

    public void printScreenDivider() {
        System.out.println("=====================================================");
    }

    public void printFinalMessage() {
        System.out.println("Done!");
    }

    public void printMovieList(List<MovieRental> incomingList) {

        for (MovieRental movie : incomingList) {
            System.out.println(movie.toString());
        }

    }

    public void writeMovieListToFile(List<MovieRental> incomingList, String pathToTheFile) {
        // STRING to FILE object
        File outputFile = new File(pathToTheFile);

        try (PrintWriter pw = new PrintWriter(outputFile)) {

            for (MovieRental movie : incomingList) {
                pw.println(movie.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Could not write to file at " + pathToTheFile);
        }
    }
}
