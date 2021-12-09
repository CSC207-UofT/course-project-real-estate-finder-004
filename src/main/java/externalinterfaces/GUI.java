package externalinterfaces;

import Exceptions.*;
import controllers.DatabaseManager;
import entities.Buyer;
import entities.Seller;
import entities.User;

import javax.swing.*;
import java.io.IOException;

public class GUI extends UserInterface {
    JFrame frame;

    /**
     * Constructor for the GUI class.
     * @param manager       A DatabaseManager object.
     */
    public GUI(DatabaseManager manager) {
        this.manager = manager;
    }

    @Override
    public void startWelcome() {
        this.frame = new WelcomeFrame(this);
    }

    @Override
    public void startSignUp() {
        this.frame.dispose();
        this.frame = new SignupFrame(this);
    }

    @Override
    public void startLogin() {
        this.frame.dispose();
        this.frame = new LoginFrame(this);
    }

    @Override
    public void startAfterLogin() {
        this.frame.dispose(); // Close the old frame, start the next frame:
        assert this.currUser != null;  // This should only be called after currUser is set to a specific user.
        startUser(currUser);
    }

    @Override
    public boolean loginSuccess(String username, String password) {
        try {
            this.currUser = manager.loginUser(username, password);
            return true;
        } catch (LoginUserNotFoundException | LoginWrongPasswordException e) {
            return false;
        }
    }

    @Override
    void startUser(User user) {
        if (user instanceof Seller) {
            startSeller((Seller) user);
        } else if (user instanceof Buyer) {
            startBuyer((Buyer) user);
        }
    }

    @Override
    public void startSeller(Seller seller) {
        this.frame.dispose();
        this.frame = new SellerFrame(seller, this, this.manager);
    }

    @Override
    public void startBuyer(Buyer buyer) {
        this.frame.dispose();
        this.frame = new BuyerFrame(buyer, this, this.manager);
    }

    @Override
    public void signOut() {
        this.frame.dispose();
        this.currUser = null;
        startWelcome();
    }

    public static void main(String[] args) throws IOException {
        DatabaseManager manager = new DatabaseManager();
        GUI myGui = new GUI(manager);
        myGui.runInterface();
    }
}
