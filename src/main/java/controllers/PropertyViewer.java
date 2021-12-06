package controllers;

import entities.Property;
import externalinterfaces.HashMapPropertyStorage;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PropertyViewer {
    private DatabaseManager manager;

    public PropertyViewer(DatabaseManager manager) {
        this.manager = manager;
    }

    public ArrayList<String> viewProperties(ArrayList<Integer> listOfProperties) {
        ArrayList<String> propertiesString = new ArrayList<>();
        for (Integer propertyId : listOfProperties) {
            propertiesString.add(manager.propertyStorage.get(propertyId).toString());
        }
        return propertiesString;
    }

}
