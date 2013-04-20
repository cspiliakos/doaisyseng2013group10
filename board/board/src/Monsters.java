import java.awt.Image;

import javax.swing.ImageIcon;


public abstract class Monsters {
	
	protected String name;
	protected int damage;
	protected int defence;
	protected int health;
	protected ImageIcon image;
	protected String category;
	
	public Monsters(String name, int damage, int defence, int health,ImageIcon image, String category){
		this.name=name;
		this.damage=damage;
		this.defence=defence;
		this.health=health;
		this.image=image;
		this.category=category;
		
	}
	
	public abstract void setDamage(int damage);
	public abstract void setDefence(int defence);
	public abstract void setHealth(int health);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public int getDefence() {
		return defence;
	}

	public int getHealth() {
		return health;
	}

	
	
	
	

}
