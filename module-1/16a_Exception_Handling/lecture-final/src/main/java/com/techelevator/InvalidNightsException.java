package com.techelevator;

public class InvalidNightsException extends Exception {

    private int wrongNumber;

    public InvalidNightsException(int wrongNumber) {
        this.wrongNumber = wrongNumber;
    }

    public int getWrongNumber() {
        return wrongNumber;
    }
}
