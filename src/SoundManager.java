import org.lwjgl.openal.AL;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

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

    /**
     * Initializes the source of sound
     * @param src
     */
    public SoundManager(String src) {
        this.src = src;
    }

    /**
     * Loads sound resource
     */
    public void init() {
        try {
//			oggStream = AudioLoader.getStreamingAudio("OGG", ResourceLoader.getResource(src));
            wav = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream(src));
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
//		oggStream.playAsMusic(1.0f, 1.0f, true);
        wav.playAsMusic(1.0f, 1.0f, true);
    }

}
