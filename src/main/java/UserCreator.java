import java.io.IOException;

public class UserCreator {
    private UserStorage userStorage;
    private StorageReadWriter readWriter;

    public UserCreator(UserStorage userStorage, StorageReadWriter readWriter) {
        this.userStorage = userStorage;
        this.readWriter = readWriter;
    }

    public void createUser(String name, String user_type, String username, String email, String phone, String password){
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
            this.userStorage.addUser(newUser);
            try {
                readWriter.saveToFile(userStorage);
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
