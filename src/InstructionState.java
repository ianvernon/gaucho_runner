import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/** A class that implements the state where instructions are displayed */
public class InstructionState extends BasicGameState {
    /** Location of graphic when quit button is selected */
    private final String menuSelected = "res/menu/MenuSelected.png";
    /** Location of graphic when quit button is unselected */
    private final String menuUnselected = "res/menu/MenuUnselected.png";
    /** Location of background */
    private final String instructions = "res/menu/Instructions.png";
    /** Instructions Menu */
    private Menu instructionsMenu;
    /** Instructions state ID */
    private int stateID;
    /** Starting menu x-position */
    private int startingX = 500;
    /** Starting menu y-position */
    private int startingY = 470;
    /** The space between Menu items */
    private int spaceBetweenItems = 131;
    /** Image object of graphic when quit button is selected */
    private Image backUs;
    /** Image object of graphic when quit button is selected */
    private Image backS;
    /** background image */
    private Image instructionList;

    /**
     * Sets instruction state ID
     *
     * @param stateID The state Id that this state will have
     */
    InstructionState(int stateID) {
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
        initMenu(gc, sbg);

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
        g.drawImage(instructionList, 0, 0);
        instructionsMenu.render(gc, g);
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

    /**
     * Initialized instructions menu with images
     *
     * @param gc  The context in which GUI components are created / rendered
     *            (info about system - mouse cursor, groups system properties that affect
     *            how program is run in terms of graphics / interaction w/ user)
     * @param sbg The current State Based Game
     */
    private void initMenu(GameContainer gc, StateBasedGame sbg) {
        instructionsMenu = new Menu(startingX, startingY, spaceBetweenItems);

        // create images for each button
        try {
            instructionList = new Image(instructions);
            backUs = new Image(menuUnselected);
            backS = new Image(menuSelected);
        } catch (SlickException ex) {
            ex.printStackTrace();
            return;
        }
        AnimatedButton play = new AnimatedButton(gc, sbg, backUs, backS, startingX, startingY, 0, 2);

        play.add(new ButtonAction() {
            public void perform() {
                /*currentState = STATES.PLAY;
                sbg.enterState(GauchoRunner.PLAY_STATE_ID);*/
            }
        }
        );

        instructionsMenu.addItem(play);

    }
}
