package t_project1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Schoolbus_timetable extends JFrame {
	ImageIcon img = new ImageIcon("C:\\Users\\nam43\\eclipse-workspace\\t_project1\\src\\t_project1\\image\\schoolbus.jpg");	
	Image im = img.getImage();
	public Schoolbus_timetable(){
		timetable panel = new timetable();
		
		this.add(panel);
		this.setTitle("������� �ð�ǥ");
		this.setSize(700,700);
		this.setVisible(true);
	}
	
	class timetable extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(im,0,0,getWidth(),getHeight(),this);
        }
    }
	
}
