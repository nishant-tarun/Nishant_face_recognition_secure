package face.recognition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {

    public MainPage() {
        setTitle("Main Page");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Absolute positioning
        setLocationRelativeTo(null); // Center the frame

        // Heading at the top
        JLabel headingLabel = new JLabel("Choose an Option");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setBounds(300, 30, 230, 50);
        add(headingLabel);

        // Register Face Button
        JButton registerFaceButton = new JButton("Register Face");
        registerFaceButton.setBounds(150, 150, 170, 100);
        registerFaceButton.setFont(new Font("Arial", Font.BOLD, 16));
        registerFaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new register().setVisible(true);

                fire();
               
            }
        });

        // Recognise Face Button
        JButton recogniseFaceButton = new JButton("Recognise Face");
        recogniseFaceButton.setBounds(325, 150, 170, 100);
        recogniseFaceButton.setFont(new Font("Arial", Font.BOLD, 16));
        recogniseFaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new  recognise();
                fire();

            }
        });

        // Data Button
        JButton dataButton = new JButton("Data");
        dataButton.setBounds(500, 150, 170, 100);
        dataButton.setFont(new Font("Arial", Font.BOLD, 16));
        dataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new data();
                fire();
            }
        });

        // Add buttons to the frame
        add(registerFaceButton);
        add(recogniseFaceButton);
        add(dataButton);

        setVisible(true);
    }

void  fire(){

    this.dispose();
}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainPage::new);
    }
}
