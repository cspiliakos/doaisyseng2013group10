import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class HangmanFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X;
	private JLabel hanglbl;
	private JPanel buttonPanel, letterPanel;
	private int helpWidth, helpHeight, widthSize, heightSize, charSize, miss, success;
	private double frameWidth, frameHeight;
	private ArrayList<String> words, usedWords;
	private JLabel[] letterlbl, undercore;
	private String newWord;
	private Random r;
	private char[] currWord;
	private letterButtonListener letterL;
	private BackgroundPanel back;
	@SuppressWarnings("unused")
	private Image background, hero, resize , hero2, helpImage;
	private ImageIcon helpIcon;
	private User player;
	
	public HangmanFrame(User u){
		player = u;
		try {
			background = ImageIO.read(new File("Hangman\\back1.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		back = new BackgroundPanel(background);
		back.setLayout(new BorderLayout(5, 5));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true);
		setContentPane(back);
		setVisible(true);
		
		r = new Random(System.currentTimeMillis());
		miss = 0;
		success = 0;
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameWidth = screenSize.getWidth();
		frameHeight = screenSize.getHeight();
		helpWidth = (int)frameWidth;
		helpHeight = (int)frameHeight;
		widthSize = helpWidth / 3;
		heightSize = helpHeight - helpHeight / 7;
		
		words = new ArrayList<String>();
		usedWords = new ArrayList<String>();
		deserializing();
		getWord();
		
		letterPanel = new JPanel();
		back.add(letterPanel, BorderLayout.CENTER);
		GridBagLayout gbl_letterPanel = new GridBagLayout();
		letterPanel.setLayout(gbl_letterPanel);
		
		createLabels();
		
		buttonPanel = new JPanel();
		back.add(buttonPanel, BorderLayout.WEST);
		letterL = new letterButtonListener();
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		buttonPanel.setLayout(gbl_buttonPanel);
		
		A = new JButton("�");
		A.setBackground(Color.BLUE);
		A.setForeground(Color.ORANGE);
		A.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_A = new GridBagConstraints();
		gbc_A.fill = GridBagConstraints.BOTH;
		gbc_A.insets = new Insets(0, 0, 5, 5);
		gbc_A.gridx = 0;
		gbc_A.gridy = 0;
		buttonPanel.add(A, gbc_A);
		A.addActionListener(letterL);
		
		B = new JButton("�");
		B.setBackground(Color.BLUE);
		B.setForeground(Color.ORANGE);
		B.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_B = new GridBagConstraints();
		gbc_B.fill = GridBagConstraints.BOTH;
		gbc_B.insets = new Insets(0, 0, 5, 5);
		gbc_B.gridx = 1;
		gbc_B.gridy = 0;
		buttonPanel.add(B, gbc_B);
		B.addActionListener(letterL);
		
		C = new JButton("�");
		C.setBackground(Color.BLUE);
		C.setForeground(Color.ORANGE);
		C.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_C = new GridBagConstraints();
		gbc_C.fill = GridBagConstraints.BOTH;
		gbc_C.insets = new Insets(0, 0, 5, 5);
		gbc_C.gridx = 2;
		gbc_C.gridy = 0;
		buttonPanel.add(C, gbc_C);
		C.addActionListener(letterL);
		
		D = new JButton("�");
		D.setBackground(Color.BLUE);
		D.setForeground(Color.ORANGE);
		D.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_D = new GridBagConstraints();
		gbc_D.fill = GridBagConstraints.BOTH;
		gbc_D.insets = new Insets(0, 0, 5, 0);
		gbc_D.gridx = 3;
		gbc_D.gridy = 0;
		buttonPanel.add(D, gbc_D);
		D.addActionListener(letterL);
		
		E = new JButton("�");
		E.setBackground(Color.BLUE);
		E.setForeground(Color.ORANGE);
		E.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_E = new GridBagConstraints();
		gbc_E.fill = GridBagConstraints.BOTH;
		gbc_E.insets = new Insets(0, 0, 5, 5);
		gbc_E.gridx = 0;
		gbc_E.gridy = 1;
		buttonPanel.add(E, gbc_E);
		E.addActionListener(letterL);
		
		F = new JButton("�");
		F.setBackground(Color.BLUE);
		F.setForeground(Color.ORANGE);
		F.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_F = new GridBagConstraints();
		gbc_F.fill = GridBagConstraints.BOTH;
		gbc_F.insets = new Insets(0, 0, 5, 5);
		gbc_F.gridx = 1;
		gbc_F.gridy = 1;
		buttonPanel.add(F, gbc_F);
		F.addActionListener(letterL);
		
		G = new JButton("�");
		G.setBackground(Color.BLUE);
		G.setForeground(Color.ORANGE);
		G.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_G = new GridBagConstraints();
		gbc_G.fill = GridBagConstraints.BOTH;
		gbc_G.insets = new Insets(0, 0, 5, 5);
		gbc_G.gridx = 2;
		gbc_G.gridy = 1;
		buttonPanel.add(G, gbc_G);
		G.addActionListener(letterL);
		
		H = new JButton("�");
		H.setBackground(Color.BLUE);
		H.setForeground(Color.ORANGE);
		H.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_H = new GridBagConstraints();
		gbc_H.fill = GridBagConstraints.BOTH;
		gbc_H.insets = new Insets(0, 0, 5, 0);
		gbc_H.gridx = 3;
		gbc_H.gridy = 1;
		buttonPanel.add(H, gbc_H);
		H.addActionListener(letterL);
		
		I = new JButton("�");
		I.setBackground(Color.BLUE);
		I.setForeground(Color.ORANGE);
		I.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_I = new GridBagConstraints();
		gbc_I.fill = GridBagConstraints.BOTH;
		gbc_I.insets = new Insets(0, 0, 5, 5);
		gbc_I.gridx = 0;
		gbc_I.gridy = 2;
		buttonPanel.add(I, gbc_I);
		I.addActionListener(letterL);
		
		J = new JButton("�");
		J.setBackground(Color.BLUE);
		J.setForeground(Color.ORANGE);
		J.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_J = new GridBagConstraints();
		gbc_J.fill = GridBagConstraints.BOTH;
		gbc_J.insets = new Insets(0, 0, 5, 5);
		gbc_J.gridx = 1;
		gbc_J.gridy = 2;
		buttonPanel.add(J, gbc_J);
		J.addActionListener(letterL);
		
		K = new JButton("�");
		K.setBackground(Color.BLUE);
		K.setForeground(Color.ORANGE);
		K.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_K = new GridBagConstraints();
		gbc_K.fill = GridBagConstraints.BOTH;
		gbc_K.insets = new Insets(0, 0, 5, 5);
		gbc_K.gridx = 2;
		gbc_K.gridy = 2;
		buttonPanel.add(K, gbc_K);
		K.addActionListener(letterL);
		
		L = new JButton("�");
		L.setBackground(Color.BLUE);
		L.setForeground(Color.ORANGE);
		L.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_L = new GridBagConstraints();
		gbc_L.fill = GridBagConstraints.BOTH;
		gbc_L.insets = new Insets(0, 0, 5, 0);
		gbc_L.gridx = 3;
		gbc_L.gridy = 2;
		buttonPanel.add(L, gbc_L);
		L.addActionListener(letterL);
		
		M = new JButton("�");
		M.setBackground(Color.BLUE);
		M.setForeground(Color.ORANGE);
		M.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_M = new GridBagConstraints();
		gbc_M.fill = GridBagConstraints.BOTH;
		gbc_M.insets = new Insets(0, 0, 5, 5);
		gbc_M.gridx = 0;
		gbc_M.gridy = 3;
		buttonPanel.add(M, gbc_M);
		M.addActionListener(letterL);
		
		N = new JButton("�");
		N.setBackground(Color.BLUE);
		N.setForeground(Color.ORANGE);
		N.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_N = new GridBagConstraints();
		gbc_N.fill = GridBagConstraints.BOTH;
		gbc_N.insets = new Insets(0, 0, 5, 5);
		gbc_N.gridx = 1;
		gbc_N.gridy = 3;
		buttonPanel.add(N, gbc_N);
		N.addActionListener(letterL);
		
		O = new JButton("�");
		O.setBackground(Color.BLUE);
		O.setForeground(Color.ORANGE);
		O.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_O = new GridBagConstraints();
		gbc_O.fill = GridBagConstraints.BOTH;
		gbc_O.insets = new Insets(0, 0, 5, 5);
		gbc_O.gridx = 2;
		gbc_O.gridy = 3;
		buttonPanel.add(O, gbc_O);
		O.addActionListener(letterL);
		
		P = new JButton("�");
		P.setBackground(Color.BLUE);
		P.setForeground(Color.ORANGE);
		P.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_P = new GridBagConstraints();
		gbc_P.fill = GridBagConstraints.BOTH;
		gbc_P.insets = new Insets(0, 0, 5, 0);
		gbc_P.gridx = 3;
		gbc_P.gridy = 3;
		buttonPanel.add(P, gbc_P);
		P.addActionListener(letterL);
		
		Q = new JButton("�");
		Q.setBackground(Color.BLUE);
		Q.setForeground(Color.ORANGE);
		Q.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_Q = new GridBagConstraints();
		gbc_Q.fill = GridBagConstraints.BOTH;
		gbc_Q.insets = new Insets(0, 0, 5, 5);
		gbc_Q.gridx = 0;
		gbc_Q.gridy = 4;
		buttonPanel.add(Q, gbc_Q);
		Q.addActionListener(letterL);
		
		R = new JButton("�");
		R.setBackground(Color.BLUE);
		R.setForeground(Color.ORANGE);
		R.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_R = new GridBagConstraints();
		gbc_R.fill = GridBagConstraints.BOTH;
		gbc_R.insets = new Insets(0, 0, 5, 5);
		gbc_R.gridx = 1;
		gbc_R.gridy = 4;
		buttonPanel.add(R, gbc_R);
		R.addActionListener(letterL);
		
		S = new JButton("�");
		S.setBackground(Color.BLUE);
		S.setForeground(Color.ORANGE);
		S.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_S = new GridBagConstraints();
		gbc_S.fill = GridBagConstraints.BOTH;
		gbc_S.insets = new Insets(0, 0, 5, 5);
		gbc_S.gridx = 2;
		gbc_S.gridy = 4;
		buttonPanel.add(S, gbc_S);
		S.addActionListener(letterL);
		
		T = new JButton("�");
		T.setBackground(Color.BLUE);
		T.setForeground(Color.ORANGE);
		T.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_T = new GridBagConstraints();
		gbc_T.fill = GridBagConstraints.BOTH;
		gbc_T.insets = new Insets(0, 0, 5, 0);
		gbc_T.gridx = 3;
		gbc_T.gridy = 4;
		buttonPanel.add(T, gbc_T);
		T.addActionListener(letterL);
		
		U = new JButton("�");
		U.setBackground(Color.BLUE);
		U.setForeground(Color.ORANGE);
		U.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_U = new GridBagConstraints();
		gbc_U.fill = GridBagConstraints.BOTH;
		gbc_U.insets = new Insets(0, 0, 0, 5);
		gbc_U.gridx = 0;
		gbc_U.gridy = 5;
		buttonPanel.add(U, gbc_U);
		U.addActionListener(letterL);
		
		V = new JButton("�");
		V.setBackground(Color.BLUE);
		V.setForeground(Color.ORANGE);
		V.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_V = new GridBagConstraints();
		gbc_V.fill = GridBagConstraints.BOTH;
		gbc_V.insets = new Insets(0, 0, 0, 5);
		gbc_V.gridx = 1;
		gbc_V.gridy = 5;
		buttonPanel.add(V, gbc_V);
		V.addActionListener(letterL);
		
		W = new JButton("�");
		W.setBackground(Color.BLUE);
		W.setForeground(Color.ORANGE);
		W.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_W = new GridBagConstraints();
		gbc_W.fill = GridBagConstraints.BOTH;
		gbc_W.insets = new Insets(0, 0, 0, 5);
		gbc_W.gridx = 2;
		gbc_W.gridy = 5;
		buttonPanel.add(W, gbc_W);
		W.addActionListener(letterL);
		
		X = new JButton("�");
		X.setBackground(Color.BLUE);
		X.setForeground(Color.ORANGE);
		X.setFont(new Font("Sylfaen", Font.BOLD, 30));
		GridBagConstraints gbc_X = new GridBagConstraints();
		gbc_X.fill = GridBagConstraints.BOTH;
		gbc_X.gridx = 3;
		gbc_X.gridy = 5;
		buttonPanel.add(X, gbc_X);
		X.addActionListener(letterL);
		
		hanglbl = new JLabel();
		helpIcon = new ImageIcon("Hangman\\gallow.gif");
		helpImage = helpIcon.getImage();
		resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
		hanglbl.setIcon(new ImageIcon(resize));
		back.add(hanglbl, BorderLayout.EAST);
	}
	
	public void getWord(){
		int randomIndex = r.nextInt(words.size());
		newWord = words.get(randomIndex);

		if (usedWords.size() == words.size())
		{
			usedWords = new ArrayList<String>();
		}

		while (usedWords.contains(newWord)){
			randomIndex = r.nextInt(words.size());
			newWord = words.get(randomIndex);
		}
		usedWords.add(newWord);
		currWord = newWord.toCharArray();
		charSize = currWord.length;
	}

	public void createLabels() {
		letterlbl = new JLabel[charSize];
		undercore = new JLabel[charSize];
		for(int i = 0; i < charSize; i++){
			String j = Character.toString(currWord[i]);
			letterlbl[i] = new JLabel(j);		
			letterlbl[i].setForeground(Color.MAGENTA);
			letterlbl[i].setFont(new Font("Arial",Font.BOLD,30));
			GridBagConstraints gbc_letter = new GridBagConstraints();
			gbc_letter.gridx = i;
			gbc_letter.gridy = 0;
			letterlbl[i].setVisible(false);
			letterPanel.add(letterlbl[i], gbc_letter);
			undercore[i] = new JLabel(" _ ");		
			undercore[i].setForeground(Color.RED);
			undercore[i].setFont(new Font("Arial", Font.BOLD, 50));
			GridBagConstraints gbc_undercore = new GridBagConstraints();
			gbc_undercore.gridx = i;
			gbc_undercore.gridy = 0;
			undercore[i].setVisible(true);
			letterPanel.add(undercore[i], gbc_undercore);
		}
	}

	public void hangmanIcon() {
		switch (miss) {
		case 1:	helpIcon = new ImageIcon("Hangman\\gallow1.gif");
			helpImage = helpIcon.getImage();
			resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
			hanglbl.setIcon(new ImageIcon(resize));
			break;
		case 2:	helpIcon = new ImageIcon("Hangman\\gallow2.gif");
			helpImage = helpIcon.getImage();
			resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
			hanglbl.setIcon(new ImageIcon(resize));
			break; 
		case 3: helpIcon=new ImageIcon("Hangman\\gallow3.gif");
			helpImage = helpIcon.getImage();
			resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
			hanglbl.setIcon(new ImageIcon(resize));
			break;
		case 4: helpIcon = new ImageIcon("Hangman\\gallow4.gif");
			helpImage = helpIcon.getImage();
			resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
			hanglbl.setIcon(new ImageIcon(resize));
			break;
		case 5: helpIcon = new ImageIcon("Hangman\\gallow5.gif");
			helpImage = helpIcon.getImage();
			resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
			hanglbl.setIcon(new ImageIcon(resize));
			break;
		case 6:	helpIcon = new ImageIcon("Hangman\\gallow6.gif");
			helpImage = helpIcon.getImage();
			resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
			hanglbl.setIcon(new ImageIcon(resize));
			break;
		default: helpIcon = new ImageIcon("Hangman\\gallow.gif");
			helpImage = helpIcon.getImage();
			resize = helpImage.getScaledInstance(widthSize, heightSize, 0);
			hanglbl.setIcon(new ImageIcon(resize));
			break;
		}
	}

	@SuppressWarnings("unchecked")
	public void deserializing() {
		try {
			FileInputStream fileIn = new FileInputStream("Words.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			words = (ArrayList<String>) in.readObject();
			in.close();
			fileIn.close();	
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
	}
	
	public class letterButtonListener implements ActionListener{
		boolean found = false;

			public void checkIfLetterExists(String letter) {
				for(int i = 0; i < charSize; i++)
				{
					String j = Character.toString(currWord[i]);
					if (letter.equals(j))
					{
						letterlbl[i].setVisible(true);
						success++;
						found = true;
					}
				} 
				
				if(!found)
				{
					miss++;
					hangmanIcon();
				}
				
				if(success == charSize) 
				{
					HangmanFrame.this.setVisible(false);
					player.setWin(true);
					player.setCoins(player.getCoins() + 1000);
					player.setXP(player.getXP() + 1000);
					JOptionPane.showMessageDialog(null, "������ �� ����.", "��������", JOptionPane.INFORMATION_MESSAGE);
				}
				
				if(miss == 6)
				{
					HangmanFrame.this.setVisible(false);
					player.setWin(false);
					JOptionPane.showMessageDialog(null, "�� ������ �� ����", "��������", JOptionPane.ERROR_MESSAGE);
				}
				found = false;
			}
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == A)
				{
					checkIfLetterExists("�");
					A.removeActionListener(letterL);
					A.setEnabled(false);
				}
				else if(e.getSource() == B)
				{
					checkIfLetterExists("�");
					B.removeActionListener(letterL);
					B.setEnabled(false);
				}
				else if(e.getSource() == C)
				{
					checkIfLetterExists("�");
					C.removeActionListener(letterL);
					C.setEnabled(false);
				}
				else if(e.getSource() == D)
				{
					checkIfLetterExists("�");
					D.removeActionListener(letterL);
					D.setEnabled(false);
				}
				else if(e.getSource() == E)
				{
					checkIfLetterExists("�");
					E.removeActionListener(letterL);
					E.setEnabled(false);
				}
				else if(e.getSource() == F)
				{
					checkIfLetterExists("�");
					F.removeActionListener(letterL);
					F.setEnabled(false);
				}
				else if(e.getSource() == G)
				{
					checkIfLetterExists("�");
					G.removeActionListener(letterL);
					G.setEnabled(false);
				}
				else if(e.getSource() == H)
				{
					checkIfLetterExists("�");
					H.removeActionListener(letterL);
					H.setEnabled(false);
				}
				else if(e.getSource() == I)
				{
					checkIfLetterExists("�");
					I.removeActionListener(letterL);
					I.setEnabled(false);
				}
				else if(e.getSource() == J)
				{
					checkIfLetterExists("�");
					J.removeActionListener(letterL);
					J.setEnabled(false);
				}
				else if(e.getSource() == K)
				{
					checkIfLetterExists("�");
					K.removeActionListener(letterL);
					K.setEnabled(false);
				}
				else if(e.getSource() == L)
				{
					checkIfLetterExists("�");
					L.removeActionListener(letterL);
					L.setEnabled(false);
				}
				else if(e.getSource() == M)
				{
					checkIfLetterExists("�");
					M.removeActionListener(letterL);
					M.setEnabled(false);
				}
				else if(e.getSource() == N)
				{
					checkIfLetterExists("�");
					N.removeActionListener(letterL);
					N.setEnabled(false);
				}
				else if(e.getSource() == O)
				{
					checkIfLetterExists("�");
					O.removeActionListener(letterL);
					O.setEnabled(false);
				}
				else if(e.getSource() == P)
				{
					checkIfLetterExists("�");
					P.removeActionListener(letterL);
					P.setEnabled(false);
				}
				else if(e.getSource() == Q)
				{
					checkIfLetterExists("�");
					Q.removeActionListener(letterL);
					Q.setEnabled(false);
				}
				else if(e.getSource() == R)
				{
					checkIfLetterExists("�");
					R.removeActionListener(letterL);
					R.setEnabled(false);
				}
				else if(e.getSource() == S)
				{
					checkIfLetterExists("�");
					S.removeActionListener(letterL);
					S.setEnabled(false);
				}
				else if(e.getSource() == T)
				{
					checkIfLetterExists("�");
					T.removeActionListener(letterL);
					T.setEnabled(false);
				}
				else if(e.getSource() == U)
				{
					checkIfLetterExists("�");
					U.removeActionListener(letterL);
					U.setEnabled(false);
				}
				else if(e.getSource() == V)
				{
					checkIfLetterExists("�");
					V.removeActionListener(letterL);
					V.setEnabled(false);
				}
				else if(e.getSource() == W)
				{
					checkIfLetterExists("�");
					W.removeActionListener(letterL);
					W.setEnabled(false);
				}
				else if(e.getSource() == X)
				{
					checkIfLetterExists("�");
					X.removeActionListener(letterL);
					X.setEnabled(false);
				}
			}
		}
}
