import java.util.*;
import javax.swing.*;

public class Uicons extends ImageIcon {
	private static final long serialVersionUID = 1L;
	private ArrayList<ImageIcon> picsHerosIcons, mmg_icons, ArcadeIcons, pics3Icons;
	
	public Uicons() {
		pics3Icons = new ArrayList<ImageIcon>();
		
		ImageIcon dedalos1 = new ImageIcon("UIcons\\picshero_dedalos.gif");
		dedalos1.setDescription("ƒ¡…ƒ¡Àœ”");
		pics3Icons.add(dedalos1);
		ImageIcon dedalos2 = new ImageIcon("UIcons\\picshero_dedalos_labyrinth.jpg");
		dedalos2.setDescription("ƒ¡…ƒ¡Àœ”");
		pics3Icons.add(dedalos2);
		ImageIcon dedalos3 = new ImageIcon("UIcons\\picshero_dedalos_talos.jpg");
		dedalos3.setDescription("ƒ¡…ƒ¡Àœ”");
		pics3Icons.add(dedalos3);
		
		ImageIcon dionisos1 = new ImageIcon("UIcons\\picshero_dioniysus_Pan.jpg");
		dionisos1.setDescription("ƒ…œÕ’”œ”");
		pics3Icons.add(dionisos1);
		ImageIcon dionisos2 = new ImageIcon("UIcons\\picshero_dionysus.jpg");
		dionisos2.setDescription("ƒ…œÕ’”œ”");
		pics3Icons.add(dionisos2);
		ImageIcon dionisos3 = new ImageIcon("UIcons\\picshero_dionysus_wine.jpg");
		dionisos3.setDescription("ƒ…œÕ’”œ”");
		pics3Icons.add(dionisos3);
		
		ImageIcon iraklis1 = new ImageIcon("UIcons\\picshero_Hercules_hydra.png");
		iraklis1.setDescription("«—¡ À«”");
		pics3Icons.add(iraklis1);
		ImageIcon iraklis2 = new ImageIcon("UIcons\\picshero_Hercules_nemealion.jpg");
		iraklis2.setDescription("«—¡ À«”");
		pics3Icons.add(iraklis2);
		ImageIcon iraklis3 = new ImageIcon("UIcons\\picshero_Hercules_snake.jpg");
		iraklis3.setDescription("«—¡ À«”");
		pics3Icons.add(iraklis3);
		
		ImageIcon iasonas1 = new ImageIcon("UIcons\\picshero_iaswnas_argw.jpg");
		iasonas1.setDescription("…¡”ŸÕ¡”");
		pics3Icons.add(iasonas1);
		ImageIcon iasonas2 = new ImageIcon("UIcons\\picshero_iaswnas_sympligades.jpg");
		iasonas2.setDescription("…¡”ŸÕ¡”");
		pics3Icons.add(iasonas2);
		ImageIcon iasonas3 = new ImageIcon("UIcons\\picshero_iaswnas_xderas.jpg");
		iasonas3.setDescription("…¡”ŸÕ¡”");
		pics3Icons.add(iasonas3);
		
		ImageIcon oddyseas1 = new ImageIcon("UIcons\\picshero_odysseas_doureios.jpg");
		oddyseas1.setDescription("œƒ’””≈¡”");
		pics3Icons.add(oddyseas1);
		ImageIcon oddyseas2 = new ImageIcon("UIcons\\picshero_odysseas_kirki.jpg");
		oddyseas2.setDescription("œƒ’””≈¡”");
		pics3Icons.add(oddyseas2);
		ImageIcon oddyseas3 = new ImageIcon("UIcons\\picshero_odysseas_polyfimos.jpg");
		oddyseas3.setDescription("œƒ’””≈¡”");
		pics3Icons.add(oddyseas3);
		
		ImageIcon perseas1 = new ImageIcon("UIcons\\picshero_perseus_argos.jpg");
		perseas1.setDescription("–≈—”≈¡”");
		pics3Icons.add(perseas1);
		ImageIcon perseas2 = new ImageIcon("UIcons\\picshero_perseus_medusa.jpg");
		perseas2.setDescription("–≈—”≈¡”");
		pics3Icons.add(perseas2);
		ImageIcon perseas3 = new ImageIcon("UIcons\\picshero_perseus_zeus.jpg");
		perseas3.setDescription("–≈—”≈¡”");
		pics3Icons.add(perseas3);
		
		ImageIcon promitheas1 = new ImageIcon("UIcons\\picshero_promitheas.jpg");
		promitheas1.setDescription("–—œÃ«»≈¡”");
		pics3Icons.add(promitheas1);
		ImageIcon promitheas2 = new ImageIcon("UIcons\\picshero_promitheas_caucasus.gif");
		promitheas2.setDescription("–—œÃ«»≈¡”");
		pics3Icons.add(promitheas2);
		ImageIcon promitheas3 = new ImageIcon("UIcons\\picshero_promitheas_fwtia.png");
		promitheas3.setDescription("–—œÃ«»≈¡”");
		pics3Icons.add(promitheas3);
		
		ImageIcon thiseas1 = new ImageIcon("UIcons\\picshero_thiseas_gyrismos.jpg");
		thiseas1.setDescription("»«”≈¡”");
		pics3Icons.add(thiseas1);
		ImageIcon thiseas2 = new ImageIcon("UIcons\\picshero_thiseas_minotauros.png");
		thiseas2.setDescription("»«”≈¡”");
		pics3Icons.add(thiseas2);
		ImageIcon thiseas3 = new ImageIcon("UIcons\\picshero_thiseas_taurosmarathona.jpg");
		thiseas3.setDescription("»«”≈¡”");
		pics3Icons.add(thiseas3);
		
		//3pics1hero icons
		picsHerosIcons = new ArrayList<ImageIcon>();
		
		ImageIcon image1 = new ImageIcon("UIcons\\picshero_dedalos_talos.jpg");
		image1.setDescription("‘‹ÎÔ");
		ImageIcon image2 = new ImageIcon("UIcons\\picshero_dedalos.gif");
		image2.setDescription("ƒ·ﬂ‰·ÎÔ");
		ImageIcon image3 = new ImageIcon("UIcons\\picshero_dioniysus_Pan.jpg");
		image3.setDescription("–‹Ì·");
		ImageIcon image4 = new ImageIcon("UIcons\\picshero_dionysus.jpg");
		image4.setDescription("ƒÈ¸ÌıÛÔ");
		ImageIcon image5 = new ImageIcon("UIcons\\picshero_odysseas_doureios.jpg");
		image5.setDescription("ƒÔ˝ÒÂÈÔ ∫Ô");
		ImageIcon image6 = new ImageIcon("UIcons\\picshero_odysseas_polyfimos.jpg");
		image6.setDescription("–ÔÎ˝ˆÁÏÔ");
		ImageIcon image7 = new ImageIcon("UIcons\\picshero_perseus_zeus.jpg");
		image7.setDescription("ƒﬂ·");
		ImageIcon image8 = new ImageIcon("UIcons\\picshero_promitheas.jpg");
		image8.setDescription("–ÒÔÏÁË›·");
		ImageIcon image9 = new ImageIcon("UIcons\\picshero_thiseas_minotauros.png");
		image9.setDescription("ÃÈÌ¸Ù·ıÒÔ");
		ImageIcon image10 = new ImageIcon("UIcons\\olympus.jpg");
		image10.setDescription("ºÎıÏÔ");
		picsHerosIcons.add(image1);
		picsHerosIcons.add(image2); 
		picsHerosIcons.add(image3); 
		picsHerosIcons.add(image4); 
		picsHerosIcons.add(image5);
		picsHerosIcons.add(image6);
		picsHerosIcons.add(image7);
		picsHerosIcons.add(image8);
		picsHerosIcons.add(image9);
		picsHerosIcons.add(image10);
		
		ImageIcon image11 = new ImageIcon("UIcons\\picshero_Hercules_hydra.png");
		image11.setDescription("ÀÂÒÌ·ﬂ· æ‰Ò·");
		ImageIcon image12 = new ImageIcon("UIcons\\picshero_Hercules_nemealion.jpg");
		image12.setDescription("ÀÈÔÌÙ‹ÒÈ ÙÁÚ ÕÂÏ›·Ú");
		ImageIcon image13 = new ImageIcon("UIcons\\picshero_iaswnas_argw.jpg");
		image13.setDescription("¡Ò„˛");
		ImageIcon image14 = new ImageIcon("UIcons\\picshero_odysseas_kirki.jpg");
		image14.setDescription(" ﬂÒÍÁ");
		ImageIcon image15 = new ImageIcon("UIcons\\picshero_perseus_medusa.jpg");
		image15.setDescription("Ã›‰ÔıÛ·");
		picsHerosIcons.add(image11);
		picsHerosIcons.add(image12); 
		picsHerosIcons.add(image13); 
		picsHerosIcons.add(image14);
		picsHerosIcons.add(image15);

		ImageIcon image16 = new ImageIcon("UIcons\\picshero_iaswnas_xderas.jpg");
		image16.setDescription("◊ÒıÛ¸Ï·ÎÎÔ ƒ›Ò·Ú");
		ImageIcon image17 = new ImageIcon("UIcons\\picshero_perseus_argos.jpg");
		image17.setDescription("¢Ò„ÔÚ");
		picsHerosIcons.add(image16); 
		picsHerosIcons.add(image17);
		
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
	
	public ArrayList<ImageIcon> getPics3() {
		return pics3Icons;
	}

	public void setPics3(ArrayList<ImageIcon> usedIcons) {
		this.pics3Icons = usedIcons;
	}
}
