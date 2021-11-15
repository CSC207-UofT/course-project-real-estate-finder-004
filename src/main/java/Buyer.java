import java.util.ArrayList;

public class Buyer extends User {
    private ArrayList<Property> interestedProperties = new ArrayList<Property>();

    public Buyer(String name, String username, String email, String phone, String password) {
        super(name, username, email, phone, password);
    }

    public void shortListProperty(Property property) {
        interestedProperties.add(property);
    }

    public ArrayList<Property> getInterestedProperties() {
        return interestedProperties;
    }


}
