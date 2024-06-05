package com.techelevator;

// MODEL layer
public class MovieRental {

    private String title;  // Title of the movie
    private String format; // DVD / VHS / BluRay
    private boolean premium;  // true or false

    // private double rentalPrice;  // Derive this (instead of storing this)

    public MovieRental(String title, String format, boolean premium) {
        this.title = title;
        this.format = format;
        this.premium = premium;
    }

    @Override
    public String toString() {
        //     "MOVIE: {title} - FORMAT: {format} PRICE: {rental price}"
        return "MOVIE: " + title + " - FORMAT: " + format + " PRICE: $" + getRentalPrice();
    }

    public double getLateFee(int daysLate) {
        if (daysLate < 1) {
            return 0.00;
        }

        if (daysLate == 1) {
            return 1.99;
        }

        if (daysLate == 2) {
            return 3.99;
        }

        return 19.99;
    }


    public double getRentalPrice() {
        double basePrice = 0.0;

        if (format.equalsIgnoreCase("VHS")) {
            basePrice = 0.99;
        } else if (format.equalsIgnoreCase("DVD")) {
            basePrice = 1.99;
        } else if (format.equalsIgnoreCase("BluRay")){
            basePrice = 2.99;
        }

        if (premium) {
            return basePrice + 1;
        } else {
            return basePrice;
        }

        //                     boolean ? T : F
        // return basePrice + (premium ? 1 : 0);
    }

}
