
public class AudiosPair {

	private String songName;
	private boolean repeat;
	
	//Name and Loop for each Audio File
	public AudiosPair(String sn , boolean rp){
		songName= sn;
		repeat= rp;
		
	}


	public String getSongName() {
		return songName;
	}


	public void setSongName(String songName) {
		this.songName = songName;
	}


	public boolean getRepeat() {
		return repeat;
	}


	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}
}
