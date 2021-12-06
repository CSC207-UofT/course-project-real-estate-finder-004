package externalinterfaces;

import java.io.IOException;

public class InitDatabaseUser {
    /**
     * Initializes the user database by creating a new HashMapUserStorage
     * and a new UserStorageReadWriter.
     */
    public static void main(String[] args) {
        HashMapUserStorage userStorage = new HashMapUserStorage();
        UserStorageReadWriter userStorageReadWriter = new UserStorageReadWriter(userStorage);
        try {
            userStorageReadWriter.saveToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
