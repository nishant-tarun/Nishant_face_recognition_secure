package face.recognition;



//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.util.UUID;
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.videoio.VideoCapture;
//import org.opencv.imgcodecs.Imgcodecs;
//
//public class register extends JFrame {
//    private JTextField nameField, phoneField, userIdField;
//    private JLabel cameraLabel, countdownLabel;
//    private JButton captureButton, saveButton;
//    private VideoCapture camera;
//    private Timer captureTimer;
//    private int countdown = 15;
//    private UUID uniqueId;
//    private File imageFolder;
//
//    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); } // Load OpenCV native library
//
//    public register() {
//        setTitle("Register Face");
//        setSize(800, 500);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(null); // Absolute positioning
//        setLocationRelativeTo(null);
//
//        // Webcam Preview Label
//        cameraLabel = new JLabel();
//        cameraLabel.setBounds(20, 50, 320, 240);
//        cameraLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        add(cameraLabel);
//
//        // Countdown Label
//        countdownLabel = new JLabel("Please wait...");
//        countdownLabel.setBounds(120, 300, 200, 30);
//        add(countdownLabel);
//
//        // Right Side Form Fields
//        JLabel nameLabel = new JLabel("Name:");
//        nameLabel.setBounds(400, 100, 100, 30);
//        nameField = new JTextField();
//        nameField.setBounds(500, 100, 200, 30);
//
//        JLabel phoneLabel = new JLabel("Phone:");
//        phoneLabel.setBounds(400, 150, 100, 30);
//        phoneField = new JTextField();
//        phoneField.setBounds(500, 150, 200, 30);
//
//        JLabel userIdLabel = new JLabel("User ID:");
//        userIdLabel.setBounds(400, 200, 100, 30);
//        userIdField = new JTextField();
//        userIdField.setBounds(500, 200, 200, 30);
//
//        // Capture and Save Buttons
//        captureButton = new JButton("Capture");
//        captureButton.setBounds(100, 400, 120, 40);
//        captureButton.addActionListener(new CaptureAction());
//
//        saveButton = new JButton("Save");
//        saveButton.setBounds(500, 300, 120, 40);
//        saveButton.addActionListener(new SaveAction());
//
//        // Add components to frame
//        add(nameLabel);
//        add(nameField);
//        add(phoneLabel);
//        add(phoneField);
//        add(userIdLabel);
//        add(userIdField);
//        add(captureButton);
//        add(saveButton);
//
//        setVisible(true);
//    }
//
//    // Action to start capturing images
//    private class CaptureAction implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (camera == null) {
//                camera = new VideoCapture(0);
//            }
//
//            if (camera.isOpened()) {
//                uniqueId = UUID.randomUUID(); // Generate unique ID
//                imageFolder = new File("images/" + uniqueId);
//                imageFolder.mkdirs();
//
//                countdown = 15; // Reset countdown
//                countdownLabel.setText("Wait for " + countdown + " seconds...");
//
//                captureTimer = new Timer(500, new ActionListener() {
//                    private int photoCount = 0;
//
//                    @Override
//                    public void actionPerformed(ActionEvent ev) {
//                        if (countdown > 0) {
//                            countdownLabel.setText("Wait for " + countdown + " seconds...");
//                            countdown--;
//                        } else {
//                            if (photoCount < 15) {
//                                Mat frame = new Mat();
//                                if (camera.read(frame)) {
//                                    Imgcodecs.imwrite(imageFolder.getPath() + "/photo_" + photoCount + ".jpg", frame);
//                                    photoCount++;
//                                }
//                            } else {
//                                captureTimer.stop();
//                                countdownLabel.setText("Capture complete!");
//                                camera.release();
//                            }
//                        }
//                    }
//                });
//                captureTimer.start();
//            } else {
//                JOptionPane.showMessageDialog(null, "Could not access camera.");
//            }
//        }
//    }
//
//    // Action to save user details in the database
//    private class SaveAction implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String name = nameField.getText();
//            String phone = phoneField.getText();
//            String userId = userIdField.getText();
//
//            if (name.isEmpty() || phone.isEmpty() || userId.isEmpty() || uniqueId == null) {
//                JOptionPane.showMessageDialog(null, "Please fill all fields and capture images first.");
//                if (imageFolder != null) {
//                    deleteFolder(imageFolder);
//                }
//                return;
//            }
//
//            try {
//                // Connect to database and save data
//                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "username", "password");
//                String query = "INSERT INTO people (user_id, name, phone, image_folder) VALUES (?, ?, ?, ?)";
//                PreparedStatement stmt = conn.prepareStatement(query);
//                stmt.setString(1, userId);
//                stmt.setString(2, name);
//                stmt.setString(3, phone);
//                stmt.setString(4, imageFolder.getPath());
//
//                stmt.executeUpdate();
//                stmt.close();
//                conn.close();
//
//                JOptionPane.showMessageDialog(null, "Data saved successfully.");
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                JOptionPane.showMessageDialog(null, "Error saving data.");
//            }
//        }
//    }
//
//    // Method to delete the folder if data is not saved
//    private void deleteFolder(File folder) {
//        File[] files = folder.listFiles();
//        if (files != null) {
//            for (File file : files) {
//                file.delete();
//            }
//        }
//        folder.delete();
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(register::new);
//    }
//}










//
//
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.videoio.VideoCapture;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//
//
//
//
//public class register extends JFrame {
//    private JLabel captureLabel;
//    private JLabel timeLabel;
//    private JLabel counterLabel;
//    private JTextField nameField;
//    private JTextField phoneField;
//    private JTextField userIdField;
//    private JButton captureButton;
//    private JButton saveButton;
//    private JButton backButton;
//    private VideoCapture camera;
//    private Timer timer;
//    private int photoCount = 0;
//    private int captureTime = 8; // 8 seconds for 15 photos (approx. 2 per second)
//    private String uniqueFolderPath;
//
//    public register() {
//        setTitle("Face Registration");
//        setSize(800, 500);
//        setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Camera preview panel on the left
//        captureLabel = new JLabel();
//        captureLabel.setBounds(50, 50, 300, 300);
//        captureLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        add(captureLabel);
//
//        // Capture button and status labels
//        captureButton = new JButton("Capture");
//        captureButton.setBounds(150, 370, 100, 30);
//        add(captureButton);
//
//        timeLabel = new JLabel("Wait for " + captureTime + " seconds");
//        timeLabel.setBounds(50, 420, 300, 20);
//        add(timeLabel);
//
//        counterLabel = new JLabel("0 photos have been clicked");
//        counterLabel.setBounds(50, 450, 300, 20);
//        add(counterLabel);
//
//        // Fields and labels on the right side for user details
//        JLabel nameLabel = new JLabel("Name:");
//        nameLabel.setBounds(400, 50, 100, 30);
//        add(nameLabel);
//
//        nameField = new JTextField();
//        nameField.setBounds(500, 50, 200, 30);
//        add(nameField);
//
//        JLabel phoneLabel = new JLabel("Phone:");
//        phoneLabel.setBounds(400, 100, 100, 30);
//        add(phoneLabel);
//
//        phoneField = new JTextField();
//        phoneField.setBounds(500, 100, 200, 30);
//        add(phoneField);
//
//        JLabel userIdLabel = new JLabel("User ID:");
//        userIdLabel.setBounds(400, 150, 100, 30);
//        add(userIdLabel);
//
//        userIdField = new JTextField();
//        userIdField.setBounds(500, 150, 200, 30);
//        add(userIdField);
//
//        saveButton = new JButton("Save");
//        saveButton.setBounds(400, 200, 100, 30);
//        add(saveButton);
//
//        backButton = new JButton("Back");
//        backButton.setBounds(520, 200, 100, 30);
//        add(backButton);
//
//        // Set up the camera
//        camera = new VideoCapture(0);
//        if (!camera.isOpened()) {
//            JOptionPane.showMessageDialog(this, "Error: Camera not found");
//            System.exit(1);
//        }
//
//        // Action listeners for buttons
//        captureButton.addActionListener(e -> startCapture());
//        saveButton.addActionListener(e -> saveData());
//        backButton.addActionListener(e -> backAction());
//
//        // Live camera preview setup
//        timer = new Timer(30, e -> updateCameraPreview());
//        timer.start();
//    }
//
//    private void updateCameraPreview() {
//        Mat frame = new Mat();
//        if (camera.read(frame)) {
//            ImageIcon icon = new ImageIcon(OpenCVUtils.matToBufferedImage(frame));
//            captureLabel.setIcon(icon);
//        }
//    }
//
//    private void startCapture() {
//        photoCount = 0;
//        captureTime = 8;
//        timeLabel.setText("Wait for " + captureTime + " seconds");
//        counterLabel.setText(photoCount + " photos have been clicked");
//
//        // Capture photos in intervals
//        Timer captureTimer = new Timer(500, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (photoCount < 15) {
//                    // Capture photo and store it in the folder
//                    Mat frame = new Mat();
//                    camera.read(frame);
//                    OpenCVUtils.saveImage(frame, uniqueFolderPath, "photo_" + photoCount + ".jpg");
//                    photoCount++;
//                    captureTime = Math.max(0, captureTime - 1);
//                    timeLabel.setText("Wait for " + captureTime + " seconds");
//                    counterLabel.setText(photoCount + " photos have been clicked");
//                } else {
//                    ((Timer) e.getSource()).stop();
//                }
//            }
//        });
//        captureTimer.start();
//    }
//
//    private void saveData() {
//        String name = nameField.getText();
//        String phone = phoneField.getText();
//        String userId = userIdField.getText();
//
//        if (name.isEmpty() || phone.isEmpty() || userId.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "All fields are required");
//            return;
//        }
//
//        // Save data to database and unique folder path
//        DatabaseUtils.saveUserData(name, phone, userId);
//        JOptionPane.showMessageDialog(this, "Data saved successfully!");
//
//        uniqueFolderPath = null;  // Prevent folder deletion
//    }
//
//    private void backAction() {
//        if (uniqueFolderPath != null) {
//            deleteFolder(new File(uniqueFolderPath));
//        }
//        dispose(); // Close the current frame
//    }
//
//    private void deleteFolder(File folder) {
//        if (folder.isDirectory()) {
//            for (File file : folder.listFiles()) {
//                deleteFolder(file);
//            }
//        }
//        folder.delete();
//    }
//
//    public static void main(String[] args) {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        SwingUtilities.invokeLater(() -> new register().setVisible(true));
//    }
//}




















//
//
//
//
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.videoio.VideoCapture;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//
//public class register extends JFrame {
//    private JLabel captureLabel;
//    private JLabel timeLabel;
//    private JLabel counterLabel;
//    private JTextField nameField;
//    private JTextField phoneField;
//    private JTextField userIdField;
//    private JButton captureButton;
//    private JButton saveButton;
//    private JButton backButton;
//    private VideoCapture camera;
//    private Timer previewTimer;
//    private Timer captureTimer;
//    private int photoCount = 0;
//    private int captureTime = 8; // Total capture time in seconds
//    private String uniqueFolderPath;
//    private boolean dataSaved = false; // Flag to track if data is saved
//
//    public register() {
//        setTitle("Face Registration");
//        setSize(800, 500);
//        setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Camera preview panel on the left
//        captureLabel = new JLabel();
//        captureLabel.setBounds(50, 50, 300, 300);
//        captureLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        add(captureLabel);
//
//        // Capture button and status labels
//        captureButton = new JButton("Capture");
//        captureButton.setBounds(150, 370, 100, 30);
//        add(captureButton);
//
//        timeLabel = new JLabel();
//        timeLabel.setBounds(50, 420, 300, 20);
//        timeLabel.setVisible(false); // Hidden initially
//        add(timeLabel);
//
//        counterLabel = new JLabel();
//        counterLabel.setBounds(50, 450, 300, 20);
//        counterLabel.setVisible(false); // Hidden initially
//        add(counterLabel);
//
//        // Fields and labels on the right side for user details
//        JLabel nameLabel = new JLabel("Name:");
//        nameLabel.setBounds(400, 50, 100, 30);
//        add(nameLabel);
//
//        nameField = new JTextField();
//        nameField.setBounds(500, 50, 200, 30);
//        add(nameField);
//
//        JLabel phoneLabel = new JLabel("Phone:");
//        phoneLabel.setBounds(400, 100, 100, 30);
//        add(phoneLabel);
//
//        phoneField = new JTextField();
//        phoneField.setBounds(500, 100, 200, 30);
//        add(phoneField);
//
//        JLabel userIdLabel = new JLabel("User ID:");
//        userIdLabel.setBounds(400, 150, 100, 30);
//        add(userIdLabel);
//
//        userIdField = new JTextField();
//        userIdField.setBounds(500, 150, 200, 30);
//        add(userIdField);
//
//        saveButton = new JButton("Save");
//        saveButton.setBounds(400, 200, 100, 30);
//        add(saveButton);
//
//        backButton = new JButton("Back");
//        backButton.setBounds(520, 200, 100, 30);
//        add(backButton);
//
//        // Set up the camera
//        camera = new VideoCapture(0);
//        if (!camera.isOpened()) {
//            JOptionPane.showMessageDialog(this, "Error: Camera not found");
//            System.exit(1);
//        }
//
//        // Action listeners for buttons
//        captureButton.addActionListener(e -> startCapture());
//        saveButton.addActionListener(e -> saveData());
//        backButton.addActionListener(e -> backAction());
//
//        // Live camera preview
//        startLivePreview();
//    }
//
//    private void startLivePreview() {
//        previewTimer = new Timer(30, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Mat frame = new Mat();
//                if (camera.read(frame)) {
//                    ImageIcon icon = new ImageIcon(OpenCVUtils.matToBufferedImage(frame));
//                    captureLabel.setIcon(icon);
//                }
//            }
//        });
//        previewTimer.start();
//    }
//
//    private void startCapture() {
//        // Generate unique folder path for each capture session
//        String userId = userIdField.getText().trim();
////        uniqueFolderPath = "path/to/storage/" + userId + "_" + System.currentTimeMillis();
//        uniqueFolderPath = "path/to/storage/" + userId + "_" + System.currentTimeMillis();
//
//        // Reset photo count and start showing the time and count labels
//        photoCount = 0;
//        captureTime = 8;
//        timeLabel.setText("Wait for " + captureTime + " seconds");
//        counterLabel.setText(photoCount + " photos have been clicked");
//        timeLabel.setVisible(true);
//        counterLabel.setVisible(true);
//
//        // Capture photos in intervals
//        captureTimer = new Timer(500, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (photoCount < 15) {
//                    // Capture photo and store it in the folder
//                    Mat frame = new Mat();
//                    camera.read(frame);
//                    OpenCVUtils.saveImage(frame, uniqueFolderPath, "photo_" + photoCount + ".jpg");
//                    photoCount++;
//                    captureTime = Math.max(0, captureTime - 1);
//                    timeLabel.setText("Wait for " + captureTime + " seconds");
//                    counterLabel.setText(photoCount + " photos have been clicked");
//                } else {
//                    ((Timer) e.getSource()).stop(); // Stop capture after 15 photos
//                }
//            }
//        });
//        captureTimer.start();
//    }
//
//    private void saveData() {
//        String name = nameField.getText();
//        String phone = phoneField.getText();
//        String userId = userIdField.getText();
//
//        if (name.isEmpty() || phone.isEmpty() || userId.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "All fields are required");
//            return;
//        }
//
//        // Save data to database and set dataSaved flag to true
//        DatabaseUtils.saveUserData(name, phone, userId);
//        dataSaved = true;  // Mark that data has been saved successfully
//
//        JOptionPane.showMessageDialog(this, "Data saved successfully!");
//    }
//
//    private void backAction() {
//        deleteFolderIfNecessary();
//        dispose(); // Close the current frame
//    }
//
//    private void deleteFolderIfNecessary() {
//        if (!dataSaved && uniqueFolderPath != null) {
//            deleteFolder(new File(uniqueFolderPath));
//        }
//    }
//
//    private void deleteFolder(File folder) {
//        if (folder.isDirectory()) {
//            for (File file : folder.listFiles()) {
//                deleteFolder(file);
//            }
//        }
//        folder.delete();
//    }
//
//    public static void main(String[] args) {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        SwingUtilities.invokeLater(() -> new register().setVisible(true));
//    }
//}
//
//
//





//import org.opencv.core.*;
//import org.opencv.videoio.VideoCapture;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.sql.*;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import javax.imageio.ImageIO;
//import javax.swing.Timer;
//
//public class FaceDetectionApp extends JFrame {
//
//    private JLabel cameraPreviewLabel;
//    private JButton captureButton, saveButton, backButton;
//    private JTextField nameField, phoneField;
//    private int photoCount = 0;
//    private boolean capturing = false;
//    private String uniqueID;
//    private Timer captureTimer;
//    private VideoCapture camera;
//
//    public FaceDetectionApp() {
//        setTitle("Face Detection App");
//        setSize(800, 500);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(null);
//
//        // Live Camera Preview on Left
//        cameraPreviewLabel = new JLabel();
//        cameraPreviewLabel.setBounds(20, 20, 350, 300);
//        add(cameraPreviewLabel);
//
//        // Capture Button
//        captureButton = new JButton("Capture");
//        captureButton.setBounds(20, 330, 100, 30);
//        add(captureButton);
//
//        // User Details on Right
//        nameField = new JTextField();
//        phoneField = new JTextField();
//        nameField.setBounds(400, 50, 200, 30);
//        phoneField.setBounds(400, 100, 200, 30);
//        add(nameField);
//        add(phoneField);
//
//        saveButton = new JButton("Save");
//        saveButton.setBounds(400, 150, 100, 30);
//        add(saveButton);
//
//        backButton = new JButton("Back");
//        backButton.setBounds(400, 200, 100, 30);
//        add(backButton);
//
//        // Initialize camera
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        camera = new VideoCapture(0);
//        startCameraPreview();
//
//        // Button Actions
//        captureButton.addActionListener(e -> startCaptureSession());
//        saveButton.addActionListener(e -> saveUserData());
//        backButton.addActionListener(e -> backToPreviousPage());
//    }
//
//    private void startCameraPreview() {
//        new Timer(30, (ActionEvent e) -> {
//            if (camera.isOpened()) {
//                Mat frame = new Mat();
//                camera.read(frame);
//                ImageIcon icon = new ImageIcon(matToBufferedImage(frame));
//                cameraPreviewLabel.setIcon(icon);
//            }
//        }).start();
//    }
//
//    private BufferedImage matToBufferedImage(Mat matrix) {
//        // Convert Mat to BufferedImage for display
//        // ... code to convert Mat to BufferedImage
//    }
//
//    private void startCaptureSession() {
//        if (!capturing) {
//            capturing = true;
//            photoCount = 0;
//            uniqueID = generateUniqueID();
//            new File("images/" + uniqueID).mkdirs();
//
//            captureTimer = new Timer(1000, (ActionEvent e) -> {
//                if (photoCount < 15) {
//                    captureImage();
//                    photoCount++;
//                } else {
//                    captureTimer.stop();
//                    capturing = false;
//                }
//            });
//            captureTimer.start();
//        }
//    }
//
//    private void captureImage() {
//        Mat frame = new Mat();
//        if (camera.read(frame)) {
//            String filename = "images/" + uniqueID + "/image_" + photoCount + ".jpg";
//            Imgcodecs.imwrite(filename, frame);
//        }
//    }
//
//    private void saveUserData() {
//        // Save to SQL database
//        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "user", "password")) {
//            String query = "INSERT INTO people (name, phone, unique_id) VALUES (?, ?, ?)";
//            try (PreparedStatement stmt = conn.prepareStatement(query)) {
//                stmt.setString(1, nameField.getText());
//                stmt.setString(2, phoneField.getText());
//                stmt.setString(3, uniqueID);
//                stmt.executeUpdate();
//                runCriticalFunction();
//                backToPreviousPage();
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    private String generateUniqueID() {
//        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//    }
//
//    private void runCriticalFunction() {
//        // Run sub-functions 5.1 and 5.2 here
//    }
//
//    private void backToPreviousPage() {
//        // Handle back button action
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new FaceDetectionApp().setVisible(true));
//    }
//}




import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

public class register extends JFrame {

    private JLabel cameraPreviewLabel, countdownLabel, statusLabel;
    private JButton captureButton, saveButton, backButton;
    private JTextField nameField, phoneField;
    private int photoCount = 0;
    private boolean capturing = false;
    private String uniqueID;
    private Timer captureTimer;
    private VideoCapture camera;

    public register() {
        setTitle("Face Registration App");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);  // No layout manager

        // Initialize OpenCV
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Live Camera Preview on Left
        cameraPreviewLabel = new JLabel();
        cameraPreviewLabel.setBounds(20, 20, 350, 300); // Position and size of camera preview
        add(cameraPreviewLabel);

        // Capture Button
        captureButton = new JButton("Capture");
        captureButton.setBounds(20, 330, 100, 30);
        add(captureButton);

        // Countdown and Status Labels
        countdownLabel = new JLabel("");
        countdownLabel.setBounds(150, 330, 200, 30);
        add(countdownLabel);

        statusLabel = new JLabel("");
        statusLabel.setBounds(150, 370, 200, 30);
        add(statusLabel);

        // User Details on Right
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(400, 50, 100, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(500, 50, 200, 30);
        add(nameField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(400, 100, 100, 30);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(500, 100, 200, 30);
        add(phoneField);

        saveButton = new JButton("Save");
        saveButton.setBounds(500, 150, 100, 30);
        add(saveButton);

        backButton = new JButton("Back");
        backButton.setBounds(500, 200, 100, 30);
        add(backButton);

        // Initialize Camera
        camera = new VideoCapture(0);
        startCameraPreview();

        // Button Actions
        captureButton.addActionListener(e -> startCaptureSession());
        saveButton.addActionListener(e -> saveUserData());
        backButton.addActionListener(e -> backToPreviousPage());

        // Handle frame closing
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//                runCriticalFunction();
                if (camera.isOpened()) {
                    camera.release();
                }
                System.exit(0);
            }
        });
    }

    private void startCameraPreview() {
        new Timer(30, (ActionEvent e) -> {
            if (camera.isOpened()) {
                Mat frame = new Mat();
                camera.read(frame);
                ImageIcon icon = new ImageIcon(matToBufferedImage(frame));
                cameraPreviewLabel.setIcon(icon);
            }
        }).start();
    }

    private BufferedImage matToBufferedImage(Mat mat) {
        // Convert Mat to BufferedImage
        int type = BufferedImage.TYPE_3BYTE_BGR;
        int bufferSize = mat.channels() * mat.cols() * mat.rows();
        byte[] buffer = new byte[bufferSize];
        mat.get(0, 0, buffer); // Get all pixels
        BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);
        return image;
    }

    private void startCaptureSession() {
        captureButton.setVisible(false);
        if (!capturing) {
            capturing = true;
            photoCount = 0;
            uniqueID = generateUniqueID();
            new File("images/" + uniqueID).mkdirs();

            captureTimer = new Timer(1000, (ActionEvent e) -> {
                if (photoCount < 15) {
                    countdownLabel.setText("Wait for " + (15 - photoCount) + " seconds");
                    captureImage();
                    photoCount++;
                    statusLabel.setText(photoCount + " photos have been clicked");
                } else {
                    captureTimer.stop();
                    capturing = false;
                    countdownLabel.setText("Capture Complete");
                }
            });
            captureTimer.start();
        }
    }

    private void captureImage() {
        Mat frame = new Mat();
        if (camera.read(frame)) {
            String filename = "images/" + uniqueID + "/image_" + photoCount + ".jpg";
            Imgcodecs.imwrite(filename, frame);
        }
    }

    private void saveUserData() {
        // Save to SQL database
        String name = nameField.getText();
        String phone = phoneField.getText();
         if ( uniqueID == null) {
            JOptionPane.showMessageDialog(null, "Capture images first.");
             return;
        } else if (capturing) {
             JOptionPane.showMessageDialog(null, "Capturing photos. Wait!");
             return;
        } else if (name.isEmpty() || phone.isEmpty()) {
             JOptionPane.showMessageDialog(null, "Please fill all fields.");
             return;
         }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/face_detection", "root", "root")) {
            String query = "INSERT INTO people (name, phone, uniqueId) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, nameField.getText());
                stmt.setString(2, phoneField.getText());
                stmt.setString(3, uniqueID);
                stmt.executeUpdate();
                stmt.close();
                conn.close();

                JOptionPane.showMessageDialog(null, "Data saved successfully.");
                runCriticalFunction();
                moveImageFolder(uniqueID);
                backToPreviousPage();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving data.");
        }
    }

    private String generateUniqueID() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    private void runCriticalFunction() {

            File sourcetrace = new File("images/" + uniqueID);
            File greyFolder = new File("greyed_data/" + uniqueID);
            greyFolder.mkdirs();

            for (File img : sourcetrace.listFiles()) {
                Mat matImage = Imgcodecs.imread(img.getPath());
                Imgproc.cvtColor(matImage, matImage, Imgproc.COLOR_BGR2GRAY);
                Imgcodecs.imwrite("greyed_data/" + uniqueID + "/" + img.getName(), matImage);
            }

//
    }


    public void moveImageFolder(String uniqueID) {

        File sourceFolder = new File("images/" + uniqueID);
        File targetFolder = new File("raw_image/" + uniqueID);
        targetFolder.mkdirs();
        File sourcereset = new File("images/" );

        try {
            // Move all files in the folder
            for (File file : sourceFolder.listFiles()) {
                Path sourcePath = file.toPath();
                Path targetPath = new File(targetFolder, file.getName()).toPath();
                Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            }

            // Delete the original folder after moving files
            sourceFolder.delete();
            System.out.println("Folder moved successfully to: " + targetFolder.getPath());



            // delete all other items
            if (sourcereset.isDirectory()) {
                File[] foldersreset = sourcereset.listFiles(File::isDirectory);

                if (foldersreset != null) {
                    for (File folderr : foldersreset) {
                        deleteFolder(folderr);
                        System.out.println("Garbage Folder: " + folderr.getName() + " deleted");
                    }
                } else {
                    System.out.println("No folders found.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while moving the folder.");
        }
    }

    private static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolder(file);
                } else {
                    file.delete();
                }
            }
        }
        folder.delete();
    }

    private void backToPreviousPage() {
        if (camera.isOpened()) {
            camera.release();
        }
        dispose();
        new MainPage().setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new register().setVisible(true));
    }
}
