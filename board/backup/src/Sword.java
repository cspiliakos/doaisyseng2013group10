import java.util.Random;

public class Sword extends Weapons{
	private Random r;

	public Sword() {
		//type of weapon used in duel
		//the user has only a sword when he start
		weaponType="Sword";
		damage=100;
		critical=4;
		price=100;
		level=1;
		r=new Random(System.currentTimeMillis());
	}
	
	public boolean isCritical(){		
		int cr=r.nextInt(critical);
		//critical double damage 20% possibility
		if(cr<2)
			return true;
		else
			return false;
	}
	
	

}
