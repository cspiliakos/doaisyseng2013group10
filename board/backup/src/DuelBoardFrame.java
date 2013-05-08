import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class DuelBoardFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private User currUser;
	private CharsOpponents currOpponent;
	private ArrayList<Weapons> usersWeapons;
	private JLabel ourHerolbl, oppHerolbl, backlbl, heroLifelbl, oppLifelbl, heroDamagelbl, oppDamagelbl, heroDeflbl, oppDeflbl,
	swordlvl, bowlvl, spearlvl, swordPrice, bowPrice, spearPrice;
	private JButton swordBt, crossBowBt, spearBt, quitBt, buyBow, buySpear, upgradeSword, upgradeBow, upgradeSpear;
	private JPanel herolblPanel, opplblPanel, mainPanel;
	private int widthSize, heightSize;
	private boolean hit=false;	
	private MyGlassPane myGlassPane;
	private ArrayList<AudiosPair> list = new ArrayList<AudiosPair>(new Audios().getDuelList()); 
	private Sound_Thread soundthread1 = new Sound_Thread(); //Thread 1 gia mikrous hxous, pou diakoptei o enas ton allon
	private Sound_Thread soundthread2 = new Sound_Thread(); //Thread 2 gia soundtrack
	private User player;

	public DuelBoardFrame(User user){
		player = user;
		soundthread2.PlayMusic(list.get(2).getSongName(), list.get(2).getRepeat());   //Sound soundtrack

		currOpponent= new CharsOpponents ("Lernaia Ydra",80,15,30,new ImageIcon("battle_hydra_1.jpg"));
		setJMenuBar(new JMenuFrame().getMenu()); // Getting the Menu from the JMenuFrame
		
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

		ImageIcon spearIcon=new ImageIcon("Duel\\spear.jpg");
		Image spearImage=spearIcon.getImage();
		spearBt=new JButton();
		spearBt.setBounds((5*widthSize),(7*heightSize), (2*widthSize), heightSize);
		Image spearResizedImage=spearImage.getScaledInstance(spearBt.getWidth(), spearBt.getHeight(), 0);
		spearBt.setIcon(new ImageIcon(spearResizedImage));
		mainPanel.add(spearBt);
		//dhmiourgia koumpiou gia spear

		buySpear=new JButton("�����");
		buySpear.setBounds(spearBt.getX(),(spearBt.getY()+spearBt.getHeight()),(spearBt.getWidth()/2),(heightSize/2));
		mainPanel.add(buySpear);

		upgradeSpear=new JButton("����������");
		upgradeSpear.setBounds((spearBt.getX()+buySpear.getWidth()),(spearBt.getY()+spearBt.getHeight()),(spearBt.getWidth()/2),(heightSize/2));
		mainPanel.add(upgradeSpear);

		ImageIcon bowIcon=new ImageIcon("Duel\\Bow.jpg");
		Image bowImage=bowIcon.getImage();
		crossBowBt=new JButton();
		crossBowBt.setBounds((5*widthSize),(4*heightSize),(2*widthSize), heightSize);
		Image bowResizedImage=bowImage.getScaledInstance(crossBowBt.getWidth(), crossBowBt.getHeight(), 0);
		crossBowBt.setIcon(new ImageIcon(bowResizedImage));
		mainPanel.add(crossBowBt);
		//dhmiourgia koumpiou gia bow

		buyBow=new JButton("�����");
		buyBow.setBounds(crossBowBt.getX(),(crossBowBt.getY()+crossBowBt.getHeight()),(crossBowBt.getWidth()/2),(heightSize/2));
		mainPanel.add(buyBow);

		upgradeBow=new JButton("����������");
		upgradeBow.setBounds((crossBowBt.getX()+buyBow.getWidth()),(crossBowBt.getY()+crossBowBt.getHeight()),(crossBowBt.getWidth()/2),(heightSize/2));
		mainPanel.add(upgradeBow);

		ImageIcon swordIcon=new ImageIcon("Duel\\sword.jpeg");
		Image swordImage=swordIcon.getImage();
		swordBt=new JButton();
		swordBt.setBounds((5*widthSize),(heightSize),(2*widthSize),heightSize);
		Image swordResizedImage=swordImage.getScaledInstance(swordBt.getWidth(), swordBt.getHeight(), 0);
		swordBt.setIcon(new ImageIcon(swordResizedImage));
		mainPanel.add(swordBt);
		//dhmiourgia koumpiou gia sword

		upgradeSword=new JButton("����������");
		upgradeSword.setBounds((swordBt.getX()+(swordBt.getWidth()/2)),(swordBt.getY()+swordBt.getHeight()),(swordBt.getWidth()/2),(heightSize/2));
		mainPanel.add(upgradeSword);

		swordlvl=new JLabel("�������: 0");
		swordlvl.setForeground(Color.ORANGE);
		bowlvl=new JLabel("�������: 0");
		bowlvl.setForeground(Color.ORANGE);
		spearlvl=new JLabel("�������: 0");
		spearlvl.setForeground(Color.ORANGE);
		swordPrice=new JLabel("����: 0");
		swordPrice.setForeground(Color.ORANGE);
		bowPrice=new JLabel("����: 0");
		bowPrice.setForeground(Color.ORANGE);
		spearPrice=new JLabel("����: 0");
		spearPrice.setForeground(Color.ORANGE);



		swordlvl.setBounds(((swordBt.getX())+(swordBt.getWidth())),(swordBt.getY()), widthSize, (heightSize/2));
		swordPrice.setBounds(swordlvl.getX(),(swordlvl.getY()+swordlvl.getHeight()),widthSize, (heightSize/2));

		bowlvl.setBounds(((crossBowBt.getX())+(crossBowBt.getWidth())),(crossBowBt.getY()), widthSize, (heightSize/2));
		bowPrice.setBounds(bowlvl.getX(),(bowlvl.getY()+bowlvl.getHeight()),widthSize, (heightSize/2));

		spearlvl.setBounds(((spearBt.getX())+(spearBt.getWidth())),(spearBt.getY()), widthSize, (heightSize/2));
		spearPrice.setBounds(spearlvl.getX(),(spearlvl.getY()+spearlvl.getHeight()),widthSize, (heightSize/2));

		mainPanel.add(swordlvl);
		mainPanel.add(swordPrice);
		mainPanel.add(bowlvl);
		mainPanel.add(bowPrice);
		mainPanel.add(spearlvl);
		mainPanel.add(spearPrice);

		
		ImageIcon  heroIcon=currUser.getImage();
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


		heroLifelbl=new JLabel("���: ");
		heroLifelbl.setForeground(Color.RED);
		herolblPanel.add(heroLifelbl);
		//label Life tou xarakthra		

		heroDamagelbl=new JLabel("�������: ");
		heroDamagelbl.setForeground(Color.RED);
		herolblPanel.add(heroDamagelbl);
		//label Damage tou xarakthra mono to damage pou proerxetai apo ta skill

		heroDeflbl=new JLabel("�����: ");
		heroDeflbl.setForeground(Color.RED);
		herolblPanel.add(heroDeflbl);
		//label gia to Defence tou xarakthra

		herolblPanel.setOpaque(false);
		//gia na mhn emfanizetai to gkri tou panel

		mainPanel.add(herolblPanel);

		ImageIcon  opponentIcon=new  ImageIcon("Duel\\opponent.jpg");
		Image opponentImage=opponentIcon.getImage();
		oppHerolbl=new JLabel();
		oppHerolbl.setBounds((16*widthSize),(2*heightSize),(3*widthSize),(3*heightSize));
		Image opponentResizedImage = opponentImage.getScaledInstance(oppHerolbl.getWidth(), oppHerolbl.getHeight(), 0);
		oppHerolbl.setIcon(new ImageIcon(opponentResizedImage));
		mainPanel.add(oppHerolbl);
		//Image label opponent

		opplblPanel=new JPanel(new GridLayout(3,1));
		opplblPanel.setBounds((16*widthSize),(6*heightSize),(widthSize),(3*heightSize));
		oppLifelbl=new JLabel("���: ");
		oppLifelbl.setForeground(Color.RED);
		opplblPanel.add(oppLifelbl);
		//Life label opponent

		oppDamagelbl=new JLabel("�������: ");
		oppDamagelbl.setForeground(Color.RED);
		opplblPanel.add(oppDamagelbl);
		//Damage label opponent

		oppDeflbl=new JLabel("�����: ");
		oppDeflbl.setForeground(Color.RED);
		//Defence label opponent

		opplblPanel.add(oppDeflbl);
		opplblPanel.setOpaque(false);

		mainPanel.add(opplblPanel);


		ImageIcon  background=new  ImageIcon("Duel\\background2.jpg");
		Image image=background.getImage();
		backlbl=new JLabel();
		backlbl.setBounds(0,0,this.getWidth(), this.getHeight());
		Image resizedImage = image.getScaledInstance(backlbl.getWidth(), backlbl.getHeight(), 0);
		backlbl.setIcon(new ImageIcon(resizedImage));
		//background image
		mainPanel.add(backlbl);

		UpgradeButtonListener upgradeListener = new UpgradeButtonListener();
		upgradeSword.addActionListener(upgradeListener);
		upgradeBow.addActionListener(upgradeListener);
		upgradeSpear.addActionListener(upgradeListener);


		buyButtonListener buyListener=new buyButtonListener();
		buyBow.addActionListener(buyListener);
		buySpear.addActionListener(buyListener);


		updateWeaponStats();

		attackButtonListener attackListener=new attackButtonListener();
		swordBt.addActionListener(attackListener);
		crossBowBt.addActionListener(attackListener);
		spearBt.addActionListener(attackListener);
		this.setUndecorated(true);
		this.setLocation(0,0);
		this.setSize(iwidth,iheight);
		this.setVisible(true);

	}

	public void updateWeaponStats(){

		for (Weapons w: currUser.getWeapons()){
			if (w.getWeaponType().equals("�����")){
				swordlvl.setText("Level: "+w.getLevel());
				swordPrice.setText("Price: "+w.getPrice());
			}
			else if(w.getWeaponType().equals("����")){
				bowlvl.setText("Level: "+w.getLevel());
				bowPrice.setText("Price: "+w.getPrice());
			}
			else if(w.getWeaponType().equals("����")){
				spearlvl.setText("Level: "+w.getLevel());
				spearPrice.setText("Price: "+w.getPrice());
			}

		}
	}

	public boolean checkIfWeaponExists(Weapons w){
		//checks if the weapon has been bought
		String type=w.getWeaponType();
		for(Weapons we: usersWeapons){
			if (type.equals(we.getWeaponType()));
				return true;
		}
		return false;
	}

	public boolean checkIfDead(CharsOpponents c){
		//method to check if the opponent's life is zero
		double remainHealth;
			remainHealth=c.getHealth();
		if(remainHealth<=0){
			JOptionPane.showMessageDialog(null, "�������� �� ����.", "����� �����", JOptionPane.INFORMATION_MESSAGE);
			player.setWin(true);
			player.setPlayed(true);
			player.setCoins(player.getCoins() + 1000);
			player.setXP(player.getXP() + 1000);
			DuelBoardFrame.this.setVisible(false);
			soundthread2.StopMusic();
			return true;
		}			
		else
			return false;

	}

	public void opponentsAttack(User u, CharsOpponents c){
		//method for opponent to attack
		//the opponent attacks only if the user has attacked first
		if (hit){
			double attack=c.getDamage();
			u.setHealth((u.getHealth())-attack);
			hit=false;
			myGlassPane.repaint();
			if (u.getHealth()<=0){
				player.setWin(false);
				player.setPlayed(true);
				JOptionPane.showMessageDialog(null, "������ �� ����.", "����� �����", JOptionPane.ERROR_MESSAGE);
				DuelBoardFrame.this.setVisible(false);
				soundthread2.StopMusic();
			}
		}

	}

	public void addCoins(User u){
		int userCoins=u.getCoins();
		int coinsToAdd=20;
		u.setCoins(userCoins+coinsToAdd);
	}

	public void addXp(User u){
		//otan teleiwsoume me thn user
	}

	class QuitListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			//check if this works

		}

	}

	class MyGlassPane extends JComponent{
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			//overwrite paintcomponent
			super.paintComponent(g);

			g.setColor(Color.YELLOW);

			//draw a bar by every stat according to its value
			//repaint every time a values is being changed
			int xhLifeRec=herolblPanel.getX() + widthSize;
			int yhLifeRec=herolblPanel.getY()+(heightSize/2);
			int recWidthL=(int)currUser.getHealth();
			g.fillRect(xhLifeRec, yhLifeRec, recWidthL, 10);

			int xoLifeRec=opplblPanel.getX() + widthSize;
			int yoLifeRec=opplblPanel.getY()+(heightSize/2);
			int recWidthOpL=(int)currOpponent.getHealth();
			g.fillRect(xoLifeRec, yoLifeRec, recWidthOpL , 10);

			int xhDamRec=herolblPanel.getX() + widthSize;
			int yhDamRec=herolblPanel.getY()+(heightSize+(heightSize/2));
			int recWidthA=(int)currUser.getDamage();
			g.fillRect(xhDamRec, yhDamRec, recWidthA, 10);

			int xoDamRec=opplblPanel.getX() + widthSize;
			int yoDamRec=opplblPanel.getY()+(heightSize+(heightSize/2));
			int recWidthOpA=(int)currOpponent.getDamage();
			g.fillRect(xoDamRec, yoDamRec, recWidthOpA, 10);

			int xhDefRec=herolblPanel.getX() + widthSize;
			int yhDefRec=herolblPanel.getY()+((2*heightSize)+(heightSize/2));
			int recWidthD=(int)currUser.getDefence();
			g.fillRect(xhDefRec, yhDefRec, recWidthD, 10);

			int xoDefRec=opplblPanel.getX() + widthSize;
			int yoDefRec=opplblPanel.getY()+((2*heightSize)+(heightSize/2));
			int recWidthOpD=(int)currOpponent.getDefence();
			g.fillRect(xoDefRec, yoDefRec, recWidthOpD, 10);

		}

	}

	class UpgradeButtonListener implements ActionListener {
		//method to upgrade weapons
		@Override
		public void actionPerformed(ActionEvent e) {
			soundthread1.PlayMusic(list.get(1).getSongName(), list.get(1).getRepeat());   //Sound upgrade
			
			if(e.getSource()==upgradeSword){
				usersWeapons=currUser.getWeapons();
				for(Weapons w: usersWeapons){
					if(w.getWeaponType()=="Sword"){
						w.upgradeWeapon(currUser, w);
						System.out.println("sword "+w.level);
						updateWeaponStats();
					}
				}
			}

			if(e.getSource()==upgradeBow){
				usersWeapons=currUser.getWeapons();
				for(Weapons w: usersWeapons){
					if(w.getWeaponType()=="CrossBow"){
						w.upgradeWeapon(currUser, w);
						System.out.println("bow "+w.level);
						updateWeaponStats();
					}
				}
			}

			if(e.getSource()==upgradeSpear){
				usersWeapons=currUser.getWeapons();
				for(Weapons w: usersWeapons){
					if(w.getWeaponType()=="Spear"){
						w.upgradeWeapon(currUser, w);
						System.out.println("spear "+w.level);
						updateWeaponStats();
					}
				}
			}



		}


	}

	class buyButtonListener implements ActionListener{
		//method for the player to buy weapons


	@Override
	public void actionPerformed(ActionEvent e) {
		soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat());   //Sound buy
		
		if(e.getSource()==buyBow){				
			System.out.println("Buy a bow ?");
			CrossBow b=new CrossBow();
			b.buyWeapons(currUser, b);
			b.setLevel(1);
			updateWeaponStats();
			}
		if(e.getSource()==buySpear){
			System.out.println("Buy a spear ?");
			Spear s=new Spear();
			s.buyWeapons(currUser, s);
			s.setLevel(1);
			updateWeaponStats();
		}
		}

	}


	class attackButtonListener implements ActionListener{
		//method for the player to attack

		TimerBeep timer;
		public void actionPerformed(ActionEvent e) {


		if(!hit){
			//the player can't hit twice unless the opponent attacks back

		if(e.getSource()==swordBt){
			JOptionPane.showMessageDialog(null, "������� �� �����.", "�������", JOptionPane.INFORMATION_MESSAGE);
			currOpponent.setHealth((currOpponent.getHealth())-10);
			myGlassPane.repaint();
			checkIfDead(currOpponent);
			hit=true;			
			}
		else if (e.getSource()==crossBowBt){
			if(checkIfWeaponExists(new CrossBow())){				
				JOptionPane.showMessageDialog(null, "������� �� ����.", "�������", JOptionPane.INFORMATION_MESSAGE);
				currOpponent.setHealth((currOpponent.getHealth())-10);
				myGlassPane.repaint();
				checkIfDead(currOpponent);
				hit=true;
				}
			else
				JOptionPane.showMessageDialog(null,"������� ���� ����.", "������", JOptionPane.ERROR_MESSAGE);
			}
		else if(e.getSource()==spearBt){
			if(checkIfWeaponExists(new Spear())){
				JOptionPane.showMessageDialog(null, "������� �� ����.", "�������", JOptionPane.INFORMATION_MESSAGE);
				currOpponent.setHealth((currOpponent.getHealth())-10);
				myGlassPane.repaint();
				checkIfDead(currOpponent);
				hit=true;			
			}
			else
				JOptionPane.showMessageDialog(null,"������� ���� ����.", "������", JOptionPane.ERROR_MESSAGE);
		}
		if (hit)
			timer=new TimerBeep();
		//the hit variable is true if the player has already attacked the opponent and it becomes false if the opponent hit the player
		//the opponent attacks only if the player has attacked before
		}
		else
			JOptionPane.showMessageDialog(null, "��� ����� � ����� ���.", "������", JOptionPane.ERROR_MESSAGE);

		}

	}

class TimerBeep extends Timer{

		Timer timer;
		TimerTask task;

		public TimerBeep() {

		   timer = new Timer();
		   timer.schedule(new TimerTask(){
			   public void run() {
			   opponentsAttack(currUser,currOpponent);
			   }
		   },3000);
		   //scedule the attack of the opponent after 3 seconds the user has attacked
		   //1 second=1000 miliseconds
		  }

 

}


	
}