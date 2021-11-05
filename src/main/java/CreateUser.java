public class CreateUser {
    private UserStorage userStorage;

    public CreateUser(UserStorage my_user_storage) {
        this.userStorage = my_user_storage;
    }

    public void createBuyer(String name, String username, String email, String phone, String password){
        User newUser = new Buyer(name, username, email, phone, password);
        this.userStorage.addUser(newUser);
    }

    public void createSeller(String name, String username, String email, String phone, String password){
        User newUser = new Seller(name, username, email, phone, password);
        this.userStorage.addUser(newUser);
    }

}
