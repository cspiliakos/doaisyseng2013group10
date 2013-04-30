import java.util.ArrayList;
import java.util.Random;



public class TelecubeList {

	private ArrayList<Words> words;
	

	public TelecubeList(){
		words =new ArrayList();
	}
	
	
	public void AddWord(Words w){
		
		words.add(w);
		
	}
	
	public void PrintWords(){
		for (int i=0;i<words.size();i++)
			System.out.println(""+words.get(i).getName());
	}
	
	public ArrayList<Words> getWords() {
		return words;
	}

	public String StringTokenizer(String str){
						
		char[] array=str.toCharArray();		
		for(int i=0;i<10;i++)
		{
			Random char1 = new Random();
			Random char2= new Random();
			
			int randomInt1 = char1.nextInt(array.length);
			int randomInt2 = char2.nextInt(array.length);
			
			char temp=array[randomInt1];
			array[randomInt1]=array[randomInt2];
			array[randomInt2]=temp;
		}
		String result= new String(array);
		
		return result;
	}
	public int GetSize(){
		return words.size();
	}
}