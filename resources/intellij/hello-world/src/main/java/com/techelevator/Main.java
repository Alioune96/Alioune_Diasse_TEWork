package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean hasbeenCreate = true;
        Scanner userAnswer = new Scanner(System.in);
        boolean isAppOn=true;
        List<UserInformation> accountCreated = new ArrayList<>();
        File firstFile = new File("C:\\Users\\Student\\AliouneD96\\AliounePackage\\src\\UserInput.txt");
        SettingAccount userAccount = new SettingAccount();
BasicDataSource keeupUp = new BasicDataSource();
keeupUp.setUrl("jdbc:postgresql://localhost:5432/SocialMedia");
keeupUp.setUsername("postgres");
keeupUp.setPassword("postgres1");
UserDOAImp makeSure = new UserDOAImp(keeupUp);




        while (isAppOn) {

                if (firstFile.exists()) {
                    try (PrintWriter tyrone = new PrintWriter(firstFile)) {
                        System.out.println("Hello User, Welcome To Linked-Friends");
                        UserInformation hello = userAccount.settingAccount();
                        if(hello==null){
                            while(hasbeenCreate){
                                System.out.println("You has not created an account, you sure you dont want to create an account?");
                                String answeredtoWebsite = userAnswer.nextLine();
                                String tobeExtraSure = answeredtoWebsite.toLowerCase();
                                if(!tobeExtraSure.contains("no")){
                                    System.out.println("Good-Bye!");
                                    hasbeenCreate=!hasbeenCreate;
                                } else {
                                    hello=userAccount.settingAccount();
                                    if(hello != null){
                                        hasbeenCreate=false;
                                    }
                                }

                            }
                        }
                        accountCreated.add(hello);
                        makeSure.createdUser(hello);
                        userAccount.creatingHobbiesforUser();
                        boolean weArekeepingYou = userAccount.guidelinePromt(userAnswer);
                        if(!weArekeepingYou){
                            System.out.println("great, get out");
                            //this is also not working~!
                            isAppOn=!isAppOn;
                        }else{
                            System.out.println("Wonderful");
                        }



                    } catch (FileNotFoundException e) {
                        System.out.println("File is not here. Please go check the file and retry later");
                        isAppOn = false;
                    }
                }

            }


    }

    static UserInformation settingAccount() {
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
                                boolean keepHold = true;
                                while (keepHold){
                                    System.out.println("What is your Name");
                                    String name = userInput.nextLine();
                                    if(name.contains("_")||!name.contains("")){
                                        System.out.println("please provide us with your full name");
                                    }else{
                                        keepHold=false;
                                    }
                                }
                                System.out.println("What is your Phone Number");
                                String phoneNumber = userInput.nextLine();
                                String numberNumber = phoneNumber.replace("-","");
                                String parseBack;
                                boolean numberConf = true;
                                while (numberConf){
                                    try{
                                        int confirmedNumber = Integer.valueOf(numberNumber);
                                        if(confirmedNumber>999999999){
                                            System.out.println("please enter an value number");
                                        }else {
                                            parseBack = String.valueOf(confirmedNumber);
                                            numberConf=false;
                                        }

                                    }catch (NumberFormatException e){
                                        System.out.println("please provide us with an valid number");

                                    }
                                }

                                System.out.println("What is your Email");
                                String emailContact = userInput.nextLine();
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
//                                            creatingAccount = new UserInformation(name, parseBack, emailContact, ageOfUser);
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

        return creatingAccount;    }
}