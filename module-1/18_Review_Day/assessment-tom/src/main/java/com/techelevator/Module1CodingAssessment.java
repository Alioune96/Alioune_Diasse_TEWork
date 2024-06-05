package com.techelevator;

import java.util.List;

// CONTROLLER layer
public class Module1CodingAssessment {

	// Very small method! Create objects, make them do all the work! You just shuttle data to them (via the objects' public methods' inputs & returns)
	public static void main(String[] args) {
		// Create "helper" objects:
		MovieRentalListPrinter mrlp = new MovieRentalListPrinter(); // Minion for printing things
		MovieRentalListCreator mrlc = new MovieRentalListCreator(); // Minion for creating things


		// Use them do to your bidding: SAMPLE DATA
		List<MovieRental> sampleDataList = mrlc.createListFromSampleData();                // Get data from one minion (its return value)
		mrlp.printMovieList(sampleDataList);                                              // pass said data to other minion (its input parameter)
		mrlp.writeMovieListToFile(sampleDataList, "sample-data-output.txt");  // use same minion to write sample data to file
		mrlp.printScreenDivider();                                                       // use this one object to do alllll UI tasks


		// Use them again: FILE DATA
		List<MovieRental> fileDataList = mrlc.createListFromFile("data-files/MovieInput.csv"); // Get different data from one minion
		mrlp.printMovieList(fileDataList);                                                              // pass said data to other minion
		mrlp.writeMovieListToFile(fileDataList, "file-data-output.txt");                     // Same pattern as Sample Data, but with File Data
		mrlp.printScreenDivider();

		mrlp.printFinalMessage(); // keeps all UI stuff in one place
	}
}
