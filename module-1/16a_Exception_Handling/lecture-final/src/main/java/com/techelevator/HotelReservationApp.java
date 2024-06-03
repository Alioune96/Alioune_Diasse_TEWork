package com.techelevator;

public class HotelReservationApp {

    // CONTROLLER (traffic control)
    public static void main(String[] args) {

        // Create VIEW
        UI userInterface = new UI();
        int nights = userInterface.promptUser("nights");
        int guests = userInterface.promptUser("guests");

        // CREATE MODEL
        HotelCalculator hc = new HotelCalculator();
        int totalCost = hc.calculateCosts(guests, nights);

        // shuttle data back and forth (via public methods)
        userInterface.displayFinalCost(totalCost);

    }





    public String stupidMethod() throws RuntimeException {
//        } catch (ArithmeticException e) {
//
//        } catch (NumberFormatException e) {
//            System.out.println("Play nice!");
//        } catch (InvalidNightsException e) {
//            System.out.println(e.getMessage());
//        } catch (InvalidGuestsException e) {
//            System.out.println(e.getMessage());
//        }

        throw new RuntimeException();

    }


    public String stupiderMethod() {
        String result = "";

        result = stupidMethod();

        return result;
    }


}
