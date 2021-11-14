import Exceptions.*;

import java.util.Objects;

public class DatabaseManager {

    private UserStorage userStorage;
    private UserCreator userCreator;

    public void signUpVerify(String name, String user_type, String username, String email, String phone, String password, String password_confirm) throws IllegalArgumentException {
        if(! password.equals(password_confirm)){
            throw new SignUpPasswordMatchException();
        }

        if(phone.length() != 10){
            throw new SignUpPhoneNumberLengthException();
        }

        if ((!user_type.equals("b")) && (!user_type.equals("s"))){
            throw new SignUpUserTypeException();
        }

        // TODO: check if username/email/phone number already exist or not
        // TODO: check if email is valid or not
    }

    public void signUp(String name, String user_type, String username, String email, String phone, String password){
        userCreator.createUser(name,user_type,username,email,phone,password);
    }

    public User loginUser(String username, String password) throws IllegalArgumentException{
        User user = userStorage.getUser(username);
        if (user == null){
            throw new LoginUserNotFoundException();
        }
        if (!user.getPassword().equals(password)){
            throw new LoginWrongPasswordException();
        }
        return user;
    }

    public DatabaseManager(){
        userStorage = new HashMapUserStorage();
        userCreator = new UserCreator(userStorage);
        userCreator.createUser("John Smith","s", "jsmith", "1234@gmail.com", "1234567890", "1234");
        CreateProperty.createProperty((Seller) userStorage.getUser("jsmith"), "6 Hoskin Avenue", "Toronto", "Ontario", "CA", "M5T 2HY", 16000F, 1000, true);
    }
}