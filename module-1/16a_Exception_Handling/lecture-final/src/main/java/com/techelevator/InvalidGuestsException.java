package com.techelevator;

public class InvalidGuestsException extends Exception {

    private int badNumber;

    public InvalidGuestsException(int badNumber) {
        this.badNumber = badNumber;
    }

    public int getBadNumber() {
        return badNumber;
    }

    @Override // inherited from java.lang.Object
    public String toString() {
        return "Cannot make a reservation for " + badNumber + " guests!";
    }

    @Override // inherited from java.lang.Exception
    public String getMessage() {
        return this.toString();
    }
}
