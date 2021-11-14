import java.io.*;
import java.util.HashMap;

// Edits:
/*
1. Need a username
 */
public class CommandLine extends UserInterface {
    /*
     */
    private final InputStream input;
    private final UserStorage users;

    public CommandLine(InputStream input, UserStorage users) {
        this.input = input;
        this.users = users;
    }

    protected InputStream getInput() {return input; }

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

        boolean password_confirmed = password.equals(password_confirm);
        if (!password_confirmed) {
            System.out.println("Password does not match. Please enter your password again. Thanks!");
            }

        CreateUser myCreateUser = new CreateUser(users);
        myCreateUser.createSeller(name, username, email, phone, password);
        System.out.println("Thank you for signing up, " + name + ", please login to begin");
    }

    public User logIn() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        System.out.println("Welcome back! Please enter your username");
        String login_username = reader.readLine();

        System.out.println("Please enter your password.");
        String login_password = reader.readLine();

        LoginUser myLogin = new LoginUser();
        User myUser = users.getUser(login_username);
        if (myUser == null) {
            System.out.println("Your username or password is not recognized, please try again.");
            return null;
        } else {
            if (myLogin.loginUser(myUser, login_password)) {
                System.out.println("Login successful!");
                return myUser;
            } else {
                System.out.println("Your username or password is not recognized, please try again.");
                return null;
            }
        }
    }

    public void chooseAfterLogin(User user) throws IOException {
        if (user instanceof Seller) {
            CommandLineSeller cLSeller = new CommandLineSeller(input, users);
            cLSeller.choicesUser((Seller) user);
        } else if (user instanceof Buyer) {
            CommandLineBuyer cLBuyer = new CommandLineBuyer(input, users);
            cLBuyer.choicesUser((Buyer) user);
        }
        chooseAfterLogin(user);
    }
}
