import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/** A class that implements the state in which the main menu is first rendered */
public class MenuState extends BasicGameState {
    /** Location of unselected play button graphic */
    private final String playUnselected = "res/menu/PlayButton.png";
    /** Location of selected play button graphic */
    private final String playSelected = "res/menu/PlayButtonSelected.png";
    /** Location of unselected instruction button graphic */
    private final String instructionsUnselected = "res/menu/InstructionsButton.png";
    /** Location of selected instruction button graphic */
    private final String instructionsSelected = "res/menu/InstructionsButtonSelected.png";
    /** Location of selected quit button graphic */
    private final String quitSelected = "res/menu/QuitButton.png";
    /** Location of unselected play button graphic */
    private final String quitUnselected = "res/menu/QuitButtonSelected.png";
    /** Location of background graphic */
    private final String bgPath = "res/menu/MenuBG.png";
    /** Main Menu */
    private Menu mainMenu;
    /** Starting x-position of menu */
    private int startingX;
    /** Starting y-position of menu */
    private int startingY;
    /** State Id of menu */
    private int stateID;
    /** Space between menu items */
    private int spaceBetweenItems;
    /** Background graphic */
    private Image bg;
    /** Unselected play button graphic */
    private Image playUs;
    /** Selected play button graphic */
    private Image playS;
    /** Unselected instruction button graphic */
    private Image instructionsUs;
    /** Selected instruction button graphic */
    private Image instructionsS;
    /** Unselected quit button graphic */
    private Image quitUs;
    /** Selected quit button graphic */
    private Image quitS;
    /** GUI context of menu state */
    private GUIContext guiContext;


    /**
     * Initializes Menu state
     *
     * @param stateID           The ID of the state
     * @param startingX         The x position of the first button
     * @param startingY         The y position of the first button
     * @param spaceBetweenItems The space between the buttons
     */
    public MenuState(int stateID, int startingX, int startingY, int spaceBetweenItems) {
        super();
        this.stateID = stateID;
        this.startingX = startingX;
        this.startingY = startingY;
        this.spaceBetweenItems = spaceBetweenItems;
    }

    /**
     * Tries to load images on Menu
     *
     * @param gc  The game container that handles the game loop, fps recording and managing the input system
     * @param sbg The current State Based Game this button is a part of
     */
    private void initMenu(GameContainer gc, StateBasedGame sbg) {
        mainMenu = new Menu(startingX, startingY, spaceBetweenItems);

        // create images for each button
        try {
            playUs = new Image(playUnselected);
            playS = new Image(playSelected);
            instructionsUs = new Image(instructionsUnselected);
            instructionsS = new Image(instructionsSelected);
            quitUs = new Image(quitUnselected);
            quitS = new Image(quitSelected);
        } catch (SlickException ex) {
            ex.printStackTrace();
            return;
        }
        AnimatedButton play = new AnimatedButton(gc, sbg, playUs, playS, startingX, startingY, 1, sbg.getCurrentStateID());  //should 1 be PLAY_STATE_ID?

        play.add(new ButtonAction() {
            public void perform() {
                /*currentState = STATES.PLAY;
                sbg.enterState(GauchoRunner.PLAY_STATE_ID);*/
            }
        }
        );

        AnimatedButton instructions = new AnimatedButton(gc, sbg, instructionsUs, instructionsS, startingX, startingY + spaceBetweenItems, 2, sbg.getCurrentStateID());

        instructions.add(new ButtonAction() {
            public void perform() {

            }
        }

        );

        AnimatedButton quit = new AnimatedButton(gc, sbg, quitUs, quitS, startingX, startingY + 2 * spaceBetweenItems, 3, sbg.getCurrentStateID());

        quit.add(new ButtonAction() {
            public void perform() {
                //gc.exit();
            }
        }
        );

        mainMenu.addItem(play);
        mainMenu.addItem(instructions);
        mainMenu.addItem(quit);
    }

    /**
     * Gets state ID of menu
     *
     * @return The state id of the current state
     */
    public int getID() {
        return this.stateID;
    }

    /**
     * Initializes Menu background and buttons
     *
     * @param gc  The game container that handles the game loop, fps recording and managing the input system
     * @param sbg The current State Based Game
     * @throws SlickException
     */
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        try {

            bg = new Image(bgPath);
            initMenu(gc, sbg);
        } catch (SlickException ex) {
            ex.printStackTrace();
            return;
        }
    }

    /**
     * Draws Menu background and buttons
     *
     * @param gc  The game container that handles the game loop, fps recording and managing the input system
     * @param sbg The current State Based Game
     * @param g   The graphics context to draw images on the screen
     */
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
        if (sbg.getCurrentStateID() == this.stateID) {
            g.drawImage(bg, 0, 0);
            mainMenu.render(gc, g);
        }
    }

    /**
     * Updates the menu state
     *
     * @param gc    The game container that handles the game loop, fps recording and managing the input system
     * @param sbg   The current State Based Game
     * @param delta The time in milliseconds
     */
    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
    }
}

