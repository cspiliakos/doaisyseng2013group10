import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
public class DummyFrame extends JFrame{
	//to prathyro einai endeiktiko o anagkaios kwdikas tha kaleitai an to nomisma erthei 
	//apo thn meria tou grifou
	

	private JButton selectBt;
	private JButton duelBt;
	private JPanel panel;
	private PuzzleList puzzles;
	private Random r;
	private myButtonListener btl;
	private duelListener dl;
	
	private User userToFight;
	
	public DummyFrame(User user){
		//*** MenuBar ***//
		setJMenuBar(new JMenuFrame().getMenu()); // Getting the Menu from the JMenuFrame
		
		userToFight = user;
		puzzles=new PuzzleList();
		
		panel=new JPanel();
		selectBt=new JButton("Next Puzzle");
		panel.add(selectBt);
		
		
		duelBt=new JButton("Duel");
		panel.add(duelBt);
		
		btl =new myButtonListener();
		selectBt.addActionListener(btl);
		
		dl=new duelListener();
		duelBt.addActionListener(dl);
		
		r=new Random(System.currentTimeMillis());
		
		this.setSize(400, 200);
		this.setContentPane(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	public void getPuzzle(){
		//methodos gia na pairnoume tyxaia ton epomeno grifo
		
		int currCode=r.nextInt(5);
		System.out.println(currCode);
		//na allaksei analoga me to plhthos twn grifwn pou tha baloume
		System.out.println(currCode);
		for(Puzzle p:(puzzles.getPuzzles())){
			System.out.println("this code is: " +p.getCode());
			int c=p.getCode();
			if ((currCode+1)==c){
				//prosthetoume +1 giati to random ksekinaei apo to 0
				p.startPuzzle();
				//kaleitai o kataskeyasths tou sygkekrimenou puzzle
				
			}
				
		}
		
	}
	
	
	public class myButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
	
		getPuzzle();
		
		}
	}
	
	class duelListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			new DuelBoardFrame(userToFight);
			
		}
		
	}
}
