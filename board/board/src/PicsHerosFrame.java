import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class PicsHerosFrame extends JFrame{
	
	private JLabel photo1;
	private JLabel photo2;
	private JLabel photo3;
	
	private JTextArea nameArea;
	
	private JButton commitBt;
	private JLabel backlbl;
	
	private JPanel mainPanel;
	
	private PicsHerosHeroManager heroManager;
	private PicsHerosHero anyHero;
	
	private myButtonListener buttonListener;
	
	
	public PicsHerosFrame(PicsHerosHeroManager heroManager){
		super("3 photos 1 Hero");
		
		//Getting Dimensions
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		System.out.println("Width is: "+width +" and height is: "+height);
		
		this.heroManager=heroManager;
		heroManager.createHeroList();
		//dhmiourgoume prwta thn lista hrwwn
		
		//this.setSize(900, 680);
		//mpainei prin ta setBounds gia na doulepsei to this
		
		setBounds(100, 100,this.getWidth(), this.getHeight());
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
			
		anyHero = this.heroManager.getHero();
		
		//Keno metaksi JLabels
		int z=10;   //ystera apo prakseis to z=10 synarthsei tou WIDTH!!!
		int w=90 ;    // ystera apo prakseis to k=10 synartisei toy ÇEIGHT!!!
		
		photo1=new JLabel(); //x=100, y=1/5 height ,Width=1/3 width -73 ,Height=2/5 toy height (keno 100 apo Deksia & Aristera)
		photo1.setBounds(100,(int) (height/5) ,(int) (width/3-73),(int) (2*(height/5)) );
		mainPanel.add(photo1);
				
		photo2=new JLabel();
		photo2.setBounds(photo1.getX()+photo1.getWidth()+z,photo1.getY() ,photo1.getWidth(),photo1.getHeight() );
		mainPanel.add(photo2);
		
		photo3=new JLabel();
		photo3.setBounds(photo2.getX()+photo2.getWidth()+z, photo2.getY() ,photo2.getWidth(),photo2.getHeight() );
		mainPanel.add(photo3);
				
		commitBt=new JButton("The pics are about...");   //150 einai sto standar width
		commitBt.setBounds(photo1.getX()+photo1.getWidth()-150, photo1.getY()+photo1.getHeight()+w,150,30);
		
		buttonListener=new myButtonListener();
		commitBt.addActionListener(buttonListener);
		
		mainPanel.add(commitBt);
			
		nameArea=new JTextArea(); // dipla sto commitBt                  width: synarthsei toy  commitBt.getWidth()
		nameArea.setBounds(commitBt.getX()+commitBt.getWidth(), commitBt.getY(), photo2.getWidth()+ 2*z +commitBt.getWidth()  ,30);
		nameArea.setBackground(Color.ORANGE);
		nameArea.setEditable(true);
		mainPanel.add(nameArea);
		//kataskeyh stoixeiwn parathyrou
		
		ImageIcon  background=new  ImageIcon("olympus.jpg");
		Image image=background.getImage();
		backlbl=new JLabel();
		backlbl.setBounds(0,0,(int) width,(int) height);
		Image resizedImage = image.getScaledInstance(backlbl.getWidth(), backlbl.getHeight(), 0);
		backlbl.setIcon(new ImageIcon(resizedImage));
		//prosarmogh eikonas fontou
		mainPanel.add(backlbl);
		
		getNextHero();
		//yparxei gia na exoume enan arxiko hrwa alliws bgazei keno
		
		//*** FullScreen Mode ***
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize((int) width,(int) height);
		this.setLocation(0, 0);
		this.setUndecorated(true);
		this.setVisible(true);
	}
	
	
	public void getNextHero(){
		anyHero = this.heroManager.getHero();
		
		ImageIcon  icon1=anyHero.getIcon(0);
		Image image1=icon1.getImage();
		Image resizedImage1 = image1.getScaledInstance(photo1.getWidth(), photo1.getHeight(), 0);
		photo1.setIcon(new ImageIcon(resizedImage1));
			
		ImageIcon  icon2=anyHero.getIcon(1);
		Image image2=icon2.getImage();
		Image resizedImage2 = image2.getScaledInstance(photo2.getWidth(), photo2.getHeight(), 0);
		photo2.setIcon(new ImageIcon(resizedImage2));
		
		ImageIcon  icon3=anyHero.getIcon(2);
		Image image3=icon3.getImage();
		Image resizedImage3 = image3.getScaledInstance(photo3.getWidth(), photo3.getHeight(), 0);
		photo3.setIcon(new ImageIcon(resizedImage3));
		//prosarmogh eikonwn sta label
		
		System.out.println(anyHero.getName());
		//yparxei boithitika gia na fainetai to onoma
		
		nameArea.setText("");
		//katharizei to textArea
		
	}
	
	public class myButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			String answer;
			answer=nameArea.getText();
			if(answer.length()!=0){
				//an den einai keno to onoma elegxoume an einai idio me ayto tou hrwa
				//h toUpperCase opws kai na grapsoume to onoma mikra kefalaia ktl ta metatrepei se
				//kefalaia na ta sygkrinei
				if((anyHero.getName()).equals(answer.toUpperCase().trim())) 
					getNextHero();
				else
					JOptionPane.showMessageDialog(null,"Wrong");
			}
			else
				JOptionPane.showMessageDialog(null,"You Have To Give A Name");
			
		}
		
	}
	

}
