package externalinterfaces;

import Exceptions.SignUpPasswordMatchException;
import Exceptions.SignUpPhoneNumberLengthException;
import Exceptions.SignUpUserTypeException;
import controllers.DatabaseManager;
import entities.Buyer;
import entities.Seller;
import entities.User;

import javax.swing.*;
import java.io.IOException;

public class GUI extends UserInterface {
    public DatabaseManager manager;
    User currUser;
    JFrame frame;

    @Override
    void runInterface() {
        startWelcomeGui();
    }

    public void startWelcomeGui() {
        this.frame = new WelcomeFrame(this);
    }

    public void startSignUp(){
        this.frame.dispose();
        this.frame = new SignupFrame(this);
    }

    public void startLogin() {
        this.frame.dispose();
        this.frame = new LoginFrame(this);
    }

    public void startUser(User user){
        if(user instanceof Seller) {
            startSeller((Seller) user);
        } else if (user instanceof Buyer) {
            startBuyer((Buyer) user);
        }
    }

    public void startSeller(Seller seller){
        this.frame.dispose();
        this.frame = new SellerFrame(seller, this, this.manager);
    }

    public void startBuyer(Buyer buyer){
        // TODO: Implement
    }


    public GUI(DatabaseManager manager) {
        this.manager = manager;
//        this.frame = new WelcomeFrame(this);
    }

    public void signOut(){
        this.frame.dispose();
        this.currUser = null;
        this.frame = new WelcomeFrame(this);
    }

    @Override
    boolean choose() {
//        if (hasChosen) {
//            return choseLogin;
//        } else {
//            return false;
//        }
////        if (!this.loginFrameActive) {
////
////            this.loginFrameActive = true;
////        }
       return false; // TODO: to be implemented
    }

    @Override
    void signUp() throws IOException {
//        if (hasChosen) {
//            if (!signupFrameActive) {
//                this.frame = new SignupFrame(this);
//                signupFrameActive  = true;
//            }
//
//        }
    }

    @Override
    User logIn() throws IOException {
//        if (hasChosen) {
//            return this.currUser;
//
//        } else {
            return null;
//        }
    }

    @Override
    void chooseAfterLogin(User user) throws IOException {
    }

    public void doAfterChoose(boolean loginChosen) {
//        hasChosen = true;
//        this.choseLogin = loginChosen;
    }

    public boolean signUpSuccess(String name, String userType, String username, String email, String phone, String password, String passwordConfirm) {
        try {
            manager.signUpVerify(name, userType, username, email, phone, password, passwordConfirm);
            manager.signUp(name, userType, username, email, phone, password);
            startLogin();
        } catch (SignUpPasswordMatchException | SignUpPhoneNumberLengthException | SignUpUserTypeException e) {
            // TODO: Add error message.
            return false;
        }
        return true;
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
        this.frame.dispose(); // Close the old frame, start the next frame:
        assert this.currUser != null;  // This should only be called after currUser is set to a specific user.
        startUser(currUser);
    }
}
