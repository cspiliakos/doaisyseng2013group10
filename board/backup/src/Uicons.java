import java.util.*;
import javax.swing.*;

public class Uicons extends ImageIcon {
	private static final long serialVersionUID = 1L;
	private ArrayList<ImageIcon> picsHerosIcons, mmg_icons, ArcadeIcons;
	
	public Uicons() {		
	
	//3pics1hero icons
	picsHerosIcons = new ArrayList<ImageIcon>();
	
	ImageIcon iconDedalus2 = new ImageIcon("UIcons\\picshero_dedalos_talos.jpg");
	iconDedalus2.setDescription("Τάλο");
	ImageIcon iconDedalus3 = new ImageIcon("UIcons\\picshero_dedalos.gif");
	iconDedalus3.setDescription("Δαίδαλο");
	ImageIcon iconDionysus1 = new ImageIcon("UIcons\\picshero_dioniysus_Pan.jpg");
	iconDionysus1.setDescription("Πάνα");
	ImageIcon iconDionysus3 = new ImageIcon("UIcons\\picshero_dionysus.jpg");
	iconDionysus3.setDescription("Διόνυσο");
	ImageIcon iconOdysseas1 = new ImageIcon("UIcons\\picshero_odysseas_doureios.jpg");
	iconOdysseas1.setDescription("Δούρειο Ίππο");
	ImageIcon iconOdysseas3 = new ImageIcon("UIcons\\picshero_odysseas_polyfimos.jpg");
	iconOdysseas3.setDescription("Πολύφημο");
	ImageIcon iconPerseas3 = new ImageIcon("UIcons\\picshero_perseus_zeus.jpg");
	iconPerseas3.setDescription("Δία");
	ImageIcon iconPromitheas3 = new ImageIcon("UIcons\\picshero_promitheas.jpg");
	iconPromitheas3.setDescription("Προμηθέα");
	ImageIcon iconThiseas2 = new ImageIcon("UIcons\\picshero_thiseas_minotauros.png");
	iconThiseas2.setDescription("Μινόταυρο");
	ImageIcon iconOlympus = new ImageIcon("UIcons\\olympus.jpg");
	iconOlympus.setDescription("Όλυμπο");
	picsHerosIcons.add(iconDedalus2);
	picsHerosIcons.add(iconDedalus3); 
	picsHerosIcons.add(iconDionysus1); 
	picsHerosIcons.add(iconDionysus3); 
	picsHerosIcons.add(iconOdysseas1);
	picsHerosIcons.add(iconOdysseas3);
	picsHerosIcons.add(iconPerseas3);
	picsHerosIcons.add(iconPromitheas3);
	picsHerosIcons.add(iconThiseas2);
	picsHerosIcons.add(iconOlympus);
	
	ImageIcon iconHercules1 = new ImageIcon("UIcons\\picshero_Hercules_hydra.png");
	iconHercules1.setDescription("Ύδρα");
	ImageIcon iconHercules2 = new ImageIcon("UIcons\\picshero_Hercules_nemealion.jpg");
	iconHercules2.setDescription("Νεμέα");
	ImageIcon iconIaswnas1 = new ImageIcon("UIcons\\picshero_iaswnas_argw.jpg");
	iconIaswnas1.setDescription("Αργώ");
	ImageIcon iconOdysseas2 = new ImageIcon("UIcons\\picshero_odysseas_kirki.jpg");
	iconOdysseas2.setDescription("Κίρκη");
	ImageIcon iconPerseas2 = new ImageIcon("UIcons\\picshero_perseus_medusa.jpg");
	iconPerseas2.setDescription("Μέδουσα");
	picsHerosIcons.add(iconHercules1);
	picsHerosIcons.add(iconHercules2); 
	picsHerosIcons.add(iconIaswnas1); 
	picsHerosIcons.add(iconOdysseas2);
	picsHerosIcons.add(iconPerseas2);

	ImageIcon iconIaswnas3 = new ImageIcon("UIcons\\picshero_iaswnas_xderas.jpg");
	iconIaswnas3.setDescription("Χρυσόμαλλο Δέρας");
	ImageIcon iconPerseas1 = new ImageIcon("UIcons\\picshero_perseus_argos.jpg");
	iconPerseas1.setDescription("Άργος");
	picsHerosIcons.add(iconIaswnas3); 
	picsHerosIcons.add(iconPerseas1);
	
	//Memory Game Stuff
	mmg_icons = new ArrayList<ImageIcon>();
	
	mmg_icons.add(new ImageIcon("UIcons\\mmg_background.jpg"));
	mmg_icons.add(new ImageIcon("UIcons\\mmg_pattern.jpg"));
	
	ImageIcon aphrodite1 = new ImageIcon("UIcons\\mmg_aphrodite.jpg");
	ImageIcon aphrodite2 = new ImageIcon("UIcons\\mmg_aphrodite.jpg");
	aphrodite1.setDescription("1");
	aphrodite2.setDescription("1");
	mmg_icons.add(aphrodite1);
	mmg_icons.add(aphrodite2);
	
	ImageIcon apollo1 = new ImageIcon("UIcons\\mmg_apollo.jpg");
	ImageIcon apollo2 = new ImageIcon("UIcons\\mmg_apollo.jpg");
	apollo1.setDescription("2");
	apollo2.setDescription("2");
	mmg_icons.add(apollo1);
	mmg_icons.add(apollo2);
	
	ImageIcon artemis1 = new ImageIcon("UIcons\\mmg_artemis.jpg");
	ImageIcon artemis2 = new ImageIcon("UIcons\\mmg_artemis.jpg");
	artemis1.setDescription("3");
	artemis2.setDescription("3");
	mmg_icons.add(artemis1);	
	mmg_icons.add(artemis2);
	 
	ImageIcon athena1 = new ImageIcon("UIcons\\mmg_athena.jpg");
	ImageIcon athena2 = new ImageIcon("UIcons\\mmg_athena.jpg");
	athena1.setDescription("4");
	athena2.setDescription("4");
	mmg_icons.add(athena1);
	mmg_icons.add(athena2);
	
	ImageIcon hera1 = new ImageIcon("UIcons\\mmg_hera.jpg");
	ImageIcon hera2 = new ImageIcon("UIcons\\mmg_hera.jpg");
	hera1.setDescription("5");
	hera2.setDescription("5");
	mmg_icons.add(hera1);
	mmg_icons.add(hera2);
	
	ImageIcon pegasus1 = new ImageIcon("UIcons\\mmg_pegasus.jpg");
	ImageIcon pegasus2 = new ImageIcon("UIcons\\mmg_pegasus.jpg");
	pegasus1.setDescription("6");
	pegasus2.setDescription("6");
	mmg_icons.add(pegasus1);
	mmg_icons.add(pegasus2);
	 
	ImageIcon poseidon1 = new ImageIcon("UIcons\\mmg_poseidon.jpg");
	ImageIcon poseidon2 = new ImageIcon("UIcons\\mmg_poseidon.jpg");
	poseidon1.setDescription("7");
	poseidon2.setDescription("7");
	mmg_icons.add(poseidon1);
	mmg_icons.add(poseidon2);
	
	ImageIcon zeus1 = new ImageIcon("UIcons\\mmg_zeus.jpg");
	ImageIcon zeus2 = new ImageIcon("UIcons\\mmg_zeus.jpg");
	zeus1.setDescription("8");
	zeus2.setDescription("8");
	mmg_icons.add(zeus1);
	mmg_icons.add(zeus2);
	
	//Ancient Arcade Stuff
	ArcadeIcons = new ArrayList<ImageIcon>();
		
	ImageIcon  back_anime = new  ImageIcon("UIcons\\arcade_background.jpg"); //0 background image
		
	ImageIcon  arcade_hero_1 = new  ImageIcon("UIcons\\arcade_zeus.jpg"); //1
	ImageIcon  arcade_hero_2 = new  ImageIcon("UIcons\\arcade_poseidon.jpg"); //2 
	ImageIcon  arcade_hero_3 = new  ImageIcon("UIcons\\arcade_hercules.jpg"); //3
	ImageIcon  arcade_hero_4 = new  ImageIcon("UIcons\\arcade_theseus.jpg"); //4
	ImageIcon  arcade_hero_5 = new  ImageIcon("UIcons\\arcade_odysseus.jpg"); //5
	ImageIcon  arcade_hero_6 = new  ImageIcon("UIcons\\arcade_perseus.jpg"); //6
	
	ImageIcon  arcade_symbol_1 = new  ImageIcon("UIcons\\arcade_cerberus.jpg"); //7
	ImageIcon  arcade_symbol_2 = new  ImageIcon("UIcons\\arcade_minotaur.jpg"); //8
	ImageIcon  arcade_symbol_3 = new  ImageIcon("UIcons\\arcade_olympus.jpg"); //9
	ImageIcon  arcade_symbol_4 = new  ImageIcon("UIcons\\arcade_medusa.jpg"); //10
	ImageIcon  arcade_symbol_5 = new  ImageIcon("UIcons\\arcade_scylla.jpg"); //11
	ImageIcon  arcade_symbol_6 = new  ImageIcon("UIcons\\arcade_sea.jpg"); //12	
	
	ArcadeIcons.add(back_anime);
	ArcadeIcons.add(arcade_hero_1);
	ArcadeIcons.add(arcade_hero_2);
	ArcadeIcons.add(arcade_hero_3);
	ArcadeIcons.add(arcade_hero_4);
	ArcadeIcons.add(arcade_hero_5);
	ArcadeIcons.add(arcade_hero_6);
	ArcadeIcons.add(arcade_symbol_1);
	ArcadeIcons.add(arcade_symbol_2);
	ArcadeIcons.add(arcade_symbol_3);
	ArcadeIcons.add(arcade_symbol_4);
	ArcadeIcons.add(arcade_symbol_5);
	ArcadeIcons.add(arcade_symbol_6);
}

	public ArrayList<ImageIcon> getArcadeIcons() {
		return ArcadeIcons;
	}

	public void setArcadeIcons(ArrayList<ImageIcon> aArcadeIcons) {
		ArcadeIcons = aArcadeIcons;
	}

	public ArrayList<ImageIcon> getPicsHerosIcons() {
		return picsHerosIcons;
	}

	public void setPicsHerosIcons(ArrayList<ImageIcon> usedIcons) {
		this.picsHerosIcons = usedIcons;
	}
	//Memory Game
	public ArrayList<ImageIcon> getMMGIcons() {
		return mmg_icons;
	}

	public void setMMGIcons(ArrayList<ImageIcon> usedIcons) {
		this.mmg_icons = usedIcons;
	}
}
