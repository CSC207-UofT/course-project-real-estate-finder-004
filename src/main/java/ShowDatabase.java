import java.io.IOException;

public class ShowDatabase {
    public static void main(String[] args) {
        StorageReadWriter userStorageReadWriter = new UserStorageReadWriter();
        HashMapUserStorage userStorage = null;
        try {
            userStorage = (HashMapUserStorage) userStorageReadWriter.readFromFile();
            System.out.println(userStorage.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
