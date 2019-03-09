import javax.swing.*;
import javax.swing.border.Border;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


class B3 extends JFrame implements ActionListener
{
	 private Timer timer;
	    private JLabel count;
	   static JLabel i;
	    private int[] time;
	    final int MIN = 0;
	    final int SEC = 1;
	    
	 static int X;
	 static int Y;

  JPopupMenu popupMenu;
  JTextField textField3;
  static String lblv2,lblv1;
  JFrame w = new JFrame("Tech Hunt");
  
  public B3()
  {
	  
	  w.setVisible(true);
	  w.setLocationRelativeTo( null );
	  w.setResizable(false);
	  ImageIcon icon=new ImageIcon("C:\\Users\\TAK\\workspace\\Tech Hunt\\src\\image\\th_logo_red_png_by_sanam5484-d6f3793 (1).png");
	  w.setIconImage(icon.getImage());


	  
	  JPanel p= (JPanel)w.getContentPane();
	  p.setBackground(Color.white);

	  Color c = new Color(156 , 0 , 0);  // Color Code
	  p.setBorder(BorderFactory.createLineBorder(c,3));
	  p.setLayout(new FlowLayout());



	  JButton Nxt = new JButton("Next");

	  Nxt.setBounds(290,380,150,40);
	  Nxt.setBackground(Color.WHITE);
	  Nxt.setForeground(Color.RED);
	  Nxt.setFont(new Font("Sans-Serif", Font.BOLD, 25));
	  Nxt.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	     w.setVisible(false);
	    		  timer.stop();
	    		  B4 b4 = new B4();
	    		   b4.getTimer();
	    		    String val3 = textField3.getText();
	    		    b4.getA3String(re1String(),re2String(),val3);
	    	     
	      }
	    });
	    
	  Border bored = BorderFactory.createLineBorder(Color.RED);
	  Nxt.setBorder(bored);


	      JButton home = new JButton("Home");
	      home.setBounds(490,380,150,40);
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

	      JLabel l=new JLabel(new ImageIcon("C:\\Users\\TAK\\workspace\\Tech Hunt\\src\\image\\B3.jpg"));
	      //To Add image to SplashScreen
	      l.setBounds(0, -1, 800, 460);
	      
	      w.add(l,BorderLayout.CENTER);
	      
	      textField3 = new JTextField();
	     
	      textField3.setBounds(250,300,420,40);
	      l.add(textField3);
          l.add(home);
	      l.add(Nxt); 
	      w.setBounds(270, 160, 840, 510);

	    
	      
	      l.add(addText());
    
	      
	
    createPopupMenu();
    textField3.addMouseListener(new MouseHandler(popupMenu));
    
    
  }
  
  
  public void getA2String(String stA2,String stA1)
  {
	  lblv2 = stA2;
	  lblv1 = stA1;
  }

  public String re2String()
  {
	  return lblv2;
  }
  public String re1String()
  {
	  return lblv1;
  }

  public void createPopupMenu()
  {
    JMenuItem copy = new javax.swing.JMenuItem("copy");
    JMenuItem paste = new javax.swing.JMenuItem("paste");
    JMenuItem selectAll = new javax.swing.JMenuItem("select all");

    popupMenu = new JPopupMenu();
    popupMenu.add( copy );
    popupMenu.add( paste );
    popupMenu.add( selectAll );

    copy.addActionListener(this);
    paste.addActionListener(this);
    selectAll.addActionListener(this);
  }


  public void actionPerformed(java.awt.event.ActionEvent e)
  {
    String cmd = e.getActionCommand();

    if (cmd.equals("copy"))
    {
      textField3.copy();
    }
    else if (cmd.equals("paste"))
    {
      textField3.paste();
    }
    else if (cmd.equals("select all"))
    {
      textField3.selectAll();
    }
  }
  
  
  
  

  

class MouseHandler extends MouseAdapter
{
  private JPopupMenu popupMenu;

  public MouseHandler(javax.swing.JPopupMenu popup)
  {
    this.popupMenu = popup;
  }

  public void mousePressed(MouseEvent e)
  {
    if (e.isPopupTrigger())
      popupMenu.show(e.getComponent(), e.getX(), e.getY());
  }
            
  public void mouseReleased(MouseEvent e )
  {
    if (e.isPopupTrigger())
      popupMenu.show(e.getComponent(), e.getX(), e.getY());
  }
            
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
            
           B4 b4 = new B4();
 		   b4.getTimer();
 		    String val3 = textField3.getText();
 		    b4.getA3String(re1String(),re2String(),val3);
 		    
 		    
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
	  B3 b3 = new B3();
	  b3.startCountdown("00:60");
	  
}

public void getTimer()
{
	 this.startCountdown("00:60");
}
}



