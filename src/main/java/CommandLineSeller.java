import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommandLineSeller extends CommandLine {

    public CommandLineSeller(InputStream input, UserStorage users) {
        super(input, users);
    }

    public void choicesUser(Seller user) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(super.getInput()));

        System.out.println("Select 1 to add a listing, select 2 to view your listings. You have"
                + user.noOfUnreadMessages() + "unread messages. Select 3 to view your messages. " +
                "Select 4 to log out");
        String seller_mode = reader.readLine();
        if (seller_mode.equals("1")) {
            addListing(reader, user);
        } else if (seller_mode.equals("2")) {
            System.out.println(ListProperties.getListOfProperties(user));
        } else if (seller_mode.equals("3")) {
            checkMessages(reader, user);
        } else if (seller_mode.equals("4")) {
            logOut();
        }
    }

    public void addListing(BufferedReader reader, Seller user) throws IOException {
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
    }

    public void checkMessages(BufferedReader reader, Seller user) throws IOException {
        if (user.noOfUnreadMessages() == 0) {
            System.out.println("You have no unread messages.");
        } else {
            System.out.println(user.getUnreadMessagesString(user.getUnreadMessages()));
            System.out.println("Enter the corresponding message number if you would like to mark it as read.");
            int messageNumber = Integer.parseInt(reader.readLine());
            user.messageRead(user.getUnreadMessages().get(messageNumber - 1));
        } // May be violating single responsibility principle, look into it later.
    }
}
