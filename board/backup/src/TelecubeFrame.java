import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class TelecubeFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private String selected, question;
	private Timer timer;
	private TimerClass count;
	private BackgroundPanel back;
	private JPanel timePanel, charPanel, checkPanel, insertPanel;
	private int minutes, seconds, score;
	private JLabel timeLabel, insertLabel, scoreLabel, helpLabel;
	private Image background;
	private JButton pause, check;
	private boolean isRunning;
	private JTextField text;
	private ArrayList<String> words, usedWords;
	private Random r;
	private User player;
	ArrayList<AudiosPair> list = new ArrayList<AudiosPair>(new Audios().getTelecubeList()); 
	private Sound_Thread soundthread1, soundthread2; //Thread 1 gia mikrous hxous, pou diakoptei o enas ton allon
	 												//Thread 2 gia soundtrack
	
	public TelecubeFrame(User u) {
		soundthread1 = new Sound_Thread();
		soundthread2 = new Sound_Thread();
		soundthread2.PlayMusic(list.get(1).getSongName(), list.get(1).getRepeat());
		list = new ArrayList<AudiosPair>(new Audios().getTelecubeList()); 
		player = u;
		setJMenuBar(new JMenuFrame().getMenu());
		r = new Random(System.currentTimeMillis());
		words = new ArrayList<String>();
		usedWords = new ArrayList<String>();
		deserializing();
		minutes =  2;
		seconds = 0;
		count = new TimerClass(minutes, seconds);
		timer = new Timer(1000, count);
		timer.start();
		isRunning  = true;
		score = 0;
		
		try {
			background = ImageIO.read(new File("UIcons\\arcade_background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		back = new BackgroundPanel(background);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);
		setContentPane(back);
		
		charPanel = new JPanel();
		back.add(charPanel, BorderLayout.CENTER);
		
		checkPanel = new JPanel();
		charPanel.setLayout(new BorderLayout(0, 0));
		getWord();
		helpLabel = new JLabel(selected);
		helpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		helpLabel.setForeground(Color.WHITE);
		helpLabel.setFont(new Font("Sylfaen", Font.BOLD, 40));
		charPanel.add(helpLabel);
		GridBagLayout gbl_checkPanel = new GridBagLayout();
		checkPanel.setLayout(gbl_checkPanel);
		back.add(checkPanel, BorderLayout.EAST);
		check = new JButton();
		check.setFont(new Font("Sylfaen", Font.BOLD, 20));
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(text.getText().toUpperCase().equals(question))
				{
					soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat());   //Sound click
					score++;
					scoreLabel.setText("\u03A3\u03BA\u03BF\u03C1: "+score);
				}
				else
					soundthread1.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat());   //Sound wrong
				
				text.setText("");
				getWord();
				helpLabel.setText(selected);
			}
		});
		scoreLabel = new JLabel("\u03A3\u03BA\u03BF\u03C1: "+score);
		scoreLabel.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_scoreLabel = new GridBagConstraints();
		gbc_scoreLabel.insets = new Insets(0, 0, 5, 5);
		gbc_scoreLabel.gridx = 0;
		gbc_scoreLabel.gridy = 0;
		checkPanel.add(scoreLabel, gbc_scoreLabel);
		check.setText("OK");
		GridBagConstraints gbc_check = new GridBagConstraints();
		gbc_check.insets = new Insets(0, 0, 0, 5);
		gbc_check.gridx = 0;
		gbc_check.gridy = 1;
		checkPanel.add(check, gbc_check);
		
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
					check.setEnabled(false);
					text.setEnabled(false);
				}
				else
				{
					isRunning = true;
					timer.start();
					check.setEnabled(true);
					text.setEnabled(true);
				}
			}
		});
		timePanel.add(pause);
		back.add(timePanel, BorderLayout.NORTH);
		
		insertPanel = new JPanel();
		insertLabel = new JLabel();
		insertLabel.setFont(new Font("Sylfaen", Font.BOLD, 20));
		insertLabel.setText("\u03A0\u03BF\u03B9\u03B1 \u03B5\u03AF\u03BD\u03B1\u03B9 \u03B7 \u03BB\u03AD\u03BE\u03B7;");
		text = new JTextField();
		text.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		insertPanel.add(insertLabel);
		text.setBounds(23, 183, 116, 33);
		text.setColumns(10);
		insertPanel.add(text);
		back.add(insertPanel, BorderLayout.SOUTH);
	}
	
	public void getWord(){
		int randomIndex = r.nextInt(words.size());
		question = words.get(randomIndex);
	
		if (usedWords.size() == words.size())
		{
			usedWords = new ArrayList<String>();
		}
	
		while (usedWords.contains(question)){
			randomIndex = r.nextInt(words.size());
			question = words.get(randomIndex);
		}
		usedWords.add(question);
	
		selected = StringTokenizer(question);
	}
	
	public String StringTokenizer(String str) {
		char[] array = str.toCharArray();		
		for(int i = 0; i < 10; i++)
		{
			Random char1 = new Random();
			Random char2 = new Random();
			
			int randomInt1 = char1.nextInt(array.length);
			int randomInt2 = char2.nextInt(array.length);
			
			char temp = array[randomInt1];
			array[randomInt1] = array[randomInt2];
			array[randomInt2] = temp;
		}
		String result = new String(array);
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public void deserializing() {
		try {
			FileInputStream fileIn = new FileInputStream("Words.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			words = (ArrayList<String>) in.readObject();
			in.close();
			fileIn.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
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
				soundthread2.StopMusic();
				timer.stop();
				Toolkit.getDefaultToolkit().beep();
				player.setCoins(player.getCoins() + 1000);
				player.setXP(player.getXP() + 100);
				player.increaseSkillPoints(player.getXP(), player.getSkillpoints());
				TelecubeFrame.this.setVisible(false);
				soundthread2.StopMusic();
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
