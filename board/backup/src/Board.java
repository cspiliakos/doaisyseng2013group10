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
import javax.sound.sampled.Clip;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Board extends JFrame{
	//frame of the main board
	
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
	private ImageIcon image, smallImage, helpIcon;
	private UpgradeSkillListener skillListener;
	private ArrayList<User> players;
	private boolean adjust, //shows if the two players have been on the same square
	played=false; // shows if the player's turn has finished
	
	/**Sounds
	 * list.get(0) corona_h_grammata
	 * list.get(1) dice_roll
	 */
	private ArrayList<AudiosPair> list = new ArrayList<AudiosPair>(new Audios().getBoardList());
	private Uicons iconlist;
	private ArrayList<ImageIcon> currlist;
	ArrayList<CharsOpponents> chOp;
	//CharsOpponents opponent;
	ArrayList<String> name;
	private Sound_Thread soundthread1;
	private Sound_Thread soundthread2 = new Sound_Thread();
	
	public Board(ArrayList<User> p){
		
		iconlist=new Uicons();
		currlist=iconlist.getOpponentIcons();
		populateOpponentsList(currlist);
		
		
		
		soundthread2.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat() ); //Soundtrack
		//getting the music theme
		
		r = new Random(System.currentTimeMillis());
		setJMenuBar(new JMenuFrame().getMenu());
		//menu
		players = new ArrayList<User>();
		//arraylist to add the players
		
		
		soundthread1 = new Sound_Thread();
		skillListener = new UpgradeSkillListener();
		
		adjust = false;
		userTurn = 2;
		//keeps track of the turn of the players in multiplayer game
		players = p;
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameWidth = screenSize.getWidth();
		frameHeight = screenSize.getHeight();
		helpWidth = (int)frameWidth;
		helpHeight = (int)frameHeight;
		widthSize = helpWidth / 7;
		heightSize = helpHeight / 5;
		//managing the frame dimensions
		
		xristis1 = players.get(0);
		image = xristis1.getImage();
		if (players.size() > 1)
		{
			xristis2 = players.get(1);
			smallImage = xristis2.getImage();
		}
		else
		{
			//getting NullPointerException if no image is set
			smallImage = xristis1.getImage();
		}
		//getting the users from the arraylist
		
		currUser = xristis1;
		//user to start is the user who entered first his name in the Name_Frame
		player1lbl = new JLabel();
		player2lbl = new JLabel();
		
		row1 = 1;
		row2 = 1;
		//setting the rows to start
		
		playerX = 0;
		playerY = 0;
		//setting the initial coordinates for the players figure
		//common for both players
		
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
		//managing the frame
		
	
	
		
		///////////////////////////
		playersPanel = new JPanel();
		back.add(playersPanel, BorderLayout.EAST);
		
		//coin function
		//it chooses whether the player is going to play a puzzle or a duel
		coinlbl = new JButton();
		coinlbl.setBorder(null);
		coinlbl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				soundthread2.StopMusic();
				
				soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat() ); //Sound: corona_h_grammata
				coin = r.nextInt(2);
				played = true;
				if (coin == 1)
				{
					CharsOpponents opponent=getNextOpponent();
					//if the random is 1 the player will play a duel
					new DuelBoardFrame(currUser,opponent);soundthread2.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat() );
				}
				else
				{
					//if the random is 0 the player will play a puzzle
					//which puzzle is determined by another random
					puzzle = r.nextInt(9);
					//if puzzles added the 9 must be increased
					switch(puzzle)
					{
					//list of the available puzzles
					case 0: new AncientArcadeFrame(currUser);soundthread2.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat() );  break;
					case 1: new ClickMeFrame(currUser);soundthread2.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat() ); break;
					case 2: new HangmanFrame(currUser); soundthread2.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat() );break;
					case 3: new MemoryGameFrame(currUser);soundthread2.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat() ); break;
					case 4: new PicsHerosFrame(currUser);soundthread2.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat() ); break;
					case 5: new QuizFrame(currUser); soundthread2.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat() );break;
					case 6: new TelecubeFrame(currUser); soundthread2.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat() );break;
					case 7: new TicTacToeFrame(currUser); soundthread2.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat() );break;
					case 8: new Pics3(currUser); soundthread2.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat() );break;
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
		
		//dice function
		//starting to be disable --> if players wins it becomes enable
		dicelbl = new JButton();
		dicelbl.setBorder(null);
		dicelbl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				soundthread1.PlayMusic(list.get(1).getSongName(), list.get(1).getRepeat() ); 
				currUser.setWin(false);
				//turns the boolean that shows if the player has won false so not to be used again
				dice = r.nextInt(6) + 1;
				//+1 because random takes values from 0 and the moves must start from 1
				coinlbl.setEnabled(true);
				//set coinlabel enable again
				moveChar(getDice());
				myGlassPane.setXYCoordinates(playerX, playerY);
				myGlassPane.repaint();
				//repaint the bord with the changes
				if((players.size()) > 1)
				{
					//if there are 2 players must switch turn
					dicelbl.setEnabled(false);
					switchTurn();
				}
				else{
					//if there is one player just turn false the boolean that shows if he has played
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
		
		//current player image --> the big one
		heightSize = helpHeight / 4;
		hero1Label = new JLabel();
		helpImage = image.getImage();
		resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
		hero1Label.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		gbc_imageLabel.gridx = 0;
		gbc_imageLabel.gridy = 1;
		playersPanel.add(hero1Label, gbc_imageLabel);
		
		//second player image --> the small one
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
		
		//labels and buttons to show and increase stats
		
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
		
		//skillpoints let the player to increase stats --> depends on the xp
		
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
			//the second label is visible only in multiplayer mode
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
				soundthread2.StopMusic();
				//setting action to go backwords one frame
				Board.this.setVisible(false);
				new Pick_A_Hero(players, clip);
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
			//turn the current users win and played indicator false then switch the flag that shows which player
			//must play an finally switch current user
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
	public void populateOpponentsList(ArrayList<ImageIcon> list){
		chOp=new ArrayList<CharsOpponents>();
		name=new ArrayList<String>();
		int a=10,d=20,h=30;
		for(ImageIcon i: list){
			chOp.add(new CharsOpponents(i.getDescription(),a,d,h,i));
			a=a+5;
			d=d+5;
			h=h+5;
			
		}
	}
	public CharsOpponents getNextOpponent(){
		
		int i=0;
		
		
		CharsOpponents selected = chOp.get(i);
		
		if (name.size() == chOp.size())
		{
			name = new ArrayList<String>();
		}
	
		while ((name.contains(selected.getImage().getDescription()))&&(chOp.get(i).isDefeated())){
			
				i++;
				selected = chOp.get(i);
				if(selected.getImage().getDescription().equals("BOSS")){
					i=0;
					name=new ArrayList<String>();
					populateOpponentsList(currlist);
					selected=chOp.get(i);
				}
				
			}
		name.add(selected.getImage().getDescription());
		
		
		
	return selected;	
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
		//dimensions of the board
		private int xCoord = 0;
		private int yCoord = 0;
		//coordinates for player1
		private int x2Coord = 0;
		private int y2Coord = 0;
		//coordinates for player2
		
		public void setXYCoordinates(int xValue, int yValue) {
			//method to set coordinates according to players turn
			//for single mode the default is userTurn=2
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
			//setting the square dimension
			size = sqSize;
			
			for(int i = 0; i < ROWS; i++) 
			{
				for(int j = 0; j < COLUMNS; j++) 
				{
					//draw the squares
					int x = j * sqSize;
					int y = i * sqSize;
					g.setColor(Color.YELLOW);
					g.drawRect(x, y, sqSize, sqSize);
				}
			}
			updateStatLabels();
			//needed to change the values in every repaint
			
			if (currUser.getWin())
			{
				//if the user has won the quest then make visible the dice
				dicelbl.setEnabled(true);
				coinlbl.setEnabled(false);
			}
			else
			{
				//if the user has lost keep it disable and change turns
				dicelbl.setEnabled(false);
				if (players.size() > 1)
				{
					//needed because the repaint repeats in greater frequency than the player plays a quest
					if(currUser.isPlayed())
					switchTurn();
				}
			}
			
			//adding the players icons
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
				// if the player2 is the first figure to leave the square need to be adjusted because it looses
				// his coordinates, there is no problem if the player1 is the first figure to leave the square
			}		
		}
	}

	public class UpgradeSkillListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//setting the functions in upgrade stats buttons
			double health = currUser.getHealth();
			double attack = currUser.getDamage();
			double defence = currUser.getDefence();
			int skillpoints = currUser.getSkillpoints();
			if(skillpoints > 0)
			{
				//for every upgrade a skillpoint is out
				if(e.getSource() == plusLife)
				{
					health++;
					currUser.setHealth(health);
					skillpoints--;
					currUser.setSkillpointsUsed(currUser.getSkillpointsUsed()+1);
					currUser.setSkillpoints(skillpoints);
					skillpointlbl.setText("Πόντοι ικανότητας: " +currUser.getSkillpoints());
					life.setText("\u0396\u03C9\u03AE: "+currUser.getHealth());
				}
				else if(e.getSource() == plusAttack)
				{
					attack++;
					currUser.setDamage(attack);
					skillpoints--;
					currUser.setSkillpointsUsed(currUser.getSkillpointsUsed()+1);
					currUser.setSkillpoints(skillpoints);
					skillpointlbl.setText("Πόντοι ικανότητας: " +currUser.getSkillpoints());
					attacklbl.setText("\u0388\u03C0\u03AF\u03B8\u03B5\u03C3\u03B7: "+currUser.getDamage());
				}
				else if(e.getSource() == plusDefence)
				{
					defence++;
					currUser.setDefence(defence);
					skillpoints--;
					currUser.setSkillpointsUsed(currUser.getSkillpointsUsed()+1);
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
		//method to change the user images on board --> only in multiplayer 
		ImageIcon tempIcon = new ImageIcon();
		Icon i = hero1Label.getIcon();
		tempIcon = (ImageIcon)i;
		//big image icon
		Image tempImage = tempIcon.getImage();
		Image tempResizedImage = tempImage.getScaledInstance(hero2Label.getWidth(), hero2Label.getHeight(), 0);
		//resize big image
		switchTurn();
		//switch currentUser to take again the image without loss in analysis
		tempIcon = currUser.getImage();
		tempImage = tempIcon.getImage();
		hero2Label.setIcon(new ImageIcon(tempResizedImage));
		tempResizedImage = tempImage.getScaledInstance(hero1Label.getWidth(), hero1Label.getHeight(), 0);
		hero1Label.setIcon(new ImageIcon(tempResizedImage));
		
	}
	
	public int getDice(){
		//method to get the dice number
		return dice;
	}
	
	public void moveChar(int dice){
		//method to adjust the movement of figures on board
		if (userTurn == 2)
		{
			//current player is player1 --> default in single player mode
			playerX = player1lbl.getX();
			playerY = player1lbl.getY();
			row = row1;
			adjust = false;
			//no adjust will be needed --> works fine
		}
		else if(userTurn == 1)
		{
			//current player is player 2 --> only in multiplayer mode
			if(adjust)
			{
				//if adjust is needed coordinates must be changed
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
			//actual move of the figure
			if (row % 2 == 0)
			{
				//if the row is mod 2 --> move from right to left
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
						//movement for the last square in order to stop in the last position
						i = dice;
						playerX = 0;
						//playerY = playerY;
						CharsOpponents boss=null;
						for(CharsOpponents ch:chOp){
							if(ch.getImage().getDescription().equals("BOSS")){
								boss=ch;
								new DuelBoardFrame(currUser,boss);
							}
						}
						
						
						Board.this.setVisible(false);
						//new Start_Frame(clip);
					
						}
				}
			}
			else
			{
				//if the row is not mod 2 --> move from left to right
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
