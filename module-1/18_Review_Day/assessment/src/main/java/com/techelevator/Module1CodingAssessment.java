package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieRental firstOne = new MovieRental("StarWar","Blu-ray", true);
		MovieRental secondOne = new MovieRental("Naruto","DVD", false);
		MovieRental thirdOne = new MovieRental("Justice League","Blu-ray", true);

		List<MovieRental>allMovies = new ArrayList<>();
		allMovies.add(firstOne);
		allMovies.add(secondOne);
		allMovies.add(thirdOne);
		printMovieList(allMovies);



	}

	public static void printMovieList(List<MovieRental>takerHer){
		for (int i = 0; i < takerHer.size() ; i++) {
			takerHer.get(i).toString();
		}

	}

}
