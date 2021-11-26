package externalinterfaces;

import entities.Property;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;

public class HashMapPropertyStorage implements Storage<Integer, Property>, Serializable {
    private static final long serialVersionUID = 486455786544765478L;
    // Key - UserName
    private final HashMap<Integer, Property> properties = new HashMap<>();

    @Override
    public void add(Property property) {
        properties.put(property.getPropertyId(), property);
    }

    @Override
    public Property get(Integer propertyId) {
        return properties.get(propertyId);
    }

    @Override
    public void remove(Integer propertyId) {
        properties.remove(propertyId);
    }

    @Override
    public String toString() {
        return "externalinterfaces.HashMapPropertyStorage{" +
                "properties=" + properties.toString() +
                '}';
    }

    public HashMap<Integer, Property> getProperties() {
        return properties;
    }

    public Integer getNewId() {
        if (this.properties.isEmpty()) {
            return 1;
        }
        return Collections.max(this.properties.keySet()) + 1;
    }
}
