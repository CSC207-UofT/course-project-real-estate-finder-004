import java.lang.reflect.Array;
import java.util.*;

public class Seller extends User {
    private ArrayList<Property> properties = new ArrayList<>();
    private LinkedHashMap<String, Boolean> messages = new LinkedHashMap<>();

    public Seller(String name, String username, String email, String phone, String password) {
        super(name, username, email, phone, password);
    }

    public void addMessage(String message) { messages.put(message, false); }

    public void messageRead(String message) {messages.put(message, true); }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public LinkedHashMap<String, Boolean> getMessages() {return messages; }

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
        StringBuilder unreadMessages = null;
        int counter = 1;
        for (String message : unreadMessagesList) {
            unreadMessages.append(counter + ". " + message + "\n");
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

    public Property removeProperty(int index) {
        return properties.remove(index);
    }
}
