package com.techelevator;
import java.util.Arrays;
import java.util.Scanner;

public class UserInformation {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private int Age;


    public UserInformation(){

    }

    public UserInformation(String firstName,String lastName, String email, String phoneNumber, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        Age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return Age;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setHobbies() {
        boolean userI = true;
        while (userI) {
            System.out.println("Great to have you in our join our hub of more than 20 millions people worldwide.");
            System.out.println("however, our goal is to connect you with people in your life!");
            System.out.println("Tell our more about yourself, What are you favorite hobbies? and let us get to know more about you so we can help you create new and meaningful relationship");
            System.out.println("Please let at least 3 hobbies, but limit it to 10. Please separate them by an ','");
            try {
                Scanner keyTime = new Scanner(System.in);
                boolean yournotout = true;

                boolean holdUp = true;
                while (holdUp) {
                    String hobbiesToTrack = keyTime.nextLine();

                    while (yournotout) {
                        if (hobbiesToTrack.contains("1") || hobbiesToTrack.contains("2")) {
                            System.out.println("Please try again");
                        } else {
                            yournotout = false;
                        }
                    }
                    String[] forSplit = hobbiesToTrack.split(",");

                    if (forSplit.length < 3) {
                        System.out.println("Please enter 3 information");
                    } else if (forSplit.length > 10) {
                        System.out.println("That too much");

                    } else {
                        holdUp = false;
                        userI = false;
                    }
                }

            } catch (Exception e) {
                System.out.println("please try another time");

            }

        }

    }
}
