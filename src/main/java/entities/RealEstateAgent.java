package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class RealEstateAgent implements Serializable {
    public final int agentId;
    private ArrayList<String> buyers;
    private final Seller client;

    public RealEstateAgent(Seller client, int propertyId) {
        this.client = client;
        this.agentId = propertyId;
        this.buyers = new ArrayList<>();
    }

    /** This function is called when a Buyer is interested in a property and would like to speak to the Seller.
     * The function sends a message to the seller that contains the Buyer's contact details and
     * informs the Seller that the Buyer is interested.
     */
    public void connectBuyersAndSeller(String custom_message, Buyer buyer, Property property) {
        client.addMessage("New notification! A buyer is interested in your property at"
                + property.getStreetAddress() + ". You can contact them at" + buyer.getEmail() + " or " +
                buyer.getPhone() + ". Here is a message from the prospective buyer: " + custom_message);
    }
    public int getAgentId() {
        return agentId;
    }

    public int getNumberOfBuyers() { return buyers.size(); }

    public void addBuyer(String buyer) { buyers.add(buyer); }

    public boolean removeBuyer(String Buyer) { return buyers.remove(Buyer); }

}
