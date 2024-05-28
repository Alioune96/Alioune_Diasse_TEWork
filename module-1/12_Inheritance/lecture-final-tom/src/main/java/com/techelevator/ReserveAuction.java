package com.techelevator;

//                           is-an
//              subclass             superclass
public class ReserveAuction extends Auction {

    private int reservePrice;

    public ReserveAuction(String itemForSale, int reservePrice) {
        super(itemForSale);
        this.reservePrice = reservePrice;
    }


    @Override
    public boolean placeBid(Bid incomingBid) {
        if (incomingBid.getBidAmount() >= this.reservePrice) {
            return super.placeBid(incomingBid);
        }

        return false;
    }

    @Override
    public Bid getCurrentWinningBid() {
        if (super.getCurrentWinningBid().getBidAmount() < this.reservePrice) {
            return null;
        }

        return super.getCurrentWinningBid();
    }


    public int getReservePrice() {
        return reservePrice;
    }


    @Override
    public String toString() {
        return super.toString() + "\tMy Reserve Price was: $" + reservePrice;
    }
}
