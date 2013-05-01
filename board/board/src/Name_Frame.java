import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
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
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class Name_Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel helpPanel, quitPanel;
	private Pick_A_Hero hero;
	private User user;
	private Start_Frame start;
	private Image background;
	private BackgroundPanel back;
	private JLabel title, label, player1, player2;
	private JButton quit, piso, play;
	private Clip clip;
	private AudioInputStream audio;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JTextField name1, name2;
	
	private ArrayList<User> players;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Name_Frame() {
		//*** MenuBar ***//
				setJMenuBar(new JMenuFrame().getMenu()); // Getting the Menu from the JMenuFrame
		
		try {
			background = ImageIO.read(new File("start.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		back = new BackgroundPanel(background);
		back.setTransparentAdd(true);
		setContentPane(back);
		back.setLayout(new BorderLayout(5, 5));
		
		try{
			audio = AudioSystem.getAudioInputStream(new File("battle_theme.wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//
		title = new JLabel("\u03A1\u03C5\u03B8\u03BC\u03AF\u03C3\u03B5\u03B9\u03C2 \u03C0\u03B1\u03B9\u03C7\u03BD\u03B9\u03B4\u03B9\u03BF\u03CD");
		title.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		back.add(title, BorderLayout.NORTH);
		
		//
		helpPanel = new JPanel();
		back.add(helpPanel, BorderLayout.CENTER);
		GridBagLayout gbl_helpPanel = new GridBagLayout();
		gbl_helpPanel.columnWidths = new int[] {250};
		gbl_helpPanel.rowHeights = new int[] {50, 50, 50, 50};
		helpPanel.setLayout(gbl_helpPanel);
		
		label = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03C0\u03B1\u03B9\u03C7\u03C4\u03CE\u03BD");
		label.setForeground(Color.ORANGE);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		helpPanel.add(label, gbc_label);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem().equals("2"))
				{
					player2.setVisible(true);
					name2.setVisible(true);
					play.setEnabled(false);
				}
				else
				{
					player2.setVisible(false);
					name2.setVisible(false);
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
		
		player1 = new JLabel("\u03A0\u03B1\u03AF\u03BA\u03C4\u03B7\u03C2 1");
		player1.setForeground(Color.ORANGE);
		player1.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_player1 = new GridBagConstraints();
		gbc_player1.insets = new Insets(0, 0, 5, 0);
		gbc_player1.gridx = 0;
		gbc_player1.gridy = 1;
		helpPanel.add(player1, gbc_player1);
		
		name1 = new JTextField();
		name1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_name1 = new GridBagConstraints();
		gbc_name1.insets = new Insets(0, 0, 5, 0);
		gbc_name1.fill = GridBagConstraints.HORIZONTAL;
		gbc_name1.gridx = 1;
		gbc_name1.gridy = 1;
		helpPanel.add(name1, gbc_name1);
		name1.setColumns(10);
		
		player2 = new JLabel("\u03A0\u03B1\u03AF\u03BA\u03C4\u03B7\u03C2 2");
		player2.setForeground(Color.ORANGE);
		player2.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_player2 = new GridBagConstraints();
		gbc_player2.insets = new Insets(0, 0, 5, 0);
		gbc_player2.gridx = 0;
		gbc_player2.gridy = 2;
		helpPanel.add(player2, gbc_player2);
		player2.setVisible(false);
		
		name2 = new JTextField();
		name2.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_name2 = new GridBagConstraints();
		gbc_name2.insets = new Insets(0, 0, 5, 0);
		gbc_name2.fill = GridBagConstraints.HORIZONTAL;
		gbc_name2.gridx = 1;
		gbc_name2.gridy = 2;
		helpPanel.add(name2, gbc_name2);
		name2.setColumns(10);
		name2.setVisible(false);
		
		players=new ArrayList<User>();
		//dhmiourgia listas gia paixtes
		
		play = new JButton("\u03A0\u03B1\u03AF\u03BE\u03B5");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clip.stop();
				if ((comboBox.getSelectedItem()).equals("1")){
					user = new User(name1.getText());   //User has username, NOT HERONAME
					players.add(user);
				
					
				}
				else{
					User user1=new User(name1.getText());
					User user2=new User(name2.getText());
					players.add(user1);
					players.add(user2);
				}
				hero = new Pick_A_Hero(players);
				hero.setVisible(true);
				Name_Frame.this.setVisible(false);
			}
		});
		play.setEnabled(false);
		play.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_play = new GridBagConstraints();
		gbc_play.gridx = 0;
		gbc_play.gridy = 3;
		helpPanel.add(play, gbc_play);
		FieldListener fieldListener = new FieldListener(play);
		fieldListener.registerDoc(name1.getDocument());
		
		//
		quitPanel = new JPanel();
		quit = new JButton("\u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		quit.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		quitPanel.setLayout(new BorderLayout(0, 0));
		
		piso = new JButton("\u03A0\u03AF\u03C3\u03C9");
		piso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip.stop();
				Name_Frame.this.setVisible(false);
				start = new Start_Frame();
				start.setVisible(true);
			}
		});
		piso.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		quitPanel.add(piso, BorderLayout.WEST);
		quitPanel.add(quit, BorderLayout.EAST);
		back.add(quitPanel, BorderLayout.SOUTH);
	}
}

class FieldListener implements DocumentListener {
	   private List<Document> docs = new ArrayList<Document>();
	   private JButton button;

	   public FieldListener(JButton button) {
	      this.button = button;
	   }

	   public void registerDoc(Document doc) {
	      docs.add(doc);
	      doc.addDocumentListener(this);
	   }

	   @Override
	   public void changedUpdate(DocumentEvent arg0) {
	      update();
	   }

	   @Override
	   public void insertUpdate(DocumentEvent arg0) {
	      update();
	   }

	   @Override
	   public void removeUpdate(DocumentEvent arg0) {
	      update();
	   }

	   private void update() {
	      for (Document doc : docs) {
	         if (doc.getLength() <= 3) {
	            button.setEnabled(false);
	            return;
	         }
	      }
	      button.setEnabled(true);
	   }
}
