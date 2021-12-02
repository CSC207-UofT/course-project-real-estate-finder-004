package externalinterfaces;

import controllers.DatabaseManager;
import controllers.PropertyViewer;
import entities.Buyer;
import externalinterfaces.CommandLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommandLineBuyer extends CommandLine {

    public CommandLineBuyer(InputStream input, DatabaseManager manager) {
        super(input, manager);
    }

    public void choicesUser(Buyer user) throws IOException {
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

    public void searchProperties() {
        // TODO: to be implemented
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
