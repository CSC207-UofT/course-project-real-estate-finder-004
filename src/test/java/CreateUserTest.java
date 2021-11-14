import org.junit.*;
import static org.junit.Assert.*;

public class CreateUserTest {
    @Test (timeout = 50)
    public void testCreateBuyer(){
        HashMapUserStorage myUserStorage = new HashMapUserStorage();
        UserStorageReadWriter rw = new UserStorageReadWriter();
        UserCreator myUser = new UserCreator(myUserStorage, rw);
        assertTrue(myUserStorage.getUsers().isEmpty());
        myUser.createUser("Alexis Tassone", "b", "alexistassone", "alexis.tassone@mail.utoronto.ca",
                "1234567890", "1234");
        assertFalse(myUserStorage.getUsers().isEmpty());
    }

    @Test (timeout = 50)
    public void testCreateSeller(){
        HashMapUserStorage myUserStorage = new HashMapUserStorage();
        UserStorageReadWriter rw = new UserStorageReadWriter();
        UserCreator myUser = new UserCreator(myUserStorage, rw);
        assertTrue(myUserStorage.getUsers().isEmpty());
        myUser.createUser("Alexis Tassone", "s", "alexistassone", "alexis.tassone@mail.utoronto.ca",
                "1234567890", "1234");
        assertFalse(myUserStorage.getUsers().isEmpty());
    }
}
