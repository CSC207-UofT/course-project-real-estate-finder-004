import java.io.IOException;

public class ShowDatabase {
    public static void main(String[] args) {
        StorageReadWriter userStorageReadWriter = new UserStorageReadWriter(null);
        HashMapUserStorage userStorage = null;
        try {
            userStorage = (HashMapUserStorage) userStorageReadWriter.readFromFile();
            System.out.println(userStorage.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        StorageReadWriter propertyStorageReadWriter = new PropertyStorageReadWriter(null);
        HashMapPropertyStorage propertyStorage = null;
        try {
            propertyStorage = (HashMapPropertyStorage) propertyStorageReadWriter.readFromFile();
            System.out.println(propertyStorage.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}