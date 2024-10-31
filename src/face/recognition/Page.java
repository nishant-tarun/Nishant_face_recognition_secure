package face.recognition;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Page extends JFrame {
    public Page() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPage = new JLabel("This is a new page");
        lblPage.setBounds(100, 100, 200, 30);
        contentPane.add(lblPage);
    }
}