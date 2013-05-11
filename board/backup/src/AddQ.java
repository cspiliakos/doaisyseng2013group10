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
import javax.sound.sampled.Clip;
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
	//frame to add words for the puzzles hangman and telecube
	private static final long serialVersionUID = 1L;
	private JPanel backPanel;
	private ArrayList<String> words;
	private BackgroundPanel back;
	private Image background;
	private JLabel title;
	private JPanel panel;
	private JButton check;
	private JTextField textField;
	
	public AddQ(final Clip clip) {
		setJMenuBar(new JMenuFrame().getMenu());
		//menu
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
		//managing the frame
		
		words = new ArrayList<String>();
		
		backPanel = new JPanel();
		back.add(backPanel, BorderLayout.SOUTH);
		backPanel.setLayout(new BorderLayout(0, 0));
		
		JButton piso = new JButton("\u03A0\u03AF\u03C3\u03C9");
		piso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setting the action to return to the previous frame
				new AdminFrame(clip);
			}
		});
		piso.setHorizontalAlignment(SwingConstants.LEFT);
		piso.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		backPanel.add(piso, BorderLayout.WEST);
		
		title = new JLabel("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03BB\u03AD\u03BE\u03B7\u03C2");
		title.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		back.add(title, BorderLayout.NORTH);
		
		panel = new JPanel();
		back.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		panel.setLayout(gbl_panel);
		
		check = new JButton("\u039A\u03B1\u03C4\u03B1\u03C7\u03CE\u03C1\u03B7\u03C3\u03B7");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//check if is ok to add the word
				if (textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Πρέπει να συμπληρώσετε το πεδίο.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
				}
				else if (!words.contains(textField.getText().toUpperCase()))
				{
					words.add(textField.getText().toUpperCase());
					serializing();			
					JOptionPane.showMessageDialog(null, "Η λέξη προστέθηκε με επιτυχία.", "Επιτυχία", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Η λέξη υπάρχει ήδη στη λίστα.", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
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
		textField.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		deserializing();
		
	}
	
	@SuppressWarnings("unchecked")
	public void deserializing() {
		//getting the existing list
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
	
	public void serializing() {
		//save the list after changes
		try {
			FileOutputStream fileOut = new FileOutputStream("Words.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(words);
			out.close();
			fileOut.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
}
