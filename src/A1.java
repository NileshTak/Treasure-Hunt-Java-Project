import java.awt.BorderLayout;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import javax.swing.border.Border;

public class A1 extends JFrame
{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	    private JLabel count;
	  
	    private int[] time;
	    final int MIN = 0;
	    final int SEC = 1;
	 static int X;
	 static int Y;
 
	   
	 JTextField textField1;
  JFrame w = new JFrame("Tech Hunt");

  
  
  public A1() {
w.setVisible(true);
w.setLocationRelativeTo( null );
ImageIcon icon=new ImageIcon("C:\\Users\\TAK\\workspace\\Tech Hunt\\src\\image\\th_logo_red_png_by_sanam5484-d6f3793 (1).png");
w.setIconImage(icon.getImage());
w.setResizable(false);

JPanel p= (JPanel)w.getContentPane();
p.setBackground(Color.white);

Color c = new Color(156 , 0 , 0);  // Color Code
p.setBorder(BorderFactory.createLineBorder(c,3));
p.setLayout(new FlowLayout());


JLabel l1=new JLabel(new ImageIcon("C:\\Users\\TAK\\workspace\\Tech Hunt\\src\\image\\1471945771_1141.gif"));
	//To Add image to SplashScreen	
	l1.setBounds(-280, -300, -1000, -800);


JLabel warn = new JLabel("**Enter Answer Below!!");
warn.setBounds(560, 250, 230, 10);
warn.setForeground(Color.red);

JLabel ans = new JLabel("Ans : ");
ans.setBounds(450, 200, 200, 70);
ans.setForeground(Color.BLACK);
Font f3=new Font("Colonna MT",Font.BOLD,40);
ans.setFont(f3);

	 textField1 = new JTextField();
	 textField1.setBounds(520,270,230,30);






JButton Home = new JButton("HOME");
Home.setBounds(530,380,150,40);
Home.setBackground(Color.WHITE);
Home.setForeground(Color.RED);
Home.setFont(new Font("Sans-Serif", Font.BOLD, 25));

Border bored1 = BorderFactory.createLineBorder(Color.RED);
Home.setBorder(bored1);
Home.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
	  w.setVisible(false);
	   Home h = new Home();
	    h.setVisible(true);
	  
	  
	 
  
  }
});

JButton Next = new JButton("Next");
Next.setBounds(530,320,150,40);
Next.setBackground(Color.WHITE);
Next.setForeground(Color.RED);
Next.setFont(new Font("Sans-Serif", Font.BOLD, 25));
Next.setBorder(bored1);
Next.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
	  
	 
	  w.setVisible(false);
	  timer.stop();
	  A2 a2 = new A2();
	   a2.getTimer();
	   String val1 = textField1.getText();
		 
	   a2.getA1String(val1);

	
	   
	   

  
  }
});
JLabel l=new JLabel(new ImageIcon("C:\\Users\\TAK\\workspace\\Tech Hunt\\src\\image\\A1.jpg"));
//To Add image to SplashScreen
l.setBounds(0, -5, 800, 460);
w.add(l,BorderLayout.CENTER);

l.add(addText());
w.setBounds(270, 160, 840, 510);
l.add(warn);
l.add(l1);
l.add(ans);
l.add(textField1);
l.add(Home);
l.add(Next);







  
 
  }	  
  
  public JPanel addText(){
      count = new JLabel();
     
      count.setFont(new Font("Arial Black", Font.BOLD, 50));
      count.setHorizontalAlignment(SwingConstants.CENTER);
      count.setBackground(Color.RED);
     
      JPanel panel = new JPanel(new FlowLayout());
      panel.add(count);
      panel.setBounds(340,0,170,80);
      panel.setBackground(Color.WHITE);
      w.add(panel);     
      return panel;
  }

  public void displayTime(int min, int sec){
      String minute = String.format("%02d",min);
      String second = (String.format("%02d",sec));
      count.setText(minute + ":" + second);
  }

  public void startCountdown(String time){
      this.time = convertTimeToInt(time.split(":"));
      count.setText(time);
      timer = new Timer(1000,new TimerListener());
      timer.setRepeats(true);
      timer.start();

  }
  public int[] convertTimeToInt(String[] time){
      int[] converted = new int[time.length];
      for(int i = 0; i<time.length; i++){
          converted[i] = Integer.valueOf(time[i]);
      }
      return converted;
  }

  private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
          if(time[MIN] == 0 && (time[SEC] == 1 || time[SEC] == 0)){
              count.setText("");
              w.setVisible(false);
              timer.stop();

              
              A2 a2 = new A2();
       	      a2.getTimer();
       	   
       	   String val1 = textField1.getText();
       		
       	   a2.getA1String(val1);
          }else if(time[SEC] > 0){
              time[SEC] -= 1;
              displayTime(time[MIN], time[SEC]);
          }else if(time[SEC] == 0){
              time[SEC] = 59;
              time[MIN] -= 1;
              displayTime(time[MIN], time[SEC]);
          }

          count.setForeground(time[MIN] == 0 && time[SEC] >= 6 ? Color.BLACK : Color.RED);
      }
  }


public static void main(String[] args) {
	 A1 a = new A1();
	
     a.startCountdown("00:15");
   
  }

 public void getTimer()
 {
	 startCountdown("00:15");
 }

}

