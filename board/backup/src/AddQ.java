import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddQ extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<String> wordList;
	
	public AddQ() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Word");
		btnNewButton.setBounds(272, 153, 134, 56);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(40, 84, 144, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Done");
		btnNewButton_1.setBounds(272, 222, 134, 25);
		contentPane.add(btnNewButton_1);
		
		ButtonListener listener = new ButtonListener();
		btnNewButton.addActionListener(listener);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
	}
	
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			wordList.add(textField.getText());
			serializing();			
			JOptionPane.showMessageDialog(null, "The word has been added!");			
			textField.setText(null);
		}
	}
	
	public void serializing() {
		try {
			FileOutputStream fileOut = new FileOutputStream("Words.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(wordList);
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
}
