import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.Dimension;

public class Pick_A_Hero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel helpPanel, quitPanel, player1Panel, player2Panel;
	private Image background, resize, help;
	private ImageIcon hero, image;
	private BackgroundPanel back;
	private JLabel title, pl1, pl2, pl3, pl4, pl5, pl6, lab1, lab2, lab3, lab4, lab5, lab6, helpLabel,
	p1, p2, p3, p4, name1lbl, health1lbl, damage1lbl, defence1lbl, name2lbl, health2lbl, damage2lbl, defence2lbl, p5, p6, p7, p8;
	private JButton piso, play;
	private Clip clip;
	private AudioInputStream audio;
	private Pick_A_Hero_Listener PHL;
	private int helpWidth, helpHeight, widthSize, heightSize;
	private double frameWidth, frameHeight;
	private ArrayList<User> players;
	private CharsOpponents char1, char2, char3, char4, char5, char6;

	public Pick_A_Hero(ArrayList<User> p) {
		setJMenuBar(new JMenuFrame().getMenu());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);
		
		players = new ArrayList<User>();
		players = p;
		
		PHL = new Pick_A_Hero_Listener();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameWidth = screenSize.getWidth();
		frameHeight = screenSize.getHeight();
		helpWidth = (int)frameWidth;
		helpHeight = (int)frameHeight;
		widthSize = helpWidth / 7;
		heightSize = helpHeight / 3;

		try {
			background = ImageIO.read(new File("Start\\start.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		back = new BackgroundPanel(background);
		back.setTransparentAdd(true);
		setContentPane(back);
		back.setLayout(new BorderLayout(5, 5));

		try{
			audio = AudioSystem.getAudioInputStream(new File("Sounds\\battle_theme.wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		//
		title = new JLabel("\u0394\u03B9\u03AC\u03BB\u03B5\u03BE\u03B5 \u03AE\u03C1\u03C9\u03B1");
		title.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		back.add(title, BorderLayout.NORTH);

		//panel gia emfanisi stat tou paixth 1
		player1Panel = new JPanel();
		player1Panel.setBorder(new EmptyBorder(100, 0, 100, 0));
		back.add(player1Panel,BorderLayout.WEST);
		GridBagLayout gbl_player1Panel = new GridBagLayout();
		gbl_player1Panel.columnWidths = new int[]{30, 30};
		gbl_player1Panel.rowHeights = new int[]{80, 80, 80, 80};
		player1Panel.setLayout(gbl_player1Panel);
		player1Panel.setVisible(false);
		
		name1lbl = new JLabel("\u0389\u03C1\u03C9\u03B1\u03C2");
		name1lbl.setFont(new Font ("Arial", Font.BOLD,20));
		name1lbl.setForeground(Color.RED);
		GridBagConstraints gbc_name1lbl = new GridBagConstraints();
		gbc_name1lbl.fill = GridBagConstraints.BOTH;
		gbc_name1lbl.insets = new Insets(0, 0, 0, 5);
		gbc_name1lbl.gridx = 0;
		gbc_name1lbl.gridy = 0;
		player1Panel.add(name1lbl, gbc_name1lbl);
		
		p1 = new JLabel();
		p1.setFont(new Font ("Arial", Font.BOLD,20));
		p1.setForeground(Color.YELLOW);
		GridBagConstraints gbc_p1 = new GridBagConstraints();
		gbc_p1.fill = GridBagConstraints.BOTH;
		gbc_p1.gridx = 1;
		gbc_p1.gridy = 0;
		player1Panel.add(p1, gbc_p1);
		
		damage1lbl = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C3\u03B7");
		damage1lbl.setFont(new Font ("Arial", Font.BOLD,20));
		damage1lbl.setForeground(Color.RED);
		GridBagConstraints gbc_damage1lbl = new GridBagConstraints();
		gbc_damage1lbl.fill = GridBagConstraints.BOTH;
		gbc_damage1lbl.insets = new Insets(0, 0, 5, 5);
		gbc_damage1lbl.gridx = 0;
		gbc_damage1lbl.gridy = 1;
		player1Panel.add(damage1lbl, gbc_damage1lbl);
		
		p3 = new JLabel();
		p3.setFont(new Font ("Arial", Font.BOLD,20));
		p3.setForeground(Color.YELLOW);
		GridBagConstraints gbc_p3 = new GridBagConstraints();
		gbc_p3.fill = GridBagConstraints.BOTH;
		gbc_p3.insets = new Insets(0, 0, 5, 0);
		gbc_p3.gridx = 1;
		gbc_p3.gridy = 1;
		player1Panel.add(p3, gbc_p3);
		
		defence1lbl = new JLabel("\u0386\u03BC\u03C5\u03BD\u03B1");
		defence1lbl.setFont(new Font ("Arial", Font.BOLD,20));
		defence1lbl.setForeground(Color.RED);
		GridBagConstraints gbc_defence1lbl = new GridBagConstraints();
		gbc_defence1lbl.fill = GridBagConstraints.BOTH;
		gbc_defence1lbl.insets = new Insets(0, 0, 5, 5);
		gbc_defence1lbl.gridx = 0;
		gbc_defence1lbl.gridy = 2;
		player1Panel.add(defence1lbl, gbc_defence1lbl);
		
		p4 = new JLabel();
		p4.setFont(new Font ("Arial", Font.BOLD,20));
		p4.setForeground(Color.YELLOW);
		GridBagConstraints gbc_p4 = new GridBagConstraints();
		gbc_p4.fill = GridBagConstraints.BOTH;
		gbc_p4.insets = new Insets(0, 0, 5, 0);
		gbc_p4.gridx = 1;
		gbc_p4.gridy = 2;
		player1Panel.add(p4, gbc_p4);
				
		health1lbl=new JLabel("\u0396\u03C9\u03AE");
		health1lbl.setFont(new Font ("Arial", Font.BOLD,20));
		health1lbl.setForeground(Color.RED);
		GridBagConstraints gbc_health1lbl = new GridBagConstraints();
		gbc_health1lbl.fill = GridBagConstraints.BOTH;
		gbc_health1lbl.insets = new Insets(0, 0, 5, 5);
		gbc_health1lbl.gridx = 0;
		gbc_health1lbl.gridy = 3;
		player1Panel.add(health1lbl, gbc_health1lbl);
				
		p2 = new JLabel();
		p2.setFont(new Font ("Arial", Font.BOLD,20));
		p2.setForeground(Color.YELLOW);
		GridBagConstraints gbc_p2 = new GridBagConstraints();
		gbc_p2.fill = GridBagConstraints.BOTH;
		gbc_p2.insets = new Insets(0, 0, 5, 0);
		gbc_p2.gridx = 1;
		gbc_p2.gridy = 3;
		player1Panel.add(p2, gbc_p2);

		//panel gia emfanisi stat tou paixth 2
		player2Panel = new JPanel();
		player2Panel.setBorder(new EmptyBorder(100, 0, 100, 0));
		back.add(player2Panel,BorderLayout.EAST);
		GridBagLayout gbl_player2Panel = new GridBagLayout();
		gbl_player2Panel.columnWidths = new int[]{30, 30};
		gbl_player2Panel.rowHeights = new int[]{80, 80, 80, 80};
		player2Panel.setLayout(gbl_player2Panel);
		player2Panel.setVisible(false);
		
		name2lbl = new JLabel("\u0389\u03C1\u03C9\u03B1\u03C2");
		
		name2lbl.setFont(new Font ("Arial", Font.BOLD,20));
		name2lbl.setForeground(Color.RED);
		GridBagConstraints gbc_name2lbl = new GridBagConstraints();
		gbc_name2lbl.fill = GridBagConstraints.BOTH;
		gbc_name2lbl.insets = new Insets(0, 0, 0, 5);
		gbc_name2lbl.gridx = 0;
		gbc_name2lbl.gridy = 0;
		player2Panel.add(name2lbl, gbc_name2lbl);
		
		p5 = new JLabel();
		p5.setFont(new Font ("Arial", Font.BOLD,20));
		p5.setForeground(Color.YELLOW);
		GridBagConstraints gbc_p5 = new GridBagConstraints();
		gbc_p5.fill = GridBagConstraints.BOTH;
		gbc_p5.gridx = 1;
		gbc_p5.gridy = 0;
		player2Panel.add(p5, gbc_p5);
		
		damage2lbl = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C3\u03B7");
		damage2lbl.setFont(new Font ("Arial", Font.BOLD,20));
		damage2lbl.setForeground(Color.RED);
		GridBagConstraints gbc_damage2lbl = new GridBagConstraints();
		gbc_damage2lbl.fill = GridBagConstraints.BOTH;
		gbc_damage2lbl.insets = new Insets(0, 0, 5, 5);
		gbc_damage2lbl.gridx = 0;
		gbc_damage2lbl.gridy = 1;
		player2Panel.add(damage2lbl, gbc_damage2lbl);
		
		p7 = new JLabel();
		p7.setFont(new Font ("Arial", Font.BOLD,20));
		p7.setForeground(Color.YELLOW);
		GridBagConstraints gbc_p7 = new GridBagConstraints();
		gbc_p7.fill = GridBagConstraints.BOTH;
		gbc_p7.insets = new Insets(0, 0, 5, 0);
		gbc_p7.gridx = 1;
		gbc_p7.gridy = 1;
		player2Panel.add(p7, gbc_p7);
		
		defence2lbl = new JLabel("\u0386\u03BC\u03C5\u03BD\u03B1");
		defence2lbl.setFont(new Font ("Arial", Font.BOLD,20));
		defence2lbl.setForeground(Color.RED);
		GridBagConstraints gbc_defence2lbl = new GridBagConstraints();
		gbc_defence2lbl.fill = GridBagConstraints.BOTH;
		gbc_defence2lbl.insets = new Insets(0, 0, 5, 5);
		gbc_defence2lbl.gridx = 0;
		gbc_defence2lbl.gridy = 2;
		player2Panel.add(defence2lbl, gbc_defence2lbl);
		
		p8 = new JLabel();
		p8.setFont(new Font ("Arial", Font.BOLD,20));
		p8.setForeground(Color.YELLOW);
		GridBagConstraints gbc_p8 = new GridBagConstraints();
		gbc_p8.fill = GridBagConstraints.BOTH;
		gbc_p8.insets = new Insets(0, 0, 5, 0);
		gbc_p8.gridx = 1;
		gbc_p8.gridy = 2;
		player2Panel.add(p8, gbc_p8);
		
		health2lbl = new JLabel("\u0396\u03C9\u03AE");
		health2lbl.setFont(new Font ("Arial", Font.BOLD,20));
		health2lbl.setForeground(Color.RED);
		GridBagConstraints gbc_health2lbl = new GridBagConstraints();
		gbc_health2lbl.fill = GridBagConstraints.BOTH;
		gbc_health2lbl.insets = new Insets(0, 0, 5, 5);
		gbc_health2lbl.gridx = 0;
		gbc_health2lbl.gridy = 3;
		player2Panel.add(health2lbl, gbc_health2lbl);
		
		p6 = new JLabel();
		p6.setFont(new Font ("Arial", Font.BOLD,20));
		p6.setForeground(Color.YELLOW);
		GridBagConstraints gbc_p6 = new GridBagConstraints();
		gbc_p6.fill = GridBagConstraints.BOTH;
		gbc_p6.insets = new Insets(0, 0, 5, 0);
		gbc_p6.gridx = 1;
		gbc_p6.gridy = 3;
		player2Panel.add(p6, gbc_p6);
		
		//
		helpPanel = new JPanel();
		helpPanel.setBorder(new EmptyBorder(100, 0, helpHeight / 5, 0));
		back.add(helpPanel, BorderLayout.CENTER);
		GridBagLayout gbl_helpPanel = new GridBagLayout();
		gbl_helpPanel.columnWidths = new int[]{10, 10, 10};
		gbl_helpPanel.rowHeights = new int[]{50, 4, 4, 4, 4};
		helpPanel.setLayout(gbl_helpPanel);

		lab1 = new JLabel("\u0386\u03C1\u03B7\u03C2");
		lab1.setHorizontalAlignment(SwingConstants.CENTER);
		lab1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_lab1 = new GridBagConstraints();
		gbc_lab1.fill = GridBagConstraints.BOTH;
		gbc_lab1.insets = new Insets(0, 0, 5, 5);
		gbc_lab1.gridx = 1;
		gbc_lab1.gridy = 1;
		helpPanel.add(lab1, gbc_lab1);

		lab2 = new JLabel("\u039A\u03C1\u03CC\u03BD\u03BF\u03C2");
		lab2.setHorizontalAlignment(SwingConstants.CENTER);
		lab2.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_lab2 = new GridBagConstraints();
		gbc_lab2.fill = GridBagConstraints.BOTH;
		gbc_lab2.insets = new Insets(0, 0, 5, 5);
		gbc_lab2.gridx = 2;
		gbc_lab2.gridy = 1;
		helpPanel.add(lab2, gbc_lab2);
		lab2.setLabelFor(pl2);

		lab3 = new JLabel("\u0386\u03B4\u03B7\u03C2");
		lab3.setHorizontalAlignment(SwingConstants.CENTER);
		lab3.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_lab3 = new GridBagConstraints();
		gbc_lab3.insets = new Insets(0, 0, 5, 0);
		gbc_lab3.gridx = 3;
		gbc_lab3.gridy = 1;
		helpPanel.add(lab3, gbc_lab3);
		lab3.setLabelFor(pl3);

		pl1 = new JLabel("");
		pl1.setSize(new Dimension(5, 5));
		pl1.setIconTextGap(0);
		hero = new ImageIcon("Pick_Hero\\Ares.jpg");
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		pl1.setIcon(new ImageIcon(resize));
		pl1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_pl1 = new GridBagConstraints();
		gbc_pl1.insets = new Insets(0, 0, 5, 5);
		gbc_pl1.gridx = 1;
		gbc_pl1.gridy = 2;
		helpPanel.add(pl1, gbc_pl1);
		pl1.addMouseListener(PHL);

		char1 = new CharsOpponents("Άρης", 10, 20, 30, hero);

		pl2 = new JLabel("");
		hero = new ImageIcon("Pick_Hero\\Cronus.jpg");
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		pl2.setIcon(new ImageIcon(resize));
		pl2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_pl2 = new GridBagConstraints();
		gbc_pl2.fill = GridBagConstraints.BOTH;
		gbc_pl2.insets = new Insets(0, 0, 5, 5);
		gbc_pl2.gridx = 2;
		gbc_pl2.gridy = 2;
		helpPanel.add(pl2, gbc_pl2);
		pl2.addMouseListener(PHL);

		char2 = new CharsOpponents("Κρόνος", 20, 10, 30, hero);

		pl3 = new JLabel("");
		hero = new ImageIcon("Pick_Hero\\Hades.jpg");
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		pl3.setIcon(new ImageIcon(resize));
		pl3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_pl3 = new GridBagConstraints();
		gbc_pl3.insets = new Insets(0, 0, 5, 0);
		gbc_pl3.gridx = 3;
		gbc_pl3.gridy = 2;
		helpPanel.add(pl3, gbc_pl3);
		pl3.addMouseListener(PHL);

		char3 = new CharsOpponents("Άδης", 20, 30, 10, hero);

		lab4 = new JLabel("\u03A0\u03BF\u03C3\u03B5\u03B9\u03B4\u03CE\u03BD\u03B1\u03C2");
		lab4.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lab4.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lab4 = new GridBagConstraints();
		gbc_lab4.fill = GridBagConstraints.BOTH;
		gbc_lab4.insets = new Insets(0, 0, 5, 5);
		gbc_lab4.gridx = 1;
		gbc_lab4.gridy = 3;
		helpPanel.add(lab4, gbc_lab4);

		lab5 = new JLabel("\u039F\u03C5\u03C1\u03B1\u03BD\u03CC\u03C2");
		lab5.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lab5.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lab5 = new GridBagConstraints();
		gbc_lab5.fill = GridBagConstraints.BOTH;
		gbc_lab5.insets = new Insets(0, 0, 5, 5);
		gbc_lab5.gridx = 2;
		gbc_lab5.gridy = 3;
		helpPanel.add(lab5, gbc_lab5);

		lab6 = new JLabel("\u0394\u03AF\u03B1\u03C2");
		lab6.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lab6.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lab6 = new GridBagConstraints();
		gbc_lab6.fill = GridBagConstraints.BOTH;
		gbc_lab6.insets = new Insets(0, 0, 5, 0);
		gbc_lab6.gridx = 3;
		gbc_lab6.gridy = 3;
		helpPanel.add(lab6, gbc_lab6);

		pl4 = new JLabel("");
		hero = new ImageIcon("Pick_Hero\\Poseidon.jpg");
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		pl4.setIcon(new ImageIcon(resize));
		pl4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_pl4 = new GridBagConstraints();
		gbc_pl4.fill = GridBagConstraints.BOTH;
		gbc_pl4.insets = new Insets(0, 0, 5, 5);
		gbc_pl4.gridx = 1;
		gbc_pl4.gridy = 4;
		helpPanel.add(pl4, gbc_pl4);
		pl4.addMouseListener(PHL);

		char4 = new CharsOpponents("Ποσειδώνας", 10, 30, 20, hero);

		pl5 = new JLabel("");
		hero = new ImageIcon("Pick_Hero\\Uranus.jpg");
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		pl5.setIcon(new ImageIcon(resize));
		pl5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_pl5 = new GridBagConstraints();
		gbc_pl5.fill = GridBagConstraints.BOTH;
		gbc_pl5.insets = new Insets(0, 0, 5, 5);
		gbc_pl5.gridx = 2;
		gbc_pl5.gridy = 4;
		helpPanel.add(pl5, gbc_pl5);
		pl5.addMouseListener(PHL);

		char5 = new CharsOpponents("Ουρανός", 30, 20, 10, hero);

		pl6 = new JLabel("");
		hero = new ImageIcon("Pick_Hero\\Zeus.jpg");
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		pl6.setIcon(new ImageIcon(resize));
		pl6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_pl6 = new GridBagConstraints();
		gbc_pl6.fill = GridBagConstraints.BOTH;
		gbc_pl6.insets = new Insets(0, 0, 5, 0);
		gbc_pl6.gridx = 3;
		gbc_pl6.gridy = 4;
		helpPanel.add(pl6, gbc_pl6);
		pl6.addMouseListener(PHL);

		char6 = new CharsOpponents("Δίας", 30, 10, 20, hero);

		play = new JButton("\u03A0\u03B1\u03AF\u03BE\u03B5");
		play.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(!checkIfDone())
				{
					if(players.size() == 1)
					{
						players.get(0).setImage(image);
						players.get(0).setHealth(Double.parseDouble(p2.getText()));
						players.get(0).setDamage(Double.parseDouble(p3.getText()));
						players.get(0).setDefence(Double.parseDouble(p4.getText()));

						Pick_A_Hero.this.setVisible(false);
						new Board(players);
						clip.stop();
					}
					else
					{
						if(players.get(0).getImage() == null)
						{
							players.get(0).setImage(image);
							players.get(0).setHealth(Double.parseDouble(p2.getText()));
							players.get(0).setDamage(Double.parseDouble(p3.getText()));
							players.get(0).setDefence(Double.parseDouble(p4.getText()));
							helpLabel.disable();
						}
						else
						{
							players.get(1).setImage(image);
							players.get(1).setHealth(Double.parseDouble(p6.getText()));
							players.get(1).setDamage(Double.parseDouble(p7.getText()));
							players.get(1).setDefence(Double.parseDouble(p8.getText()));
							
							Pick_A_Hero.this.setVisible(false);
							new Board(players);
							clip.stop();
						}
					}
				}
			}
			
			public boolean checkIfDone(){
				for(User u : players){
					if(u.getImage() == null)
					{
						return false;
					}
				}
				return true;
			}
		});
		play.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_play = new GridBagConstraints();
		gbc_play.fill = GridBagConstraints.VERTICAL;
		gbc_play.insets = new Insets(0, 0, 0, 5);
		gbc_play.gridx = 2;
		gbc_play.gridy = 5;
		helpPanel.add(play, gbc_play);
		play.setEnabled(false);

		//
		quitPanel = new JPanel();
		quitPanel.setLayout(new BorderLayout(0, 0));
		piso = new JButton("\u03A0\u03AF\u03C3\u03C9");
		piso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip.stop();
				Pick_A_Hero.this.setVisible(false);
				new Name_Frame();
			}
		});
		piso.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		quitPanel.add(piso, BorderLayout.WEST);
		back.add(quitPanel, BorderLayout.SOUTH);
	}

	class Pick_A_Hero_Listener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			play.setEnabled(true);
			pl1.setBorder(null);
			pl2.setBorder(null);
			pl3.setBorder(null);
			pl4.setBorder(null);
			pl5.setBorder(null);
			pl6.setBorder(null);

			player1Panel.setVisible(true);
			
			if (players.size() == 1)
			{
				if(e.getSource() == pl1)
				{
					pl1.setBorder(new LineBorder(Color.RED, 5));
					image = new ImageIcon("Pick_Hero\\Ares.jpg");
					setStatValues(char1);
				}
				else if(e.getSource() == pl2)
				{
					pl2.setBorder(new LineBorder(Color.RED, 5));
					image = new ImageIcon("Pick_Hero\\Cronus.jpg");
					setStatValues(char2);
				}
				else if(e.getSource() == pl3)
				{
					pl3.setBorder(new LineBorder(Color.RED, 5));
					image = new ImageIcon("Pick_Hero\\Hades.jpg");
					setStatValues(char3);
				}
				else if(e.getSource() == pl4)
				{
					pl4.setBorder(new LineBorder(Color.RED, 5));
					image = new ImageIcon("Pick_Hero\\Poseidon.jpg");
					setStatValues(char4);
				}
				else if(e.getSource() == pl5)
				{
					pl5.setBorder(new LineBorder(Color.RED, 5));
					image = new ImageIcon("Pick_Hero\\Uranus.jpg");
					setStatValues(char5);
				}
				else if(e.getSource() == pl6)
				{
					pl6.setBorder(new LineBorder(Color.RED, 5));
					image = new ImageIcon("Pick_Hero\\Zeus.jpg");
					setStatValues(char6);
				}
			}
			else
			{
				if(players.get(0).getImage() != null)
				{
					player2Panel.setVisible(true);
					
					if(e.getSource() == pl1 && e.getSource() != helpLabel)
					{
						pl1.setBorder(new LineBorder(Color.RED, 5));
						image = new ImageIcon("Pick_Hero\\Ares.jpg");
						setStatValues(char1);
					}
					else if(e.getSource() == pl2 && e.getSource() != helpLabel)
					{
						pl2.setBorder(new LineBorder(Color.RED, 5));
						image = new ImageIcon("Pick_Hero\\Cronus.jpg");
						setStatValues(char2);
					}
					else if(e.getSource() == pl3 && e.getSource() != helpLabel)
					{
						pl3.setBorder(new LineBorder(Color.RED, 5));
						image = new ImageIcon("Pick_Hero\\Hades.jpg");
						setStatValues(char3);
					}
					else if(e.getSource() == pl4 && e.getSource() != helpLabel)
					{
						pl4.setBorder(new LineBorder(Color.RED, 5));
						image = new ImageIcon("Pick_Hero\\Poseidon.jpg");
						setStatValues(char4);
					}
					else if(e.getSource() == pl5 && e.getSource() != helpLabel)
					{
						pl5.setBorder(new LineBorder(Color.RED, 5));
						image = new ImageIcon("Pick_Hero\\Uranus.jpg");
						setStatValues(char5);
					}
					else if(e.getSource() == pl6 && e.getSource() != helpLabel)
					{
						pl6.setBorder(new LineBorder(Color.RED, 5));
						image = new ImageIcon("Pick_Hero\\Zeus.jpg");
						setStatValues(char6);
					}
				}
				else
				{
					if(e.getSource() == pl1)
					{
						pl1.setBorder(new LineBorder(Color.RED, 5));
						image = new ImageIcon("Pick_Hero\\Ares.jpg");
						setStatValues(char1);
						helpLabel = pl1;
					}
					else if(e.getSource() == pl2)
					{
						pl2.setBorder(new LineBorder(Color.RED, 5));
						image = new ImageIcon("Pick_Hero\\Cronus.jpg");
						setStatValues(char2);
						helpLabel = pl2;
					}
					else if(e.getSource() == pl3)
					{
						pl3.setBorder(new LineBorder(Color.RED, 5));
						image = new ImageIcon("Pick_Hero\\Hades.jpg");
						setStatValues(char3);
						helpLabel = pl3;
					}
					else if(e.getSource() == pl4)
					{
						pl4.setBorder(new LineBorder(Color.RED, 5));
						image = new ImageIcon("Pick_Hero\\Poseidon.jpg");
						setStatValues(char4);
						helpLabel = pl4;
					}
					else if(e.getSource() == pl5)
					{
						pl5.setBorder(new LineBorder(Color.RED, 5));
						image = new ImageIcon("Pick_Hero\\Uranus.jpg");
						setStatValues(char5);
						helpLabel = pl5;
					}
					else if(e.getSource() == pl6)
					{
						pl6.setBorder(new LineBorder(Color.RED, 5));
						image = new ImageIcon("Pick_Hero\\Zeus.jpg");
						setStatValues(char6);
						helpLabel = pl6;
					}
				}
			}
		}

		public void setStatValues(CharsOpponents c){
			CharsOpponents currChar;
			currChar = c;
			if(!player2Panel.isVisible())
			{
				p1.setText(currChar.getName());
				p2.setText(String.valueOf(currChar.getHealth()));
				p3.setText(String.valueOf(currChar.getDamage()));
				p4.setText(String.valueOf(currChar.getDefence()));
			}
			else
			{
				p5.setText(currChar.getName());
				p6.setText(String.valueOf(currChar.getHealth()));
				p7.setText(String.valueOf(currChar.getDamage()));
				p8.setText(String.valueOf(currChar.getDefence()));
			}

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}	
	}
}