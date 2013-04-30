import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class User {
	private String name;
	private double attack;
	private double defence;
	private double health;
	private int skillpoints;
	//points to upgrade skills
	private ImageIcon charImage;
	
	private int coins;
	private ArrayList<Weapons> weapons;
	private Weapons currWeapon;
	
	public User(String name) 
	{
		super();
		this.name = name;
		this.attack = 20;
		this.defence = 20;
		this.health = 100;
		this.skillpoints=10;
		this.charImage=null;
		
		//from user class of duel board
		coins = 100000;
		//just for checking 
		weapons =new ArrayList<Weapons>();
		weapons.add(new Sword());
	}

	
	
	
	


	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public ArrayList<Weapons> getWeapons() {
		return weapons;
	}

	public void setWeapons(ArrayList<Weapons> weapons) {
		this.weapons = weapons;
	}

	public void addWeapons(Weapons currWeapon){
		weapons.add(currWeapon);
	}
	
	public ImageIcon getCharImage() {
		return charImage;
	}

	public void setCharImage(ImageIcon charImage) {
		this.charImage = charImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAttack() {
		return attack;
	}

	public void setAttack(double attack) {
		this.attack = attack;
	}

	public double getDefence() {
		return defence;
	}

	public void setDefence(double defence) {
		this.defence = defence;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public int getSkillpoints() {
		return skillpoints;
	}

	public void setSkillpoints(int skillpoints) {
		this.skillpoints = skillpoints;
	}
	
}