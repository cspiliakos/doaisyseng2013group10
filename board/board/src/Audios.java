import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;

//Returns a HashMap with 1)audios path and 2)booelan: whether must be repeated or not 
public class Audios {
	// battle_theme.wav
	//click_meny_buttons.wav
	//corona_h_grammata.wav
	//dice_roll.wav
	//swordedited.wav
	//toxo(2).wav
	private HashMap<String, Boolean>  audios ;

	public Audios(){
		
		audios.put("battle_theme.wav", true);
		audios.put("click_meny_buttons.wav", false);
		audios.put("corona_h_grammata.wav", true);
		audios.put("dice_roll.wav", false);
		audios.put("swordedited.wav", false);
		audios.put("toxo(2).wav", false);
		
	}

	public HashMap<String, Boolean> getAudios() {
		return audios;
	}

	public void setAudios(HashMap<String, Boolean> audios) {
		this.audios = audios;
	}
}
