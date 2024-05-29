package com.techelevator.farm;

import java.util.*;

public class Application {
    public static void main(String[] args) {


        List<String> students = new JavaBlueList();

        students.add("String");
        System.out.println(students.size());

        System.exit(0);

        Map<Integer, String> zip2city = new TreeMap<>();

        zip2city.put(15222, "Dahntahn");
        zip2city.put(15201, "Lawrenceville");
        zip2city.put(90210, "Beverly Hills");
        zip2city.put(43081, "Westerville");
        zip2city.put(19144, "Germantown");


        for (Integer zipcode : zip2city.keySet()) {
            String value = zip2city.get(zipcode);

            System.out.println(zipcode + " is the neighborhood of " + value);
        }

    }


}
