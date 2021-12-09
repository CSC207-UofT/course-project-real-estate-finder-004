package externalinterfaces;

import controllers.DatabaseManager;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;

public class RunGUI {
    public static void main(String[] args) throws IOException {
        File f1 = new File("src/properties.ser");
        File f2 = new File("src/agents.ser");
        File f3 = new File("src/users.ser");
        if(!(f1.isFile() && f2.isFile() && f3.isFile())) {
            System.out.println("Running initializers...");
            InitDatabaseUser.main(null);
            InitDatabaseProperty.main(null);
            InitDatabaseAgent.main(null);
        } else {
            System.out.println("Not running Initializers.");
        }
        DatabaseManager manager = new DatabaseManager();
        GUI gui = new GUI(manager);
        gui.runInterface();
    }
}
