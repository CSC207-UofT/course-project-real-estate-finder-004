import org.junit.*;

public class UserTest {
    User[] users;

    @Before
    public void setUp() throws Exception {
        User user1 = new User("John Smith", "jsmith", "1234@gmail.com", "123-456-7890", "1234");
        User user2 = new User("Paul Gries", "pgries", "adsfsgrdhtjyt", "1234567", "csc207");
        users = new User[]{user1, user2};
    }
    @Test(timeout = 50)
    public void TestUserGetPassword() {
        assert users[0].getPassword().equals("1234");
    }
//
//    @RunCLI(timeout = 50)
//    public void TestEnhanceBagsTrue() {
//        BagMain.enhanceBags(bags, true);
//        assertEquals(4, bags[0].getCapacity());
//        assertEquals(5, bags[1].getCapacity());
//        assertEquals(6, bags[2].getCapacity());
//        assertEquals(7, bags[3].getCapacity());
//    }
//    @RunCLI(timeout = 50)
//    public void TestEnhanceBagsFalse() {
//        BagMain.enhanceBags(bags, false);
//        assertEquals(3, bags[0].getCapacity());
//        assertEquals(5, bags[1].getCapacity());
//        assertEquals(5, bags[2].getCapacity());
//        assertEquals(7, bags[3].getCapacity());
//    }
//
//    @RunCLI(timeout = 50)
//    public void TestCountCrossbodyStraps() {
//        assertEquals(6, BagMain.countCrossbodyStraps(bags));
//    }

}