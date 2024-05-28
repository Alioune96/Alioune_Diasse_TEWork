package com.techelevator;

public class Bid {

    private String username;
    private int bidAmount;


    public Bid(String username, int bidAmount) {
        this.username = username;
        this.bidAmount = bidAmount;
    }

    public int getBidAmount() {
        return bidAmount;
    }

    public String getUsername() {
        return username;
    }
}
