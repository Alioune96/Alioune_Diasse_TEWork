package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class Module1CodingAssessment {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		MovieRental firstMovie = new MovieRental("GodFather", "DVD", true);
		MovieRental secondMovie = new MovieRental("The Room", "VHS", false);
		MovieRental thirdMovie = new MovieRental("Fast and Furious", "Blu-Ray",false);
		MovieRental fourMovie = new MovieRental("1984", "Blu-Ray", true);
		MovieRental fiveMovie = new MovieRental("Soylent Green","DVD", true);

//		List<MovieRental>alltheMoviesToWatch = new ArrayList<>();
//		alltheMoviesToWatch.add(firstMovie);
//		alltheMoviesToWatch.add(secondMovie);
//		alltheMoviesToWatch.add(thirdMovie);
//		alltheMoviesToWatch.add(fourMovie);
//		alltheMoviesToWatch.add(fiveMovie);
////		printMovieList(alltheMoviesToWatch);
////		forPrintOnly(alltheMoviesToWatch);
// MovieRental justforFun = new MovieRental("naruto","DVD", false);
// justforFun.setFormat("Blu-Ray");
// justforFun.setPremiumMovie(true);
//		System.out.println( justforFun.getRentalPrice());
		Integer hi = 1;
		Set<String> james = new HashSet<>();
		james.add("hi");
		james.add("hi");
		james.add("alioune");
		james.stream().sorted();

		for (String gg: james){
			System.out.println(gg);
		}


	}

	public static void printMovieList(List<MovieRental> printBaby){
		for (MovieRental x: printBaby){
			System.out.println(x.toString());
		}
	}

	public static void forPrintOnly(List<MovieRental>lalalal){
			boolean holdup = true;
		while(holdup)
        try {
			Scanner cheese = new Scanner(System.in);
			System.out.println("please tell me what while name should be");
			String okayed = cheese.next();
			File manThatSup = new File(okayed);
            PrintWriter okayGotit = new PrintWriter(manThatSup);
			for (int i = 0; i < lalalal.size(); i++) {
				String forlala= lalalal.get(i).toString();
				okayGotit.println(forlala);
			}
			okayGotit.flush();
			okayGotit.close();

			holdup=false;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
