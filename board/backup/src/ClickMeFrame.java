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
	private Sound_Thread soundthread1;
	
	public ClickMeFrame(User u) {
		setJMenuBar(new JMenuFrame().getMenu());
		player = u;
		minutes =  2;
		seconds = 0;
		delay = 2000;
		hit = false;
		list = new ArrayList<AudiosPair>(new Audios().getClickMeList());
		help = new IconClass();
		count = new TimerClass(minutes, seconds);
		iconTimer = new Timer(delay, help);
		soundthread1 = new Sound_Thread();
		iconTimer.start();
		timer = new Timer(1000, count);
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
		
		scorePanel = new JPanel();
		GridBagLayout gbl_scorePanel = new GridBagLayout();
		scorePanel.setLayout(gbl_scorePanel);
		
		scoreLabel = new JLabel("\u03A3\u03BA\u03BF\u03C1: 0");
		scoreLabel.setForeground(new Color(128, 0, 0));
		scoreLabel.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_scoreLabel = new GridBagConstraints();
		gbc_scoreLabel.insets = new Insets(0, 0, 0, 5);
		gbc_scoreLabel.gridx = 0;
		gbc_scoreLabel.gridy = 0;
		scorePanel.add(scoreLabel, gbc_scoreLabel);
		back.add(scorePanel, BorderLayout.EAST);
		
		lifeLabel = new JLabel("\u0396\u03C9\u03AD\u03C2: 3");
		lifeLabel.setForeground(new Color(128, 0, 0));
		lifeLabel.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_lifeLabel = new GridBagConstraints();
		gbc_lifeLabel.gridx = 0;
		gbc_lifeLabel.gridy = 1;
		scorePanel.add(lifeLabel, gbc_lifeLabel);
		
		timeLabel = new JLabel(minutes+" : 0"+seconds);
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
					isRunning = false;
					timer.stop();
					iconTimer.stop();
					Toolkit.getDefaultToolkit().beep();
				}
				else
				{
					isRunning = true;
					timer.start();
					iconTimer.start();
				}
			}
		});
		timePanel.add(pause);
		back.add(timePanel, BorderLayout.NORTH);
		
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
	}
	
	public void checkIfHit(int x, int y){
		if((x!=oldX)&&(y!=oldY)&&(hit))
		{
			hit = false;
			oldX = x;
			oldY = y;
		}
		else if((x != oldX) && (y != oldY) && (!hit))
		{
			lives--;
			lifeLabel.setText("\u0396\u03C9\u03AD\u03C2: "+lives);
			if(lives == 0 || (minutes == 0 && seconds == 0))
			{
				soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat() ); //Sound: endofgame
				player.setCoins(player.getCoins() + 1000);
				player.setXP(player.getXP() + 100);
				ClickMeFrame.this.setVisible(false);
				JOptionPane.showMessageDialog(null, "\u03A4\u03BF \u03C4\u03B5\u03BB\u03B9\u03BA\u03CC \u03C3\u03BA\u03BF\u03C1 \u03B5\u03AF\u03BD\u03B1\u03B9: "+score);
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
			checkIfHit(iconLabel.getX(),iconLabel.getY());
			Random r = new Random(System.currentTimeMillis());
			int randomX = r.nextInt(400 - iconSize);
			int randomY = r.nextInt((480 - iconSize) + (score + 1));
			iconLabel.setBounds(randomX, randomY, iconSize, iconSize);
		}
	}
	
	public class TimerClass implements ActionListener{
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
			int labelX = iconLabel.getX();
			int labelY = iconLabel.getY();
			int clickX = e.getX();
			int clickY = e.getY();
			
			checkIfHit(labelX, labelY);
			
			if((clickX >= labelX) && (clickX < (labelX + iconSize)) && (clickY >= labelY) && (clickY < (labelY + iconSize)))
			{
				soundthread1.PlayMusic(list.get(1).getSongName(), list.get(1).getRepeat() ); //Sound: right
				if(!hit)
				{
					score = score + 1;
				}
					
				hit = true;
				scoreLabel.setText("\u03A3\u03BA\u03BF\u03C1: "+score);
				if ((score % 5) == 0){
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
			}
			else
			{
				soundthread1.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat() ); //Sound: wrong
				lives = lives - 1;
				lifeLabel.setText("\u0396\u03C9\u03AD\u03C2: "+lives);
				if(lives == 0 || (minutes == 0 && seconds == 0))
				{
					soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat() ); //Sound: endofgame
					player.setCoins(player.getCoins() + 1000);
					player.setXP(player.getXP() + 100);
					ClickMeFrame.this.setVisible(false);
					JOptionPane.showMessageDialog(null, "\u03A4\u03BF \u03C4\u03B5\u03BB\u03B9\u03BA\u03CC \u03C3\u03BA\u03BF\u03C1 \u03B5\u03AF\u03BD\u03B1\u03B9: "+score);
					help.repaint();
				}
			}
		}
	}
}
