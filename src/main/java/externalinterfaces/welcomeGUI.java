package externalinterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcomeGUI extends JFrame implements ActionListener {
    Container container = getContentPane();
//    JLabel userLabel = new JLabel("USERNAME");
//    JLabel passwordLabel = new JLabel("PASSWORD");
//    JTextField userTextField = new JTextField();
//    JPasswordField passwordField = new JPasswordField();
//    JButton loginButton = new JButton("LOGIN");
//    JButton resetButton = new JButton("RESET");
//    JCheckBox showPassword = new JCheckBox("Show Password");

    JLabel welcomeLabel = new JLabel("Welcome");
    JButton welcomeLoginButton = new JButton ("Login");
    JButton welcomeSignupButton = new JButton ("Signup");


    welcomeGUI() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
//        userLabel.setBounds(50, 150, 100, 30);
//        passwordLabel.setBounds(50, 220, 100, 30);
//        userTextField.setBounds(150, 150, 150, 30);
//        passwordField.setBounds(150, 220, 150, 30);
//        showPassword.setBounds(150, 250, 150, 30);\


        welcomeLabel.setBounds(50, 150, 100, 30);
        welcomeLoginButton.setBounds(50, 300, 100, 30);
        welcomeSignupButton.setBounds(200, 300, 100, 30);
//        loginButton.setBounds(50, 300, 100, 30);
//        resetButton.setBounds(200, 300, 100, 30);


    }

    public void addComponentsToContainer() {
//        container.add(userLabel);
//        container.add(passwordLabel);
//        container.add(userTextField);
//        container.add(passwordField);
//        container.add(showPassword);
//        container.add(loginButton);
//        container.add(resetButton);
        container.add(welcomeLabel);
        container.add(welcomeLoginButton);
        container.add(welcomeSignupButton);
    }

    public void addActionEvent() {
        welcomeLoginButton.addActionListener(this);
        welcomeSignupButton.addActionListener(this);

//        loginButton.addActionListener(this);
//        resetButton.addActionListener(this);
//        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        //Coding Part of LOGIN button
//        if (e.getSource() == loginButton) {
//            String userText;
//            String pwdText;
//            userText = userTextField.getText();
//            pwdText = passwordField.getText();
//            if (userText.equalsIgnoreCase("mehtab") && pwdText.equalsIgnoreCase("12345")) {
//                JOptionPane.showMessageDialog(this, "Login Successful");
//            } else {
//                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
//            }
//
//        }
//        //Coding Part of RESET button
//        if (e.getSource() == resetButton) {
//            userTextField.setText("");
//            passwordField.setText("");
//        }
//        //Coding Part of showPassword JCheckBox
//        if (e.getSource() == showPassword) {
//            if (showPassword.isSelected()) {
//                passwordField.setEchoChar((char) 0);
//            } else {
//                passwordField.setEchoChar('*');
//            }
//
//
//        }

        //TODO: Implement after clicking welcomeLoginButton and welcomeSignupButton, it goes to the next Frame
    }

    public static void main(String[] a) {
        // Create object for externalinterfaces.loginGUI class and set properties
        welcomeGUI frame = new welcomeGUI();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
