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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AddQ extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel backPanel;
	private ArrayList<String> words;
	private BackgroundPanel back;
	private Image background;
	private JLabel title;
	private JPanel panel;
	private JButton check;
	private JTextField textField;
	
	public AddQ() {
		setJMenuBar(new JMenuFrame().getMenu());
		try {
			background = ImageIO.read(new File("adminback.jpg"));
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
		
		JButton piso = new JButton("\u03A0\u03AF\u03C3\u03C9");
		piso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminFrame();
			}
		});
		piso.setHorizontalAlignment(SwingConstants.LEFT);
		piso.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		backPanel.add(piso, BorderLayout.WEST);
		
		title = new JLabel("\u03A0\u03C1\u03CC\u03C3\u03B8\u03B5\u03C3\u03B5 \u03C4\u03B9\u03C2 \u03BB\u03AD\u03BE\u03B5\u03B9\u03C2 \u03C0\u03BF\u03C5 \u03B8\u03AD\u03BB\u03B5\u03B9\u03C2 \u03BD\u03B1 \u03B5\u03AF\u03BD\u03B1\u03B9 \u03B4\u03B9\u03B1\u03B8\u03AD\u03C3\u03B9\u03BC\u03B5\u03C2 \u03B3\u03B9\u03B1 \u03C4\u03BF \u03C0\u03B1\u03B9\u03C7\u03BD\u03AF\u03B4\u03B9 \u03C4\u03BF\u03C5 \u03B1\u03BD\u03B1\u03B3\u03C1\u03B1\u03BC\u03BC\u03B1\u03C4\u03B9\u03C3\u03BC\u03BF\u03CD");
		title.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		back.add(title, BorderLayout.NORTH);
		
		panel = new JPanel();
		back.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{50};
		gbl_panel.rowHeights = new int[]{60, 60};
		panel.setLayout(gbl_panel);
		
		check = new JButton("\u039A\u03B1\u03C4\u03B1\u03C7\u03CE\u03C1\u03B7\u03C3\u03B7");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "������ �� ������������ �� �����.");
				}
				if (!words.contains(textField.getText()))
				{
					words.add(textField.getText());
					serializing();			
					JOptionPane.showMessageDialog(null, "� ���� ���������� �� ��������.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "� ���� ������� ��� ��� �����.");
				}
				textField.setText(null);		
			}
		});
		check.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_check = new GridBagConstraints();
		gbc_check.insets = new Insets(0, 0, 0, 5);
		gbc_check.gridx = 0;
		gbc_check.gridy = 1;
		panel.add(check, gbc_check);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		deserializing();
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
		finally {
			System.out.println("De-Serialization Attempted...");		
		}
	}
	
	public void serializing() {
		try {
			FileOutputStream fileOut = new FileOutputStream("Words.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(words);
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
