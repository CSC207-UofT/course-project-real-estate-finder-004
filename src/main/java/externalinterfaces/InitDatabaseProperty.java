package externalinterfaces;

import java.io.IOException;

public class InitDatabaseProperty {
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
