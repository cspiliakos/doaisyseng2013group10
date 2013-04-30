import java.awt.Image;

import javax.swing.ImageIcon;


public abstract class Monsters {

	protected String name;
	protected double damage;
	protected double defence;
	protected double health;
	protected ImageIcon image;

	public Monsters(){ //Empty Constructor for the use of User Class

	}

	public Monsters(String name, double damage, double defence, double health, ImageIcon image){
		this.name=name;
		this.damage=damage;
		this.defence=defence;
		this.health=health;
		this.image=image;

	}



	public void setDamage(double damage) {
		this.damage = damage;
	}



	public void setDefence(double defence) {
		this.defence = defence;
	}



	public void setHealth(double health) {
		this.health = health;
	}


	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDamage() {
		return damage;
	}

	public double getDefence() {
		return defence;
	}

	public double getHealth() {
		return health;
	}

}