/**
 * Created with IntelliJ IDEA.
 * User: ianvernon
 * Date: 12/5/13
 * Time: 9:17 PM
 * To change this template use File | Settings | File Templates.
 */
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/** A class that quits the game are displayed */
public class QuitState extends BasicGameState {

    /** QuitState state ID */
    private int stateID;

    /**
     * Sets quit state ID
     *
     * @param stateID The state Id that this state will have
     */
    public QuitState(int stateID) {
        super();
        this.stateID = stateID;
    }

    /**
     * Sets the game container and state based game
     *
     * @param gc  The game container that handles the game loop, fps recording and managing the input system
     * @param sbg The current State Based Game
     */
    public void init(GameContainer gc, StateBasedGame sbg) {

    }

    /**
     * Draws the instructions for the game
     *
     * @param gc  The game container that handles the game loop, fps recording and managing the input system
     * @param sbg The current State Based Game
     * @param g   The graphics context to draw images on the screen
     * @throws SlickException
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        if(sbg.getCurrentStateID() == this.stateID)
        {
            gc.exit();
        }
    }

    /**
     * Updates the instructions state.
     *
     * @param gc    The game container that handles the game loop, fps recording and managing the input system
     * @param sbg   The current State Based Game
     * @param delta The time in milliseconds
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

    }

    /**
     * Gets state ID
     *
     * @return the current state ID of the instruction state
     */
    @Override
    public int getID() {
        return stateID;
    }
}
