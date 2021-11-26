package externalinterfaces;

import entities.User;

import java.io.Serializable;
import java.util.HashMap;

public class HashMapUserStorage implements Storage<String, User>, Serializable {
    private static final long serialVersionUID = 4631559705365505190L;
    // Key - UserName
    private final HashMap<String, User> users = new HashMap<>();

    @Override
    public void add(User user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public User get(String username) {
        return users.get(username);
    }

    @Override
    public void remove(String username) {
        users.remove(username);
    }

    @Override
    public String toString() {
        return "externalinterfaces.HashMapUserStorage{" +
                "users=" + users.toString() +
                '}';
    }

    public HashMap<String, User> getUsers() {
        return users;
    }
}
