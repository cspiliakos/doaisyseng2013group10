import javax.swing.ImageIcon;


public class CharsOpponents extends Monsters {
	
	private boolean defeated=false;
	//method to create opponents for the player in duels

	public CharsOpponents(String name, double damage, double defence, double health, ImageIcon image) {
		super(name, damage, defence, health, image);
		// TODO Auto-generated constructor stub
	}

	public boolean isDefeated() {
		return defeated;
	}

	public void setDefeated(boolean defeated) {
		this.defeated = defeated;
	}

	
	

}
