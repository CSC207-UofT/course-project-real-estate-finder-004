import java.io.Serializable;
import java.util.ArrayList;

// <<<<<<< Serializable_added
public class RealEstateAgent implements Serializable {
    private ArrayList<Buyer> buyers = new ArrayList<Buyer>();
// =======
// public class RealEstateAgent {
//     private ArrayList<Buyer> buyers = new ArrayList<>();
// >>>>>>> main
    private Seller client;
    private Property property;

    public RealEstateAgent(Seller client) {
        this.client = client;
    }

    /** This function is called when a Buyer is interested in a property and would like to speak to the Seller.
     * The function sends a message to the seller that contains the Buyer's contact details and
     * informs the Seller that the Buyer is interested.
     */
    public void connectBuyersAndSeller(String custom_message, Buyer buyer) {
        // Not yet working.... Need to figure out how to communicate with it.
        client.addMessage("New notification! A buyer is interested in your property at"
                + property.getStreetAddress() + ". You can contact them at" + buyer.getEmail() + " or " +
                buyer.getPhone() + ". Here is a message from the prospective buyer: " + custom_message);
    }

    public int getNumberOfBuyers() {
        return buyers.size();
    }

    public void addBuyer(Buyer buyer) {
        this.buyers.add(buyer);
    }



}
