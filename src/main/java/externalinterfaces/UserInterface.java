package externalinterfaces;

import entities.User;

import java.io.IOException;

abstract class UserInterface {

    void runInterface() throws IOException {
        User userObj = null;
        while (userObj == null) {
            // First, we check if the user would like to sign up or log in.
            boolean existsAccount = choose();
            // choose() returns a boolean which, if false, takes the user to signup
            if (!existsAccount) {
                signUp();
            }
            userObj = logIn();
            // If username does not exist or password does not match, null is returned by logIn(), and another
            // iteration of the while loop occurs.
        }
        chooseAfterLogin(userObj);
    }

    abstract boolean choose() throws IOException;
    abstract void signUp() throws IOException;
    abstract User logIn() throws IOException;
    abstract void chooseAfterLogin(User user) throws IOException;

    public void logOut() throws IOException {
        runInterface();
    }

    // For sellers, they can add properties, view properties, and view messages after logging in
    // For buyers, they can search properties, shortlist properties, join entities.RealEstateAgent and send messages to
    // the seller.
}
