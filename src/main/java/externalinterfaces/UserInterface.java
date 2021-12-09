package externalinterfaces;

import Exceptions.*;
import controllers.DatabaseManager;
import entities.Buyer;
import entities.Seller;
import entities.User;

import java.io.IOException;

abstract class UserInterface {
    public DatabaseManager manager;
    public User currUser;

    void runInterface() throws IOException {
        startWelcome();
    }

    abstract void startWelcome() throws IOException;
    abstract void startSignUp() throws IOException;
    abstract void startLogin() throws IOException;
    abstract void startAfterLogin() throws IOException;
    abstract void startUser(User user) throws IOException;
    abstract void startSeller(Seller seller) throws IOException;
    abstract void startBuyer(Buyer buyer) throws IOException;
    abstract boolean loginSuccess(String username, String password);

    public boolean signUpSuccess(String name, String userType, String username, String email, String phone, String password, String passwordConfirm) {
        try {
            manager.signUpVerify(name, userType, username, email, phone, password, passwordConfirm);
            manager.signUp(name, userType, username, email, phone, password);
            startLogin();
        } catch (SignUpPasswordMatchException | SignUpPhoneNumberLengthException | SignUpUserTypeException | IOException e) {
            return false;
        }
        return true;
    }

    public void logOut() throws IOException {
        runInterface();
    }

    // For sellers, they can add properties, view properties, and view messages after logging in
    // For buyers, they can search properties, shortlist properties, send messages to the seller.

    // Old stuff:
    //        User userObj = null;
//        while (userObj == null) {
//            // First, we check if the user would like to sign up or log in.
//            boolean existsAccount = choose();
//            // choose() returns a boolean which, if false, takes the user to signup
//            if (!existsAccount) {
//                signUp();
//            }
//            userObj = logIn();
//            // If username does not exist or password does not match, null is returned by logIn(), and another
//            // iteration of the while loop occurs.
//        }
//        chooseAfterLogin(userObj);


}
