package com.techelevator.hotels;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HotelService;

public class App {

    private final ConsoleService consoleService = new ConsoleService();
    private final HotelService hotelService = new HotelService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;

        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();
            if (menuSelection == 1) {
                // List Hotels!
                Hotel[] allHotels = hotelService.listHotels();
                consoleService.printHotels(allHotels);

            } else if (menuSelection == 2) {

                Review[] allReviews = hotelService.listReviews();
                consoleService.printReviews(allReviews);

            } else if (menuSelection == 3) {

                consoleService.promptUserForHotelId();
                int desiredHotel = consoleService.promptForMenuSelection();
                Hotel specificHotel = hotelService.getHotelById(desiredHotel);
                consoleService.printHotel(specificHotel);

            } else if (menuSelection == 4) {
                System.out.println("Not implemented");
            } else if (menuSelection == 5) {
                System.out.println("Not implemented");
            } else if (menuSelection == 6) {
                System.out.println("Not implemented");
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

}
