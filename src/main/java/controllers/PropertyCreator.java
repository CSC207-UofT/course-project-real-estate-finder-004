package controllers;

import entities.Property;
import entities.Seller;
import externalinterfaces.*;

import java.io.IOException;

public class PropertyCreator extends Creator {


    public PropertyCreator(HashMapUserStorage userStorage,
                           UserStorageReadWriter userStorageReadWriter,
                           HashMapPropertyStorage propertyStorage,
                           PropertyStorageReadWriter propertyStorageReadWriter,
                           HashMapAgentStorage agentStorage,
                           AgentStorageReadWriter agentStorageReadWriter) {
        super(userStorage, userStorageReadWriter, propertyStorage, propertyStorageReadWriter, agentStorage, agentStorageReadWriter);
    }

    /**
     * Creates a new Property with the given parameters and creates a propertyId for it.
     * Then it saves the Property in the property storage.
     * @param user  The user who owns the property.
     * @param streetAddress The property's street address.
     * @param city  The city in which the property is located.
     * @param province  The province in which the property is located.
     * @param country   The country in which the property is located.
     * @param postalCode    The property's postal code.
     * @param price The price of the property.
     * @param sqft   The square footage of the property.
     * @param availability  The property's availability.
     */
    public void create(Seller user, String streetAddress, String city, String province, String country,
                       String postalCode, float price, int sqft, boolean availability) {

        int propertyId = propertyStorage.getNewId();
        Property property = new Property(propertyId, streetAddress, city, province, country, postalCode, price, sqft, user, availability);
        user.addProperty(property.getPropertyId());

        this.propertyStorage.add(property);
        if(Creator.writeToFile) {
            try {
                agentStorageReadWriter.saveToFile();
                propertyStorageReadWriter.saveToFile();
                userStorageReadWriter.saveToFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
