package externalinterfaces;

import Exceptions.LoginUserNotFoundException;
import Exceptions.LoginWrongPasswordException;
import controllers.DatabaseManager;
import entities.User;

import java.io.IOException;
import java.util.ArrayList;

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
        ArrayList<String> info = loginGUI.main();
        try {
            User user = manager.loginUser(info.get(0), info.get(1));
            return user;
        } catch (LoginUserNotFoundException | LoginWrongPasswordException e){
            return null;
        }
    }

    @Override
    void chooseAfterLogin(User user) throws IOException {

    }

    public static boolean loginSuccess(String username, String password) {
        return (manager.loginUser(username, password) instanceof User);
    }

}

