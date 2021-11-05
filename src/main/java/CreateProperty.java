public class CreateProperty {
    public static void createProperty(Seller user, String streetAddress, String city, String province, String country, String postalCode, float price, int sqft, boolean availability) {
        Property property = new Property(streetAddress, city, province, country, postalCode, price, sqft, user, availability);
        user.addProperty(property);
    }
}
