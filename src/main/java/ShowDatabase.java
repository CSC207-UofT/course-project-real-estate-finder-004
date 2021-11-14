import java.io.IOException;

public class ShowDatabase {
    public static void main(String[] args) {
        UserStorageReadWriter userStorageReadWriter = new UserStorageReadWriter();
        HashMapUserStorage userStorage = null;
        try {
            userStorage = userStorageReadWriter.readFromFile("src/users.ser");
            System.out.println(userStorage.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
