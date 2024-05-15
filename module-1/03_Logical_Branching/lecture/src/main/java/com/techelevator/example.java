package com.techelevator;

public class example {
    public static void main(String [] args){
        int age = 15;
        boolean hasPermit = true;

        if(age >= 15){
            //drive
        }
        else if(age >= 15 && hasPermit){
            //drive
        }
        else {
            //don't drive
        }
        System.out.println("drive");
        boolean condition1 = true;
        boolean condition2=true;
        System.out.println(condition1&&condition2);
        int[] testScores = new int[10];

// ... array is populated

        boolean hasPerfectScore = false;

        for (int i = 0; i < testScores.length; i++) {
            if (testScores[i] == 100) {
                hasPerfectScore = true;
                break;      // stop looking for a perfect score if you've found one
            }
        }

        System.out.println("Contains perfect score " + hasPerfectScore);
    }
}
