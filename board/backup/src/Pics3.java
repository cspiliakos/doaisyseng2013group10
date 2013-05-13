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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class Pics3 extends JFrame{
	private static final long serialVersionUID = 1L;
	private User player;
	private Image background, help, resize;
	private ImageIcon selected;
	private BackgroundPanel back;
	private JButton pause, commit;
	private Timer timer;
	private TimerClass count;
	private JPanel timePanel, mainPanel, scorePanel;
	private int helpWidth, helpHeight, widthSize, heightSize, minutes, seconds, score;
	private JLabel timeLabel, photo1, photo2, photo3, scoreLabel, question;
	private double frameWidth, frameHeight;
	private Uicons iconlist;
	private boolean isRunning;
	private ArrayList<ImageIcon> currlist, usedImages, helpImages;
	private Random r;
	private JTextField field;
	private String correct;
	
	ArrayList<AudiosPair> list = new ArrayList<AudiosPair>(new Audios().getPics3List()); 
	Sound_Thread soundthread1 = new Sound_Thread(); //Thread 1 gia mikrous hxous, pou diakoptei o enas ton allon
	Sound_Thread soundthread2 = new Sound_Thread(); //Thread 2 gia soundtrack
	
	public Pics3(User u){
		
		soundthread2.PlayMusic(list.get(1).getSongName(), list.get(1).getRepeat());
		//sound theme
		
		setJMenuBar(new JMenuFrame().getMenu());
		//menu
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameWidth = screenSize.getWidth();
		frameHeight = screenSize.getHeight();
		helpWidth = (int)frameWidth;
		helpHeight = (int)frameHeight;
		widthSize = helpWidth / 4;
		heightSize = helpHeight / 2;
		//managing frame dimension
		
		r = new Random(System.currentTimeMillis());
		iconlist = new Uicons();
		currlist = new ArrayList<ImageIcon>(iconlist.getPics3());
		usedImages = new ArrayList<ImageIcon>();
		selected = new ImageIcon();
		player = u;
		minutes =  2;
		seconds = 0;
		score = 0;
		count = new TimerClass(minutes, seconds);
		timer = new Timer(1000, count);
		isRunning  = true;
		timer.start();
		//frame components
		
		try {
			background = ImageIO.read(new File("UIcons\\olympus.jpg"));
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
		//managing frame
		
		timeLabel = new JLabel(minutes+" : 0"+seconds);
		timeLabel.setFont(new Font("Sylfaen", Font.BOLD, 20));
		timeLabel.setForeground(new Color(139, 69, 19));
		timePanel = new JPanel();
		timePanel.add(timeLabel);
		//indicates time
		pause = new JButton("\u03A0\u03B1\u03CD\u03C3\u03B7");
		//pushed while time is running --> time stop
		//pushed while time is stopped --> time run
		//when stopped the field used to enter the hero's name is disable
		pause.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isRunning)
				{
					isRunning = false;
					timer.stop();
					Toolkit.getDefaultToolkit().beep();	
					field.setEnabled(false);
					commit.setEnabled(false);
				}
				else
				{
					isRunning = true;
					timer.start();
					field.setEnabled(true);
					commit.setEnabled(true);
				}
			}
		});
		timePanel.add(pause);
		back.add(timePanel, BorderLayout.NORTH);
		
		///////////////////////
		mainPanel = new JPanel();
		back.add(mainPanel, BorderLayout.CENTER);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		mainPanel.setLayout(gbl_mainPanel);
		
		question = new JLabel("Ποιο πρόσωπο συνδέει τις παρακάτω εικόνες;");
		question.setForeground(Color.RED);
		question.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		GridBagConstraints gbc_question = new GridBagConstraints();
		gbc_question.insets = new Insets(0, 0, 5, 0);
		gbc_question.gridwidth = 3;
		gbc_question.gridy = 0;
		gbc_question.gridx = 0;
		mainPanel.add(question, gbc_question);
		
		//setting the labels for the photos --> 3 photos taken from Uicons
		photo1 = new JLabel();
		GridBagConstraints gbc_photo1 = new GridBagConstraints();
		gbc_photo1.insets = new Insets(0, 0, 5, 5);
		gbc_photo1.gridx = 0;
		gbc_photo1.gridy = 1;
		mainPanel.add(photo1, gbc_photo1);
		
		photo2 = new JLabel();
		GridBagConstraints gbc_photo2 = new GridBagConstraints();
		gbc_photo2.insets = new Insets(0, 0, 5, 5);
		gbc_photo2.gridx = 1;
		gbc_photo2.gridy = 1;
		mainPanel.add(photo2, gbc_photo2);
		
		photo3 = new JLabel();
		GridBagConstraints gbc_photo3 = new GridBagConstraints();
		gbc_photo3.insets = new Insets(0, 0, 5, 0);
		gbc_photo3.gridx = 2;
		gbc_photo3.gridy = 1;
		mainPanel.add(photo3, gbc_photo3);
		
		commit = new JButton();
		//button to commit your answer
		commit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat());
				
				if (field.getText().toUpperCase().equals(correct))
				{
					//if correct score +1 get next 3 pics and clear the textfield
					score++;
					scoreLabel.setText("\u03A3\u03BA\u03BF\u03C1: "+score);
				}
				getQuestion();
				field.setText(null);
			}
		});
		
		//field to enter the hero's name as answer
		field = new JTextField();
		field.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_field = new GridBagConstraints();
		gbc_field.insets = new Insets(0, 0, 5, 5);
		gbc_field.gridx = 1;
		gbc_field.gridy = 2;
		mainPanel.add(field, gbc_field);
		field.setColumns(10);
		commit.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		commit.setText("\u0388\u03BB\u03B5\u03B3\u03C7\u03BF\u03C2");
		GridBagConstraints gbc_commit = new GridBagConstraints();
		gbc_commit.insets = new Insets(0, 0, 0, 5);
		gbc_commit.gridx = 1;
		gbc_commit.gridy = 3;
		mainPanel.add(commit, gbc_commit);
		
		//////////////////////////
		scorePanel = new JPanel();
		//keeps score
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
		
		//get the initial question
		getQuestion();
	}
	
	public void getQuestion(){
		//method to get different question over time till the available question list is empty
		//every used question is added to another list
		helpImages = new ArrayList<ImageIcon>();
		
		if (usedImages.size() == currlist.size())
		{
			usedImages = new ArrayList<ImageIcon>();
		}
		
		int randomIndex = r.nextInt(currlist.size());
		selected = currlist.get(randomIndex);
	
		while (usedImages.contains(selected)){
			randomIndex = r.nextInt(currlist.size());
			selected = currlist.get(randomIndex);
		}
		helpImages.add(selected);
		//adding selected icons
		
		for (int i = 0; i < currlist.size(); i++)
		{
			if (currlist.get(i).getDescription().equals(selected.getDescription()) && !helpImages.contains(currlist.get(i)))
			{
				helpImages.add(currlist.get(i));
			}
		}
		
		//adding used images to the used list to know which of them have not been shown
		usedImages.add(helpImages.get(0));
		help = helpImages.get(0).getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		photo1.setIcon(new ImageIcon(resize));
	
		usedImages.add(helpImages.get(1));
		help = helpImages.get(1).getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		photo2.setIcon(new ImageIcon(resize));
	
		usedImages.add(helpImages.get(2));
		help = helpImages.get(2).getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		photo3.setIcon(new ImageIcon(resize));
		
		correct = selected.getDescription();
		//correct hold the name of the hero is the answer to the question
	}
	
	public class TimerClass implements ActionListener{
		//managing timer
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
				//if out of time and score >8 win else lose
				soundthread2.StopMusic();
				timer.stop();
				Toolkit.getDefaultToolkit().beep();
				player.setCoins(player.getCoins() + 1000);
				player.setXP(player.getXP() + 1000);
				player.increaseSkillPoints(player.getXP(), player.getSkillpoints());
				Pics3.this.setVisible(false);
				JOptionPane.showMessageDialog(null, "\u03A4\u03BF \u03C4\u03B5\u03BB\u03B9\u03BA\u03CC \u03C3\u03BA\u03BF\u03C1 \u03B5\u03AF\u03BD\u03B1\u03B9: "+score, "Τέλος παιχνιδιού", JOptionPane.INFORMATION_MESSAGE);
				if (score > 8)
				{
					player.setWin(true);
				}
				else
				{
					player.setWin(false);
				}
			}
		}
	}
}
