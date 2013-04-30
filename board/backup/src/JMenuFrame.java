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