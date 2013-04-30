import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class User extends Monsters { //extends Mosnter --> User is a character
	private String Username; //The name of the Current Player

	private int skillpoints;
	//points to upgrade skills


	private int coins;
	private ArrayList<Weapons> weapons;
	private Weapons currWeapon;

	public User(String name)
	{
		super();
		Username = name;
		this.skillpoints=10;

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

	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}

	public Weapons getCurrWeapon() {
		return currWeapon;
	}

	public void setCurrWeapon(Weapons currWeapon) {
		this.currWeapon = currWeapon;
	}

	public int getSkillpoints() {
		return skillpoints;
	}

	public void setSkillpoints(int skillpoints) {
		this.skillpoints = skillpoints;
	}

}