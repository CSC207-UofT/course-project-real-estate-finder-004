public class LoginUser {
    public boolean loginUser(User user, String password){
        return user.getPassword().equals(password);
    }
}
