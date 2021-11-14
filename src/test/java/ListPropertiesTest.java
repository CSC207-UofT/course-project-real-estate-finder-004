import org.junit.*;
import static org.junit.Assert.*;

public class ListPropertiesTest {
    @Test (timeout = 150)
    public void testGetListOfProperties(){
        Seller s = new Seller("John Smith", "johnsmith", "john.smith@gmail.com",
                "0987654321", "4321");
        Property p1 = new Property("75 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 450000, 350, s, true);
        Property p2 = new Property("85 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 350000, 400, s, true);
        s.addProperty(p1);
        String s1 = "Property: \nAddress: 75 St. George St Toronto Ontario\n350 square feet\nPrice: $450000.0\n\n";
        ListProperties myProperties = new ListProperties();
        assertEquals(s1,myProperties.getListOfProperties(s));
        s.addProperty(p2);
        String s2 = "Property: \nAddress: 85 St. George St Toronto Ontario\n400 square feet\nPrice: $350000.0\n\n";
        assertEquals(s1 + s2, myProperties.getListOfProperties(s));
    }
}