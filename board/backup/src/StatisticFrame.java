import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class StatisticFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextArea q1,q2,q3,q4,q5,q6;
	private JLabel graph1,graph2,graph3,graph4,graph5,graph6;
	private Image background;
	private BackgroundPanel back;
	
	public StatisticFrame(){
		
		try {
			background = ImageIO.read(new File("statback.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		back = new BackgroundPanel(background);
		back.setLayout(new GridLayout(3,4));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		
		q1 = new JTextArea("Πόσο ενδιαφέρον πιστεύετε ότι θα φανεί στα παιδιά;");
		q1.setEditable(false);
		q1.setOpaque(false);
		q1.setLineWrap(true);
		q1.setForeground(Color.ORANGE);
		q1.setFont(new Font("Arial",Font.BOLD,15));
		q2 = new JTextArea("Πιστεύετε ότι μπορεί το Live your Myth να ενταχθεί στα πλαίσια της διδακτικής ώρας;");
		q2.setForeground(Color.ORANGE);
		q2.setFont(new Font("Arial",Font.BOLD,15));
		q2.setEditable(false);
		q2.setOpaque(false);
		q2.setLineWrap(true);
		q3 = new JTextArea("Τα στατιστικά αποτελέσματα του παιχνιδιού θα βοηθήσουν εσάς τους εκπαιδευτικούς για την αξιολόγηση των γνώσεων των μαθητών;");
		q3.setForeground(Color.ORANGE);
		q3.setFont(new Font("Arial",Font.BOLD,15));
		q3.setEditable(false);
		q3.setOpaque(false);
		q3.setLineWrap(true);
		q4 = new JTextArea("Ποια πιστεύετε ότι θα πρέπει να είναι δομή των ερωτήσεων;");
		q4.setForeground(Color.CYAN);
		q4.setFont(new Font("Arial",Font.BOLD,15));
		q4.setEditable(false);
		q4.setOpaque(false);
		q4.setLineWrap(true);
		q5 = new JTextArea("Πιστεύετε ότι οι ερωτήσεις θα πρέπει να είναι μόνο στο πλαίσιο της ύλης ή να επεκτείνονται και σε κάποιες παραπάνω γνώσεις;");
		q5.setForeground(Color.CYAN);
		q5.setFont(new Font("Arial",Font.BOLD,15));
		q5.setEditable(false);
		q5.setOpaque(false);
		q5.setLineWrap(true);
		q6 = new JTextArea("Θεωρείτε ότι το Live your Myth θα είναι διασκεδαστικό για τους μαθητές;");
		q6.setForeground(Color.CYAN);
		q6.setFont(new Font("Arial",Font.BOLD,15));
		q6.setEditable(false);
		q6.setOpaque(false);
		q6.setLineWrap(true);
		
		graph1 = new JLabel(new ImageIcon("graph1.jpg"));
		graph2 = new JLabel(new ImageIcon("graph2.jpg"));
		graph3 = new JLabel(new ImageIcon("graph3.jpg"));
		graph4 = new JLabel(new ImageIcon("graph4a.jpg"));
		graph5 = new JLabel(new ImageIcon("graph5.jpg"));
		graph6 = new JLabel(new ImageIcon("graph6.jpg"));
		
		back.add(q1);
		back.add(graph1);
		back.add(q4);
		back.add(graph4);
		back.add(q2);
		back.add(graph2);
		back.add(q5);
		back.add(graph5);
		back.add(q3);
		back.add(graph3);
		back.add(q6);
		back.add(graph6);
		
		setVisible(true);
		setContentPane(back);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}