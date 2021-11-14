import java.io.IOException;

public class InitDatabase {
    public static void main(String[] args) {
        UserStorageReadWriter userStorageReadWriter = new UserStorageReadWriter();
        HashMapUserStorage userStorage = new HashMapUserStorage();
        try {
            userStorageReadWriter.saveToFile("src/users.ser",userStorage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
