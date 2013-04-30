import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class List implements Serializable{

	private ArrayList<Words> words;

	public List() {
		words = new ArrayList<Words>();
	}
	
	public void AddWord(Words w) {
		words.add(w);
	}
	
	public void PrintWords() {
		for (int i = 0; i < words.size(); i++)
			System.out.println(""+words.get(i).getName());
	}
	
	public ArrayList<Words> getWords() {
		return words;
	}
	
	public String getWord(Words w) {
		return w.getName();
	}
	
	public String StringTokenizer(String str) {
		char[] array = str.toCharArray();		
		for(int i = 0; i < 10; i++)
		{
			Random char1 = new Random();
			Random char2 = new Random();
			
			int randomInt1 = char1.nextInt(array.length);
			int randomInt2 = char2.nextInt(array.length);
			
			char temp = array[randomInt1];
			array[randomInt1] = array[randomInt2];
			array[randomInt2] = temp;
		}
		String result = new String(array);
		
		return result;
	}
	
	public int GetSize() {
		return words.size();
	}
}