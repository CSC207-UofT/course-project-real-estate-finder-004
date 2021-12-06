package externalinterfaces;

import controllers.PropertyStorageReadWriter;

import java.io.IOException;

public class InitDatabaseProperty {
    /**
     * Initializes the property database by creating a new HashMapPropertyStorage
     * and a new PropertyStorageReadWriter.
     */
    public static void main(String[] args) {
        HashMapPropertyStorage propertyStorage = new HashMapPropertyStorage();
        PropertyStorageReadWriter propertyStorageReadWriter = new PropertyStorageReadWriter(propertyStorage);
        try {
            propertyStorageReadWriter.saveToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
