import java.util.Random;


public class Spear extends Weapons{

	private Random r;

	public Spear() {
		//super(weaponType, damage, critical, price);
		weaponType="Spear";
		damage=180;
		critical=10;
		price=1000;
		
		r = new Random(System.currentTimeMillis());
	}
	@Override
	public boolean isCritical() {
		int cr=r.nextInt(critical);
		//afou akolouthei mia kanonikh katanomh tote exei 20% pithanothta na ferei enan apo tous arithmous
		if(cr==2)
			return true;
		else
			return false;
		
	}
	

}
