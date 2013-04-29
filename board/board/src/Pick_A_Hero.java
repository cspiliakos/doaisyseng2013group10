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
	private JPanel helpPanel, quitPanel;
	private Name_Frame name;
	private Board pista;
	private User xristis1, xristis2;
	private Image background, resize, help;
	private ImageIcon hero, image;
	private BackgroundPanel back;
	private JLabel title, pl1, pl2, pl3, pl4, pl5, pl6, lab1, lab2, lab3, lab4, lab5, lab6;
	private JButton quit, piso, play;
	private Clip clip;
	private AudioInputStream audio;
	private Pick_A_Hero_Listener PHL;
	private int helpWidth, helpHeight, widthSize, heightSize;
	private double frameWidth, frameHeight;
	private ArrayList<User> players;
	
	public Pick_A_Hero(ArrayList<User> p) {
		//*** MenuBar ***//
				setJMenuBar(new JMenuFrame().getMenu()); // Getting the Menu from the JMenuFrame
		
		
		players=new ArrayList<User>();
		players=p;
		//metafora listas paixtwn
		xristis1 = players.get(0);
		if((players.size())>1){
			xristis2=players.get(1);
		}
		PHL = new Pick_A_Hero_Listener();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameWidth = screenSize.getWidth();
		frameHeight = screenSize.getHeight();
		helpWidth = (int)frameWidth;
		helpHeight = (int)frameHeight;
		widthSize = helpWidth / 7;
		heightSize = helpHeight / 3;
		
		try {
			background = ImageIO.read(new File("start.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
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
		title = new JLabel("\u0394\u03B9\u03AC\u03BB\u03B5\u03BE\u03B5 \u03AE\u03C1\u03C9\u03B1");
		title.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		back.add(title, BorderLayout.NORTH);
		
		//
		helpPanel = new JPanel();
		helpPanel.setBorder(new EmptyBorder(100, 0, 100, 0));
		back.add(helpPanel, BorderLayout.CENTER);
		GridBagLayout gbl_helpPanel = new GridBagLayout();
		gbl_helpPanel.columnWidths = new int[]{10, 10, 10};
		gbl_helpPanel.rowHeights = new int[]{50, 4, 4, 4, 4};
		helpPanel.setLayout(gbl_helpPanel);
		
		lab1 = new JLabel("Ares");
		lab1.setHorizontalAlignment(SwingConstants.CENTER);
		lab1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_lab1 = new GridBagConstraints();
		gbc_lab1.fill = GridBagConstraints.BOTH;
		gbc_lab1.insets = new Insets(0, 0, 5, 5);
		gbc_lab1.gridx = 1;
		gbc_lab1.gridy = 1;
		helpPanel.add(lab1, gbc_lab1);
		
		lab2 = new JLabel("Cronus");
		lab2.setHorizontalAlignment(SwingConstants.CENTER);
		lab2.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_lab2 = new GridBagConstraints();
		gbc_lab2.fill = GridBagConstraints.BOTH;
		gbc_lab2.insets = new Insets(0, 0, 5, 5);
		gbc_lab2.gridx = 2;
		gbc_lab2.gridy = 1;
		helpPanel.add(lab2, gbc_lab2);
		lab2.setLabelFor(pl2);
		
		lab3 = new JLabel("Hades");
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
		hero = new  ImageIcon("Ares.jpg");
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
		
		pl2 = new JLabel("");
		hero = new  ImageIcon("Cronus.jpg");
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
		
		pl3 = new JLabel("");
		hero = new  ImageIcon("Hades.jpg");
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
		
		lab4 = new JLabel("Poseidon");
		lab4.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lab4.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lab4 = new GridBagConstraints();
		gbc_lab4.fill = GridBagConstraints.BOTH;
		gbc_lab4.insets = new Insets(0, 0, 5, 5);
		gbc_lab4.gridx = 1;
		gbc_lab4.gridy = 3;
		helpPanel.add(lab4, gbc_lab4);
		
		lab5 = new JLabel("Uranus");
		lab5.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lab5.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lab5 = new GridBagConstraints();
		gbc_lab5.fill = GridBagConstraints.BOTH;
		gbc_lab5.insets = new Insets(0, 0, 5, 5);
		gbc_lab5.gridx = 2;
		gbc_lab5.gridy = 3;
		helpPanel.add(lab5, gbc_lab5);
		
		lab6 = new JLabel("Zeus");
		lab6.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lab6.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lab6 = new GridBagConstraints();
		gbc_lab6.fill = GridBagConstraints.BOTH;
		gbc_lab6.insets = new Insets(0, 0, 5, 0);
		gbc_lab6.gridx = 3;
		gbc_lab6.gridy = 3;
		helpPanel.add(lab6, gbc_lab6);
		
		pl4 = new JLabel("");
		hero = new  ImageIcon("Poseidon.jpg");
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
		
		pl5 = new JLabel("");
		hero = new  ImageIcon("Uranus.jpg");
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
		
		pl6 = new JLabel("");
		hero = new  ImageIcon("Zeus.jpg");
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
		
		play = new JButton("\u03A0\u03B1\u03AF\u03BE\u03B5");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(xristis1.getName());
				//System.out.println(xristis2.getName());
				if(!checkIfDone()){
					System.out.println("All players must choose a hero");
					if(players.size()==1){
						//single player
						players.get(0).setCharImage(image);
						
						Pick_A_Hero.this.setVisible(false);
						pista = new Board(players,image);
						//metabolh kataskeyasth
						pista.setVisible(true);
						clip.stop();
					}
					else{
						//multiplayer
						if(players.get(0).getCharImage()==null){
						players.get(0).setCharImage(image);
						}
						else{
							players.get(1).setCharImage(image);
							
							Pick_A_Hero.this.setVisible(false);
							pista = new Board(players,image);
							//metabolh kataskeyasth
							pista.setVisible(true);
							clip.stop();
						}
						}
				}
				
				
				 
			}
			public boolean checkIfDone(){
				//an exoume teleiwsei me tis eikones
				for(User u:players){
					if(u.getCharImage()==null)
						return false;
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
				Pick_A_Hero.this.setVisible(false);
				name = new Name_Frame();
				name.setVisible(true);
			}
			
			
		});
		piso.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		quitPanel.add(piso, BorderLayout.WEST);
		quitPanel.add(quit, BorderLayout.EAST);
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
			
			if(e.getSource() == pl1){
				pl1.setBorder(new LineBorder(Color.RED, 5));
				image = new ImageIcon("Ares.jpg");
			}
			else if(e.getSource() == pl2){
				pl2.setBorder(new LineBorder(Color.RED, 5));
				image = new ImageIcon("Cronus.jpg");
			}
			else if(e.getSource() == pl3){
				pl3.setBorder(new LineBorder(Color.RED, 5));
				image = new ImageIcon("Hades.jpg");
			}
			else if(e.getSource() == pl4){
				pl4.setBorder(new LineBorder(Color.RED, 5));
				image = new ImageIcon("Poseidon.jpg");
			}
			else if(e.getSource() == pl5){
				pl5.setBorder(new LineBorder(Color.RED, 5));
				image = new ImageIcon("Uranus.jpg");
			}
			else if(e.getSource() == pl6){
				pl6.setBorder(new LineBorder(Color.RED, 5));
				image = new ImageIcon("Zeus.jpg");
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