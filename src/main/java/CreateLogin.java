import java.io.*;

public class CreateLogin {
    public void choose(String choice) throws IOException {
        if (choice.equals("1")) {
            signup();
        } else {
            login();
        }
    }

    public void signup(String name, String username, String email, String phone, String password,
                       String password_confirm, boolean password_confirmed, Seller users) throws IOException {
        password_confirmed = password.equals(password_confirm);
        if (password_confirmed == false) {
            // When signing up, check if password entered are the same (twice)
//            System.out.println("Password does not match. Please enter your password again. Thanks!");
//            password_confirm = reader.readLine();
        }

        // ???
        // Confirm of creating an account

        // Call login()
        login(String login_username, String login_password, Seller users);
    }

    //???
    public void login(String login_username, String login_password, Seller users) throws IOException {
        // Check if password corresponds to the right username
        if (users.containsKey(login_username) && users.get(login_username).getPassword().equals(login_password)) {
            System.out.println("Login successful!");
            chooseAfterLogin((Seller) users.get(login_username));
        } else {
            System.out.println("Your username or password is not recognized, please try again.");
            choose();
        }
    }

    public void chooseAfterLogin(Seller user, String seller_mode, String streetAddress, String city, String province,
                                 String country, String postalCOde, String price, int sqft) throws IOException {
            // Property property = new Property(streetAddress, city, province, country, postalCode, price, sqft, user);
            //user.addProperty(property);
            }
        //chooseAfterLogin(user);
}
