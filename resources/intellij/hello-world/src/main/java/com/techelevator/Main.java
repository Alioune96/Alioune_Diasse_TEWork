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
    boolean hasbeenCreate = true;
    Scanner userAnswer = new Scanner(System.in);
    SettingAccount userAccount = new SettingAccount();


    public static void main(String[] args) {

        Main appRun = new Main();
        if(appRun.appStarted()){
            appRun.appStarted();
        }
        String man = "*";



    }
        public  boolean appStarted() {
            boolean isAppOn = true;
            boolean hasbeenCreate = true;
            File firstFile = new File("C:\\Users\\Student\\AliouneD96\\AliounePackage\\src\\UserInput.txt");
            BasicDataSource keeupUp = new BasicDataSource();
            keeupUp.setUrl("jdbc:postgresql://localhost:5432/SocialMedia");
            keeupUp.setUsername("postgres");
            keeupUp.setPassword("postgres1");
            UserDOAImp makeSure = new UserDOAImp(keeupUp);


            Scanner userAnswer = new Scanner(System.in);

            while (isAppOn) {

                if (firstFile.exists()) {
                    try (PrintWriter tyrone = new PrintWriter(firstFile)) {
                        System.out.println("Hello User, Welcome To Linked-Friends");
                        UserInformation hello = userAccount.settingAccount();
                        if (hello == null) {
                            while (hasbeenCreate) {
                                System.out.println("You has not created an account, you sure you dont want to create an account?");
                                String answeredtoWebsite = userAnswer.nextLine();
                                String tobeExtraSure = answeredtoWebsite.toLowerCase();
                                if (!tobeExtraSure.contains("no")) {
                                    System.out.println("Good-Bye!");
                                    return false;
                                } else {
                                    hello = userAccount.settingAccount();
                                    if (hello != null) {
                                        hasbeenCreate = false;
                                    }
                                }

                            }
                        }
                        makeSure.createdUser(hello);
                        boolean weArekeepingYou = userAccount.guidelinePromt(userAnswer);
                        if (!weArekeepingYou) {
                            System.out.println("great, get out");
                            makeSure.deleteAccount(hello.getPhoneNumber(), hello.getFirstName());
                            isAppOn=false;
                            //this is also not working~!
                        } else {
                            System.out.println("Wonderful");
                        }


                    } catch (FileNotFoundException e) {
                        System.out.println("File is not here. Please go check the file and retry later");
                    }
                }

            }

return isAppOn;
    }

    }
