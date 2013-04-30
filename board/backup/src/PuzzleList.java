import java.util.ArrayList;

public class PuzzleList {
	private ArrayList<Puzzle> puzzles;
		
	public PuzzleList(){
		//dhmiourgia listas puzzle prosthiki 1-1 tous grifous
		puzzles=new ArrayList<Puzzle>();
		puzzles.add(new ClickMe());
		puzzles.add(new AncientArcade());
		puzzles.add(new TeleCube());
		puzzles.add(new PicsHeros());
		puzzles.add(new MemoryGame());
			
	}

	public ArrayList<Puzzle> getPuzzles() {
		return puzzles;
	}

	public void setPuzzles(ArrayList<Puzzle> puzzles) {
		this.puzzles = puzzles;
	}

	
	
}
