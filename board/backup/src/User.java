import java.util.ArrayList;

public class User extends Monsters {
	private String Username;
	private int skillpoints, coins, xp;
	private ArrayList<Weapons> weapons;
	private Weapons currWeapon;

	public User(String name)
	{
		super();
		Username = name;
		skillpoints = 10;
		coins = 1000;
		xp = 0;
		weapons = new ArrayList<Weapons>();
		weapons.add(new Sword());
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public int getXP() {
		return xp;
	}

	public void setXP(int xp) {
		this.xp = xp;
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