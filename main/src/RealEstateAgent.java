import java.util.ArrayList;

public class RealEstateAgent {
    private ArrayList<Buyer> buyers = new ArrayList<Buyer>();
    private Seller client;
    private Property property;

    public RealEstateAgent(Seller client) {
        this.client = client;
    }

    public void connectBuyersAndSellers() {
        // Not yet working.... Need to figure out how to communicate with it.
    }

    public int getNumberOfBuyers() {
        return buyers.size();
    }

    public void addBuyer(Buyer buyer) {
        this.buyers.add(buyer);
    }



}
