
public class AncientArcade extends Puzzle{
	private int code;

	public AncientArcade() {
		super();
		code=1;
	}

	@Override
	public void addXP() {
		//methodos gia ton ypologismo twn xp	
	}

	@Override
	public void addcoins() {
		//methodos gia ton ypologismo twn coins	
	}
	
	public int getCode() {
		return code;
	}
	
	public void startPuzzle(){
		//gia na ksekinisei to paixnidi kaloume ton kataskeyasth tou frame tou
		new AncientArcadeFrame();
		System.out.println("ancient arcade");
	}
}
