//import org.junit.*;
//import static org.junit.Assert.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class SellerTest {
//    @Test(timeout = 50)
//    public void testSeller(){
//        Seller s = new Seller("Alexis Tassone", "alexistassone", "alexis.tassone@mail.utoronto.ca",
//                "1234567890", "1234");
//        User u = new Seller("John Smith", "johnsmith", "john.smith@gmail.com",
//                "0987654321", "4321");
//    }
//
//    @Test(timeout = 50)
//    public void testGetProperties(){
//        Seller s = new Seller("John Smith", "johnsmith", "john.smith@gmail.com",
//                "0987654321", "4321");
//        Map<String, Boolean> a = new HashMap<>();
//        Property p1 = new Property("75 St. George St", "Toronto", "Ontario", "Canada",
//                "M5S 2E5", 450000, 350, 1, 1, a, true, s);
//        Property p2 = new Property("85 St. George St", "Toronto", "Ontario", "Canada",
//                "M5S 2E5", 350000, 400, s, true);
//        assertTrue(s.getProperties().isEmpty());
//        s.addProperty(p1);
//        assertTrue(s.getProperties().contains(p1));
//        s.addProperty(p2);
//        assertTrue(s.getProperties().contains(p2));
//    }
//
//    @Test(timeout = 50)
//    public void testAddProperty(){
//        Seller s = new Seller("Alexis Tassone", "alexistassone", "alexis.tassone@mail.utoronto.ca",
//                "1234567890", "1234");
//        Map<String, Boolean> a = new HashMap<>();
//        Property p1 = new Property("75 St. George St", "Toronto", "Ontario", "Canada",
//                "M5S 2E5", 450000, 350, 1, 1, a, true, s);
//        Property p2 = new Property("85 St. George St", "Toronto", "Ontario", "Canada",
//                "M5S 2E5", 350000, 400, s, true);
//        s.addProperty(p1);
//        assertTrue(s.getProperties().contains(p1));
//        s.addProperty(p2);
//        assertTrue(s.getProperties().contains(p2));
//    }
//
//    @Test(timeout = 50)
//    public void testRemoveProperty(){
//        Seller s = new Seller("Alexis Tassone", "alexistassone", "alexis.tassone@mail.utoronto.ca",
//                "1234567890", "1234");
//        Map<String, Boolean> a = new HashMap<>();
//        Property p1 = new Property("75 St. George St", "Toronto", "Ontario", "Canada",
//                "M5S 2E5", 450000, 350, 1, 1, a, true, s);
//        Property p2 = new Property("85 St. George St", "Toronto", "Ontario", "Canada",
//                "M5S 2E5", 350000, 400, s,false );
//        s.addProperty(p1);
//        s.addProperty(p2);
//        s.removeProperty(0);
//        assertFalse(s.getProperties().contains(p1));
//        s.removeProperty(0);
//        assertFalse(s.getProperties().contains(p2));
//    }
//}
