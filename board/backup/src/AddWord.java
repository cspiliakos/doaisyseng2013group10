import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AddWord extends JFrame {
	//tha xrhsimopoihthei to idio panel kai gia to addword sthn kremmala

	private JPanel contentPane;
	private JTextField textField;

	String categories[]={"Choose ","C1","C2"};
	public AddWord() {
		//*** MenuBar ***//
				setJMenuBar(new JMenuFrame().getMenu()); // Getting the Menu from the JMenuFrame
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox(categories);
		comboBox.setBounds(12, 157, 144, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Add Word");
		btnNewButton.setBounds(272, 85, 134, 56);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Welcome, Admin");
		lblNewLabel.setBounds(291, 13, 119, 22);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(12, 73, 144, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Type The word");
		lblNewLabel_1.setBounds(12, 16, 109, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Category");
		lblNewLabel_2.setBounds(12, 119, 96, 22);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setBounds(272, 156, 134, 25);
		contentPane.add(btnNewButton_1);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
	}
}
