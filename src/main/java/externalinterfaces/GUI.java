package externalinterfaces;

import Exceptions.SignUpPasswordMatchException;
import Exceptions.SignUpPhoneNumberLengthException;
import Exceptions.SignUpUserTypeException;
import controllers.DatabaseManager;
import entities.User;

import java.io.IOException;

public class GUI extends UserInterface {
    static DatabaseManager manager;

    public GUI(DatabaseManager manager) {
        this.manager = manager;
    }

    @Override
    boolean choose() throws IOException {
        return false; // TODO: to be implemented
    }

    @Override
    void signUp() throws IOException {
        // TODO: to be implemented
    }

    @Override
    User logIn() throws IOException {
        loginGUI.main();
        return null;
    }

    @Override
    void chooseAfterLogin(User user) throws IOException {

    }

    public static boolean loginSuccess(String username, String password) {
        return (manager.loginUser(username, password) instanceof User);
    }

    public static boolean signUpSuccess(String name, String userType, String username, String email, String phone, String password, String passwordConfirm) {
    try {
        manager.signUpVerify(name, userType, username, email, phone, password, passwordConfirm);
        manager.signUp(name, userType, username, email, phone, password);
        return true;
    } catch (SignUpPasswordMatchException| SignUpPhoneNumberLengthException | SignUpUserTypeException e) {
        return false;
        }
    }
}

