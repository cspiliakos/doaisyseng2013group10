 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

public class JMenuFrame{
	private JMenuBar menuBar;
    
	//MUST BE IN EVERY FRAME//
    public JMenuFrame() {
        
  
        
        // Creates a menubar for a JFrame
        menuBar = new JMenuBar();
        
        // Add the menubar to the frame
        
        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("File");
        JMenu infoMenu = new JMenu("About");
        menuBar.add(fileMenu);
        menuBar.add(infoMenu);
        
        // Create and add simple menu item to one of the drop down menu

        JMenuItem exitAction = new JMenuItem("Exit");
        JMenuItem info_about_puzzles_Action = new JMenuItem("About Puzzles");
        JMenuItem info_about_game_Action = new JMenuItem("About The Game");




        fileMenu.add(exitAction);
        infoMenu.add(info_about_puzzles_Action);
        infoMenu.addSeparator();
        infoMenu.add(info_about_game_Action);
        
      
        // Add a listener to the New menu item. actionPerformed() method will
        // invoked, if user triggred this menu item
        //EXIT
        exitAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        //INFO ABOUT PUZZLES
        info_about_puzzles_Action.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
             JOptionPane.showMessageDialog(null	, "Info About Puzzles:\n1)Επίλυση Quiz ερωτήσεων :2. Μέσα από 4 πιθανές απαντήσεις,,ο παίκτης επιλέγει την αντίστοιχη απάντηση." +
             	 "\n2)Επίλυση Click-me: Στην οθόνη του γρίφου εμφανίζεται μια εικόνα. Ο παίκτης θα πρέπει στο συγκεκριμένο χρόνο, να κάνει όσα περισσότερα κλικ πάνω στην εικόνα μπορεί."+
            	 "\n3)Επίλυση Ancient arcade: Ο παίκτης αντιστοιχεί 6 ήρωες της μυθολογίας με 6 χαρακτηριστικά τους, ένα για τον καθένα."+
             	 "\n4)Επίλυση Τηλεκύβου: Εμφανίζεται στην οθόνη μία αναγραμματισμένη λέξη. Ο παίκτης πρέπει να πληκτολογήσει την λέξη στην σωστή της μορφή"+
            	 "\n5)Επίλυση Memory game: Ο παίκτης μέσα από ανακατεμένα 8 ζεύγη καρτών επιλέγει πανομοιότυπες εικόνες"+
             	 "\n6)Επίλυση 3-Pics-1-hero: Στην οθόνη εμφανίζονται 3 εικόνες. Ο παίκτης συμπηρώνει το όνομα του ήρωα που περιγράφουν οι εικόνες" +
            	 "\n7)Επίλυση Tρίλιζα: Εμφανίζεται στην οθόνη ένας κύκλος O και ένα X. Ο παίκτης επιλέγει το σχήμα που θέλει να έχει ξεκινάει το παιχνίδι."+
             	 "\n8)Επίλυση 8-block-puzzle: Εμφανίζεται στην οθόνη ένα puzzle χωρισμένο σε 9 εσωτερικά τετράγωνα,με ένα κενό.Ο παίκτης προσπαθεί να σχηματίσει την σωστή εικόνα."+
            	 "\n9) Επίλυση Κρεμάλας: Εμφανίζεται στην οθόνη μία κενή κρεμάλα και το αρχικό γράμμα της σωστής λέξης. Ο παίκτης προσπαθεί να σχηματίσει τη σωστή λέξη."
                 , "Title", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        //INFO ABOUT GAME
        info_about_game_Action.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		JOptionPane.showMessageDialog(null	, "Info About Game", "Title", JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        
    }

    public JMenuBar getMenu() {
    	return menuBar;
    }

}