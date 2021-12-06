package externalinterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectionKey;

public class WelcomeGUI extends JFrame implements ActionListener {
    private final GUI gui;
    Container container = getContentPane();

    JLabel welcomeLabel = new JLabel("Welcome");
    JButton welcomeLoginButton = new JButton ("Login");
    JButton welcomeSignupButton = new JButton ("Signup");


    WelcomeGUI(GUI gui) {
        this.gui = gui;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        start();
    }

    public void start() {
        this.setTitle("Login Form");
        this.setBounds(10, 10, 370, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        welcomeLabel.setBounds(50, 150, 100, 30);
        welcomeLoginButton.setBounds(50, 300, 100, 30);
        welcomeSignupButton.setBounds(200, 300, 100, 30);
    }

    public void addComponentsToContainer() {
        container.add(welcomeLabel);
        container.add(welcomeLoginButton);
        container.add(welcomeSignupButton);
    }

    public void addActionEvent() {
        welcomeLoginButton.addActionListener(this);
        welcomeSignupButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: Implement after clicking welcomeLoginButton and welcomeSignupButton, it goes to the next Frame
        if (e.getSource() == welcomeLoginButton){
            gui.startLogin();
        }
        if (e.getSource() == welcomeSignupButton) {
            gui.startSignUp();
        }

        //TODO: the above code will work if SignUpGUI class is merged successfully.
    }


    public static void main(String[] a) {
//        WelcomeGUI frame = new WelcomeGUI();
//        frame.setTitle("Login Form");
//        frame.setVisible(true);
//        frame.setBounds(10, 10, 370, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
    }
}
