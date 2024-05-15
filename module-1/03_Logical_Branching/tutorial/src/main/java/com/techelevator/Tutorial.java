package com.techelevator;

public class Tutorial {
        public static void main(String[] args) {

                /* *********** Logical Branching Tutorial ***********
                 * In this tutorial, you will write some boolean expressions and use them to
                 * control the flow of your program using if / else statements.
                 * This program tells the user how to prepare for their day based on weather conditions.
                 * *************************************************/

                // Step One: Greet the user
                System.out.println("**************************************");
                System.out.println("*** Welcome to the Weather Station ***");
                System.out.println("**************************************");

                // Step Two: Declare and initialize Weather Station variables
                int highTemp = 50;
                int lowTemp = 25;
                int dayTemp = 48;
                final int FREEZING_POINT = 2;
                boolean isThereRain = true;
                String weatherStation = "CNN";



                // Step Three: Report today's expected conditions to the user.
                System.out.println("Today weather is looking grey outside with an High of: " + highTemp + " and an Low of: "+ lowTemp);


                // Step Four: Determine if the user should bring a coat. (when the temperature < 65°F)
                if(dayTemp < 65){
                        System.out.println("you should bring an coat today");
                }


                // Step Five: Determine if the user should bring an umbrella

                if(dayTemp<65 && isThereRain){
                        System.out.println("you should also bring an umbrella");
                }

                // Step Six: Advise the user on the type of jacket they should be wearing. (<= 0°F, <= freezing, < 65°F)

                if(dayTemp <= 0){
                        System.out.println("good luck lol");
                }
                else if(dayTemp <= FREEZING_POINT){
                        System.out.println("too cold buddy");
                }
                else if(dayTemp < 65){
                        System.out.println("you got an chance, just wear regular jacket");
                }

                // Step Seven: If the temperature delta for the day is more than 20°F, advise the user to dress in layers.
                if(dayTemp > 20){
                        System.out.println("just wear layers tho");
                }
                
        }
}
