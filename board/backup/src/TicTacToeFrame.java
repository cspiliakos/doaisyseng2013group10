import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TicTacToeFrame implements ActionListener{
	private JFrame window = new JFrame();
	private JMenuBar mnuMain = new JMenuBar();	
	private JButton btnEmpty[] = new JButton[10];
	private JButton btnTryAgain = new JButton("Ξαναπαίξε");
	private JPanel 	pnlNewGame = new JPanel(),
			pnlMenu = new JPanel(),
			pnlMain = new JPanel(),
			pnlTop = new JPanel(),
			pnlBottom = new JPanel(),
			pnlQuitNTryAgain = new JPanel(),
			pnlPlayingField = new JPanel();
	private JLabel 	lblTitle = new JLabel("Tic-Tac-Toe"),
			lblTurn = new JLabel(),
			lblStatus = new JLabel("", JLabel.CENTER),
			lblMode = new JLabel("", JLabel.LEFT);
	private JLabel back_lbl = new JLabel();
	private JTextArea txtMessage = new JTextArea();
	private int lives=3;
	private final int winCombo[][] = new int[][]	{
			{1, 2, 3}, 			{1, 4, 7}, 		{1, 5, 9},
			{4, 5, 6}, 			{2, 5, 8}, 		{3, 5, 7},
			{7, 8, 9}, 			{3, 6, 9}
			/*Horizontal Wins*/	/*Vertical Wins*/ /*Diagonal Wins*/
	};
	@SuppressWarnings("unused")
	private final int X = 535, Y = 342,
			mainColorR = 190, mainColorG = 50, mainColorB = 50,
			btnColorR = 70, btnColorG = 70, btnColorB = 70;
	private Color clrBtnWonColor = new Color(190, 190, 190);
	private int 	turn = 1,
			player1Won = 0,
		   	draws=0,
		   	loses=0,
			wonNumber1 = 1, wonNumber2 = 1, wonNumber3 = 1;
	private boolean CPUGame = false,
			win = false;
	@SuppressWarnings("unused")
	private String 	message,
	Player1 = "Player 1", Player2 = "Player 2",
	tempPlayer2 = "Player 2";
	private final JPanel GeneralPnl = new JPanel();
	ArrayList<AudiosPair> list = new ArrayList<AudiosPair>(new Audios().getTicTacToeList()); 
	Sound_Thread soundthread1 = new Sound_Thread(); //Thread 1 gia mikrous hxous, pou diakoptei o enas ton allon
	Sound_Thread soundthread2 = new Sound_Thread(); //Thread 2 gia soundtrack
	private User player;

	public TicTacToeFrame(User u)	{
		window.setJMenuBar(new JMenuFrame().getMenu()); // Getting the Menu from the JMenuFrame
		player = u;
		soundthread2.PlayMusic(list.get(1).getSongName(), list.get(1).getRepeat());   //Sound soundtrack
	
		//Getting Dimensions
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		//Setting window properties:
		window.setSize((int) width,(int) height);
		window.setLocation(0, 0);
		window.setUndecorated(true);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pnlNewGame.setBackground(new Color(mainColorR - 50, mainColorG - 50, mainColorB- 50));

		//Adding buttons to NewGame panel
		pnlNewGame.setLayout(new GridLayout(4, 1, 2, 10));

		//Setting txtMessage Properties
		txtMessage.setBackground(new Color(mainColorR-30, mainColorG-30, mainColorB-30));
		txtMessage.setForeground(Color.white);
		txtMessage.setEditable(false);
		for(int i=1; i<=9; i++)	{
			btnEmpty[i] = new JButton();
			btnEmpty[i].setBackground(new Color(btnColorR, btnColorG, btnColorB));
			btnEmpty[i].addActionListener(this);
			pnlPlayingField.add(btnEmpty[i]);//	Playing Field is Compelte
		}

		GeneralPnl.setBounds(0, 0,(int) width,(int) height); //General Panel is in fullscreen
		window.getContentPane().add(GeneralPnl);
		GeneralPnl.setLayout(null);

		//Setting Menu, Main, Top, Bottom Panel Layout/Backgrounds
		pnlMenu.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlMenu.setBackground(new Color((mainColorR - 50), (mainColorG - 50), (mainColorB- 50)));

		//Adding everything needed to pnlMenu and pnlMain
		lblMode.setForeground(Color.white);
		pnlMenu.add(lblMode);
		pnlMenu.add(mnuMain);
		pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlBottom.setLayout(new FlowLayout(FlowLayout.CENTER));

		pnlMain.setBounds((int) width/3,(int) (height/4) ,(int) width/3, (int) (2*(height/4)) ); // 1/3 ths othonhs
		GeneralPnl.add(pnlMain);

		pnlMenu.setBounds(pnlMain.getX(), pnlMain.getY()-50, pnlMain.getWidth(), 40 );
		GeneralPnl.add(pnlMenu);
		pnlMain.setBackground(new Color(mainColorR, mainColorG, mainColorB));
		pnlTop.setBackground(new Color(mainColorR, mainColorG, mainColorB));
		pnlBottom.setBackground(new Color(mainColorR, mainColorG, mainColorB));

		GeneralPnl.add(btnTryAgain);
		btnTryAgain.setBounds(pnlMain.getX(), pnlMain.getY()+pnlMain.getHeight(), 100, 35);
		btnTryAgain.setEnabled(false);  //arxika den einai enabled
		//Setting up Panel QuitNTryAgain
		pnlQuitNTryAgain.setLayout(new GridLayout(1, 2, 2, 2));

		//Adding Action Listener to all the Buttons and Menu Items
		btnTryAgain.addActionListener(this);

		//Setting up the playing field
		pnlPlayingField.setLayout(new GridLayout(3, 3, 2, 2));
		pnlPlayingField.setBackground(Color.black);
		pnlMain.add(lblTitle);
		pnlMain.setLayout(new BorderLayout());
		pnlTop.setLayout(new BorderLayout());
		pnlBottom.setLayout(new BorderLayout());
		 
		// IMAGE BACKGROUND
		back_lbl.setBounds(0, 0, (int) width, (int) height);
		ImageIcon img_icn = new ImageIcon("UIcons\\tic_tac_toe_background.jpg");
		Image img = img_icn.getImage().getScaledInstance(back_lbl.getWidth(), back_lbl.getHeight(), 0);
				
		back_lbl.setIcon(new ImageIcon(img) );
		GeneralPnl.add(back_lbl);
	
		window.repaint();//Refresh the image
		beginToPlay();
		/**
		//player vs computer epiloges ktl
		clearPanelSouth();
		setDefaultLayout();
		pnlTop.add(pnlNewGame);
		pnlMain.add(pnlTop);
		 **/
	}

	public void beginToPlay(){
		Player2 = "Computer";
		player1Won=0;
		lblMode.setText("Τρίλιζα  Ζωές = "+lives +"  Νίκες = "+ player1Won +"  Ισοπαλίες = "+draws +"  Ήττες = "+loses);
		CPUGame = true;
		newGame();
		
		pnlMain.setVisible(false);
		pnlMain.setVisible(true);
	}
	
	
	public void showGame()	{
		clearPanelSouth();
		pnlTop.add(pnlPlayingField);
		pnlBottom.add(lblTurn, BorderLayout.WEST);
		pnlBottom.add(lblStatus, BorderLayout.CENTER);
		pnlBottom.add(pnlQuitNTryAgain, BorderLayout.EAST);
		pnlMain.add(pnlTop, BorderLayout.CENTER);
		pnlMain.add(pnlBottom, BorderLayout.SOUTH);
		pnlPlayingField.requestFocus();
		checkWinStatus();
	}
		
	public void newGame() {
		btnEmpty[wonNumber1].setBackground(new Color(btnColorR, btnColorG, btnColorB));
		btnEmpty[wonNumber2].setBackground(new Color(btnColorR, btnColorG, btnColorB));
		btnEmpty[wonNumber3].setBackground(new Color(btnColorR, btnColorG, btnColorB));
		for(int i=1; i<10; i++)	{
			btnEmpty[i].setText("");
			btnEmpty[i].setIcon(null);
			btnEmpty[i].setEnabled(true);
		}
		turn = 1;
		win = false;
		showGame();
	}
	
	public void quit() {
		lblMode.setText("");
		clearPanelSouth();
		setDefaultLayout();
		pnlTop.add(pnlNewGame);
		pnlMain.add(pnlTop);
	}
		
	public void checkWin()	{
		for(int i=0; i<8; i++)	{
			if(
					!btnEmpty[winCombo[i][0]].getText().equals("") &&
					btnEmpty[winCombo[i][0]].getText().equals(btnEmpty[winCombo[i][1]].getText()) &&
					//								if {1 == 2 && 2 == 3}
					btnEmpty[winCombo[i][1]].getText().equals(btnEmpty[winCombo[i][2]].getText()))	{
				
				win = true;
				wonNumber1 = winCombo[i][0];
				wonNumber2 = winCombo[i][1];
				wonNumber3 = winCombo[i][2];
				btnEmpty[wonNumber1].setBackground(clrBtnWonColor);
				btnEmpty[wonNumber2].setBackground(clrBtnWonColor);
				btnEmpty[wonNumber3].setBackground(clrBtnWonColor);
				break;
			}
		}
		if(win || (!win && turn>9))	{
			if(win)	{
				if(btnEmpty[wonNumber1].getText().equals("X"))	{
					message = "Συγχαρητηρια νίκησες!";           //***********PLAYER WINS  (X)**********//
					showMessage(message);
					player1Won++;
					
					if(player1Won == 3){   // 3 WINS -> EXIT
						message = "3 Νίκες!";         
						showMessage(message);
						window.setVisible(false);      soundthread2.StopMusic();
						player.setCoins(player.getCoins() + 1000);
						player.setXP(player.getXP() + 1000);
						player.setWin(true);
						player.setPlayed(true);
					}
				}
				else	{
					message ="Έχασες...!";                       //***********PLAYER LOSES (O)**********//
					showMessage(message);
					lives--;
					loses++;
					if(lives== 0)  {       //0 LIVES -> EXIT
						message = "3 Ήττες!";         
						showMessage(message);
						window.setVisible(false);    soundthread2.StopMusic();
						player.setWin(false);
						player.setPlayed(true);
					}

				}
			}	else if(!win && turn>9)      {       //***********  DRAW   *********//
				message = "Ισοπαλία!";                            
				showMessage(message);
				draws++;
				if(draws== 3)  {       //3 DRAWS -> EXIT
					message = "3 Ισοπαλίες!";          
					showMessage(message);
					window.setVisible(false);       soundthread2.StopMusic();
					player.setCoins(player.getCoins() + 500);
					player.setXP(player.getXP() + 500);
					player.setWin(true);
					player.setPlayed(true);
				}
			}
				
			for(int i=1; i<=9; i++)	{
				btnEmpty[i].setEnabled(false);
			}
			btnTryAgain.setEnabled(true);
			checkWinStatus();
			lblMode.setText("Τρίλιζα  Ζωές = "+lives +"  Νίκες = "+ player1Won +"  Ισοπαλίες = "+draws +"  Ήττες = "+loses);
		}
	}
	
	public void AI()	{
		int computerButton;
		if(turn <= 9)	{
			turn++;
			computerButton = TicTacToeCPU.doMove(
					btnEmpty[1], btnEmpty[2], btnEmpty[3],
					btnEmpty[4], btnEmpty[5], btnEmpty[6],
					btnEmpty[7], btnEmpty[8], btnEmpty[9]);
			if(computerButton == 0)
				Random();
			else {
				
				ImageIcon oIcon=new ImageIcon("tictactoe_shield.jpg");
				Image oImage=oIcon.getImage();
				Image oResizedImage=oImage.getScaledInstance(btnEmpty[computerButton].getWidth(), btnEmpty[computerButton].getHeight(), 0);
				btnEmpty[computerButton].setIcon(new ImageIcon(oResizedImage));
				btnEmpty[computerButton].setText("O");
			}
			checkWin();
		}
	}
	
	public void Random()	{
		int random;
		if(turn <= 9)	{
			random = 0;
			while(random == 0)	{
				random = (int)(Math.random() * 10);
			}
			if(TicTacToeCPU.doRandomMove(btnEmpty[random]))	{
				ImageIcon oIcon=new ImageIcon("tictactoe_shield.jpg");
				Image oImage=oIcon.getImage();
				Image oResizedImage=oImage.getScaledInstance(btnEmpty[random].getWidth(), btnEmpty[random].getHeight(), 0);
				btnEmpty[random].setIcon(new ImageIcon(oResizedImage));
				btnEmpty[random].setText("O");
			} else {
				Random();
			}
		}
	}
	
	public void setDefaultLayout()	{
		pnlMain.setLayout(new GridLayout(2, 1, 2, 5));
		pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	
	public void checkWinStatus()	{
		lblStatus.setText("Παίκτη1 : " + player1Won );	
	}
		
	public int askMessage(String msg, String tle, int op)	{
		return JOptionPane.showConfirmDialog(null, msg, tle, op);
	}
	
	public String getInput(String msg, String setText)	{
		return JOptionPane.showInputDialog(null, msg, setText);
	}
	
	public void showMessage(String msg)	{
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public void clearPanelSouth()	{
		pnlMain.remove(lblTitle);
		pnlMain.remove(pnlTop);
		pnlMain.remove(pnlBottom);
		pnlTop.remove(pnlNewGame);
		pnlTop.remove(txtMessage);
		pnlTop.remove(pnlPlayingField);
		pnlBottom.remove(lblTurn);
		pnlBottom.remove(pnlQuitNTryAgain);
	}
	
	public void actionPerformed(ActionEvent click)	{
		soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat());   //Sound click
		
		Object source = click.getSource();
		for(int i=1; i<=9; i++)	{
			if(source == btnEmpty[i] && turn <	10)	{
				String btnText=btnEmpty[i].getText();
				int btnLength=btnText.length();
				if(btnLength==0){
				if(!(turn % 2 == 0)){
					ImageIcon xIcon=new ImageIcon("tictactoe_swords.jpg");
					Image xImage=xIcon.getImage();
					Image xResizedImage=xImage.getScaledInstance(btnEmpty[i].getWidth(), btnEmpty[i].getHeight(), 0);
					btnEmpty[i].setIcon(new ImageIcon(xResizedImage));	
					
					btnEmpty[i].setText("X");
				}	
				else
				{
					ImageIcon oIcon=new ImageIcon("tictactoe_shield.jpg");
					Image oImage=oIcon.getImage();
					Image oResizedImage=oImage.getScaledInstance(btnEmpty[i].getWidth(), btnEmpty[i].getHeight(), 0);
					btnEmpty[i].setIcon(new ImageIcon(oResizedImage));
					btnEmpty[i].setText("O");
				}
				pnlPlayingField.requestFocus();
				turn++;
				checkWin();
				if(CPUGame && win == false)
					AI();
				}
			}
		}

		if(source == btnTryAgain)	{
			newGame();
			btnTryAgain.setEnabled(false);
		}
		pnlMain.setVisible(false);
		pnlMain.setVisible(true);
	}
}