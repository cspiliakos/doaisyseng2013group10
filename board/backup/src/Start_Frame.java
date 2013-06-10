import java.awt.EventQueue;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Start_Frame extends JFrame{
	private static final long serialVersionUID = 1L;
	private Image background;
	private BackgroundPanel back;
	private JPanel helpPanel;
	private JButton cont;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private static Clip clip;
	private static AudioInputStream audio;
	
	public static void main(String[] args) {
		//in place of Main used to run the initial frame

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					audio = AudioSystem.getAudioInputStream(new File("Sounds\\battle_theme.wav").getAbsoluteFile());
					clip = AudioSystem.getClip();
					clip.open(audio);
					clip.loop(Clip.LOOP_CONTINUOUSLY);
					//managing the sound

					Start_Frame frame = new Start_Frame(clip);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Start_Frame(final Clip clip){     //final to play in a loop 
		setJMenuBar(new JMenuFrame().getMenu());
		//menu
		
		try {
			background = ImageIO.read(new File("Start\\loginbackground.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);
		back = new BackgroundPanel(background);
		setContentPane(back);
		back.setLayout(new BorderLayout(5, 5));
		
		//managing frame
		
		//
		helpPanel = new JPanel();
		GridBagLayout gbl_helpPanel = new GridBagLayout();
		helpPanel.setLayout(gbl_helpPanel);
		cont = new JButton("\u03A3\u03C5\u03BD\u03AD\u03C7\u03B9\u03C3\u03B5");
		cont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Start_Frame.this.setVisible(false);
				//combo box for player or admin mode
				if (comboBox.getSelectedItem().toString().equals("\u0394\u03B9\u03B1\u03C7\u03B5\u03B9\u03C1\u03B9\u03C3\u03C4\u03AE\u03C2")){
					new AdminFrame(clip);
					//in admin mode redirects to the admin frame
				}
				else
				{
					new Name_Frame(clip);
					//in players mode redirects to the Name frame to choose single or multi player mode
				}
			}
		});
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u0394\u03B9\u03B1\u03C7\u03B5\u03B9\u03C1\u03B9\u03C3\u03C4\u03AE\u03C2", "\u03A7\u03C1\u03AE\u03C3\u03C4\u03B7\u03C2"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		helpPanel.add(comboBox, gbc_comboBox);
		cont.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_cont = new GridBagConstraints();
		gbc_cont.gridx = 0;
		gbc_cont.gridy = 2;
		helpPanel.add(cont, gbc_cont);
		back.add(helpPanel, BorderLayout.CENTER);	
	}
}
