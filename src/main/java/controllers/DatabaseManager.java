package controllers;

import Exceptions.*;
import entities.*;
import externalinterfaces.HashMapPropertyStorage;
import externalinterfaces.HashMapUserStorage;
import externalinterfaces.HashMapAgentStorage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

public class DatabaseManager {

    private HashMapUserStorage userStorage;
    private HashMapPropertyStorage propertyStorage;
    private HashMapAgentStorage agentStorage;
    private final UserCreator userCreator;
    private final PropertyCreator propertyCreator;
    private final AgentCreator agentCreator;
    private final UserStorageReadWriter userStorageReadWriter;
    private final PropertyStorageReadWriter propertyStorageReadWriter;
    private final AgentStorageReadWriter agentStorageReadWriter;

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

        // check if username/email/phone number already exist or not
        for(User user: userStorage.getUsers().values()) {
            if (user.getUsername().equals(username)) {
                throw new SignUpUserNameInUseException();
            }
            if (user.getEmail().equals(email)) {
                throw new SignUpEmailInUseException();
            }
            if (user.getPhone().equals(phone)) {
                throw new SignUpPhoneNumberInUseException();
            }
        }
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

    public ArrayList<Integer> searchProperties(String postalCode, float minPrice, float maxPrice, int minSqft, int maxSqft, int numberOfRoom, int numberOfBathrooms) {
        ArrayList<Integer> properties = new ArrayList<>();
        ArrayList<Integer> toReturn = new ArrayList<>();
        Set<Integer> keys = this.propertyStorage.keySet();
        for (Integer key : keys) {
            Property property = this.propertyStorage.get(key);
            properties.add(property.getPropertyId());
        }
        for (Integer key : properties){
            Property property = this.propertyStorage.get(key);
            boolean b = true;
            if (postalCode != null && !property.getPostalCode().equals(postalCode)){
                b = false;
            }
            else if (minPrice != -1.0f && maxPrice != -1.0f && (minPrice > property.getPrice() || property.getPrice() > maxPrice)){
                b = false;
            }
            else if (minSqft != -1 && maxSqft != -1 && (minSqft > property.getSqft() || property.getSqft() > maxSqft)){
                b = false;
            }
            else if (numberOfRoom != -1 && property.getNumberOfRoom() != numberOfRoom){
                b = false;
            }
            else if (numberOfBathrooms != -1 && property.getNumberOfBathrooms() != numberOfBathrooms){
                b = false;
            }
            if (b){
                toReturn.add(key);
            }
        }
        return toReturn;
    }

    public void addProperty(Seller user, String streetAddress, String city, String province, String country, String postalCode, float price, int sqft, boolean availability) {
        this.propertyCreator.create(user, streetAddress, city, province, country, postalCode, price, sqft, availability);
        this.agentCreator.create(user);
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

    public Property getProperty(Integer propertyID){
        return propertyStorage.get(propertyID);
    }

    public String specificPropertyToString(Integer propertyId) {
        Property property = propertyStorage.get(propertyId);
        return property.toStringLong();
    }

    public void joinRealEstateAgent(Integer propertyId, String buyerUsername, String customMessage) {
        Property property = propertyStorage.get(propertyId);
        RealEstateAgent agent = property.getAgent();
        agent.addBuyer(buyerUsername);
        agent.connectBuyersAndSeller(customMessage, (Buyer) userStorage.get(buyerUsername), property);
    }

    public void updateUser(User user){
        HashMap<String, Boolean> messages = new HashMap<>();
        ArrayList<Integer> properties = new ArrayList<>();
        String type = "b";
        if (user instanceof Seller) {
            type = "s";
            Seller seller = (Seller) user;
            messages = seller.getMessages();
            properties = seller.getProperties();
        }
        userCreator.create(user.getName(), type, user.getUsername(), user.getEmail(), user.getPhone(), user.getPassword(), messages, properties);

    }

    public DatabaseManager() {
        this.userStorageReadWriter = new UserStorageReadWriter(null);
        this.propertyStorageReadWriter = new PropertyStorageReadWriter(null);
        this.agentStorageReadWriter = new AgentStorageReadWriter(null);

        try {
            this.userStorage = (HashMapUserStorage) userStorageReadWriter.readFromFile();
            this.propertyStorage = (HashMapPropertyStorage) propertyStorageReadWriter.readFromFile();
            this.agentStorage = (HashMapAgentStorage) agentStorageReadWriter.readFromFile();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        this.propertyCreator = new PropertyCreator(userStorage, userStorageReadWriter, propertyStorage, propertyStorageReadWriter, agentStorage, agentStorageReadWriter);
        this.agentCreator = new AgentCreator(userStorage, userStorageReadWriter, propertyStorage, propertyStorageReadWriter, agentStorage, agentStorageReadWriter);
        this.userCreator = new UserCreator(userStorage, userStorageReadWriter, propertyStorage, propertyStorageReadWriter, agentStorage, agentStorageReadWriter);

        this.userCreator.create("John Smith","s", "jsmith", "1234@gmail.com", "1234567890", "1234");
        this.propertyCreator.create((Seller) this.userStorage.get("jsmith"), "6 Hoskin Avenue", "Toronto", "Ontario", "CA", "M5T 2HY", 16000F, 1000, true);
        this.agentCreator.create((Seller) this.userStorage.get("jsmith"));
    }
}