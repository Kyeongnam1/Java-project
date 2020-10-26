package t_project1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;



public class b_School extends JFrame implements Runnable {
	private Thread thread;
	JLabel clock = new JLabel();
	JButton restTime = new JButton("�����ð� ����");
	JLabel b_School = new JLabel("���� ����");
	JButton timetable = new JButton("�ð�ǥ ����");
	public b_School(){			
		MyPanel panel = new MyPanel();
	
		
		panel.setLayout(null);
		this.add(panel);
		this.setTitle("�������");
		this.setSize(1000,500);
		this.setVisible(true);
		
		panel.setBackground(SystemColor.inactiveCaption);
		
		clock.setFont(new Font("���ʷҵ���", Font.PLAIN, 30));
		clock.setForeground(new Color(70,70,70));
		clock.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		panel.add(clock);
		clock.setBounds(0,0,600,100);
		
		
		panel.add(restTime);
		restTime.setBounds(800,100,200,100);
		restTime.setFont(new Font("���ʷҵ���", Font.PLAIN, 25));
		restTime.setBackground(SystemColor.menu);
		
		panel.add(timetable);
		timetable.setBounds(595,100,200,100);
		timetable.setFont(new Font("���ʷҵ���", Font.PLAIN, 25));
		timetable.setBackground(SystemColor.menu);
		panel.add(b_School);
		b_School.setBounds(0,100,800,100);
		b_School.setFont(new Font("���ʷҵ���", Font.PLAIN, 25));
		b_School.setBackground(new Color(230,227,227));  // �޹�� �ٲٱ�
		b_School.setOpaque(true);
		b_School.setForeground(new Color(31, 74, 155)); 
		b_School.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
		
		restTime.addActionListener(new ActionListener () {
	    	public void actionPerformed(ActionEvent e) {
	    		new Map(); 
	    		JOptionPane.showMessageDialog(null, "Ż ���� �����ϼ���!" );
	    	}
	    });
		
		timetable.addActionListener(new ActionListener () {
	    	public void actionPerformed(ActionEvent e) {
	    		new Schoolbus_timetable(); 
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
