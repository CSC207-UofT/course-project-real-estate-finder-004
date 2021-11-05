public class CreateUser {
    private UserStorage userStorage;

    public CreateUser(UserStorage my_user_storage) {
        this.userStorage = my_user_storage;
    }

    public void createUser(String name, String username, String email, String phone, String password){
        User newUser = new User(name, username, email, phone, password);
        this.userStorage.addUser(newUser);
    }
}
