import java.util.Random;

import javax.swing.ImageIcon;


public class Boss extends Monsters{
	
	private User currUser;
	private Random r1, r2;
	private int plusminus;
	private int amount;

	public Boss(String name, double damage, double defence, double  health,
			ImageIcon image, String category) {
		super(name, damage, defence, health, image, category);
		// TODO Auto-generated constructor stub
		r1=new Random(System.currentTimeMillis());
		//apofash gia to an tha prostethei h tha afairethei to poso
		r2=new Random(System.currentTimeMillis());
		//apofash gia to poso tha einai to poso
		
		this.setDamage(this.calculateDamage());
		this.setDefence(this.calculateDefence());
		this.setHealth(this.calculateHealth());
		//ypologismos me bash ta stat tou paixth
		
		
	}

	public double calculateDamage(){
		double currDamage;
		currDamage=currUser.getAttack();
		plusminus=r1.nextInt(1);
		amount=r2.nextInt(10+(currUser.getSkillpoints()));
		if(plusminus==0){
			currDamage=currDamage+amount;
		}
		else{
			currDamage=currDamage-amount;
		}
		return currDamage;
	}
	
	public double calculateDefence(){

		double currDefence;
		currDefence=currUser.getDefence();
		plusminus=r1.nextInt(1);
		amount=r2.nextInt(10+(currUser.getSkillpoints()));
		if(plusminus==0){
			currDefence=currDefence+amount;
		}
		else{
			currDefence=currDefence-amount;
		}
		return currDefence;
	}
	
	public double calculateHealth(){

		double currHealth;
		currHealth=currUser.getHealth();
		plusminus=r1.nextInt(1);
		amount=r2.nextInt(10+(currUser.getSkillpoints()));
		if(plusminus==0){
			currHealth=currHealth+amount;
		}
		else{
			currHealth=currHealth-amount;
		}
		
	return currHealth;
	}
	
}
