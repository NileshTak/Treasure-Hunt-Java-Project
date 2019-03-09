import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.*;

import javax.swing.border.Border;

public class ABCD{

	 static int X;
	 static int Y;

	 A1 a;
  JFrame w = new JFrame("Tech Hunt");

  
  
  public ABCD() {
w.setVisible(true);
w.setResizable(false);
w.setLocationRelativeTo( null );
ImageIcon icon=new ImageIcon("C:\\Users\\TAK\\workspace\\Tech Hunt\\src\\image\\th_logo_red_png_by_sanam5484-d6f3793 (1).png");
w.setIconImage(icon.getImage());

JPanel p= (JPanel)w.getContentPane();
p.setBackground(Color.white);

Color c = new Color(156 , 0 , 0);  // Color Code
p.setBorder(BorderFactory.createLineBorder(c,3));
p.setLayout(new FlowLayout());



ImageIcon iconAbt=new ImageIcon("C:\\Users\\TAK\\workspace\\Tech Hunt\\src\\image\\Abt.jpg");
ImageIcon iconBbt=new ImageIcon("C:\\Users\\TAK\\workspace\\Tech Hunt\\src\\image\\Bbt.jpg");
ImageIcon iconCbt=new ImageIcon("C:\\Users\\TAK\\workspace\\Tech Hunt\\src\\image\\Cbt.jpg");
ImageIcon Hom=new ImageIcon("C:\\Users\\TAK\\workspace\\Tech Hunt\\src\\image\\Home.png");



JButton H = new JButton(Hom);

H.setBounds(600,300,120,120);
H.setBackground(Color.WHITE);
H.setForeground(Color.RED);
H.setFont(new Font("Sans-Serif", Font.BOLD, 25));
Border bored1 = BorderFactory.createLineBorder(Color.RED);
H.setBorder(bored1);
H.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
	   w.setVisible(false);
	Home h = new Home();
	h.setVisible(true);
	 
  
  }
});

JButton A = new JButton(iconAbt);
A.setBounds(300,150,120,120);
A.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
		  w.setVisible(false);
		  Rules r= new Rules();
		  
		   
	     
	  }
	});

JButton B = new JButton(iconBbt);
B.setBounds(600,150,120,120);
B.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
		  w.setVisible(false);
		  RulesB r= new RulesB();
		  r.setVisible(true);
		   
	     
	  }
	});

JButton C = new JButton(iconCbt);
C.setBounds(300,300,120,120);
C.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
		  w.setVisible(false);
		  RulesC r= new RulesC();
		  r.setVisible(true);
		   
	     
	  }
	});




JLabel l=new JLabel(new ImageIcon("C:\\Users\\TAK\\Desktop\\Tech Hunt Images\\ABCD.jpg"));
//To Add image to SplashScreen
l.setBounds(0, -1, 800, 460);
w.add(l,BorderLayout.CENTER);

l.add(H);
l.add(A);
l.add(B);
l.add(C);

  w.setBounds(270, 160, 840, 510);


 
}
  public void setVisible(boolean b)
  {
	   this.setVisible(true);
  }



public static void main(String[] args) {
  new ABCD();
}
}
