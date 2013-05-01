import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AddWord extends JFrame {
	private JPanel back;
	private JTextField textField;
	String categories[]={"Choose ","C1","C2"};
	
	public AddWord() {
		setJMenuBar(new JMenuFrame().getMenu());
		
		back = new JPanel();
		back.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(back);
		back.setLayout(null);
		
		JButton commit = new JButton("\u039A\u03B1\u03C4\u03B1\u03C7\u03CE\u03C1\u03B7\u03C3\u03B7");
		commit.setBounds(272, 85, 134, 36);
		back.add(commit);
		
		textField = new JTextField();
		textField.setBounds(12, 73, 144, 22);
		back.add(textField);
		textField.setColumns(10);
		
		JLabel prompt = new JLabel("Type The word");
		prompt.setBounds(12, 16, 109, 36);
		back.add(prompt);
		
		JButton back2 = new JButton("\u03A0\u03AF\u03C3\u03C9");
		back2.setBounds(272, 156, 134, 25);
		back.add(back2);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
	}
}
