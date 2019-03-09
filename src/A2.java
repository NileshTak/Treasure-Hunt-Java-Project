
import javax.swing.*;
import javax.swing.border.Border;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


class A2 extends JFrame implements ActionListener
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	    private JLabel count;
	   static JLabel i;
	    private int[] time;
	    final int MIN = 0;
	    final int SEC = 1;
	    
	 static int X;
	 static int Y;
static String lblv1;
  JPopupMenu popupMenu;
  JTextField textField2;
  JFrame w = new JFrame();
  
  public A2()
  {
	  
	  w.setVisible(true);
	  w.setResizable(false);
	  w.setLocationRelativeTo( null );
	  w.setTitle("Tech Hunt");
	  ImageIcon icon=new ImageIcon("C:\\Users\\TAK\\workspace\\Tech Hunt\\src\\image\\th_logo_red_png_by_sanam5484-d6f3793 (1).png");
	  w.setIconImage(icon.getImage());
	  
	  w.addMouseListener(new MouseAdapter()
	  {
	  public void mousePressed(MouseEvent me)
	  {
	  	X=me.getX();       //get X Attribute Dimension
	  	Y=me.getY();         //get Y Attribute Dimension
	  	
	  }
	  });

	  w.addMouseMotionListener(new MouseMotionAdapter()
	  {
	  public void mouseDragged(MouseEvent me)
	  {
	  	Point p = w.getLocation();
	  	w.setLocation(p.x + (me.getX()-X), p.y + (me.getY()-Y));
	  	
	  }
	  });

	  
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
	    		  A3 a3 = new A3();
	    		   a3.getTimer();
	    		   String val2 = textField2.getText();
		    		 
	    		   a3.getA2String(re1String(),val2);
    	    
	    		   
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

	      JLabel l=new JLabel(new ImageIcon("C:\\Users\\TAK\\Desktop\\Tech Hunt Images\\A2.jpg"));
	      //To Add image to SplashScreen
	      l.setBounds(0, -1, 800, 460);
	      
	      w.add(l,BorderLayout.CENTER);
	      
	      textField2 = new JTextField();
	     
	      textField2.setBounds(250,320,420,40);
	      l.add(textField2);
          l.add(home);
	      l.add(Nxt); 
	      w.setBounds(270, 160, 840, 510);

	    
	      
	      l.add(addText());
    
	      
	
    createPopupMenu();
    textField2.addMouseListener(new MouseHandler(popupMenu));
    
    
  }
  
  
  public void getA1String(String stA1)
  {
	  lblv1 = stA1;
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
      textField2.copy();
    }
    else if (cmd.equals("paste"))
    {
      textField2.paste();
    }
    else if (cmd.equals("select all"))
    {
      textField2.selectAll();
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
            
           A3 a3 = new A3();
 		   a3.getTimer();
 		   String val2 = textField2.getText();
	    		 
 		   a3.getA2String(re1String(),val2);
	    
 		   
 		   
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
	  A2 a2 = new A2();
	  a2.startCountdown("00:60");
	  
}

public void getTimer()
{
	 this.startCountdown("00:60");
}
}



