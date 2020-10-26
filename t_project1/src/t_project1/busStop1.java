package t_project1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;

public class busStop1 extends JFrame implements Runnable {
   private Thread thread;
   JLabel clock = new JLabel();
   
   JLabel restTime_SB = new JLabel();
   JLabel Schoolbus = new JLabel("�������");
   
   static int curtime;   
   static int T_Schoolbus[] = {490, 500, 510, 525, 545, 550, 565, 585, 590, 605, 630, 640, 655, 685, 695, 715, 725, 735, 775, 815, 830, 860, 875, 880, 890, 920, 935, 950, 980, 995, 1005, 1030, 1040, 1050, 1075, 1090, 1150, 1180, 1210}; // 8�ùݺ��� �ѽð������� �д����� ����
   static int busTime_SB,TimeRemaining_SB;
         
   
   public busStop1(){         
      MyPanel panel = new MyPanel();
   
      panel.setLayout(null);
      this.add(panel);
      this.setTitle("�����뿪��Ÿ�");
      this.setSize(1000,800);
      this.setVisible(true);
      
      panel.setBackground(SystemColor.inactiveCaption);
      
      clock.setFont(new Font("���ʷҵ���",Font.BOLD,30));
      clock.setForeground(new Color(70,70,70));
      clock.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
      panel.add(clock);
      clock.setBounds(0,0,600,100);
      
      panel.add(restTime_SB);
      restTime_SB.setBounds(600,100,400,100);
      restTime_SB.setFont(new Font("���ʷҵ���",Font.BOLD,30));
      restTime_SB.setForeground(Color.black);
      restTime_SB.setBackground(new Color(230,227,227));  // �޹�� �ٲٱ�
      restTime_SB.setOpaque(true);
      
   
      
      //���� ����
      panel.add(Schoolbus);
      Schoolbus.setBounds(0,100,600,100);
      Schoolbus.setFont(new Font("���ʷҵ���",Font.BOLD,30));
      Schoolbus.setBackground(new Color(230,227,227));  // �޹�� �ٲٱ�
      Schoolbus.setOpaque(true);
      Schoolbus.setForeground(new Color(31, 74, 155)); 
      Schoolbus.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 0));
   


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
         curtime = cal.get(Calendar.HOUR_OF_DAY)*60 +cal.get(Calendar.MINUTE);
         
         Queue q=new Queue(10); //ť ��ü ����
         
         //������� �ð�
         if(curtime<=T_Schoolbus[0]) {
            busTime_SB = T_Schoolbus[0];
            q.enQueue(T_Schoolbus[0]);
            q.deQueue();
         }
         for(int i=1;i<=37;i++) {
            if(T_Schoolbus[i]<curtime&&curtime<=T_Schoolbus[i+1]) {
               busTime_SB=T_Schoolbus[i+1];
               q.enQueue(T_Schoolbus[i+1]);
               q.deQueue();
               break;
            }
         }
         TimeRemaining_SB = busTime_SB -curtime;

         String T_SB = "�����ð�: "+ TimeRemaining_SB + "��";
      
         if(T_Schoolbus[38]<curtime&&curtime<1440) {
            T_SB = "���� ����";
         }   
         clock.setText(now);
         restTime_SB.setText(T_SB);   
         
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