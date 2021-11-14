public class UserCreator {
    private UserStorage userStorage;

    public UserCreator(UserStorage my_user_storage) {
        this.userStorage = my_user_storage;
    }

    public void createUser(String name, String user_type, String username, String email, String phone, String password){
        User newUser;
        switch (user_type){
            case "b":
                newUser = new Buyer(name, username, email, phone, password);
                this.userStorage.addUser(newUser);
                break;
            case "s":
                newUser = new Seller(name, username, email, phone, password);
                this.userStorage.addUser(newUser);
                break;
        }
    }
}
