public class Application {

    public static void main(String[] args) {
        Auction myAction = new Auction("Tech Elevator T shirt");

        ReservationAction ra = new ReservationAction("tech elevator coffee mug", 14);

        Bidperson newBid = new Bidperson("Alioune", 100);
        Bidperson secondBid = new Bidperson("Steve", 150);
        Bidperson newBid3 = new Bidperson("Tom", 1100);
        myAction.placebid(newBid);
        myAction.placebid(secondBid);
        myAction.placebid(newBid3);

        String winner = myAction.getCurrentwinning().getUsername();
        int winningBid = myAction.getCurrentwinning().getBidAmount();

        System.out.println(winner + " wins the action " + winningBid);
    }
}
