import java.util.ArrayList;

public class Seller extends User {
    private ArrayList<Property> properties = new ArrayList<Property>();

    public Seller(String name, String username, String email, String phone, String password) {
        super(name, username, email, phone, password);
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public Property removeProperty(int index) {
        return properties.remove(index);
    }
}
