import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import java.awt.Cursor;
import javax.imageio.ImageIO;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class AncientArcadeFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private Image background, help, resize;
	private ImageIcon hero;
	private BackgroundPanel back;
	private JButton pause, check;
	private Timer timer;
	private TimerClass count;
	private User player;
	private JPanel timePanel, checkPanel, image1, image2, centre;
	private int helpWidth, helpHeight, widthSize, heightSize, minutes, seconds;
	private double frameWidth, frameHeight;
	private JLabel timeLabel, hero1, hero2, hero3, hero4, hero5, hero6, 
	symbol1, symbol2, symbol3, symbol4, symbol5, symbol6, heroTip, symbolTip, helpTip;
	private Uicons iconlist;
	private ArrayList<ImageIcon> currlist;
	private ArrayList<AudiosPair> list = new ArrayList<AudiosPair>(new Audios().getArcadeList());
	private Sound_Thread soundthread1 = new Sound_Thread();
	private Labels listen;
	private Labels2 listen2;
	private boolean flag1, flag2, flag3, flag4, flag5, flag6, isRunning;
	private String name, symbol;
	
	private JTextArea heroArea;
	private JTextArea symbolArea;
	private JScrollPane scrollPane,scrollPane_1;
	
	private ArrayList<String> Info ;
	
	public AncientArcadeFrame(User u) {
		setJMenuBar(new JMenuFrame().getMenu());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameWidth = screenSize.getWidth();
		frameHeight = screenSize.getHeight();
		helpWidth = (int)frameWidth;
		helpHeight = (int)frameHeight;
		widthSize = helpWidth / 5;
		heightSize = helpHeight / 8;
		
		listen = new Labels();
		listen2 = new Labels2();
		iconlist = new Uicons();
		currlist = new ArrayList<ImageIcon>(iconlist.getArcadeIcons());
		player = u;
		minutes =  2;
		seconds = 0;
		count = new TimerClass(minutes, seconds);
		timer = new Timer(1000, count);
		timer.start();
		isRunning  = true;
		flag1 = false;
		flag2 = false;
		flag3 = false;
		flag4 = false;
		flag5 = false;
		flag6 = false;
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
		
		/////////////////
		centre = new JPanel();
		GridBagLayout gbl_centre = new GridBagLayout();
		gbl_centre.columnWidths = new int[]{50};
		gbl_centre.rowHeights = new int[]{80, 80, 80};
		centre.setLayout(gbl_centre);
		heroTip = new JLabel("");
		heroTip.setForeground(Color.BLACK);
		heroTip.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
		GridBagConstraints gbc_heroTip = new GridBagConstraints();
		gbc_heroTip.insets = new Insets(0, 0, 0, 5);
		gbc_heroTip.gridx = 0;
		gbc_heroTip.gridy = 0;
		centre.add(heroTip, gbc_heroTip);
		helpTip = new JLabel("-");
		helpTip.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
		helpTip.setForeground(Color.BLACK);
		GridBagConstraints gbc_helpTip = new GridBagConstraints();
		gbc_helpTip.insets = new Insets(0, 0, 0, 5);
		gbc_helpTip.gridx = 0;
		gbc_helpTip.gridy = 1;
		centre.add(helpTip, gbc_helpTip);
		symbolTip = new JLabel("");
		symbolTip.setForeground(Color.BLACK);
		symbolTip.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
		GridBagConstraints gbc_symbolTip = new GridBagConstraints();
		gbc_symbolTip.gridx = 0;
		gbc_symbolTip.gridy = 2;
		centre.add(symbolTip, gbc_symbolTip);
		back.add(centre, BorderLayout.CENTER);
		
		/////////////////
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
					check.setEnabled(false);
					if (!flag1)
					{
						hero1.removeMouseListener(listen);
						symbol3.removeMouseListener(listen2);
					}
					
					if (!flag2)
					{
						hero2.removeMouseListener(listen);
						symbol6.removeMouseListener(listen2);
					}
					
					if (!flag3)
					{
						hero3.removeMouseListener(listen);
						symbol1.removeMouseListener(listen2);
					}
					
					if (!flag4)
					{
						hero4.removeMouseListener(listen);
						symbol2.removeMouseListener(listen2);
					}
					
					if (!flag5)
					{
						hero5.removeMouseListener(listen);
						symbol5.removeMouseListener(listen2);
					}
					
					if (!flag6) 
					{
						hero6.removeMouseListener(listen);
						symbol4.removeMouseListener(listen2);
					}
				}
				else
				{
					isRunning = true;
					timer.start();
					check.setEnabled(true);
					if (!flag1)
					{
						hero1.addMouseListener(listen);
						symbol3.addMouseListener(listen2);
					}
					
					if (!flag2)
					{
						hero2.addMouseListener(listen);
						symbol6.addMouseListener(listen2);
					}
					
					if (!flag3)
					{
						hero3.addMouseListener(listen);
						symbol1.addMouseListener(listen2);
					}
					
					if (!flag4)
					{
						hero4.addMouseListener(listen);
						symbol2.addMouseListener(listen2);
					}
					
					if (!flag5)
					{
						hero5.addMouseListener(listen);
						symbol5.addMouseListener(listen2);
					}
					
					if (!flag6) 
					{
						hero6.addMouseListener(listen);
						symbol4.addMouseListener(listen2);
					}
				}
			}
		});
		timePanel.add(pause);
		back.add(timePanel, BorderLayout.NORTH);
		
		/////////////////////////////
		checkPanel = new JPanel(new GridLayout(3,1));
		back.add(checkPanel, BorderLayout.SOUTH);
		
		Info = new ArrayList<String>();
		addTips();
		
		
		scrollPane = new JScrollPane();
				
		heroArea=new JTextArea();
		heroArea.setEditable(false);
		heroArea.setLineWrap(true);
		heroArea.setFont(new Font ("Aria",Font.PLAIN,15));
		
		checkPanel.add(heroArea);
		
		symbolArea=new JTextArea();
		symbolArea.setEditable(false);
		symbolArea.setLineWrap(true);
		symbolArea.setFont(new Font ("Aria",Font.PLAIN,15));
		symbolArea.setDropMode(DropMode.INSERT);
		checkPanel.add(symbolArea);

		
		
		check = new JButton();
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(name.equals("dias") && symbol.equals("olympos"))
				{
						hero1.setEnabled(false);
						symbol3.setEnabled(false);
						hero1.removeMouseListener(listen);
						symbol3.removeMouseListener(listen2);
						flag1 = true;
						heroTip.setText("");
						symbolTip.setText("");
				}
				else if(name.equals("poseidonas") && symbol.equals("thallassa"))
				{
						hero2.setEnabled(false);
						symbol6.setEnabled(false);
						hero2.removeMouseListener(listen);
						symbol6.removeMouseListener(listen2);
						flag2 = true;
						heroTip.setText("");
						symbolTip.setText("");
				}
				else if(name.equals("iraklis") && symbol.equals("kerveros"))
				{
						hero3.setEnabled(false);
						symbol1.setEnabled(false);
						hero3.removeMouseListener(listen);
						symbol1.removeMouseListener(listen2);
						flag3 = true;
						heroTip.setText("");
						symbolTip.setText("");
				}
				else if(name.equals("thiseas") && symbol.equals("minotavros"))
				{
						hero4.setEnabled(false);
						symbol2.setEnabled(false);
						hero4.removeMouseListener(listen);
						symbol2.removeMouseListener(listen2);
						flag4 = true;
						heroTip.setText("");
						symbolTip.setText("");
				}
				else if(name.equals("oddyseas") && symbol.equals("skylla"))
				{
						hero5.setEnabled(false);
						symbol5.setEnabled(false);
						hero5.removeMouseListener(listen);
						symbol5.removeMouseListener(listen2);
						flag5 = true;
						heroTip.setText("");
						symbolTip.setText("");
				}
				else if(name.equals("perseas") && symbol.equals("medousa"))
				{
						hero6.setEnabled(false);
						symbol4.setEnabled(false);
						hero6.removeMouseListener(listen);
						symbol4.removeMouseListener(listen2);
						flag6 = true;
						heroTip.setText("");
						symbolTip.setText("");
				}
				
				if(flag1 && flag2 && flag3 && flag4 && flag5 && flag6)
				{
					soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat());
					player.setCoins(player.getCoins() + 1000);
					player.setXP(player.getXP() + 1000);
					AncientArcadeFrame.this.setVisible(false);
					JOptionPane.showMessageDialog(null, "”ı„˜·ÒÁÙﬁÒÈ·!");	
				}
			}
		});
		check.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		check.setText("\u0388\u03BB\u03B5\u03B3\u03C7\u03BF\u03C2");
		checkPanel.add(check);
		
		////////////////////////
		image1 = new JPanel();
		back.add(image1, BorderLayout.WEST);
		GridBagLayout gbl_image1 = new GridBagLayout();
		image1.setLayout(gbl_image1);
						
		hero1 = new JLabel();  //zeus   --> 1
		hero1.addMouseListener(listen);
		hero1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(1).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		hero1.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_hero1 = new GridBagConstraints();
		gbc_hero1.insets = new Insets(0, 0, 5, 0);
		gbc_hero1.gridx = 0;
		gbc_hero1.gridy = 0;
		image1.add(hero1, gbc_hero1);
						
		hero2 = new JLabel();   //poseidon --> 2
		hero2.addMouseListener(listen);
		hero2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(2).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		hero2.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_hero2 = new GridBagConstraints();
		gbc_hero2.insets = new Insets(0, 0, 5, 0);
		gbc_hero2.gridx = 0;
		gbc_hero2.gridy = 1;
		image1.add(hero2, gbc_hero2);

		hero3 = new JLabel();   // hercules --> 3
		hero3.addMouseListener(listen);
		hero3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(3).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		hero3.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_hero3 = new GridBagConstraints();
		gbc_hero3.insets = new Insets(0, 0, 5, 0);
		gbc_hero3.gridx = 0;
		gbc_hero3.gridy = 2;
		image1.add(hero3, gbc_hero3);
		
		hero4 = new JLabel();
		hero4.addMouseListener(listen);
		hero4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(4).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		hero4.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_hero4 = new GridBagConstraints();
		gbc_hero4.insets = new Insets(0, 0, 5, 0);
		gbc_hero4.gridx = 0;
		gbc_hero4.gridy = 3;
		image1.add(hero4, gbc_hero4);
				
		hero5 = new JLabel();
		hero5.addMouseListener(listen);
		hero5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(5).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		hero5.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_hero5 = new GridBagConstraints();
		gbc_hero5.insets = new Insets(0, 0, 5, 0);
		gbc_hero5.gridx = 0;
		gbc_hero5.gridy = 4;
		image1.add(hero5, gbc_hero5);
		
		hero6 = new JLabel();
		hero6.addMouseListener(listen);
		hero6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(6).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		hero6.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_hero6 = new GridBagConstraints();
		gbc_hero6.insets = new Insets(0, 0, 5, 0);
		gbc_hero6.gridx = 0;
		gbc_hero6.gridy = 5;
		image1.add(hero6, gbc_hero6);
		
		///////////////////////
		image2 = new JPanel();
		back.add(image2, BorderLayout.EAST);
		GridBagLayout gbl_image2 = new GridBagLayout();
		image2.setLayout(gbl_image2);
		
		symbol1 = new JLabel("");
		symbol1.addMouseListener(listen2);
		symbol1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(7).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		symbol1.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_symbol1 = new GridBagConstraints();
		gbc_symbol1.insets = new Insets(0, 0, 5, 0);
		gbc_symbol1.gridx = 1;
		gbc_symbol1.gridy = 0;
		image2.add(symbol1, gbc_symbol1);
		
		symbol2 = new JLabel("");
		symbol2.addMouseListener(listen2);
		symbol2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(8).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		symbol2.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_symbol2 = new GridBagConstraints();
		gbc_symbol2.insets = new Insets(0, 0, 5, 0);
		gbc_symbol2.gridx = 1;
		gbc_symbol2.gridy = 1;
		image2.add(symbol2, gbc_symbol2);
		
		symbol3 = new JLabel("");
		symbol3.addMouseListener(listen2);
		symbol3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(9).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		symbol3.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_symbol3 = new GridBagConstraints();
		gbc_symbol3.insets = new Insets(0, 0, 5, 0);
		gbc_symbol3.gridx = 1;
		gbc_symbol3.gridy = 2;
		image2.add(symbol3, gbc_symbol3);
		
		symbol4 = new JLabel("");
		symbol4.addMouseListener(listen2);
		symbol4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(10).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		symbol4.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_symbol4 = new GridBagConstraints();
		gbc_symbol4.insets = new Insets(0, 0, 5, 0);
		gbc_symbol4.gridx = 1;
		gbc_symbol4.gridy = 3;
		image2.add(symbol4, gbc_symbol4);
		
		symbol5 = new JLabel("");
		symbol5.addMouseListener(listen2);
		symbol5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(11).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		symbol5.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_symbol5 = new GridBagConstraints();
		gbc_symbol5.insets = new Insets(0, 0, 5, 0);
		gbc_symbol5.gridx = 1;
		gbc_symbol5.gridy = 4;
		image2.add(symbol5, gbc_symbol5);
		
		symbol6 = new JLabel("");
		symbol6.addMouseListener(listen2);
		symbol6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hero = new ImageIcon(currlist.get(12).getImage());
		help = hero.getImage();
		resize = help.getScaledInstance(widthSize, heightSize, 0);
		symbol6.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_symbol6 = new GridBagConstraints();
		gbc_symbol6.insets = new Insets(0, 0, 5, 0);
		gbc_symbol6.gridx = 1;
		gbc_symbol6.gridy = 5;
		image2.add(symbol6, gbc_symbol6);
	}
	public void addTips(){
		         //info about Zeus
		Info.add("King of the gods, the ruler of Mount Olympus and the god of the sky" +
				", weather, thunder, lightning, law, order, and fate.");

		Info.add("Poseidon or Posidon is one of the twelve Olympian deities of the pantheon" +
				" in Greek mythology. His main domain is the ocean, and he is  called the 'God of the Sea'.");

		Info.add("Hercules is the Roman name for the Greek divine hero Heracles, who was the son of Zeus " +
				"and the mortal Alcmene. In classical mythology, Hercules is famous for his strength and for his" +
				" numerous far-ranging adventures.");

		Info.add("Theseus was the mythical founder-king of Athens, son of Aegeus and Poseidon, both of whom Aethra had " +
				"slept with in one night. Theseus was a founder-hero , like Perseus, Cadmus, or Heracles,");
		
		Info.add("Odysseus also known by the Roman name Ulysses , was a legendary Greek king of Ithaca and a" +
		      		" hero of Homer's epic poem the Odyssey.");
		
		Info.add("Perseus the legendary founder of Mycenae and the Perseid dynasty of Danaans there, was the first of the" +
				" heroes of Greek mythology whose exploits in defeating various archaic monsters provided the founding myths of the" +
				" Twelve Olympians. Perseus was a demi-god, the Greek hero who killed the Gorgon Medusa, and claimed Andromeda, having " +
				"rescued her from a sea monster sent by Poseidon in retribution for Queen Cassiopeia declaring that her daughter, " +
				"Andromeda, was more beautiful than the Nereids");
		
		Info.add("Cerberus or Kerberos, in Greek and Roman mythology, is a multi-headed (usually three-headed) dog, whi" +
				"ch guards the gates of the Underworld , to prevent those who have" +
				" crossed the river Styx from ever escaping. ");
	
		Info.add("In Greek mythology, the Minotaur was a creature with the head of a bull on the body of a man." +
				" He dwelt at the center of the Cretan Labyrinth, which was an elaborate maze-like construction" +
				" designed by the architect Daedalus and his son Icarus, on the command of King Minos of Crete." +
				" The Minotaur was eventually killed by the Athenian hero Theseus.");
		
		Info.add("Mount Olympus is the highest mountain in Greece, located in the Olympus Range on the border between Thessaly " +
				"and Macedonia. In Greek mythology Olympus was regarded as the home of the Twelve Olympian gods of the ancient Greek world." +
				" It formed itself after the gods defeated the Titans in the Titan War, and soon the palace was inhabited by the gods.");
		
		Info.add("In Greek mythology Medusa was a monster, a Gorgon, generally described as having the face of a hideous human female with living " +
			     	"venomous snakes in place of hair. Gazing directly upon her would turn onlookers to stone");
	
		Info.add("In Greek mythology, Scylla was a monster that lived on one side of a narrow channel of water, opposite its counterpart Charybdis. " +
				" The two sides of the strait were within an arrow's range of each otheróso close that sailors attempting to avoid Charybdis would " +
		   		"pass too close to Scylla and vice versa.");
		
		Info.add("In ancient Greece, the sea world was one of the most important things, as the fish was a basic part of Greek" +
			          	" nutrition. They also used sea to trade with other civilizations");
	}
	public class Labels implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			hero1.setBorder(null);
			hero2.setBorder(null);
			hero3.setBorder(null);
			hero4.setBorder(null);
			hero5.setBorder(null);
			hero6.setBorder(null);
			
			if(e.getSource() == hero1)
			{
				hero1.setBorder(new LineBorder(Color.RED, 5));
				heroArea.setText(Info.get(0));
				soundthread1.PlayMusic(list.get(1).getSongName(), list.get(1).getRepeat() ); //Sound: dias
				heroTip.setText("ƒ…¡”");
				name = "dias";
			} 
			else if(e.getSource() == hero2)
			{
				hero2.setBorder(new LineBorder(Color.RED, 5));
				heroArea.setText(Info.get(1));
				heroTip.setText("–œ”≈…ƒŸÕ¡”");
				name = "poseidonas";
			}
			else if(e.getSource() == hero3)
			{
				hero3.setBorder(new LineBorder(Color.RED, 5));
				heroArea.setText(Info.get(2));
				heroTip.setText("«—¡ À«”");
				name = "iraklis";
			}
			else if(e.getSource() == hero4)
			{
				hero4.setBorder(new LineBorder(Color.RED, 5));
				heroArea.setText(Info.get(3));
				heroTip.setText("»«”≈¡”");
				name = "thiseas";
			}
			else if(e.getSource() == hero5)
			{
				hero5.setBorder(new LineBorder(Color.RED, 5));
				heroArea.setText(Info.get(4));
				heroTip.setText("œƒ’””≈¡”");
				name = "oddyseas";
			}
			else if(e.getSource() == hero6)
			{
				hero6.setBorder(new LineBorder(Color.RED, 5));
				heroArea.setText(Info.get(5));
				soundthread1.PlayMusic(list.get(4).getSongName(), list.get(4).getRepeat() ); //Sound: olympus
				heroTip.setText("–≈—”≈¡”");
				name = "perseas";
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
	
	public class Labels2 implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			symbol1.setBorder(null);
			symbol2.setBorder(null);
			symbol3.setBorder(null);
			symbol4.setBorder(null);
			symbol5.setBorder(null);
			symbol6.setBorder(null);
			
			if(e.getSource() == symbol1)
			{
				symbol1.setBorder(new LineBorder(Color.RED, 5));
				symbolArea.setText(Info.get(6));
				soundthread1.PlayMusic(list.get(5).getSongName(), list.get(5).getRepeat() ); //Sound: cerberus
				symbolTip.setText(" ≈—¬≈—œ”");
				symbol = "kerveros";
			}
			else if(e.getSource() == symbol2)
			{
				symbol2.setBorder(new LineBorder(Color.RED, 5));
				symbolArea.setText(Info.get(7));
				soundthread1.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat() ); //Sound: minotaur
				symbolTip.setText("Ã…Õœ‘¡’—œ”");
				symbol = "minotavros";
			}
			else if(e.getSource() == symbol3)
			{
				symbol3.setBorder(new LineBorder(Color.RED, 5));
				symbolArea.setText(Info.get(8));
				soundthread1.PlayMusic(list.get(3).getSongName(), list.get(3).getRepeat() ); //Sound: olympus
				symbolTip.setText("œÀ’Ã–œ”");
				symbol = "olympos";
			}
			else if(e.getSource() == symbol4)
			{
				symbol4.setBorder(new LineBorder(Color.RED, 5));
				symbolArea.setText(Info.get(9));
				symbolTip.setText("Ã≈ƒœ’”¡");
				symbol = "medousa";
			}
			else if(e.getSource() == symbol5)
			{
				symbol5.setBorder(new LineBorder(Color.RED, 5));
				symbolArea.setText(Info.get(10));
				symbolTip.setText("” ’ÀÀ¡");
				symbol = "skylla";
			}
			else if(e.getSource() == symbol6)
			{
				symbol6.setBorder(new LineBorder(Color.RED, 5));
				symbolArea.setText(Info.get(11));
				symbolTip.setText("»¡À¡””¡");
				symbol = "thallassa";
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
				AncientArcadeFrame.this.setVisible(false);
				JOptionPane.showMessageDialog(null, "∏˜·ÛÂÚ!");	
			}
		}
	}
}
