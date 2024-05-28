package com.techelevator;

public class MadeUpAuction extends Auction {

    public MadeUpAuction() {
        super("No item at all");
    }


    @Override
    public boolean placeBid(Bid incomingBid) {
        return super.placeBid(incomingBid);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
