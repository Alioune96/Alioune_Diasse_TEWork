import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Auction {
    private String itemforSale;
    private List<Bidperson> bidpeople = new ArrayList<>();
    private Bidperson currentwinning = new Bidperson("", 0);

    public Auction(String itemforSale) {
        this.itemforSale = itemforSale;
    }

    public Bidperson getCurrentwinning(){
        return this.currentwinning;
    }
    public boolean placebid(Bidperson incoming){

        bidpeople.add(incoming);
        if(incoming.getBidAmount()>currentwinning.getBidAmount()){
            currentwinning=incoming;
            return true;
        }
        bidpeople.add(incoming);
        return false;
    }

    public String getItemforSale() {
        return itemforSale;
    }
}
