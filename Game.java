package quizgame;
import java.net.URL;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Game implements ActionListener {
	String questions[]= {"Which artist released the song red?",
			"Complete the lyrics: And if I'm turning blue...",
			"Guess the song by listening to the audio.",
			"Guess the album by the cover." };
	String options[][]= {{"Billie Eilish","Taylor Swift","Sabrina Carpenter","Olivia Rodrigo"},
			{"please dont save me.","please dont leave me.","please dont hate me.",
		     "please be with me."},{"thats so true","vampire","espresso","man child"},
			{"1989","short n' sweet","Guts","lover"}};
	char answers[]= {'B','A','C','C'};
	public char guess;
	public char answer;
	public int index=0;
	public int correct=0;
	public int total_q=questions.length;
	public int result;
	public int seconds=10;
	JPanel panel=new JPanel();
	JFrame frame=new JFrame("QUIZ GAME");
	JTextField tf1=new JTextField();
	JTextField tf2=new JTextField();
	JButton b1=new JButton("A");
	JButton b2=new JButton("B");
	JButton b3=new JButton("C");
	JButton b4=new JButton("D");
	JLabel l1=new JLabel();
	JLabel l2=new JLabel();
	JLabel l3=new JLabel();
	JLabel l4=new JLabel();
	JLabel time=new JLabel();
	JLabel second=new JLabel();
    JButton playButton;
	Container con=frame.getContentPane();
	 Timer timer=new Timer(1000,new ActionListener(){
	    	
	    	public void actionPerformed(ActionEvent e) {
	    		 seconds--;
	    	     time.setText(String.valueOf(seconds));
                 if(seconds<=0)
                	 displayAnswer();
	    	}
	    });

	Game(){
		
		con.setLayout(null);
       Color lightpink=new Color(255,192,203);
       con.setBackground(lightpink);
		frame.setSize(1500,1500);
        Font customFont2 = new Font("Serif", Font.BOLD, 50); 
		tf1.setBounds(100,5,1150,70);
		tf1.setFont(customFont2);
        tf1.setForeground(new Color(255, 153, 204));
        tf1.setHorizontalAlignment(JTextField.CENTER);
        tf1.setEditable(false);
		con.add(tf1);
		
		tf2.setBounds(100,80,1150,150);
		tf2.setFont(customFont2);
        tf2.setForeground(new Color(255, 153, 204));
        tf2.setHorizontalAlignment(JTextField.CENTER);
        tf2.setEditable(false);
		con.add(tf2);

		b1.setBounds(100,240,200,80);
		b1.setFont(customFont2);
		b1.setBackground(new Color(255, 204, 229)); 
        b1.setForeground(new Color(255, 105, 180));
        b1.setBorder(new LineBorder(new Color(255,105,180), 2)); 
		con.add(b1);
		
		b2.setBounds(100,330,200,80);
		b2.setFont(customFont2);
		b2.setBackground(new Color(255, 204, 229)); 
        b2.setForeground(new Color(255, 105, 180));
        b2.setBorder(new LineBorder(new Color(255,105,180), 2)); 
		con.add(b2);
		
		b3.setBounds(100,420,200,80);
		b3.setFont(customFont2);
		b3.setBackground(new Color(255, 204, 229)); 
        b3.setForeground(new Color(255, 105, 180));
        b3.setBorder(new LineBorder(new Color(255,105,180), 2)); 
		con.add(b3);
		
		b4.setBounds(100,510,200,80);
		b4.setFont(customFont2);
		b4.setBackground(new Color(255, 204, 229)); 
        b4.setForeground(new Color(255, 105, 180));
        b4.setBorder(new LineBorder(new Color(255,105,180), 2)); 
		con.add(b4);
		
		l1.setBounds(310,240,950,80);
		l1.setFont(customFont2); 
	    l1.setOpaque(true);
        l1.setForeground(new Color(255, 105, 180));
        l1.setHorizontalAlignment(JTextField.LEFT);
        l1.setBackground(new Color(255,204,229));
        l1.setBorder(new LineBorder(new Color(255,105,180), 2)); 
		con.add(l1);
		
		l2.setBounds(310,330,950,80);
		l2.setFont(customFont2); 
	    l2.setOpaque(true);
        l2.setForeground(new Color(255, 105, 180));
        l2.setHorizontalAlignment(JTextField.LEFT);
        l2.setBackground(new Color(255,204,229));
        l2.setBorder(new LineBorder(new Color(255,105,180), 2)); 
		con.add(l2);
		
		l3.setBounds(310,420,950,80);
		l3.setFont(customFont2); 
	    l3.setOpaque(true);
        l3.setForeground(new Color(255, 105, 180));
        l3.setHorizontalAlignment(JTextField.LEFT);
        l3.setBackground(new Color(255,204,229));
        l3.setBorder(new LineBorder(new Color(255,105,180), 2)); 
		con.add(l3);
		
		l4.setBounds(310,510,950,80);
	    l4.setOpaque(true);
		l4.setFont(customFont2); 
        l4.setForeground(new Color(255, 105, 180));
        l4.setHorizontalAlignment(JTextField.LEFT);
        l4.setBackground(new Color(255,204,229));
        l4.setBorder(new LineBorder(new Color(255,105,180), 2)); 
		con.add(l4);
		
		time.setBounds(550,600,250,80);
	    time.setOpaque(true);
		time.setFont(customFont2); 
        time.setForeground(new Color(255, 105, 180));
        time.setHorizontalAlignment(JTextField.CENTER);
        time.setBackground(new Color(255,204,229));
        time.setBorder(new LineBorder(new Color(255,105,180), 3)); 
        time.setText(String.valueOf(seconds));
		con.add(time);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nextQuestion();
	}
  
	public void nextQuestion() {
		
		if(index>=total_q) {
			new Result(this);
			frame.dispose();
		}
		else{
			tf1.setText("QYESTION:"+(index+1));
			tf2.setText(questions[index]);
			l1.setText(options[index][0]);
			l2.setText(options[index][1]);
			l3.setText(options[index][2]);
			l4.setText(options[index][3]);

			timer.start();
		}
	
		if (playButton != null) {
	        con.remove(playButton);
	        playButton = null;
	    }
		
		if (index == 2) {
			tf2.setBounds(100,80,950,150);
			playButton=new JButton("Play Sound");
		    playButton.setBounds(1060, 80, 190, 150);
		    Font customFont = new Font("Serif", Font.BOLD, 30); 
		    playButton.setFont(customFont);
		    playButton.setBackground(new Color(255, 204, 229)); 
		    playButton.setForeground(new Color(255, 105, 180));
		    playButton.setBorder(new LineBorder(new Color(255,105,180), 2));
		    con.add(playButton);
		    con.revalidate(); // refresh layout
	        con.repaint();  
		    playButton.addActionListener(e -> playAudioFromResources("audio.wav"));
		}
		
		
		if(index==3) {
	
			tf2.setBounds(100,80,950,150);
			   JComponent image1= new JComponent() {
		            Image img = new ImageIcon("image.jpg").getImage();   

		            @Override
		            protected void paintComponent(Graphics g) {
		                super.paintComponent(g); 
		                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		            }
		        };
		        image1.setBounds(1060, 80, 190, 150);
		        con.add(image1);
		        con.revalidate(); // refresh layout
		        con.repaint();  
		}
	}
	private void playAudioFromResources(String fileName) {
	    try {
	        // Load file from resources folder
	        URL url = getClass().getResource("/" + fileName);
	        if (url == null) {
	            System.err.println("Audio file not found: " + fileName);
	            return;
	        }

	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioStream);
	        clip.start();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		b1.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		
		if(e.getSource() == b1) {
			answer ='A';
			if(answer==answers[index]) {
				correct++;
			}
			
		}
		if(e.getSource() == b2) {
				answer ='B';
				if(answer==answers[index]) {
					correct++;
				}
		}
		if(e.getSource() == b3) {
				answer ='C';
			if(answer==answers[index]) {
						correct++;
					}
		}
		if(e.getSource() == b4) {
			answer ='D';
		if(answer==answers[index]) {
					correct++;
				}
	}
      displayAnswer();
	}
	
	public void displayAnswer() {
		timer.stop();
		
		b1.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		
		if(answers[index]!='A') 
			l1.setForeground(new Color(255,102,102));
		if(answers[index]!='B') 
			l2.setForeground(new Color(255,102,102));
		if(answers[index]!='C') 
			l3.setForeground(new Color(255,102,102));
		if(answers[index]!='D') 
			l4.setForeground(new Color(255,102,102));
		
		if (answers[index] == 'A') 
		l1.setForeground(new Color(34,139,34));
	    if (answers[index] == 'B') 
	    l2.setForeground(new Color(34,139,34));
	    if (answers[index] == 'C') 
	    l3.setForeground(new Color(34,139,34));
	    if (answers[index] == 'D')
	    l4.setForeground(new Color(34,139,34));
	    
	    Timer pause=new Timer(2000,new ActionListener(){
	    	
	    	public void actionPerformed(ActionEvent e) {
	    		 l1.setForeground(new Color(255, 105, 180));
	    		 l2.setForeground(new Color(255, 105, 180));
	    		 l3.setForeground(new Color(255, 105, 180));
	    		 l4.setForeground(new Color(255, 105, 180));

	    		answer = '_' ;
	    		seconds =10;
	    	    time.setText(String.valueOf(seconds));
	    	    b1.setEnabled(true);
	    		b2.setEnabled(true);
	    		b3.setEnabled(true);
	    		b4.setEnabled(true);
	    		index++;
	    		nextQuestion();
	    		
	    	}
	    });
	    pause.setRepeats(false);
	    pause.start();
	}
	
	
	public static void main(String[] args) {
		Game game=new Game();
	}
}
