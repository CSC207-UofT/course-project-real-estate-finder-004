package externalinterfaces;

import controllers.DatabaseManager;
import entities.Property;
import entities.Seller;

import javax.swing.*;
import java.util.ArrayList;

public class SellerFrame extends JFrame {
    private final DatabaseManager manager;
    private final Seller seller;
    private final GUI gui;
    private JPanel SellerPanel;
    private JButton viewListingsButton;
    private JButton viewMessagesButton;
    private JButton addListingsButton;
    private JButton signOutButton;
    private JPanel myPanel;

    public SellerFrame(Seller seller, GUI gui, DatabaseManager manager) {
        this.seller = seller;
        this.gui = gui;
        this.manager = manager;
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));
        setContentPane(SellerPanel);
        setSize(600, 600);

        viewListings();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        viewListingsButton.addActionListener(e -> {
            viewListings();
        });
        viewMessagesButton.addActionListener(e -> {
            viewMessages();
        });
        addListingsButton.addActionListener(e -> {
            addListings();
        });
        signOutButton.addActionListener(e -> {
            this.gui.signOut();
        });
    }

    private void addListings() {
        myPanel.removeAll();
        JLabel text = new JLabel("Input the information for your property:");
        myPanel.add(text);
        JPanel addressPane = new JPanel();
        JLabel addressText = new JLabel("Address");
        JTextField addressInput = new JTextField(10);
        addressPane.add(addressText);
        addressPane.add(addressInput);
        myPanel.add(addressPane);
        JPanel cityPane = new JPanel();
        JLabel cityText = new JLabel("City");
        JTextField cityInput = new JTextField(10);
        cityPane.add(cityText);
        cityPane.add(cityInput);
        myPanel.add(cityPane);
        JPanel provincePane = new JPanel();
        JLabel provinceText = new JLabel("Province");
        JTextField provinceInput = new JTextField(10);
        provincePane.add(provinceText);
        provincePane.add(provinceInput);
        myPanel.add(provincePane);
        JPanel countryPane = new JPanel();
        JLabel countryText = new JLabel("Country");
        JTextField countryInput = new JTextField(10);
        countryPane.add(countryText);
        countryPane.add(countryInput);
        myPanel.add(countryPane);
        JPanel postalCodePane = new JPanel();
        JLabel postalCodeText = new JLabel("Postal Code");
        JTextField postalCodeInput = new JTextField(10);
        postalCodePane.add(postalCodeText);
        postalCodePane.add(postalCodeInput);
        myPanel.add(postalCodePane);

        JPanel pricePane = new JPanel();
        JLabel priceText = new JLabel("Price");
        JTextField priceInput = new JTextField(10);
        pricePane.add(priceText);
        pricePane.add(priceInput);
        myPanel.add(pricePane);
        JPanel sqftPane = new JPanel();
        JLabel sqftText = new JLabel("Square Feet");
        JTextField sqftInput = new JTextField(10);
        sqftPane.add(sqftText);
        sqftPane.add(sqftInput);
        myPanel.add(sqftPane);

        JPanel AvailabilityPane = new JPanel();
        JLabel AvailabilityText = new JLabel("Available?");
        JRadioButton AvailabilityInput = new JRadioButton();
        AvailabilityPane.add(AvailabilityText);
        AvailabilityPane.add(AvailabilityInput);
        myPanel.add(AvailabilityPane);


        JButton submitButton = new JButton("Add Property");
        myPanel.add(submitButton);
        submitButton.addActionListener(e -> {
            try {
                int sqftInteger = Integer.parseInt(sqftInput.getText());
                float priceFloat = Float.parseFloat(priceInput.getText());
                manager.addProperty(seller, addressInput.getText(), cityInput.getText(), provinceInput.getText(), countryInput.getText(), postalCodeInput.getText(), priceFloat, sqftInteger, AvailabilityInput.isSelected());
                addListings();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(this, "Incorrect values for listing.");
            }

        });

        repaint();
        validate();
    }

    public void viewListings() {
        myPanel.removeAll();

        ArrayList<Integer> propertyIDs = this.seller.getProperties();
        for (int propertyID : propertyIDs) {
            Property property = manager.getProperty(propertyID);
            JPanel propertyPanel = new JPanel();
            JLabel text = new JLabel(property.getStreetAddress());
            propertyPanel.add(text);
            JButton button = new JButton("Delete");
            button.addActionListener(e -> {
                seller.removeProperty(propertyID);
                viewListings();
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
        if (propertyIDs.size() == 0) {
            JPanel propertyPanel = new JPanel();
            JLabel text = new JLabel("You have no listings. \n Add one with the Add Listing button.");
            propertyPanel.add(text);
            myPanel.add(propertyPanel);
        }

        repaint();
        validate();
    }

    public void viewMessages() {
        myPanel.removeAll();
        ArrayList<String> messages = seller.getUnreadMessages();
        for (String message : messages) {
            JPanel propertyPanel = new JPanel();
            JLabel text = new JLabel(message);
            propertyPanel.add(text);
            JButton button = new JButton("Mark As Read");
            button.addActionListener(e -> {
                seller.messageRead(message);
                viewMessages();
            });

            propertyPanel.add(button);

            myPanel.add(propertyPanel);
        }
        if (messages.size() == 0) {
            JPanel propertyPanel = new JPanel();
            JLabel text = new JLabel("You have no messages.");
            propertyPanel.add(text);
            myPanel.add(propertyPanel);
        }

        repaint();
        validate();
    }
}