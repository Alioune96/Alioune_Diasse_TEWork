public class Bidperson {
    private String username;
    private int bidAmount;

    public Bidperson(String username, int bidAmount) {
        this.username = username;
        this.bidAmount = bidAmount;
    }


    public String getUsername() {
        return username;
    }

    public int getBidAmount() {
        return bidAmount;
    }
}
