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

public class DatabaseManager {

    private HashMapUserStorage userStorage;
    private HashMapPropertyStorage propertyStorage;
    private UserCreator userCreator;
    private PropertyCreator propertyCreator;
    private UserStorageReadWriter userStorageReadWriter;
    private PropertyStorageReadWriter propertyStorageReadWriter;

    public void signUpVerify(String name, String user_type, String username, String email, String phone, String password, String password_confirm) throws IllegalArgumentException {
        if(! password.equals(password_confirm)){
            throw new SignUpPasswordMatchException();
        }

        if(phone.length() != 10){
            throw new SignUpPhoneNumberLengthException();
        }

        if ((!user_type.equals("b")) && (!user_type.equals("s"))){
            throw new SignUpUserTypeException();
        }

        // TODO: check if username/email/phone number already exist or not
        // TODO: check if email is valid or not
    }

    public void signUp(String name, String user_type, String username, String email, String phone, String password){
        userCreator.create(name,user_type,username,email,phone,password);
    }

    public User loginUser(String username, String password) throws IllegalArgumentException{
        User user = userStorage.get(username);
        if (user == null){
            throw new LoginUserNotFoundException();
        }
        if (!user.getPassword().equals(password)){
            throw new LoginWrongPasswordException();
        }
        return user;
    }

    public void addProperty(Seller user, String streetAddress, String city, String province, String country, String postalCode, float price, int sqft, boolean availability) {
        this.propertyCreator.create(user, streetAddress, city, province, country, postalCode, price, sqft, availability);
    }

    public String propertiesToString(Seller seller) {
        StringBuilder returnString = new StringBuilder();
        for (Integer propertyId: seller.getProperties()) {
            Property property = propertyStorage.get(propertyId);
            returnString.append("entities.Property: \n");
            returnString.append("Address: ").append(property.getStreetAddress()).append(" ").append(property.getCity()).append(" ").append(property.getProvince()).append('\n');
            returnString.append(property.getSqft()).append(" square feet\n");
            returnString.append("Price: $").append(property.getPrice()).append("\n\n");
        }
        return returnString.toString();
    }

    public Property getProperty(Integer propertyID){
        return propertyStorage.get(propertyID);
    }

    public DatabaseManager(){
        this.userStorageReadWriter = new UserStorageReadWriter(null);
        this.propertyStorageReadWriter = new PropertyStorageReadWriter(null);
        try {
            this.userStorage = (HashMapUserStorage) userStorageReadWriter.readFromFile();
            this.propertyStorage = (HashMapPropertyStorage) this.propertyStorageReadWriter.readFromFile();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        this.propertyCreator = new PropertyCreator(userStorage, userStorageReadWriter, propertyStorage, propertyStorageReadWriter);
        this.userCreator = new UserCreator(userStorage, userStorageReadWriter, propertyStorage, propertyStorageReadWriter);
        this.userCreator.create("John Smith","s", "jsmith", "1234@gmail.com", "1234567890", "1234");
        this.propertyCreator.create((Seller) this.userStorage.get("jsmith"), "6 Hoskin Avenue", "Toronto", "Ontario", "CA", "M5T 2HY", 16000F, 1000, true);
    }
}