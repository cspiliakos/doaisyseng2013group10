
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class AdminFrame extends JFrame {

	private JButton wordBt;
	private JButton questionBt;
	private JButton verifyBt;
	
	private JPanel mainPanel;
	private JPanel buttonPanel;
	private JPanel loginPanel;
	private JLabel gearlbl;
	
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	
	private int widthSize;
	private int heightSize;
	
	private VerifyButtonListener vbl;
	private AdminButtonListener abl;
	
	
	public AdminFrame(){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double fwidth = screenSize.getWidth();
		double fheight = screenSize.getHeight();
		int iwidth = (int)fwidth;
		int iheight = (int)fheight;
		widthSize = iwidth / 20;
		heightSize = iheight / 10;
		
		
		mainPanel=new JPanel();
		
		ImageIcon  gear=new  ImageIcon("gears.gif");
		Image gearImage=gear.getImage();
		gearlbl=new JLabel();
		gearlbl.setBounds(widthSize, heightSize, (widthSize*2),(heightSize*2));
		Image gearResizedImage = gearImage.getScaledInstance(gearlbl.getWidth(),gearlbl.getHeight(), 0);
		gearlbl.setIcon(new ImageIcon(gearResizedImage));
		mainPanel.add(gearlbl);
		
		verifyBt=new JButton("Login");
		mainPanel.add(verifyBt);
		
		vbl=new VerifyButtonListener();
		verifyBt.addActionListener(vbl);
		
		loginPanel=new JPanel(new GridLayout(2,2));
		
		usernameLabel=new JLabel("Username");
		loginPanel.add(usernameLabel);
		usernameTextField=new JTextField(5);
		loginPanel.add(usernameTextField);
		passwordLabel=new JLabel("Password");
		loginPanel.add(passwordLabel);
		passwordField=new JPasswordField();
		loginPanel.add(passwordField);
		
		mainPanel.add(loginPanel);
		
		wordBt=new JButton("Add Word");
		questionBt=new JButton("Add Question");
		
		abl=new AdminButtonListener();
		wordBt.addActionListener(abl);
		questionBt.addActionListener(abl);
		
		buttonPanel=new JPanel(new GridLayout(2,1));
		
		buttonPanel.add(wordBt);
		buttonPanel.add(questionBt);
		buttonPanel.setVisible(false);
		
		mainPanel.add(buttonPanel);
		
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
				new AddWord();
			}
			else if (e.getSource()==questionBt){
				System.out.println("Add Question");
			}
			
		}
		
	}
}
	