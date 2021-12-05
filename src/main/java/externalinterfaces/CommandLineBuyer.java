package externalinterfaces;

import controllers.DatabaseManager;
import controllers.PropertyViewer;
import entities.Buyer;
import entities.User;
import externalinterfaces.CommandLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Integer.*;

public class CommandLineBuyer extends CommandLine {
    private Buyer currUser = null;

    public CommandLineBuyer(InputStream input, DatabaseManager manager) {
        super(input, manager);
    }

    public void choicesUser(Buyer user) throws IOException {
        this.currUser = user;
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.input));

        System.out.println("Select 1 to search for properties, select 2 to view your shortlisted properties." +
                "Select 3 to log out");
        String seller_mode = reader.readLine();
        switch (seller_mode) {
            case "1":
                searchProperties();
                break;
            case "2":
                viewInterestedProperties(user);
                break;
            case "3":
                logOut();
                break;
        }
    }

    public void searchProperties() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.input));

        System.out.println("Please input a postal code. Please input 'NA' (without the quotations) if you would" +
                "not like to filter by postal code.");
        String postalCode = reader.readLine();
        System.out.println("Please input the maximum price. Please input 'NA' (without quotations) if you would" +
                "not like to filter by maximum price.");
        String minPriceStr = reader.readLine();
        System.out.println("Please input the minimum price. Please input 'NA' (without quotations) if you would" +
                "not like to filter by minimum price.");
        String maxPriceStr = reader.readLine();
        System.out.println("Please input the minimum square feet. Please input 'NA' (without quotations) if you" +
                "would not like to filter by minimum square feet.");
        String minSqftStr = reader.readLine();
        System.out.println("Please input the maximum square feet. Please input 'NA' (without quotations) if you" +
                "would not like to filter by maximum square feet.");
        String maxSqftStr = reader.readLine();
        System.out.println("Please input the number of rooms. Please input 'NA' (without quotations) if you " +
                        "would not like to filter by the number of rooms in the property.");
        String noOfRoomsStr = reader.readLine();
        System.out.println("Please input the number of bathrooms. Input 'NA' (without quotations) if you " +
                        "would not like to filter by the number of bathrooms in the property.");
        String noOfBathroomsStr = reader.readLine();

        if (postalCode.equals("NA")) {
            postalCode = null;
        }

        float minPrice;
        if (minPriceStr.equals("NA")) {
            minPrice = -1.0f;
        } else {
            minPrice = Float.parseFloat(minPriceStr);
        }
        float maxPrice;
        if (maxPriceStr.equals("NA")) {
            maxPrice = -1.0f;
        } else {
            maxPrice = Float.parseFloat(maxPriceStr);
        }
        int minSqft;
        if (minSqftStr.equals("NA")) {
            minSqft = -1;
        } else {
            minSqft = parseInt(minSqftStr);
        }
        int maxSqft;
        if (maxSqftStr.equals("NA")) {
            maxSqft = -1;
        } else {
            maxSqft = parseInt(maxSqftStr);
        }
        int noOfRooms;
        if (noOfRoomsStr.equals("NA")) {
            noOfRooms = -1;
        } else {
            noOfRooms = parseInt(noOfRoomsStr);
        }
        int noOfBathrooms;
        if (noOfBathroomsStr.equals("NA")) {
            noOfBathrooms = -1;
        } else {
            noOfBathrooms = parseInt(noOfBathroomsStr);
        }
        ArrayList<Integer> filteredProperties = manager.searchProperties(postalCode, minPrice, maxPrice,
                minSqft, maxSqft, noOfRooms, noOfBathrooms);
        System.out.println(manager.propertiesToString(filteredProperties));
        viewSpecificProperty(filteredProperties);
    }

    public void viewSpecificProperty(ArrayList<Integer> filteredProperties) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.input));
        System.out.println("To view more information about a particular property, please type in the corresponding" +
                "property number. To go back to the main menu, please input 'main'");
        String nextInput = reader.readLine();
        int propertyChoice = 0;
        if (nextInput.equals("main")) {
            choicesUser(currUser);
        } else {
            try {
                propertyChoice = Integer.parseInt(nextInput);
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid input");
                viewSpecificProperty(filteredProperties);
            }
        }
        propertyChoice--;
        Integer chosenPropertyId = filteredProperties.get(propertyChoice);
        System.out.println(manager.specificPropertyToString(chosenPropertyId));
        System.out.println("If you would like to shortlist this property, please input 's'. If you would" +
                "like to contact the owner, please input 'c'. If you would like to view another property, " +
                "please input 'p'. If you would like to go back to the main menu, " +
                "please input 'main'.");
        String newInput = reader.readLine();
        switch (newInput) {
            case "s":
                currUser.shortListProperty(chosenPropertyId);
                break;
            case "c":
                System.out.println("You can send a custom message to the owner of the property! Please input your " +
                        "message here");
                String customMessage = reader.readLine();
                manager.joinRealEstateAgent(chosenPropertyId, currUser.getUsername(), customMessage);
                break;
            case "main":
                choicesUser(currUser);
                break;
            default:
                viewSpecificProperty(filteredProperties);
                break;
        }
    }

    public void viewInterestedProperties(Buyer user) throws IOException {
        ArrayList<Integer> myProperties = user.getInterestedProperties();
        System.out.println(manager.propertiesToString(myProperties));
        viewSpecificProperty(myProperties);
    }

}
