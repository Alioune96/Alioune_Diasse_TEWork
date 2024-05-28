package com.techelevator;

public class BuyItNowAuction extends Auction {

    private int buyItNowPrice;

    public BuyItNowAuction(String itemForSale, int buyItNowPrice) {
        super(itemForSale);
        this.buyItNowPrice = buyItNowPrice;
    }
    @Override
    public boolean placeBid(Bid incomingBid) {
        Bid currentWinningBid = super.getCurrentWinningBid();

        if (currentWinningBid.getBidAmount() >= buyItNowPrice) {
            return false;
        }

        if (incomingBid.getBidAmount() >= buyItNowPrice) {
            super.placeBid(incomingBid);
            return true;
        }

        return super.placeBid(incomingBid);
    }

    public int getBuyItNowPrice() {
        return buyItNowPrice;
    }

    @Override
    public String toString() {
        return super.toString() + "\tMy Buy It Now Price was: $" + buyItNowPrice;
    }
}
