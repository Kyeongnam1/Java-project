package t_project1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class mainDisplay extends JPanel{
	String sinaebus[] = {"13", "5001-1", "5003B", "5000B","�������"};
	public mainDisplay() {
		this.setBackground(SystemColor.inactiveCaption);
		JButton btn1 = new JButton("��������");
		JButton btn2 = new JButton("���ã��");
		JButton btn3 = new JButton("�ó�����");
		JButton btn4 = new JButton("�������");
		
		JButton btn = new JButton("�˻�");
		JTextField field = new JTextField();
		field.setBounds(300, 156, 317, 39);
		field.setColumns(10);
		
		add(field);
		field.setVisible(true);
		
		
		btn.setVisible(true);
		btn.setBackground(SystemColor.menu);
        btn.setFont(new Font("���ʷҵ���", Font.PLAIN, 15));
        btn.setForeground(Color.DARK_GRAY);
        btn.setBounds(645, 156, 65, 40);
		add(btn);
		
		
		
		btn1.setBounds(300,300,200,200);
		btn1.setForeground(Color.DARK_GRAY);
        btn1.setFont(new Font("���ʷҵ���", Font.PLAIN, 19));
        btn1.setBackground(SystemColor.menu);
		add(btn1);
		btn1.setVisible(true);
		
		btn2.setBounds(500,300,200,200);
		btn2.setForeground(Color.DARK_GRAY);
        btn2.setFont(new Font("���ʷҵ���", Font.PLAIN, 19));
        btn2.setBackground(SystemColor.menu);
		add(btn2);
		btn2.setVisible(true);
		
		btn3.setBounds(300,500,200,200);
		btn3.setForeground(Color.DARK_GRAY);
        btn3.setFont(new Font("���ʷҵ���", Font.PLAIN, 19));
        btn3.setBackground(SystemColor.menu);
		add(btn3);
		btn3.setVisible(true);
		
		btn4.setBounds(500,500,200,200);
		btn4.setForeground(Color.DARK_GRAY);
        btn4.setFont(new Font("���ʷҵ���", Font.PLAIN, 19));
        btn4.setBackground(SystemColor.menu);
		add(btn4);
		btn4.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("    B U S  T O  M Y O N G J I");
        lblNewLabel.setForeground(Color.GRAY);
        lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 51));
        lblNewLabel.setBounds(94, 12, 796, 126);
        add(lblNewLabel);
		
		 btn.addActionListener(new ActionListener () {
	            public void actionPerformed(ActionEvent e) {
	               
	                String bus=field.getText();
	                int num=-1;
	                int i=0;
	                 for(i=0;i<sinaebus.length;i++) {
	                      if(bus.equals(sinaebus[i])) {
	                         num=i;
	                         break;
	                      }
	                  }
	                 if(num==-1) {
	                	   JOptionPane.showMessageDialog(null, "���� �����Դϴ�!" );
	                   }
	                 else if(bus.equals(sinaebus[i])&&sinaebus[i]=="13") {
	                	 new b_13();
	                 }
	                 else if(bus.equals(sinaebus[i])&&sinaebus[i]=="5001-1") {
	                	 new b_5001_1();
	                 }
	                 else if(bus.equals(sinaebus[i])&&sinaebus[i]=="5003B") {
	                	 new b_5003B();
	                 }
	                 else if(bus.equals(sinaebus[i])&&sinaebus[i]=="5000B") {
	                	 new b_5000B();
	                 } 
	                 else if(bus.equals(sinaebus[i])&&sinaebus[i]=="�������") {
	                	 new b_School();
	                 } 
	                   
	            }
	         });
		 
	    btn1.addActionListener(new ActionListener () {
	    	public void actionPerformed(ActionEvent e) {
	    		new Map(); 
	    	}
	    });
	    
	    btn2.addActionListener(new ActionListener () {
	    	public void actionPerformed(ActionEvent e) {
	    		new Star();
	    	}
	    });
	    
	    btn3.addActionListener(new ActionListener () {
	    	public void actionPerformed(ActionEvent e) {
	    		new CitybusList_Frame(); 
	    	}
	    });
	    
	    btn4.addActionListener(new ActionListener () {
	    	public void actionPerformed(ActionEvent e) {
	    		new SchoolbusList_Frame(); 
	    	}
	    });

	}
}

