
public class MemoryGame extends Puzzle{
	private int code;

	
	public MemoryGame(){
		super();
		code=5;
	}
	@Override
	public void addXP() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addcoins() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startPuzzle() {
		new MemoryGameFrame();
		
	}

	@Override
	public int getCode() {
		// TODO Auto-generated method stub
		return code;
	}

}
