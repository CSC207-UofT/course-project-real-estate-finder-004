import java.util.ArrayList;

public class Buyer extends User {
    private ArrayList<Property> interestedProperties = new ArrayList<Property>();

    public Buyer(String name, String email, String phone, String password) {
        super(name, email, phone, password);
    }

    public void shortListProperty(Property property) {
        interestedProperties.add(property);
    }

}
