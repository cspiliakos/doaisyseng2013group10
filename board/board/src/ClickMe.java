
public class ClickMe extends Puzzle{
	private int code;
	
	public ClickMe() {
		super();
		code=2;
		
	}

	public void addXP() {
		//methodos gia prosthiki xp		
	}

	@Override
	public void addcoins() {
		//methodos gia prosthiki coins
	}
	
	public int getCode(){
		return code;
	}

	public void startPuzzle(){
		//gia na ksekinisei to paixnidi kaloume ton kataskeyasth tou
		new ClickMeFrame();
		System.out.println("clickme");
	}
}
