import java.util.Random;


public class CrossBow extends Weapons{
	//class that creates the bow weapon for duel
	private Random r;

	public CrossBow() {
		//super(weaponType, damage, critical, price);
		weaponType="CrossBow";
		damage=80;
		critical=10;
		price=200;
		System.out.println("bow");
		r = new Random(System.currentTimeMillis());
	}

	@Override
	public boolean isCritical() {
		//double the damage 
		int cr=r.nextInt(critical);
		//possibility 20%
		if(cr<2)
			return true;
		else
			return false;
	}
	
	

}
