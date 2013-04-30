import java.util.Random;

import javax.swing.JOptionPane;




public class Sword extends Weapons{
	private Random r;

	public Sword() {
		//super(weaponType, damage,critical,price);
		weaponType="Sword";
		damage=100;
		critical=4;
		price=0;
		
		r=new Random(System.currentTimeMillis());
	}
	
	public boolean isCritical(){		
		int cr=r.nextInt(critical);
		//afou akolouthei mia kanonikh katanomh tote exei 20% pithanothta na ferei enan apo tous arithmous
		if(cr==2)
			return true;
		else
			return false;
	}
	
	

}
