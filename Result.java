package quizgame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class Result implements ActionListener {

	JFrame f=new JFrame("QUIZ GAME");
	JLabel label=new JLabel();
	JLabel label1=new JLabel();
	JButton quit=new JButton("FINISH");
	JButton again=new JButton("BACK");
	Container c=f.getContentPane();
	
	Result(Game  game){
	c.setLayout(null);
	f.setSize(1500, 1500);
	Color lightpink=new Color(255,192,203);
    c.setBackground(lightpink);
    
    Font customFont0 = new Font("Serif", Font.BOLD, 30); 

     label.setBounds(370,130,600,150);
	 label.setFont(customFont0); 
	 label.setOpaque(true);
     label.setForeground(new Color(255, 105, 180));
     label.setHorizontalAlignment(JTextField.CENTER);
     label.setBackground(new Color(255,204,229));
     label.setBorder(new LineBorder(new Color(255,105,180), 5)); 	
     label.setText("CORRECT ANSWERS :  "+game.correct+"/"+game.total_q);
     c.add(label);
     
     label1.setBounds(370,300,600,150);
   	 label1.setFont(customFont0); 
   	 label1.setOpaque(true);
     label1.setForeground(new Color(255, 105, 180));
     label1.setHorizontalAlignment(JTextField.CENTER);
     label1.setBackground(new Color(255,204,229));
     label1.setBorder(new LineBorder(new Color(255,105,180), 5)); 	
     label1.setText("Score: " + ((game.correct * 100) / game.total_q) + "%");
     c.add(label1);
        
     quit.setBounds(370,470,290,50);
     quit.setFont(customFont0);
     quit.setBackground(new Color(255, 204, 229)); 
     quit.setForeground(new Color(255, 105, 180));
     quit.setBorder(new LineBorder(new Color(255,105,180), 2)); 
     quit.addActionListener(this);
	 c.add(quit);
	 
     again.setBounds(670,470,290,50);
     again.setFont(customFont0);
     again.setBackground(new Color(255, 204, 229)); 
     again.setForeground(new Color(255, 105, 180));
     again.setBorder(new LineBorder(new Color(255,105,180), 2)); 
     again.addActionListener(this);
	 c.add(again);

	 
     f.setVisible(true);
     f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
 
		if(e.getSource() == quit)
		f.dispose();
		
		if(e.getSource()== again) {
			new MainMenu();
		}
	}
}
