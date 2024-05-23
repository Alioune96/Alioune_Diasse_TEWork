package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		Scanner keyB = new Scanner(System.in);
		System.out.println("type in a sentence");
		String sentence = keyB.nextLine();
		String mostCommonLetter = null;
		sentence=sentence.toUpperCase();
		Map<String,Integer> repoMost = new HashMap<String,Integer>();
		for(int i = 0; i <sentence.length();i++){
		String letter = sentence.substring(i,i+1);
		int highnumber = 0;
		String time =null;
		if(!repoMost.containsKey(letter)){
			repoMost.put(letter,1);
		}else{
			Integer timeseen = repoMost.get(letter);
			timeseen++;
			repoMost.put(letter,timeseen);
			if (timeseen>highnumber){
				highnumber = timeseen;
				time = letter;
			}
		}

		}
		System.out.println(repoMost);





//		System.out.println("####################");
//		System.out.println("        MAPS");
//		System.out.println("####################");
		Set<String> people = new HashSet<String>();
		people.add("james");
		people.add("laura");
		people.add("great");
		List<String> ordercuz = new ArrayList<String>();
		for (String peo : people){
			System.out.println(peo);
			ordercuz.add(peo);
		}
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(5);
		numbers.add(5);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(7);
		Set<Integer> noCopy = new HashSet<Integer>(numbers);

		System.out.println(noCopy);
		Map<Integer, String> zip2City = new HashMap<Integer, String>();
		zip2City.put(43017, "Dublin");
		zip2City.put(19144, "philadelphia");
		zip2City.put(43081, "Westerville");
		zip2City.put(19140, "germantown");
		System.out.println("tom live here " + zip2City.get(19144));
		Set<Integer> validKey = zip2City.keySet();
		for (Integer zipcode: validKey){
			System.out.println(zipcode);
			String Holder = zip2City.get(zipcode);
			System.out.println(Holder);
		}


	}

}
