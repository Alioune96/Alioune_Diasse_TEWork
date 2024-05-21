package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		// make a new List:
		List<String> staff = new ArrayList<String>();   // empty list (no initialization step)
		staff.size();  // 0

		staff.add("Amanda");
		staff.size();  // 1

		staff.add("Laura");
		staff.size();  // 2

		staff.add("Steve");
		staff.size();  // 3

		staff.add("Amanda");
		staff.size();  // 4

		staff.add(2, "Tom");


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for (int i = 0; i < staff.size(); i++) {
			String person = staff.get(i);

			System.out.println("Index " + i + ": " + person);
		}


		System.out.println("=================================");

		while (staff.remove("Amanda")); // remove alllll Amandas :(



		for (int i = 0; i < staff.size(); i++) {
			String person = staff.get(i);

			System.out.println("Index " + i + ": " + person);
		}



		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		String searchFor = "Amanda";

		if (staff.contains(searchFor)) {
			System.out.println("She's still here! She is at Index " + staff.indexOf(searchFor));

		} else {
			System.out.println("She's gone :( ");
		}




		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");




		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] arrayOfStrings = staff.toArray(new String[0]);


		System.out.println("FOR loop:");
		for (int i = 0; i < staff.size(); i++) {
			System.out.println("I have i: " + i);
			System.out.println("staff.get(i): " + staff.get(i));
		}

		System.out.println("FOR EACH loop:");
		for (String staffMember : staff) {
			System.out.println("I don't know what i is, but I have " + staffMember);
		}



		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(staff);




		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(staff);


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();


		System.out.println("####################");
		System.out.println("       QUEUEUEUEUEUES");
		System.out.println("####################");
		System.out.println();

		Queue<String> tasks = new LinkedList<>();
		tasks.offer("Do the dishes");
		tasks.offer("Mop the floor");
		tasks.offer("Make dinner");

		// process a queue
		// while (tasks.size() > 0) {
		while (!tasks.isEmpty()) {
			System.out.print("Do this next: ");

			String nextTask = tasks.poll();

			System.out.println(nextTask);
		}

		System.out.println("Done!");



		System.out.println("####################");
		System.out.println("       STACKS       ");
		System.out.println("####################");
		System.out.println();

		Stack<String> browserHistory = new Stack<String>();
		browserHistory.push("www.google.com");
		browserHistory.push("www.techelevator.com");
		browserHistory.push("www.espn.com");


		while (browserHistory.size() > 0) {
			System.out.println("Push the Back button!");

			String lastSite = browserHistory.pop();

			System.out.println(lastSite);
		}


	}
}
