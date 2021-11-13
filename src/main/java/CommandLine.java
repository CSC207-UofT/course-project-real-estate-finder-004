import java.io.*;
import java.util.HashMap;

// Edits:
/*
1. Need a username
 */
public class CommandLine {
    /*
     */
    private final InputStream input;
    private final UserStorage users;

    public CommandLine(InputStream input, UserStorage users) {
        this.input = input;
        this.users = users;
    }

    public void choose() throws IOException {
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
        if (!password_confirmed) {
            System.out.println("Password does not match. Please enter your password again. Thanks!");
            }

        // Confirm of creating an account
//        users.put(username, new Seller(name, username, email, phone, password));
        CreateUser myCreateUser = new CreateUser(users);
        myCreateUser.createSeller(name, username, email, phone, password);
        System.out.println("Thank you for signing up, " + name + " login to begin");


        // Call login()
        login();
    }

    public void login() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        System.out.println("Welcome back! Please enter your username");
        String login_username = reader.readLine();

        System.out.println("Please enter your password.");
        String login_password = reader.readLine();


        LoginUser myLogin = new LoginUser();
        User myUser = users.getUser(login_username);
        if (myUser == null) {
            System.out.println("Your username or password is not recognized, please try again.");
            choose();
        } else {
            if (myLogin.loginUser(myUser, login_password)) {
                System.out.println("Login successful!");
                chooseAfterLogin((Seller) users.getUser(login_username));
            } else {
                System.out.println("Your username or password is not recognized, please try again.");
                choose();
            }
        }
    }

    public void chooseAfterLogin(Seller user) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        System.out.println("Select 1 to add a listing, select 2 to view your listings. You have"
                + user.noOfUnreadMessages() + "unread messages. Select 3 to view your messages.");
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
        } else if (seller_mode.equals("2")) {
            System.out.println(ListProperties.getListOfProperties(user));
        } else if (seller_mode.equals("3")) {
            if (user.noOfUnreadMessages() == 0) {
                System.out.println("You have no unread messages.");
            } else {
                System.out.println(user.getUnreadMessagesString(user.getUnreadMessages()));
                System.out.println("Enter the corresponding message number if you would like to mark it as read.");
                int messageNumber = Integer.parseInt(reader.readLine());
                user.messageRead(user.getUnreadMessages().get(messageNumber - 1));
            } // May be violating single responsibility principle, look into it later.
        }
        chooseAfterLogin(user);
    }
}
