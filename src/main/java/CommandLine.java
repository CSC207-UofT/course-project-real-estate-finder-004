import java.io.*;
import java.util.HashMap;

// Edits:
/*
1. Need a username
 */
public class CommandLine {
    /*
     */
    private HashMap<String, User> users = new HashMap<>();

    public void createUser(User user) {
        users.put(user.getUsername(), user);
    }

    public void choose() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Sign up here!");
        // Input name
        System.out.println("Please enter your name");
        String name = reader.readLine();

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


        // Check if password matches
        //System.out.println(password.equals(password_confirm));

        boolean password_confirmed = password.equals(password_confirm);
        if (password_confirmed == false) {
            System.out.println("Password does not match. Please enter your password again. Thanks!");
            password_confirm = reader.readLine();
        }

        // Confirm of creating an account
        users.put(username, new Seller(name, username, email, phone, password));
        System.out.println("Thank you for signing up, " + name + " login to begin");


        // Call login()
        login();
    }

    public void login() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome back! Please enter your username");
        String login_username = reader.readLine();

        System.out.println("Please enter your password.");
        String login_password = reader.readLine();

        // Check if password corresponds to the right username
        if (users.containsKey(login_username) && users.get(login_username).getPassword().equals(login_password)) {
            System.out.println("Login successful!");
            chooseAfterLogin((Seller) users.get(login_username));
        } else {
            System.out.println("Your username or password is not recognized, please try again.");
            choose();
        }
    }

    public void chooseAfterLogin(Seller user) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select 1 to add a listing, select 2 to view your listings.");
        String seller_mode = reader.readLine();
        if (seller_mode.equals("1")) {
            //    public Property(String streetAddress, String city, String province, String country, String postalCode, float price, int sqft, int numberOfRoom, int numberOfBathrooms, Map amenities, Seller owner) {
            System.out.println("");



            } else{
                for (Property myProperty : user.getProperties()){
                    System.out.println("Property: ");
                    System.out.println("Address: " + myProperty.getStreetAddress() + " " + myProperty.getCity() + " " + myProperty.getProvince());
                    System.out.println(myProperty.getSqft() + " square feet");
                    System.out.println("Price: $" + myProperty.getPrice());
                }
            }
        }
    }
