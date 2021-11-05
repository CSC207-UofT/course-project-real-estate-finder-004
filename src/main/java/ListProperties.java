public class ListProperties {
    public String getListOfProperties(Seller user) {
        StringBuilder returnString = new StringBuilder();
        for (Property property: user.getProperties()) {
            returnString.append("Property: \n");
            returnString.append("Address: ").append(property.getStreetAddress()).append(" ").append(property.getCity()).append(" ").append(property.getProvince()).append('\n');
            returnString.append(property.getSqft()).append(" square feet\n");
            returnString.append("Price: $").append(property.getPrice()).append("\n\n");
        }
        return returnString.toString();
    }
}
