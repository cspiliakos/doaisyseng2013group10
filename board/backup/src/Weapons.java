import java.util.ArrayList;

import javax.swing.JOptionPane;


public abstract class Weapons{
	//protected User currUser;
	//protected int coins=10000;
	//boithitikh metablhth gia na elegxoume thn agora antikeimenwn
	//kanonika einai parametros pou pairnei apo thn klash user opou tha einai apothikeymena ta coins twn paixtwn
	
	protected String weaponType;
	protected int damage;
	protected int critical;
	protected int price;
	protected int level;
	
	private ArrayList<Weapons> weapons;
	
	public Weapons() {
		//this.weaponType = weaponType;
		//this.damage = damage;
		//this.critical=critical;
		//this.price=price;
		this.level=0;
	}

	public String getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getCritical() {
		return critical;
	}

	public void setCritical(int critical) {
		this.critical = critical;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public abstract boolean isCritical();
	
	public void upgradeWeapon(User user, Weapons w){
		if (level==3)
			JOptionPane.showMessageDialog(null, "No further upgrade possible");
		else{
			int coins=user.getCoins();
			if (coins>=w.price){
				w.level++;
				w.price=w.price+((w.price*50)/100);
				//aykshsh kata to 50% ths prohgoumenhs timhs
				w.damage=w.damage+((w.damage*30)/100);
				}
		}
		
		
	}
	
	public void buyWeapons(User user, Weapons bWeapon){
		weapons=new ArrayList<Weapons>();
		weapons=user.getWeapons();
		boolean found=false;
		for(Weapons w: weapons){
			if((w.getWeaponType()).equals(bWeapon.getWeaponType())){
				found=true;
				System.out.println("You already have a "+bWeapon.getWeaponType());
			}
		}
		if (!found){
			weapons.add(bWeapon);
		}
			
		}
		

}
