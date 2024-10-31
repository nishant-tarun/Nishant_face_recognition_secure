package face.recognition;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel leftPanel, rightPanel;
    private Connection conn;

    public LoginPage() {
        setTitle("Login Page");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Center the frame

        conn = createDatabaseConnection();


        leftPanel = new JPanel();
        leftPanel.setBackground(new Color(52, 152, 219));  // Soft blue
        leftPanel.setPreferredSize(new Dimension(400, 500));
        leftPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        leftPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        leftPanel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        usernameField = new JTextField(20);
        leftPanel.add(usernameField, gbc);


        gbc.gridx = 0;
        gbc.gridy++;
        leftPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        leftPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginButtonListener());
        leftPanel.add(loginButton, gbc);

        add(leftPanel, BorderLayout.WEST);


        rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setPreferredSize(new Dimension(400, 500));


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(400,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,400,400);
        rightPanel.add(image);


        add(rightPanel, BorderLayout.EAST);
        setVisible(true);
    }

    private Connection createDatabaseConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/face_detection", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed.");
            return null;
        }
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (validateLogin(username, password)) {
                JOptionPane.showMessageDialog(LoginPage.this, "Login Successful!");
                openMainPage();
            } else {
                JOptionPane.showMessageDialog(LoginPage.this, "Invalid credentials, please try again.");
            }
        }

        private boolean validateLogin(String username, String password) {
            if (conn == null) return false;

            String query = "SELECT * FROM accounts WHERE username = ? AND password = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();
                return rs.next();  // True if a matching record is found
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }

    private void openMainPage() {
      new MainPage(); dispose();
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
