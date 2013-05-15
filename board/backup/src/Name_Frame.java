import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Toolkit;

public class Name_Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel helpPanel, quitPanel;
	private Image background;
	private BackgroundPanel back;
	private JLabel title, label, player1, player2, help1, help2;
	private JButton piso, play;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JTextField name1, name2;
	private ArrayList<User> players;
	private Image resize;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Name_Frame(final Clip clip) {
		setJMenuBar(new JMenuFrame().getMenu());
		
		try {
			background = ImageIO.read(new File("Start\\loginbackground.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		back = new BackgroundPanel(background);
		setContentPane(back);
		back.setLayout(new BorderLayout(5, 5));
	
		//
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double frameWidth = screenSize.getWidth();
		double frameHeight = screenSize.getHeight();
		int helpWidth = (int)frameWidth;
		int helpHeight = (int)frameHeight;
		int widthSize = helpWidth / 7;
		int heightSize = helpHeight / 3;
		
		
		
		
		
		title = new JLabel("\u03A1\u03C5\u03B8\u03BC\u03AF\u03C3\u03B5\u03B9\u03C2 \u03C0\u03B1\u03B9\u03C7\u03BD\u03B9\u03B4\u03B9\u03BF\u03CD");
		
		
		title.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		back.add(title, BorderLayout.NORTH);
	//	title.setText("\u03A1\u03C5\u03B8\u03BC\u03AF\u03C3\u03B5\u03B9\u03C2 \u03C0\u03B1\u03B9\u03C7\u03BD\u03B9\u03B4\u03B9\u03BF\u03CD");
		
		
		//title.setIcon(new ImageIcon(resize));
		//managing frame
		
		//
		helpPanel = new JPanel();
		back.add(helpPanel, BorderLayout.CENTER);
		GridBagLayout gbl_helpPanel = new GridBagLayout();
		gbl_helpPanel.rowHeights = new int[] {50, 50, 50};
		helpPanel.setLayout(gbl_helpPanel);
		
		label = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03C0\u03B1\u03B9\u03C7\u03C4\u03CE\u03BD");
		label.setForeground(Color.ORANGE);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		helpPanel.add(label, gbc_label);
		
		//combo box for single or mutliplayer mode
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem().equals("2"))
				{
					player2.setVisible(true);
					name2.setVisible(true);
					help2.setVisible(true);
				}
				else
				{
					player2.setVisible(false);
					name2.setVisible(false);
					help2.setVisible(false);
				}
			}
		});
		comboBox.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		helpPanel.add(comboBox, gbc_comboBox);
		
		// player 1 components
		player1 = new JLabel("\u03A0\u03B1\u03AF\u03BA\u03C4\u03B7\u03C2 1");
		player1.setForeground(Color.ORANGE);
		player1.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_player1 = new GridBagConstraints();
		gbc_player1.insets = new Insets(0, 0, 5, 5);
		gbc_player1.gridx = 0;
		gbc_player1.gridy = 1;
		helpPanel.add(player1, gbc_player1);
		
		name1 = new JTextField();
		name1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_name1 = new GridBagConstraints();
		gbc_name1.insets = new Insets(0, 0, 5, 0);
		gbc_name1.gridx = 1;
		gbc_name1.gridy = 1;
		helpPanel.add(name1, gbc_name1);
		name1.setColumns(10);
		
		help1 = new JLabel("*");
		help1.setForeground(Color.RED);
		help1.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_help1 = new GridBagConstraints();
		gbc_help1.insets = new Insets(0, 0, 5, 0);
		gbc_help1.gridx = 2;
		gbc_help1.gridy = 1;
		helpPanel.add(help1, gbc_help1);
		
		//player2 components
		player2 = new JLabel("\u03A0\u03B1\u03AF\u03BA\u03C4\u03B7\u03C2 2");
		player2.setForeground(Color.ORANGE);
		player2.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_player2 = new GridBagConstraints();
		gbc_player2.insets = new Insets(0, 0, 5, 5);
		gbc_player2.gridx = 0;
		gbc_player2.gridy = 2;
		helpPanel.add(player2, gbc_player2);
		player2.setVisible(false);
		
		name2 = new JTextField();
		name2.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_name2 = new GridBagConstraints();
		gbc_name2.insets = new Insets(0, 0, 5, 0);
		gbc_name2.gridx = 1;
		gbc_name2.gridy = 2;
		helpPanel.add(name2, gbc_name2);
		name2.setColumns(10);
		name2.setVisible(false);
		
		help2 = new JLabel("*");
		help2.setForeground(Color.RED);
		help2.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_help2 = new GridBagConstraints();
		gbc_help2.insets = new Insets(0, 0, 0, 5);
		gbc_help2.gridx = 2;
		gbc_help2.gridy = 2;
		helpPanel.add(help2, gbc_help2);
		help2.setVisible(false);
		
		//check if name(s) has more than 4 chars
		//redirect to PickAHero frame for 1 or 2 players according to the selection
		play = new JButton("\u03A0\u03B1\u03AF\u03BE\u03B5");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((comboBox.getSelectedItem()).equals("1")){
					if (name1.getText().length() >= 4) 
					{
						players = new ArrayList<User>();
						User user = new User(name1.getText());
						players.add(user);	
						
						new Pick_A_Hero(players, clip);
						Name_Frame.this.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Το όνομα του κάθε παίκτη πρέπει να περιλαμβάνει τουλάχιστον 4 χαρακτήρες", 
								"Προειδοποιηση", JOptionPane.WARNING_MESSAGE);
					}
				}
				else
				{
					if (name1.getText().length() >= 4 && name2.getText().length() >= 4) 
					{
						players = new ArrayList<User>();
						User user = new User(name1.getText());
						User user2 = new User(name2.getText());
						players.add(user);	
						players.add(user2);
						
						new Pick_A_Hero(players, clip);
						Name_Frame.this.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Το όνομα του κάθε παίκτη πρέπει να περιλαμβάνει τουλάχιστον 4 χαρακτήρες", 
								"Προειδοποιηση", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		play.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_play = new GridBagConstraints();
		gbc_play.insets = new Insets(0, 0, 5, 5);
		gbc_play.gridx = 0;
		gbc_play.gridy = 3;
		helpPanel.add(play, gbc_play);
		
		//
		quitPanel = new JPanel();
		quitPanel.setLayout(new BorderLayout(0, 0));
		
		piso = new JButton("\u03A0\u03AF\u03C3\u03C9");
		piso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Name_Frame.this.setVisible(false);
				new Start_Frame(clip);
			}
		});
		piso.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		quitPanel.add(piso, BorderLayout.WEST);
		back.add(quitPanel, BorderLayout.SOUTH);
	}
}
