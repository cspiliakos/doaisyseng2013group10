import java.util.Random;


public class TeleCube extends Puzzle{
	private int code;
	private String i;
	private String j;
	public TeleCube() {
		super();
		//oti yparxei mesa sthn main enos programmatos to kaloume ston kataskeyasth tou
		code=4;
		
		TelecubeList L=new TelecubeList();
		Words a=new Words("COMPUTER");
		Words b=new Words ("WONDERFUL");
		//tha antikatastathei apo diadikasia de-serialization
		
		
		
		L.AddWord(a);
		L.AddWord(b);
		//prosthiki leksewn tha antikatastathei kai ayto apo thn diadikasia de-serialization
		
		L.PrintWords();
		
		Random num= new Random();
		int randomInt1 = num.nextInt(L.GetSize());
		
		
		i=L.getWords().get(randomInt1).getName();
		j=L.StringTokenizer(i);
		
		
	}

	@Override
	public void addXP() {
		//methodos prosthikis xp
		
	}

	@Override
	public void addcoins() {
		//methodos prosthikis coins
		
	}
	public int getCode() {
		return code;
	}

	public void startPuzzle(){
		//gia na ksekinisei to paixnidi kaloume ton kataskeyasth tou
		new TelecubeFrame(j,i);
		System.out.println("thlekybos");
	}
}
