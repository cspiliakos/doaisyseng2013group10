import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFrame extends JFrame {
	//the main frame the admin uses to make changes in the puzzles
	private static final long serialVersionUID = 1L;
	private Image background;
	private BackgroundPanel back;
	private JPanel helpPanel, second, quitPanel;
	private JButton login, addWord, addQuestion, piso;
	private JLabel title, username, password, help1, help2;
	private JTextField userField;
	private JPasswordField passField;
	private int helpHeight, heightSize;
	private double frameHeight;
	
	public AdminFrame(final Clip clip){
		setJMenuBar(new JMenuFrame().getMenu());
		//menu
		try {
			background = ImageIO.read(new File("adminback.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);
		back = new BackgroundPanel(background);
		setContentPane(back);
		back.setLayout(new BorderLayout(5, 5));
		//managing the frame
		

		
		////////////////////////
		title = new JLabel("\u0395\u03B9\u03C3\u03AE\u03B3\u03B1\u03B3\u03B5 \u03C4\u03B1 \u03C3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u03C3\u03BF\u03C5");
		title.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		title.setForeground(Color.BLACK);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		back.add(title, BorderLayout.NORTH);
		
		//////////////////
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameHeight = screenSize.getHeight();
		helpHeight = (int)frameHeight;
		heightSize = helpHeight / 4;
		
		helpPanel = new JPanel();
		back.add(helpPanel, BorderLayout.CENTER);
		GridBagLayout gbl_helpPanel = new GridBagLayout();
		gbl_helpPanel.rowHeights = new int[] {heightSize, 0, 0, 0};
		helpPanel.setLayout(gbl_helpPanel);
		
		//making the area used to enter the username and password
		username = new JLabel();
		username.setForeground(Color.BLACK);
		username.setText("\u038C\u03BD\u03BF\u03BC\u03B1 \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7");
		username.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_username = new GridBagConstraints();
		gbc_username.fill = GridBagConstraints.BOTH;
		gbc_username.insets = new Insets(0, 0, 5, 5);
		gbc_username.gridx = 0;
		gbc_username.gridy = 1;
		helpPanel.add(username, gbc_username);
		
		userField = new JTextField();
		userField.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_userField = new GridBagConstraints();
		gbc_userField.fill = GridBagConstraints.BOTH;
		gbc_userField.insets = new Insets(0, 0, 5, 5);
		gbc_userField.gridx = 1;
		gbc_userField.gridy = 1;
		helpPanel.add(userField, gbc_userField);
		userField.setColumns(10);
		
		help1 = new JLabel("*");
		//shows that this field is necessary 
		help1.setForeground(Color.RED);
		help1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_help1 = new GridBagConstraints();
		gbc_help1.fill = GridBagConstraints.BOTH;
		gbc_help1.insets = new Insets(0, 0, 5, 0);
		gbc_help1.gridx = 2;
		gbc_help1.gridy = 1;
		helpPanel.add(help1, gbc_help1);
		
		password = new JLabel();
		password.setForeground(Color.BLACK);
		password.setText("\u039A\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2 \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7");
		password.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.fill = GridBagConstraints.BOTH;
		gbc_password.insets = new Insets(0, 0, 0, 5);
		gbc_password.gridx = 0;
		gbc_password.gridy = 2;
		helpPanel.add(password, gbc_password);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_passField = new GridBagConstraints();
		gbc_passField.fill = GridBagConstraints.BOTH;
		gbc_passField.insets = new Insets(0, 0, 0, 5);
		gbc_passField.gridx = 1;
		gbc_passField.gridy = 2;
		helpPanel.add(passField, gbc_passField);
		passField.setColumns(10);
		
		help2 = new JLabel("*");
		//shows this field is necessary
		help2.setForeground(Color.RED);
		help2.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_help2 = new GridBagConstraints();
		gbc_help2.fill = GridBagConstraints.BOTH;
		gbc_help2.insets = new Insets(0, 0, 0, 5);
		gbc_help2.gridx = 2;
		gbc_help2.gridy = 2;
		helpPanel.add(help2, gbc_help2);
		
		login = new JButton();
		login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				if (userField.getText().equals("admin") && passField.getText().equals("admin"))
				{
					//if the username and password entered before are correct the previous frame components
					//become invisible and the function buttons take their place
					title.setText("Διάλεξε λειτουργία");
					
					second = new JPanel();
					back.remove(helpPanel);
					back.add(second, BorderLayout.CENTER);
					GridBagLayout gbl_helpPanel = new GridBagLayout();
					second.setLayout(gbl_helpPanel);
					
					addWord = new JButton("Λίστα αναγραμματισμού");
					addWord.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							AdminFrame.this.setVisible(false);
							new AddQ(clip);
						}
					});
					//button in order to add the new word
					addWord.setFont(new Font("Sylfaen", Font.PLAIN, 20));
					GridBagConstraints gbc_username = new GridBagConstraints();
					gbc_username.insets = new Insets(0, 0, 5, 5);
					gbc_username.gridx = 0;
					gbc_username.gridy = 0;
					second.add(addWord, gbc_username);
					
					addQuestion = new JButton("Λίστα ερωτήσεων");
					addQuestion.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							AdminFrame.this.setVisible(false);
							new AddQuestion(clip);
						}
					});
					//button in order to add the new question
					addQuestion.setFont(new Font("Sylfaen", Font.PLAIN, 20));
					GridBagConstraints gbc_userField = new GridBagConstraints();
					gbc_userField.insets = new Insets(0, 0, 5, 5);
					gbc_userField.gridx = 0;
					gbc_userField.gridy = 1;
					second.add(addQuestion, gbc_userField);
				}
				else
				{
					//what happens if the username and password are wrong
					JOptionPane.showMessageDialog(null, "Το όνομα χρήστη ή ο κωδικός που εισήγαγες είναι λάθος.", "Σφάλμα σύνδεσης", JOptionPane.ERROR_MESSAGE);
					userField.setText("");
					passField.setText("");
				}
			}
		});
		login.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		login.setText("\u03A3\u03CD\u03BD\u03B4\u03B5\u03C3\u03B7");
		GridBagConstraints gbc_login = new GridBagConstraints();
		gbc_login.gridx = 1;
		gbc_login.gridy = 3;
		helpPanel.add(login, gbc_login);
		
		/////////////////////
		quitPanel = new JPanel();
		quitPanel.setLayout(new BorderLayout(0, 0));
		
		piso = new JButton("\u03A0\u03AF\u03C3\u03C9");
		piso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminFrame.this.setVisible(false);
				//setting the action for returning to the previous frame
				new Start_Frame(clip);
			}
		});
		piso.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		quitPanel.add(piso, BorderLayout.WEST);
		back.add(quitPanel, BorderLayout.SOUTH);
	}
}
	