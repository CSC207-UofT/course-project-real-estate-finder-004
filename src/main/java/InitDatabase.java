import java.io.IOException;

public class InitDatabase {
    public static void main(String[] args) {
        StorageReadWriter userStorageReadWriter = new UserStorageReadWriter();
        HashMapUserStorage userStorage = new HashMapUserStorage();
        try {
            userStorageReadWriter.saveToFile(userStorageReadWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
