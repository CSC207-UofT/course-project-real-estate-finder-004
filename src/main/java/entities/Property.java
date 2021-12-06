package entities;

import java.util.ArrayList;
import java.util.Map;
import java.io.Serializable;

public class Property implements Serializable {
    public final int propertyId;
    public final RealEstateAgent agent;

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
    private Seller owner;

    /**
     * Constructs a new property given the relevant details.
     *
     * @param propertyId        The property's unique Id.
     * @param streetAddress     The property's street address.
     * @param city              The city in which the property is located.
     * @param province          The province in which the property is located.
     * @param country           The country in which the property is located.
     * @param postalCode        The property's postal code.
     * @param price             The price of the property.
     * @param sqft              The square footage of the property.
     * @param numberOfRoom      The number of rooms the property has.
     * @param numberOfBathrooms The number of bathrooms the property has.
     * @param amenities         The amenities the property features.
     * @param availability      The property's availability.
     * @param owner             The user who owns the property.
     */
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

    /**
     * Constructs a new property given the relevant details.
     *
     * @param propertyId        The property's unique Id.
     * @param streetAddress     The property's street address.
     * @param city              The city in which the property is located.
     * @param province          The province in which the property is located.
     * @param country           The country in which the property is located.
     * @param postalCode        The property's postal code.
     * @param price             The price of the property.
     * @param sqft              The square footage of the property.
     * @param availability      The property's availability.
     * @param owner             The user who owns the property.
     */
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

    /**
     * Returns the property Id uniquely associated with the property.
     *
     * @return An int representing property Id uniquely associated with the property.
     */
    public int getPropertyId() {
        return propertyId;
    }

    /**
     * Returns the property's street address.
     *
     * @return A String of the property's street address.
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Returns the city in which the property is located.
     *
     * @return A String of the city in which the property is located.
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the country in which the property is located.
     *
     * @return A String of the country in which the property is located.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Returns the property's postal code.
     *
     * @return A String of the property's postal code.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Returns the province in which the property is located.
     *
     * @return A String of the province in which the property is located.
     */
    public String getProvince() {
        return province;
    }

    /**
     * Returns the price of the property.
     *
     * @return An int representing the price of the property.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Returns the square footage of the property.
     *
     * @return An int representing square footage of the property.
     */
    public int getSqft() {
        return sqft;
    }

    /**
     * Returns the number of rooms the property has.
     *
     * @return An int representing number of rooms the property has.
     */
    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    /**
     * Returns the number of bathrooms the property has.
     *
     * @return An int representing the number of bathrooms the property has.
     */
    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    /**
     * Returns the user who owns this property.
     *
     * @return The User who owns this property.
     */
    public Seller getOwner() {
        return owner;
    }

    /**
     * Returns the amenities the property features.
     *
     * @return A Map of all amenities, where the value of the amenity is True if the property has the amenity.
     */
    public Map<String, Boolean> getAmenities() { return Amenities; }

    public ArrayList<String> getAvailableAmenities() {
        ArrayList<String> availableAmenities = new ArrayList<>();
        for (String amenity : Amenities.keySet()) {
            if (Amenities.get(amenity)) {
                availableAmenities.add(amenity);
            }
        }
        return availableAmenities;
    }

    /**
     * Returns the availability of the property.
     *
     * @return True if the property is available, and False if the property is not available.
     */
    public boolean getAvaliability() {
        return availability;
    }

    /**
     * Sets the property's street address.
     *
     * @param streetAddress The property's street address
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Sets the property's city.
     *
     * @param city The city in which the property is located.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets the property's province.
     *
     * @param province The province in which the property is located.
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Set's the property's country.
     *
     * @param country The country in which the property is located.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Set's the property's postal code.
     *
     * @param postalCode The property's postal code.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Set's the property's price.
     *
     * @param price The price of the property.
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Set's the property's square footage.
     *
     * @param sqft The square footage of the property.
     */
    public void setSqft(int sqft) {
        this.sqft = sqft;
    }

    /**
     * Calculates the price of the property per square foot.
     *
     * @return A float representing the price of the property per square foot.
     */
    public float pricepersqft() {
        return this.price / this.sqft;
    }

    /**
     * Set's the property's number of rooms.
     *
     * @param numberOfRoom The number of rooms the property has.
     */
    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    /**
     * Set's the property's number of bathrooms.
     *
     * @param numberOfBathrooms The number of bathrooms the property has.
     */
    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    /**
     * Set's the property's amenities.
     *
     * @param amenities The amenities the property features.
     */
    public void setAmenities(Map<String, Boolean> amenities) {
        Amenities = amenities;
    }

    /**
     * Set's the property's owner.
     *
     * @param owner The user who owns the property.
     */
    public void setOwner(Seller owner) {
        this.owner = owner;
    }

    /**
     * Set's the property's availability.
     *
     * @param availability The property's availability.
     */
    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public String toString() {
        return "Address: " + streetAddress + ", " + city + ", " + province + "\n" +
                "Floor area: " + sqft + " square feet\n" +
                "Price: $" + price + "\n\n";
    }

    public String toStringLong() {
        return "Address: " + streetAddress + ", " + city + ", " + province + "\n" +
                "Postal code: " + postalCode + "\n" +
                "Floor area: " + sqft + " square feet\n" +
                "Price: $" + price + "\n" +
                "Number of rooms: " + numberOfRoom + "\n" +
                "Number of bathrooms: " + numberOfBathrooms + "\n" +
                "Available amenities: " + getAvailableAmenities().toString() + "\n";
    }

}
