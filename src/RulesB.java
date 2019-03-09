import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.Border;



public class RulesB {

	 static int X;
	 static int Y;
	 
  JFrame w = new JFrame("Tech Hunt");

  
  
  public RulesB() {
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



JButton Nxt = new JButton("Let's Play");

Nxt.setBounds(330,380,150,40);
Nxt.setBackground(Color.WHITE);
Nxt.setForeground(Color.RED);
Nxt.setFont(new Font("Sans-Serif", Font.BOLD, 25));
Nxt.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    	 w.setVisible(false);
  	  B1 a = new B1();
	    a.getTimer();
		   
		  
	
		    
		    
    }
  });
  
Border bored = BorderFactory.createLineBorder(Color.RED);
Nxt.setBorder(bored);


    JButton close = new JButton("Home");
      close.setBounds(530,380,150,40);
    close.setBackground(Color.WHITE);
    close.setForeground(Color.RED);
    close.setFont(new Font("Sans-Serif", Font.BOLD, 25));
    Border bored1 = BorderFactory.createLineBorder(Color.RED);
    close.setBorder(bored1);
    close.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
    	  w.setVisible(false);
    	  Home h = new Home();
    	  
		    h.setVisible(true);
		   
       
      }
    });
    
    JLabel l=new JLabel(new ImageIcon("C:\\Users\\TAK\\Desktop\\Tech Hunt Images\\RulesA.jpg"));
  //To Add image to SplashScreen
  l.setBounds(0, -1, 800, 460);
  w.add(l,BorderLayout.CENTER);

  l.add(close);

l.add(Nxt); 
    w.setBounds(270, 160, 840, 510);

  
   
  }

  public void setVisible(boolean b)
  {
	   this.setVisible(true);
  } 

public static void main(String[] args) {
    new RulesB();
  }
}
