package controllers;

import entities.User;
import externalinterfaces.Storage;

public class UserStorageReadWriter extends StorageReadWriter<String, User>{
    public UserStorageReadWriter(Storage<String, User> storage) {
        super("src/users.ser", storage);
    }
}
