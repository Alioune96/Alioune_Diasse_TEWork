package com.techelevator;

public class Application {

    public static void main(String[] args) {

        MadeUpClass muc = new MadeUpClass();
        System.out.println(muc);

        System.exit(0);


        Auction a = new Auction("Tech Elevator T-shirt!");
        ReserveAuction ra = new ReserveAuction("Tech Elevator Coffee Mug", 250);
        BuyItNowAuction ba = new BuyItNowAuction("Tech Elevator Acoustic Guitar", 100);

        Auction[] auctionArray = new Auction[] { a, ba, ra, new MadeUpAuction() };

        for (Auction x : auctionArray) {
            System.out.println(x);
        }

        System.exit(0);

        Bid newBid1 = new Bid("Tom", 90);
        Bid newBid2 = new Bid("Steve", 200);
        Bid newBid3 = new Bid("Tom", 300);

        for (Auction auction : auctionArray) {
            auction.placeBid(newBid1);
            auction.placeBid(newBid2);
            auction.placeBid(newBid3);
        }

        System.out.println("==================================");

        for (Auction auction : auctionArray) {
            Bid winningBid = auction.getCurrentWinningBid();

            String winner = winningBid.getUsername();
            int winningBidAmount = winningBid.getBidAmount();

            System.out.println(winner + " wins the auction, with a bid of: $" + winningBidAmount);

            System.out.println("AUCTION bid History:");
            for (Bid b : auction.getBidHistory()) {
                System.out.println(b.getUsername() + " bid $" + b.getBidAmount());
            }
            System.out.println("==================================");
        }


        System.out.println("Thanks for playing!");
    }

}
