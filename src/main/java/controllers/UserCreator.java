package controllers;

import entities.Buyer;
import entities.Seller;
import entities.User;
import externalinterfaces.HashMapAgentStorage;
import externalinterfaces.HashMapPropertyStorage;
import externalinterfaces.HashMapUserStorage;

import java.io.IOException;

public class UserCreator extends Creator {

    public UserCreator(HashMapUserStorage userStorage,
                       UserStorageReadWriter userStorageReadWriter,
                       HashMapPropertyStorage propertyStorage,
                       PropertyStorageReadWriter propertyStorageReadWriter,
                       HashMapAgentStorage agentStorage,
                       AgentStorageReadWriter agentStorageReadWriter) {
        super(userStorage, userStorageReadWriter, propertyStorage, propertyStorageReadWriter, agentStorage, agentStorageReadWriter);
    }

    /**
     * Creates a new User with the given parameters and depending on the user_type it creates either a Buyer or
     * a Seller as the new User. And then saves the User in the user storage.
     * @param name  name of the user
     * @param user_type Buyer or Seller
     * @param username  username of the user
     * @param email email of the user
     * @param phone phone of the user
     * @param password  password of the user
     */
    public void create(String name, String user_type, String username, String email, String phone, String password){
        User newUser = null;

        switch (user_type){
            case "b":
                newUser = new Buyer(name, username, email, phone, password);
                break;
            case "s":
                newUser = new Seller(name, username, email, phone, password);
                break;
        }

        if (newUser != null){
            this.userStorage.add(newUser);
            if(Creator.writeToFile) {
                try {
                    userStorageReadWriter.saveToFile();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
