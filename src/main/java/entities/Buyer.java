package entities;

import java.util.ArrayList;

public class Buyer extends User {
    private ArrayList<Integer> interestedProperties = new ArrayList<>();

    /**
     * Constructs a new user given the relevant details.
     *
     * @param name     The user's given name.
     * @param username The user's username, which will be used for authentication. Note that this must be unique for all users.
     * @param email    The user's email, for getting in contact with the buyers.
     * @param phone    The user's phone number, for getting in contact with the buyers.
     * @param password The user's password, used for authentication.
     */
    public Buyer(String name, String username, String email, String phone, String password) {
        super(name, username, email, phone, password);
    }


    /**
     * Adds a property to the user's list of interested properties.
     *
     * @param propertyId The property the buyer is interested in.
     */
    public void shortListProperty(Integer propertyId) { interestedProperties.add(propertyId); }

    /**
     * Gets the list of user's interested properties.
     *
     * @return An ArrayList of the user's interested properties.
     */
    public ArrayList<Integer> getInterestedProperties() {
        return interestedProperties;
    }

    public void removeShortListProperty(Integer propertyId){ interestedProperties.remove(propertyId);}
}
