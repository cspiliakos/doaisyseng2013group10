import java.util.Random;


public class CrossBow extends Weapons{
	private Random r;

	public CrossBow() {
		//super(weaponType, damage, critical, price);
		weaponType="CrossBow";
		damage=80;
		critical=10;
		price=200;
		
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
