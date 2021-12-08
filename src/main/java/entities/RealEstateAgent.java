package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class RealEstateAgent implements Serializable {
    private final int agentId;
    private final ArrayList<String> buyers;
    private final Seller client;

    /**
     * Constructor for the RealEstateAgent.
     *
     * @param client The Seller object that this RealEstateAgent corresponds to.
     */
    public RealEstateAgent(Seller client, int propertyId) {
        this.client = client;
        this.agentId = propertyId;
        this.buyers = new ArrayList<>();
    }

    /**
     * This function is called when a Buyer is interested in a property and would like to speak to the Seller.
     * The function sends a message to the seller that contains the Buyer's contact details and
     * informs the Seller that the Buyer is interested.
     *
     * @param customMessage A String with the message that the buyer wants to be passed along.
     * @param buyer         The Buyer that wants this message passed to the client.
     * @param property      The property that the buyer wishes to contact the seller for
     */
    public void connectBuyersAndSeller(String customMessage, Buyer buyer, Property property) {
        client.addMessage("New notification! A buyer is interested in your property at "
                + property.getStreetAddress() + ". You can contact them at " + buyer.getEmail() + " or " +
                buyer.getPhone() + ". Here is a message from the interested buyer: " + customMessage);
    }

    public int getAgentId() {
        return agentId;
    }

    /**
     * Returns the number of Buyers that are associated with this RealEstateAgent.
     *
     * @return An int with the length of the buyers object.
     */
    public int getNumberOfBuyers() {
        return buyers.size();
    }

    /**
     * Adds a buyer to the list of buyers associated with this RealEstateAgent.
     *
     * @param buyerId The username of the Buyer to be added.
     */
    public void addBuyer(String buyerId) {
        this.buyers.add(buyerId);
    }

    public boolean removeBuyer(String Buyer) {
        return buyers.remove(Buyer);
    }
}
