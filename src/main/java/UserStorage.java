public interface UserStorage {
    void addUser(User user);
    void removeUser(String username);
    User getUser(String username);
}
