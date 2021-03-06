import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class DuelBoardFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private User currUser;
	private CharsOpponents currOpponent;
	private ArrayList<Weapons> usersWeapons;
	private JLabel heroLabel, opponentLabel, heroLifeLabel, opponentLifeLabel, heroDamageLabel, opponentDamageLabel, heroDefenceLabel, opponentDefenceLabel,
	swordLevel, bowLevel, spearLevel, swordPrice, bowPrice, spearPrice;
	private JButton swordBt, bowBt, spearBt, buyBow, buySpear, upgradeSword, upgradeBow, upgradeSpear;
	private JPanel heroPanel, opponentPanel;
	private int widthSize, heightSize, helpWidth, helpHeight;
	private boolean hit;
	//shows if the player has already attacked
	private MyGlassPane myGlassPane;
	private ArrayList<AudiosPair> list;
	private Sound_Thread soundthread1, soundthread2;//Thread 1 gia mikrous hxous, pou diakoptei o enas ton allon, Thread 2 gia soundtrack
	private double frameWidth, frameHeight, temphealth; //temphealth everytime gets the current health of the player hero
	private BackgroundPanel back;
	private Image background, resize, helpImage;
	private ImageIcon helpIcon;
	private static Clip clip;
	private static AudioInputStream audio;

	public DuelBoardFrame(User user, Monsters c){
		currOpponent=(CharsOpponents)c;
		
		soundthread1 = new Sound_Thread();
		soundthread2 = new Sound_Thread();
		//managing sounds
		list = new ArrayList<AudiosPair>(new Audios().getDuelList());
		hit = false;
		//player = user;
		temphealth=user.getHealth();
		
		soundthread2.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat());   //Sound soundtrack

		setJMenuBar(new JMenuFrame().getMenu()); // Getting the Menu from the JMenuFrame
		
		try {
			background = ImageIO.read(new File("Duel\\background2.jpg"));
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
		
		currUser = user;
		usersWeapons = currUser.getWeapons();
		//get user and the weapon list
		
		myGlassPane = new MyGlassPane();
		this.setGlassPane(myGlassPane);
		myGlassPane.setVisible(true);
		
		//////////////////////////////
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameWidth = screenSize.getWidth();
		frameHeight = screenSize.getHeight();
		helpWidth = (int)frameWidth;
		helpHeight = (int)frameHeight;
		widthSize = helpWidth / 7;
		heightSize = helpHeight / 3;
		//managing frame dimension 
		
		UpgradeButtonListener upgradeListener = new UpgradeButtonListener();
		buyButtonListener buyListener = new buyButtonListener();
		attackButtonListener attackListener = new attackButtonListener();
		//create button listeners
		
		//hero image and stat labels
		heroPanel = new JPanel();
		back.add(heroPanel, BorderLayout.WEST);
		GridBagLayout gbl_heroPanel = new GridBagLayout();
		widthSize = helpWidth / 25;
		gbl_heroPanel.rowHeights = new int[] {widthSize, 0, widthSize, widthSize, 0, widthSize, widthSize, widthSize, 0};
		heroPanel.setLayout(gbl_heroPanel);
		
		heroLabel = new JLabel();
		helpIcon = currUser.getImage();
		helpImage = helpIcon.getImage();
		widthSize = helpWidth / 7;
		resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
		heroLabel.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_heroLabel = new GridBagConstraints();
		gbc_heroLabel.gridheight = 3;
		gbc_heroLabel.insets = new Insets(0, 0, 0, 5);
		gbc_heroLabel.gridx = 0;
		gbc_heroLabel.gridy = 0;
		heroPanel.add(heroLabel, gbc_heroLabel);
		
		heroLifeLabel = new JLabel("���: ");
		heroLifeLabel.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		heroLifeLabel.setForeground(Color.RED);
		GridBagConstraints gbc_heroLifeLabel = new GridBagConstraints();
		gbc_heroLifeLabel.fill = GridBagConstraints.BOTH;
		gbc_heroLifeLabel.insets = new Insets(0, 0, 0, 5);
		gbc_heroLifeLabel.gridx = 0;
		gbc_heroLifeLabel.gridy = 5;
		heroPanel.add(heroLifeLabel, gbc_heroLifeLabel);	
				
		heroDamageLabel = new JLabel("�������: ");
		heroDamageLabel.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		heroDamageLabel.setForeground(Color.RED);
		GridBagConstraints gbc_heroDamageLabel = new GridBagConstraints();
		gbc_heroDamageLabel.fill = GridBagConstraints.BOTH;
		gbc_heroDamageLabel.insets = new Insets(0, 0, 0, 5);
		gbc_heroDamageLabel.gridx = 0;
		gbc_heroDamageLabel.gridy = 6;
		heroPanel.add(heroDamageLabel, gbc_heroDamageLabel);
		
		heroDefenceLabel = new JLabel("�����: ");
		heroDefenceLabel.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		heroDefenceLabel.setForeground(Color.RED);
		GridBagConstraints gbc_heroDefenceLabel = new GridBagConstraints();
		gbc_heroDefenceLabel.fill = GridBagConstraints.BOTH;
		gbc_heroDefenceLabel.gridx = 0;
		gbc_heroDefenceLabel.gridy = 7;
		heroPanel.add(heroDefenceLabel, gbc_heroDefenceLabel);
		
		widthSize = helpWidth / 8;
		heightSize = helpHeight / 8;
		
		//weapon buttons --> upgrade weapon buttons --> buy weapon buttons
		//the sword only upgrades --> player starts by default having one
		swordBt = new JButton();
		swordBt.addActionListener(attackListener);
		swordBt.setBorder(null);
		helpIcon = new ImageIcon("Duel\\sword.jpeg");
		helpImage = helpIcon.getImage();
		resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
		swordBt.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_sword = new GridBagConstraints();
		gbc_sword.gridy = 0;
		gbc_sword.gridx = 1;
		gbc_sword.gridwidth = 2;
		heroPanel.add(swordBt, gbc_sword);
		
		upgradeSword = new JButton("����������");
		upgradeSword.addActionListener(upgradeListener);
		upgradeSword.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_upgradeSword = new GridBagConstraints();
		gbc_upgradeSword.fill = GridBagConstraints.BOTH;
		gbc_upgradeSword.gridy = 1;
		gbc_upgradeSword.gridx = 2;
		heroPanel.add(upgradeSword, gbc_upgradeSword);
		
		spearBt = new JButton();
		spearBt.addActionListener(attackListener);
		spearBt.setBorder(null);
		helpIcon = new ImageIcon("Duel\\spear.jpg");
		helpImage = helpIcon.getImage();
		resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
		spearBt.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_spear = new GridBagConstraints();
		gbc_spear.gridy = 8;
		gbc_spear.gridwidth = 2;
		gbc_spear.gridx = 1;
		heroPanel.add(spearBt, gbc_spear);
		
		buySpear = new JButton("�����");
		buySpear.addActionListener(buyListener);
		buySpear.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_buySpear = new GridBagConstraints();
		gbc_buySpear.fill = GridBagConstraints.BOTH;
		gbc_buySpear.gridy = 9;
		gbc_buySpear.gridx = 1;
		heroPanel.add(buySpear, gbc_buySpear);

		upgradeSpear = new JButton("����������");
		upgradeSpear.addActionListener(upgradeListener);
		upgradeSpear.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_upgradeSpear = new GridBagConstraints();
		gbc_upgradeSpear.fill = GridBagConstraints.BOTH;
		gbc_upgradeSpear.gridy = 9;
		gbc_upgradeSpear.gridx = 2;
		heroPanel.add(upgradeSpear, gbc_upgradeSpear);
		
		bowBt = new JButton();
		bowBt.addActionListener(attackListener);
		bowBt.setBorder(null);
		helpIcon = new ImageIcon("Duel\\Bow.jpg");
		helpImage = helpIcon.getImage();
		resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
		bowBt.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_bow = new GridBagConstraints();
		gbc_bow.gridy = 3;
		gbc_bow.gridwidth = 2;
		gbc_bow.gridx = 1;
		heroPanel.add(bowBt, gbc_bow);
		
		buyBow = new JButton("�����");
		buyBow.addActionListener(buyListener);
		buyBow.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_buyBow = new GridBagConstraints();
		gbc_buyBow.fill = GridBagConstraints.BOTH;
		gbc_buyBow.gridy = 4;
		gbc_buyBow.gridx = 1;
		heroPanel.add(buyBow, gbc_buyBow);

		upgradeBow = new JButton("����������");
		upgradeBow.addActionListener(upgradeListener);
		upgradeBow.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_upgradeBow = new GridBagConstraints();
		gbc_upgradeBow.fill = GridBagConstraints.BOTH;
		gbc_upgradeBow.gridy = 4;
		gbc_upgradeBow.gridx = 2;
		heroPanel.add(upgradeBow, gbc_upgradeBow);
		
		//labels showing the level and the price for next level
		int lvls = 0, lvlsp = 0, lvlb = 0;
		int priceS = 0, priceSp = 0, priceB = 0;
		
		for(Weapons w:currUser.getWeapons()){
			if(w.getWeaponType().equals("Sword")){
				lvls = w.getLevel();
				priceS = w.getPrice();
			}
			if(w.getWeaponType().equals("CrossBow")){
				lvlb = w.getLevel();
				priceB = w.getPrice();
			}
			if(w.getWeaponType().equals("Spear")){
				lvlsp = w.getLevel();
				priceSp = w.getPrice();
			}
		}
		swordLevel = new JLabel("�������: "+lvls);
		swordLevel.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		swordLevel.setForeground(Color.ORANGE);
		GridBagConstraints gbc_swordLevel = new GridBagConstraints();
		gbc_swordLevel.gridy = 0;
		gbc_swordLevel.gridx = 3;
		heroPanel.add(swordLevel, gbc_swordLevel);
		
		swordPrice = new JLabel("����: "+priceS);
		swordPrice.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		swordPrice.setForeground(Color.ORANGE);
		GridBagConstraints gbc_swordPrice = new GridBagConstraints();
		gbc_swordPrice.gridy = 1;
		gbc_swordPrice.gridx = 3;
		heroPanel.add(swordPrice, gbc_swordPrice);
		
		bowLevel = new JLabel("�������: "+lvlb);
		bowLevel.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		bowLevel.setForeground(Color.ORANGE);
		GridBagConstraints gbc_bowLevel = new GridBagConstraints();
		gbc_bowLevel.gridy = 3;
		gbc_bowLevel.gridx = 3;
		heroPanel.add(bowLevel, gbc_bowLevel);
		
		bowPrice = new JLabel("����: "+priceB);
		bowPrice.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		bowPrice.setForeground(Color.ORANGE);
		GridBagConstraints gbc_bowPrice = new GridBagConstraints();
		gbc_bowPrice.gridy = 4;
		gbc_bowPrice.gridx = 3;
		heroPanel.add(bowPrice, gbc_bowPrice);
		
		spearLevel = new JLabel("�������: "+lvlsp);
		spearLevel.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		spearLevel.setForeground(Color.ORANGE);
		GridBagConstraints gbc_spearLevel = new GridBagConstraints();
		gbc_spearLevel.gridy = 8;
		gbc_spearLevel.gridx = 3;
		heroPanel.add(spearLevel, gbc_spearLevel);
		
		spearPrice = new JLabel("����: "+priceSp);
		spearPrice.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		spearPrice.setForeground(Color.ORANGE);
		GridBagConstraints gbc_spearPrice = new GridBagConstraints();
		gbc_spearPrice.gridy = 9;
		gbc_spearPrice.gridx = 3;
		heroPanel.add(spearPrice, gbc_spearPrice);
		
		///////////////////////////
		widthSize = helpWidth / 7;
		heightSize = helpHeight / 3;
		
		//opponents pic and label stats
		opponentPanel = new JPanel();
		back.add(opponentPanel, BorderLayout.EAST);
		
		GridBagLayout gbl_opponentPanel = new GridBagLayout();
		widthSize = helpWidth / 25;
		gbl_opponentPanel.rowHeights = new int[] {widthSize, widthSize, widthSize, widthSize, widthSize, widthSize, widthSize, widthSize, widthSize};
		opponentPanel.setLayout(gbl_opponentPanel);
				
		opponentLabel = new JLabel();
		helpIcon=currOpponent.getImage();
		helpImage = helpIcon.getImage();
		widthSize = helpWidth / 7;
		resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
		opponentLabel.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_opponentLabel = new GridBagConstraints();
		gbc_opponentLabel.fill = GridBagConstraints.BOTH;
		gbc_opponentLabel.insets = new Insets(0, 0, 0, 5);
		gbc_opponentLabel.gridx = 0;
		gbc_opponentLabel.gridy = 0;
		opponentPanel.add(opponentLabel, gbc_opponentLabel);
		
		opponentLifeLabel = new JLabel("���: ");
		opponentLifeLabel.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		opponentLifeLabel.setForeground(Color.RED);
		GridBagConstraints gbc_opponentLifeLabel = new GridBagConstraints();
		gbc_opponentLifeLabel.fill = GridBagConstraints.BOTH;
		gbc_opponentLifeLabel.insets = new Insets(0, 0, 0, 5);
		gbc_opponentLifeLabel.gridx = 0;
		gbc_opponentLifeLabel.gridy = 3;
		opponentPanel.add(opponentLifeLabel, gbc_opponentLifeLabel);
				
		opponentDamageLabel = new JLabel("�������: ");
		opponentDamageLabel.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		opponentDamageLabel.setForeground(Color.RED);
		GridBagConstraints gbc_opponentDamageLabel = new GridBagConstraints();
		gbc_opponentDamageLabel.fill = GridBagConstraints.BOTH;
		gbc_opponentDamageLabel.insets = new Insets(0, 0, 0, 5);
		gbc_opponentDamageLabel.gridx = 0;
		gbc_opponentDamageLabel.gridy = 4;
		opponentPanel.add(opponentDamageLabel, gbc_opponentDamageLabel);
		
		opponentDefenceLabel = new JLabel("�����: ");
		opponentDefenceLabel.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		opponentDefenceLabel.setForeground(Color.RED);
		GridBagConstraints gbc_opponentDefenceLabel = new GridBagConstraints();
		gbc_opponentDefenceLabel.fill = GridBagConstraints.BOTH;
		gbc_opponentDefenceLabel.gridx = 0;
		gbc_opponentDefenceLabel.gridy = 5;
		opponentPanel.add(opponentDefenceLabel, gbc_opponentDefenceLabel);
		
		updateWeaponStats();
	}

	public void updateWeaponStats(){
		//get current users weapons levels and prices
		for (Weapons w: currUser.getWeapons()){
			if (w.getWeaponType().equals("Sword"))
			{
				swordLevel.setText("�������: "+w.getLevel());
				swordPrice.setText("����: "+w.getPrice());
			}
			
			else if(w.getWeaponType().equals("CrossBow"))
			{
				bowLevel.setText("�������: "+w.getLevel());
				bowPrice.setText("����: "+w.getPrice());
			}
			
			else if(w.getWeaponType().equals("Spear"))
			{
				spearLevel.setText("�������: "+w.getLevel());
				spearPrice.setText("����: "+w.getPrice());
			}
		}
	}

	public boolean checkIfWeaponExists(Weapons w){
		//check if the weapon already exists in the list
		//a weapon can be bought only once --> can't upgrade if not been bought
		String type = w.getWeaponType();
		for(Weapons we: usersWeapons)
		{
			if (type.equals(we.getWeaponType()))
				return true;
		}
		return false;
	}

	public boolean checkIfDead(CharsOpponents c){
		//check if the opponents life is below zero --> players wins the duel
		double remainHealth;
		remainHealth = c.getHealth();
		if(remainHealth <= 0)
		{
			if(c.getImage().getDescription().equals("BOSS")){
				int pane = JOptionPane.showConfirmDialog(null, "������ �� ������� ��� ��� ����?", "", JOptionPane.YES_NO_OPTION);
				if(pane == JOptionPane.YES_OPTION){
					try {
					audio = AudioSystem.getAudioInputStream(new File("Sounds\\battle_theme.wav").getAbsoluteFile());
					clip = AudioSystem.getClip();
					clip.open(audio);
					clip.loop(Clip.LOOP_CONTINUOUSLY);
					new Name_Frame(clip);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			else
				JOptionPane.showMessageDialog(null, "�������� �� ����.", "����� �����", JOptionPane.INFORMATION_MESSAGE);
			c.setDefeated(true);
			currUser.setWin(true);
			currUser.setPlayed(true);
			currUser.setCoins(currUser.getCoins() + 1000);
			currUser.setXP(currUser.getXP() + 1000);
			currUser.increaseSkillPoints(currUser.getXP(), currUser.getSkillpoints());
			DuelBoardFrame.this.setVisible(false);
			soundthread2.StopMusic();
			
			return true;
		}			
		else
		{
			return false;
		}
	}

	public void opponentsAttack(User u, CharsOpponents c){
		//managing automatic hit by the opponent --> only after player has already hit
		if (hit)
		{
			double attack = c.getDamage();
			if(attack-u.getDefence()>0)
				temphealth=temphealth-(attack-u.getDefence());
			else
				temphealth=temphealth-(attack/2);
			hit = false;
			myGlassPane.repaint();
			if (temphealth <= 0)
			{
				//check if players life is below zero --> player is defeated
				currUser.setWin(false);
				currUser.setPlayed(true);
				JOptionPane.showMessageDialog(null, "������ �� ����.", "����� �����", JOptionPane.ERROR_MESSAGE);
				DuelBoardFrame.this.setVisible(false);
				soundthread2.StopMusic();
			}
		}
	}

	public class MyGlassPane extends JComponent{
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(Color.YELLOW);
			//drawing the bars according to stats
			int xhLifeRec = heroPanel.getX() + 60;
			int yhLifeRec = heroLifeLabel.getY() + heroLifeLabel.getHeight() - heroLifeLabel.getHeight() / 5;
			int recWidthL = (int)temphealth;
			if(recWidthL<0)
				recWidthL=0;
			g.fillRect(xhLifeRec, yhLifeRec, recWidthL, 10);
			
			int xoLifeRec = opponentPanel.getX() + 60;
			int yoLifeRec = opponentLifeLabel.getY() + opponentLifeLabel.getHeight() - opponentLifeLabel.getHeight() / 5;
			int recWidthOpL = (int)currOpponent.getHealth();
			if(recWidthOpL<0)
				recWidthOpL=0;
			g.fillRect(xoLifeRec, yoLifeRec, recWidthOpL , 10);

			int xhDamRec = heroPanel.getX() + 90;
			int yhDamRec = heroDamageLabel.getY() + heroDamageLabel.getHeight() - heroDamageLabel.getHeight() / 5;
			int recWidthA = (int)currUser.getDamage();
			g.fillRect(xhDamRec, yhDamRec, recWidthA, 10);

			int xoDamRec = opponentPanel.getX() + 90;
			int yoDamRec = opponentDamageLabel.getY() + opponentDamageLabel.getHeight() - opponentDamageLabel.getHeight() / 5;
			int recWidthOpA = (int)currOpponent.getDamage();
			g.fillRect(xoDamRec, yoDamRec, recWidthOpA, 10);

			int xhDefRec = heroPanel.getX() + 80;
			int yhDefRec = heroDefenceLabel.getY() + heroDefenceLabel.getHeight() - heroDefenceLabel.getHeight() / 5;
			int recWidthD = (int)currUser.getDefence();
			g.fillRect(xhDefRec, yhDefRec, recWidthD, 10);

			int xoDefRec = opponentPanel.getX() + 80;
			int yoDefRec = opponentDefenceLabel.getY() + opponentDefenceLabel.getHeight() - opponentDefenceLabel.getHeight() / 5;
			int recWidthOpD = (int)currOpponent.getDefence();
			g.fillRect(xoDefRec, yoDefRec, recWidthOpD, 10);
		}
	}

  class UpgradeButtonListener implements ActionListener {
		    //method to upgrade weapons
		    @Override
		    public void actionPerformed(ActionEvent e) {
		      if(e.getSource()==upgradeSword){
		        usersWeapons=currUser.getWeapons();
		        for(Weapons w: usersWeapons){
		          if(w.getWeaponType()=="Sword"){
		            w.upgradeWeapon(currUser, w);
		            updateWeaponStats();
		          }
		        }
		      }
		
		      if(e.getSource()==upgradeBow){
		        usersWeapons=currUser.getWeapons();
		        for(Weapons w: usersWeapons){
		          if(w.getWeaponType()=="CrossBow"){
		            w.upgradeWeapon(currUser, w);
		            updateWeaponStats();
		          }
		        }
		      }
		
		      if(e.getSource()==upgradeSpear){
		        usersWeapons=currUser.getWeapons();
		        for(Weapons w: usersWeapons){
		          if(w.getWeaponType()=="Spear"){
		            w.upgradeWeapon(currUser, w);
		            updateWeaponStats();
		          }
		        }
		      }
		 }
		} 

	public class buyButtonListener implements ActionListener{
		//buy weapons -- > only if weapons do not exists
		public void actionPerformed(ActionEvent e) {
			soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat());   //Sound buy
			
			if(e.getSource() == buyBow)
			{				
				CrossBow b = new CrossBow();
				b.buyWeapons(currUser, b);
				b.setLevel(1);
				updateWeaponStats();
				}
			if(e.getSource() == buySpear)
			{
				Spear s = new Spear();
				s.buyWeapons(currUser, s);
				s.setLevel(1);
				updateWeaponStats();
			}
		}
	}

	class attackButtonListener implements ActionListener{
		    //method for the player to attack
		int weapondamage;
		    TimerBeep timer;
		    public void actionPerformed(ActionEvent e) {
		
		    if(!hit){
		      //the player can't hit twice unless the opponent attacks back
		
		    if(e.getSource()==swordBt)
		    {
		    	usersWeapons=currUser.getWeapons();
	    		for(Weapons w:usersWeapons){
	    			if(w.getWeaponType().equals("Sword")){
	    				weapondamage=w.getDamage();
	    			}
	    		}
	    		if(((currUser.getDamage()+weapondamage/5))-(currOpponent.getDefence()/2)>0){
	    			currOpponent.setHealth((currOpponent.getHealth())-(((currUser.getDamage()+weapondamage))-(currOpponent.getDefence()/2)));
	    			}
	    		else
	    			currOpponent.setHealth((currOpponent.getHealth())-(((currUser.getDamage()+weapondamage))/2));
	    			    	
		      JOptionPane.showMessageDialog(null, "������� �� �����.", "�������", JOptionPane.INFORMATION_MESSAGE);
		      currOpponent.setHealth((currOpponent.getHealth())-10);
		      myGlassPane.repaint();
		      checkIfDead(currOpponent);
		      hit = true;      
		    }
		    if (e.getSource()==bowBt)
		    {
		    	if(checkIfWeaponExists(new CrossBow()))
		    	{        
		    		JOptionPane.showMessageDialog(null,"������� �� ����.", "�������", JOptionPane.INFORMATION_MESSAGE);
		    		usersWeapons=currUser.getWeapons();
		    		for(Weapons w:usersWeapons){
		    			if(w.getWeaponType().equals("CrossBow")){
		    				weapondamage=w.getDamage();
		    			}
		    		}
		    		if(((currUser.getDamage()+weapondamage)/4)-(currOpponent.getDefence()/2)>0){
		    			currOpponent.setHealth((currOpponent.getHealth())-(((currUser.getDamage()+weapondamage)/5)-(currOpponent.getDefence()/2)));
		    			}
		    		else
		    			currOpponent.setHealth((currOpponent.getHealth())-(((currUser.getDamage()+weapondamage)/5)/2));
		    		myGlassPane.repaint();
		    		checkIfDead(currOpponent);
		    		hit=true;
		        }
		    	else
		    	{
		    		JOptionPane.showMessageDialog(null,"������� ���� ����.", "����", JOptionPane.WARNING_MESSAGE);
		    	}
		    }
		    if(e.getSource()==spearBt)
		    {
		    	Spear s=new Spear();
		    	if(checkIfWeaponExists(s))
		    	{
		    		
		    		usersWeapons=currUser.getWeapons();
		    		for(Weapons w:usersWeapons){
		    			if(w.getWeaponType().equals("Spear")){
		    				weapondamage=w.getDamage();
		    			}
		    		}
		    		if(((currUser.getDamage()+weapondamage)/4)-(currOpponent.getDefence()/2)>0){
		    			currOpponent.setHealth((currOpponent.getHealth())-(((currUser.getDamage()+weapondamage)/5)-(currOpponent.getDefence()/2)));
		    			}
		    		else
		    			currOpponent.setHealth((currOpponent.getHealth())-(((currUser.getDamage()+weapondamage)/5)/2));JOptionPane.showMessageDialog(null, "������� �� ����.", "�������", JOptionPane.INFORMATION_MESSAGE);
		    		
		    		myGlassPane.repaint();
		    		checkIfDead(currOpponent);
		    		hit=true;      
		    	}
		    	else
		    	{
		    		JOptionPane.showMessageDialog(null,"������� ���� ����.", "����", JOptionPane.WARNING_MESSAGE);
		    	}
		    }
		       
		    if ((hit)&&(!checkIfDead(currOpponent)))
		      timer=new TimerBeep();
		    //the hit variable is true if the player has already attacked the opponent and it becomes false if the opponent hit the player
		    //the opponent attacks only if the player has attacked before
		    }
		    else
		      JOptionPane.showMessageDialog(null, "It 's not your turn");
		
		    }
		
		  }
		
		
	public class TimerBeep extends Timer{
		Timer timer;
		TimerTask task;

		public TimerBeep() {
			timer = new Timer();
			timer.schedule(new TimerTask(){
				public void run() {
					opponentsAttack(currUser,currOpponent);
				}
			},3000);
		}
	}
}