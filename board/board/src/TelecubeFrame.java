import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelecubeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private String s;
	private String q;

	public TelecubeFrame(String str,String str2) {
		//*** MenuBar ***//
				setJMenuBar(new JMenuFrame().getMenu()); // Getting the Menu from the JMenuFrame
		
		s=str;
		q=str2;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label1 = new JLabel();
		label1.setVisible(false);
		label1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setForeground(Color.WHITE);
		label1.setBackground(new Color(0, 0, 128));
		label1.setBounds(23, 47, 41, 41);
		contentPane.add(label1);

		JLabel label2 = new JLabel("A");
		label2.setVisible(false);
		label2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setForeground(Color.WHITE);
		label2.setBackground(new Color(0, 0, 128));
		label2.setBounds(65, 47, 41, 41);
		contentPane.add(label2);

		JLabel label3 = new JLabel("A");
		label3.setVisible(false);
		label3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setForeground(Color.WHITE);
		label3.setBackground(new Color(0, 0, 128));
		label3.setBounds(107, 47, 41, 41);
		contentPane.add(label3);

		JLabel label4 = new JLabel("A");
		label4.setVisible(false);
		label4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setForeground(Color.WHITE);
		label4.setBackground(new Color(0, 0, 128));
		label4.setBounds(149, 47, 41, 41);
		contentPane.add(label4);

		JLabel label5 = new JLabel("A");
		label5.setVisible(false);
		label5.setFont(new Font("Tahoma", Font.BOLD, 20));
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setForeground(Color.WHITE);
		label5.setBackground(new Color(0, 0, 128));
		label5.setBounds(191, 47, 41, 41);
		contentPane.add(label5);

		JLabel label6 = new JLabel("A");
		label6.setVisible(false);
		label6.setFont(new Font("Tahoma", Font.BOLD, 20));
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setForeground(Color.WHITE);
		label6.setBackground(new Color(0, 0, 128));
		label6.setBounds(233, 47, 41, 41);
		contentPane.add(label6);

		JLabel label7 = new JLabel("A");
		label7.setVisible(false);
		label7.setFont(new Font("Tahoma", Font.BOLD, 20));
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		label7.setForeground(Color.WHITE);
		label7.setBackground(new Color(0, 0, 128));
		label7.setBounds(275, 47, 41, 41);
		contentPane.add(label7);
		label1.setOpaque(true);
		label3.setOpaque(true);
		label4.setOpaque(true);
		label5.setOpaque(true);
		label6.setOpaque(true);
		label7.setOpaque(true);
		label2.setOpaque(true);

		t1 = new JTextField();
		t1.setBounds(23, 183, 116, 33);
		contentPane.add(t1);
		t1.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(320, 153, 97, 25);
		contentPane.add(btnOk);

		JButton btnAddWord = new JButton("Add Word");
		btnAddWord.setBounds(320, 191, 97, 25);
		contentPane.add(btnAddWord);

		JLabel label8 = new JLabel("A");
		label8.setVisible(false);
		label8.setFont(new Font("Tahoma", Font.BOLD, 20));
		label8.setOpaque(true);
		label8.setHorizontalAlignment(SwingConstants.CENTER);
		label8.setForeground(Color.WHITE);
		label8.setBackground(new Color(0, 0, 128));
		label8.setBounds(89, 89, 41, 41);
		contentPane.add(label8);

		JLabel label9 = new JLabel("A");
		label9.setVisible(false);
		label9.setFont(new Font("Tahoma", Font.BOLD, 20));
		label9.setOpaque(true);
		label9.setHorizontalAlignment(SwingConstants.CENTER);
		label9.setForeground(Color.WHITE);
		label9.setBackground(new Color(0, 0, 128));
		label9.setBounds(131, 89, 41, 41);
		contentPane.add(label9);

		JLabel label10 = new JLabel("A");
		label10.setVisible(false);
		label10.setFont(new Font("Tahoma", Font.BOLD, 20));
		label10.setOpaque(true);
		label10.setHorizontalAlignment(SwingConstants.CENTER);
		label10.setForeground(Color.WHITE);
		label10.setBackground(new Color(0, 0, 128));
		label10.setBounds(173, 89, 41, 41);
		contentPane.add(label10);

		JLabel label11 = new JLabel("A");
		label11.setVisible(false);
		label11.setFont(new Font("Tahoma", Font.BOLD, 20));
		label11.setOpaque(true);
		label11.setHorizontalAlignment(SwingConstants.CENTER);
		label11.setForeground(Color.WHITE);
		label11.setBackground(new Color(0, 0, 128));
		label11.setBounds(215, 89, 41, 41);
		contentPane.add(label11);

		JLabel lblNewLabel_1 = new JLabel("\u03A0\u03BB\u03B7\u03BA\u03C4\u03C1\u03BF\u03BB\u03CC\u03B3\u03B7\u03C3\u03B5 \u03B1\u03C0\u03AC\u03BD\u03C4\u03B7\u03C3\u03B7!");
		lblNewLabel_1.setBounds(12, 157, 178, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u0392\u03C1\u03B5\u03C2 \u03C4\u03B7\u03BD \u03B1\u03BD\u03B1\u03B3\u03C1\u03B1\u03BC\u03BC\u03B1\u03C4\u03B9\u03C3\u03BC\u03B5\u03BD\u03B7 \u03BB\u03AD\u03BE\u03B7");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(131, 0, 299, 41);
		contentPane.add(lblNewLabel_2);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		


		String ch=Character.toString(s.charAt(0));
		for(int i=0;i<s.length();i++){
			ch=Character.toString(s.charAt(i));
			switch(i){
			case 0:label1.setText(ch);label1.setVisible(true);break;
			case 1:label2.setText(ch);label2.setVisible(true);break;
			case 2:label3.setText(ch);label3.setVisible(true);break;
			case 3:label4.setText(ch);label4.setVisible(true);break;
			case 4:label5.setText(ch);label5.setVisible(true);break;
			case 5:label6.setText(ch);label6.setVisible(true);break;
			case 6:label7.setText(ch);label7.setVisible(true);break;
			case 7:label8.setText(ch);label8.setVisible(true);break;
			case 8:label9.setText(ch);label9.setVisible(true);break;
			case 9:label10.setText(ch);label10.setVisible(true);break;
			case 10:label11.setText(ch);label11.setVisible(true);break;

			}


		}

		ButtonListener listener = new ButtonListener();
		btnOk.addActionListener(listener);
		AddWButtonListener listener1 = new AddWButtonListener();
		btnAddWord.addActionListener(listener1);
		
	}


	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
				String answer=t1.getText();
				if(answer.equals(q)){

					JOptionPane.showMessageDialog(null, "Correct Answer!");	
					System.exit(0);
				}
				else {
					
					JOptionPane.showMessageDialog(null, "камхаслемг апамтгсг","апотувиа", JOptionPane.ERROR_MESSAGE);	
				}
				
			
		}
	}
	public class AddWButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			
			
			new AddWord();
			setVisible(false);
		}
		
		}
}
