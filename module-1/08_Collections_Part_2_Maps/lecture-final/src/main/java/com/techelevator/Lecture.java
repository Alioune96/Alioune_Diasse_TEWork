package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in); // connect to keyboard

		System.out.println("Type in a sentence: ");
		String sentence = keyboard.nextLine();
		String mostCommonLetter = null;

		sentence = sentence.trim().toUpperCase().replace(" ", "");

		Map<String, Integer> letterCounter = new HashMap<String, Integer>();

		int highestNumberOfTimesSeen = 0;


		for (int i = 0; i < sentence.length(); i++) {
			String letter = sentence.substring(i, i+1);

			// Have I seen this letter before?
			if (!letterCounter.containsKey(letter)) {  // Nope!
				letterCounter.put(letter, 1);          // first time! so counter is set to 1
			} else {  // Yup!
				Integer timesSeen = letterCounter.get(letter); // How many times?
				timesSeen++;                                   // well, here's one more
				letterCounter.put(letter, timesSeen);          // out with the old, in with the new

				if (timesSeen > highestNumberOfTimesSeen) {
					highestNumberOfTimesSeen = timesSeen;
					mostCommonLetter = letter;
				}


			}
		}


		System.out.println(letterCounter);



		System.out.println("The letter that appeared the most times in your sentence was:");
		System.out.println(mostCommonLetter);

		System.exit(0);









		System.out.println("####################");
		System.out.println("        SETS");
		System.out.println("####################");
		System.out.println();

		// DECLARATION        INSTANTIATION      INITIALIZATION
		Set<String> people = new HashSet<String>(); // empty set
		System.out.println("Set size: " + people.size());

		boolean result;

		result = people.add("Tom");
		System.out.println("Adding Tom: " + result);
		System.out.println("Set size: " + people.size());

		result = people.add("Steve");
		System.out.println("Adding Steve: " + result);
		System.out.println("Set size: " + people.size());

		result = people.add("Tom");
		System.out.println("Adding Tom: " + result);
		System.out.println("Set size: " + people.size());

		result = people.add("Amanda");
		System.out.println("Adding Amanda: " + result);
		System.out.println("Set size: " + people.size());

		result = people.add("Laura");
		System.out.println("Adding Laura: " + result);
		System.out.println("Set size: " + people.size());

		result = people.add("Heather");
		System.out.println("Adding Heather: " + result);
		System.out.println("Set size: " + people.size());

		for (String person : people) {
			System.out.println(person);
		}

		List<Integer> numbers = new ArrayList<>();
		numbers.add(0);
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(5);
		numbers.add(8);
		numbers.add(13);
		numbers.add(21);
		numbers.add(0);
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(5);
		numbers.add(8);
		numbers.add(13);
		numbers.add(21);

		System.out.println(numbers);

		System.out.println("Trying this... " + numbers.hashCode());

		Set<Integer> noDupes = new HashSet<>(numbers);

		System.out.println(noDupes);





		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		Map<Integer, String> zip2city = new HashMap<Integer, String>();  // empty Map

		zip2city.put(43017, "Dublin");
		zip2city.put(15222, "Strip District");
		zip2city.put(43035, "Lewis Center");
		zip2city.put(43081, "Westerville");
		zip2city.put(43065, "Powell");


		zip2city.remove(15222);

		Set<Integer> validKeys = zip2city.keySet();

		for (int zipcode : validKeys) { // Auto-unboxing
			System.out.println(zipcode + " is in the map!");

			String neighborhood = zip2city.get(zipcode);
			System.out.println("It is the zipcode for: " + neighborhood);
			System.out.println();
		}

		Integer x = 5;
		x++;

		System.out.println(x);




		String thisTown = "Default City";

		if (zip2city.containsKey(90210)) {
			thisTown = zip2city.get(90210);
		}

		System.out.println(thisTown.toUpperCase() + " is my favorite!");




	}

}
