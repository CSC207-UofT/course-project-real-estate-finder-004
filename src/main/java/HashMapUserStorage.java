import java.io.Serializable;
import java.util.HashMap;

public class HashMapUserStorage implements UserStorage, Serializable {
    private static final long serialVersionUID = 4631559705365505190L;
    // Key - UserName
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

// <<<<<<< Serializable_added
    @Override
    public String toString() {
        return "HashMapUserStorage{" +
                "users=" + users.toString() +
                '}';
    }
// =======
    public HashMap<String, User> getUsers(){return users;}
// >>>>>>> main
}
