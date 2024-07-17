package com.techelevator.clientServer;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.File;
import java.util.Scanner;


public class Main {
    Scanner userAnswer = new Scanner(System.in);
    SettingAccount userAccount = new SettingAccount();


    public static void main(String[] args) {

        Main appRun = new Main();
        appRun.appStarted();


    }







    public void appStarted() {


        File firstFile = new File("C:\\Users\\Student\\AliouneD96\\AliounePackage\\src\\UserInput.txt");
        BasicDataSource keeupUp = new BasicDataSource();
        keeupUp.setUrl("jdbc:postgresql://localhost:5432/SocialMedia");
        keeupUp.setUsername("postgres");
        keeupUp.setPassword("postgres1");
        UserDOAImp makeSure = new UserDOAImp(keeupUp);


        Scanner userAnswer = new Scanner(System.in);


        if (firstFile.exists()) {
            boolean doesUserHaveAccount = true;
            int parseUser = 0;

            while (doesUserHaveAccount) {
                System.out.println("Hello User, Welcome To Linked-Friends");
                System.out.println("Would you like to log in or create a account? Press 1 to Login or 2 to Register");
                String user = userAnswer.nextLine();
                boolean smallTrap = true;
                while (smallTrap) {
                    try {
                        parseUser = Integer.parseInt(user);
                        smallTrap = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Please provide us an number");
                    }
                }


                if (parseUser == 1) {
                    System.out.print("What is your First name?: ");
                    String firstName = userAnswer.nextLine();
                    System.out.print("What is your Last name?: ");
                    String lastName = userAnswer.nextLine();

                    UserInformation thisWouldKeep = makeSure.checkUser(firstName,lastName);
                    if (thisWouldKeep != null) {
                        System.out.println("Hello: " + thisWouldKeep.getFirstName()+". Welcome Back!");
                        doesUserHaveAccount = false;
                    }
                } else {
                    UserInformation hello = userAccount.settingAccount();
                    if (hello == null) {
                        boolean hasbeenCreate = true;
                        while (hasbeenCreate) {
                            System.out.println("You has not created an account, you sure you dont want to create an account?");
                            String answeredtoWebsite = userAnswer.nextLine();
                            String tobeExtraSure = answeredtoWebsite.toLowerCase();
                            if (!tobeExtraSure.contains("no")) {
                                System.out.println("Good-Bye!");
                                break;
                            } else {
                                hello = userAccount.settingAccount();
                                if (hello != null) {
                                    makeSure.createdUser(hello);
                                    hasbeenCreate = false;
                                    doesUserHaveAccount = false;
                                }
                            }

                        }
                    }
                }
            }
        }






    }
}