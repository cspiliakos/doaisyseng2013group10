import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class HangmanFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
	private JLabel hanglbl, backlbl;
	private JPanel buttonPanel, mainPanel;
	private int widthSize, heightSize, miss=0,success=0, charSize,iwidth,iheight;
	private hangGlassPane hangGP;
	private ArrayList<String> words, usedWords;
	private JLabel[] letterlbl;
	private String newWord;
	private Random r;
	private char[] currWord;
	private letterButtonListener letterL;
	
	public HangmanFrame(){
		
		r = new Random(System.currentTimeMillis());
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double fwidth = screenSize.getWidth();
		double fheight = screenSize.getHeight();

		iwidth=(int)fwidth;
		iheight=(int)fheight;
		//this.setUndecorated(true);
		//this.setLocation(0,0);
		
		widthSize=iwidth/20;
		heightSize=iheight/10;
		
		setBounds(0, 0, iwidth, iheight);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		words=new ArrayList<String>();
		usedWords=new ArrayList<String>();
		deserializing();
		getWord();
		
		A=new JButton("A");
		A.setBackground(Color.BLUE);
		A.setForeground(Color.ORANGE);
		A.setFont(new Font("Jokerman",Font.BOLD,30));
		B=new JButton("B");
		B.setBackground(Color.BLUE);
		B.setForeground(Color.ORANGE);
		B.setFont(new Font("Jokerman",Font.BOLD,30));
		C=new JButton("C");
		C.setBackground(Color.BLUE);
		C.setForeground(Color.ORANGE);
		C.setFont(new Font("Jokerman",Font.BOLD,30));
		D=new JButton("D");
		D.setBackground(Color.BLUE);
		D.setForeground(Color.ORANGE);
		D.setFont(new Font("Jokerman",Font.BOLD,30));
		E=new JButton("E");
		E.setBackground(Color.BLUE);
		E.setForeground(Color.ORANGE);
		E.setFont(new Font("Jokerman",Font.BOLD,30));
		F=new JButton("F");
		F.setBackground(Color.BLUE);
		F.setForeground(Color.ORANGE);
		F.setFont(new Font("Jokerman",Font.BOLD,30));
		G=new JButton("G");
		G.setBackground(Color.BLUE);
		G.setForeground(Color.ORANGE);
		G.setFont(new Font("Jokerman",Font.BOLD,30));
		H=new JButton("H");
		H.setBackground(Color.BLUE);
		H.setForeground(Color.ORANGE);
		H.setFont(new Font("Jokerman",Font.BOLD,30));
		I=new JButton("I");
		I.setBackground(Color.BLUE);
		I.setForeground(Color.ORANGE);
		I.setFont(new Font("Jokerman",Font.BOLD,30));
		J=new JButton("J");
		J.setBackground(Color.BLUE);
		J.setForeground(Color.ORANGE);
		J.setFont(new Font("Jokerman",Font.BOLD,30));
		K=new JButton("K");
		K.setBackground(Color.BLUE);
		K.setForeground(Color.ORANGE);
		K.setFont(new Font("Jokerman",Font.BOLD,30));
		L=new JButton("L");
		L.setBackground(Color.BLUE);
		L.setForeground(Color.ORANGE);
		L.setFont(new Font("Jokerman",Font.BOLD,30));
		M=new JButton("M");
		M.setBackground(Color.BLUE);
		M.setForeground(Color.ORANGE);
		M.setFont(new Font("Jokerman",Font.BOLD,30));
		N=new JButton("N");
		N.setBackground(Color.BLUE);
		N.setForeground(Color.ORANGE);
		N.setFont(new Font("Jokerman",Font.BOLD,30));
		O=new JButton("O");
		O.setBackground(Color.BLUE);
		O.setForeground(Color.ORANGE);
		O.setFont(new Font("Jokerman",Font.BOLD,30));
		P=new JButton("P");
		P.setBackground(Color.BLUE);
		P.setForeground(Color.ORANGE);
		P.setFont(new Font("Jokerman",Font.BOLD,30));
		Q=new JButton("Q");
		Q.setBackground(Color.BLUE);
		Q.setForeground(Color.ORANGE);
		Q.setFont(new Font("Jokerman",Font.BOLD,30));
		R=new JButton("R");
		R.setBackground(Color.BLUE);
		R.setForeground(Color.ORANGE);
		R.setFont(new Font("Jokerman",Font.BOLD,30));
		S=new JButton("S");
		S.setBackground(Color.BLUE);
		S.setForeground(Color.ORANGE);
		S.setFont(new Font("Jokerman",Font.BOLD,30));
		T=new JButton("T");
		T.setBackground(Color.BLUE);
		T.setForeground(Color.ORANGE);
		T.setFont(new Font("Jokerman",Font.BOLD,30));
		U=new JButton("U");
		U.setBackground(Color.BLUE);
		U.setForeground(Color.ORANGE);
		U.setFont(new Font("Jokerman",Font.BOLD,30));
		V=new JButton("V");
		V.setBackground(Color.BLUE);
		V.setForeground(Color.ORANGE);
		V.setFont(new Font("Jokerman",Font.BOLD,30));
		W=new JButton("W");
		W.setBackground(Color.BLUE);
		W.setForeground(Color.ORANGE);
		W.setFont(new Font("Jokerman",Font.BOLD,30));
		X=new JButton("X");
		X.setBackground(Color.BLUE);
		X.setForeground(Color.ORANGE);
		X.setFont(new Font("Jokerman",Font.BOLD,30));
		Y=new JButton("Y");
		Y.setBackground(Color.BLUE);
		Y.setForeground(Color.ORANGE);
		Y.setFont(new Font("Jokerman",Font.BOLD,30));
		Z=new JButton("Z");
		Z.setBackground(Color.BLUE);
		Z.setForeground(Color.ORANGE);
		Z.setFont(new Font("Jokerman",Font.BOLD,30));
		
		buttonPanel=new JPanel(new GridLayout(7,4));
		buttonPanel.add(A);
		buttonPanel.add(B);
		buttonPanel.add(C);
		buttonPanel.add(D);
		buttonPanel.add(E);
		buttonPanel.add(F);
		buttonPanel.add(G);
		buttonPanel.add(H);
		buttonPanel.add(I);
		buttonPanel.add(J);
		buttonPanel.add(K);
		buttonPanel.add(L);
		buttonPanel.add(M);
		buttonPanel.add(N);
		buttonPanel.add(O);
		buttonPanel.add(P);
		buttonPanel.add(Q);
		buttonPanel.add(R);
		buttonPanel.add(S);
		buttonPanel.add(T);
		buttonPanel.add(U);
		buttonPanel.add(V);
		buttonPanel.add(W);
		buttonPanel.add(X);
		buttonPanel.add(Y);
		buttonPanel.add(Z);
		
		letterL=new letterButtonListener();
		A.addActionListener(letterL);
		B.addActionListener(letterL);
		C.addActionListener(letterL);
		D.addActionListener(letterL);
		E.addActionListener(letterL);
		F.addActionListener(letterL);
		G.addActionListener(letterL);
		H.addActionListener(letterL);
		I.addActionListener(letterL);
		J.addActionListener(letterL);
		K.addActionListener(letterL);
		L.addActionListener(letterL);
		M.addActionListener(letterL);
		N.addActionListener(letterL);
		O.addActionListener(letterL);
		P.addActionListener(letterL);
		Q.addActionListener(letterL);
		R.addActionListener(letterL);
		S.addActionListener(letterL);
		T.addActionListener(letterL);
		U.addActionListener(letterL);
		V.addActionListener(letterL);
		W.addActionListener(letterL);
		X.addActionListener(letterL);
		Y.addActionListener(letterL);
		Z.addActionListener(letterL);
		
		buttonPanel.setBounds(0,3*heightSize,5*widthSize,5*heightSize);
		buttonPanel.setOpaque(false);
		mainPanel.add(buttonPanel);
		
		
		ImageIcon hangIcon=new ImageIcon("gallow.gif");
		Image hang=hangIcon.getImage();
		hanglbl=new JLabel();
		hanglbl.setBounds((iwidth-(8*widthSize)), (2*heightSize), (widthSize*8), (iheight-(2*heightSize)));
		Image resizedHang=hang.getScaledInstance(hanglbl.getWidth(), hanglbl.getHeight(), 0);
		hanglbl.setIcon(new ImageIcon(resizedHang));
		
		mainPanel.add(hanglbl);
		
		hangGP=new hangGlassPane();
		this.setGlassPane(hangGP);
		hangGP.setVisible(true);
		
		createLabels();
		
		ImageIcon  background=new  ImageIcon("back1.jpg");
		Image image=background.getImage();
		backlbl=new JLabel();
		backlbl.setBounds(0,0,iwidth,iheight);
		Image resizedImage = image.getScaledInstance(backlbl.getWidth(), backlbl.getHeight(), 0);
		backlbl.setIcon(new ImageIcon(resizedImage));
		
		mainPanel.add(backlbl);
		
		
		
		
		
		this.setContentPane(mainPanel);
		this.setSize(iwidth,iheight);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
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
	currWord=newWord.toCharArray();
	System.out.println(newWord);
	charSize=currWord.length;
	System.out.println(charSize);
}

public void createLabels(){
	int x=widthSize*6,y=((heightSize*5)-51);
	letterlbl=new JLabel[charSize];
	for(int i=0;i<charSize;i++){
		String j=Character.toString(currWord[i]);
		letterlbl[i]=new JLabel(j);		
		letterlbl[i].setForeground(Color.MAGENTA);
		letterlbl[i].setFont(new Font("Arial",Font.BOLD,30));
		letterlbl[i].setBounds(x, y, 40, 50);
		mainPanel.add(letterlbl[i]);
		letterlbl[i].setVisible(false);
		x=x+45;
		
	}
}

public void hangmanIcon(){
	ImageIcon im;
	Image helpImage, resizedhelpHang;
	switch (miss){
	case 1:im=new ImageIcon("gallow1.gif");
		helpImage=im.getImage();
		hanglbl.setBounds((iwidth-(8*widthSize)), (2*heightSize), (widthSize*8), (iheight-(2*heightSize)));
		resizedhelpHang=helpImage.getScaledInstance(hanglbl.getWidth(), hanglbl.getHeight(), 0);
		hanglbl.setIcon(new ImageIcon(resizedhelpHang));
		break;
	case 2:im=new ImageIcon("gallow2.gif");
		helpImage=im.getImage();
		hanglbl.setBounds((iwidth-(8*widthSize)), (2*heightSize), (widthSize*8), (iheight-(2*heightSize)));
		resizedhelpHang=helpImage.getScaledInstance(hanglbl.getWidth(), hanglbl.getHeight(), 0);
		hanglbl.setIcon(new ImageIcon(resizedhelpHang));
		break; 
	case 3: im=new ImageIcon("gallow3.gif");
		helpImage=im.getImage();
		hanglbl.setBounds((iwidth-(8*widthSize)), (2*heightSize), (widthSize*8), (iheight-(2*heightSize)));
		resizedhelpHang=helpImage.getScaledInstance(hanglbl.getWidth(), hanglbl.getHeight(), 0);
		hanglbl.setIcon(new ImageIcon(resizedhelpHang));
		break;
	case 4: im=new ImageIcon("gallow4.gif");
		helpImage=im.getImage();
		hanglbl.setBounds((iwidth-(8*widthSize)), (2*heightSize), (widthSize*8), (iheight-(2*heightSize)));
		resizedhelpHang=helpImage.getScaledInstance(hanglbl.getWidth(), hanglbl.getHeight(), 0);
		hanglbl.setIcon(new ImageIcon(resizedhelpHang));
		break;
	case 5: im=new ImageIcon("gallow5.gif");
		helpImage=im.getImage();
		hanglbl.setBounds((iwidth-(8*widthSize)), (2*heightSize), (widthSize*8), (iheight-(2*heightSize)));
		resizedhelpHang=helpImage.getScaledInstance(hanglbl.getWidth(), hanglbl.getHeight(), 0);
		hanglbl.setIcon(new ImageIcon(resizedhelpHang));
		break;
	case 6:im=new ImageIcon("gallow6.gif");
		helpImage=im.getImage();
		hanglbl.setBounds((iwidth-(8*widthSize)), (2*heightSize), (widthSize*8), (iheight-(2*heightSize)));
		resizedhelpHang=helpImage.getScaledInstance(hanglbl.getWidth(), hanglbl.getHeight(), 0);
		hanglbl.setIcon(new ImageIcon(resizedhelpHang));
		break;
	default: im=new ImageIcon("gallow.gif");
		helpImage=im.getImage();
		hanglbl.setBounds((iwidth-(8*widthSize)), (2*heightSize), (widthSize*8), (iheight-(2*heightSize)));
		resizedhelpHang=helpImage.getScaledInstance(hanglbl.getWidth(), hanglbl.getHeight(), 0);
		hanglbl.setIcon(new ImageIcon(resizedhelpHang));
		break;
		
	
		
	}
}
	
public class letterButtonListener implements ActionListener{
	boolean found=false;

		public void checkIfLetterExists(String letter){
			
			for(int i=0;i<charSize;i++){
				System.out.println("doen");
				String j=Character.toString(currWord[i]);
				if (letter.equals(j)){
					System.out.println("found" +i);
					letterlbl[i].setVisible(true);
					success++;
					mainPanel.repaint();
					found=true;
					//return true;
				}
			} 
			
			if(!found){
				miss++;
				hangmanIcon();
				mainPanel.repaint();
			}
			if(success==charSize){
				JOptionPane.showMessageDialog(null, "YOU WIN");
			}
			if(miss==6){
				JOptionPane.showMessageDialog(null, "YOU LOSE");
			}
			found= false;
			}
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==A){
				checkIfLetterExists("a");
				A.removeActionListener(letterL);
				A.setEnabled(false);
				
			}
			else if(e.getSource()==B){
				checkIfLetterExists("b");
				B.removeActionListener(letterL);
				B.setEnabled(false);
			}
			else if(e.getSource()==C){
				checkIfLetterExists("c");
				C.removeActionListener(letterL);
				C.setEnabled(false);
			}
			else if(e.getSource()==D){
				checkIfLetterExists("d");
				D.removeActionListener(letterL);
				D.setEnabled(false);
			}
			else if(e.getSource()==E){
				checkIfLetterExists("e");
				E.removeActionListener(letterL);
				E.setEnabled(false);
			}
			else if(e.getSource()==F){
				checkIfLetterExists("f");
				F.removeActionListener(letterL);
				F.setEnabled(false);
			}
			else if(e.getSource()==G){
				checkIfLetterExists("g");
				G.removeActionListener(letterL);
				G.setEnabled(false);
			}
			else if(e.getSource()==H){
				checkIfLetterExists("h");
				H.removeActionListener(letterL);
				H.setEnabled(false);
			}
			else if(e.getSource()==I){
				checkIfLetterExists("i");
				I.removeActionListener(letterL);
				I.setEnabled(false);
			}
			else if(e.getSource()==J){
				checkIfLetterExists("j");
				J.removeActionListener(letterL);
				J.setEnabled(false);
			}
			else if(e.getSource()==K){
				checkIfLetterExists("k");
				K.removeActionListener(letterL);
				K.setEnabled(false);
			}
			else if(e.getSource()==L){
				checkIfLetterExists("l");
				L.removeActionListener(letterL);
				L.setEnabled(false);
			}
			else if(e.getSource()==M){
				checkIfLetterExists("m");
				M.removeActionListener(letterL);
				M.setEnabled(false);
			}
			else if(e.getSource()==N){
				checkIfLetterExists("n");
				N.removeActionListener(letterL);
				N.setEnabled(false);
			}
			else if(e.getSource()==O){
				checkIfLetterExists("o");
				O.removeActionListener(letterL);
				O.setEnabled(false);
			}
			else if(e.getSource()==P){
				checkIfLetterExists("p");
				P.removeActionListener(letterL);
				P.setEnabled(false);
			}
			else if(e.getSource()==Q){
				checkIfLetterExists("q");
				Q.removeActionListener(letterL);
				Q.setEnabled(false);
			}
			else if(e.getSource()==R){
				checkIfLetterExists("r");
				R.removeActionListener(letterL);
				R.setEnabled(false);
			}
			else if(e.getSource()==S){
				checkIfLetterExists("s");
				S.removeActionListener(letterL);
				S.setEnabled(false);
			}
			else if(e.getSource()==T){
				checkIfLetterExists("t");
				T.removeActionListener(letterL);
				T.setEnabled(false);
			}
			else if(e.getSource()==U){
				checkIfLetterExists("u");
				U.removeActionListener(letterL);
				U.setEnabled(false);
			}
			else if(e.getSource()==V){
				checkIfLetterExists("v");
				V.removeActionListener(letterL);
				V.setEnabled(false);
			}
			else if(e.getSource()==W){
				checkIfLetterExists("w");
				W.removeActionListener(letterL);
				W.setEnabled(false);
			}
			else if(e.getSource()==X){
				checkIfLetterExists("x");
				X.removeActionListener(letterL);
				X.setEnabled(false);
			}
			else if(e.getSource()==Y){
				checkIfLetterExists("y");
				Y.removeActionListener(letterL);
				Y.setEnabled(false);
			}
			else if(e.getSource()==Z){
				checkIfLetterExists("z");
				Z.removeActionListener(letterL);
				Z.setEnabled(false);
			}
			
		}
		
	}
@SuppressWarnings("serial")
public class hangGlassPane extends JComponent{
	public void paintComponent(Graphics g) {
		//overwrite paintcomponent
		super.paintComponent(g);
		int xf=widthSize*6, yf=heightSize*5, xl=40, yl=5;
		for(int i=0;i<charSize;i++){
			//to charArraySize
			
		g.setColor(Color.RED);
		g.fillRect(xf, yf, xl, yl);
		xf=xf+45;
		}
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

}
