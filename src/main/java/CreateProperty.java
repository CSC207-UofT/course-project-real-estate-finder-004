public class CreateProperty {
    public void createProperty(Seller user, String streetAddress, String city, String province, String country, String postalCode, float price, int sqft) {
        Property property = new Property(streetAddress, city, province, country, postalCode, price, sqft, user);
        user.addProperty(property);
    }
}
