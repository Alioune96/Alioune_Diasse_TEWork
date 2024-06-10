package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// MODEL layer
public class MovieRentalListCreator {

    public List<MovieRental> createListFromSampleData() {
        // SAMPLE DATA
        MovieRental pulpFiction = new MovieRental("Pulp Fiction", "VHS", true);
        MovieRental pussInBoots2 = new MovieRental("Puss In Boots 2", "BluRay", true);
        MovieRental oldBoy = new MovieRental("Old Boy", "DVD", false);

        List<MovieRental> sampleDataList = new ArrayList<MovieRental>(); // create an empty List
        sampleDataList.add(pulpFiction);
        sampleDataList.add(pussInBoots2);
        sampleDataList.add(oldBoy);

        return sampleDataList;
    }

    public List<MovieRental> createListFromFile(String pathToFile) {
        List<MovieRental> output = new ArrayList<>();

        File inputFile = new File(pathToFile);

        try (Scanner inputStream = new Scanner(inputFile)) {

            while (inputStream.hasNextLine()) {
                // Godfather,DVD,true
                String movieData = inputStream.nextLine();

                String[] pieces = movieData.split(",");

                String title = pieces[0]; // Godfather
                String format = pieces[1]; // DVD
                boolean premium = Boolean.parseBoolean(pieces[2]);  // "true" -> true

                MovieRental thisMovie = new MovieRental(title, format, premium);

                output.add(thisMovie);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Couldn't open the file at: " + pathToFile);
        }

        return output;
    }
}
