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

    public void create(Seller user, String streetAddress, String city, String province, String country,
                       String postalCode, float price, int sqft, boolean availability) {

        int propertyId = propertyStorage.getNewId();
        Property property = new Property(propertyId, streetAddress, city, province, country, postalCode, price, sqft, user, availability);
        user.addProperty(property.getPropertyId());

        this.propertyStorage.add(property);
        if(Creator.writeToFile) {
            try {
                propertyStorageReadWriter.saveToFile();
                userStorageReadWriter.saveToFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
