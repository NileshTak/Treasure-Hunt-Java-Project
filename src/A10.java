
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;



class MyButton extends JButton {

	

	private static final long serialVersionUID = 1L;
	private boolean isLastButton;

    public MyButton() {

        super();

        initUI();
    }

    public MyButton(Image image) {

        super(new ImageIcon(image));

        initUI();
    }

    private void initUI() {

        isLastButton = false;
        BorderFactory.createLineBorder(Color.gray);

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.yellow));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.gray));
            }
        });
    }

    public void setLastButton() {
        
        isLastButton = true;
    }

    public boolean isLastButton() {

        return isLastButton;
    }
}

public class A10 extends JFrame  {

	JFrame f;
	private JPanel pic;
    private JPanel panel;
    private BufferedImage source;
    private ArrayList<MyButton> buttons;
    static String lblv1,lblv2,lblv3,lblv4,lblv5,lblv6,lblv7,lblv8,lblv9; 
	 

    ArrayList<Point> solution = new ArrayList();

    private Image image;
    private MyButton lastButton;
    private int width, height;
    private final int DESIRED_WIDTH = 300;
    private BufferedImage resized;
    
    private Timer timer;
    private JLabel count;
   static JLabel i;
    private int[] time;
    final int MIN = 0;
    final int SEC = 1;
    
 static int X;
 static int Y;


    public A10() {

        initUI();
    }

    private void initUI() {

    	setBounds(270, 160, 840, 510);
  	  setLocationRelativeTo( null );
  	  setTitle("Tech Hunt");
  	setResizable(false);
  	ImageIcon icon=new ImageIcon("C:\\Users\\TAK\\workspace\\Tech Hunt\\src\\image\\th_logo_red_png_by_sanam5484-d6f3793 (1).png");
  	setIconImage(icon.getImage());
  	  
    
  	  JPanel p= (JPanel)getContentPane();
	  p.setBackground(Color.white);

	  Color c = new Color(156 , 0 , 0);  // Color Code
	  p.setBorder(BorderFactory.createLineBorder(c,3));
	  p.setLayout(new FlowLayout());

  	  
    	
        solution.add(new Point(0, 0));
        solution.add(new Point(0, 1));
        solution.add(new Point(0, 2));
        solution.add(new Point(1, 0));
        solution.add(new Point(1, 1));
        solution.add(new Point(1, 2));
        solution.add(new Point(2, 0));
        solution.add(new Point(2, 1));
        solution.add(new Point(2, 2));
        solution.add(new Point(3, 0));
        solution.add(new Point(3, 1));
        solution.add(new Point(3, 2));

        buttons = new ArrayList();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        panel.setLayout(new GridLayout(4, 3, 0, 0));

        try {
            source = loadImage();
            int h = getNewHeight(source.getWidth(), source.getHeight());
            resized = resizeImage(source, DESIRED_WIDTH, h,
                    BufferedImage.TYPE_INT_ARGB);

        } catch (IOException ex) {
            Logger.getLogger(A10.class.getName()).log(
                    Level.SEVERE, null, ex);
        }

        width = resized.getWidth(null);
        height = resized.getHeight(null);

        

    	
        
       


        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 3; j++) {

                image = createImage(new FilteredImageSource(resized.getSource(),
                        new CropImageFilter(j * width / 3, i * height / 4,
                                (width / 3), height / 4)));
                MyButton button = new MyButton(image);
                button.putClientProperty("position", new Point(i, j));

                if (i == 3 && j == 2) {
                    lastButton = new MyButton();
                    lastButton.setBorderPainted(false);
                    lastButton.setContentAreaFilled(false);
                    lastButton.setLastButton();
                    lastButton.putClientProperty("position", new Point(i, j));
                } else {
                    buttons.add(button);
                }
            }
        }

        Collections.shuffle(buttons);
        buttons.add(lastButton);

        for (int i = 0; i < 12; i++) {

            MyButton btn = buttons.get(i);
            panel.add(btn);
            btn.setBorder(BorderFactory.createLineBorder(Color.gray));
            btn.addActionListener(new ClickAction());
        }
    	pic = new JPanel();
    	  pic.setBounds(200, 200, 310, 245);
    	  pic.setBackground(Color.white);
    	  
     	 JLabel l=new JLabel(new ImageIcon("C:\\Users\\TAK\\Desktop\\Tech Hunt Images\\A10.jpg"));
        //To Add image to SplashScreen
        l.setBounds(0, -1, 800, 460);
     
        add(l,BorderLayout.CENTER);
       pic.add(panel, BorderLayout.CENTER);
       
        l.add(pic,BorderLayout.CENTER);
        
        l.add(addText());
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
    public String re9String()
    {
  	  return lblv9;
    }
    public void getlableString(String stA9,String stA8,String stA7,String stA6,String stA5,String stA4,String stA3,String stA2,String stA1)
    {
    	lblv9 = stA9;
  	  lblv8 = stA8;
  	  lblv7 = stA7;
  	  lblv6 = stA6;
  	  lblv5 = stA5;
  	  lblv4 = stA4;
  	  lblv3 = stA3;
  	  lblv1 = stA1;
  	  lblv2 = stA2;
    }  

    
    
    private int getNewHeight(int w, int h) {

        double ratio = DESIRED_WIDTH / (double) w;
        int newHeight = (int) (h * ratio);
        return newHeight;
    }

    private BufferedImage loadImage() throws IOException {

        BufferedImage bimg = ImageIO.read(new File("C:\\Users\\TAK\\Desktop\\Tech Hunt images\\s.png"));

        return bimg;
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int width,
            int height, int type) throws IOException {

        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();

        return resizedImage;
    }

    private class ClickAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {

            checkButton(e);
            checkSolution();
        }

        private void checkButton(ActionEvent e) {

            int lidx = 0;
            for (MyButton button : buttons) {
                if (button.isLastButton()) {
                    lidx = buttons.indexOf(button);
                }
            }

            JButton button = (JButton) e.getSource();
            int bidx = buttons.indexOf(button);

            if ((bidx - 1 == lidx) || (bidx + 1 == lidx)
                    || (bidx - 3 == lidx) || (bidx + 3 == lidx)) {
                Collections.swap(buttons, bidx, lidx);
                updateButtons();
            }
        }

        private void updateButtons() {

            panel.removeAll();

            for (JComponent btn : buttons) {

                panel.add(btn);
            }

            panel.validate();
        }
    }

    private void checkSolution() {

        ArrayList<Point> current = new ArrayList();

        for (JComponent btn : buttons) {
            current.add((Point) btn.getClientProperty("position"));
        }

        if (compareList(solution, current)) {
            JOptionPane.showMessageDialog(panel, "Finished",
                    "Congratulation", JOptionPane.INFORMATION_MESSAGE);
            
            ResultA r = new ResultA();
            String val10 = "1";					
    	 	r.setAnswers(re1String(), re2String(),re3String(),re4String(),re5String(),re6String(),re7String(),re8String(),re9String(),val10);
    		
            
        }
    }

    public static boolean compareList(List ls1, List ls2) {
        return ls1.toString().contentEquals(ls2.toString());
    }

    
    public void getTimer()
    {
    	 this.startCountdown("01:00");
    }
    
    
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            A10 puzzle = new A10();
            puzzle.setVisible(true);
            puzzle.startCountdown("01:00");
        });
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
        add(panel);     
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
                setVisible(false);
                timer.stop();
                
                ResultA r = new ResultA();
                String val10 = "0";					
        	 	r.setAnswers(re1String(), re2String(),re3String(),re4String(),re5String(),re6String(),re7String(),re8String(),re9String(),val10);
        		
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



   

    
}