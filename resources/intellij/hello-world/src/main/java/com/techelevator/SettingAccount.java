package com.techelevator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SettingAccount {

    List<String> hobbiesForUser = new ArrayList<>();


    public SettingAccount() {
    }

    public UserInformation settingAccount() {
        boolean getout = false;
        UserInformation creatingAccount = null;


        System.out.println("We're excited to have you on our App. Connecting with friends can be exhausting. Which is why we are here to Help");
        System.out.println("Our app is designed to match you with your current social media followers, not complete strangers" + "Are you ready to set up a account?");
        System.out.println("Press (Y) for yes, (N) for no");
        Scanner userInput = new Scanner(System.in);
        while (getout == false)
            try {
                String yOrN = userInput.nextLine();
                if (yOrN.length() > 1) {
                    System.out.println("Please Enter on Letter");
                } else {
                    String decision = yOrN.toLowerCase().trim();
                    if (decision.contains("y")) {
                        boolean protectedCase = true;
                        while (protectedCase) {

                            try {
                                System.out.println("What is First Name");
                                String firstName = userInput.nextLine();
                                System.out.println("Your Last Name");
                                String lastName = userInput.nextLine();
                                System.out.println("What is your Phone Number");
                                String phoneNumber = userInput.nextLine();
                                String phoneForAccount ="";
                                boolean listenHereBuddy = true;
                                while (listenHereBuddy){
                                    boolean littleONe = true;
                                    while (littleONe) {
                                        if (phoneNumber.length() != 10) {
                                            System.out.println("Here is the mistake");
                                            phoneNumber=userInput.nextLine();
                                        } else {
                                            littleONe = false;
                                        }
                                    }

                                    String[]Justcan = phoneNumber.split("");
                                    for (int i = 0; i < Justcan.length ; i++) {
                                        if(i!=0&&i%3==0&&i!=9){
                                            phoneForAccount+="-";
                                        }
                                        phoneForAccount+=Justcan[i];
                                                }
                                            listenHereBuddy=false;

                                }
                                System.out.println("What is your Email");
                                String emailContact = userInput.nextLine();
                                boolean isNotvalidEmail = true;
                                while (isNotvalidEmail){
                                    if(emailContact.contains("@yahoo.com")||emailContact.contains("@gmail.com")){
                                        isNotvalidEmail=false;

                                    }else{
                                        System.out.println("Please provide us with an valid email");
                                        emailContact=userInput.nextLine();
                                    }
                                }
                                boolean miniloop = true;

                                while (miniloop) {
                                    try {
                                        System.out.println("What is your Age");
                                        String afornow = userInput.nextLine();
                                        int ageOfUser = Integer.parseInt(afornow);


                                        if (ageOfUser < 18) {
                                            System.out.println("Your too young for this Application, can't set up a account");
                                            miniloop = false;
                                            protectedCase = false;
                                            getout = true;
                                        } else {
                                            System.out.println("Thank for creating an account with Linked-Friends");
                                            creatingAccount = new UserInformation(firstName,lastName, emailContact,phoneNumber,ageOfUser);
                                            miniloop = false;
                                            protectedCase = false;
                                            getout = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Please provide an valid number");
                                    }
                                }

                            } catch (Exception e) {
                                System.out.println("Please provide use with the right Information");
                            }
                        }
                    } else if (decision.contains("n")) {
                        System.out.println("Sorry to Hear, Good bye!");
                        getout = true;

                    } else {
                        System.out.println("please enter a valid entry");
                    }

                }
            } catch (Exception e) {
                System.out.println("Please enter Characters");
            }

        return creatingAccount;
    }


    public String creatingHobbiesforUser() {
        boolean userI = true;
        while (userI) {
            System.out.println("Great to have you in our join our hub of more than 20 millions people worldwide.");
            System.out.println("however, our goal is to connect you with people in your life!");
            System.out.println("Tell our more about yourself, What are you favorite hobbies? and let us get to know more about you so we can help you create new and meaningful relationship");
            System.out.println("Please let at least 3 hobbies, but limit it to 10. Please separate them by an ','");
            try {
                Scanner keyTime = new Scanner(System.in);

                boolean holdUp = true;
                while (holdUp) {
                    String hobbiesToTrack = keyTime.nextLine();
                    String[] forSplit = hobbiesToTrack.split(",");
                    if (forSplit.length < 3) {
                        System.out.println("Please enter 3 information");
                    } else if (forSplit.length > 10) {
                        System.out.println("That too much");

                    } else {
                        hobbiesForUser = Arrays.asList(forSplit);


                        holdUp = false;
                        userI = false;
                    }
                }

            } catch (Exception e) {
                System.out.println("please try another time");

            }

        }

        return null;
    }


    public boolean guidelinePromt(Scanner answer ) {
        System.out.println("Our mission is to help our communication. Through our extensive math-matching application, our goal involves helping the everyday man like you!");
        System.out.println("However, There are certain guidelines that we must all follow, Please review our guideline and confirm finished at reading through it");
        String caseFor = null;
        int x = 0;
        while (x < 20) {
            System.out.println("This is a test");
            x += 1;
        }
        try {
            System.out.println("Please confirm that you read through our guideline");
            String result = answer.nextLine();
            boolean littleOne = true;
            boolean keepTrap = true;
            while (keepTrap) {
                while(littleOne) {
                    if (result.length() > 1 || result.length() < 0) {
                        System.out.println("Please try again.");
                        result = answer.nextLine();
                    }else{
                        littleOne =false;
                    }

                }
                String keepTHis = result.toLowerCase();
                if (!keepTHis.contains("y")) {
                    System.out.println("Sorry to hear, GoodBye");
                    keepTrap = false;

                }else{
                    System.out.println("Great to hear, Thanks for being part of our community!");
                    return true;

                }
            }
        } catch (Exception e) {
            System.out.println("An unknown issue");
        }

        return false;
    }



}

