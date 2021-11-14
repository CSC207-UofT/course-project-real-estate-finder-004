import org.junit.*;
import static org.junit.Assert.*;

public class CreatePropertyTest {
    @Test (timeout = 50)
    public void testCreateProperty(){
        Seller s = new Seller("John Smith", "johnsmith", "john.smith@gmail.com",
                "0987654321", "4321");
        assertTrue(s.getProperties().isEmpty());
        CreateProperty myProperty = new CreateProperty();
        myProperty.createProperty(s,"85 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 350000, 400, true);
        assertFalse(s.getProperties().isEmpty());
    }

}
