package externalinterfaces;

import entities.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public class HashMapUserStorage implements Storage<String, User>, Serializable {
    private static final long serialVersionUID = 4631559705365505190L;
    /**
     * Creates a new HashMap where the keys are usernames and the values are users.
     */
    private final HashMap<String, User> users = new HashMap<>();

    /**
     * Adds a user to the users HashMap.
     * @param user  user to be stored in users
     */
    @Override
    public void add(User user) {
        users.put(user.getUsername(), user);
    }

    /**
     * Returns the user associated with a given username.
     * @param username  a String which is the key of a user
     * @return  a user stored in users
     */
    @Override
    public User get(String username) {
        return users.get(username);
    }

    /**
     * Removes a username and its associated user from the users HashMap.
     * @param username    a String which is the key of a user
     */
    @Override
    public void remove(String username) {
        users.remove(username);
    }
    /**
     * @return  the keys in the users HashMap
     */
    @Override
    public Set<String> keySet(){
        return users.keySet();
    }
    /**
     * @return a String representation of the users HashMap.
     */
    @Override
    public String toString() {
        return "externalinterfaces.HashMapUserStorage{" +
                "users=" + users.toString() +
                '}';
    }

    /**
     * @return  the users HashMap
     */
    public HashMap<String, User> getUsers() {
        return users;
    }
}
