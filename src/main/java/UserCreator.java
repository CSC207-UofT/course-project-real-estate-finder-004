import java.io.IOException;

public class UserCreator extends Creator {

    public UserCreator(HashMapUserStorage userStorage, UserStorageReadWriter userStorageReadWriter, HashMapPropertyStorage propertyStorage, PropertyStorageReadWriter propertyStorageReadWriter) {
        super(userStorage, userStorageReadWriter, propertyStorage, propertyStorageReadWriter);
    }

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
            if(writeToFile) {
                try {
                    userStorageReadWriter.saveToFile();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
