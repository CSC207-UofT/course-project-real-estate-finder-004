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
        if (seller_mode.equals("1")) {
            searchProperties();
        } else if (seller_mode.equals("2")) {
            viewInterestedProperties(user);
        } else if (seller_mode.equals("3")) {
            logOut();
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

        Float minPrice = Float.parseFloat(minPriceStr);
        Float maxPrice = Float.parseFloat(maxPriceStr);
        Integer minSqft = Integer.parseInt(minSqftStr);
        Integer maxSqft = Integer.parseInt(maxSqftStr);
        Integer noOfRooms = Integer.parseInt(noOfRoomsStr);
        Integer noOfBathrooms = Integer.parseInt(noOfBathroomsStr);
        ArrayList<Integer> filteredProperties = manager.searchProperties(postalCode, minPrice, maxPrice,
                minSqft, maxSqft, noOfRooms, noOfBathrooms);
        System.out.println(manager.propertiesToString(filteredProperties));
        System.out.println("To view more information about a particular property, please type in the corresponding" +
                "property number. To go back to the main menu, please input 'main'");
        String nextInput = reader.readLine();
        if (nextInput.equals("main")) {
            choicesUser(currUser);
        } else {
            viewSpecificProperty(nextInput, filteredProperties);
        }
    }

    public void viewSpecificProperty(String nextInput, ArrayList<Integer> filteredProperties) {
        Integer propertyChoice = Integer.parseInt(nextInput);
        propertyChoice = propertyChoice - 1;
        Integer chosenPropertyId = filteredProperties.get(propertyChoice);
        System.out.println(manager.specificPropertyToString(chosenPropertyId));
        System.out.println("If you would like to shortlist this property, please input 's'. If you would" +
                "like to contact the owner, please input 'c'. If you would like to view another property, " +
                "please input the relevant property number. If you would like to go back to the main menu, " +
                "please input 'main'.");

    }

    public void viewInterestedProperties(Buyer user) {
        // somehow get the property object OR the string representation of the property from the Property Storage
        // probably violating clean architecture because there should be a controller PropertyViewer that
        // can return string representation of properties given propertyIDs
        System.out.println(manager.propertiesToString(user.getInterestedProperties()));
        // still need to offer options on choosing individual properties, seeing more information and potentially
        // joining making the offer (by joining the real estate agent)
    }

}
