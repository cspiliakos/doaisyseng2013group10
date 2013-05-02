import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
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
	private Question que;

	public TelecubeFrame() {
		//setJMenuBar(new JMenuFrame().getMenu());
		que = new Question();
		
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
			background = ImageIO.read(new File("arcade_background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		back = new BackgroundPanel(background);
		setContentPane(back);
		
		charPanel = new JPanel();
		back.add(charPanel, BorderLayout.CENTER);
		
		checkPanel = new JPanel();
		charPanel.setLayout(new BorderLayout(0, 0));
		helpLabel = new JLabel("");
		helpLabel.setForeground(Color.WHITE);
		helpLabel.setFont(new Font("Sylfaen", Font.BOLD, 40));
		charPanel.add(helpLabel);
		charPanel.add(que);
		GridBagLayout gbl_checkPanel = new GridBagLayout();
		gbl_checkPanel.columnWidths = new int[] {30};
		gbl_checkPanel.rowHeights = new int[] {30, 30};
		checkPanel.setLayout(gbl_checkPanel);
		back.add(checkPanel, BorderLayout.EAST);
		check = new JButton();
		check.setFont(new Font("Sylfaen", Font.BOLD, 20));
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String answer = text.getText();
				if(answer.equals(question))
				{
					score++;
					scoreLabel.setText("\u03A3\u03BA\u03BF\u03C1: "+score);
				}
				text.setText("");
				que.repaint();
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
		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isRunning)
				{
					isRunning = false;
					timer.stop();
					Toolkit.getDefaultToolkit().beep();
				}
				else
				{
					isRunning = true;
					timer.start();
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
		
		this.setVisible(true);
		this.setSize(700, 500);
	}
	
	@SuppressWarnings("serial")
	public class Question extends JComponent {
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Random r = new Random(System.currentTimeMillis());
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
			System.out.println(selected);
			helpLabel.setText(selected);
		}
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
		finally {
			System.out.println("De-Serialization Attempted...");		
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
}
