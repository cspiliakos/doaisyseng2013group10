import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;






public class DuelBoardFrame extends JFrame {
	private User currUser;
	private ArrayList<Weapons> usersWeapons;
	
	private JLabel ourHerolbl;
	private JLabel oppHerolbl;
	private JLabel backlbl;
	private JButton swordBt;
	private JButton crossBowBt;
	private JButton spearBt;
	private JButton quitBt;
	
	private JLabel heroLifelbl;
	private JLabel oppLifelbl;
	private JLabel heroDamagelbl;
	private JLabel oppDamagelbl;
	private JLabel heroDeflbl;
	private JLabel oppDeflbl;
	
	private JButton buyBow;
	private JButton buySpear;
	private JButton upgradeSword;
	private JButton upgradeBow;
	private JButton upgradeSpear;
	
	private Image background;
	private JPanel herolblPanel;
	private JPanel opplblPanel;
	
	private int widthSize;
	private int heightSize;
	
	
	
	private JPanel mainPanel;
	
	private MyGlassPane myGlassPane;
	
	
	public DuelBoardFrame(User user){
		
		//make the frame full screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double fwidth = screenSize.getWidth();
		double fheight = screenSize.getHeight();
		
		int iwidth=(int)fwidth;
		int iheight=(int)fheight;
		this.setUndecorated(true);
		this.setLocation(0,0);
		
		widthSize=iwidth/20;
		heightSize=iheight/10;
		
		
		currUser=user;
		usersWeapons=new ArrayList<Weapons>();
				
		myGlassPane=new MyGlassPane();
		this.setGlassPane(myGlassPane);
		myGlassPane.setVisible(true);
		
		
		quitBt=new JButton("Quit");
		QuitListener ql=new QuitListener();
		quitBt.addActionListener(ql);
		
				
		setBounds(100, 100, iwidth, iheight);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		//dhmiourgia kentrikou panel

		ImageIcon spearIcon=new ImageIcon("spear.jpg");
		Image spearImage=spearIcon.getImage();
		spearBt=new JButton();
		spearBt.setBounds((5*widthSize),(7*heightSize), (2*widthSize), heightSize);
		Image spearResizedImage=spearImage.getScaledInstance(spearBt.getWidth(), spearBt.getHeight(), 0);
		spearBt.setIcon(new ImageIcon(spearResizedImage));
		mainPanel.add(spearBt);
		//dhmiourgia koumpiou gia spear
		
		buySpear=new JButton("Buy");
		buySpear.setBounds(spearBt.getX(),(spearBt.getY()+spearBt.getHeight()),(spearBt.getWidth()/2),(heightSize/2));
		mainPanel.add(buySpear);
		
		upgradeSpear=new JButton("Upgrade");
		upgradeSpear.setBounds((spearBt.getX()+buySpear.getWidth()),(spearBt.getY()+spearBt.getHeight()),(spearBt.getWidth()/2),(heightSize/2));
		mainPanel.add(upgradeSpear);
		
		ImageIcon bowIcon=new ImageIcon("Bow.jpg");
		Image bowImage=bowIcon.getImage();
		crossBowBt=new JButton();
		crossBowBt.setBounds((5*widthSize),(4*heightSize),(2*widthSize), heightSize);
		Image bowResizedImage=bowImage.getScaledInstance(crossBowBt.getWidth(), crossBowBt.getHeight(), 0);
		crossBowBt.setIcon(new ImageIcon(bowResizedImage));
		mainPanel.add(crossBowBt);
		//dhmiourgia koumpiou gia bow
		
		buyBow=new JButton("Buy");
		buyBow.setBounds(crossBowBt.getX(),(crossBowBt.getY()+crossBowBt.getHeight()),(crossBowBt.getWidth()/2),(heightSize/2));
		mainPanel.add(buyBow);
		
		upgradeBow=new JButton("Upgrade");
		upgradeBow.setBounds((crossBowBt.getX()+buyBow.getWidth()),(crossBowBt.getY()+crossBowBt.getHeight()),(crossBowBt.getWidth()/2),(heightSize/2));
		mainPanel.add(upgradeBow);
		
		ImageIcon swordIcon=new ImageIcon("sword.jpeg");
		Image swordImage=swordIcon.getImage();
		swordBt=new JButton();
		swordBt.setBounds((5*widthSize),(heightSize),(2*widthSize),heightSize);
		Image swordResizedImage=swordImage.getScaledInstance(swordBt.getWidth(), swordBt.getHeight(), 0);
		swordBt.setIcon(new ImageIcon(swordResizedImage));
		mainPanel.add(swordBt);
		//dhmiourgia koumpiou gia sword
		
		upgradeSword=new JButton("Upgrade");
		upgradeSword.setBounds((swordBt.getX()+(swordBt.getWidth()/2)),(swordBt.getY()+swordBt.getHeight()),(swordBt.getWidth()/2),(heightSize/2));
		mainPanel.add(upgradeSword);
		
		
		
		
		ImageIcon  heroIcon=new  ImageIcon("Myrmidon.jpg");
		Image heroImage=heroIcon.getImage();
		ourHerolbl=new JLabel();
		ourHerolbl.setBounds(widthSize,(2*heightSize),(3*widthSize),(3*heightSize));
		Image heroResizedImage = heroImage.getScaledInstance(ourHerolbl.getWidth(), ourHerolbl.getHeight(), 0);
		ourHerolbl.setIcon(new ImageIcon(heroResizedImage));
		mainPanel.add(ourHerolbl);
		//eikona xarakthra
		
		//panel for hero stats
		herolblPanel=new JPanel(new GridLayout(3,1));
		herolblPanel.setBounds(widthSize,(6*heightSize),widthSize,(3*heightSize));
		
		
		heroLifelbl=new JLabel("Life: ");
		heroLifelbl.setForeground(Color.RED);
		herolblPanel.add(heroLifelbl);
		//label Life tou xarakthra		
		
		heroDamagelbl=new JLabel("Damage: ");
		heroDamagelbl.setForeground(Color.RED);
		herolblPanel.add(heroDamagelbl);
		//label Damage tou xarakthra mono to damage pou proerxetai apo ta skill
		
		heroDeflbl=new JLabel("Defence: ");
		heroDeflbl.setForeground(Color.RED);
		herolblPanel.add(heroDeflbl);
		//label gia to Defence tou xarakthra
		
		herolblPanel.setOpaque(false);
		//gia na mhn emfanizetai to gkri tou panel
		
		mainPanel.add(herolblPanel);
		
		ImageIcon  opponentIcon=new  ImageIcon("opponent.jpg");
		Image opponentImage=opponentIcon.getImage();
		oppHerolbl=new JLabel();
		oppHerolbl.setBounds((16*widthSize),(2*heightSize),(3*widthSize),(3*heightSize));
		Image opponentResizedImage = opponentImage.getScaledInstance(oppHerolbl.getWidth(), oppHerolbl.getHeight(), 0);
		oppHerolbl.setIcon(new ImageIcon(opponentResizedImage));
		mainPanel.add(oppHerolbl);
		//eikona antipalou
		
		opplblPanel=new JPanel(new GridLayout(3,1));
		opplblPanel.setBounds((16*widthSize),(6*heightSize),(widthSize),(3*heightSize));
		oppLifelbl=new JLabel("Life: ");
		oppLifelbl.setForeground(Color.RED);
		opplblPanel.add(oppLifelbl);
		//label gia to Life tou antipalou
		
		oppDamagelbl=new JLabel("Damage: ");
		oppDamagelbl.setForeground(Color.RED);
		opplblPanel.add(oppDamagelbl);
		//label gia to Damage tou antipalou einai eniaio den exei opla
		
		oppDeflbl=new JLabel("Defence: ");
		oppDeflbl.setForeground(Color.RED);
		opplblPanel.add(oppDeflbl);
		
		opplblPanel.setOpaque(false);
		
		mainPanel.add(opplblPanel);
		//label gia to Defence tou antipalou
		
		
		ImageIcon  background=new  ImageIcon("background2.jpg");
		Image image=background.getImage();
		backlbl=new JLabel();
		backlbl.setBounds(0,0,this.getWidth(), this.getHeight());
		Image resizedImage = image.getScaledInstance(backlbl.getWidth(), backlbl.getHeight(), 0);
		backlbl.setIcon(new ImageIcon(resizedImage));
		//prosarmogh eikonas fontou
		mainPanel.add(backlbl);
		
		UpgradeButtonListener upgradeListener = new UpgradeButtonListener();
		upgradeSword.addActionListener(upgradeListener);
		upgradeBow.addActionListener(upgradeListener);
		upgradeSpear.addActionListener(upgradeListener);
		
		
		buyButtonListener buyListener=new buyButtonListener();
		buyBow.addActionListener(buyListener);
		buySpear.addActionListener(buyListener);
		
		attackButtonListener attackListener=new attackButtonListener();
		swordBt.addActionListener(attackListener);
		crossBowBt.addActionListener(attackListener);
		spearBt.addActionListener(attackListener);
		this.setUndecorated(true);
		this.setLocation(0,0);
		this.setSize(iwidth,iheight);
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	class QuitListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			//check if this works
			
		}
		
	}
	
	class MyGlassPane extends JComponent{
		
		
		public void paintComponent(Graphics g) {
			//επικάλυψη της paintcomponent
			super.paintComponent(g);
			
			g.setColor(Color.YELLOW);
			
			//sxediasmos ths mparas dipla apo kathe label
			//to mhkos ths proxeira orizetai san arithmos kanonika tha pairnei san parametro to skill tou
			//xarakthra - isws xreiastei klimakwsh an ksefeygei poly se mhkos
			int xhLifeRec=herolblPanel.getX() + widthSize;
			int yhLifeRec=herolblPanel.getY()+(heightSize/2);
			int recWidthL=(int)currUser.getHealth();
			g.fillRect(xhLifeRec, yhLifeRec, recWidthL, 10);
			
			int xoLifeRec=opplblPanel.getX() + widthSize;
			int yoLifeRec=opplblPanel.getY()+(heightSize/2);
			g.fillRect(xoLifeRec, yoLifeRec, 110 , 10);
			
			int xhDamRec=herolblPanel.getX() + widthSize;
			int yhDamRec=herolblPanel.getY()+(heightSize+(heightSize/2));
			int recWidthA=(int)currUser.getAttack();
			g.fillRect(xhDamRec, yhDamRec, recWidthA, 10);
			
			int xoDamRec=opplblPanel.getX() + widthSize;
			int yoDamRec=opplblPanel.getY()+(heightSize+(heightSize/2));
			g.fillRect(xoDamRec, yoDamRec, 150, 10);
			
			int xhDefRec=herolblPanel.getX() + widthSize;
			int yhDefRec=herolblPanel.getY()+((2*heightSize)+(heightSize/2));
			int recWidthD=(int)currUser.getDefence();
			g.fillRect(xhDefRec, yhDefRec, recWidthD, 10);
			
			int xoDefRec=opplblPanel.getX() + widthSize;
			int yoDefRec=opplblPanel.getY()+((2*heightSize)+(heightSize/2));
			g.fillRect(xoDefRec, yoDefRec, 80, 10);
			
		}
		
	}
	
	class UpgradeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==upgradeSword){
				usersWeapons=currUser.getWeapons();
				for(Weapons w: usersWeapons){
					if(w.getWeaponType()=="Sword"){
						w.upgradeWeapon(currUser, w);
						System.out.println("sword "+w.level);
					}
				}
			}
			
			

			if(e.getSource()==upgradeBow){
				//System.out.println("You dont have a bow");
				usersWeapons=currUser.getWeapons();
				for(Weapons w: usersWeapons){
					if(w.getWeaponType()=="CrossBow"){
						w.upgradeWeapon(currUser, w);
						System.out.println("bow "+w.level);
					}
				}
			}
			
			

			if(e.getSource()==upgradeSpear){
				//System.out.println("You dont have a spear");
				usersWeapons=currUser.getWeapons();
				for(Weapons w: usersWeapons){
					if(w.getWeaponType()=="Spear"){
						w.upgradeWeapon(currUser, w);
						System.out.println("spear "+w.level);
					}
				}
			}
			
			
		
		}
		
		
	}
	
	class buyButtonListener implements ActionListener{
		

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==buyBow){				
			System.out.println("Buy a bow ?");
			CrossBow b=new CrossBow();
			b.buyWeapons(currUser, b);
			}
		if(e.getSource()==buySpear){
			System.out.println("Buy a spear ?");
			Spear s=new Spear();
			s.buyWeapons(currUser, s);
		}
		}
		
	}
	
	
	class attackButtonListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
		if(e.getSource()==swordBt){
			JOptionPane.showMessageDialog(null, "Attack with sword");
		}
		else if (e.getSource()==crossBowBt){
			JOptionPane.showMessageDialog(null,"Attack with bow");
		}
		else if(e.getSource()==spearBt){
			JOptionPane.showMessageDialog(null, "Attack with spear");
		}
			
		}
		
	}


	
}
	

