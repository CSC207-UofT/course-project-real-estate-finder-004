import Exceptions.LoginUserNotFoundException;
import Exceptions.LoginWrongPasswordException;
import Exceptions.SignUpPasswordMatchException;
import Exceptions.SignUpPhoneNumberLengthException;

import java.io.*;

// Edits:
/*
1. Need a username
 */
public class CommandLine extends UserInterface {
    /*
     */
    private final InputStream input;
    private final DatabaseManager manager;

    public CommandLine(InputStream input, DatabaseManager manager) {
        this.input = input;
        this.manager = manager;
    }

    protected InputStream getInput() { return input; }

    public boolean choose() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        System.out.println("Hi! If you would like to signup, please type in 1. If you would like to login, " +
                "please type in 2.");

        String choice = reader.readLine();

        return !choice.equals("1");
    }

    public void signUp() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        System.out.println("Sign up here!");

        // Input name
        System.out.println("Please enter your name");
        String name = reader.readLine();

        // Input user type
        System.out.println("Are you a buyer or seller? enter B/S");
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

        // Input password"
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
        } catch (SignUpPasswordMatchException | SignUpPhoneNumberLengthException e) {
            System.out.println(e.getMessage());
            choose();
        }
    }

    public User logIn() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        System.out.println("Welcome back! Please enter your username");
        String login_username = reader.readLine();

        System.out.println("Please enter your password.");
        String login_password = reader.readLine();

        try {
            User user = manager.loginUser(login_username, login_password);
            System.out.println("Login successful!");
            return user;
        } catch (LoginUserNotFoundException | LoginWrongPasswordException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void chooseAfterLogin(User user) throws IOException {
        if (user instanceof Seller) {
            CommandLineSeller cLSeller = new CommandLineSeller(input,manager);
            cLSeller.choicesUser((Seller) user);
        } else if (user instanceof Buyer) {
            CommandLineBuyer cLBuyer = new CommandLineBuyer(input, manager);
            cLBuyer.choicesUser((Buyer) user);
        }
    }
}
