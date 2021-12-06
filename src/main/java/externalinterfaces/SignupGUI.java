package externalinterfaces;

import controllers.DatabaseManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignupGUI extends JFrame implements ActionListener {
    private final GUI Gui;
    static DatabaseManager manager;
    JLabel signUpFormLabel, nameLabel, userTypeLabel, emailLabel, createPasswordLabel, confirmPasswordLabel, usernameLabel, countryLabel, phoneNumberLabel;
    JTextField nameTextField, emailTextField, usernameTextField, countryTextField, phoneNumberTextField;
    JButton submitButton, clearButton;
    JRadioButton buyerButton, sellerButton;
    JPasswordField createPasswordTextField, confirmPasswordTextField;

    public SignupGUI(GUI Gui) {
        setSize(700, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Signup Form");
        signUpFormLabel = new JLabel("Signup Form:");
        signUpFormLabel.setForeground(Color.blue);
        signUpFormLabel.setFont(new Font("Serif", Font.BOLD, 20));
        nameLabel = new JLabel("Name:");
        userTypeLabel = new JLabel("User Type:");
        emailLabel = new JLabel("Email-ID:");
        createPasswordLabel = new JLabel("Create Password:");
        confirmPasswordLabel = new JLabel("Confirm Password:");
        usernameLabel = new JLabel("Username:");
        countryLabel = new JLabel("Country:");
        phoneNumberLabel = new JLabel("Phone No:");
        nameTextField = new JTextField();
        buyerButton = new JRadioButton("Buyer");
        sellerButton = new JRadioButton("Seller");
        ButtonGroup userType = new ButtonGroup();
        userType.add(buyerButton);
        userType.add(sellerButton);
        emailTextField = new JTextField();
        createPasswordTextField = new JPasswordField();
        confirmPasswordTextField = new JPasswordField();
        usernameTextField = new JTextField();
        countryTextField = new JTextField();
        phoneNumberTextField = new JTextField();
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        submitButton.addActionListener(this);
        clearButton.addActionListener(this);
        signUpFormLabel.setBounds(100, 30, 400, 30);
        nameLabel.setBounds(80, 70, 200, 30);
        userTypeLabel.setBounds(80, 110, 200, 30);
        emailLabel.setBounds(80, 110, 200, 30);
        createPasswordLabel.setBounds(80, 150, 200, 30);
        confirmPasswordLabel.setBounds(80, 190, 200, 30);
        usernameLabel.setBounds(80, 230, 200, 30);
        countryLabel.setBounds(80, 270, 200, 30);
        phoneNumberLabel.setBounds(80, 310, 200, 30);
        nameTextField.setBounds(300, 70, 200, 30);
        buyerButton.setBounds(300, 350, 100, 30);
        sellerButton.setBounds(420, 350, 100, 30);
        emailTextField.setBounds(300, 110, 200, 30);
        createPasswordTextField.setBounds(300, 150, 200, 30);
        confirmPasswordTextField.setBounds(300, 190, 200, 30);
        usernameTextField.setBounds(300, 230, 200, 30);
        countryTextField.setBounds(300, 270, 200, 30);
        phoneNumberTextField.setBounds(300, 310, 200, 30);
        submitButton.setBounds(50, 350, 100, 30);
        clearButton.setBounds(170, 350, 100, 30);
        add(signUpFormLabel);
        add(nameLabel);
        add(nameTextField);
        add(userTypeLabel);
        add(buyerButton);
        add(sellerButton);
        add(emailLabel);
        add(emailTextField);
        add(createPasswordLabel);
        add(createPasswordTextField);
        add(confirmPasswordLabel);
        add(confirmPasswordTextField);
        add(usernameLabel);
        add(usernameTextField);
        add(countryLabel);
        add(countryTextField);
        add(phoneNumberLabel);
        add(phoneNumberTextField);
        add(submitButton);
        add(clearButton);

        this.Gui = Gui;
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameTextField.getText();
            String userType = userTypeSelection();
            String email = emailTextField.getText();
            char[] s3 = createPasswordTextField.getPassword();
            char[] s4 = confirmPasswordTextField.getPassword();
            String password = new String(s3);
            String confirmPassword = new String(s4);
            String username = usernameTextField.getText();
            String country = countryTextField.getText();
            String phoneNumber = phoneNumberTextField.getText();
            if (password.equals(confirmPassword)) {
                try {
                    if (Gui.signUpSuccess(name, userType, username, email, phoneNumber, password, confirmPassword)) {
                        JOptionPane.showMessageDialog(submitButton, "Data Saved Successfully");
                    } else {
                        JOptionPane.showMessageDialog(submitButton, "Failed to save information.");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else {
                JOptionPane.showMessageDialog(submitButton, "Password Does Not Match");
            }
        } else {
            nameTextField.setText("");
            emailTextField.setText("");
            createPasswordTextField.setText("");
            confirmPasswordTextField.setText("");
            usernameTextField.setText("");
            countryTextField.setText("");
            phoneNumberTextField.setText("");
        }
    }

    // helper method
    public String userTypeSelection() {
        if (buyerButton.isSelected()) {
            return new String("b");
        } else {
            return new String("s");

        }
    }

    public static void main(String args[]) {
//        SignupGUI signupGUI = new SignupGUI(new GUI(manager));
    }

}