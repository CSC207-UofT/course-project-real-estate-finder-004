package externalinterfaces;

import controllers.DatabaseManager;
import entities.Property;
import entities.Seller;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.ArrayList;

public class SellerFrame extends JFrame {
    private final DatabaseManager manager;
    private final Seller seller;
    private JPanel SellerPanel;
    private JButton viewListingsButton;
    private JButton viewMessagesButton;
    private JButton addListingsButton;
    private JButton signOutButton;
    private JPanel myPanel;

    public SellerFrame(Seller seller, DatabaseManager manager) {
        this.seller = seller;
        this.manager = manager;
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));
        setContentPane(SellerPanel);
        setSize(600, 600);
        loadProperties();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        viewListingsButton.addActionListener(e -> {
            loadProperties();
        });
        viewMessagesButton.addActionListener(e -> {
            showMessages();
        });

    }

    public void loadProperties() {
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
                loadProperties();
            });

            propertyPanel.add(button);

            myPanel.add(propertyPanel);
        }
        repaint();
        validate();
    }


    public void showMessages(){
        myPanel.removeAll();
        for (String message : seller.getUnreadMessages()) {
            JPanel propertyPanel = new JPanel();
            JLabel text = new JLabel(message);
            propertyPanel.add(text);
            JButton button = new JButton("Delete");
            button.addActionListener(e -> {
                seller.messageRead(message);
                showMessages();
            });

            propertyPanel.add(button);

            myPanel.add(propertyPanel);
        }
        repaint();
        validate();

    }


    public static void main(String[] args) {
        InitDatabaseProperty.main(new String[]{});
        InitDatabaseUser.main(new String[]{});

        DatabaseManager manager = new DatabaseManager();
        Seller user = (Seller) manager.loginUser("jsmith", "1234");
        manager.addProperty(user, "eqr3w4te",  "afdsgdh", "afdsgdh", "afdsgdh", "afdsgdh", 0.0f, 0, true);
        SellerFrame frame = new SellerFrame(user, manager);

    }
}
