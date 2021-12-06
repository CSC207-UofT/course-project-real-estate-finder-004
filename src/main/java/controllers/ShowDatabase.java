package controllers;

import entities.Property;
import entities.RealEstateAgent;
import entities.User;
import externalinterfaces.*;

import java.io.IOException;

public class ShowDatabase {
    public static void main(String[] args) {
        StorageReadWriter<String, User> userStorageReadWriter = new UserStorageReadWriter(null);
        HashMapUserStorage userStorage = null;
        try {
            userStorage = (HashMapUserStorage) userStorageReadWriter.readFromFile();
            System.out.println(userStorage.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        StorageReadWriter<Integer, Property> propertyStorageReadWriter = new PropertyStorageReadWriter(null);
        HashMapPropertyStorage propertyStorage = null;
        try {
            propertyStorage = (HashMapPropertyStorage) propertyStorageReadWriter.readFromFile();
            System.out.println(propertyStorage.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        StorageReadWriter<Integer, RealEstateAgent> agentStorageReadWriter = new AgentStorageReadWriter(null);
        HashMapAgentStorage agentStorage = null;
        try {
            agentStorage = (HashMapAgentStorage) agentStorageReadWriter.readFromFile();
            System.out.println(agentStorage.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
