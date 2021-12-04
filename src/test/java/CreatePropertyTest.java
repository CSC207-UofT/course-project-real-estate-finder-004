import controllers.PropertyCreator;
import entities.Seller;
import externalinterfaces.HashMapPropertyStorage;
import externalinterfaces.HashMapUserStorage;
import externalinterfaces.PropertyStorageReadWriter;
import externalinterfaces.UserStorageReadWriter;
import org.junit.*;

import static org.junit.Assert.*;

public class CreatePropertyTest {
    @Test(timeout = 500)
    public void testCreateProperty() {
        Seller s = new Seller("John Smith", "johnsmith", "john.smith@gmail.com",
                "0987654321", "4321");
        assertTrue(s.getProperties().isEmpty());
        HashMapUserStorage userStorage = new HashMapUserStorage();
        UserStorageReadWriter userRW = new UserStorageReadWriter(userStorage);
        HashMapPropertyStorage storage = new HashMapPropertyStorage();
        PropertyStorageReadWriter rw = new PropertyStorageReadWriter(storage);
        PropertyCreator propertyCreator = new PropertyCreator(userStorage, userRW, storage, rw);
        propertyCreator.create(s, "85 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 350000, 400, true);
        assertFalse(s.getProperties().isEmpty());
    }

}
