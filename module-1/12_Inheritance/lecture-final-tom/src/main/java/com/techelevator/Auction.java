package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Auction {

    private String itemForSale;
    private List<Bid> bidHistory = new ArrayList<>();
    private Bid currentWinningBid = new Bid("", 0);

    public Auction(String itemForSale) {
        this.itemForSale = itemForSale;
    }

    public boolean placeBid(Bid incomingBid) {
        bidHistory.add(incomingBid);

        if (incomingBid.getBidAmount() > currentWinningBid.getBidAmount()) {
            currentWinningBid = incomingBid;
            return true;
        }

        return false;
    }

    public Bid getCurrentWinningBid() {
        return this.currentWinningBid;
    }
    public String getItemForSale() {
        return this.itemForSale;
    }

    public List<Bid> getBidHistory() {
        return new ArrayList<>(bidHistory);
    }

    @Override
    public String toString() {
        return "This auction is for a " + itemForSale + " and the current winning bid is: " + currentWinningBid.getUsername() + " @ $" + currentWinningBid.getBidAmount();
    }

}
