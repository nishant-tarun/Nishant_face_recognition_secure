package face.recognition;

import javax.swing.*;
import java.awt.*;

public class flash extends JFrame {

    flash(){

//        JLabel heading1 = new JLabel("hi");
//        heading1.setBounds(320,30,500,50);
//        heading1.setFont(new Font("serif", Font.BOLD,50));
//        add(heading1);

        ImageIcon i1x = new ImageIcon(ClassLoader.getSystemResource("icons/loading.gif"));
        Image i2x= i1x.getImage().getScaledInstance(384,216, Image.SCALE_DEFAULT);
        ImageIcon i3x=new ImageIcon(i2x);
        JLabel imgx=new JLabel(i3x);
        imgx.setBounds(170,450,384,216);
        add(imgx);


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/flash.png"));
        Image i2 = i1.getImage(); //.getScaledInstance(550,550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(-14,0,700,700);
        add(image);

        setSize(700,700);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        try{
            Thread.sleep(6000);
            setVisible(false );
            new splash();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new flash();

    }

}
