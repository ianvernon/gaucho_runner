import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;


public class SoundTest {
	
	private String src;
	private Audio wav;

	public SoundTest(String src) {
		this.src = src;
	}

	public void init(){
		try{
			wav = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream(src));
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	public void destroy(){
		AL.destroy();
	}
	public void play(){
		wav.playAsMusic(1.0f, 1.0f, true);
	}

}
