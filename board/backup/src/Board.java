import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	private JButton piso, plusLife, plusAttack, plusDefence;
	private JLabel title, imageLabel, attacklbl, defencelbl, life, coinlbl, dicelbl, hero2lbl, skillpointlbl, playerCoins, playerXP;
	private JLabel player1lbl, player2lbl;
	private Random r;
	private JPanel buttonPanel, imagePanel, quitPanel;
	private User xristis1, xristis2, currUser;
	private MyGlassPane myGlassPane;
	private int row1, row2, size, playerX, playerY, widthSize, heightSize;
	private BackgroundPanel back;
	@SuppressWarnings("unused")
	private Image background, hero, resize , hero2;
	private Clip clip;
	private AudioInputStream audio;
	private Pick_A_Hero pick;
	private DiceListener dlistener;
	private CoinListener clistener;
	private ImageIcon image, smallImage;
	private UpgradeSkillListener skillListener;
	private int sqSize, userTurn = 2;
	private ArrayList<User> players;
	
	private boolean adjust=false;
	//shows if the two players have been on the same square
	
	/**Sounds
	 * list.get(0) corona_h_grammata
	 * list.get(1) dice_roll
	 */
	ArrayList<AudiosPair> list = new ArrayList<AudiosPair>(new Audios().getBoardList());
	Sound_Thread soundthread1 = new Sound_Thread();
	
	public Board(ArrayList<User> p){
		setJMenuBar(new JMenuFrame().getMenu()); // Getting the Menu from the JMenuFrame
		
		players=new ArrayList<User>();
		players=p;
		xristis1 = players.get(0);
		image=xristis1.getImage();
		if ((players.size())>1){
			xristis2=players.get(1);
			smallImage=xristis2.getImage();
			}
		else
			smallImage=xristis1.getImage();
		
		currUser=xristis1;
		player1lbl=new JLabel();
		player2lbl=new JLabel();
		
		row1 = 1;
		row2=1;
		
		playerX = 0;
		playerY = 0;
		
		try {
			background = ImageIO.read(new File("Board\\background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		back = new BackgroundPanel(background);
		
		back.setLayout(null);
		
		try{
			audio = AudioSystem.getAudioInputStream(new File("Sounds\\battle_theme.wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		dlistener=new DiceListener();
		clistener=new CoinListener();
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double fwidth = screenSize.getWidth();
		double fheight = screenSize.getHeight();
		int iwidth = (int)fwidth;
		int iheight = (int)fheight;
		widthSize = iwidth / 20;
		heightSize = iheight / 10;
		
		//
		title = new JLabel("\u03A4\u03B1\u03BC\u03C0\u03BB\u03CC");
		title.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds((iwidth/2),5,(widthSize*2),(heightSize));
		
		myGlassPane = new MyGlassPane();
		this.setGlassPane(myGlassPane);
		myGlassPane.setVisible(true);
		
		
				
		//
		buttonPanel = new JPanel();
		GridLayout gbl_buttonPanel = new GridLayout(1,2);
		buttonPanel.setLayout(gbl_buttonPanel);
		
		buttonPanel.setBounds((widthSize*13),(heightSize*2),(widthSize*6),(heightSize*2));
		back.add(buttonPanel);
		
		ImageIcon  coin=new  ImageIcon("Board\\coin.gif");
		Image coinImage=coin.getImage();
		coinlbl=new JLabel();
		Image coinResizedImage = coinImage.getScaledInstance((buttonPanel.getWidth()/2), buttonPanel.getHeight(), 0);
		coinlbl.setIcon(new ImageIcon(coinResizedImage));
		buttonPanel.add(coinlbl);
		coinlbl.addMouseListener(clistener);
		
		ImageIcon dice=new ImageIcon("Board\\dice.gif");
		Image diceImage=dice.getImage();
		dicelbl=new JLabel();
		Image diceResizedImage= diceImage.getScaledInstance((buttonPanel.getWidth()/2),buttonPanel.getHeight(),0);
		dicelbl.setIcon(new ImageIcon(diceResizedImage));
		buttonPanel.add(dicelbl);
		dicelbl.addMouseListener(dlistener);
		
		imagePanel = new JPanel();
		imagePanel.setBounds((widthSize*13),(heightSize*4),(widthSize*6),(heightSize*5));
		GridBagLayout gbl_imagePanel = new GridBagLayout();
		imagePanel.setLayout(gbl_imagePanel);
		back.add(imagePanel);
		
		imageLabel = new JLabel();
		hero = image.getImage();
		resize = hero.getScaledInstance((widthSize*3), (heightSize*3), 0);
		imageLabel.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		gbc_imageLabel.fill=GridBagConstraints.HORIZONTAL;
		gbc_imageLabel.insets = new Insets(0, 0, 0, 5);
		gbc_imageLabel.gridx = 0;
		gbc_imageLabel.gridy = 0;
		//gbc_imageLabel.anchor=GridBagConstraints.FIRST_LINE_START;
		imagePanel.add(imageLabel, gbc_imageLabel);
		
		hero2lbl=new JLabel();
		Image hero2Image=smallImage.getImage();
		Image hero2ResizedImage= hero2Image.getScaledInstance((widthSize),(heightSize),0);
		hero2lbl.setIcon(new ImageIcon(hero2ResizedImage));
		GridBagConstraints gbc_hero2lbl=new GridBagConstraints();
		gbc_hero2lbl.insets=new Insets(0,(2*widthSize),0,0);
		gbc_hero2lbl.gridx=1;
		gbc_hero2lbl.gridy=0;
		gbc_hero2lbl.anchor=GridBagConstraints.FIRST_LINE_END;
		imagePanel.add(hero2lbl, gbc_hero2lbl);
		
		if((players.size())>1)
			hero2lbl.setVisible(true);
		else
			hero2lbl.setVisible(false);
		//only visible in multiplayer mode
		
		attacklbl = new JLabel("\u0388\u03C0\u03AF\u03B8\u03B5\u03C3\u03B7: "+currUser.getDamage());
		attacklbl.setForeground(Color.ORANGE);
		attacklbl.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_attack = new GridBagConstraints();
		gbc_attack.insets = new Insets(0, 0, 0, 5);
		gbc_attack.gridx = 0;
		gbc_attack.gridy = 1;
		imagePanel.add(attacklbl, gbc_attack);
		
		defencelbl = new JLabel("\u0386\u03BC\u03C5\u03BD\u03B1: "+currUser.getDefence());
		defencelbl.setForeground(Color.ORANGE);
		defencelbl.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_defence = new GridBagConstraints();
		gbc_defence.insets = new Insets(0, 0, 0, 5);
		gbc_defence.gridx = 0;
		gbc_defence.gridy = 2;
		imagePanel.add(defencelbl, gbc_defence);
		
		life = new JLabel("\u0396\u03C9\u03AE: "+currUser.getHealth());
		life.setForeground(Color.ORANGE);
		life.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_life = new GridBagConstraints();
		gbc_life.gridx = 0;
		gbc_life.gridy = 3;
		imagePanel.add(life, gbc_life);
		
		plusLife=new JButton("+");
		plusLife.setForeground(Color.ORANGE);
		plusLife.setBackground(Color.BLACK);
		plusLife.setFont(new Font("Sylfaen",Font.BOLD,30));
		GridBagConstraints c=new GridBagConstraints();
		c.gridx=1;
		c.gridy=3;
		imagePanel.add(plusLife,c);
		plusDefence=new JButton("+");
		plusDefence.setForeground(Color.ORANGE);
		plusDefence.setBackground(Color.BLACK);
		plusDefence.setFont(new Font("Sylfaen",Font.BOLD,30));
		c.gridx=1;
		c.gridy=2;
		imagePanel.add(plusDefence,c);
		plusAttack=new JButton("+");
		plusAttack.setForeground(Color.ORANGE);
		plusAttack.setBackground(Color.BLACK);
		plusAttack.setFont(new Font("Sylfaen",Font.BOLD,30));
		c.gridx=1;
		c.gridy=1;
		imagePanel.add(plusAttack,c);
		
		skillpointlbl=new JLabel("Skill Points \n"+currUser.getSkillpoints());
		skillpointlbl.setFont(new Font("Sylfaen",Font.BOLD,20));
		skillpointlbl.setForeground(Color.WHITE);
		c.gridx=1;
		c.gridy=4;
		imagePanel.add(skillpointlbl, c);
		
		playerCoins=new JLabel("Golden Coins: "+currUser.getCoins());
		playerCoins.setFont(new Font("Sylfaen",Font.BOLD,20));
		playerCoins.setForeground(Color.WHITE);
		c.gridx=0;
		c.gridy=5;
		imagePanel.add(playerCoins,c);
		
		playerXP=new JLabel("XP: "+currUser.getXP());
		playerXP.setFont(new Font("Sylfaen",Font.BOLD,20));
		playerXP.setForeground(Color.WHITE);
		c.gridx=0;
		c.gridy=6;
		imagePanel.add(playerXP,c);
		
		
		skillListener=new UpgradeSkillListener();
		plusLife.addActionListener(skillListener);
		plusDefence.addActionListener(skillListener);
		plusAttack.addActionListener(skillListener);
		
		
		r = new Random(System.currentTimeMillis());
		
		//
		quitPanel = new JPanel();
		quitPanel.setLayout(new BorderLayout(0, 0));
		
		piso = new JButton("\u03A0\u03AF\u03C3\u03C9");
		piso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip.stop();
				Board.this.setVisible(false);
				pick = new Pick_A_Hero(players);
				pick.setVisible(true);
			}
		});
		piso.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		quitPanel.add(piso, BorderLayout.WEST);
		quitPanel.setBounds((widthSize*18),(heightSize*9),(widthSize*2),(heightSize/2));
		back.add(quitPanel);
		
		back.setTransparentAdd(true);
		this.setVisible(true);
		this.setContentPane(back);
	}
	
	public void switchTurn(){
		//method to switch turns in multi player		
		if(userTurn==1){
			userTurn=2;
			currUser=xristis1;
		}
		else if (userTurn==2){
			userTurn=1;
			currUser=xristis2;
		}
		JOptionPane.showMessageDialog(null, currUser.getDamage());
		updateStatLabels();
	}
	
	public void updateStatLabels(){
		//for the values of the labels to be in accordance with the player 
		skillpointlbl.setText("Skill Points \n"+String.valueOf(currUser.getSkillpoints()));
		attacklbl.setText("\u0388\u03C0\u03AF\u03B8\u03B5\u03C3\u03B7: "+String.valueOf(currUser.getDamage()));
		defencelbl.setText("\u0386\u03BC\u03C5\u03BD\u03B1: "+String.valueOf(currUser.getDefence()));
		life.setText("\u0396\u03C9\u03AE: "+String.valueOf(currUser.getHealth()));
		playerCoins.setText("Golden Coins: "+(currUser.getCoins()));
		playerXP.setText("XP: "+(currUser.getXP()));
		}

	@SuppressWarnings("serial")
	class MyGlassPane extends JComponent{
		private static final int ROWS = 6;
		private static final int COLUMNS = 6;
		private int xCoord = 0;
		private int yCoord = 0;
		private int x2Coord=0;
		private int y2Coord=0;
		
		
		public void setXYCoordinates(int xValue, int yValue) {
			if (userTurn==2){
			xCoord = xValue;
			yCoord = yValue;
			}
			else if (userTurn==1){
				x2Coord=xValue;
				y2Coord=yValue;
			}
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			sqSize = this.getHeight() / ROWS;
			size = sqSize;
			
			for(int i = 0; i < ROWS; i++) {
				for(int j = 0; j < COLUMNS; j++) {
					int x = j * sqSize;
					int y = i * sqSize;
					g.setColor(Color.YELLOW);
					g.drawRect(x, y, sqSize, sqSize);
				}
			}
			updateStatLabels();
			
			player1lbl.setSize(sqSize,sqSize);
			ImageIcon p1icon=new ImageIcon("player1.gif");
			Image p1image=p1icon.getImage();
			//System.out.println(""+sqSize);
			Image p1ResizedImage=p1image.getScaledInstance(player1lbl.getWidth(), player1lbl.getHeight(), 0);
			player1lbl.setIcon(new ImageIcon(p1ResizedImage));
			player1lbl.setBounds(xCoord, yCoord, sqSize, sqSize);
			myGlassPane.add(player1lbl);
			
			
			
			player2lbl.setSize(sqSize,sqSize);
			ImageIcon p2icon=new ImageIcon("player3.gif");
			Image p2image=p2icon.getImage();
			//System.out.println(""+sqSize);
			Image p2ResizedImage=p2image.getScaledInstance(player2lbl.getWidth(), player2lbl.getHeight(), 0);
			player2lbl.setIcon(new ImageIcon(p2ResizedImage));
			player2lbl.setBounds(x2Coord, y2Coord, sqSize, sqSize);
			if ((players.size())>1){
				myGlassPane.add(player2lbl);
				checkSameSquare();
				
			}
			
		}	
	public void checkSameSquare(){
		//resize the players figure if both players are on the same square
		if (((player1lbl.getX())==(player2lbl.getX()))&&((player1lbl.getY())==(player2lbl.getY()))){
			player1lbl.setSize((sqSize/2),(sqSize));
			ImageIcon p1icon=new ImageIcon("player1.gif");
			Image p1image=p1icon.getImage();
			//System.out.println(""+sqSize);
			Image p1ResizedImage=p1image.getScaledInstance(player1lbl.getWidth(), player1lbl.getHeight(), 0);
			player1lbl.setIcon(new ImageIcon(p1ResizedImage));
			player1lbl.setBounds(xCoord, yCoord,(sqSize/2), (sqSize));
			
			
			player2lbl.setSize((sqSize/2),(sqSize));
			ImageIcon p2icon=new ImageIcon("player3.gif");
			Image p2image=p2icon.getImage();
			//System.out.println(""+sqSize);
			Image p2ResizedImage=p2image.getScaledInstance(player2lbl.getWidth(), player2lbl.getHeight(), 0);
			player2lbl.setIcon(new ImageIcon(p2ResizedImage));
			player2lbl.setBounds((x2Coord+(sqSize/2)),y2Coord,(sqSize/2),sqSize);
			
			adjust=true;
		}
		
		

			
	}
}

	class DiceListener implements MouseListener {

		int diceButton;
		int row;
		@Override
		public void mouseClicked(MouseEvent arg0) {
			//Sound: dice_roll
			soundthread1.PlayMusic(list.get(1).getSongName(), list.get(1).getRepeat() ); 
			
			diceButton = r.nextInt(6) + 1;
			System.out.println("zari "+diceButton);
			moveChar(getDice());
			myGlassPane.setXYCoordinates(playerX, playerY);

			myGlassPane.repaint();
			if((players.size())>1)
				switchChars();



		}

		public void switchChars(){			
			//tha kaleitai mono an paizoun 2 paixtes
			ImageIcon tempIcon=new ImageIcon();
			Icon i=imageLabel.getIcon();
			tempIcon=(ImageIcon)i;
			//apothikeyw to icon ths megalhs eikonas
			Image tempImage=tempIcon.getImage();
			Image tempResizedImage = tempImage.getScaledInstance(hero2lbl.getWidth(), hero2lbl.getHeight(), 0);
			//thn metasxhmatizw stis diastaseis tou mikrou label
			switchTurn();
			tempIcon=currUser.getImage();
			tempImage=tempIcon.getImage();
			hero2lbl.setIcon(new ImageIcon(tempResizedImage));
			tempResizedImage=tempImage.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(),0);
			imageLabel.setIcon(new ImageIcon(tempResizedImage));
			
			//allagh twn label me ta xarakthristika
			
		}
		
		public int getDice(){
			return diceButton;
		}
		
		public void moveChar(int dice){
			//int row;
			if (userTurn==2){
				playerX=player1lbl.getX();
				playerY=player1lbl.getY();
				row=row1;
				adjust=false;
			}
			else if(userTurn==1){
				if(adjust){
					playerX=(player2lbl.getX())-(sqSize/2);
				}
				else{
					playerX=player2lbl.getX();
				}
				
				playerY=player2lbl.getY();
				row=row2;
				
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
							JOptionPane.showMessageDialog(null, "End of Stage");
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
			
			if(userTurn==2){
				//dealing with players figure rows
				row1=row;
			}
			else if(userTurn==1){
				row2=row;
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

class CoinListener implements MouseListener {
	private int coin, puzzle;
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat() ); //Sound: corona_h_grammata
		coin = r.nextInt(2);
		if (coin == 1)
		{
			new DuelBoardFrame(currUser);
		}
		else
		{
			puzzle = r.nextInt(5);
			switch(puzzle)
			{
			case 1: new ClickMeFrame(currUser); break;
			case 2: new TelecubeFrame(currUser); break;
			case 3: new MemoryGameFrame(); break;
			case 4: new AncientArcadeFrame(); break;
			case 5: new QuizFrame(currUser); break;
			}
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

public class UpgradeSkillListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		double health=currUser.getHealth();
		double attack=currUser.getDamage();
		double defence=currUser.getDefence();
		int skillpoints=currUser.getSkillpoints();
		if(skillpoints>0){
			if(e.getSource()==plusLife){
				health++;
				currUser.setHealth(health);
				skillpoints--;
				currUser.setSkillpoints(skillpoints);
				skillpointlbl.setText("Skill Points" +currUser.getSkillpoints());
				life.setText("\u0396\u03C9\u03AE: "+currUser.getHealth());
			}
			else if(e.getSource()==plusAttack){
				attack++;
				currUser.setDamage(attack);
				skillpoints--;
				currUser.setSkillpoints(skillpoints);
				skillpointlbl.setText("Skill Points" +currUser.getSkillpoints());
				attacklbl.setText("\u0388\u03C0\u03AF\u03B8\u03B5\u03C3\u03B7: "+currUser.getDamage());
			}
			else if(e.getSource()==plusDefence){
				defence++;
				currUser.setDefence(defence);
				skillpoints--;
				currUser.setSkillpoints(skillpoints);
				skillpointlbl.setText("Skill Points" +currUser.getSkillpoints());
				defencelbl.setText("\u0386\u03BC\u03C5\u03BD\u03B1: "+currUser.getDefence());
			}
		}
		else
			JOptionPane.showMessageDialog(null,"You Don't Have Any Skill Points Available");
	}
	
}

}
