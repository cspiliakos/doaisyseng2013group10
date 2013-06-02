import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.Font;
import java.util.ArrayList;

public class JMenuFrame{
	private JMenuBar menuBar;
	
	ArrayList<AudiosPair> list = new ArrayList<AudiosPair>(new Audios().getMenuList());
	Sound_Thread soundthread1 = new Sound_Thread();
    
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
        
        JMenuItem info_about_heroes_Action = new JMenuItem("\u0389\u03C1\u03C9\u03B5\u03C2");
        info_about_heroes_Action.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        JMenuItem info_about_game_Action = new JMenuItem("\u03A4\u03BF \u03C0\u03B1\u03B9\u03C7\u03BD\u03AF\u03B4\u03B9");
        info_about_game_Action.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        JMenuItem info_about_stats_Action = new JMenuItem("Η δική σας γνώμη");
        info_about_stats_Action.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        JMenuItem info_about_us_Action = new JMenuItem("Η ομάδα μας");
        info_about_us_Action.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        fileMenu.add(exitAction);       //KLEISIMO     
        infoMenu.add(info_about_heroes_Action);//HEROES
        infoMenu.addSeparator();              // SEPERATOR
        infoMenu.add(info_about_puzzles_Action);  //GRIFOI
        infoMenu.addSeparator();               //SEPERATOR
        infoMenu.add(info_about_game_Action);     //TO PAIXNIDI
        infoMenu.addSeparator();               //SEPERATOR
        infoMenu.add(info_about_stats_Action);     //TA ERWTHMATOLOGIA
        infoMenu.addSeparator();               //SEPERATOR
        infoMenu.add(info_about_us_Action);     //TA ERWTHMATOLOGIA
          
        
        // Add a listener to the New menu item. actionPerformed() method will
        // invoked, if user triggred this menu item
        //EXIT
        
        //info_about_heroes_Action
        info_about_heroes_Action.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat() ); //Sound: click_sword
            	JOptionPane.showMessageDialog(null, 
            			"Ουρανός: Είναι το πρώτο παιδί της Γαίας το οποίο γέννησε μόνη της (χωρίς πατέρα). Επειδή ήταν τόσο μεγάλος σε μέγεθος μπορούσε και την αγκάλιαζε ολόκληρη και έτσι έγινε ο ιδανικός σύζυγός της \n"+
            			"και μαζί απέκτησαν, έξι Τιτάνες, έξι Τιτανίδες, τρεις Κύκλωπες και τρεις Εκατόγχειρες.\n"+
            			"Κρόνος: Ήταν ο ηγέτης και ο νεώτερος της πρώτης γενεάς των τιτάνων. Σκότωσε τον πατέρα του, τον Ουρανό, και κυβέρνησε κατά τη διάρκεια της μυθολογικής χρυσής εποχής.\n"+
            			"Δίας: Γιός του Κρόνου και της Ρέας, εγγονός του Ουρανού και της Γαίας. Είναι θεός του ουρανού και του κεραυνού. Κατοικία του ο Όλυμπος και γυναίκα του η θεά Ήρα.\n"+
            			"Ποσειδώνας: Γιός του Κρόνου και της Ρέας. Ο θεός της στεριάς και της θάλασσας. Αδελφός του ήταν ο Δίας. Χαρακτηρηστικό του αντικείμενο ήταν η τριάινα του.\n"+
            			"Άδης: Ο βασιλιάς του κάτω κόσμου (Τάρταρο), θεός του θανάτου και των νεκρών. Αδερφός του Δία και του Ποσειδώνα.\n"+
            			"Άρης: Ο θεός του πολέμου κατά την ελληνική μυθολογία, γιος του Δία και της Ήρας. Αδελφή του ήταν η Έριδα. Εμφανίζεται πολεμοχαρής και προκλητικός και\n"+
            			"εκπροσωπεί την παρορμητική φύση του πολέμου.\n"+
            			"Ηρακλής: Θεωρούνταν ως ο μέγιστος των Ελλήνων ηρώων. Γεννήθηκε στη Θήβα και ήταν γιος του Δία και της Αλκμήνης. Χαρακτηριστικό του όπλο το ρόπαλο.\n"+
            			"Κέρβερος: Αντιπροσωπεύει τον φύλακα του Άδη και έχει συνήθως την μορφή ενός σκύλου, με τρία κεφάλια και με ουρά που κατέληγε σε κεφαλή δράκου.\n"+
            			"Μέδουσα: Αναφέρεται ως μια από τις τρεις Γοργόνες. Η ασχήμια της ήταν τέτοια, που όποιος την κοιτούσε στο πρόσωπο πέτρωνε.\n"+
            			"Μινώταυρος: Ήταν ένα ον με σώμα ανθρώπου και κεφάλι και ουρά ταύρου. Κατοικούσε στο Λαβύρινθο, κτίσμα που φτιάχτηκε από το Δαίδαλο κατόπιν εντολής του βασιλιά της Κρήτης Μίνωα.\n"+
            			"Οδυσσέας: Γιός του Λαέρτη και της Αντίκλειας, σύζυγος της Πηνελόπης και πατέρας του Τηλεμάχου. Μυθικός βασιλιάς της Ιθάκης. Είναι ευρέως γνωστός για την πονηριά και την εφευρετικότητά του.\n"+
            			"Περσέας: Γιός του Δία και της Δανάης. Παππούς του ήταν ο Ακρίσιος, βασιλιάς του Άργους. Ο ήρωας αυτός κατάφερε να σκοτώσει την Μέδουσα με την βοήθεια της Αθηνάς.\n"+
            			"Σκύλλα: Θυγατέρα του Ποσειδώνα και της Γαίας είναι θηλυκό τέρας της ελληνικής μυθολογίας. Είχε έξι λαιμούς και άρπαζε τους ναυτικούς από τα διερχόμενα πλοία.\n"+
            			"Θησέας: Ήταν Έλληνας βασιλιάς της Αθήνας στην ελληνική μυθολογία, γιος του Αιγέα και της Αίθρας, σκότωσε τον Μινώταυρο μέσα στον Λαβύρινθο και έπειτα τον υποδέχθηκαν με τιμές ήρωα μέσα στην Αθήνα."
            			, "Ήρωες του παιχνιδιού", JOptionPane.INFORMATION_MESSAGE);
			}
		});
        
        exitAction.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {	
        		System.exit(0);
        	}
        });
        //INFO ABOUT PUZZLES
        info_about_puzzles_Action.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat() ); //Sound: click_sword
            	JOptionPane.showMessageDialog(null, 
            			"Πληροφορίες για τους γρίφους:\n"+
            			"1) Quiz ερωτήσεων: Εμφανίζετε στην οθόνη μια ερώτηση και 4 πιθανές απαντήσεις. Ο παίκτης προσπαθεί να βρει τη σωστή απάντηση. Μετά από την \n" +
            			"απάντηση του παίκτη εμφανίζεται νέα ερώτηση\n"+
            			"2) Click-me: Στην οθόνη εμφανίζεται μια εικόνα. Ο παίκτης θα πρέπει σε συγκεκριμένο χρόνο, να κάνει όσα περισσότερα κλικ μπορεί πάνω στην εικόνα.\n"+
            			"3) Αντιστοίχιση: Εμφανίζονται στην οθόνη 12 εικόνες. Ο παίκτης καλείται να αντιστοιχήσει μέσα σε ορισμένο χρόνο 6 ήρωες της μυθολογίας σε 6 \n"+
            			"χαρακτηριστικά τους.\n"+
            			"4) Αναγραμματισμός: Εμφανίζετε στην οθόνη μια αναγραμματισμένη λέξη. Ο παίκτης προσπαθεί να βρει τη σωστή λέξη. Αφού απαντήσει εμφανίζεται νέα λέξη\n"+
            			"5) Παιχνίδι μνήμης: Εμφανίζονται στην οθόνη 16 κρυμμένες εικόνες. Ο παίκτης προσπαθεί μέσα στον χρόνο που του δίνεται να βρει όσο περισσότερα ζεύγη"+
            			"όμοιων εικόνων μπορεί.\n"+
            			"6) Quiz ηρώων: Στην οθόνη εμφανίζονται 3 εικόνες. Ο παίκτης προσπαθεί να βρει ποιος ήρωας συνδέει τις 3 εικόνες. Μετά την απάντηση του παίκτη\n"+
            			"εμφανίζεται νέα τριάδα εικόνων.\n"+
            			"7) Tρίλιζα: Εμφανίζεται στην οθόνη ένα ταμπλό 9 τετραγώνων. Ο παίκτης προσπαθεί να δημιουργήσει τριάδες είτε οριζόντια, είτε κάθετα, είτε διαγώνια.\n"+
            			"8) Quiz εικόνων: Εμφανίζονται στην οθόνη 3 εικόνες και το όνομα ενός ιστορικού προσώπου. Ο παίκτης καλείται να βρει την εικόνα που αντιστοιχεί"+
            			"στο πρόσωπο.\nΜετά την απάντηση του παίκτη εμφανίζεται νέα τριάδα εικόνων.\n"+
            			"9) Κρεμάλα: Εμφανίζονται στην οθόνη παύλες που αντιστοιχούν στο κάθε γράμμα της ζητούμενης λέξης. Ο παίκτης προσπαθεί να σχηματίσει τη σωστή λέξη."
            			, "Γρίφοι του παιχνιδιού", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        //INFO ABOUT GAME
        info_about_game_Action.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		JOptionPane.showMessageDialog(null	, 
        				"Το Live your Myth είναι ένα επιτραπέζιο παιχνίδι. Έχουν τη δυνατότητα να παίξουν ένας ή δυο παίκτες. Ο κάθε παίκτης επιλέγει το όνομά του και τον\n"+
        				"και τον ήρωά του. Έπειτα ξεκινάει το παιχνίδι. Ο παίκτης που έχει σειρά ρίχνει το κέρμα. Αν το κέρμα δείξει κορώνα τότε ο παίκτης οδηγείται\n"+
        				"σε μάχη στην οποία διαθέτει τρία όπλα, σπαθί, δόρυ και τόξο. Αν το κέρμα δείξει γράμματα τότε ο παίκτης οδηγείται σε έναν από τους γρίφους.\n"+
        				"Αν ο παίκτης κερδίσει τη μάχη ή βρει το γρίφο τότε έχει δικαίωμα να ρίξει το ζάρι και να κινήσει το πιόνι του πάνω στο ταμπλό. Έπειτα, αν παίζουν δυο\n"+
        				"παίκτες παίζει ο δεύτερος παίκτης, αλλιώς ξαναρίχνει το κέρμα ο αρχικός παίκτης."
        				, "Το παιχνίδι", JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        
        info_about_stats_Action.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0){
        		new StatisticFrame();
        	}
        });
        
        info_about_us_Action.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0){
        		JOptionPane.showMessageDialog(null, "ΑΝΑΛΥΤΕΣ \n -----------------------\n ΑΛΒΑΝΟΥ ΣΟΦΙΑ \n ΚΑΡΑΓΚΙΑΟΥΡΗ ΣΙΑ \n ΜΑΚΑΡΟΒΣΚΑ ΜΑΡΙΑ \n ΣΕΝΤΕΡΗ ΓΑΒΡΙΕΛΑ \n \n" +
        				"ΣΧΕΔΙΑΣΤΕΣ \n -----------------------\n ΓΙΑΝΝΙΩΤΗΣ ΑΠΟΣΤΟΛΗΣ \n ΕΛΕΥΘΕΡΙΑΔΗΣ ΘΟΔΩΡΗΣ \n ΛΟΥΚΙΔΗΣ ΓΡΗΓΟΡΗΣ \n \n" +
        				"ΠΡΟΓΡΑΜΜΑΤΙΣΤΕΣ \n -----------------------\n ΔΗΜΟΠΟΥΛΟΣ ΘΟΔΩΡΗΣ \n ΚΟΤΣΙΚΟΡΗΣ ΠΑΝΟΣ \n ΜΟΣΧΟΥ ΝΑΣΙΑ \n ΧΑΤΖΗΠΑΡΑΣΚΕΥΑΣ ΓΙΩΡΓΟΣ \n \n" +
        				"ΔΟΚΙΜΑΣΤΕΣ \n -----------------------\n ΒΥΡΑ ΝΙΚΟΛΕΤΑ \n ΘΥΜΙΑΝΗΣ ΝΙΚΟΣ \n ΣΠΗΛΙΑΚΟΣ ΚΩΝΣΤΑΝΤΙΝΟΣ", null, JOptionPane.INFORMATION_MESSAGE);
        	}
        });

        //Just a Sound when Clicked 
        fileMenu.addMenuListener(new MenuListener() {

        	@Override
        	public void menuSelected(MenuEvent e) {
        		soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat() ); //Sound: click_sword
        	}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        
        //Just a Sound when Clicked 
        infoMenu.addMenuListener(new MenuListener() {

        	@Override
        	public void menuSelected(MenuEvent e) {
        		soundthread1.PlayMusic(list.get(0).getSongName(), list.get(0).getRepeat() ); //Sound: click_sword
        	}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
    }

        public JMenuBar getMenu() {
        	return menuBar;
        }
        
    }