import controllers.DatabaseManager;
import entities.Property;
import entities.Seller;
import externalinterfaces.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class DatabaseManagerTest {
    DatabaseManager manager;
    @Before
    public void initProperties() {
        InitDatabaseProperty.main(null);
        manager = new DatabaseManager();
        manager.signUp("John Smith", "s","johnsmith", "john.smith@gmail.com",
                "0987654321", "4321");
        Seller seller = (Seller) manager.loginUser("johnsmith", "4321");
        manager.addProperty(seller, "75 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 450000, 350, true);
        manager.addProperty(seller, "85 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 350000, 400, true);
        manager.addProperty(seller, "6 Hoskin Ave", "Toronto", "Ontario", "Canada",
                "M5S 1H8", 900000, 3000, true);
    }

    @Test(timeout = 50)
    public void testSearchProperties() {
        ArrayList<Integer> results = manager.searchProperties("M5S 1H8", -1.0f,-1.0f, -1, -1, -1, -1);
        assertTrue(results.contains(4));
    }
}