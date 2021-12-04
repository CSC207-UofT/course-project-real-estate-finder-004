package externalinterfaces;

import Exceptions.LoginUserNotFoundException;
import Exceptions.LoginWrongPasswordException;
import controllers.DatabaseManager;
import entities.Buyer;
import entities.User;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class GUI extends UserInterface {
    public DatabaseManager manager;
    private User currUser;
    boolean loginFrameActive = false;
    loginGUI frame;

    public GUI(DatabaseManager manager) {
        this.manager = manager;
        this.frame = new loginGUI(this);
    }

    @Override
    boolean choose() {
        if (!this.loginFrameActive) {
            this.frame.start();
            this.loginFrameActive = true;
        }
        return false; // TODO: to be implemented
    }

    @Override
    void signUp() throws IOException {
        // TODO: to be implemented
    }

    @Override
    User logIn() throws IOException {
        return this.currUser;
    }

    @Override
    void chooseAfterLogin(User user) throws IOException {

    }

    public boolean loginSuccess(String username, String password) {
        try {
            this.currUser = manager.loginUser(username, password);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        DatabaseManager manager = new DatabaseManager();
        GUI myGui = new GUI(manager);
        myGui.runInterface();
    }

    public void startAfterLogin() {
        this.frame.close(); // Close the old frame, start the next frame:
        assert this.currUser != null;  // This should only be called after currUser is set to a specific user.
        if (this.currUser instanceof Buyer) {
            // Call the BuyerGUI file to start stuff.
        } else {
            // Call the SellerGUI to start stuff.
        }
    }
}

