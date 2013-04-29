import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

import java.util.Timer;

import java.util.TimerTask;




public class ClickMeFrame extends JFrame{
	private TimerBeep timer;
	private int timerDelay;
	private JLabel iconLabel;
	//label gia thn eikona
	private JLabel backgroundLabel;
	//label gia to background
	private JLabel scoreLabel;
	//label pou emfanizei to score
	private JLabel lifeLabel;
	//label pou emfanizei poses prospathies menoun akoma
	private int iconSize;
	//arxiko megethos eikonas tha meiwnetai posostiaia analoga me tis epityxies
	private int score=0;
	//ayksanetai kata ena meta apo kathe epityxia
	private int lives=3;
	//meiwnei kata ena me kathe klik ektos eikonas kai me kathe allagh theshs kata thn opoia den exei mesolabhsei klik
	private MyGlassPane myGlassPane;
	
	public ClickMeFrame() {
		
		
		iconSize=150;
		timerDelay=3000;
		timer=new TimerBeep(timerDelay);
		
		iconLabel=new JLabel();
		scoreLabel=new JLabel("Score: "+score);
		lifeLabel=new JLabel("Lives: "+lives);
		
		//scoreLabel.setLocation(10,10);
		
		ImageIcon bgIcon=new ImageIcon("land.png");
		backgroundLabel=new JLabel(bgIcon);
		this.setContentPane(backgroundLabel);
		
		myGlassPane=new MyGlassPane();
		this.setGlassPane(myGlassPane);
		myGlassPane.setVisible(true);
		
		myGlassPane.add(scoreLabel);
		myGlassPane.add(iconLabel);
		myGlassPane.add(lifeLabel);
		//dhmiourgia kai rythmiseis gia to glasspane
		
		ImageIcon icon = new ImageIcon("medusa.png");
		Image image=icon.getImage();
		//metatroph aytou pou perasame san icon se typo image giati theloume na kanei rezise me thn getScaleInstance
		//pou einai methodos ths klashs image	
		
		
		iconLabel.setSize(iconSize, iconSize);		
		//tis diastaseis tha tis baloume me metablhtes gia na allazoun analoga me ta klik
		//isws xreiastei allh klash h tha mpei sto timer mesa
	
		System.out.println(iconLabel.getSize());
		System.out.println(iconLabel.getWidth());
		//println gia elegxo
	
		Image resizedImage = image.getScaledInstance(iconLabel.getWidth(), iconLabel.getHeight(), 0);
		//methodos gia na kanei resize h eikona
		iconLabel.setIcon(new ImageIcon(resizedImage));
		//afou ginei resize bazoume panw sto label thn kainouria eikona
    
		MyListener listener = new MyListener();
		myGlassPane.addMouseListener(listener);
		//dhmiourgia kai prosthiki tou listener sto glasspane		
	
		this.setSize(500, 500);
		this.setTitle("Click Me!");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public void endTime(){
		if(timer.isExpire()){
			myGlassPane.repaint();
			lives=lives-1;
			if(lives==0){
				JOptionPane.showMessageDialog(null, "Your Total Score Is: "+score);
				
			}
		}
		
	}
	
	
	class MyGlassPane extends JComponent{
		
		public void paintComponent(Graphics g){
			//epikalypsh ths repaint
			super.paintComponent(g);
			
			
			Random r=new Random(System.currentTimeMillis());
			int randomX=r.nextInt(500-iconSize);
			int randomY=r.nextInt((480-iconSize)+(score+1));
			
			iconLabel.setBounds(randomX,randomY,iconSize,iconSize);
			
			
			// na dw ti ftaiei
			
		}
	}
		
	class MyListener extends MouseAdapter {		
		public void mouseClicked(MouseEvent e) {
			timer.restart();
			int labelX=iconLabel.getX();
			int labelY=iconLabel.getY();
			//pairnoume tis trexouses syntetagmenes X kai Y tou label
			int clickX=e.getX();
			int clickY=e.getY();
			//pairnoume tis syntetagmenes tou klik pou kaname
			
			
			System.out.println(" "+iconLabel.getX()+" "+iconLabel.getY());
			//ektypwsh elegxou
			
			if((clickX>=labelX)&&(clickX<(labelX+iconSize))&&(clickY>=labelY)&&(clickY<(labelY+iconSize))){
					//elegxos an to klik einai panw sto label
					score=score+1;
					//aykshsh score kata ena
					if ((score%5)==0){
						System.out.println("A");
						double size=iconSize/1.05;
						iconSize=(int)Math.round(size);
						//meiwsh diastasewn kata 5%
						//metatroph tou double size se akeraio me stroggylopoihsh gia na mpei sto iconSize
						double delay=timerDelay/1.20;
						timerDelay=(int)Math.round(delay);
						
						System.out.println("my"+iconSize);
						iconLabel.setSize(iconSize,iconSize);
						System.out.println(iconLabel.getWidth()+"");
						ImageIcon icon = new ImageIcon("medusa.png");
						Image image=icon.getImage();
						Image resizedImage = image.getScaledInstance(iconLabel.getWidth(), iconLabel.getHeight(), 0);
						//methodos gia na kanei resize h eikona
						iconLabel.setIcon(new ImageIcon(resizedImage));
						
						//afou ginei resize bazoume panw sto label thn kainouria eikona
					}
					scoreLabel.setText("Score: "+score);
					//update tou keimenou tou label pou deixnei to score
					System.out.println("score "+labelX +","+ labelY);
					//ektypwsh elegxou
					System.out.println("Hit");
			}
			else{
				System.out.println("Miss");
				lives=lives-1;
				if(lives==0){
					JOptionPane.showMessageDialog(null, "Your Total Score Is: "+score);
					
				}
			}
		System.out.println("score "+labelX +","+ labelY);
		//ektypwsh elegxou
		
		myGlassPane.repaint();
		//kalw thn repaint pou epikalypsa epanw
		}
		}
	
	class TimerBeep extends Timer{
		//klash gia ton timer

		private boolean expire=false;
		  Timer timer;
		  RemindTask task;

		  public TimerBeep(int seconds) {
		
			  
		    timer = new Timer();
		  
		    timer.scheduleAtFixedRate(new RemindTask(),5000,timerDelay);
		    //xrhsh gia epanalambanomeno gegonos to prwto orisma einai to epanalambanomeno gegonos, to deytero einai
		    //posh kathysterhsh se milliseconds tha exei mexri thn prwth epanalhpsh apo thn klhsh ths klashs
		    //to deytero einai to perithorio metaksi dyo epanalhpsewn
		    
		    //1 second=1000 miliseconds
		  }

		  class RemindTask extends TimerTask {
			  int i=0;
			  //opoiadhpote energia ginetai bash tou rologiou prepei na kanei extends to TimerTask
		    public void run() {
		    	expire=true;
		      System.out.println("Time's up!"+i);
		      i++;
		      endTime();
		      System.out.println("td"+timerDelay);
		    
		       //Stops the AWT thread (and everything else)
		    }
		  }

		public void restart() {
			timer.cancel();
			//akyrwnei ton prwto timer
			timer.purge();
			//akyrwnei oles tis ergasies pou trexoun
			timer=new Timer();
			//ftiaxnei neo timer
			timer.scheduleAtFixedRate(new RemindTask(),timerDelay,timerDelay);
			
			//orizei to task tou
			
		}
		
		

		public boolean isExpire() {
			//elegxei an exei lhksei o xronos
			return expire;
		}
	}
}
