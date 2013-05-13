import java.util.ArrayList;

public class User extends Monsters {
	private String Username;
	private int skillpoints,skillpointsUsed, coins, xp;
	private ArrayList<Weapons> weapons;
	private Weapons currWeapon;
	private boolean win,played;

	public User(String name)
	{
		super();
		Username = name;
		skillpoints = 10;
		skillpointsUsed=0;
		coins = 10000;
		xp = 0;
		weapons = new ArrayList<Weapons>();
		weapons.add(new Sword());
		win = false;
		played=false;
	}
	
	public void increaseSkillPoints(int xp,int sk){
		skillpoints=skillpoints+((xp/1000)-skillpointsUsed);
	}


	public int getSkillpointsUsed() {
		return skillpointsUsed;
	}

	public void setSkillpointsUsed(int skillpointsUsed) {
		this.skillpointsUsed = skillpointsUsed;
	}

	public boolean isPlayed() {
		return played;
	}


	public void setPlayed(boolean played) {
		this.played = played;
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
	
	public boolean getWin() {
		return win;
	}
	
	public void setWin(boolean win) {
		this.win = win;
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