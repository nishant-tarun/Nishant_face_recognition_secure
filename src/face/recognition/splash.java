package face.recognition;

import javax.swing.*;
import java.awt.*;

public class splash extends JFrame {

    splash(){
        JLabel heading1 = new JLabel("FaceTrace");
        heading1.setBounds(255,10,190,50);
        heading1.setFont(new Font("serif", Font.BOLD,40));
        heading1.setForeground(Color.WHITE);
        add(heading1);

        JLabel author = new JLabel("Nishant.tarun");
        author.setBounds(20,305,150,30);
        author.setFont(new Font("SAN_SERIF", Font.BOLD,15));
        author.setForeground(Color.WHITE);
        add(author);

        JLabel version = new JLabel("version: 1.0.0");
        version.setBounds(20,325,150,30);
        version.setFont(new Font("SAN_SERIF", Font.BOLD,15));
        version.setForeground(Color.WHITE);
        add(version);

        ImageIcon i1y = new ImageIcon(ClassLoader.getSystemResource("icons/pop2.gif"));
        Image i2y= i1y.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3y=new ImageIcon(i2y);
        JLabel imgy=new JLabel(i3y);
        imgy.setBounds(295,280,100,100);
        add(imgy);


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/splash.png"));
        Image i2 = i1.getImage().getScaledInstance(690,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,690,400);
        add(image);

        setSize(690,400);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        try{
            Thread.sleep(4000);
            setVisible(false );
            new LoginPage();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new splash();
    }

}
