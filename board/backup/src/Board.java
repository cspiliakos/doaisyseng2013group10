import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Board extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JButton piso, plusLife, plusAttack, plusDefence, coinlbl, dicelbl;
	private JLabel attacklbl, defencelbl, life, skillpointlbl, playerCoins, hero1Label, hero2Label, 
	playerXP, player1lbl, player2lbl;
	private Random r;
	private JPanel playersPanel, quitPanel;
	private User xristis1, xristis2, currUser;
	private MyGlassPane myGlassPane;
	private int row1, row2, size, playerX, playerY, widthSize, heightSize, sqSize, userTurn, helpWidth, helpHeight, 
	coin, puzzle, dice, row;
	private double frameWidth, frameHeight;
	private BackgroundPanel back;
	@SuppressWarnings("unused")
	private Image background, hero, resize , hero2, helpImage;
	private Clip clip;
	private AudioInputStream audio;
	private ImageIcon image, smallImage, helpIcon;
	private UpgradeSkillListener skillListener;
	private ArrayList<User> players;
	private boolean adjust, played=false;
	//shows if the two players have been on the same square
	/**Sounds
	 * list.get(0) corona_h_grammata
	 * list.get(1) dice_roll
	 */
	private ArrayList<AudiosPair> list;
	private Sound_Thread soundthread1;
	
	public Board(ArrayList<User> p){
		r = new Random(System.currentTimeMillis());
		setJMenuBar(new JMenuFrame().getMenu());
		players = new ArrayList<User>();
		list = new ArrayList<AudiosPair>(new Audios().getBoardList());
		soundthread1 = new Sound_Thread();
		skillListener = new UpgradeSkillListener();
		adjust = false;
		userTurn = 2;
		players = p;
		xristis1 = players.get(0);
		image = xristis1.getImage();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameWidth = screenSize.getWidth();
		frameHeight = screenSize.getHeight();
		helpWidth = (int)frameWidth;
		helpHeight = (int)frameHeight;
		widthSize = helpWidth / 7;
		heightSize = helpHeight / 5;
		if (players.size() > 1)
		{
			xristis2 = players.get(1);
			smallImage = xristis2.getImage();
		}
		else
		{
			smallImage = xristis1.getImage();
		}
		
		currUser = xristis1;
		player1lbl = new JLabel();
		player2lbl = new JLabel();
		
		row1 = 1;
		row2 = 1;
		
		playerX = 0;
		playerY = 0;
		
		try {
			background = ImageIO.read(new File("Board\\background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		back = new BackgroundPanel(background);
		back.setLayout(new BorderLayout(5, 5));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setContentPane(back);
		setVisible(true);
		
		try{
			audio = AudioSystem.getAudioInputStream(new File("Sounds\\battle_theme.wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		///////////////////////////
		playersPanel = new JPanel();
		back.add(playersPanel, BorderLayout.EAST);
		
		coinlbl = new JButton();
		coinlbl.setBorder(null);
		coinlbl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat() ); //Sound: corona_h_grammata
				coin = r.nextInt(2);
				played = true;
				clip.stop(); //maxh kai grifoi exoun allo soundtrack
				if (coin == 1)
				{
					new DuelBoardFrame(currUser);
				}
				else
				{
					puzzle = r.nextInt(9);
					switch(puzzle)
					{
					case 0: new AncientArcadeFrame(currUser); break;
					case 1: new ClickMeFrame(currUser); break;
					case 2: new HangmanFrame(currUser); break;
					case 3: new MemoryGameFrame(currUser); break;
					case 4: new PicsHerosFrame(currUser); break;
					case 5: new QuizFrame(currUser); break;
					case 6: new TelecubeFrame(currUser); break;
					case 7: new TicTacToeFrame(currUser); break;
					case 8: new Pics3(currUser); break;
					}
				}
			}
		});
		coinlbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpIcon = new  ImageIcon("Board\\coin.gif");
		helpImage = helpIcon.getImage();
		resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
		GridBagLayout gbl_playersPanel = new GridBagLayout();
		playersPanel.setLayout(gbl_playersPanel);
		coinlbl.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_coinlbl = new GridBagConstraints();
		gbc_coinlbl.insets = new Insets(0, 0, 0, 5);
		gbc_coinlbl.gridx = 0;
		gbc_coinlbl.gridy = 0;
		playersPanel.add(coinlbl, gbc_coinlbl);
		
		dicelbl = new JButton();
		dicelbl.setBorder(null);
		dicelbl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				soundthread1.PlayMusic(list.get(1).getSongName(), list.get(1).getRepeat() ); 
				currUser.setWin(false);
				dice = r.nextInt(6) + 1;
				moveChar(getDice());
				myGlassPane.setXYCoordinates(playerX, playerY);
				myGlassPane.repaint();
				if((players.size()) > 1)
				{
					dicelbl.setEnabled(false);
					switchTurn();
				}
				else{
					currUser.setPlayed(false);
					dicelbl.setEnabled(false);
				}				
			}
		});
		dicelbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpIcon = new ImageIcon("Board\\dice.gif");
		helpImage = helpIcon.getImage();
		resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
		dicelbl.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_dicelbl = new GridBagConstraints();
		gbc_dicelbl.gridx = 1;
		gbc_dicelbl.gridy = 0;
		playersPanel.add(dicelbl, gbc_dicelbl);
		dicelbl.setEnabled(false);
		
		heightSize = helpHeight / 4;
		hero1Label = new JLabel();
		helpImage = image.getImage();
		resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
		hero1Label.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		gbc_imageLabel.gridx = 0;
		gbc_imageLabel.gridy = 1;
		playersPanel.add(hero1Label, gbc_imageLabel);
		
		widthSize = helpWidth / 8;
		heightSize = helpHeight / 6;
		hero2Label = new JLabel();
		helpImage = smallImage.getImage();
		resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
		hero2Label.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_hero2lbl = new GridBagConstraints();
		gbc_hero2lbl.gridx = 1;
		gbc_hero2lbl.gridy = 1;
		playersPanel.add(hero2Label, gbc_hero2lbl);
		
		attacklbl = new JLabel("\u0388\u03C0\u03AF\u03B8\u03B5\u03C3\u03B7: "+currUser.getDamage());
		attacklbl.setForeground(Color.ORANGE);
		attacklbl.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_attack = new GridBagConstraints();
		gbc_attack.gridx = 0;
		gbc_attack.gridy = 2;
		playersPanel.add(attacklbl, gbc_attack);
		
		plusAttack = new JButton("+");
		plusAttack.addActionListener(skillListener);
		plusAttack.setForeground(Color.ORANGE);
		plusAttack.setBackground(Color.BLACK);
		plusAttack.setFont(new Font("Sylfaen",Font.BOLD,30));
		GridBagConstraints gbc_plus_attack = new GridBagConstraints();
		gbc_plus_attack.gridx = 1;
		gbc_plus_attack.gridy = 2;
		playersPanel.add(plusAttack, gbc_plus_attack);
		
		defencelbl = new JLabel("\u0386\u03BC\u03C5\u03BD\u03B1: "+currUser.getDefence());
		defencelbl.setForeground(Color.ORANGE);
		defencelbl.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_defence = new GridBagConstraints();
		gbc_defence.gridx = 0;
		gbc_defence.gridy = 3;
		playersPanel.add(defencelbl, gbc_defence);
		
		plusDefence = new JButton("+");
		plusDefence.addActionListener(skillListener);
		plusDefence.setForeground(Color.ORANGE);
		plusDefence.setBackground(Color.BLACK);
		plusDefence.setFont(new Font("Sylfaen",Font.BOLD,30));
		GridBagConstraints gbc_plus_defence = new GridBagConstraints();
		gbc_plus_defence.gridx = 1;
		gbc_plus_defence.gridy = 3;
		playersPanel.add(plusDefence, gbc_plus_defence);
		
		life = new JLabel("\u0396\u03C9\u03AE: "+currUser.getHealth());
		life.setForeground(Color.ORANGE);
		life.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_life = new GridBagConstraints();
		gbc_life.gridx = 0;
		gbc_life.gridy = 4;
		playersPanel.add(life, gbc_life);
		
		plusLife = new JButton("+");
		plusLife.addActionListener(skillListener);
		plusLife.setForeground(Color.ORANGE);
		plusLife.setBackground(Color.BLACK);
		plusLife.setFont(new Font("Sylfaen",Font.BOLD,30));
		GridBagConstraints gbc_plus_life = new GridBagConstraints();
		gbc_plus_life.gridx = 1;
		gbc_plus_life.gridy = 4;
		playersPanel.add(plusLife, gbc_plus_life);
		
		skillpointlbl = new JLabel("Πόντοι ικανότητας: "+currUser.getSkillpoints());
		skillpointlbl.setFont(new Font("Sylfaen",Font.BOLD,20));
		skillpointlbl.setForeground(Color.WHITE);
		GridBagConstraints gbc_skill = new GridBagConstraints();
		gbc_skill.gridx = 0;
		gbc_skill.gridy = 5;
		playersPanel.add(skillpointlbl, gbc_skill);
		
		playerCoins = new JLabel("Νομίσματα: "+currUser.getCoins());
		playerCoins.setFont(new Font("Sylfaen",Font.BOLD,20));
		playerCoins.setForeground(Color.WHITE);
		GridBagConstraints gbc_coin = new GridBagConstraints();
		gbc_coin.gridx = 0;
		gbc_coin.gridy = 6;
		playersPanel.add(playerCoins, gbc_coin);
		
		playerXP = new JLabel("Εμπειρία: "+currUser.getXP());
		playerXP.setFont(new Font("Sylfaen",Font.BOLD,20));
		playerXP.setForeground(Color.WHITE);
		GridBagConstraints gbc_xp = new GridBagConstraints();
		gbc_xp.gridx = 0;
		gbc_xp.gridy = 7;
		playersPanel.add(playerXP, gbc_xp);
		
		if((players.size()) > 1)
		{
			hero2Label.setVisible(true);
		}
		else
		{
			hero2Label.setVisible(false);
		}
		
		/////////////////////////
		myGlassPane = new MyGlassPane();
		this.setGlassPane(myGlassPane);
		myGlassPane.setVisible(true);
		back.add(myGlassPane);
		
		///////////////////
		quitPanel = new JPanel();
		quitPanel.setLayout(new BorderLayout(0, 0));
		
		piso = new JButton("\u03A0\u03AF\u03C3\u03C9");
		piso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip.stop();
				Board.this.setVisible(false);
				new Pick_A_Hero(players);
			}
		});
		piso.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		quitPanel.add(piso, BorderLayout.WEST);
		back.add(quitPanel, BorderLayout.SOUTH);
	}
	
	public void switchTurn(){
		if(played==true)
		{
			//method to switch turns in multi player		
			if(userTurn == 1)
			{
				currUser.setWin(false);
				currUser.setPlayed(false);
				userTurn = 2;
				currUser = xristis1;
			}
			else if (userTurn == 2)
			{
				currUser.setWin(false);
				currUser.setPlayed(false);
				userTurn = 1;
				currUser = xristis2;
			}
			updateStatLabels();
			
			played = false;
			switchChars();
		}
	}
	
	public void updateStatLabels(){
		//for the values of the labels to be in accordance with the player 
		skillpointlbl.setText("Πόντοι ικανότητας: "+String.valueOf(currUser.getSkillpoints()));
		attacklbl.setText("\u0388\u03C0\u03AF\u03B8\u03B5\u03C3\u03B7: "+String.valueOf(currUser.getDamage()));
		defencelbl.setText("\u0386\u03BC\u03C5\u03BD\u03B1: "+String.valueOf(currUser.getDefence()));
		life.setText("\u0396\u03C9\u03AE: "+String.valueOf(currUser.getHealth()));
		playerCoins.setText("Νομίσματα: "+(currUser.getCoins()));
		playerXP.setText("Εμπειρία: "+(currUser.getXP()));
	}

	@SuppressWarnings("serial")
	public class MyGlassPane extends JComponent{
		private static final int ROWS = 6;
		private static final int COLUMNS = 6;
		private int xCoord = 0;
		private int yCoord = 0;
		private int x2Coord = 0;
		private int y2Coord = 0;
		
		public void setXYCoordinates(int xValue, int yValue) {
			if (userTurn == 2)
			{
				xCoord = xValue;
				yCoord = yValue;
			}
			else if (userTurn == 1)
			{
				x2Coord = xValue;
				y2Coord = yValue;
			}
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			sqSize = this.getHeight() / ROWS;
			size = sqSize;
			
			for(int i = 0; i < ROWS; i++) 
			{
				for(int j = 0; j < COLUMNS; j++) 
				{
					int x = j * sqSize;
					int y = i * sqSize;
					g.setColor(Color.YELLOW);
					g.drawRect(x, y, sqSize, sqSize);
				}
			}
			updateStatLabels();
			
			if (currUser.getWin())
			{
				dicelbl.setEnabled(true);
			}
			else
			{
				dicelbl.setEnabled(false);
				if (players.size() > 1)
				{
					if(currUser.isPlayed())
					switchTurn();
				}
			}
			
			player1lbl.setSize(sqSize,sqSize);
			helpIcon = new ImageIcon("Board\\player1.gif");
			helpImage = helpIcon.getImage();
			resize = helpImage.getScaledInstance(player1lbl.getWidth(), player1lbl.getHeight(), 0);
			player1lbl.setIcon(new ImageIcon(resize));
			player1lbl.setBounds(xCoord, yCoord, sqSize, sqSize);
			myGlassPane.add(player1lbl);
			
			player2lbl.setSize(sqSize,sqSize);
			helpIcon = new ImageIcon("Board\\player3.gif");
			helpImage = helpIcon.getImage();
			resize = helpImage.getScaledInstance(player2lbl.getWidth(), player2lbl.getHeight(), 0);
			player2lbl.setIcon(new ImageIcon(resize));
			player2lbl.setBounds(x2Coord, y2Coord, sqSize, sqSize);
			if ((players.size())>1)
			{
				myGlassPane.add(player2lbl);
				checkSameSquare();
			}
		}
		
		public void checkSameSquare(){
		//resize the players figure if both players are on the same square
			if (((player1lbl.getX()) == (player2lbl.getX())) && ((player1lbl.getY()) == (player2lbl.getY())))
			{
				player1lbl.setSize((sqSize / 2), sqSize);
				helpIcon = new ImageIcon("Board\\player1.gif");
				helpImage = helpIcon.getImage();
				resize = helpImage.getScaledInstance(player1lbl.getWidth(), player1lbl.getHeight(), 0);
				player1lbl.setIcon(new ImageIcon(resize));
				player1lbl.setBounds(xCoord, yCoord,(sqSize/2), (sqSize));
			
				player2lbl.setSize((sqSize / 2), sqSize);
				helpIcon = new ImageIcon("Board\\player3.gif");
				helpImage = helpIcon.getImage();
				resize = helpImage.getScaledInstance(player2lbl.getWidth(), player2lbl.getHeight(), 0);
				player2lbl.setIcon(new ImageIcon(resize));
				player2lbl.setBounds((x2Coord + (sqSize / 2)), y2Coord, (sqSize / 2), sqSize);
			
				adjust = true;
			}		
		}
	}

	public class UpgradeSkillListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			double health = currUser.getHealth();
			double attack = currUser.getDamage();
			double defence = currUser.getDefence();
			int skillpoints = currUser.getSkillpoints();
			if(skillpoints > 0)
			{
				if(e.getSource() == plusLife)
				{
					health++;
					currUser.setHealth(health);
					skillpoints--;
					currUser.setSkillpoints(skillpoints);
					skillpointlbl.setText("Πόντοι ικανότητας: " +currUser.getSkillpoints());
					life.setText("\u0396\u03C9\u03AE: "+currUser.getHealth());
				}
				else if(e.getSource() == plusAttack)
				{
					attack++;
					currUser.setDamage(attack);
					skillpoints--;
					currUser.setSkillpoints(skillpoints);
					skillpointlbl.setText("Πόντοι ικανότητας: " +currUser.getSkillpoints());
					attacklbl.setText("\u0388\u03C0\u03AF\u03B8\u03B5\u03C3\u03B7: "+currUser.getDamage());
				}
				else if(e.getSource() == plusDefence)
				{
					defence++;
					currUser.setDefence(defence);
					skillpoints--;
					currUser.setSkillpoints(skillpoints);
					skillpointlbl.setText("Πόντοι ικανότητας: " +currUser.getSkillpoints());
					defencelbl.setText("\u0386\u03BC\u03C5\u03BD\u03B1: "+currUser.getDefence());
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Δεν έχεις άλλους πόντους ικανότητας διαθέσιμους.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void switchChars(){			
		//tha kaleitai mono an paizoun 2 paixtes
		ImageIcon tempIcon = new ImageIcon();
		Icon i = hero1Label.getIcon();
		tempIcon = (ImageIcon)i;
		//apothikeyw to icon ths megalhs eikonas
		Image tempImage = tempIcon.getImage();
		Image tempResizedImage = tempImage.getScaledInstance(hero2Label.getWidth(), hero2Label.getHeight(), 0);
		//thn metasxhmatizw stis diastaseis tou mikrou label
		switchTurn();
		tempIcon = currUser.getImage();
		tempImage = tempIcon.getImage();
		hero2Label.setIcon(new ImageIcon(tempResizedImage));
		tempResizedImage = tempImage.getScaledInstance(hero1Label.getWidth(), hero1Label.getHeight(), 0);
		hero1Label.setIcon(new ImageIcon(tempResizedImage));
		//allagh twn label me ta xarakthristika
	}
	
	public int getDice(){
		return dice;
	}
	
	public void moveChar(int dice){
		//int row;
		if (userTurn == 2)
		{
			playerX = player1lbl.getX();
			playerY = player1lbl.getY();
			row = row1;
			adjust = false;
		}
		else if(userTurn == 1)
		{
			if(adjust)
			{
				playerX = (player2lbl.getX()) - (sqSize / 2);
			}
			else
			{
				playerX = player2lbl.getX();
			}
			
			playerY = player2lbl.getY();
			row = row2;
		}
		for (int i = 0; i < dice; i++)
		{
			if (row % 2 == 0)
			{
				playerX -= size;
				if(playerX < 0)
				{
					if(row != 6)
					{
					playerY += size;
					row++;
					playerX += size;
					}
					else
					{
						i = dice;
						playerX = 0;
						playerY = playerY;
						JOptionPane.showMessageDialog(null, "Τέλος πίστας.", "Τέλος παιχνιδιού", JOptionPane.INFORMATION_MESSAGE);
						Board.this.setVisible(false);
						new Start_Frame();
					}	
				}
			}
			else
			{
				playerX = playerX + size;
				if (playerX + size > (6 * size))
				{
					playerY += size;
					row++;
					playerX -= size;
				}
			}
		}
		
		if(userTurn == 2)
		{
			//dealing with players figure rows
			row1 = row;
		}
		else if(userTurn == 1)
		{
			row2 = row;
		}
	}
}
