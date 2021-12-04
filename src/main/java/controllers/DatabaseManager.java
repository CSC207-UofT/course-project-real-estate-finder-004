package controllers;

import Exceptions.*;
import entities.Property;
import entities.Seller;
import entities.User;
import externalinterfaces.HashMapPropertyStorage;
import externalinterfaces.HashMapUserStorage;
import externalinterfaces.PropertyStorageReadWriter;
import externalinterfaces.UserStorageReadWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

public class DatabaseManager {

    private HashMapUserStorage userStorage;
    public HashMapPropertyStorage propertyStorage;
    private UserCreator userCreator;
    private PropertyCreator propertyCreator;
    private UserStorageReadWriter userStorageReadWriter;
    private PropertyStorageReadWriter propertyStorageReadWriter;

    public void signUpVerify(String name, String user_type, String username, String email, String phone, String password, String password_confirm) throws IllegalArgumentException {
        if (!password.equals(password_confirm)) {
            throw new SignUpPasswordMatchException();
        }

        if (phone.length() != 10) {
            throw new SignUpPhoneNumberLengthException();
        }

        if ((!user_type.equals("b")) && (!user_type.equals("s"))) {
            throw new SignUpUserTypeException();
        }

        // TODO: check if username/email/phone number already exist or not
        // TODO: check if email is valid or not
    }

    public void signUp(String name, String user_type, String username, String email, String phone, String password) {
        userCreator.create(name, user_type, username, email, phone, password);
    }

    public User loginUser(String username, String password) throws IllegalArgumentException {
        User user = userStorage.get(username);
        if (user == null) {
            throw new LoginUserNotFoundException();
        }
        if (!user.getPassword().equals(password)) {
            throw new LoginWrongPasswordException();
        }
        return user;
    }

    public Map<Integer, Property> searchProperties(String postalCode) {
        Map<Integer, Property> toReturn = new HashMap<>();
        Set<Integer> keys = this.propertyStorage.keySet();
        for (Integer key : keys) {
            Property property = this.propertyStorage.get(key);
            if (property.getPostalCode().equals(postalCode)) {
                toReturn.put(key, property);
            }
        }
        return toReturn;
    }

    public void addProperty(Seller user, String streetAddress, String city, String province, String country, String postalCode, float price, int sqft, boolean availability) {
        this.propertyCreator.create(user, streetAddress, city, province, country, postalCode, price, sqft, availability);
    }

    public String propertiesToString(ArrayList<Integer> propertyIds) {
        StringBuilder returnString = new StringBuilder();
        int propertyNumber = 1;
        for (Integer propertyId: propertyIds) {
            Property property = propertyStorage.get(propertyId);
            returnString.append(propertyNumber).append(". ").append(property.toString()).append("\n");
            propertyNumber++;
        }
        return returnString.toString();
    }

    public String specificPropertyToString(Integer propertyId) {
        Property property = propertyStorage.get(propertyId);
        return property.toStringLong();
    }

    public DatabaseManager() {
        this.userStorageReadWriter = new UserStorageReadWriter(null);
        this.propertyStorageReadWriter = new PropertyStorageReadWriter(null);
        try {
            this.userStorage = (HashMapUserStorage) userStorageReadWriter.readFromFile();
            this.propertyStorage = (HashMapPropertyStorage) this.propertyStorageReadWriter.readFromFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        this.propertyCreator = new PropertyCreator(userStorage, userStorageReadWriter, propertyStorage, propertyStorageReadWriter);
        this.userCreator = new UserCreator(userStorage, userStorageReadWriter, propertyStorage, propertyStorageReadWriter);
        this.userCreator.create("John Smith", "s", "jsmith", "1234@gmail.com", "1234567890", "1234");
        this.propertyCreator.create((Seller) this.userStorage.get("jsmith"), "6 Hoskin Avenue", "Toronto", "Ontario", "CA", "M5T 2HY", 16000F, 1000, true);
    }
}