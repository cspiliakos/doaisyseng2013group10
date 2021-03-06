import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClickMeFrame extends JFrame{
	//frame for the puzzle click me
	private static final long serialVersionUID = 1L;
	private BackgroundPanel back;
	private JPanel scorePanel, timePanel;
	private int iconSize, score, lives, minutes, seconds, delay, oldX, oldY;
	private JLabel iconLabel, scoreLabel, lifeLabel, timeLabel;
	private Image background;
	private JButton pause;
	private boolean isRunning, hit;
	private Timer timer, iconTimer;
	private TimerClass count;
	private IconClass help;
	private User player;
	private MyListener listener; 
	private ArrayList<AudiosPair> list;
	private Sound_Thread soundthread1 = new Sound_Thread(); //Thread 1 gia mikrous hxous, pou diakoptei o enas ton allon
	private Sound_Thread soundthread2 = new Sound_Thread();//Thread 2 gia soundtrack
	
	public ClickMeFrame(User u) {
		
		
		setJMenuBar(new JMenuFrame().getMenu());
		//menu
		
		player = u;
		minutes =  2;
		seconds = 0;
		delay = 2000;
		hit = false;
		list = new ArrayList<AudiosPair>(new Audios().getClickMeList());
		soundthread2.PlayMusic(list.get(3).getSongName(), list.get(3).getRepeat());
		help = new IconClass();
		count = new TimerClass(minutes, seconds);
		//timer for the timer label
		iconTimer = new Timer(delay, help);
		//timer for the change of the frequency the image change place
		
		iconTimer.start();
		timer = new Timer(1000, count);
		//timer for the change of timer label
		timer.start();
		isRunning  = true;
		score = 0;
		lives = 3;
		try {
			background = ImageIO.read(new File("ClickMe\\land.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		back = new BackgroundPanel(background);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);
		setContentPane(back);
		//managing with the frame
		
		scorePanel = new JPanel();
		
		GridBagLayout gbl_scorePanel = new GridBagLayout();
		scorePanel.setLayout(gbl_scorePanel);
		
		scoreLabel = new JLabel("\u03A3\u03BA\u03BF\u03C1: 0");
		//label to keep up score
		scoreLabel.setForeground(new Color(128, 0, 0));
		scoreLabel.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_scoreLabel = new GridBagConstraints();
		gbc_scoreLabel.insets = new Insets(0, 0, 0, 5);
		gbc_scoreLabel.gridx = 0;
		gbc_scoreLabel.gridy = 0;
		scorePanel.add(scoreLabel, gbc_scoreLabel);
		back.add(scorePanel, BorderLayout.EAST);
		
		lifeLabel = new JLabel("\u0396\u03C9\u03AD\u03C2: 3");
		//label to keep up lives
		lifeLabel.setForeground(new Color(128, 0, 0));
		lifeLabel.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_lifeLabel = new GridBagConstraints();
		gbc_lifeLabel.gridx = 0;
		gbc_lifeLabel.gridy = 1;
		scorePanel.add(lifeLabel, gbc_lifeLabel);
		
		timeLabel = new JLabel(minutes+" : 0"+seconds);
		//label to show timer
		timeLabel.setFont(new Font("Sylfaen", Font.BOLD, 20));
		timeLabel.setForeground(new Color(139, 69, 19));
		timePanel = new JPanel();
		timePanel.add(timeLabel);
		pause = new JButton("\u03A0\u03B1\u03CD\u03C3\u03B7");
		pause.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isRunning)
				{
					//stop time if pause is pushed while the timer is running
					isRunning = false;
					timer.stop();
					iconTimer.stop();
					Toolkit.getDefaultToolkit().beep();
				}
				else
				{
					//start time if pause is pushed while the timer has stopped
					isRunning = true;
					timer.start();
					iconTimer.start();
				}
			}
		});
		timePanel.add(pause);
		back.add(timePanel, BorderLayout.NORTH);
		
		//getting the icon to start with
		iconSize = 150;
		iconLabel = new JLabel();
		help.add(iconLabel);
		ImageIcon icon = new ImageIcon("ClickMe\\medusa.png");
		Image image = icon.getImage();
		iconLabel.setSize(iconSize, iconSize);		
		Image resizedImage = image.getScaledInstance(iconLabel.getWidth(), iconLabel.getHeight(), 0);
		iconLabel.setIcon(new ImageIcon(resizedImage));
		listener = new MyListener();
		help.addMouseListener(listener);
		back.add(help, BorderLayout.CENTER);
		
		oldX = iconLabel.getX();
		oldY = iconLabel.getY();
		//keep the old coordinates in order to prevent double click 
	}
	
	public void checkIfHit(int x, int y){
		if((x != oldX) && (y != oldY) && (hit))
		{
			//check only if the coordinates of the pic has changed --> hit happened --> keep track of current coordinates
			hit = false;
			oldX = x;
			oldY = y;
		}
		else if((x != oldX) && (y != oldY) && (!hit))
		{
			//if coordinates has changed --> no hit happened --> loose a life
			lives--;
			lifeLabel.setText("\u0396\u03C9\u03AD\u03C2: "+lives);
			if(lives == 0 || (minutes == 0 && seconds == 0))      
			{
				//check if the game must end --> out of lives OR out of time
				soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat() ); //Sound: endofgame
				soundthread2.StopMusic();
				
				int currCoins=score*10;
				int currXP=score*100;
				//calculate coins and xp according to score achieved
				player.setCoins(player.getCoins() + currCoins);
				player.setXP(player.getXP() + currXP);
				player.increaseSkillPoints(player.getXP(), player.getSkillpoints());
				ClickMeFrame.this.setVisible(false);
				soundthread2.StopMusic();
				JOptionPane.showMessageDialog(null, "\u03A4\u03BF \u03C4\u03B5\u03BB\u03B9\u03BA\u03CC \u03C3\u03BA\u03BF\u03C1 \u03B5\u03AF\u03BD\u03B1\u03B9: "+score, "Τέλος παιχνιδιού", JOptionPane.INFORMATION_MESSAGE);
				if (lives == 0)
				{
					player.setWin(false);
					player.setPlayed(true);
					timer.stop();
					iconTimer.stop();
				}
				else
				{
					player.setWin(true);
					player.setPlayed(true);
					timer.stop();
					iconTimer.stop();
				}
				help.repaint();
			}
			oldX = x;
			oldY = y;
		}
	}
	
	public class IconClass extends JComponent implements ActionListener{
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g){
			super.paintComponent(g);
		}
		
		public void actionPerformed(ActionEvent e) {
			//repaints the icon in a different place
			checkIfHit(iconLabel.getX(),iconLabel.getY());
			Random r = new Random(System.currentTimeMillis());
			int randomX = r.nextInt(400 - iconSize);
			int randomY = r.nextInt((480 - iconSize) + (score + 1));
			iconLabel.setBounds(randomX, randomY, iconSize, iconSize);
		}
	}
	
	public class TimerClass implements ActionListener{
		//class for timer
		int minutes, seconds;
		
		public TimerClass(int minutes, int seconds)
		{
			this.minutes = minutes;
			this.seconds = seconds;
		}

		public void actionPerformed(ActionEvent arg0) {
			if(seconds == 0)
			{
				minutes--;
				seconds = 59;
			}
			else
			{
				seconds--;
			}

			if (seconds < 10)
			{
				timeLabel.setText(minutes+" : 0"+seconds);
			}
			else
			{
				timeLabel.setText(minutes+" : "+seconds);
			}
			
			if (seconds == 0 && minutes == 0)
			{
				timer.stop();
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
			
	class MyListener extends MouseAdapter {		
		public void mouseClicked(MouseEvent e) 
		{
			//function to deside if the click is correct or not
			int labelX = iconLabel.getX();
			int labelY = iconLabel.getY();
			int clickX = e.getX();
			int clickY = e.getY();
			
			checkIfHit(labelX, labelY);
			
			if((clickX >= labelX) && (clickX < (labelX + iconSize)) && (clickY >= labelY) && (clickY < (labelY + iconSize)))
			{
				//checks if the click is within the icon bounds
				soundthread1.PlayMusic(list.get(1).getSongName(), list.get(1).getRepeat() ); //Sound: right
				if(!hit)
				{
					//hit is true only if the player has hit the icon again before it changes its possition
					score = score + 1;
				}
					
				hit = true;
				scoreLabel.setText("\u03A3\u03BA\u03BF\u03C1: "+score);
				
				if ((score % 5) == 0){
					//for every 5 succesfull hits the size reduces 5% and the frequency the icon change place reduce 20%
					double size = iconSize / 1.05;
					iconSize = (int)Math.round(size);
					double timerDelay = delay / 1.20;
					delay = (int)Math.round(timerDelay);
					iconLabel.setSize(iconSize,iconSize);
					ImageIcon icon = new ImageIcon("ClickMe\\medusa.png");
					Image image=icon.getImage();
					Image resizedImage = image.getScaledInstance(iconLabel.getWidth(), iconLabel.getHeight(), 0);
					iconLabel.setIcon(new ImageIcon(resizedImage));
			}
			help.repaint();
			iconTimer.setDelay(delay);
			//set the new delay to the timer
			}
			else
			{
			//if click is out of bounds --> life lost -->check if the game is over
				soundthread1.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat() ); //Sound: wrong
				lives = lives - 1;
				lifeLabel.setText("\u0396\u03C9\u03AD\u03C2: "+lives);
				if(lives == 0 || (minutes == 0 && seconds == 0))
				{
					soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat() ); //Sound: endofgame
					int currCoins=score*10;
					int currXp=score*100;
					player.setCoins(player.getCoins() + currCoins);
					player.setXP(player.getXP() + currXp);
					player.increaseSkillPoints(player.getXP(), player.getSkillpoints());
					player.setPlayed(true);
					timer.stop();
					iconTimer.stop();
					ClickMeFrame.this.setVisible(false);
					soundthread2.StopMusic();
					JOptionPane.showMessageDialog(null, "\u03A4\u03BF \u03C4\u03B5\u03BB\u03B9\u03BA\u03CC \u03C3\u03BA\u03BF\u03C1 \u03B5\u03AF\u03BD\u03B1\u03B9: "+score, "Τέλος παιχνιδιού", JOptionPane.INFORMATION_MESSAGE);
					help.repaint();
				}
			}
		}
	}
}
