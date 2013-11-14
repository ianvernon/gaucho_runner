import org.lwjgl.openal.AL;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A class that loads a sound resource and makes it available for output
 */
public class SoundManager {
    /** Source of sound*/
    private String src;
    /** OGG file stream */
    private Audio oggStream;
    /** WAV file stream */
    private Audio wav;
    private ArrayList<String> srcList;
    public ArrayList<Audio> soundList;


    /**
     * Initializes the source of sound
     */
    public SoundManager() {
        srcList = new ArrayList<String>();
        srcList.add("res/sound/Testarossa.wav");
        srcList.add("res/sound/theme.wav");
        init();
    }

    /**
     * Loads sound resource
     */
    public void init() {
            try {
                wav = (AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream(srcList.get(0))));
            } catch (IOException e) {
                e.printStackTrace();
            }


    }

    /**
     * Destroys sound resource
     */
    public void destroy() {
        AL.destroy();
    }

    /**
     * Plays sound resource
     */
    public void play() {
        wav.playAsMusic(1.0f, 1.0f, true);
//         soundList.get(0).playAsMusic(1.0f, 1.0f, true);

    }

}
