import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class ChessBoard extends JFrame {

	private JPanel mainPanel;
	private BoardPanel boardPanel;
	private JPanel buttonPanel;
	private JButton resultButton;
	
	
	private JLabel diceResult;
	//��� �� ����������� �������� ��� ���� � random �������
	private Random r;
	private int playerX;
	//������������ � ��� �� �����
	private int playerY;
	//������������ � ��� �� �����
	private int size;
	//� ������ ��� ���������� ���� ����
	private ArrayList<Square> turnSteps;
	//������� �� ��������� ��� ����� ���� ������� � ������� ���� ����� ���
	private int totalMoves;
	//�������� ��� �� ������������ � ������� �������� ��� ���� ����� ���
	
	public ChessBoard() {
		playerX=0;
		playerY=0;
		
		mainPanel = new JPanel();
		boardPanel = new BoardPanel();
		buttonPanel = new JPanel();
		resultButton = new JButton("Roll");
		diceResult=new JLabel();
		
		BorderLayout layout = new BorderLayout();
		mainPanel.setLayout(layout);
		
		buttonPanel.add(resultButton);
		buttonPanel.add(diceResult);
		
		
		mainPanel.add(boardPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		this.setContentPane(mainPanel);
		
		ButtonListener listener = new ButtonListener();
		resultButton.addActionListener(listener);
				
		MouseClickListener mlistener = new MouseClickListener();
		boardPanel.addMouseListener(mlistener);
		
		r=new Random(System.currentTimeMillis());
		//���������� ������ ������� �������
		
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle("ChessBoard");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class BoardPanel extends JPanel {
		
		private static final int ROWS = 8;
		private static final int COLUMNS = 8;
		//���������� ������ ��������� ���������� ��� board
		
		private int xCoord = 0;
		private int yCoord = 0;
		//������� �������������
		
		public void setXYCoordinates(int xValue, int yValue) {
			//������� ���������� �������������
			xCoord = xValue;
			yCoord = yValue;
		}
		
		public void paintComponent(Graphics g) {
			//��������� ��� paintcomponent
			super.paintComponent(g);
			
			int sqSize = this.getHeight() / ROWS;
			size=sqSize;
			//��� �� ������� �� ������� ��� ������� ������� �� �� ��������
			
			for(int i=0; i<ROWS; i++) {
				for(int j=0; j<COLUMNS; j++) {
					int x = j * sqSize;
					int y = i * sqSize;
					g.drawRect(x, y, sqSize, sqSize);
					
				}
			}
			
			g.setColor(Color.RED);
			g.fillOval(xCoord, yCoord, sqSize, sqSize);
			//�� ������� �� �������� ���� ����� ����� ������� �������� �� ����� ����� ��� �������� ��� ����
			//��� ���������... ���������� ���� ��� repaint ���� ������� resize �� ��������... � �� ����� fix
			//�� ������� ���...
			
		}
		
		
	}
	
	
	class MouseClickListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			boolean found=false;
			//flag ��� ������� �� ������� �� ��������� ���� �����
			int x = e.getX();
			int y = e.getY();
			//������������� ��� ����
			
			
			if(turnSteps.size()>=totalMoves){
				System.out.println("Roll Again");
				//�� � ����� �� �� ������ ��� ����� ������ ���� ���� ����� �������� ��������
			}
			else{
			if ((x<(size*8))&&(y<(size*8))&&(x>(playerX+size))&&(y<(playerY+size))&&(y>playerY)){
				//������ ��� �� rows ��� �� columns ����� 8 ��� ���� ������������� �� 8 �� �� ������� ��� ����������
				//��� �� ��� ����� �� ���� ���� ����� ��� board
				playerX=playerX+size;
				}
			else if((x<(size*8))&&(y<(size*8))&&(x<playerX)&&(y<(playerY+size))&&(y>playerY)){
				playerX=playerX-size;	
			}
			else if ((x<(size*8))&&(y<(size*8))&&(y>(playerY+size))&&(x<(playerX+size))&&(x>playerX)){
				playerY=playerY+size;
			}
			else if ((x<(size*8))&&(y<(size*8))&&(y<playerY)&&(x<(playerX+size))&&(x>playerX)){
				playerY=playerY-size;
			}
			//������ ������ ���� �� ������ �� �������� ���� ��������� � ������ ��� ��� ��������
			//�� ����� �������� ���� �� ����� ���� ��� ������� (� ������ ��� ������� ���������) ���� ��� ���� ����������
			//�� ����� ���� ���� �������� ��� ������������ ��� �� ���������
			
			
			
			Square sq=new Square(playerX,playerY);
			//���������� ������������ ����������
			
			if (turnSteps.isEmpty()){
				//�� � ����� ����� ����� �� ��������� ������� ����� ������
				turnSteps.add(sq);
				sq.printSquare();
				}
			else{
				for(Square s: turnSteps){
					//������� �� ������� ��������� �� ��� ����� �������������
					if((s.getCorrX()==sq.getCorrX())&&(s.getCorrY()==sq.getCorrY())){
						System.out.println("Dialekse allo tetragwno");
						//��������� ��� ������
						found=true;
					}
				}
				
				if (!found){
					turnSteps.add(sq);
					sq.printSquare();
			//���������� ������������ ���������� ��� �������� ��� ���� ����� �� ��� ���� ������� � �������
					
					
				}
				
				
				}
					
			boardPanel.setXYCoordinates(playerX, playerY);
			
			if (!found)			
			boardPanel.repaint();	
			//�� �� ��������� ��� ������� ���� ����� ���� ��� ���� ���� ���� repaint
		}}
		
		public void mousePressed(MouseEvent e) {
			
			
		}
		
		public void mouseReleased(MouseEvent e) {
			
		}
		
		public void mouseEntered(MouseEvent e) {
			
		}
		
		public void mouseExited(MouseEvent e) {
			
		}
	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			turnSteps=new ArrayList<Square>();
			//�� ���� ����� ������������� ��� ��������� arraylist ��� �� ���������� ��� ��������
			int dice=r.nextInt(6)+1;
			
			totalMoves=dice;
			//�������� ��������
			
			String result=Integer.toString(dice);
			diceResult.setText(result);
			System.out.println(dice);
			//��������� ������� ���� �������
			
			
				
		}
	}
}








