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
import java.util.Random;
import java.awt.Cursor;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class PicsHerosFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private User player;
	private Image background, help, resize;
	private ImageIcon selected, correct, check;
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
	private Labels listen;
	private ArrayList<ImageIcon> currlist, usedImages, helpImages;
	private Random r;
	private String name1, name2, name3;
	private ArrayList<String> helpString;
	
	public PicsHerosFrame(User u){
		setJMenuBar(new JMenuFrame().getMenu());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameWidth = screenSize.getWidth();
		frameHeight = screenSize.getHeight();
		helpWidth = (int)frameWidth;
		helpHeight = (int)frameHeight;
		widthSize = helpWidth / 4;
		heightSize = helpHeight / 2;
		r = new Random(System.currentTimeMillis());
		iconlist = new Uicons();
		currlist = new ArrayList<ImageIcon>(iconlist.getPicsHerosIcons());
		usedImages = new ArrayList<ImageIcon>();
		selected = new ImageIcon();
		correct = new ImageIcon();
		check = new ImageIcon();
		player = u;
		minutes =  2;
		seconds = 0;
		score = 0;
		count = new TimerClass(minutes, seconds);
		timer = new Timer(1000, count);
		isRunning  = true;
		timer.start();
		listen = new Labels();
		name1 = "στον";
		name2 = "στην";
		name3 = "στο";
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
					Toolkit.getDefaultToolkit().beep();	
					photo1.removeMouseListener(listen);
					photo2.removeMouseListener(listen);
					photo3.removeMouseListener(listen);
					commit.setEnabled(false);
				}
				else
				{
					isRunning = true;
					timer.start();
					photo1.addMouseListener(listen);
					photo2.addMouseListener(listen);
					photo3.addMouseListener(listen);
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
		
		question = new JLabel();
		question.setForeground(Color.RED);
		question.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		GridBagConstraints gbc_question = new GridBagConstraints();
		gbc_question.gridwidth = 3;
		gbc_question.gridy = 0;
		gbc_question.gridx = 0;
		mainPanel.add(question, gbc_question);
		
		photo1 = new JLabel();
		photo1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		photo1.addMouseListener(listen);
		GridBagConstraints gbc_photo1 = new GridBagConstraints();
		gbc_photo1.insets = new Insets(0, 0, 0, 5);
		gbc_photo1.gridx = 0;
		gbc_photo1.gridy = 1;
		mainPanel.add(photo1, gbc_photo1);
		
		photo2 = new JLabel();
		photo2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		photo2.addMouseListener(listen);
		GridBagConstraints gbc_photo2 = new GridBagConstraints();
		gbc_photo2.insets = new Insets(0, 0, 0, 5);
		gbc_photo2.gridx = 1;
		gbc_photo2.gridy = 1;
		mainPanel.add(photo2, gbc_photo2);
		
		photo3 = new JLabel();
		photo3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		photo3.addMouseListener(listen);
		GridBagConstraints gbc_photo3 = new GridBagConstraints();
		gbc_photo3.insets = new Insets(0, 0, 0, 5);
		gbc_photo3.gridx = 2;
		gbc_photo3.gridy = 1;
		mainPanel.add(photo3, gbc_photo3);
		
		commit = new JButton();
		commit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (correct.getDescription().equals(check.getDescription()))
				{
					score++;
					scoreLabel.setText("\u03A3\u03BA\u03BF\u03C1: "+score);
				}
				getQuestion();
				photo1.setBorder(null);
				photo2.setBorder(null);
				photo3.setBorder(null);
			}
		});
		commit.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		commit.setText("\u0388\u03BB\u03B5\u03B3\u03C7\u03BF\u03C2");
		GridBagConstraints gbc_commit = new GridBagConstraints();
		gbc_commit.gridx = 1;
		gbc_commit.gridy = 2;
		mainPanel.add(commit, gbc_commit);
		
		//////////////////////////
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
		
		getQuestion();
	}
	
	public void getQuestion(){
		helpImages = new ArrayList<ImageIcon>();
		helpString = new ArrayList<String>();
		
		if (usedImages.size() + 2 == currlist.size())
		{
			usedImages = new ArrayList<ImageIcon>();
		}
		
		for (int i = 0; i < 3; i++)
		{
			int randomIndex = r.nextInt(currlist.size());
			selected = currlist.get(randomIndex);
		
			while (usedImages.contains(selected) || helpImages.contains(selected)){
				randomIndex = r.nextInt(currlist.size());
				selected = currlist.get(randomIndex);
			}
			helpImages.add(selected);
			
			if (i == 0)
			{
				help = selected.getImage();
				resize = help.getScaledInstance(widthSize, heightSize, 0);
				photo1.setIcon(new ImageIcon(resize));
			}
			else if (i == 1)
			{
				help = selected.getImage();
				resize = help.getScaledInstance(widthSize, heightSize, 0);
				photo2.setIcon(new ImageIcon(resize));
			}
			else
			{
				help = selected.getImage();
				resize = help.getScaledInstance(widthSize, heightSize, 0);
				photo3.setIcon(new ImageIcon(resize));
			}	
			
			if (randomIndex < 10)
			{
				helpString.add(name1);
			}
			else if (randomIndex < 15)
			{
				helpString.add(name2);
			}
			else
			{
				helpString.add(name3);
			}
		}
		
		int randomIndex = r.nextInt(3);
		correct = helpImages.get(randomIndex);
		correct.setDescription(helpImages.get(randomIndex).getDescription());
		usedImages.add(correct);
		question.setText("Ποια εικόνα αντιστοιχεί "+helpString.get(randomIndex)+": "+correct.getDescription());
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
				player.setCoins(player.getCoins() + 1000);
				player.setXP(player.getXP() + 1000);
				PicsHerosFrame.this.setVisible(false);
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
	
	public class Labels implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			photo1.setBorder(null);
			photo2.setBorder(null);
			photo3.setBorder(null);
			
			if(e.getSource() == photo1)
			{
				photo1.setBorder(new LineBorder(Color.RED, 5));
				check.setDescription(helpImages.get(0).getDescription());
			}
			else if(e.getSource() == photo2)
			{
				photo2.setBorder(new LineBorder(Color.RED, 5));
				check.setDescription(helpImages.get(1).getDescription());
			}
			else if(e.getSource() == photo3)
			{
				photo3.setBorder(new LineBorder(Color.RED, 5));
				check.setDescription(helpImages.get(2).getDescription());
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
}
