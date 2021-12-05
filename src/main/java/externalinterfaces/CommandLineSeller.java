package externalinterfaces;

import controllers.DatabaseManager;
import controllers.PropertyViewer;
import entities.Seller;
import externalinterfaces.CommandLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CommandLineSeller extends CommandLine {
    private Seller currUser;

    public CommandLineSeller(InputStream input, DatabaseManager manager) {
        super(input, manager);
    }

    public void choicesUser(Seller user) throws IOException {
        this.currUser = user;
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.input));

        System.out.println("Select 1 to add a listing, select 2 to view your listings. You have"
                + user.noOfUnreadMessages() + "unread messages. Select 3 to view your messages. " +
                "Select 4 to log out");
        String sellerMode = reader.readLine();
        switch (sellerMode) {
            case "1":
                addListing(reader, user);
                choicesUser(user);
                break;
            case "2":
                ArrayList<Integer> sellerPropertiesListed = user.getProperties();
                System.out.println(manager.propertiesToString(sellerPropertiesListed));
                removeProperty(sellerPropertiesListed);
                break;
            case "3":
                checkMessages(reader, user);
                choicesUser(currUser);
                break;
            case "4":
                logOut();
                break;
        }
    }

    private void removeProperty(ArrayList<Integer> sellerProperties) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.input));
        System.out.println("If you would like to remove a property, please input the corresponding property" +
                " number. To go back to the main menu, please input 'main'.");
        String sellerChoice = reader.readLine();
        int propertyChoice = 0;
        if (sellerChoice.equals("main")) {
            choicesUser(currUser);
        } else {
            try {
                propertyChoice = Integer.parseInt(sellerChoice);
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid input");
                removeProperty(sellerProperties);
            }
        }
        propertyChoice--;
        Integer removePropertyId = sellerProperties.get(propertyChoice);
        currUser.removeProperty(removePropertyId);
        System.out.println("Property successfully removed!");
        choicesUser(currUser);
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

        manager.addProperty(user, streetAddress, city, province, country, postalCode, price, sqft, false);
        System.out.println("Property successfully added!");
    }

    public void checkMessages(BufferedReader reader, Seller user) throws IOException {
        if (user.noOfUnreadMessages() == 0) {
            System.out.println("You have no unread messages.");
        } else {
            System.out.println(user.getUnreadMessagesString(user.getUnreadMessages()));
            System.out.println("Enter the corresponding message number if you would like to mark it as read.");
            int messageNumber = Integer.parseInt(reader.readLine());
            user.messageRead(user.getUnreadMessages().get(messageNumber - 1));
        }
    }
}
