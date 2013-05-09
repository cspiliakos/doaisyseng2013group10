import java.util.Random;

import javax.swing.ImageIcon;


public class Boss extends Monsters{
	//class only for bosses in every stage
	
	private User currUser;
	private Random r1, r2;
	private int plusminus;
	private int amount;

	public Boss(String name, double damage, double defence, double  health,
			ImageIcon image) {
		super(name, damage, defence, health, image);
		
		r1=new Random(System.currentTimeMillis());
		//1 --> adding the amount
		//2 --> diminish the amount
		r2=new Random(System.currentTimeMillis());
		//how much the amount is
		
		this.setDamage(this.calculateDamage());
		this.setDefence(this.calculateDefence());
		this.setHealth(this.calculateHealth());
		//calculate the bosses stats according to the player stats so the player has possibilities to pass the stage
		
		
	}

	public double calculateDamage(){
		//method to calculate Damage
		double currDamage;
		currDamage=currUser.getDamage();
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
		//method to calculate defence
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
		//method to calculate health
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
