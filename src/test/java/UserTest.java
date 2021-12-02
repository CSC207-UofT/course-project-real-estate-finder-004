import entities.User;
import org.junit.*;

public class UserTest {
    User[] users;

    @Before
    public void setUp() {
        User user1 = new User("John Smith", "jsmith", "1234@gmail.com", "1234567890", "1234");
        User user2 = new User("Paul Gries", "pgries", "adsfsgrdhtjyt", "1231231231", "csc207");
        users = new User[]{user1, user2};
    }

    @Test(timeout = 500)
    public void TestUserGetName() {
        assert users[0].getName().equals("John Smith");
    }

    @Test(timeout = 500)
    public void TestUserGetUsername() {
        assert users[0].getUsername().equals("jsmith");
    }

    @Test(timeout = 500)
    public void TestUserGetEmail() {
        assert users[0].getEmail().equals("1234@gmail.com");
    }

    @Test(timeout = 500)
    public void TestUserGetPhone() {
        assert users[0].getPhone().equals("1234567890");
    }

    @Test(timeout = 500)
    public void TestUserGetPassword() {
        assert users[0].getPassword().equals("1234");
    }

    @Test(timeout = 500)
    public void TestUserSetName() {
        users[1].setName("Harsh Jaluka");
        assert users[1].getName().equals("Harsh Jaluka");
    }

    @Test(timeout = 500)
    public void TestUserSetUsername() {
        users[1].setUsername("harshjaluka");
        assert users[1].getUsername().equals("harshjaluka");
    }

    @Test(timeout = 500)
    public void TestUserSetEmail() {
        users[1].setEmail("harsh@gmail.com");
        assert users[1].getEmail().equals("harsh@gmail.com");
    }

    @Test(timeout = 500)
    public void TestUserSetPhone() {
        users[1].setPhone("1111111111");
    }

    @Test(timeout = 500)
    public void TestUserSetPassword() {
        users[1].setPassword("new_password");
        assert users[1].getPassword().equals("new_password");
    }

    @Test(timeout = 500)
    public void TestConstructorLengthOfPhoneException() {
        Assert.assertThrows(IllegalArgumentException.class,
                () -> {
                    User test_exception = new User("a", "b", "c", "d", "e");
                });
    }

    @Test(timeout = 500)
    public void TestSetPhoneLengthOfPhoneException() {
        Assert.assertThrows(IllegalArgumentException.class,
                () -> users[0].setPhone("23"));
    }
}