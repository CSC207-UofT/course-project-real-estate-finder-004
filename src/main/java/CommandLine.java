import Exceptions.LoginUserNotFoundException;
import Exceptions.LoginWrongPasswordException;
import Exceptions.SignUpPasswordMatchException;
import Exceptions.SignUpPhoneNumberLengthException;

import java.io.*;

// Edits:
/*
1. Need a username
 */
public class CommandLine {
    /*
     */
    private final InputStream input;
    private final DatabaseManager manager;

    public CommandLine(InputStream input, DatabaseManager manager) {
        this.input = input;
        this.manager = manager;
    }

    public void main_menu() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        System.out.println("Hi! If you would like to signup, please type in 1. If you would like to login, " +
                "please type in 2.");

        String choice = reader.readLine();

        if (choice.equals("1")) {
            signup();
        } else {
            login();
        }
    }

    public void signup() throws IOException {
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

        // Input password\n"
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

            // Call login()
            login();
        } catch (SignUpPasswordMatchException | SignUpPhoneNumberLengthException e) {
            System.out.println(e.getMessage());
            main_menu();
        }
    }

    public void login() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        System.out.println("Welcome back! Please enter your username");
        String login_username = reader.readLine();

        System.out.println("Please enter your password.");
        String login_password = reader.readLine();

        try {
            User user = manager.loginUser(login_username, login_password);
            System.out.println("Login successful!");
            after_login_menu(user);
        } catch (LoginUserNotFoundException | LoginWrongPasswordException e){
            System.out.println(e.getMessage());
            main_menu();
        }
    }

    public void after_login_menu(User user) throws IOException{
        // TODO must check if it's seller or buyer and then show the appropriate menu
        after_login_menu_seller((Seller) user);
    }

    public void after_login_menu_seller(Seller user) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        System.out.println("Select 1 to add a listing, select 2 to view your listings.");
        String seller_mode = reader.readLine();
        if (seller_mode.equals("1")) {
            System.out.println("Enter Street Address:");
            String streetAddress = reader.readLine();
            System.out.println("Enter City:");
            String city = reader.readLine();
            System.out.println("Enter Province:");
            String province = reader.readLine();
            System.out.println("Enter Country:");
            String country = reader.readLine();
            System.out.println("Enter Postal Code:");
            String postalCode = reader.readLine();
            System.out.println("Enter Price:");
            float price = Float.parseFloat(reader.readLine());
            System.out.println("Enter Street Total Square Feet:");
            int sqft = Integer.parseInt(reader.readLine());

            CreateProperty.createProperty(user, streetAddress, city, province, country, postalCode, price, sqft, false);
        } else {
            System.out.println(ListProperties.getListOfProperties(user));
        }
        after_login_menu(user);
    }
}
