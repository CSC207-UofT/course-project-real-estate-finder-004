import org.junit.*;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class SellerTest {
    @Test(timeout = 50)
    public void testSeller() {
        Seller s = new Seller("Alexis Tassone", "alexistassone", "alexis.tassone@mail.utoronto.ca",
                "1234567890", "1234");
        User u = new Seller("John Smith", "johnsmith", "john.smith@gmail.com",
                "0987654321", "4321");
    }

    @Test(timeout = 50)
    public void testGetProperties() {
        Seller s = new Seller("John Smith", "johnsmith", "john.smith@gmail.com",
                "0987654321", "4321");
        Map<String, Boolean> a = new HashMap<>();
        Property p1 = new Property(1, "75 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 450000, 350, 1, 1, a, true, s);
        Property p2 = new Property(2, "85 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 350000, 400, s, true);
        assertTrue(s.getProperties().isEmpty());
        s.addProperty(p1.getPropertyId());
        assertEquals(1, (int) s.getProperties().get(0));
        s.addProperty(p2.getPropertyId());
        assertEquals(2, (int) s.getProperties().get(1));
    }

    @Test(timeout = 50)
    public void testAddProperty() {
        Seller s = new Seller("Alexis Tassone", "alexistassone", "alexis.tassone@mail.utoronto.ca",
                "1234567890", "1234");
        Map<String, Boolean> a = new HashMap<>();
        Property p1 = new Property(3, "75 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 450000, 350, 1, 1, a, true, s);
        Property p2 = new Property(4, "85 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 350000, 400, s, true);
        s.addProperty(p1.getPropertyId());
        assertEquals(3, (int) s.getProperties().get(0));
        s.addProperty(p2.getPropertyId());
        assertEquals(4, (int) s.getProperties().get(1));
    }

    @Test(timeout = 50)
    public void testRemoveProperty() {
        Seller s = new Seller("Alexis Tassone", "alexistassone", "alexis.tassone@mail.utoronto.ca",
                "1234567890", "1234");
        Map<String, Boolean> a = new HashMap<>();
        Property p1 = new Property(5, "75 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 450000, 350, 1, 1, a, true, s);
        Property p2 = new Property(6, "85 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 350000, 400, s, false);
        s.addProperty(p1.getPropertyId());
        s.addProperty(p2.getPropertyId());
        s.removeProperty(0);
        assertEquals(5, (int) s.getProperties().get(0));
        s.removeProperty(0);
        assertEquals(6, (int) s.getProperties().get(1));
    }
}
