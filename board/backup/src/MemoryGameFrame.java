import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Cursor;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;

public class MemoryGameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private User player;
	private Image background, help, resize;
	private ImageIcon hero, helpIcon, check;
	private BackgroundPanel back;
	private JButton pause;
	private Timer timer, turnTimer, wrongTimer;
	private TimerClass count;
	private TurnClass turn;
	private JPanel timePanel, mainPanel;
	private int helpWidth, helpHeight, widthSize, heightSize, minutes, seconds, correct;
	private JLabel timeLabel, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10,
	label11, label12, label13, label14, label15, label16, helpLabel;
	private double frameWidth, frameHeight;
	private Uicons iconlist;
	private ArrayList<ImageIcon> currlist;
	private boolean isRunning, turned, hasPicked;
	private Labels listen;
	private Wrong wrong;
	private Sound_Thread soundthread1, soundthread2;
	private ArrayList<AudiosPair> list;

	public MemoryGameFrame(User u) {
		setJMenuBar(new JMenuFrame().getMenu());
		//menu
		list = new ArrayList<AudiosPair>(new Audios().getMemoryGameList()); 
		soundthread1 = new Sound_Thread();
		soundthread2 = new Sound_Thread();
		soundthread2.PlayMusic(list.get(4).getSongName(), list.get(4).getRepeat());
		//managing sounds
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameWidth = screenSize.getWidth();
		frameHeight = screenSize.getHeight();
		helpWidth = (int)frameWidth;
		helpHeight = (int)frameHeight;
		widthSize = helpWidth / 5;
		heightSize = helpHeight / 5;
		//managing screen dimension
		
		iconlist = new Uicons();
		currlist = new ArrayList<ImageIcon>(iconlist.getMMGIcons());
		Collections.shuffle(currlist.subList(2, currlist.size()));
		//getting icons used and suffle them

		helpIcon = new ImageIcon();
		check = new ImageIcon();
		player = u;
		correct = 0;
		minutes =  2;
		seconds = 0;
		turned = false;
		count = new TimerClass(minutes, seconds);
		timer = new Timer(1000, count);
		turn = new TurnClass(turned);
		turnTimer = new Timer(3500, turn);
		isRunning  = true;
		hasPicked = false;
		turnTimer.start();
		listen = new Labels();
		try {
			background = ImageIO.read(new File("UIcons\\mmg_background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		////////////////
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);
		back = new BackgroundPanel(background);
		setContentPane(back);
		back.setLayout(new BorderLayout(5, 5));
		
		timeLabel = new JLabel(minutes+" : 0"+seconds);
		timeLabel.setFont(new Font("Sylfaen", Font.BOLD, 20));
		timeLabel.setForeground(new Color(139, 69, 19));
		timePanel = new JPanel();
		timePanel.add(timeLabel);
		//indicates time
		
		pause = new JButton("\u03A0\u03B1\u03CD\u03C3\u03B7");
		pause.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		//pushed while running --> stop
		//pushed while stopped --> run
		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isRunning)
				{
					isRunning = false;
					timer.stop();
					Toolkit.getDefaultToolkit().beep();	
					label1.removeMouseListener(listen);
					label2.removeMouseListener(listen);
					label3.removeMouseListener(listen);
					label4.removeMouseListener(listen);
					label5.removeMouseListener(listen);
					label6.removeMouseListener(listen);
					label7.removeMouseListener(listen);
					label8.removeMouseListener(listen);
					label9.removeMouseListener(listen);
					label10.removeMouseListener(listen);
					label11.removeMouseListener(listen);
					label12.removeMouseListener(listen);
					label13.removeMouseListener(listen);
					label14.removeMouseListener(listen);
					label15.removeMouseListener(listen);
					label16.removeMouseListener(listen);
					//remove all listeners so the player cannot gain time
				}
				else
				{
					isRunning = true;
					timer.start();
					label1.addMouseListener(listen);
					label2.addMouseListener(listen);
					label3.addMouseListener(listen);
					label4.addMouseListener(listen);
					label5.addMouseListener(listen);
					label6.addMouseListener(listen);
					label7.addMouseListener(listen);
					label8.addMouseListener(listen);
					label9.addMouseListener(listen);
					label10.addMouseListener(listen);
					label11.addMouseListener(listen);
					label12.addMouseListener(listen);
					label13.addMouseListener(listen);
					label14.addMouseListener(listen);
					label15.addMouseListener(listen);
					label16.addMouseListener(listen);
					//re-add all listeners to continue game
				}
			}
		});
		timePanel.add(pause);
		back.add(timePanel, BorderLayout.NORTH);
		
		//////////////////////////
		mainPanel = new JPanel();
		back.add(mainPanel, BorderLayout.CENTER);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		mainPanel.setLayout(gbl_mainPanel);
		
		//constracting the labels for the icons --> 16 labels - 8 pairs
		label1 = new JLabel();
		label1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(2).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label1.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.insets = new Insets(0, 0, 0, 5);
		gbc_label1.gridx = 0;
		gbc_label1.gridy = 0;
		mainPanel.add(label1, gbc_label1);
		
		label2 = new JLabel();
		label2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(3).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label2.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_label2 = new GridBagConstraints();
		gbc_label2.insets = new Insets(0, 0, 0, 5);
		gbc_label2.gridx = 1;
		gbc_label2.gridy = 0;
		mainPanel.add(label2, gbc_label2);
		
		label3 = new JLabel();
		label3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(4).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label3.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_label3 = new GridBagConstraints();
		gbc_label3.insets = new Insets(0, 0, 0, 5);
		gbc_label3.gridx = 2;
		gbc_label3.gridy = 0;
		mainPanel.add(label3, gbc_label3);
		
		label4 = new JLabel();
		label4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(5).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label4.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_label4 = new GridBagConstraints();
		gbc_label4.insets = new Insets(0, 0, 0, 5);
		gbc_label4.gridx = 3;
		gbc_label4.gridy = 0;
		mainPanel.add(label4, gbc_label4);
		
		label5 = new JLabel();
		label5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(6).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label5.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_label5 = new GridBagConstraints();
		gbc_label5.insets = new Insets(0, 0, 0, 5);
		gbc_label5.gridx = 0;
		gbc_label5.gridy = 1;
		mainPanel.add(label5, gbc_label5);
		
		label6 = new JLabel();
		label6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(7).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label6.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_label6 = new GridBagConstraints();
		gbc_label6.insets = new Insets(0, 0, 0, 5);
		gbc_label6.gridx = 1;
		gbc_label6.gridy = 1;
		mainPanel.add(label6, gbc_label6);
		
		label7 = new JLabel();
		label7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(8).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label7.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_label7 = new GridBagConstraints();
		gbc_label7.insets = new Insets(0, 0, 0, 5);
		gbc_label7.gridx = 2;
		gbc_label7.gridy = 1;
		mainPanel.add(label7, gbc_label7);
		
		label8 = new JLabel();
		label8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(9).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label8.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_label8 = new GridBagConstraints();
		gbc_label8.insets = new Insets(0, 0, 0, 5);
		gbc_label8.gridx = 3;
		gbc_label8.gridy = 1;
		mainPanel.add(label8, gbc_label8);
		
		label9 = new JLabel();
		label9.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(10).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label9.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_label9 = new GridBagConstraints();
		gbc_label9.insets = new Insets(0, 0, 0, 5);
		gbc_label9.gridx = 0;
		gbc_label9.gridy = 2;
		mainPanel.add(label9, gbc_label9);
		
		label10 = new JLabel();
		label10.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(11).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label10.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_label10 = new GridBagConstraints();
		gbc_label10.insets = new Insets(0, 0, 0, 5);
		gbc_label10.gridx = 1;
		gbc_label10.gridy = 2;
		mainPanel.add(label10, gbc_label10);
		
		label11 = new JLabel();
		label11.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(12).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label11.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_label11 = new GridBagConstraints();
		gbc_label11.insets = new Insets(0, 0, 0, 5);
		gbc_label11.gridx = 2;
		gbc_label11.gridy = 2;
		mainPanel.add(label11, gbc_label11);
		
		label12 = new JLabel();
		label12.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(13).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label12.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_label12 = new GridBagConstraints();
		gbc_label12.insets = new Insets(0, 0, 0, 5);
		gbc_label12.gridx = 3;
		gbc_label12.gridy = 2;
		mainPanel.add(label12, gbc_label12);
		
		label13 = new JLabel();
		label13.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(14).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label13.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_label13 = new GridBagConstraints();
		gbc_label13.insets = new Insets(0, 0, 0, 5);
		gbc_label13.gridx = 0;
		gbc_label13.gridy = 3;
		mainPanel.add(label13, gbc_label13);
		
		label14 = new JLabel();
		label14.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(15).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label14.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_label14 = new GridBagConstraints();
		gbc_label14.insets = new Insets(0, 0, 0, 5);
		gbc_label14.gridx = 1;
		gbc_label14.gridy = 3;
		mainPanel.add(label14, gbc_label14);
		
		label15 = new JLabel();
		label15.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(16).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label15.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_label15 = new GridBagConstraints();
		gbc_label15.insets = new Insets(0, 0, 0, 5);
		gbc_label15.gridx = 2;
		gbc_label15.gridy = 3;
		mainPanel.add(label15, gbc_label15);
		
		label16 = new JLabel();
		label16.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(17).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label16.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_label16 = new GridBagConstraints();
		gbc_label16.gridx = 3;
		gbc_label16.gridy = 3;
		mainPanel.add(label16, gbc_label16);
		
		helpLabel = new JLabel();
	}
	
	public void Verify_CardLabel (JLabel cd, ImageIcon check){
		// check if the two selected icons match
		if(!hasPicked)
		{
			//the helpLabel = the first label chosen
			helpLabel = cd;
			hasPicked = true;
		}
		else
		{
			//for the second label chosen --> check the description given in the Uicons
			//if descriptions with helpLabel match --> correct
			//if descriptions with helpLabel do not match --> wrong
			if(helpIcon.getDescription().equals(check.getDescription()))
			{
				soundthread1.PlayMusic(list.get(1).getSongName(), list.get(1).getRepeat());

				correct++;
				//increase score
				//remove listener and disable --> player cannot use the same image
				cd.removeMouseListener(listen);
				helpLabel.removeMouseListener(listen);
				cd.setEnabled(false);
				helpLabel.setEnabled(false);
			}
			else
			{
				wrong = new Wrong(helpLabel, cd);
				wrongTimer = new Timer(500, wrong);
				wrongTimer.start();
				label1.removeMouseListener(listen);
				label2.removeMouseListener(listen);
				label3.removeMouseListener(listen);
				label4.removeMouseListener(listen);
				label5.removeMouseListener(listen);
				label6.removeMouseListener(listen);
				label7.removeMouseListener(listen);
				label8.removeMouseListener(listen);
				label9.removeMouseListener(listen);
				label10.removeMouseListener(listen);
				label11.removeMouseListener(listen);
				label12.removeMouseListener(listen);
				label13.removeMouseListener(listen);
				label14.removeMouseListener(listen);
				label15.removeMouseListener(listen);
				label16.removeMouseListener(listen);
			}
			hasPicked = false;
		}
	}

	public void AppearLabel(JLabel label, int i){
		//adjust icons to a fixed size
		hero = new ImageIcon(currlist.get(i + 1).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		label.setIcon(new ImageIcon(resize));
		//get the description of icon from Uicons for first and second picked labels
		if (!hasPicked)
		{
			helpIcon.setDescription(currlist.get(i + 1).getDescription());
		}
		else
		{
			check.setDescription(currlist.get(i + 1).getDescription());
		}
	}
	
	public class Labels implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat());
			
			if (helpLabel != e.getSource())
			{
				//setting the actions for each label according to click
				if(e.getSource() == label1 && label1.isEnabled())
				{
					AppearLabel(label1, 1);
					Verify_CardLabel(label1, check);
				}
				else if(e.getSource() == label2 && label2.isEnabled())
				{
					AppearLabel(label2, 2);
					Verify_CardLabel(label2, check);
				}
				else if(e.getSource() == label3 && label3.isEnabled())
				{
					AppearLabel(label3, 3);
					Verify_CardLabel(label3, check);
				}
				else if(e.getSource() == label4 && label4.isEnabled())
				{
					AppearLabel(label4, 4);
					Verify_CardLabel(label4, check);
				}
				else if(e.getSource() == label5 && label5.isEnabled())
				{
					AppearLabel(label5, 5);
					Verify_CardLabel(label5, check);
				}
				else if(e.getSource() == label6 && label6.isEnabled())
				{
					AppearLabel(label6, 6);
					Verify_CardLabel(label6, check);
				}
				else if(e.getSource() == label7 && label7.isEnabled())
				{
					AppearLabel(label7, 7);
					Verify_CardLabel(label7, check);
				}
				else if(e.getSource() == label8 && label8.isEnabled())
				{
					AppearLabel(label8, 8);
					Verify_CardLabel(label8, check);
				}
				else if(e.getSource() == label9 && label9.isEnabled())
				{
					AppearLabel(label9, 9);
					Verify_CardLabel(label9, check);
				}
				else if(e.getSource() == label10 && label10.isEnabled())
				{
					AppearLabel(label10, 10);
					Verify_CardLabel(label10, check);
				}
				else if(e.getSource() == label11 && label11.isEnabled())
				{
					AppearLabel(label11, 11);
					Verify_CardLabel(label11, check);
				}
				else if(e.getSource() == label12 && label12.isEnabled())
				{
					AppearLabel(label12, 12);
					Verify_CardLabel(label12, check);
				}
				else if(e.getSource() == label13 && label13.isEnabled())
				{
					AppearLabel(label13, 13);
					Verify_CardLabel(label13, check);
				}
				else if(e.getSource() == label14 && label14.isEnabled())
				{
					AppearLabel(label14, 14);
					Verify_CardLabel(label14, check);
				}
				else if(e.getSource() == label15 && label15.isEnabled())
				{
					AppearLabel(label15, 15);
					Verify_CardLabel(label15, check);
				}
				else if(e.getSource() == label16 && label16.isEnabled())
				{
					AppearLabel(label16, 16);
					Verify_CardLabel(label16, check);
				}
			}
			
			if(correct == 8)
			{
				//requirment for the win 8 correct matching
				soundthread1.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat());
				//get coins and xp--> return to BoardFrame
				player.setCoins(player.getCoins() + 1000);
				player.setXP(player.getXP() + 1000);
				player.increaseSkillPoints(player.getXP(), player.getSkillpoints());
				MemoryGameFrame.this.setVisible(false);
				soundthread1.StopMusic();
				soundthread2.StopMusic();
				JOptionPane.showMessageDialog(null, "Συγχαρητήρια.", "Τέλος παιχνιδιού", JOptionPane.INFORMATION_MESSAGE);
				player.setWin(true);
				player.setPlayed(true);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub	
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
			//managing timer
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
				MemoryGameFrame.this.setVisible(false);
				soundthread2.StopMusic();
				JOptionPane.showMessageDialog(null, "Έχασες.", "Τέλος παιχνιδιού", JOptionPane.ERROR_MESSAGE);
				player.setWin(false);
				player.setPlayed(true);
			}
		}
	}
	
	public class TurnClass implements ActionListener{
		boolean turned;
		
		public TurnClass(boolean turned)
		{
			this.turned = turned;
		}

		public void actionPerformed(ActionEvent arg0) {
			hero = new ImageIcon(currlist.get(1).getImage());
			help = hero.getImage();
			resize = help.getScaledInstance(widthSize, heightSize, 0);
			if (!turned)
			{
				label1.setIcon(new ImageIcon(resize));
				label2.setIcon(new ImageIcon(resize));
				label3.setIcon(new ImageIcon(resize));
				label4.setIcon(new ImageIcon(resize));
				label5.setIcon(new ImageIcon(resize));
				label6.setIcon(new ImageIcon(resize));
				label7.setIcon(new ImageIcon(resize));
				label8.setIcon(new ImageIcon(resize));
				label9.setIcon(new ImageIcon(resize));
				label10.setIcon(new ImageIcon(resize));
				label11.setIcon(new ImageIcon(resize));
				label12.setIcon(new ImageIcon(resize));
				label13.setIcon(new ImageIcon(resize));
				label14.setIcon(new ImageIcon(resize));
				label15.setIcon(new ImageIcon(resize));
				label16.setIcon(new ImageIcon(resize));
				turned = true;
			}
			else
			{
				turnTimer.stop();
				timer.start();
				label1.addMouseListener(listen);
				label2.addMouseListener(listen);
				label3.addMouseListener(listen);
				label4.addMouseListener(listen);
				label5.addMouseListener(listen);
				label6.addMouseListener(listen);
				label7.addMouseListener(listen);
				label8.addMouseListener(listen);
				label9.addMouseListener(listen);
				label10.addMouseListener(listen);
				label11.addMouseListener(listen);
				label12.addMouseListener(listen);
				label13.addMouseListener(listen);
				label14.addMouseListener(listen);
				label15.addMouseListener(listen);
				label16.addMouseListener(listen);
			}
		}
	}
	
	public class Wrong implements ActionListener{
		
		JLabel prev, curr;
		
		public Wrong (JLabel prev, JLabel curr)
		{
			this.prev = prev;
			this.curr = curr;
		}
		public void actionPerformed(ActionEvent arg0) {
			hero = new ImageIcon(currlist.get(1).getImage());
			help = hero.getImage();
			resize = help.getScaledInstance(widthSize, heightSize, 0);
			curr.setIcon(new ImageIcon(resize));
			helpLabel.setIcon(new ImageIcon(resize));
			label1.addMouseListener(listen);
			label2.addMouseListener(listen);
			label3.addMouseListener(listen);
			label4.addMouseListener(listen);
			label5.addMouseListener(listen);
			label6.addMouseListener(listen);
			label7.addMouseListener(listen);
			label8.addMouseListener(listen);
			label9.addMouseListener(listen);
			label10.addMouseListener(listen);
			label11.addMouseListener(listen);
			label12.addMouseListener(listen);
			label13.addMouseListener(listen);
			label14.addMouseListener(listen);
			label15.addMouseListener(listen);
			label16.addMouseListener(listen);
			wrongTimer.stop();
		}
	}
}
