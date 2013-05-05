import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

public class QuizFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private Image background;
	private BackgroundPanel back;
	private JPanel timePanel, scorePanel, checkPanel, mainPanel;
	private JButton pause, check;
	private Timer timer;
	private TimerClass count;
	private JLabel timeLabel, scoreLabel, question;
	private int minutes, seconds, score;
	private boolean isRunning;
	private User player;
	private JRadioButton choice1, choice2, choice3, choice4;
	private ArrayList<Question> questions, usedQuestions; 
	private Random r;
	private Question selected;
	private ButtonGroup group;
	private String choose;
	
	public QuizFrame(User u) {
		setJMenuBar(new JMenuFrame().getMenu());
		r = new Random(System.currentTimeMillis());
		player = u;
		minutes =  2;
		seconds = 0;
		score = 0;
		count = new TimerClass(minutes, seconds);
		timer = new Timer(1000, count);
		timer.start();
		isRunning  = true;
		questions = new ArrayList<Question>();
		usedQuestions = new ArrayList<Question>();
		group = new ButtonGroup();
		group.clearSelection();
		deserializing();
		try {
			background = ImageIO.read(new File("UIcons\\arcade_background.jpg"));
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
		
		//////////////////
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
					choice1.setEnabled(false);
					choice2.setEnabled(false);
					choice3.setEnabled(false);
					choice4.setEnabled(false);
				}
				else
				{
					isRunning = true;
					timer.start();
					check.setEnabled(true);
					choice1.setEnabled(true);
					choice2.setEnabled(true);
					choice3.setEnabled(true);
					choice4.setEnabled(true);
				}
			}
		});
		timePanel.add(pause);
		back.add(timePanel, BorderLayout.NORTH);
		
		////////////////////////
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
		
		/////////////////////////////
		checkPanel = new JPanel();
		back.add(checkPanel, BorderLayout.SOUTH);
		
		check = new JButton();
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (choice1.isSelected()) 
				{
					choose = choice1.getText();
				}
				else if (choice2.isSelected()) 
				{
					choose = choice2.getText();
				}
				else if (choice3.isSelected()) 
				{
					choose = choice3.getText();
				}
				else if (choice4.isSelected())
				{
					choose = choice4.getText();
				}
				System.out.println(choose+"  "+selected.getCorrect());
				if (choose.equals(selected.getCorrect())) 
				{
					score++;
					scoreLabel.setText("\u03A3\u03BA\u03BF\u03C1: "+score);
				}
				
				getQuestion();
				question.setText(selected.getQuestion());
				choice1.setText(selected.getAnswer1());
				choice2.setText(selected.getAnswer2());
				choice3.setText(selected.getAnswer3());
				choice4.setText(selected.getAnswer4());
				group.clearSelection();
			}
		});
		check.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		check.setText("\u0388\u03BB\u03B5\u03B3\u03C7\u03BF\u03C2");
		checkPanel.add(check);
		
		///////////////////////////////
		mainPanel = new JPanel();
		back.add(mainPanel, BorderLayout.CENTER);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		mainPanel.setLayout(gbl_mainPanel);
		
		question = new JLabel();
		question.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_question = new GridBagConstraints();
		gbc_question.gridx = 0;
		gbc_question.gridy = 0;
		mainPanel.add(question, gbc_question);
		
		choice1 = new JRadioButton();
		choice1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_choice1 = new GridBagConstraints();
		gbc_question.gridx = 0;
		gbc_question.gridy = 1;
		mainPanel.add(choice1, gbc_choice1);
		group.add(choice1);
		
		choice2 = new JRadioButton();
		choice2.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_choice2 = new GridBagConstraints();
		gbc_question.gridx = 1;
		gbc_question.gridy = 1;
		mainPanel.add(choice2, gbc_choice2);
		group.add(choice2);
		
		choice3 = new JRadioButton();
		choice3.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_choice3 = new GridBagConstraints();
		gbc_question.gridx = 2;
		gbc_question.gridy = 1;
		mainPanel.add(choice3, gbc_choice3);
		group.add(choice3);
		
		choice4 = new JRadioButton();
		choice4.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_choice4 = new GridBagConstraints();
		gbc_question.gridx = 3;
		gbc_question.gridy = 1;
		mainPanel.add(choice4, gbc_choice4);
		group.add(choice4);
		
		getQuestion();
		question.setText(selected.getQuestion());
		choice1.setText(selected.getAnswer1());
		choice2.setText(selected.getAnswer2());
		choice3.setText(selected.getAnswer3());
		choice4.setText(selected.getAnswer4());
	}
	
	public void getQuestion(){
		int randomIndex = r.nextInt(questions.size());
		selected = questions.get(randomIndex);
	
		if (usedQuestions.size() == questions.size())
		{
			usedQuestions = new ArrayList<Question>();
		}
	
		while (usedQuestions.contains(selected)){
			randomIndex = r.nextInt(questions.size());
			selected = questions.get(randomIndex);
		}
		usedQuestions.add(selected);
	}
	
	@SuppressWarnings("unchecked")
	public void deserializing() {
		try {
			FileInputStream fileIn = new FileInputStream("QuestionsDatabase.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			questions = (ArrayList<Question>) in.readObject();
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
				player.setCoins(player.getCoins() + 1000);
				player.setXP(player.getXP() + 100);
				QuizFrame.this.setVisible(false);
				JOptionPane.showMessageDialog(null, "\u03A4\u03BF \u03C4\u03B5\u03BB\u03B9\u03BA\u03CC \u03C3\u03BA\u03BF\u03C1 \u03B5\u03AF\u03BD\u03B1\u03B9: "+score);
			}
		}
	}
}
