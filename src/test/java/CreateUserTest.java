import org.junit.*;
import static org.junit.Assert.*;

public class CreateUserTest {
    @Test (timeout = 50)
    public void testCreateBuyer(){
        HashMapUserStorage myUserStorage = new HashMapUserStorage();
        CreateUser myUser = new CreateUser(myUserStorage);
        assertTrue(myUserStorage.getUsers().isEmpty());
        myUser.createBuyer("Alexis Tassone", "alexistassone", "alexis.tassone@mail.utoronto.ca",
                "1234567890", "1234");
        assertFalse(myUserStorage.getUsers().isEmpty());
    }

    @Test (timeout = 50)
    public void testCreateSeller(){
        HashMapUserStorage myUserStorage = new HashMapUserStorage();
        CreateUser myUser = new CreateUser(myUserStorage);
        assertTrue(myUserStorage.getUsers().isEmpty());
        myUser.createSeller("Alexis Tassone", "alexistassone", "alexis.tassone@mail.utoronto.ca",
                "1234567890", "1234");
        assertFalse(myUserStorage.getUsers().isEmpty());
    }
}
