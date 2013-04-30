public class TeleCube extends Puzzle{
	private int code;

	public TeleCube() {
		super();
		code = 4;
	}

	public void addXP() {
		//methodos prosthikis xp
	}

	public void addcoins() {
		//methodos prosthikis coins
	}
	
	public int getCode() {
		return code;
	}

	public void startPuzzle(){
		new TelecubeFrame();
	}
}
