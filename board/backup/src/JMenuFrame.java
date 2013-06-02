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
        
        JMenuItem info_about_stats_Action = new JMenuItem("� ���� ��� �����");
        info_about_stats_Action.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        JMenuItem info_about_us_Action = new JMenuItem("� ����� ���");
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
            			"�������: ����� �� ����� ����� ��� ����� �� ����� ������� ���� ��� (����� ������). ������ ���� ���� ������� �� ������� �������� ��� ��� ��������� �������� ��� ���� ����� � �������� ������� ��� \n"+
            			"��� ���� ���������, ��� �������, ��� ���������, ����� �������� ��� ����� ������������.\n"+
            			"������: ���� � ������ ��� � �������� ��� ������ ������ ��� �������. ������� ��� ������ ���, ��� ������, ��� ��������� ���� �� �������� ��� ����������� ������ ������.\n"+
            			"����: ���� ��� ������ ��� ��� ����, ������� ��� ������� ��� ��� �����. ����� ���� ��� ������� ��� ��� ��������. �������� ��� � ������� ��� ������� ��� � ��� ���.\n"+
            			"����������: ���� ��� ������ ��� ��� ����. � ���� ��� ������� ��� ��� ��������. ������� ��� ���� � ����. �������������� ��� ����������� ���� � ������� ���.\n"+
            			"����: � �������� ��� ���� ������ (�������), ���� ��� ������� ��� ��� ������. ������� ��� ��� ��� ��� ���������.\n"+
            			"����: � ���� ��� ������� ���� ��� �������� ���������, ���� ��� ��� ��� ��� ����. ������ ��� ���� � �����. ����������� ����������� ��� ����������� ���\n"+
            			"���������� ��� ����������� ���� ��� �������.\n"+
            			"�������: ���������� �� � �������� ��� ������� �����. ��������� ��� ���� ��� ���� ���� ��� ��� ��� ��� ��������. �������������� ��� ���� �� ������.\n"+
            			"��������: �������������� ��� ������ ��� ��� ��� ���� ������� ��� ����� ���� ������, �� ���� ������� ��� �� ���� ��� �������� �� ������ ������.\n"+
            			"�������: ���������� �� ��� ��� ��� ����� ��������. � ������� ��� ���� ������, ��� ������ ��� �������� ��� ������� �������.\n"+
            			"����������: ���� ��� �� �� ���� �������� ��� ������ ��� ���� ������. ���������� ��� ���������, ������ ��� ��������� ��� �� ������� ������� ������� ��� ������� ��� ������ �����.\n"+
            			"��������: ���� ��� ������ ��� ��� ����������, ������� ��� ��������� ��� ������� ��� ���������. ������� �������� ��� ������. ����� ������ ������� ��� ��� ������� ��� ��� �������������� ���.\n"+
            			"�������: ���� ��� ��� ��� ��� ������. ������� ��� ���� � ��������, �������� ��� ������. � ����� ����� �������� �� �������� ��� ������� �� ��� ������� ��� ������.\n"+
            			"������: �������� ��� ��������� ��� ��� ����� ����� ������ ����� ��� ��������� ����������. ���� ��� ������� ��� ������ ���� ��������� ��� �� ���������� �����.\n"+
            			"������: ���� ������� �������� ��� ������ ���� �������� ���������, ���� ��� ����� ��� ��� ������, ������� ��� ��������� ���� ���� ��������� ��� ������ ��� ����������� �� ����� ���� ���� ���� �����."
            			, "����� ��� ����������", JOptionPane.INFORMATION_MESSAGE);
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
            			"����������� ��� ���� �������:\n"+
            			"1) Quiz ���������: ���������� ���� ����� ��� ������� ��� 4 ������� ����������. � ������� ��������� �� ���� �� ����� ��������. ���� ��� ��� \n" +
            			"�������� ��� ������ ����������� ��� �������\n"+
            			"2) Click-me: ���� ����� ����������� ��� ������. � ������� �� ������ �� ������������ �����, �� ����� ��� ����������� ���� ������ ���� ���� ������.\n"+
            			"3) ������������: ������������ ���� ����� 12 �������. � ������� �������� �� ������������� ���� �� �������� ����� 6 ����� ��� ���������� �� 6 \n"+
            			"�������������� ����.\n"+
            			"4) ���������������: ���������� ���� ����� ��� ���������������� ����. � ������� ��������� �� ���� �� ����� ����. ���� ��������� ����������� ��� ����\n"+
            			"5) �������� ������: ������������ ���� ����� 16 ��������� �������. � ������� ��������� ���� ���� ����� ��� ��� ������� �� ���� ��� ����������� �����"+
            			"������ ������� ������.\n"+
            			"6) Quiz �����: ���� ����� ������������ 3 �������. � ������� ��������� �� ���� ����� ����� ������� ��� 3 �������. ���� ��� �������� ��� ������\n"+
            			"����������� ��� ������ �������.\n"+
            			"7) T������: ����������� ���� ����� ��� ������ 9 ����������. � ������� ��������� �� ������������ ������� ���� ���������, ���� ������, ���� ��������.\n"+
            			"8) Quiz �������: ������������ ���� ����� 3 ������� ��� �� ����� ���� ��������� ��������. � ������� �������� �� ���� ��� ������ ��� �����������"+
            			"��� �������.\n���� ��� �������� ��� ������ ����������� ��� ������ �������.\n"+
            			"9) �������: ������������ ���� ����� ������ ��� ������������ ��� ���� ������ ��� ���������� �����. � ������� ��������� �� ���������� �� ����� ����."
            			, "������ ��� ����������", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        //INFO ABOUT GAME
        info_about_game_Action.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		JOptionPane.showMessageDialog(null	, 
        				"�� Live your Myth ����� ��� ����������� ��������. ����� �� ���������� �� ������� ���� � ��� �������. � ���� ������� �������� �� ����� ��� ��� ���\n"+
        				"��� ��� ���� ���. ������ �������� �� ��������. � ������� ��� ���� ����� ������ �� �����. �� �� ����� ������ ������ ���� � ������� ���������\n"+
        				"�� ���� ���� ����� �������� ���� ����, �����, ���� ��� ����. �� �� ����� ������ �������� ���� � ������� ��������� �� ���� ��� ���� �������.\n"+
        				"�� � ������� �������� �� ���� � ���� �� ����� ���� ���� �������� �� ����� �� ���� ��� �� ������� �� ����� ��� ���� ��� ������. ������, �� ������� ���\n"+
        				"������� ������ � �������� �������, ������ ���������� �� ����� � ������� �������."
        				, "�� ��������", JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        
        info_about_stats_Action.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0){
        		new StatisticFrame();
        	}
        });
        
        info_about_us_Action.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0){
        		JOptionPane.showMessageDialog(null, "�������� \n -----------------------\n ������� ����� \n ������������ ��� \n ���������� ����� \n ������� �������� \n \n" +
        				"���������� \n -----------------------\n ���������� ��������� \n ������������ ������� \n �������� �������� \n \n" +
        				"��������������� \n -----------------------\n ���������� ������� \n ���������� ����� \n ������ ����� \n ��������������� ������� \n \n" +
        				"���������� \n -----------------------\n ���� �������� \n �������� ����� \n ��������� ������������", null, JOptionPane.INFORMATION_MESSAGE);
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