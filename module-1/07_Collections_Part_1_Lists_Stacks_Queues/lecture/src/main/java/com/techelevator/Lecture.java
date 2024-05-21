package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		// make a new list
		List<String> staff = new ArrayList<String>();
		staff.size();//0
		staff.add("amanda");
		staff.add("laura");
		staff.add("james");
		staff.add("mangger");
		staff.add(2,"amanda");
		while(staff.get(0).equals("amanda")){
			System.out.println("hello");
			if(staff.indexOf("james")==2);{
				break;
			}
		}
        for (String s : staff) {
            System.out.println(s);
        }


		Queue<String> tasks = new LinkedList<>();
		tasks.offer("do the dish");
		tasks.offer("mop the floor");
		tasks.offer("make dinner");
		while(tasks.size()>0){
			System.out.print("do this next: ");
			String nHss = tasks.poll();
			System.out.println(nHss);
		}

		Stack<String> broweserhister = new Stack<>();
		broweserhister.push("google");
		broweserhister.push("tech");
		broweserhister.push("espn");
		while (broweserhister.size()>0){
			System.out.print("this is the order");
			String stored = broweserhister.pop();
			System.out.println(stored);
		}

System.exit(0);
		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");


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


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();


	}
}
