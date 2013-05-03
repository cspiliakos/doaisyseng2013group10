import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AdminFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton wordBt;
	private JButton questionBt;
	private JButton verifyBt;
	
	private JPanel mainPanel;
	private JPanel buttonPanel;
	private JPanel loginPanel;
	private JLabel gearlbl;
	private JLabel backlbl;
	
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	
	private int widthSize;
	private int heightSize;
	
	private VerifyButtonListener vbl;
	private AdminButtonListener abl;
	
	//private BackgroundPanel mainPanel;
	//private Image background;
	
	public AdminFrame(){
		
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double fwidth = screenSize.getWidth();
		double fheight = screenSize.getHeight();
		int iwidth = (int)fwidth;
		int iheight = (int)fheight;
		widthSize = iwidth / 20;
		heightSize = iheight / 10;
		
		setBounds(100, 100, iwidth, iheight);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(mainPanel);
		mainPanel.setLayout(null);
				
		//mainPanel=new JPanel();
		
		ImageIcon  gear=new  ImageIcon("gears.gif");
		Image gearImage=gear.getImage();
		gearlbl=new JLabel();
		gearlbl.setBounds(widthSize, heightSize, (widthSize*2),(heightSize*2));
		Image gearResizedImage = gearImage.getScaledInstance(gearlbl.getWidth(),gearlbl.getHeight(), 0);
		gearlbl.setIcon(new ImageIcon(gearResizedImage));
		
		mainPanel.add(gearlbl);
		
		
		
		
		
		loginPanel=new JPanel(new GridLayout(2,2));
		
		usernameLabel=new JLabel("Username");
		loginPanel.add(usernameLabel);
		usernameTextField=new JTextField(5);
		loginPanel.add(usernameTextField);
		passwordLabel=new JLabel("Password");
		loginPanel.add(passwordLabel);
		passwordField=new JPasswordField();
		loginPanel.add(passwordField);
		loginPanel.setOpaque(false);
		loginPanel.setBounds(((iwidth/2)-(widthSize/2)),((iheight/2)+((3*heightSize)/4)),(widthSize*2),(heightSize/2));
		
		mainPanel.add(loginPanel);
		
		verifyBt=new JButton("Login");
		verifyBt.setBounds(((loginPanel.getX())-widthSize),(loginPanel.getY()),(widthSize), heightSize/2);
		mainPanel.add(verifyBt);
		
		vbl=new VerifyButtonListener();
		verifyBt.addActionListener(vbl);
		
		wordBt=new JButton("Add Word");
		questionBt=new JButton("Add Question");
		
		abl=new AdminButtonListener();
		wordBt.addActionListener(abl);
		questionBt.addActionListener(abl);
		
		buttonPanel=new JPanel(new GridLayout(2,1));
		buttonPanel.setBounds(((loginPanel.getX())+(widthSize*2)),(loginPanel.getY()),(widthSize*2),(heightSize/2));
		
		buttonPanel.add(wordBt);
		buttonPanel.add(questionBt);
		buttonPanel.setOpaque(false);
		buttonPanel.setVisible(false);
		
		mainPanel.add(buttonPanel);
		
		ImageIcon  background=new  ImageIcon("adminback.jpg");
		Image image=background.getImage();
		backlbl=new JLabel();
		backlbl.setBounds(0,0,iwidth,iheight);
		Image resizedImage = image.getScaledInstance(iwidth, iheight, 0);
		backlbl.setIcon(new ImageIcon(resizedImage));
		//prosarmogh eikonas fontou
		mainPanel.add(backlbl);
		mainPanel.setOpaque(false);
		this.setContentPane(mainPanel);
		
		this.setUndecorated(true);
		this.setLocation(0,0);
		this.setSize(iwidth,iheight);
		this.setVisible(true);
			
	}
	
	class VerifyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String usernameText=usernameTextField.getText();
			
			char[] c=(passwordField.getPassword());
			//h getPassword epistrefei char array kai prepei na ginei metatroph se string
			String passwordText=new String (c);
			//metatroph se string
			
			if((usernameText.length()!=0)&&(passwordText.length()!=0)){
				//an den einai kena
				if (usernameText.equals("admin")){
					if(passwordText.equals("admin1")){
						buttonPanel.setVisible(true);
						System.out.println("You are admin");
						
					}
					else{
						System.out.println("Wrong Password");
						}
				}
			else{
					System.out.println("Wrong Username");
				}
			}
		}
	}
	
	class AdminButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==wordBt){
				new AddQ();
			}
			else if (e.getSource()==questionBt){
				new AddQuestion();
			}
			
		}
		
	}
}
	