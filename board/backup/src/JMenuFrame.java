 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Font;

public class JMenuFrame{
	private JMenuBar menuBar;
    
    public JMenuFrame() {
        // Creates a menubar for a JFrame
        menuBar = new JMenuBar();
        
        // Add the menubar to the frame
        
        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("\u0391\u03C1\u03C7\u03B5\u03AF\u03BF");
        fileMenu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        JMenu infoMenu = new JMenu("\u03A3\u03C7\u03B5\u03C4\u03B9\u03BA\u03AC");
        infoMenu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuBar.add(fileMenu);
        menuBar.add(infoMenu);
        
        // Create and add simple menu item to one of the drop down menu

        JMenuItem exitAction = new JMenuItem("\u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
        exitAction.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        JMenuItem info_about_puzzles_Action = new JMenuItem("\u0393\u03C1\u03AF\u03C6\u03BF\u03B9");
        info_about_puzzles_Action.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        JMenuItem info_about_game_Action = new JMenuItem("\u03A4\u03BF \u03C0\u03B1\u03B9\u03C7\u03BD\u03AF\u03B4\u03B9");
        info_about_game_Action.setFont(new Font("Segoe UI", Font.PLAIN, 12));

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