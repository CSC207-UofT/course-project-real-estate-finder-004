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

    /**
     * Calling this function from the GUI or CommandLine child class will run the respective interface.
     * @throws IOException BufferedReader used in CommandLine throws an IOException
     */
    void runInterface() throws IOException {
        startWelcome();
    }

    /**
     * startWelcome calls the welcome interface for the respective UI.
     * @throws IOException  BufferedReader used in CommandLine throws an IOException
     */
    abstract void startWelcome() throws IOException;

    /**
     * startSignUp runs the signup interface for the respective UI.
     * @throws IOException BufferedReader used in CommandLine throws an IOException
     */
    abstract void startSignUp() throws IOException;

    /**
     * startLogin runs the login interface for the respective UI.
     * @throws IOException BufferedReader used in CommandLine throws an IOException
     */
    abstract void startLogin() throws IOException;

    /**
     * startAfterLogin checks whether the currUser is not null and then calls the startAfterLogin method.
     * @throws IOException BufferedReader used in CommandLine throws an IOException
     */
    abstract void startAfterLogin() throws IOException;

    /**
     * startUser checks what type of object user is (Seller or Buyer) and then calls the respective method that
     * will provide the user will choices.
     *
     * @param user              The user object for which the program will run.
     * @throws IOException BufferedReader used in CommandLine throws an IOException
     */
    abstract void startUser(User user) throws IOException;

    /**
     * startSeller provides the seller with choices of what to do.
     * Sellers can add properties, view properties, view unread messages or log out.
     *
     * @param seller        The current seller object
     * @throws IOException BufferedReader used in CommandLine throws an IOException
     */
    abstract void startSeller(Seller seller) throws IOException;

    /**
     * startBuyer provides the buyer with a menu of options.
     * Buyers can search for properties, shortlist properties, contact the seller (for purchasing) or log out.
     *
     * @param buyer         The current buyer object. 
     * @throws IOException BufferedReader used in CommandLine throws an IOException
     */
    abstract void startBuyer(Buyer buyer) throws IOException;

    /**
     * loginSuccess checks whether the username input by the user exists in the database and whether the
     * password input corresponds to the one stored in the database.
     *
     * @param username      The username input by the user.
     * @param password      The password input by the user.
     * @return              True if the username exists and password corresponds. False otherwise
     */
    abstract boolean loginSuccess(String username, String password);

    /**
     * Logs the current user out by calling runInterface()
     * @throws IOException BufferedReader used in CommandLine throws an IOException
     */
    abstract void signOut() throws IOException;
    /**
     * This function checks whether first, the information input by the users is valid and if so, creates a user
     * object and adds it to the database. It outputs true if the user has been signed up successfully and false
     * if not.
     *
     * @param name              The user's given name.
     * @param userType          The type of account the user wishes to create.
     * @param username          The user's username, which will be used for authentication. Note that this must be unique for all users.
     * @param email             The user's email, for getting in contact with the buyers.
     * @param phone             The user's phone number, for getting in contact with the buyers.
     * @param password          The user's password, used for authentication.
     * @param passwordConfirm   The user's password re-typed for validation.
     * @return                  True if the user has been signed up successfully, false if not.
     */
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
}
