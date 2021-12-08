package externalinterfaces;

import entities.Seller;
import controllers.DatabaseManager;
import entities.Property;
import entities.Buyer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BuyerFrame extends JFrame {
    private final DatabaseManager manager;
    private final Buyer buyer;
    private final GUI gui;

    private JPanel BuyerPanel;
    private JButton viewFilteredListings;
    private JButton signOut;
    private JPanel myPanel;
    private JButton viewWishLists;

    public BuyerFrame(Buyer buyer, GUI gui, DatabaseManager manager) {
        this.buyer = buyer;
        this.manager = manager;
        this.gui = gui;

        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));
        setContentPane(BuyerPanel);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        viewFilteredListings.addActionListener(e -> {
            addFilteredListings();
        });
        viewWishLists.addActionListener(e -> {
            viewShortListProperties();
        });
        signOut.addActionListener(e -> {
            gui.signOut();
        });
    }

    public void addFilteredListings() {
        myPanel.removeAll();

        JLabel postalCode = new JLabel("Postal Code");
        myPanel.add(postalCode);
        JPanel postalCodePane = new JPanel();
        JLabel postalCodeText = new JLabel("Postal Code");
        JTextField postalCodeInput = new JTextField(10);
        postalCodePane.add(postalCodeText);
        postalCodePane.add(postalCodeInput);
        myPanel.add(postalCodePane);

        JLabel minPrice = new JLabel("Min Price");
        myPanel.add(minPrice);
        JPanel minPricePane = new JPanel();
        JLabel minPriceText = new JLabel("Min Price");
        JTextField minPriceInput = new JTextField(10);
        minPricePane.add(minPriceText);
        minPricePane.add(minPriceInput);
        myPanel.add(minPricePane);


        JLabel maxPrice = new JLabel("Max Price");
        myPanel.add(maxPrice);
        JPanel maxPricePane = new JPanel();
        JLabel maxPriceText = new JLabel("Max Price");
        JTextField maxPriceInput = new JTextField(10);
        maxPricePane.add(maxPriceText);
        maxPricePane.add(maxPriceInput);
        myPanel.add(maxPricePane);

//        JLabel minSqft = new JLabel("Min Square Feet");
//        myPanel.add(minSqft);
//        JPanel minSqftPane = new JPanel();
//        JLabel minSqftText = new JLabel("Min Square Feet");
//        JTextField minSqftInput = new JTextField(10);
//        minSqftPane.add(minSqft);
//        minSqftPane.add(minSqft);
//        myPanel.add(minSqft);


        int minSqftVar = 50;
        int maxSqftVar = 200;
        int numberOfRoomVar = -1;
        int numberOfBathroomsVar = -1;

        JButton filterButton = new JButton("Filter");
        myPanel.add(filterButton);
        filterButton.addActionListener(e -> {
            String postalCodeVar = postalCodeInput.getText();
            float minPriceVar = Float.parseFloat(minPriceInput.getText());
            float maxPriceVar = Float.parseFloat(maxPriceInput.getText());
            viewFilteredListings(postalCodeVar, minPriceVar, maxPriceVar, minSqftVar, maxSqftVar, numberOfRoomVar, numberOfBathroomsVar);
        });

        repaint();
        validate();
//        JLabel minPrice = new JLabel("Min Price");
//        JLabel maxPrice = new JLabel("Max Price");
//        JLabel minSqft = new JLabel("Min Square Feet");
//        JLabel maxSqft = new JLabel("Max Square Feet");
//        JLabel noOfRooms = new JLabel("No. of Rooms");
//        JLabel noOfBathrooms = new JLabel("No. of Bathrooms");

    }

    public void viewFilteredListings(String postalCodeVar, float minPriceVar, float maxPriceVar, int minSqftVar, int maxSqftVar, int numberOfRoomVar, int numberOfBathroomsVar) {
        myPanel.removeAll();

        ArrayList<Integer> propertyIDs = this.manager.searchProperties(postalCodeVar, minPriceVar, maxPriceVar, minSqftVar, maxSqftVar, numberOfRoomVar, numberOfBathroomsVar);
        for (int propertyID : propertyIDs) {
            Property property = manager.getProperty(propertyID);
            JPanel propertyPanel = new JPanel();
            JLabel propertyText = new JLabel(property.getStreetAddress());
            propertyPanel.add(propertyText);

            JButton AddToWishListButton = new JButton("Add");
            AddToWishListButton.addActionListener(e -> {
                buyer.shortListProperty(propertyID);

                //Add message system
                property.addWishListedBuyer(buyer);
                property.getOwner().addMessage(buyer.getUsername() + " is interested in " + property.getStreetAddress());
                viewFilteredListings(postalCodeVar, minPriceVar, maxPriceVar, minSqftVar, maxSqftVar, numberOfRoomVar, numberOfBathroomsVar);
            });
            propertyPanel.add(AddToWishListButton);
            myPanel.add(propertyPanel);
        }

        repaint();
        validate();

    }

    public void showText(String stuff) {
//        for (int i = 0; i < 10; i++) {
//            JLabel text = new JLabel("TEST");
//            myPanel.add(text);
//        }
        //JLabel listOne = new JLabel("8719 St.George Street");
        //myPanel.add(listOne);
    }

    public void viewShortListProperties() {
        myPanel.removeAll();

        ArrayList<Integer> shortListIDs = this.buyer.getInterestedProperties();
        for (int shortListID : shortListIDs) {
            Property property = manager.getProperty(shortListID);
            JPanel propertyPanel = new JPanel();
            JLabel text = new JLabel(property.getStreetAddress());
            propertyPanel.add(text);
            JButton button = new JButton("Delete");
            button.addActionListener(e -> {
                buyer.removeShortListProperty(shortListID);
                viewShortListProperties();
            });
            propertyPanel.add(button);
            JButton viewButton = new JButton("Details");
            viewButton.addActionListener(e -> {
                JPanel testPanel = new JPanel();
                testPanel.setLayout(new BoxLayout(testPanel, BoxLayout.PAGE_AXIS));
                testPanel.add(new JLabel("Address: " + property.getStreetAddress()));
                testPanel.add(new JLabel("City: " + property.getCity()));
                testPanel.add(new JLabel("Province: " + property.getProvince()));
                testPanel.add(new JLabel("Country: " + property.getCountry()));
                testPanel.add(new JLabel("Postal Code: " + property.getPostalCode()));
                testPanel.add(new JLabel("Price: " + property.getPrice()));
                testPanel.add(new JLabel("Square Feet: " + property.getSqft()));
                JOptionPane.showMessageDialog(this, testPanel);
            });
            propertyPanel.add(viewButton);

            myPanel.add(propertyPanel);
        }
        if (shortListIDs.size() == 0) {
            JPanel propertyPanel = new JPanel();
            propertyPanel.setLayout(new BoxLayout(propertyPanel, BoxLayout.PAGE_AXIS));
            JLabel text = new JLabel("You have no shortlisted properties.");
            propertyPanel.add(text);
            JLabel text2 = new JLabel("Add one with the View Listing button.");
            propertyPanel.add(text2);
            myPanel.add(propertyPanel);
        }

        repaint();
        validate();
    }

    public void SendMessage(){
        myPanel.removeAll();


    }
    public static void main(String[] args) {
        DatabaseManager manager = new DatabaseManager();
        Buyer user = (Buyer) manager.loginUser("ame", "0000");


//        BuyerFrame frame = new BuyerFrame(user, manager);
//        frame.showText("TEST1 \n .TEST2");
//        JFrame frame = new JFrame();
//
//        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
//
//
//        for (int i = 0; i < 10; i++) {
//            JLabel label = new JLabel("Label" + i);
//            frame.add(label);
//        }
//
//        frame.setVisible(true);
//
//        // optional, but nice to have.
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

//    private void createUIComponents() {
//        // TODO: place custom component creation code here
//    }
}