package externalinterfaces;

import entities.Property;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class HashMapPropertyStorage implements Storage<Integer, Property>, Serializable {
    private static final long serialVersionUID = 486455786544765478L;
    /**
     * Creates a new HashMap where the keys are unique integers and the values are properties.
     */
    private final HashMap<Integer, Property> properties = new HashMap<>();

    /**
     * Adds a property to the properties HashMap.
     * @param property  property to be stored in properties
     */
    @Override
    public void add(Property property) {
        properties.put(property.getPropertyId(), property);
    }

    /**
     * Returns the property associated with a given propertyId.
     * @param propertyId    an integer which is the key of a property
     * @return  a property stored in properties
     */
    @Override
    public Property get(Integer propertyId) {
        return properties.get(propertyId);
    }

    /**
     * Removes a propertyId and its associated property from the properties HashMap.
     * @param propertyId    an integer which is the key of a property
     */
    @Override
    public void remove(Integer propertyId) {
        properties.remove(propertyId);
    }

    /**
     * @return  the keys in the properties HashMap
     */
    @Override
    public Set<Integer> keySet() {
        return properties.keySet();
    }

    /**
     * @return a String representation of the properties HashMap.
     */
    @Override
    public String toString() {
        return "externalinterfaces.HashMapPropertyStorage{" +
                "properties=" + properties.toString() +
                '}';
    }

    /**
     * @return  the properties HashMap
     */
    public HashMap<Integer, Property> getProperties() {
        return properties;
    }

    /**
     * @return  a new unique propertyId
     */
    public Integer getNewId() {
        if (this.properties.isEmpty()) {
            return 1;
        }
        return Collections.max(this.properties.keySet()) + 1;
    }
}
