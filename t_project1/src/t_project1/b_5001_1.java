package t_project1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;



public class b_5001_1 extends JFrame implements Runnable {
	private Thread thread;
	JLabel clock = new JLabel();
	JLabel Infor = new JLabel();
	
	JButton restTime = new JButton("�����ð� ����");
	JLabel b_5001_1 = new JLabel("5001-1");
	
	public b_5001_1(){			
		MyPanel panel = new MyPanel();
	
		
		panel.setLayout(null);
		this.add(panel);
		this.setTitle("5001-1�� ����");
		this.setSize(1000,800);
		this.setVisible(true);
		
		panel.setBackground(SystemColor.inactiveCaption);
		
		clock.setFont(new Font("���ʷҵ���", Font.PLAIN, 30));
		clock.setForeground(new Color(70,70,70));
		clock.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		panel.add(clock);
		clock.setBounds(0,0,600,100);
		
		Infor.setFont(new Font("���ʷҵ���", Font.PLAIN, 30));
		Infor.setForeground(new Color(70,70,70));
		Infor.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		panel.add(Infor);
		Infor.setText("<html>---------------------------------------------------------------------<br>"
				+ "����ð� - ���� 05:30~23:00, �ָ� 05:30~23:00<br>"
				+"�������� - ���� 30��<br>"
				+"�ֿ������ - �ż�����Ʈ.�����������, ���ȸ�Ǽ�<br>"
				+"---------------------------------------------------------------------</html>");
		Infor.setBounds(0,0,800,400);
		
		panel.add(restTime);
		restTime.setBounds(600,400,400,100);
		restTime.setFont(new Font("���ʷҵ���", Font.BOLD, 30));
		restTime.setForeground(Color.black);
		restTime.setBorderPainted(false);
		restTime.setBackground(SystemColor.menu);  // �޹�� �ٲٱ�
		restTime.setOpaque(true);
		
		panel.add(b_5001_1);
		b_5001_1.setBounds(0,400,600,100);
		b_5001_1.setFont(new Font("���ʷҵ���", Font.BOLD, 30));
		b_5001_1.setBackground(new Color(230,227,227));  // �޹�� �ٲٱ�
		b_5001_1.setOpaque(true);
		b_5001_1.setForeground(new Color(219,4,4)); 
		b_5001_1.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		
		restTime.addActionListener(new ActionListener () {
	    	public void actionPerformed(ActionEvent e) {
	    		new Map(); 
	    		JOptionPane.showMessageDialog(null, "Ż ���� �����ϼ���!" );
	    	}
	    });
		
		if(thread == null){
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public void run(){
		while(true){
			Calendar cal = Calendar.getInstance();
			
			String now = "����ð�: " + cal.get(Calendar.YEAR)+"��"+
					(cal.get(Calendar.MONTH)+1)+"��"+
					cal.get(Calendar.DATE)+"��"+
					cal.get(Calendar.HOUR)+"��"+
					cal.get(Calendar.MINUTE)+"��"+
					cal.get(Calendar.SECOND)+"��";
		
			clock.setText(now);
		
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	class MyPanel extends JPanel{
		public MyPanel(){			
		}
	}

	
}