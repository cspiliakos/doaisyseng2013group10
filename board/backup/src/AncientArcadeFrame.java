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
		pause.setFont(new Font("Sylfaen", Font.PLAIN, 20));
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
		checkPanel = new JPanel();
		back.add(checkPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_checkPanel = new GridBagLayout();
		checkPanel.setLayout(gbl_checkPanel);
		
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
		GridBagConstraints gbc_check = new GridBagConstraints();
		gbc_check.fill = GridBagConstraints.BOTH;
		gbc_check.gridx = 0;
		gbc_check.gridy = 0;
		checkPanel.add(check, gbc_check);
		
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
				soundthread1.PlayMusic(list.get(1).getSongName(), list.get(1).getRepeat() ); //Sound: dias
				heroTip.setText("ƒ…¡”");
				name = "dias";
			} 
			else if(e.getSource() == hero2)
			{
				hero2.setBorder(new LineBorder(Color.RED, 5));
				heroTip.setText("–œ”≈…ƒŸÕ¡”");
				name = "poseidonas";
			}
			else if(e.getSource() == hero3)
			{
				hero3.setBorder(new LineBorder(Color.RED, 5));
				heroTip.setText("«—¡ À«”");
				name = "iraklis";
			}
			else if(e.getSource() == hero4)
			{
				hero4.setBorder(new LineBorder(Color.RED, 5));
				heroTip.setText("»«”≈¡”");
				name = "thiseas";
			}
			else if(e.getSource() == hero5)
			{
				hero5.setBorder(new LineBorder(Color.RED, 5));
				heroTip.setText("œƒ’””≈¡”");
				name = "oddyseas";
			}
			else if(e.getSource() == hero6)
			{
				hero6.setBorder(new LineBorder(Color.RED, 5));
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
				soundthread1.PlayMusic(list.get(5).getSongName(), list.get(5).getRepeat() ); //Sound: cerberus
				symbolTip.setText(" ≈—¬≈—œ”");
				symbol = "kerveros";
			}
			else if(e.getSource() == symbol2)
			{
				symbol2.setBorder(new LineBorder(Color.RED, 5));
				soundthread1.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat() ); //Sound: minotaur
				symbolTip.setText("Ã…Õœ‘¡’—œ”");
				symbol = "minotavros";
			}
			else if(e.getSource() == symbol3)
			{
				symbol3.setBorder(new LineBorder(Color.RED, 5));
				soundthread1.PlayMusic(list.get(3).getSongName(), list.get(3).getRepeat() ); //Sound: olympus
				symbolTip.setText("œÀ’Ã–œ”");
				symbol = "olympos";
			}
			else if(e.getSource() == symbol4)
			{
				symbol4.setBorder(new LineBorder(Color.RED, 5));
				symbolTip.setText("Ã≈ƒœ’”¡");
				symbol = "medousa";
			}
			else if(e.getSource() == symbol5)
			{
				symbol5.setBorder(new LineBorder(Color.RED, 5));
				symbolTip.setText("” ’ÀÀ¡");
				symbol = "skylla";
			}
			else if(e.getSource() == symbol6)
			{
				symbol6.setBorder(new LineBorder(Color.RED, 5));
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
