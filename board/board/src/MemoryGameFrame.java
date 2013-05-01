import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;


public class MemoryGameFrame extends JFrame {

	private JPanel contentPane;
	private Uicons iconlist;
	private ArrayList<CardLabel> currlist;
	
	private CardLabel conn_label= new CardLabel();//The label that is responsible for the connention with the previous one(if there is)
    private boolean hasPicked =false;   // We need to know if the user has already picked something!
                                    // TRUE:The user has picked something    FALSE:The user has picked nothing
    
    private int delay_secs= 1; // If user is wrong images stay open for 'delay_secs' seconds
    private int period = 199;
    private int correct=0;//correct guesses
    
    private int Clicks=0; //the ammount of clicks done by Player
    private JLabel Clickslbl;
    
    private Image img;  //The image of the closed icons(something black)
    private Image backimg;  //The image of the backgound
    private CardLabel label_1;
	private CardLabel label_2;
	private CardLabel label_3;
	private CardLabel label_4;
	private CardLabel label_5;
	private CardLabel label_6;
	private CardLabel label_7;
	private CardLabel label_8;
	private CardLabel label_9;
	private CardLabel label_10;
	private CardLabel label_11;
	private CardLabel label_12;
	private CardLabel label_13;
	private CardLabel label_14;
	private CardLabel label_15;
	private CardLabel label_16;
	private JTextArea info;
	private JLabel backlbl;
	
	private LblListener listener;

	public MemoryGameFrame() {
		//*** MenuBar ***//
				setJMenuBar(new JMenuFrame().getMenu()); // Getting the Menu from the JMenuFrame
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		System.out.println("Width is: "+width +" and height is: "+height);
		
		iconlist= new Uicons();
		currlist=new ArrayList<CardLabel>(iconlist.getMMGIcons());
		Collections.shuffle(currlist.subList(2, currlist.size()));//randomize ALL the pictures and codes except form 
		                                                              //no 1(backgorund) and no2(pattern) 
		                                                                    
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//Adding the Labels
		int z=26;   //ystera apo prakseis to z=26.6666 synarthsei tou WIDTH!!!
		int k=20 ;    // ystera apo prakseis to k=20 synartisei toy ÇEIGHT!!!
		
		label_1 = new CardLabel();
		label_1=currlist.get(2); 	 //label gets icon and code
		label_1.setBounds(20, 20,(int) (width/4-40) , (int) (height/4-30));
		label_1.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		contentPane.add(label_1);
		
		
		label_2 = new CardLabel();
		label_2=currlist.get(3);   //label gets icon and code
		label_2.setBounds(label_1.getX()+label_1.getWidth()+ z , 20,(int) (width/4-40) , (int) (height/4-30));
		label_2.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		contentPane.add(label_2);
		
		label_3 = new CardLabel(); 
		label_3=currlist.get(4);     //label gets icon and code
		label_3.setBounds(label_2.getX()+label_2.getWidth()+ z  , 20,(int) (width/4-40) , (int) (height/4-30));
		label_3.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		contentPane.add(label_3);
		
		label_4 = new CardLabel();
		label_4=currlist.get(5);     //label gets icon and code
		label_4.setBounds(label_3.getX()+label_3.getWidth()+ z , 20,(int) (width/4-40) , (int) (height/4-30));
		label_4.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		contentPane.add(label_4);
		
		label_5 = new CardLabel();	
		label_5=currlist.get(6);      //label gets icon and code
		label_5.setBounds(20,label_1.getY()+label_1.getHeight()+k, (int) (width/4-40),   (int) (height/4-30));
		label_5.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		contentPane.add(label_5);
		
		label_6 = new CardLabel();
		label_6=currlist.get(7);
		label_6.setBounds(label_5.getX()+label_5.getWidth()+z, label_2.getY()+label_2.getHeight()+k , (int) (width/4-40),   (int) (height/4-30)   );
		label_6.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		contentPane.add(label_6);
		
		label_7 = new CardLabel();
		label_7=currlist.get(8);      //label gets icon and code
		label_7.setBounds(label_6.getX()+label_6.getWidth()+z, label_3.getY()+label_3.getHeight()+k , (int) (width/4-40),   (int) (height/4-30)   );
		label_7.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		contentPane.add(label_7);
		
		label_8 = new CardLabel();
		label_8=currlist.get(9);      //label gets icon and code
		label_8.setBounds(label_7.getX()+label_7.getWidth()+z, label_4.getY()+label_4.getHeight()+k , (int) (width/4-40),   (int) (height/4-30)   );
		label_8.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		contentPane.add(label_8);
		
		label_9 = new CardLabel();
		label_9=currlist.get(10);      //label gets icon and code
		label_9.setBounds(20, label_5.getY()+label_5.getHeight()+k , (int) (width/4-40),   (int) (height/4-30)   );
		label_9.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		contentPane.add(label_9);
		
		label_10 = new CardLabel();
		label_10=currlist.get(11);      //label gets icon and code
		label_10.setBounds(label_9.getX()+label_9.getWidth()+z, label_6.getY()+label_6.getHeight()+k , (int) (width/4-40),   (int) (height/4-30)   );
		label_10.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		contentPane.add(label_10);
		
		label_11 = new CardLabel();
		label_11=currlist.get(12);      //label gets icon and code
		label_11.setBounds(label_10.getX()+label_10.getWidth()+z, label_7.getY()+label_7.getHeight()+k , (int) (width/4-40),   (int) (height/4-30)   );
		label_11.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		contentPane.add(label_11);
		
		label_12 = new CardLabel();
		label_12=currlist.get(13);      //label gets icon and code
		label_12.setBounds(label_11.getX()+label_11.getWidth()+z, label_8.getY()+label_8.getHeight()+k , (int) (width/4-40),   (int) (height/4-30)   );
		label_12.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		contentPane.add(label_12);
		
		label_13 = new CardLabel();
		label_13=currlist.get(14);      //label gets icon and code
		label_13.setBounds(20 , label_9.getY()+label_9.getHeight()+k , (int) (width/4-40),   (int) (height/4-30)   );
		label_13.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		contentPane.add(label_13);
		
		label_14 = new CardLabel();
		label_14=currlist.get(15);      //label gets icon and code
		label_14.setBounds(label_13.getX()+label_13.getWidth()+z, label_10.getY()+label_10.getHeight()+k , (int) (width/4-40),   (int) (height/4-30)   );
		label_14.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		contentPane.add(label_14);
		
		label_15 = new CardLabel();
		label_15=currlist.get(16);      //label gets icon and code
		label_15.setBounds(label_14.getX()+label_14.getWidth()+z, label_11.getY()+label_11.getHeight()+k , (int) (width/4-40),   (int) (height/4-30)   );
		label_15.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		contentPane.add(label_15);
		
		label_16 = new CardLabel();
		label_16=currlist.get(17);      //label gets icon and code
		label_16.setBounds(label_15.getX()+label_15.getWidth()+z, label_12.getY()+label_12.getHeight()+k , (int) (width/4-40),   (int) (height/4-30)   );
		label_16.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		contentPane.add(label_16);
		
		
		//Informational JPanel 
		info = new JTextArea();   //x            //y               //width                                       //height
		info.setBounds(label_14.getX(),label_14.getY()+label_14.getHeight()+2,2*(label_16.getWidth() )+z,(int) height-(20+ 4*label_14.getHeight()+3*k)-10 );
		info.setBackground(Color.ORANGE);
		info.setText("Find the hidden pairs. GOOD LUCK!!!");
		info.setEditable(false);
		contentPane.add(info);
		
		
		Clickslbl = new JLabel();   //x                       //y               //width                                       //height
		Clickslbl.setBounds(label_4.getX()+ label_4.getWidth(),label_4.getY(),80,50);
		Clickslbl.setForeground(Color.WHITE);
		Clickslbl.setText("Clicks: "+Clicks);
		contentPane.add(Clickslbl);
		
		
		
		
		backlbl=new JLabel();
		backlbl.setBounds(0,0,(int) width,(int) height);
		backimg = currlist.get(0).getImage();   //eikona backgorund
		backlbl.setIcon(new ImageIcon(backimg.getScaledInstance(backlbl.getWidth(), backlbl.getHeight(), 0)));
		//prosarmogh eikonas fontou
		contentPane.add(backlbl);
		
		//appear all images normally
		appear_all_cards_mormally();
		
    	
    	//images turn around after we wait n seconds
		int l= 100; //every 100 the cards close again
		int n=8 ;//after 5 secs tha cards turn around
    	turn_around_images_in_seconds(n,l);
		
		
		
		
		//Adding the listener 
		listener = new LblListener();
		label_1.addMouseListener(listener);
		label_2.addMouseListener(listener);
		label_3.addMouseListener(listener);
		label_4.addMouseListener(listener);
		label_5.addMouseListener(listener);
		label_6.addMouseListener(listener);
		label_7.addMouseListener(listener);
		label_8.addMouseListener(listener);
		label_9.addMouseListener(listener);
		label_10.addMouseListener(listener);
		label_11.addMouseListener(listener);
		label_12.addMouseListener(listener);
		label_13.addMouseListener(listener);
		label_14.addMouseListener(listener);
		label_15.addMouseListener(listener);
		label_16.addMouseListener(listener);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		//WINDOW MANAGEMENT
	//	this.setSize(500, 500);
		this.setSize((int) width,(int) height);
		this.setLocation(0, 0);
		this.setUndecorated(true);
		this.setVisible(true);
	}
	

	public void appear_all_cards_mormally(){
		//appear all images normally
		label_1.setIcon(new ImageIcon(currlist.get(2).getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), 0)));
		label_2.setIcon(new ImageIcon(currlist.get(3).getImage().getScaledInstance(label_2.getWidth(), label_2.getHeight(), 0)));
		label_3.setIcon(new ImageIcon(currlist.get(4).getImage().getScaledInstance(label_3.getWidth(), label_3.getHeight(), 0)));
		label_4.setIcon(new ImageIcon(currlist.get(5).getImage().getScaledInstance(label_4.getWidth(), label_4.getHeight(), 0)));
		label_5.setIcon(new ImageIcon(currlist.get(6).getImage().getScaledInstance(label_5.getWidth(), label_5.getHeight(), 0)));
		label_6.setIcon(new ImageIcon(currlist.get(7).getImage().getScaledInstance(label_6.getWidth(), label_6.getHeight(), 0)));
		label_7.setIcon(new ImageIcon(currlist.get(8).getImage().getScaledInstance(label_7.getWidth(), label_7.getHeight(), 0)));
		label_8.setIcon(new ImageIcon(currlist.get(9).getImage().getScaledInstance(label_8.getWidth(), label_8.getHeight(), 0)));
		label_9.setIcon(new ImageIcon(currlist.get(10).getImage().getScaledInstance(label_9.getWidth(), label_9.getHeight(), 0)));
		label_10.setIcon(new ImageIcon(currlist.get(11).getImage().getScaledInstance(label_10.getWidth(), label_10.getHeight(), 0)));
		label_11.setIcon(new ImageIcon(currlist.get(12).getImage().getScaledInstance(label_11.getWidth(), label_11.getHeight(), 0)));
		label_12.setIcon(new ImageIcon(currlist.get(13).getImage().getScaledInstance(label_12.getWidth(), label_12.getHeight(), 0)));
		label_13.setIcon(new ImageIcon(currlist.get(14).getImage().getScaledInstance(label_13.getWidth(), label_13.getHeight(), 0)));
		label_14.setIcon(new ImageIcon(currlist.get(15).getImage().getScaledInstance(label_14.getWidth(), label_14.getHeight(), 0)));
		label_15.setIcon(new ImageIcon(currlist.get(16).getImage().getScaledInstance(label_15.getWidth(), label_15.getHeight(), 0)));
		label_16.setIcon(new ImageIcon(currlist.get(17).getImage().getScaledInstance(label_16.getWidth(), label_16.getHeight(), 0)));
	}

	public void turn_around_images_in_seconds(int n, int l){
		Timer timer = new Timer();
		timer.schedule( new TimerTask() {
			public void run() {
				img = currlist.get(1).getImage();   //h basikh eikona backgorund ennalasete se pola labels
				label_1.setIcon(new ImageIcon(img.getScaledInstance(label_1.getWidth(), label_1.getHeight(), 0)));
				label_2.setIcon(new ImageIcon(img.getScaledInstance(label_2.getWidth(), label_2.getHeight(), 0)));
				label_3.setIcon(new ImageIcon(img.getScaledInstance(label_3.getWidth(), label_3.getHeight(), 0)));
				label_4.setIcon(new ImageIcon(img.getScaledInstance(label_4.getWidth(), label_4.getHeight(), 0)));
				label_5.setIcon(new ImageIcon(img.getScaledInstance(label_5.getWidth(), label_5.getHeight(), 0)));
				label_6.setIcon(new ImageIcon(img.getScaledInstance(label_6.getWidth(), label_6.getHeight(), 0)));
				label_7.setIcon(new ImageIcon(img.getScaledInstance(label_7.getWidth(), label_7.getHeight(), 0)));
				label_8.setIcon(new ImageIcon(img.getScaledInstance(label_8.getWidth(), label_8.getHeight(), 0)));
				label_9.setIcon(new ImageIcon(img.getScaledInstance(label_9.getWidth(), label_9.getHeight(), 0)));
				label_10.setIcon(new ImageIcon(img.getScaledInstance(label_10.getWidth(), label_10.getHeight(), 0)));
				label_11.setIcon(new ImageIcon(img.getScaledInstance(label_11.getWidth(), label_11.getHeight(), 0)));
				label_12.setIcon(new ImageIcon(img.getScaledInstance(label_12.getWidth(), label_12.getHeight(), 0)));
				label_13.setIcon(new ImageIcon(img.getScaledInstance(label_13.getWidth(), label_13.getHeight(), 0)));
				label_14.setIcon(new ImageIcon(img.getScaledInstance(label_14.getWidth(), label_14.getHeight(), 0)));
				label_15.setIcon(new ImageIcon(img.getScaledInstance(label_15.getWidth(), label_15.getHeight(), 0)));
				label_16.setIcon(new ImageIcon(img.getScaledInstance(label_16.getWidth(), label_16.getHeight(), 0)));


			}
		}, n*1000, l*1000);
	}


	
	public void SwitchFlag(){
		if(hasPicked) 
			hasPicked=false;
		else
			hasPicked= true;
	}
	
	public void AppearLabel(CardLabel lbl_to_appear, int i){
		lbl_to_appear.setIcon(new ImageIcon(currlist.get(i+1).getImage().getScaledInstance(lbl_to_appear.getWidth(), lbl_to_appear.getHeight(), 0)));
	}

	
	//gets a JLabel(the conn_label) and finds which one of the rest is equal to, and turns is around
	public void CloseOpenedLabel(CardLabel lbl_to_close){

		lbl_to_close.setIcon(new ImageIcon(img.getScaledInstance(lbl_to_close.getWidth(), lbl_to_close.getHeight(), 0)));
	/**	if(lbl_to_close == label_1){
			label_1.setIcon(new ImageIcon(img.getScaledInstance(label_1.getWidth(), label_1.getHeight(), 0)));
		}
		else if(lbl_to_close == label_2){
			label_2.setIcon(new ImageIcon(img.getScaledInstance(label_2.getWidth(), label_2.getHeight(), 0)));
		}
		else if(lbl_to_close == label_3){
			label_3.setIcon(new ImageIcon(img.getScaledInstance(label_3.getWidth(), label_3.getHeight(), 0)));
		}
		else if(lbl_to_close == label_4){
			label_4.setIcon(new ImageIcon(img.getScaledInstance(label_4.getWidth(), label_4.getHeight(), 0)));
		}
		else if(lbl_to_close == label_5){
			label_5.setIcon(new ImageIcon(img.getScaledInstance(label_5.getWidth(), label_5.getHeight(), 0)));
		}
		else if(lbl_to_close == label_6){
			label_6.setIcon(new ImageIcon(img.getScaledInstance(label_6.getWidth(), label_6.getHeight(), 0)));
		}   **/

	}
	
	public void set_conn_label(CardLabel lbl_to_save){

		conn_label=lbl_to_save;
	}

	public void Verify_CardLabel (final CardLabel cd, int i){
		if(!hasPicked){                 //user hasn 't chosen anything before  , conn_label DOES NOT have a value
			set_conn_label(cd);
			SwitchFlag();

		}
		else
			//User has picked something before
			//We must check if he is correct
		{
			//User is correct!                                //clik twice tha same picture
			if(  conn_label.getCode().equals(cd.getCode()) &&cd != conn_label ){
				correct++;
				cd.removeMouseListener(listener);      // if a PAIR is correct LOCK IT,so it doesnt get clicked AGAIN !!!
				conn_label.removeMouseListener(listener);
				JOptionPane.showMessageDialog(null, "Correct");
			}
			else{//User is wrong
				
				//Give the normal image for 2 SECS  and then turn is around
				Timer timer = new Timer();
				
				timer.schedule( new TimerTask() {
					public void run() {

						CloseOpenedLabel(cd);
						CloseOpenedLabel(conn_label);
						
					}
				},  delay_secs* 1000);

					JOptionPane.showMessageDialog(null, "Wrong","Wrong", JOptionPane.WARNING_MESSAGE);
			}
			System.out.println("CD Code: "+ cd.getCode());
			System.out.println("conn_label Code: "+ conn_label.getCode());
			SwitchFlag();
		}
	}



	class LblListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			Clicks++;
			Clickslbl.setText("Clicks: "+Clicks);
			
			
			System.out.println(Clicks +" clicks");
			//User Picked Label 1
			if(e.getSource()==label_1){
				AppearLabel(label_1, 1);
				Verify_CardLabel(label_1, 1);

			}

			//User Picked Label 2
			else if(e.getSource()==label_2){
				AppearLabel(label_2, 2);
				Verify_CardLabel(label_2, 2);

			}
			//User Picked Label 3
			else if(e.getSource()==label_3){
				AppearLabel(label_3, 3);
				Verify_CardLabel(label_3, 3);


			}
			//User Picked Label 4
			else if(e.getSource()==label_4){
				AppearLabel(label_4, 4);
				Verify_CardLabel(label_4, 4);

			}
			//User Picked Label 5
			else if(e.getSource()==label_5){
				AppearLabel(label_5, 5);
				Verify_CardLabel(label_5, 5);

			}
			//User Picked Label 6
			else if(e.getSource()==label_6){
				AppearLabel(label_6, 6);
				Verify_CardLabel(label_6, 6);

			}
			//User Picked Label 7
			else if(e.getSource()==label_7){
				AppearLabel(label_7, 7);
				Verify_CardLabel(label_7, 7);

			}
			//User Picked Label 8
			else if(e.getSource()==label_8){
				AppearLabel(label_8, 8);
				Verify_CardLabel(label_8, 8);

			}
			//User Picked Label 9
			else if(e.getSource()==label_9){
				AppearLabel(label_9, 9);
				Verify_CardLabel(label_9, 9);

			}
			//User Picked Label 10
			else if(e.getSource()==label_10){
				AppearLabel(label_10, 10);
				Verify_CardLabel(label_10, 10);

			}
			//User Picked Label 11
			else if(e.getSource()==label_11){
				AppearLabel(label_11, 11);
				Verify_CardLabel(label_11, 11);

			}
			//User Picked Label 12
			else if(e.getSource()==label_12){
				AppearLabel(label_12, 12);
				Verify_CardLabel(label_12, 12);

			}
			//User Picked Label 13
			else if(e.getSource()==label_13){
				AppearLabel(label_13, 13);
				Verify_CardLabel(label_13, 13);

			}
			//User Picked Label 14
			else if(e.getSource()==label_14){
				AppearLabel(label_14, 14);
				Verify_CardLabel(label_14, 14);

			}
			//User Picked Label 15
			else if(e.getSource()==label_15){
				AppearLabel(label_15, 15);
				Verify_CardLabel(label_15, 15);

			}
			//User Picked Label 16
			else if(e.getSource()==label_16){
				AppearLabel(label_16, 16);
				Verify_CardLabel(label_16, 16);

			}
			if(correct==8){
				JOptionPane.showMessageDialog(null, "Congatulations");
				//RETURN XP & COINS
			}
		}


		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
