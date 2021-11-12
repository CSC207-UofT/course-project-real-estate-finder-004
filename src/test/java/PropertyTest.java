import org.junit.*;

public class PropertyTest {
    Property[] properties;
    Seller user1;
    Seller user2;
    @Before
    public void setUp(){
        user1 = new Seller("Tony Stark", "tstark", "tonystark@gmail.com", "2129704133", "starkindustries");
        user2 = new Seller("Paul Gries", "pgries", "pgries@cs.toronto.edu", "1231231231", "csc207");
        Property property1 = new Property("10880 Malibu Point", "Malibu", "California", "United States", "90265", 620000, 500, user1, true);
        Property property2 = new Property("RM4234, 40 St. George St", "Toronto", "ON", "Canada", "M5S 2E4", 1142000, 1000, user2, true);
        properties = new Property[]{property1, property2};
    }
    @Test(timeout = 50)
    public void TestPropertyGetStreetAddress() {
        assert properties[0].getStreetAddress().equals("10880 Malibu Point");
    }

    @Test(timeout = 50)
    public void TestPropertyGetCity() {
        assert properties[0].getCity().equals("Malibu");
    }

    @Test(timeout = 50)
    public void TestPropertyGetProvince() {
        assert properties[0].getProvince().equals("California");
    }

    @Test(timeout = 50)
    public void TestPropertyGetCountry() {
        assert properties[0].getCountry().equals("United States");
    }

    @Test(timeout = 50)
    public void TestPropertyGetPostalCode() {
        assert properties[0].getPostalCode().equals("90265");
    }

    @Test(timeout = 50)
    public void TestPropertyGetPrice() {
        assert properties[0].getPrice() == 620000;
    }

    @Test(timeout = 50)
    public void TestPropertyGetSqft() {
        assert properties[0].getSqft() == 500;
    }

    @Test(timeout = 50)
    public void TestPropertyGetOwner() {
        assert properties[0].getOwner().equals(user1);
    }

    @Test(timeout = 50)
    public void TestPropertyGetAvailability() {
        assert properties[0].getAvaliability();
    }

    @Test(timeout = 50)
    public void TestPropertySetStreetAddress() {
        properties[1].setStreetAddress("569 Leaman Place");
        assert properties[1].getStreetAddress().equals("569 Leaman Place");
    }

    @Test(timeout = 50)
    public void TestPropertySetCity() {
        properties[1].setCity("Brooklyn");
        assert properties[1].getCity().equals("Brooklyn");
    }

    @Test(timeout = 50)
    public void TestPropertySetProvince() {
        properties[1].setProvince("New York");
        assert properties[1].getProvince().equals("New York");
    }

    @Test(timeout = 50)
    public void TestPropertySetCountry() {
        properties[1].setCountry("United States");
        assert properties[1].getCountry().equals("United States");
    }

    @Test(timeout = 50)
    public void TestPropertySetPostalCode() {
        properties[1].setPostalCode("90569");
        assert properties[1].getPostalCode().equals("90569");
    }

    @Test(timeout = 50)
    public void TestPropertySetPrice() {
        properties[1].setPrice(5000000);
        assert properties[1].getPrice() == 5000000;
    }

    @Test(timeout = 50)
    public void TestPropertySetSqft() {
        properties[1].setSqft(1000);
        assert properties[1].getSqft() == 1000;
    }

    @Test(timeout = 50)
    public void TestPropertySetOwner() {
        Seller user3 = new Seller("Steve Roger", "sroger", "steveroger@gmail.com", "6781367092", "captainamerica");
        properties[1].setOwner(user3);
        assert properties[1].getOwner().equals(user3);
    }

    @Test(timeout = 50)
    public void TestPricePerSqft(){
        assert properties[0].pricepersqft() == 1240;
    }

    @Test(timeout = 50)
    public void TestUpdateAvailability(){
        properties[0].setAvailability(false);
        assert ! properties[0].getAvaliability();
    }

}

