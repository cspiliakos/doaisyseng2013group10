import java.util.Random;


public class Spear extends Weapons{

	private Random r;

	public Spear() {
		//type of weapon used in duel
		weaponType="Spear";
		damage=180;
		critical=10;
		price=1000;
		System.out.println("spear");
		r = new Random(System.currentTimeMillis());
	}
	@Override
	public boolean isCritical() {
		int cr=r.nextInt(critical);
		//critical doubles the damage 10% possibility
		if(cr<1)
			return true;
		else
			return false;
		
	}
	

}
