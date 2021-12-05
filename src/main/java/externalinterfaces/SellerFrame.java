package externalinterfaces;

import entities.Seller;

import javax.swing.*;
import java.awt.*;

public class SellerFrame extends JFrame {
    private JPanel SellerPanel;
    private JButton button4;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel myPanel;

    public SellerFrame() {
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));
        setContentPane(SellerPanel);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void showText(String stuff) {
        for (int i = 0; i < 10; i++) {
            JLabel text = new JLabel("TEST");
            myPanel.add(text);
        }
    }


    public static void main(String[] args) {
        SellerFrame frame = new SellerFrame();
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
//
//        frame.setVisible(true);
//
//        // optional, but nice to have.
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
