package com.techelevator;


// MODEL (business logic)
public class HotelCalculator {
    private final int FIXED_RATE = 100;

    public int calculateCosts(int guests, int nights) {
        if (guests < 1 || nights < 1) {
            throw new IllegalArgumentException();
        }

        return guests * nights * FIXED_RATE;
    }
}
