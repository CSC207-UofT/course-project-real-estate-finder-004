import controllers.UserCreator;
import externalinterfaces.AgentStorageReadWriter;
import externalinterfaces.HashMapAgentStorage;
import externalinterfaces.PropertyStorageReadWriter;
import externalinterfaces.HashMapPropertyStorage;
import externalinterfaces.UserStorageReadWriter;
import externalinterfaces.HashMapUserStorage;
import org.junit.*;

import static org.junit.Assert.*;

public class CreateUserTest {
    @Test (timeout = 500)
    public void testCreateBuyer(){
        HashMapUserStorage userStorage = new HashMapUserStorage();
        UserStorageReadWriter userStorageReadWriter = new UserStorageReadWriter(userStorage);
        HashMapPropertyStorage propertyStorage = new HashMapPropertyStorage();
        PropertyStorageReadWriter propertyStorageReadWriter = new PropertyStorageReadWriter(propertyStorage);
        HashMapAgentStorage agentStorage = new HashMapAgentStorage();
        AgentStorageReadWriter agentStorageReadWriter = new AgentStorageReadWriter(agentStorage);
        UserCreator myUser = new UserCreator(userStorage, userStorageReadWriter, propertyStorage, propertyStorageReadWriter, agentStorage, agentStorageReadWriter);
        assertTrue(userStorage.getUsers().isEmpty());
        myUser.create("Alexis Tassone", "b", "alexistassone", "alexis.tassone@mail.utoronto.ca",
                "1234567890", "1234");
        assertFalse(userStorage.getUsers().isEmpty());
    }

    @Test (timeout = 500)
    public void testCreateSeller(){
        HashMapUserStorage userStorage = new HashMapUserStorage();
        UserStorageReadWriter userStorageReadWriter = new UserStorageReadWriter(userStorage);
        HashMapPropertyStorage propertyStorage = new HashMapPropertyStorage();
        PropertyStorageReadWriter propertyStorageReadWriter = new PropertyStorageReadWriter(propertyStorage);
        HashMapAgentStorage agentStorage = new HashMapAgentStorage();
        AgentStorageReadWriter agentStorageReadWriter = new AgentStorageReadWriter(agentStorage);
        UserCreator myUser = new UserCreator(userStorage, userStorageReadWriter, propertyStorage, propertyStorageReadWriter, agentStorage, agentStorageReadWriter);
        assertTrue(userStorage.getUsers().isEmpty());
        myUser.create("Alexis Tassone", "s", "alexistassone", "alexis.tassone@mail.utoronto.ca",
                "1234567890", "1234");
        assertFalse(userStorage.getUsers().isEmpty());
    }
}
