import java.util.HashMap;

public class HashMapUserStorage implements UserStorage{
    private final HashMap<String, User> users = new HashMap<>();
    @Override
    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public User getUser(String username) {
        return users.get(username);
    }

    @Override
    public void removeUser(String username) {
        users.remove(username);
    }

    public HashMap<String, User> getUsers(){return users;}
}
