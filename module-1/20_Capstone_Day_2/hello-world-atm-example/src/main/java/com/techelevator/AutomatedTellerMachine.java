package com.techelevator;

public class AutomatedTellerMachine {

    private String manufacturer;
    private double deposits;

    private double withdrawals;


    public AutomatedTellerMachine(String manufacturer, double deposits, double withdrawals) {
        this.manufacturer = manufacturer;
        this.deposits = deposits;
        this.withdrawals = withdrawals;
    }


    // Derived Property (calculated from two pieces of data, so it doesn't need to be its own piece of data)
    public double getBalance() {
        return deposits - withdrawals;
    }


    public boolean isValidCardNumber(String cardNumber) {
        if (cardNumber == null) {
            return false;
        }

        int length = cardNumber.length();
        char startingDigit = cardNumber.charAt(0);  // take the number at index 0 (first number) and return it as char

//        If the cardNumber begins with a 5 and has 16 digits
        if (startingDigit == '5' && length == 16) {
            return true;
        }

//        If the cardNumber begins with a 4 and has 13 or 16 digits
        if (startingDigit == '4' && (length == 13 || length == 16)) {
            return true;
        }

//        If the cardNumber begins with a 3 and is followed by a 4 or a 7
        if (cardNumber.startsWith("34") || cardNumber.startsWith("37")) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "ATM - " + manufacturer + " - " + getBalance();
    }

}
