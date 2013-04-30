import java.io.Serializable;

@SuppressWarnings("serial")
public class Words implements Serializable {

	private String name;
	
	public Words(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void printName() {
		System.out.println(name);
	}
}
