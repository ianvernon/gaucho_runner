import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/** The class that displays final screen after player finishes or dies */
public class EndPlayState extends BasicGameState {
    /** The score that the player got */
    private int score;
    /** The state ID of EndPlayState */
    private int stateID;
    /** The boolean that is set to see what end screen to draw */
    private boolean lose;
    /** The image to be drawn depending on the lose boolean */
    private Image bg;

    EndPlayState(int stateID, int score, boolean lose) {
        super();
        this.stateID = stateID;
        this.score = score;
        this.lose = lose;
    }

    /**
     * Init must be overridden when extending BasicGameState
     *
     * @param c   A generic game container that handles the game loop, fps recording and managing the input system
     * @param sbg The current State Based Game this button is a part of
     * @throws SlickException
     */
    @Override
    public void init(GameContainer c, StateBasedGame sbg) throws SlickException {

    }

    /**
     * @param c   A generic game container that handles the game loop, fps recording and managing the input system
     * @param sbg The current State Based Game this button is a part of
     * @param g   The graphics context to draw images on the screen
     * @throws SlickException
     */
    @Override
    public void render(GameContainer c, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("Score: " + score, 350, 400);
        g.drawImage(bg, 0, 0);

    }

    /**
     * @param c     A generic game container that handles the game loop, fps recording and managing the input system
     * @param sbg   The current State Based Game this button is a part of
     * @param delta The time in milliseconds
     * @throws SlickException
     */
    @Override
    public void update(GameContainer c, StateBasedGame sbg, int delta) throws SlickException {

    }

    /** @return The state ID */
    @Override
    public int getID() {
        return this.stateID;
    }

    /**
     * @param gc  The context in which GUI components are created / rendered (info about system - mouse cursor,
     *            groups system properties that affect how program is run in terms of graphics / interaction w/ user)
     * @param sbg The current State Based Game this state is a part of
     */
    public void enter(GameContainer gc, StateBasedGame sbg) {
        System.out.println("Entering EndPlayState");
        try {
            if (lose) {
                bg = new Image("res/menu/Lose.png");
            } else {
                bg = new Image("res/menu/Win.png");
            }

        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
