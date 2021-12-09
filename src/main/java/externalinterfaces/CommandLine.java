package externalinterfaces;

import Exceptions.LoginUserNotFoundException;
import Exceptions.LoginWrongPasswordException;
import Exceptions.SignUpPasswordMatchException;
import Exceptions.SignUpPhoneNumberLengthException;
import controllers.DatabaseManager;
import entities.Buyer;
import entities.Seller;
import entities.User;

import java.io.*;

public class CommandLine extends UserInterface {
    final InputStream input;

    /**
     * Constructor for the Commandline class
     * @param input         An InputStream object for taking in inputs from the command line.
     * @param manager       A DatabaseManager object.
     */
    public CommandLine(InputStream input, DatabaseManager manager) {
        this.input = input;
        this.manager = manager;
    }

    @Override
    public void startWelcome() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        System.out.println("Hi! If you would like to signup, please type in 1. If you would like to login, " +
                "please type in 2.");
        String choice = reader.readLine();

        if (choice.equals("1")) {
            startSignUp();
        } else if (choice.equals("2")) {
            startLogin();
        }
    }

    @Override
    public void startSignUp() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        System.out.println("Sign up here!");

        // Input name
        System.out.println("Please enter your name");
        String name = reader.readLine();

        // Input user type
        System.out.println("Are you a buyer (B) or seller (S)? Please enter B/S");
        String user_type = reader.readLine().toLowerCase();

        //Input username
        System.out.println("Please enter your username");
        String username = reader.readLine();

        // Input email
        System.out.println("Please enter your email");
        String email = reader.readLine();

        // Input phone
        System.out.println("Please enter your phone number");
        String phone = reader.readLine();

        // Input password
        System.out.println("To create this account, please enter your password");
        String password = reader.readLine();

        // To confirm the password
        System.out.println("Please enter your password again for confirmation");
        String password_confirm = reader.readLine();

        try {
            // Verify info
            manager.signUpVerify(name, user_type, username, email , phone, password, password_confirm);
            manager.signUp(name, user_type, username, email, phone, password);
            System.out.println("Thank you for signing up, " + name + " login to begin");
            startLogin();
        } catch (SignUpPasswordMatchException | SignUpPhoneNumberLengthException e) {
            System.out.println(e.getMessage());
            startWelcome();
        }
    }

    @Override
    public void startLogin() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        System.out.println("Welcome back! Please enter your username");
        String loginUsername = reader.readLine();

        System.out.println("Please enter your password.");
        String loginPassword = reader.readLine();

        if (loginSuccess(loginUsername, loginPassword)) {
            startAfterLogin();
        } else {
            System.out.println("Invalid Username or Password");
            startWelcome();
        }
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
    void signOut() throws IOException {
        this.currUser = null;
        startWelcome();
    }

    @Override
    public void startAfterLogin() throws IOException {
        assert this.currUser != null;  // This should only be called after currUser is set to a specific user.
        startUser(currUser);
    }

    @Override
    public void startUser(User user) throws IOException {
        if (user instanceof Seller) {
            startSeller((Seller) user);
        } else if (user instanceof Buyer) {
            startBuyer((Buyer) user);
        }
    }

    @Override
    void startSeller(Seller seller) throws IOException {
        CommandLineSeller cLSeller = new CommandLineSeller(input,manager);
        cLSeller.choicesUser(seller);
    }

    @Override
    void startBuyer(Buyer buyer) throws IOException {
        CommandLineBuyer cLBuyer = new CommandLineBuyer(input, manager);
        cLBuyer.choicesUser(buyer);
    }
}
