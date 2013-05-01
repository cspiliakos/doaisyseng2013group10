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
             JOptionPane.showMessageDialog(null	, "Info About Puzzles:\n1)������� Quiz ��������� :2. ���� ��� 4 ������� ����������,,� ������� �������� ��� ���������� ��������." +
             	 "\n2)������� Click-me: ���� ����� ��� ������ ����������� ��� ������. � ������� �� ������ ��� ������������ �����, �� ����� ��� ����������� ���� ���� ���� ������ ������."+
            	 "\n3)������� Ancient arcade: � ������� ����������� 6 ����� ��� ���������� �� 6 �������������� ����, ��� ��� ��� ������."+
             	 "\n4)������� ���������: ����������� ���� ����� ��� ���������������� ����. � ������� ������ �� ������������� ��� ���� ���� ����� ��� �����"+
            	 "\n5)������� Memory game: � ������� ���� ��� ����������� 8 ����� ������ �������� ������������� �������"+
             	 "\n6)������� 3-Pics-1-hero: ���� ����� ������������ 3 �������. � ������� ���������� �� ����� ��� ���� ��� ����������� �� �������" +
            	 "\n7)������� T������: ����������� ���� ����� ���� ������ O ��� ��� X. � ������� �������� �� ����� ��� ����� �� ���� �������� �� ��������."+
             	 "\n8)������� 8-block-puzzle: ����������� ���� ����� ��� puzzle ��������� �� 9 ��������� ���������,�� ��� ����.� ������� ��������� �� ���������� ��� ����� ������."+
            	 "\n9) ������� ��������: ����������� ���� ����� ��� ���� ������� ��� �� ������ ������ ��� ������ �����. � ������� ��������� �� ���������� �� ����� ����."
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