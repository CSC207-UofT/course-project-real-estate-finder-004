import entities.Buyer;
import entities.Property;
import entities.Seller;
import entities.User;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class BuyerTest {
    @Test(timeout = 500)
    public void testBuyer(){
        Buyer b = new Buyer("Alexis Tassone", "alexistassone", "alexis.tassone@mail.utoronto.ca",
                "1234567890", "1234");
        User u = new Buyer("John Smith", "johnsmith", "john.smith@gmail.com",
                "0987654321", "4321");
    }

    @Test(timeout = 500)
    public void testGetInterestedProperties(){
        Buyer b = new Buyer("Alexis Tassone", "alexistassone", "alexis.tassone@mail.utoronto.ca",
                "1234567890", "1234");
        Seller s = new Seller("John Smith", "johnsmith", "john.smith@gmail.com",
                "0987654321", "4321");
        Map<String, Boolean> a = new HashMap<>();
        Property p1 = new Property(1, "75 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 450000, 350, 1, 1, a, true, s);
        Property p2 = new Property(2, "85 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 350000, 400, s, true);
        assertTrue(b.getInterestedProperties().isEmpty());
        b.shortListProperty(p1.propertyId);
        assertTrue(b.getInterestedProperties().contains(p1.propertyId));
        b.shortListProperty(p2.propertyId);
        assertTrue(b.getInterestedProperties().contains(p2.propertyId));
    }

    @Test(timeout = 500)
    public void testShortListProperty(){
        Buyer b = new Buyer("Alexis Tassone", "alexistassone", "alexis.tassone@mail.utoronto.ca",
                "1234567890", "1234");
        Seller s = new Seller("John Smith", "johnsmith", "john.smith@gmail.com",
                "0987654321", "4321");
        Map<String, Boolean> a = new HashMap<>();
        Property p1 = new Property(3, "75 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 450000, 350, 1, 1, a, true, s);
        Property p2 = new Property(4, "85 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 350000, 400, s, true);
        b.shortListProperty(p1.propertyId);
        assertTrue(b.getInterestedProperties().contains(p1.propertyId));
        b.shortListProperty(p2.propertyId);
        assertTrue(b.getInterestedProperties().contains(p2.propertyId));
    }

}
