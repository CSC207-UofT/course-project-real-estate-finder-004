package entities;

import java.util.ArrayList;

public class Buyer extends User {
    private ArrayList<Integer> interestedProperties = new ArrayList<>();

    public Buyer(String name, String username, String email, String phone, String password) {
        super(name, username, email, phone, password);
    }

    public void shortListProperty(Integer propertyId) { interestedProperties.add(propertyId); }

    public ArrayList<Integer> getInterestedProperties() {
        return interestedProperties;
    }

}
