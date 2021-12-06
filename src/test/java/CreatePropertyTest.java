import controllers.PropertyCreator;
import entities.Seller;
import controllers.AgentStorageReadWriter;
import externalinterfaces.HashMapAgentStorage;
import controllers.PropertyStorageReadWriter;
import externalinterfaces.HashMapPropertyStorage;
import controllers.UserStorageReadWriter;
import externalinterfaces.HashMapUserStorage;
import org.junit.*;

import static org.junit.Assert.*;

public class CreatePropertyTest {
    @Test(timeout = 500)
    public void testCreateProperty() {
        Seller s = new Seller("John Smith", "johnsmith", "john.smith@gmail.com",
                "0987654321", "4321");
        assertTrue(s.getProperties().isEmpty());

        HashMapUserStorage userStorage = new HashMapUserStorage();
        UserStorageReadWriter userStorageReadWriter = new UserStorageReadWriter(userStorage);
        HashMapPropertyStorage propertyStorage = new HashMapPropertyStorage();
        PropertyStorageReadWriter propertyStorageReadWriter = new PropertyStorageReadWriter(propertyStorage);
        HashMapAgentStorage agentStorage = new HashMapAgentStorage();
        AgentStorageReadWriter agentStorageReadWriter = new AgentStorageReadWriter(agentStorage);

        PropertyCreator propertyCreator = new PropertyCreator(userStorage, userStorageReadWriter, propertyStorage, propertyStorageReadWriter, agentStorage, agentStorageReadWriter);
        propertyCreator.create(s,"85 St. George St", "Toronto", "Ontario", "Canada",
                "M5S 2E5", 350000, 400, true);
        assertFalse(s.getProperties().isEmpty());
    }

}
