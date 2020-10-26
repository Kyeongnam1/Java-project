package t_project1;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CitybusList extends JPanel {
	String bus[] = {"5000B", "5001-1", "5003B", "13"};    
	public CitybusList(){
		this.setBackground(SystemColor.inactiveCaption);
        JLabel label2 = new JLabel("시내버스");
        JList scrollList = new JList(bus); 
        scrollList.setBackground(SystemColor.menu);
        JButton view = new JButton("정보보기");
        scrollList.setFont(new Font("함초롬돋움", Font.PLAIN, 18));
        view.setBackground(SystemColor.menu);
        view.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
        label2.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
        add(label2);
        add(new JScrollPane(scrollList));
        add(view);
        
        
        scrollList.setPreferredSize(new Dimension(500,300));
        label2.setPreferredSize(new Dimension(100,100));
        view.setPreferredSize(new Dimension(150,100));
        
      
        label2.setVisible(true);
        scrollList.setVisible(true);
        
        view.addActionListener(new ActionListener () {
	    	public void actionPerformed(ActionEvent e) {
	    		if (scrollList.getSelectedValue()== "13") {
	    			new b_13();
	    		}
	    		
	    		if (scrollList.getSelectedValue()== "5001-1") {
	    			new b_5001_1();
	    		}
	    		
	    		if (scrollList.getSelectedValue()== "5003B") {
	    			new b_5003B();
	    		}
	    		
	    		if (scrollList.getSelectedValue()== "5000B") {
	    			new b_5000B();
	    		}
	    	}
	    });
     }
}