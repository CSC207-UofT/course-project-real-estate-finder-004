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

    private JPanel BuyerPanel;
    private JButton viewFilteredListings;
    private JButton signOut;
    private JPanel myPanel;
    private JButton viewLists;

    public BuyerFrame(Buyer buyer, DatabaseManager manager) {
        this.buyer = buyer;
        this.manager = manager;
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));
        setContentPane(BuyerPanel);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        viewFilteredListings.addActionListener(e -> {
            viewFilteredListings();
        });
        signOut.addActionListener(e -> {
            this.dispose();
        });
    }

    public void viewFilteredListings(){
        myPanel.removeAll();

        JLabel postalCode = new JLabel("Postal Code");
        myPanel.add(postalCode);
        JPanel postalCodePane = new JPanel();
        JLabel postalCodeText = new JLabel("Postal Code");
        JTextField postalCodeInput = new JTextField(10);
        postalCodePane.add(postalCodeText);
        postalCodePane.add(postalCodeInput);
        myPanel.add(postalCodePane);

        //JLabel = new JLabel();
        JButton filterButton = new JButton ("Filter");
        myPanel.add(filterButton);
        filterButton.addActionListener(e -> {
//            ArrayList<Integer> filteredProperties = this.buyer.searchProperties();
//            for(int properties: properties){
//            }
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

    public void showText(String stuff) {
//        for (int i = 0; i < 10; i++) {
//            JLabel text = new JLabel("TEST");
//            myPanel.add(text);
//        }
        JLabel listOne = new JLabel("8719 St.George Street");
        myPanel.add(listOne);
    }



    public static void main(String[] args) {
        DatabaseManager manager = new DatabaseManager();
        Buyer user = (Buyer) manager.loginUser("ame", "0000");


        BuyerFrame frame = new BuyerFrame(user, manager);
        frame.showText("TEST1 \n .TEST2");
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