import java.util.Map;
import java.io.Serializable;

public class Property implements Serializable {
    public final int propertyId;

    private String streetAddress;
    private String city;
    private String province;
    private String country;
    private String postalCode;
    private float price;
    private int sqft;
    private int numberOfRoom;
    private int numberOfBathrooms;
    private Map<String, Boolean> Amenities;
    private boolean availability;
    private final RealEstateAgent agent;
    private Seller owner;

    public Property(int propertyId, String streetAddress, String city, String province, String country, String postalCode, float price, int sqft, int numberOfRoom, int numberOfBathrooms, Map amenities, Boolean availability, Seller owner) {
        this.propertyId = propertyId;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
        this.price = price;
        this.sqft = sqft;
        this.numberOfRoom = numberOfRoom;
        this.numberOfBathrooms = numberOfBathrooms;
        this.Amenities = amenities;
        this.owner = owner;
        this.availability = availability;
        this.agent = new RealEstateAgent(this.owner);
    }

    public Property(int propertyId, String streetAddress, String city, String province, String country, String postalCode, float price, int sqft, Seller owner, boolean availability) {
        this.propertyId = propertyId;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
        this.price = price;
        this.sqft = sqft;
        this.owner = owner;
        this.agent = new RealEstateAgent(this.owner);
        this.availability = availability;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getProvince() {
        return province;
    }

    public float getPrice() {
        return price;
    }

    public int getSqft() {
        return sqft;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public Seller getOwner() {
        return owner;
    }

    public Map<String, Boolean> getAmenities() {
        return Amenities;
    }

    public boolean getAvaliability() {
        return availability;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSqft(int sqft) {
        this.sqft = sqft;
    }

    public float pricepersqft() {
        return this.price / this.sqft;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public void setAmenities(Map<String, Boolean> amenities) {
        Amenities = amenities;
    }

    public void setOwner(Seller owner) {
        this.owner = owner;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}
