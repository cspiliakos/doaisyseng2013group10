import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AddQuestion extends JFrame {
	private static final long serialVersionUID = 1L;
	private ArrayList<Question> questions;
	private JPanel backPanel, mainPanel;
	private BackgroundPanel back;
	private Image background;
	private JLabel title, makeQuestion;
	private JRadioButton answer1, answer2, answer3, answer4;
	private JTextField makeField, field1, field2, field3, field4;
	private JButton piso, check;
	private ButtonGroup group;
	private String choose;

	public AddQuestion() {
		group = new ButtonGroup();
		questions = new ArrayList<Question>();
		deserializing();
		
		setJMenuBar(new JMenuFrame().getMenu());
		try {
			background = ImageIO.read(new File("UIcons\\arcade_background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		back = new BackgroundPanel(background);
		setContentPane(back);
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		
		backPanel = new JPanel();
		back.add(backPanel, BorderLayout.SOUTH);
		backPanel.setLayout(new BorderLayout(0, 0));
		
		piso = new JButton("\u03A0\u03AF\u03C3\u03C9");
		piso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminFrame();
			}
		});
		piso.setHorizontalAlignment(SwingConstants.LEFT);
		piso.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		backPanel.add(piso, BorderLayout.WEST);
		
		title = new JLabel("\u03A0\u03C1\u03CC\u03C3\u03B8\u03B5\u03C3\u03B5 \u03C4\u03B9\u03C2 \u03BB\u03AD\u03BE\u03B5\u03B9\u03C2 \u03C0\u03BF\u03C5 \u03B8\u03AD\u03BB\u03B5\u03B9\u03C2 \u03BD\u03B1 \u03B5\u03AF\u03BD\u03B1\u03B9 \u03B4\u03B9\u03B1\u03B8\u03AD\u03C3\u03B9\u03BC\u03B5\u03C2 \u03B3\u03B9\u03B1 \u03C4\u03BF \u03C0\u03B1\u03B9\u03C7\u03BD\u03AF\u03B4\u03B9 \u03C4\u03C9\u03BD \u03B5\u03C1\u03C9\u03C4\u03AE\u03C3\u03B5\u03C9\u03BD");
		title.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		back.add(title, BorderLayout.NORTH);
		
		////////////////////////
		mainPanel = new JPanel();
		back.add(mainPanel, BorderLayout.CENTER);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{50, 50};
		gbl_mainPanel.rowHeights = new int[]{50, 50, 50, 50, 50};
		mainPanel.setLayout(gbl_mainPanel);
		
		makeQuestion = new JLabel();
		makeQuestion.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_makeQuestion = new GridBagConstraints();
		gbc_makeQuestion.insets = new Insets(0, 0, 0, 5);
		gbc_makeQuestion.gridx = 0;
		gbc_makeQuestion.gridy = 0;
		mainPanel.add(makeQuestion, gbc_makeQuestion);
		
		makeField = new JTextField();
		makeField.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_makeField = new GridBagConstraints();
		gbc_makeField.insets = new Insets(0, 0, 0, 5);
		gbc_makeField.gridx = 1;
		gbc_makeField.gridy = 0;
		mainPanel.add(makeField, gbc_makeField);
		
		answer1 = new JRadioButton("Απάντηση 1:");
		answer1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_answer1 = new GridBagConstraints();
		gbc_answer1.insets = new Insets(0, 0, 0, 5);
		gbc_answer1.gridx = 0;
		gbc_answer1.gridy = 1;
		mainPanel.add(answer1, gbc_answer1);
		group.add(answer1);
		
		field1 = new JTextField();
		field1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_field1 = new GridBagConstraints();
		gbc_field1.insets = new Insets(0, 0, 0, 5);
		gbc_field1.gridx = 1;
		gbc_field1.gridy = 1;
		mainPanel.add(field1, gbc_field1);
		
		answer2 = new JRadioButton("Απάντηση 2:");
		answer2.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_answer2 = new GridBagConstraints();
		gbc_answer2.insets = new Insets(0, 0, 0, 5);
		gbc_answer2.gridx = 0;
		gbc_answer2.gridy = 2;
		mainPanel.add(answer2, gbc_answer2);
		group.add(answer2);
		
		field2 = new JTextField();
		field2.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_field2 = new GridBagConstraints();
		gbc_field2.insets = new Insets(0, 0, 0, 5);
		gbc_field2.gridx = 1;
		gbc_field2.gridy = 2;
		mainPanel.add(field2, gbc_field2);
		
		answer3 = new JRadioButton("Απάντηση 3:");
		answer3.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_answer3 = new GridBagConstraints();
		gbc_answer3.insets = new Insets(0, 0, 0, 5);
		gbc_answer3.gridx = 0;
		gbc_answer3.gridy = 3;
		mainPanel.add(answer3, gbc_answer3);
		group.add(answer3);
		
		field3 = new JTextField();
		field3.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_field3 = new GridBagConstraints();
		gbc_field3.insets = new Insets(0, 0, 0, 5);
		gbc_field3.gridx = 1;
		gbc_field3.gridy = 3;
		mainPanel.add(field3, gbc_field3);
		
		answer4 = new JRadioButton("Απάντηση 4:");
		answer4.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_answer4 = new GridBagConstraints();
		gbc_answer4.insets = new Insets(0, 0, 0, 5);
		gbc_answer4.gridx = 0;
		gbc_answer4.gridy = 4;
		mainPanel.add(answer4, gbc_answer4);
		group.add(answer4);
		
		field4 = new JTextField();
		field4.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_field4 = new GridBagConstraints();
		gbc_field4.insets = new Insets(0, 0, 0, 5);
		gbc_field4.gridx = 1;
		gbc_field4.gridy = 4;
		mainPanel.add(field4, gbc_field4);
		
		check = new JButton();
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (field1.getText().equals("") || field2.getText().equals("") || field3.getText().equals("") || field4.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Δεν έχετε συμπληρώσει όλα τα πεδία που χρειάζονται.");
				}
				
				if (!answer1.isSelected() && !answer2.isSelected() && !answer3.isSelected() && !answer4.isSelected())
				{
					JOptionPane.showMessageDialog(null, "Δεν έχετε διαλέξει σωστή απάντηση.");
				}
				
				if (!questions.contains(makeField.getText()))
				{
					if (answer1.isSelected()) 
					{
						choose = answer1.getText();
					}
					else if (answer2.isSelected()) 
					{
						choose = answer2.getText();
					}
					else if (answer3.isSelected()) 
					{
						choose = answer3.getText();
					}
					else if (answer4.isSelected())
					{
						choose = answer4.getText();
					}
					Question question = new Question(makeField.getText(), field1.getText(), field2.getText(), field3.getText(), field4.getText(), choose);
					questions.add(question);
					serializing();			
					JOptionPane.showMessageDialog(null, "Η ερώτηση προστέθηκε με επιτυχία.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Η ερώτηση υπάρχει ήδη στη λίστα.");
				}
				makeField.setText(null);
				field1.setText(null);
				field2.setText(null);
				field3.setText(null);
				field4.setText(null);
			}
		});
		check.setText("\u039A\u03B1\u03C4\u03B1\u03C7\u03CE\u03C1\u03B7\u03C3\u03B7");
		check.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_check = new GridBagConstraints();
		gbc_check.gridx = 0;
		gbc_check.gridy = 5;
		mainPanel.add(check, gbc_check);
	}
	
	public void serializing() {
		try {
			FileOutputStream fileOut = new FileOutputStream("QuestionsDatabase.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(questions);
			out.close();
			fileOut.close();		
		}
		catch(IOException i) {
			System.out.println("Error");
			i.printStackTrace();
		}
		finally {
			System.out.println("Serialization Attempted...");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void deserializing() {
		try {
			FileInputStream fileIn = new FileInputStream("QuestionsDatabase.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			questions = (ArrayList<Question>) in.readObject();
			in.close();
			fileIn.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		finally {
			System.out.println("De-Serialization Attempted...");		
		}
	}
}
