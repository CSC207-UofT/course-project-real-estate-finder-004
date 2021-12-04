package entities;

import entities.Buyer;
import entities.Property;
import entities.Seller;

import java.io.Serializable;
import java.util.ArrayList;

public class RealEstateAgent implements Serializable {
    private ArrayList<Buyer> buyers = new ArrayList<Buyer>();
    private Seller client;
    private Property property;

    /**
     * Constructor for the RealEstateAgent.
     *
     * @param client The Seller object that this RealEstateAgent corresponds to.
     */
    public RealEstateAgent(Seller client) {
        this.client = client;
    }

    /**
     * This function is called when a entities.Buyer is interested in a property and would like to speak to the entities.Seller.
     * The function sends a message to the seller that contains the entities.Buyer's contact details and
     * informs the entities.Seller that the entities.Buyer is interested.
     *
     * @param custom_message A String with the message that the buyer wants to be passed along.
     * @param buyer          The Buyer that wants this message passed to the client.
     */
    public void connectBuyersAndSeller(String custom_message, Buyer buyer) {
        // Not yet working.... Need to figure out how to communicate with it.
        client.addMessage("New notification! A buyer is interested in your property at"
                + property.getStreetAddress() + ". You can contact them at" + buyer.getEmail() + " or " +
                buyer.getPhone() + ". Here is a message from the prospective buyer: " + custom_message);
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
     * @param buyer The Buyer instance to be added.
     */
    public void addBuyer(Buyer buyer) {
        this.buyers.add(buyer);
    }


}
