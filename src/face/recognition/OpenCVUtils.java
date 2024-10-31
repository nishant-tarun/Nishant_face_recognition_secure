package face.recognition;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import javax.swing.JOptionPane;

public class OpenCVUtils {

    // Convert Mat to BufferedImage for display in JLabel
    public static BufferedImage matToBufferedImage(Mat mat) {
        int type = mat.channels() == 1 ? BufferedImage.TYPE_BYTE_GRAY : BufferedImage.TYPE_3BYTE_BGR;
        BufferedImage image = new BufferedImage(mat.width(), mat.height(), type);
        DataBufferByte dataBuffer = (DataBufferByte) image.getRaster().getDataBuffer();
        mat.get(0, 0, dataBuffer.getData());
        return image;
    }

    // Save Mat as an image file
    public static void saveImage(Mat mat, String folderPath, String fileName) {
        try {
            File dir = new File(folderPath);
            if (!dir.exists()) dir.mkdirs(); // Create the folder if it doesn't exist
            String filePath = folderPath + File.separator + fileName;
            Imgcodecs.imwrite(filePath, mat); // Save image using OpenCV
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to save image: " + e.getMessage());
        }
    }
}
