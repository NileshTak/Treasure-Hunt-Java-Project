import javax.swing.*;
import javax.swing.border.Border;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class B9
{
	 private Timer timer;
	    private JLabel count;
	   static JLabel i;
	    private int[] time;
	    final int MIN = 0;
	    final int SEC = 1;
	    
	 static int X;
	 static int Y;

	 static String lblv1,lblv2,lblv3,lblv4,lblv5,lblv6,lblv7,lblv8; 
	 
  JTextField textField9;
  JFrame w;
  
  public B9()
  {
	  w = new JFrame();
	  w.setVisible(true);
	  w.setLocationRelativeTo( null );
	  w.setTitle("Tech Hunt");
	  w.setResizable(false);
	  ImageIcon icon=new ImageIcon("C:\\Users\\TAK\\workspace\\Tech Hunt\\src\\image\\th_logo_red_png_by_sanam5484-d6f3793 (1).png");
	  w.setIconImage(icon.getImage());
	  
	  ImageIcon BtnClue=new ImageIcon("C:\\Users\\TAK\\workspace\\Tech Hunt\\src\\image\\Btncl.jpg");
	  

	  
	  JPanel p= (JPanel)w.getContentPane();
	  p.setBackground(Color.white);

	  Color c = new Color(156 , 0 , 0);  // Color Code
	  p.setBorder(BorderFactory.createLineBorder(c,3));
	  p.setLayout(new FlowLayout());



	  JButton Nxt = new JButton("Next");

	  Nxt.setBounds(290,390,150,40);
	  Nxt.setBackground(Color.WHITE);
	  Nxt.setForeground(Color.RED);
	  Nxt.setFont(new Font("Sans-Serif", Font.BOLD, 25));
	  Nxt.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	     w.setVisible(false);
	    	     timer.stop();
	    	     B10 b10 = new B10();
	    	     b10.setVisible(true);
	    	     b10.getTimer();
	    	     String val9 = textField9.getText();					
		    	 	b10.getlableString(re1String(), re2String(),re3String(),re4String(),re5String(),re6String(),re7String(),re8String(),val9);
		    		
	    	     
	    	  
	      }
	    });
	    
	  Border bored = BorderFactory.createLineBorder(Color.RED);
	  Nxt.setBorder(bored);


	      JButton home = new JButton("Home");
	        home.setBounds(490,390,150,40);
	      home.setBackground(Color.WHITE);
	      home.setForeground(Color.RED);
	      home.setFont(new Font("Sans-Serif", Font.BOLD, 25));
	      Border bored1 = BorderFactory.createLineBorder(Color.RED);
	      home.setBorder(bored1);
	      home.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	      	   w.setVisible(false);
	      	
	  	   Home h = new Home();
	  	    h.setVisible(true);
	         
	        }
	      });

	      JLabel l=new JLabel(new ImageIcon("C:\\Users\\TAK\\workspace\\Tech Hunt\\src\\image\\B9.jpg"));
	      //To Add image to SplashScreen
	      l.setBounds(0, -1, 800, 460);
	      
	      w.add(l,BorderLayout.CENTER);
	      
	      textField9 = new JTextField();
	     
	      textField9.setBounds(250,330,420,40);
	      l.add(textField9);
          l.add(home);
	      l.add(Nxt); 
	      w.setBounds(270, 160, 840, 510);

	    
	      JButton clue = new JButton(BtnClue);
	      clue.setBounds(0, 0, 230, 80);
	      clue.setBackground(Color.white);
	      Border bored2 = BorderFactory.createLineBorder(Color.white);
	      clue.setBorder(bored2);
	      clue.addActionListener(new ActionListener()
	     	{
	     			public void actionPerformed(ActionEvent e)
	     			{
	     				UIManager UI=new UIManager();
	     			 UI.put("OptionPane.background", Color.white);
	     			 UI.put("Panel.background", Color.white);
	     			ImageIcon icon = new ImageIcon("Btncl.jpg");
	     			JOptionPane.showMessageDialog(null, "Clue is B9JPG", "About", JOptionPane.INFORMATION_MESSAGE, icon);
	     			}
	     				});
	
	      
	      
	      
	      l.add(addText());
	      l.add(clue);
	      
	
  
    
  }
  
  public String re1String()
  {
	  return lblv1;
  }
  public String re2String()
  {
	  return lblv2;
  }
  public String re3String()
  {
	  return lblv3;
  }
  
  public String re4String()
  {
	  return lblv4;
  }
  
  public String re5String()
  {
	  return lblv5;
  }
  public String re6String()
  {
	  return lblv6;
  }
  public String re7String()
  {
	  return lblv7;
  }
  public String re8String()
  {
	  return lblv8;
  }
  public void getlableString(String stA8,String stA7,String stA6,String stA5,String stA4,String stA3,String stA2,String stA1)
  {
	  lblv8 = stA8;
	  lblv7 = stA7;
	  lblv6 = stA6;
	  lblv5 = stA5;
	  lblv4 = stA4;
	  lblv3 = stA3;
	  lblv1 = stA1;
	  lblv2 = stA2;
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

public void startCountdown(String time)
{   
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
            
            
            B10 b10 = new B10();
   	     b10.setVisible(true);
   	     b10.getTimer();
   	     String val9 = textField9.getText();					
	    	 	b10.getlableString(re1String(), re2String(),re3String(),re4String(),re5String(),re6String(),re7String(),re8String(),val9);
	    		
            
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


public static void main(String[] args) throws Exception
{
	  B9 b9 = new B9();
	  b9.startCountdown("00:60");
	  
}

public void getTimer()
{
	 this.startCountdown("00:60");
}
}


