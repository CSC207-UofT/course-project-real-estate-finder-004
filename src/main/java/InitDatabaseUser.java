import java.io.IOException;

public class InitDatabaseUser {
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
