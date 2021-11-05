import org.junit.*;

public class UserTest {
    User[] users;

    @Before
    public void setUp() throws Exception {
        User user1 = new User("John Smith", "jsmith", "1234@gmail.com", "123-456-7890", "1234");
        User user2 = new User("Paul Gries", "pgries", "adsfsgrdhtjyt", "1234567", "csc207");
        users = new User[]{user1, user2};
    }
    @Test(timeout=50)
    public void TestUserGetPassword() {
        assert users[0].getPassword().equals("1234");
    }

    @Test(timeout=50)
    public void TestUserGetName(){ assert users[0].getName().equals("John Smith"); }
}