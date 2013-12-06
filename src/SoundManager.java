import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * A class that loads a sound resource and makes it available for output
 */
public class SoundManager {
    /** Source of crash and collision sound */
    private Sound crash;
    /** Source of crowd cheer sound */
    private Sound cheer;
    /** Source of booing sound */
    private Sound boo;
    /** Source of powerup sound */
    private Sound powerUp;
    /** Source of game theme music */
    private Music theme;

    /**
     * Initializes the source of sound
     */
    public SoundManager() {

    }

    /**
     * Loads sound resource
     */
    public void init() throws SlickException {
        theme = new Music("res/sound/soundtrack.wav");
        crash = new Sound("res/sound/crash.wav");
        cheer = new Sound("res/sound/cheering.wav");
        boo = new Sound("res/sound/booing.wav");
        powerUp = new Sound("res/sound/powerup.wav");

    }

    /**
     * Plays sound resource
     * @param src name of sound to be played
     */
    public void play(String src) {
        if(src == "theme"){
            theme.loop();
        }
        else if (src == "crash"){
            crash.play();
        }
        else if (src == "cheering"){
            cheer.play();
        }
        else if (src == "boo"){
            boo.play();
        }
        else if (src == "powerup"){
            powerUp.play();
        }
    }

    /**
     * Stops sound resource
     * @param src name of sound to be stopped
     */
    public void stop(String src){
        if(src == "theme"){
            theme.fade(1500, 0f, true);
        }
        else if (src == "crash"){
            crash.stop();
        }
        else if (src == "cheering"){
            cheer.stop();
        }
        else if (src == "boo"){
            boo.stop();
        }
        else if (src == "powerup"){
            powerUp.stop();
        }

    }
}
