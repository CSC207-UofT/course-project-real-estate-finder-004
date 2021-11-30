package entities;

import java.util.*;

public class Seller extends User {
    private final ArrayList<Integer> properties = new ArrayList<>();
    private final LinkedHashMap<String, Boolean> messages = new LinkedHashMap<>();

    /**
     * Constructs a new user given the relevant details.
     * @param name The user's given name.
     * @param username The user's username, which will be used for authentication. Note that this must be unique for all users.
     * @param email The user's email, for getting in contact with the buyers.
     * @param phone The user's phone number, for getting in contact with the buyers.
     * @param password The user's password, used for authentication.
     */
    public Seller(String name, String username, String email, String phone, String password) {
        super(name, username, email, phone, password);
    }

    /**
     * Adds a message object to the Seller, which will be displayed to the user when checking their unread messages.
     * @param message The message that will be passed to the user, as a string.
     */
    public void addMessage(String message) {
        messages.put(message, false);
    }

    /**
     * Marks a message as read, so it will not be displayed to the user when checking their unread messages.
     * @param message The message to mark as read.
     */
    public void messageRead(String message) {
        messages.put(message, true);
    }

    public void addProperty(Integer propertyId) {
        properties.add(propertyId);
    }

    public ArrayList<Integer> getProperties() {
        return properties;
    }

    public LinkedHashMap<String, Boolean> getMessages() {
        return messages;
    }

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

    public StringBuilder getUnreadMessagesString(ArrayList<String> unreadMessagesList) {
        StringBuilder unreadMessages = new StringBuilder();
        int counter = 1;
        for (String message : unreadMessagesList) {
            unreadMessages.append(counter).append(". ").append(message).append("\n");
        }
        return unreadMessages;
    }

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

    public boolean removeProperty(Integer propertyId) {
        return properties.remove(propertyId);
    }
}
