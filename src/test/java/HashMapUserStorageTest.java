import org.junit.*;

public class HashMapUserStorageTest {

    HashMapUserStorage users;

    @Before
    public void setUp() {
        User user1 = new User("John Smith", "jsmith", "1234@gmail.com", "1234567890", "1234");
        User user2 = new User("Paul Gries", "pgries", "adsfsgrdhtjyt", "1231231231", "csc207");
        users = new HashMapUserStorage();
        users.add(user1);
        users.add(user2);
    }

    @Test(timeout = 50)
    public void TestGetUser() {
        System.out.println(users.get("user1"));
        assert users.get("jsmith").getName().equals("John Smith");
    }

    @Test(timeout = 50)
    public void TestAddUser() {
        User user3 = new User("Sebastian", "origamii", "myemail@gmail.com", "1234567890", "mypass");
        users.add(user3);
        assert users.get("origamii").getName().equals("Sebastian");
    }


}
