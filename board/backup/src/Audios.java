import java.util.ArrayList;

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
	
	private ArrayList<AudiosPair> MemoryGameList; //MemoryGame Sounds
	
	private ArrayList<AudiosPair> ClickMeList; //MemoryGame Sounds
	
	private ArrayList<AudiosPair> BoardList; //Board Sounds
	
	private ArrayList<AudiosPair> MenuList; //Menu Sounds
	
	private ArrayList<AudiosPair> DuelList; //Duel Sounds
	
	private ArrayList<AudiosPair> TicTacToeList; //Triliza Sounds
	
	private ArrayList<AudiosPair> HangmamList; //Hangman Sounds
	
	private ArrayList<AudiosPair> PicsHerosList; //PicsHeros Sounds

	private ArrayList<AudiosPair> QuizList; //Quiz Sounds

	private ArrayList<AudiosPair> TelecubeList; //Telecube Sounds
	
	private ArrayList<AudiosPair> Pics3List; //Pics3 Sounds
	
	public Audios(){
		audiosList = new ArrayList<AudiosPair>(); //CREATING ARRAYLIST
		ArcadeList= new ArrayList<AudiosPair>(); //ARRAYLIST FOR ARCADE
		MemoryGameList= new ArrayList<AudiosPair>(); //ARRAYLIST FOR MEMORYGAME
		ClickMeList= new ArrayList<AudiosPair>(); //ARRAYLIST FOR CLICKME
		BoardList= new ArrayList<AudiosPair>(); //ARRAYLIST FOR BOARD
		MenuList= new ArrayList<AudiosPair>(); //ARRAYLIST FOR JMENUFRAME
		DuelList= new ArrayList<AudiosPair>(); //ARRAYLIST FOR DUELBOARDFRAME
		TicTacToeList= new ArrayList<AudiosPair>(); //ARRAYLIST FOR TicTacToe
		HangmamList= new ArrayList<AudiosPair>(); //ARRAYLIST FOR Hangman
		PicsHerosList= new ArrayList<AudiosPair>(); //ARRAYLIST FOR PicsHerosFrame
		QuizList= new ArrayList<AudiosPair>(); //ARRAYLIST FOR QuizFrame
		TelecubeList= new ArrayList<AudiosPair>(); //ARRAYLIST FOR TelecubeFrame
		Pics3List= new ArrayList<AudiosPair>(); //ARRAYLIST FOR Pics3
		
		
		audiosList.add(new AudiosPair("Sounds\\battle_theme.wav", true));           //0
		audiosList.add(new AudiosPair("Sounds\\click_meny_buttons.wav", false));   //1
		audiosList.add(new AudiosPair("Sounds\\corona_h_grammata.wav", true));    //2
		audiosList.add(new AudiosPair("Sounds\\dice_roll.wav", false));           //3
		audiosList.add(new AudiosPair("Sounds\\swordedited.wav", false));        //4
		//Ancient Arcade Sounds
		ArcadeList.add(new AudiosPair("Sounds\\ancientarcade_correct.wav", false));          //0
		ArcadeList.add(new AudiosPair("Sounds\\ancientarcade_dias.wav", false));          //1
		ArcadeList.add(new AudiosPair("Sounds\\ancientarcade_minotaur.wav", false));          //2
		ArcadeList.add(new AudiosPair("Sounds\\ancientarcade_olympos.wav", false));          //3
		ArcadeList.add(new AudiosPair("Sounds\\ancientarcade_perseus.wav", false));          //4
		ArcadeList.add(new AudiosPair("Sounds\\ancientarcade_cerberus.wav", false));          //5
		ArcadeList.add(new AudiosPair("Sounds\\quiz_theme2.wav", true));                    //6		
		//MemoryGame Sounds
		MemoryGameList.add(new AudiosPair("Sounds\\memorygame_select.wav", false));              // 0 
		MemoryGameList.add(new AudiosPair("Sounds\\memorygame_right.wav", false));              //  1
		MemoryGameList.add(new AudiosPair("Sounds\\memorygame_congratulations.wav", false));   //   2
		MemoryGameList.add(new AudiosPair("Sounds\\memorygame_wrong.wav", false));            //    3
		MemoryGameList.add(new AudiosPair("Sounds\\memorygame_soundtrack.wav", true));       //     4

		//ClickMe Sounds
		ClickMeList.add(new AudiosPair("Sounds\\clickme_endofgame.wav", false));            //    0
		ClickMeList.add(new AudiosPair("Sounds\\clickme_right.wav", false));            //    1
		ClickMeList.add(new AudiosPair("Sounds\\clickme_wrong.wav", false));            //    2
		ClickMeList.add(new AudiosPair("Sounds\\quiz_theme1.wav", true));            //    3
		
		//Hangman Sounds
		HangmamList.add(new AudiosPair("Sounds\\hangman_right.wav", false));            //    0
		HangmamList.add(new AudiosPair("Sounds\\hangman_select.wav", false));            //    1
		HangmamList.add(new AudiosPair("Sounds\\quiz_theme1.wav", true));            //    2
		HangmamList.add(new AudiosPair("Sounds\\hangman_wrong.wav", false));            //    3
		
		
		//Board Sounds
		BoardList.add(new AudiosPair("Sounds\\board_corona_h_grammata.wav", false));    //    0
		BoardList.add(new AudiosPair("Sounds\\board_dice_roll.wav", false));            //    1
		BoardList.add(new AudiosPair("Sounds\\board_soundtrack.wav", true));            //    2
		
		//PicsHeros Sounds
		PicsHerosList.add(new AudiosPair("Sounds\\picsheros_click.wav", false));        //    0
		PicsHerosList.add(new AudiosPair("Sounds\\picsheros_soundtrack.wav", true));    //    1
		
		//Quiz Sounds
		QuizList.add(new AudiosPair("Sounds\\quiz_click.wav", false));        //    0
		QuizList.add(new AudiosPair("Sounds\\quiz_soundtrack.wav", true));    //    1

		//Telecube Sounds
		TelecubeList.add(new AudiosPair("Sounds\\telecube_click.wav", false));        //    0
		TelecubeList.add(new AudiosPair("Sounds\\telecube_soundtrack.wav", true));    //    1
		TelecubeList.add(new AudiosPair("Sounds\\telecube_wrong.wav", false));        //    2

		//Pics3 Sounds
		Pics3List.add(new AudiosPair("Sounds\\pices3_click.wav", false));        //    0
		Pics3List.add(new AudiosPair("Sounds\\pices3_soundtrack.wav", true));    //    1


		//JMENUFRAME Sounds
		MenuList.add(new AudiosPair("Sounds\\menu_click_sword.wav", false));     //    0
		
		DuelList.add(new AudiosPair("Sounds\\duel_buy.wav", false));          //    0
		DuelList.add(new AudiosPair("Sounds\\duel_upgrade.wav", false));      //    1
		DuelList.add(new AudiosPair("Sounds\\duel_soundtrack.wav", false))  ; //    2

		TicTacToeList.add(new AudiosPair("Sounds\\tic_tac_toe_click.wav", false));        //    0
		TicTacToeList.add(new AudiosPair("Sounds\\tic_tac_toe_soundtrack.wav", false));  //    1


	}
	public ArrayList<AudiosPair> getPics3List() {
		return Pics3List;
	}
	public void setPics3List(ArrayList<AudiosPair> pics3List) {
		Pics3List = pics3List;
	}
	public ArrayList<AudiosPair> getTelecubeList() {
		return TelecubeList;
	}
	public void setTelecubeList(ArrayList<AudiosPair> telecubeList) {
		TelecubeList = telecubeList;
	}
	public ArrayList<AudiosPair> getQuizList() {
		return QuizList;
	}
	public void setQuizList(ArrayList<AudiosPair> quizList) {
		QuizList = quizList;
	}
	public ArrayList<AudiosPair> getPicsHerosList() {
		return PicsHerosList;
	}
	public void setPicsHerosList(ArrayList<AudiosPair> picsHerosList) {
		PicsHerosList = picsHerosList;
	}
	public ArrayList<AudiosPair> getHangmamList() {
		return HangmamList;
	}
	public void setHangmamList(ArrayList<AudiosPair> hangmamList) {
		HangmamList = hangmamList;
	}
	public ArrayList<AudiosPair> getTicTacToeList() {
		return TicTacToeList;
	}
	public void setTicTacToeList(ArrayList<AudiosPair> ticTacToeList) {
		TicTacToeList = ticTacToeList;
	}
	public ArrayList<AudiosPair> getDuelList() {
		return DuelList;
	}
	public void setDuelList(ArrayList<AudiosPair> duelList) {
		DuelList = duelList;
	}
	public ArrayList<AudiosPair> getMenuList() {
		return MenuList;
	}
	public void setMenuList(ArrayList<AudiosPair> menuList) {
		MenuList = menuList;
	}
	public ArrayList<AudiosPair> getBoardList() {
		return BoardList;
	}
	public void setBoardList(ArrayList<AudiosPair> boardList) {
		BoardList = boardList;
	}
	public ArrayList<AudiosPair> getClickMeList() {
		return ClickMeList;
	}
	public void setClickMeList(ArrayList<AudiosPair> clickMeList) {
		ClickMeList = clickMeList;
	}
	public ArrayList<AudiosPair> getMemoryGameList() {
		return MemoryGameList;
	}
	public void setMemoryGameList(ArrayList<AudiosPair> memoryGameList) {
		MemoryGameList = memoryGameList;
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
