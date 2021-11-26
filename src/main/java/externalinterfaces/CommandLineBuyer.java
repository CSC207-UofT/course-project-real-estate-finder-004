package externalinterfaces;

import controllers.DatabaseManager;
import entities.Buyer;
import externalinterfaces.CommandLine;

import java.io.InputStream;

public class CommandLineBuyer extends CommandLine {

    public CommandLineBuyer(InputStream input, DatabaseManager manager) {
        super(input, manager);
    }

    public void choicesUser(Buyer user) {
        // TODO: to be implemented
    }

}
