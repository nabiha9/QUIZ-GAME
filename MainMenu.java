package quizgame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainMenu implements ActionListener{
	JPanel panel=new JPanel();
	JFrame frame=new JFrame("QUIZ GAME");
	JLabel headlabel=new JLabel("MUSIC QUIZ");
	JButton startb=new JButton("START");
	JButton quitb=new JButton();
	 Container con=frame.getContentPane();
	 
	 MainMenu(){
		con.setLayout(null);
	    Color lightpink=new Color(255,192,203);
        con.setBackground(lightpink);
		frame.setSize(1500,1500);
		
		headlabel.setBounds(450,20,500,100);
        con.add(headlabel);
        Font customFont = new Font("Serif", Font.BOLD, 70); 
        headlabel.setFont(customFont);
        headlabel.setForeground(new Color(255, 105, 180));

		startb.setBounds(720, 500, 300,100 );
		con.add(startb);
		startb.setBackground(new Color(255, 204, 229));
        Font customFont2 = new Font("Serif", Font.BOLD, 50); 
        startb.setFont(customFont2);
        startb.setForeground(new Color(255, 153, 204));
        startb.setBorder(new LineBorder(new Color(255,105,180), 2)); 
		startb.addActionListener(this);
        quitb.setBounds(300, 500, 300,100 );
		con.add(quitb);
		quitb.setBackground(new Color(255, 204, 229)); 
		quitb.setText("QUIT");
        quitb.setFont(customFont2);
        quitb.setForeground(new Color(255, 153, 204));
        quitb.setBorder(new LineBorder(new Color(255,105,180), 2)); 
		quitb.addActionListener(this);

		frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		MainMenu obj=new MainMenu();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==startb)
		{
			new Game();
			frame.dispose();
		}
		
		if(e.getSource()==quitb) {
		    frame.dispose();
		}
		
	}

}
