import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * A class that loads a sound resource and makes it available for output
 */
public class SoundManager {
    /** Source of sound*/
    private Sound  crash;
    private Music  theme;

    /**
     * Initializes the source of sound
     */
    public SoundManager() {

    }

    /**
     * Loads sound resource
     */
    public void init() throws SlickException {
        theme = new Music("res/sound/Testarossa.wav");
        theme.loop();


        crash = new Sound("res/sound/crash.wav");

    }

    /**
     * Destroys sound resource
     */
    public void destroy() {
//        AL.destroy();
    }

    /**
     * Plays sound resource
     */
    public void play(String src) {
//        wav.playAsMusic(1.0f, 1.0f, true);
//
//   soundList.get(0).playAsMusic(1.0f, 1.0f, true);
        if(src == "theme"){
            theme.play();
        }
        else if (src == "crash"){
            crash.play();
        }


    }

}
