import controllers.UserCreator;
import externalinterfaces.HashMapPropertyStorage;
import externalinterfaces.HashMapUserStorage;
import externalinterfaces.PropertyStorageReadWriter;
import externalinterfaces.UserStorageReadWriter;
import org.junit.*;

import static org.junit.Assert.*;

public class CreateUserTest {
    @Test(timeout = 500)
    public void testCreateBuyer() {
        HashMapUserStorage myUserStorage = new HashMapUserStorage();
        UserStorageReadWriter rw = new UserStorageReadWriter(myUserStorage);
        HashMapPropertyStorage storage = new HashMapPropertyStorage();
        PropertyStorageReadWriter propRW = new PropertyStorageReadWriter(storage);

        UserCreator myUser = new UserCreator(myUserStorage, rw, storage, propRW);
        assertTrue(myUserStorage.getUsers().isEmpty());
        myUser.create("Alexis Tassone", "b", "alexistassone", "alexis.tassone@mail.utoronto.ca",
                "1234567890", "1234");
        assertFalse(myUserStorage.getUsers().isEmpty());
    }

    @Test(timeout = 500)
    public void testCreateSeller() {
        HashMapUserStorage myUserStorage = new HashMapUserStorage();
        UserStorageReadWriter rw = new UserStorageReadWriter(myUserStorage);
        HashMapPropertyStorage storage = new HashMapPropertyStorage();
        PropertyStorageReadWriter propRW = new PropertyStorageReadWriter(storage);

        UserCreator myUser = new UserCreator(myUserStorage, rw, storage, propRW);
        assertTrue(myUserStorage.getUsers().isEmpty());
        myUser.create("Alexis Tassone", "s", "alexistassone", "alexis.tassone@mail.utoronto.ca",
                "1234567890", "1234");
        assertFalse(myUserStorage.getUsers().isEmpty());
    }
}
