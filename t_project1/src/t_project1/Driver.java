package t_project1;
import java.awt.*;
import javax.swing.*;


public class Driver extends JFrame {
    public static void main(String[] args) {
        mainDisplay m = new mainDisplay();
        m.setLayout(null);
        
        JFrame frame = new JFrame("BUS TO MYONGJI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);
        frame.getContentPane().add(m);
        frame.getContentPane().setBackground(SystemColor.inactiveCaption);
       
    }
}