import java.io.File;
import java.util.HashMap;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound_Thread extends Thread{
	private Clip clip;
	private String SongPath;
	private boolean repeat;
	@SuppressWarnings("unused")
	private HashMap<AudioInputStream, Boolean> Sounds ;
	
	public Sound_Thread(){ //Empty Constructor : gia mikrous hxous pou pezoun apo ena mono antikeimeno Sound_Thread(opws AncientArcadeFrame)
		
	}
	public Sound_Thread(String sp, boolean rp){
		SongPath = sp;
		repeat = rp;
		PlayMusic(SongPath, repeat); //Different audios are being played many times

	}

	public void StopMusic(){ //Stops the clip, USED FOR BACKGROUND SOUNDS
		if(clip != null)
			clip.stop();
	}

	public void PlayMusic(String SongPath, boolean repeat){  //Stamataei tous prohgoumenous hxous(ama yparxoun) kai ksekinaei kainourgio
		StopMusic();   
		try{
			File f = new File(SongPath);
			AudioInputStream ais = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			if(repeat)
				clip.loop(Clip.LOOP_CONTINUOUSLY); // for background sounds that are being played CONTINUOUSLY

		}

		catch(Exception e){
			System.out.println("Audio file Not found!");
		}
	}
	/** //Sound
ArrayList<AudiosPair> list = new ArrayList<AudiosPair>(new Audios().getAudios());
Sound_Thread st1 = new Sound_Thread(list.get(0).getSongName(), list.get(0).getRepeat()); **/
}