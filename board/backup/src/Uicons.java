import java.util.*;

import javax.swing.*;


public class Uicons extends ImageIcon {
	
	private ArrayList<ImageIcon> picsHerosIcons;
	private ArrayList<CardLabel> mmg_icons;//Memory Game
	private ArrayList<ImageIcon> ArcadeIcons;
	
	public Uicons(){		
	
	//3pics1hero icons
	picsHerosIcons=new ArrayList<ImageIcon>();
		
	ImageIcon iconDedalus1=new ImageIcon("UIcons\\picshero_dedalos_labyrinth.jpg");
	ImageIcon iconDedalus2=new ImageIcon("UIcons\\picshero_dedalos_talos.jpg");
	ImageIcon iconDedalus3=new ImageIcon("UIcons\\picshero_dedalos.gif");
	
	picsHerosIcons.add(iconDedalus1); //0
	picsHerosIcons.add(iconDedalus2); //1
	picsHerosIcons.add(iconDedalus3); //2 
	
	ImageIcon iconDionysus1=new ImageIcon("UIcons\\picshero_dioniysus_Pan.jpg");
	ImageIcon iconDionysus2=new ImageIcon("UIcons\\picshero_dionysus_wine.jpg");
	ImageIcon iconDionysus3=new ImageIcon("UIcons\\picshero_dionysus.jpg");
	
	picsHerosIcons.add(iconDionysus1); //3
	picsHerosIcons.add(iconDionysus2); //4
	picsHerosIcons.add(iconDionysus3); //5
	
	ImageIcon iconHercules1=new ImageIcon("UIcons\\picshero_Hercules_hydra.png");
	ImageIcon iconHercules2=new ImageIcon("UIcons\\picshero_Hercules_nemealion.jpg");
	ImageIcon iconHercules3=new ImageIcon("UIcons\\picshero_Hercules_snake.jpg");
	
	picsHerosIcons.add(iconHercules1); //6
	picsHerosIcons.add(iconHercules2); //7
	picsHerosIcons.add(iconHercules3); //8
	
	ImageIcon iconIaswnas1=new ImageIcon("UIcons\\picshero_iaswnas_argw.jpg");
	ImageIcon iconIaswnas2=new ImageIcon("UIcons\\picshero_iaswnas_sympligades.jpg");
	ImageIcon iconIaswnas3=new ImageIcon("UIcons\\picshero_iaswnas_xderas.jpg");
	
	picsHerosIcons.add(iconIaswnas1); //9
	picsHerosIcons.add(iconIaswnas2); //10
	picsHerosIcons.add(iconIaswnas3); //11
	
	ImageIcon iconOdysseas1=new ImageIcon("UIcons\\picshero_odysseas_doureios.jpg");
	ImageIcon iconOdysseas2=new ImageIcon("UIcons\\picshero_odysseas_kirki.jpg");
	ImageIcon iconOdysseas3=new ImageIcon("UIcons\\picshero_odysseas_polyfimos.jpg");
	
	picsHerosIcons.add(iconOdysseas1); //12
	picsHerosIcons.add(iconOdysseas2); //13
	picsHerosIcons.add(iconOdysseas3); //14
	
	ImageIcon iconPerseas1=new ImageIcon("UIcons\\picshero_perseus_argos.jpg");
	ImageIcon iconPerseas2=new ImageIcon("UIcons\\picshero_perseus_medusa.jpg");
	ImageIcon iconPerseas3=new ImageIcon("UIcons\\picshero_perseus_zeus.jpg");
	
	picsHerosIcons.add(iconPerseas1); //15
	picsHerosIcons.add(iconPerseas2); //16
	picsHerosIcons.add(iconPerseas3); //17
	
	ImageIcon iconPromitheas1=new ImageIcon("UIcons\\picshero_promitheas_caucasus.gif");
	ImageIcon iconPromitheas2=new ImageIcon("UIcons\\picshero_promitheas_fwtia.png");
	ImageIcon iconPromitheas3=new ImageIcon("UIcons\\picshero_promitheas.jpg");
	
	picsHerosIcons.add(iconPromitheas1); //18
	picsHerosIcons.add(iconPromitheas2); //19
	picsHerosIcons.add(iconPromitheas3); //20
	
	ImageIcon iconThiseas1=new ImageIcon("UIcons\\picshero_thiseas_gyrismos.jpg");
	ImageIcon iconThiseas2=new ImageIcon("UIcons\\picshero_thiseas_minotauros.png");
	ImageIcon iconThiseas3=new ImageIcon("UIcons\\picshero_thiseas_taurosmarathona.jpg");
	
	picsHerosIcons.add(iconThiseas1); //21
	picsHerosIcons.add(iconThiseas2); //22
	picsHerosIcons.add(iconThiseas3); //23
	
	ImageIcon iconOlympus=new ImageIcon("UIcons\\olympus.jpg");
	picsHerosIcons.add(iconOlympus); //24 background
	
	//Memory Game Stuff
	mmg_icons=new ArrayList<CardLabel>();
	
	ImageIcon default_back_mmg=new ImageIcon("UIcons\\mmg_background.jpg"); // 0 backgound
	ImageIcon default_pattern_mmg=new ImageIcon("UIcons\\mmg_pattern.jpg"); // 1 closed cards (pattern)
	ImageIcon aphrodite_mmg=new ImageIcon("UIcons\\mmg_aphrodite.jpg");    //  2
	ImageIcon apollo_mmg=new ImageIcon("UIcons\\mmg_apollo.jpg");           // 3
	ImageIcon artemis_mmg=new ImageIcon("UIcons\\mmg_artemis.jpg");        //  4
	ImageIcon athena_mmg=new ImageIcon("UIcons\\mmg_athena.jpg");        //    5
	ImageIcon hera_mmg=new ImageIcon("UIcons\\mmg_hera.jpg");             //   6
	ImageIcon pegasus_mmg=new ImageIcon("UIcons\\mmg_pegasus.jpg");       //   7
	ImageIcon poseidon_mmg=new ImageIcon("UIcons\\mmg_poseidon.jpg");       // 8
	ImageIcon zeus_mmg=new ImageIcon("UIcons\\mmg_zeus.jpg");               // 9
	
	mmg_icons.add(new CardLabel(default_back_mmg,      "default") );
	mmg_icons.add(new CardLabel(default_pattern_mmg,  "default2") );
	
	mmg_icons.add(new CardLabel(aphrodite_mmg,        "aphrodite") );  //We need twice each icon
	mmg_icons.add(new CardLabel(aphrodite_mmg,        "aphrodite") );
	
	mmg_icons.add(new CardLabel(apollo_mmg,              "apollo") );
	mmg_icons.add(new CardLabel(apollo_mmg,              "apollo") );
	
	mmg_icons.add(new CardLabel(artemis_mmg,            "artemis") );	
	mmg_icons.add(new CardLabel(artemis_mmg,            "artemis") );
	 
	mmg_icons.add(new CardLabel(athena_mmg,              "athena") );
	mmg_icons.add(new CardLabel(athena_mmg,              "athena") );
	
	mmg_icons.add(new CardLabel(hera_mmg,                  "hera") );
	mmg_icons.add(new CardLabel(hera_mmg,                  "hera") );
	
	mmg_icons.add(new CardLabel(pegasus_mmg,            "pegasus") );
	mmg_icons.add(new CardLabel(pegasus_mmg,            "pegasus") );
	 
	mmg_icons.add(new CardLabel(poseidon_mmg,          "poseidon") );
	mmg_icons.add(new CardLabel(poseidon_mmg,          "poseidon") );
	
	mmg_icons.add(new CardLabel(zeus_mmg,                  "zeus") );
	mmg_icons.add(new CardLabel(zeus_mmg,                  "zeus") );

	
	
	//Ancient Arcade Stuff
		ArcadeIcons=new ArrayList<ImageIcon>();
		
		ImageIcon  back_anime=new  ImageIcon("UIcons\\arcade_background.jpg"); //0 background image
		
		ImageIcon  arcade_hero_1=new  ImageIcon("UIcons\\arcade_zeus.jpg"); //1
		ImageIcon  arcade_hero_2=new  ImageIcon("UIcons\\arcade_poseidon.jpg"); //2 
		ImageIcon  arcade_hero_3=new  ImageIcon("UIcons\\arcade_hercules.jpg"); //3
		ImageIcon  arcade_hero_4=new  ImageIcon("UIcons\\arcade_theseus.jpg"); //4
		ImageIcon  arcade_hero_5=new  ImageIcon("UIcons\\arcade_odysseus.jpg"); //5
		ImageIcon  arcade_hero_6=new  ImageIcon("UIcons\\arcade_perseus.jpg"); //6

		ImageIcon  arcade_symbol_1=new  ImageIcon("UIcons\\arcade_cerberus.jpg"); //7
		ImageIcon  arcade_symbol_2=new  ImageIcon("UIcons\\arcade_minotaur.jpg"); //8
		ImageIcon  arcade_symbol_3=new  ImageIcon("UIcons\\arcade_olympus.jpg"); //9
		ImageIcon  arcade_symbol_4=new  ImageIcon("UIcons\\arcade_medusa.jpg"); //10
		ImageIcon  arcade_symbol_5=new  ImageIcon("UIcons\\arcade_scylla.jpg"); //11
		ImageIcon  arcade_symbol_6=new  ImageIcon("UIcons\\arcade_sea.jpg"); //12
	
		
		//adding the ImageIcons
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
	public ArrayList<CardLabel> getMMGIcons() {
		return mmg_icons;
	}

	public void setMMGIcons(ArrayList<CardLabel> usedIcons) {
		this.mmg_icons = usedIcons;
	}
	
	
	
}
