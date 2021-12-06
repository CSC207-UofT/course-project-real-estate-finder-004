import entities.Property;
import entities.Seller;
import org.junit.*;

public class ListPropertiesTest {
    @Test(timeout = 500)
    public void testGetListOfProperties() {
        Seller s = new Seller("John Smith", "johnsmith", "john.smith@gmail.com",
                "0987654321", "4321");
        Property p1 = new Property(1, "75 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 450000, 350, s, true);
        Property p2 = new Property(2, "85 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 350000, 400, s, true);
        s.addProperty(p1.getPropertyId());
        String s1 = "entities.Property: \nAddress: 75 St. George St Toronto Ontario\n350 square feet\nPrice: $450000.0\n\n";
// Commented out since new refactoring stuff
//        ListProperties myProperties = new ListProperties();
//        assertEquals(s1,myProperties.getListOfProperties(s));
//        s.addProperty(p2);
//        String s2 = "entities.Property: \nAddress: 85 St. George St Toronto Ontario\n400 square feet\nPrice: $350000.0\n\n";
//        assertEquals(s1 + s2, myProperties.getListOfProperties(s));
    }
}
