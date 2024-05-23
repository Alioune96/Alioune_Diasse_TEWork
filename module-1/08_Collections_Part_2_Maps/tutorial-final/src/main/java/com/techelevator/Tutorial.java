package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Tutorial {
	

    public static void main(String[] args) {

        // Step One: Declare a Map
        Map<String, String> projects = new HashMap<String, String>();


        // Step Two: Add items to a Map
        projects.put("Ada", "Inventing Computer Programming");
        projects.put("Grace", "COBOL");
        projects.put("Margaret", "Apollo Guidance Computer");
        projects.put("Adele", "Graphical User Interfaces");


        // Step Four: Remove an item (this comment doesn't appear in the student starter)
        projects.remove("Grace");


        // Step Three: Loop through a Map
        for (Map.Entry<String, String> project : projects.entrySet()) {
            System.out.println("The key " + project.getKey() + " is linked to the value " + project.getValue());
        }
        List<String> names = new ArrayList<String>();
        names.add("first name");
        names.add(0,"alioune");
        System.out.println("please print the name, of the list "+names.get(0));

    }

}
