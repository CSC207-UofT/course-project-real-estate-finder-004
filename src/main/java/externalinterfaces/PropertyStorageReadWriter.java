package externalinterfaces;

import entities.Property;

public class PropertyStorageReadWriter extends StorageReadWriter<Integer, Property>{
    public PropertyStorageReadWriter(Storage<Integer, Property> storage) {
        super("src/properties.ser", storage);
    }
}

