import java.util.*;
import javax.swing.*;

public class PicsHerosHeroManager {
	
	private Uicons iconList;
	private ArrayList<ImageIcon> currList;
	private ArrayList<PicsHerosHero> heroes;
	@SuppressWarnings("unused")
	private PicsHerosHero currHero;
	@SuppressWarnings("unused")
	private String name;
	private ArrayList<String> heroNames;
	
	public PicsHerosHeroManager(){
		
		heroNames=new ArrayList<String>();
		addNames();
		//add the names of heroes		
		iconList=new Uicons();
		//na ginetai mia fora genika oxi edw sto fortwma tou paixnidiou
		currList=new ArrayList<ImageIcon>(iconList.getPicsHerosIcons());
		heroes=new ArrayList<PicsHerosHero>();
	}
	
	public void addNames(){
		//adding names of heroes
		//the order must be according to the order the pics were imported
		heroNames.add("DEDALUS");
		heroNames.add("DIONYSUS");
		heroNames.add("HERCULES");
		heroNames.add("IASON");
		heroNames.add("ODYSSEUS");
		heroNames.add("PERSEUS");
		heroNames.add("PROMITHEUS");
		heroNames.add("THESEUS");
	}
	
	
	
	public void createHeroList(){
		int i;
		int j;
		int k;
		String currName="";
		for(i=0;i<((currList.size()-1)/3);i++){
		//the icon list has 3 pics related to each hero (minus 1 because of the background)
				
			ImageIcon[] currIcons=new ImageIcon[3];
			k=0;
			//k if for the icon array, it goes up to 3 (3 pics for each hero) and back to zero for the next hero
			
			for(j=(i*3);j<((i*3)+3);j++){
			//read the icon array step by step
			//(i*3) because in the first loop it increases only by 1 each time
				
				currName=heroNames.get(i);
				currIcons[k]=currList.get(j);
				k++;
			}
			heroes.add(new PicsHerosHero(currName,currIcons));
			//creating the final hero to display
		}	
		System.out.println(heroes.size());
	}
	
	public PicsHerosHero getHero(){
		//gettin a random hero
		 Random r = new Random();
		  return heroes.get(r.nextInt(heroes.size()));
	}
}
	
	
	


