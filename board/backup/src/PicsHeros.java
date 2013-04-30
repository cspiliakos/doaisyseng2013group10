
public class PicsHeros extends Puzzle{
	private int code;
	public PicsHeros() {
		super();
		code=3;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addXP() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addcoins() {
		// TODO Auto-generated method stub
		
	}

	public int getCode() {
		return code;
	}
 
	public void startPuzzle(){
		new PicsHerosFrame(new PicsHerosHeroManager());
		System.out.println("pics heros");
	}


}
