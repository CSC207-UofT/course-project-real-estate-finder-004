package controllers;

import entities.Buyer;
import entities.Seller;
import entities.User;
import externalinterfaces.HashMapAgentStorage;
import externalinterfaces.HashMapPropertyStorage;
import externalinterfaces.HashMapUserStorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserCreator extends Creator {

    public UserCreator(HashMapUserStorage userStorage,
                       UserStorageReadWriter userStorageReadWriter,
                       HashMapPropertyStorage propertyStorage,
                       PropertyStorageReadWriter propertyStorageReadWriter,
                       HashMapAgentStorage agentStorage,
                       AgentStorageReadWriter agentStorageReadWriter) {
        super(userStorage, userStorageReadWriter, propertyStorage, propertyStorageReadWriter, agentStorage, agentStorageReadWriter);
    }

    public void create(String name, String user_type, String username, String email, String phone, String password) {
        User newUser = null;

        switch (user_type) {
            case "b":
                newUser = new Buyer(name, username, email, phone, password);
                break;
            case "s":
                newUser = new Seller(name, username, email, phone, password);
                break;
        }

        if (newUser != null) {
            this.userStorage.add(newUser);
            if (Creator.writeToFile) {
                try {
                    userStorageReadWriter.saveToFile();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void create(String name, String user_type, String username, String email, String phone, String password, HashMap<String, Boolean> messages, ArrayList<Integer> properties) {
        User newUser = null;

        switch (user_type) {
            case "b":
                newUser = new Buyer(name, username, email, phone, password);
                break;
            case "s":
                Seller newSeller = new Seller(name, username, email, phone, password);
                for (String key : messages.keySet()) {
                    newSeller.addMessage(key);
                    if (messages.get(key)) {
                        newSeller.messageRead(key);
                    }
                }
                for (Integer propertyID : properties) {
                    newSeller.addProperty(propertyID);
                }
                newUser = newSeller;
                break;
        }


        if (newUser != null) {
            this.userStorage.add(newUser);
            if (Creator.writeToFile) {
                try {
                    userStorageReadWriter.saveToFile();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
