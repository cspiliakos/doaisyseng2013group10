import java.util.*;

import javax.swing.*;


public class PicsHerosHero {
	
	private String name;
	private ImageIcon icons[];
		
	public PicsHerosHero(String name, ImageIcon i[]){
		icons=new ImageIcon[3];
		icons=i;
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageIcon getIcon(int index){
		return icons[index];
	}
	
	

}
