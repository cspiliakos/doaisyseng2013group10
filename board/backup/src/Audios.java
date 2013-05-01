import java.util.ArrayList;
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
	private ArrayList<AudiosPair> audiosList;

	private ArrayList<AudiosPair> ArcadeList; //Arcade Sounds

	public Audios(){
		audiosList = new ArrayList<AudiosPair>(); //CREATING ARRAYLIST
		ArcadeList= new ArrayList<AudiosPair>(); //ARRAYLIST FOR ARCADE

		audiosList.add(new AudiosPair("battle_theme.wav", true));           //0
		audiosList.add(new AudiosPair("click_meny_buttons.wav", false));   //1
		audiosList.add(new AudiosPair("corona_h_grammata.wav", true));    //2
		audiosList.add(new AudiosPair("dice_roll.wav", false));           //3
		audiosList.add(new AudiosPair("swordedited.wav", false));        //4
		//Ancient Arcade Sounds
		ArcadeList.add(new AudiosPair("ancientarcade_correct.wav", false));          //0
		ArcadeList.add(new AudiosPair("ancientarcade_dias.wav", false));          //1
		ArcadeList.add(new AudiosPair("ancientarcade_minotaur.wav", false));          //2
		ArcadeList.add(new AudiosPair("ancientarcade_olympos.wav", false));          //3
		ArcadeList.add(new AudiosPair("ancientarcade_perseus.wav", false));          //4

	}
	public ArrayList<AudiosPair> getAudiosList() {
		return audiosList;
	}

	public void setAudiosList(ArrayList<AudiosPair> audiosList) {
		this.audiosList = audiosList;
	}

	public ArrayList<AudiosPair> getArcadeList() {
		return ArcadeList;
	}

	public void setArcadeList(ArrayList<AudiosPair> arcadeList) {
		ArcadeList = arcadeList;
	}


	public ArrayList<AudiosPair> getAudios() {
		return audiosList;
	}

	public void setAudios(ArrayList<AudiosPair> audios) {
		this.audiosList = audios;
	}


}