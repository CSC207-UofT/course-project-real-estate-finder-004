package entities;

import java.util.*;

public class Seller extends User {
    // properties stores the propertyIds of all the properties
    private ArrayList<Integer> properties = new ArrayList<>();
    private LinkedHashMap<String, Boolean> messages = new LinkedHashMap<>();

    /**
     * Constructs a new user given the relevant details.
     *
     * @param name     The user's given name.
     * @param username The user's username, which will be used for authentication. Note that this must be unique for all users.
     * @param email    The user's email, for getting in contact with the buyers.
     * @param phone    The user's phone number, for getting in contact with the buyers.
     * @param password The user's password, used for authentication.
     */
    public Seller(String name, String username, String email, String phone, String password) {
        super(name, username, email, phone, password);
    }

    /**
     * Adds a message object to the Seller, which will be displayed to the user when checking their unread messages.
     *
     * @param message The message that will be passed to the user, as a string.
     */
    public void addMessage(String message) {
        messages.put(message, false);

        // Using print statement to test
        //System.out.println(message);
    }
    /**
     * Marks a message as read, so it will not be displayed to the user when checking their unread messages.
     *
     * @param message The message to mark as read.
     */
    public void messageRead(String message) {
        messages.put(message, true);
    }

    /**
     * Adds a property to the Seller's list of properties.
     *
     * @param propertyId The ID for the property to be added.
     */
    public void addProperty(Integer propertyId) {
        properties.add(propertyId);
    }

    /**
     * Gets the list of user propertyIds.
     *
     * @return An ArrayList of the user's propertyIds.
     */
    public ArrayList<Integer> getProperties() {
        return properties;
    }

    /**
     * Gets all the user's read and unread messages.
     *
     * @return A HashMap of the User's messages, with values of true or false depending on if it has been read.
     */
    public LinkedHashMap<String, Boolean> getMessages() {
        return messages;
    }

    /**
     * Returns a list of all the user's unread messages.
     *
     * @return An ArrayList of all the content of the user's unread messages.
     */
    public ArrayList<String> getUnreadMessages() {
        ArrayList<String> unreadMessagesList = new ArrayList<>();
        Set<String> allMessages = messages.keySet();
        for (String message : allMessages) {
            if (!messages.get(message)) {
                unreadMessagesList.add(message);
            }
        }
        return unreadMessagesList;
    }

    /**
     * Converts a list of unread messages to a string.
     *
     * @param unreadMessagesList An ArrayList of the unread messages
     * @return A String with the messages, separated by newlines.
     */
    public String getUnreadMessagesString(ArrayList<String> unreadMessagesList) {
        StringBuilder unreadMessages = new StringBuilder();
        int counter = 1;
        for (String message : unreadMessagesList) {
            unreadMessages.append(counter).append(". ").append(message).append("\n");
        }
        return unreadMessages.toString();
    }

    /**
     * Returns the total number of unread messages.
     *
     * @return An int that is the number of unread messages.
     */
    public int noOfUnreadMessages() {
        Set<String> my_keys = messages.keySet();
        int counter = 0;
        for (String message : my_keys) {
            if (!messages.get(message)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Removes a property from the user's list of properties.
     *
     * @param propertyId The property ID to be removed from the user.
     * @return A boolean value, true if properties contained the property.
     */
    public boolean removeProperty(Integer propertyId) {
        return properties.remove(propertyId);
    }
}
