import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A class that implements the state in which the Pause menu is first rendered
 */
public class PauseState extends BasicGameState {
    /** Pause Menu */
    private Menu pauseMenu;
    /** Starting x-position of menu */
    private int startingX;
    /** Starting y-position of menu */
    private int startingY;
    /** State Id of menu */
    private int stateID;
    /** Space between menu items */
    private int spaceBetweenItems;
    /** Location of unselected play button graphic */
    private final String playUnselected = "res/menu/PlayButton.png";
    /** Location of selected play button graphic */
    private final String playSelected = "res/menu/PlayButtonSelected.png";
    /** Location of unselected restart button graphic */
    private final String restartUnselected = "res/menu/RestartButton.png";
    /** Location of selected restart button graphic */
    private final String restartSelected = "res/menu/RestartButtonSelected.png";
    /** Location of selected quit button graphic */
    private final String quitSelected = "res/menu/QuitButton.png";
    /** Location of unselected play button graphic */
    private final String quitUnselected = "res/menu/QuitButtonSelected.png";
    /** Location of background graphic */
    private final String bgPath = "res/menu/MenuBG.png";
    /** Background graphic */
    private Image bg;
    /** Unselected play button graphic */
    private Image playUs;
    /** Selected play button graphic */
    private Image playS;
    /** Unselected restart button graphic */
    private Image restartUs;
    /** Selected restart button graphic */
    private Image restartS;
    /** Unselected quit button graphic */
    private Image quitUs;
    /** Selected quit button graphic */
    private Image quitS;
    /** GUI context of menu state */
    private GUIContext guiContext;
    public SoundManager soundManager;
    private PlayState play;

    /**
     * Initializes Menu state
     * @param stateID
     * @param startingX
     * @param startingY
     * @param spaceBetweenItems
     */
    public PauseState(int stateID, int startingX, int startingY, int spaceBetweenItems) {
        super();
        this.stateID = stateID;
        this.startingX = startingX;
        this.startingY = startingY;
        this.spaceBetweenItems = spaceBetweenItems;
        this.guiContext = guiContext;

    }

    /**
     * Initializes Menu state
     * @param stateID
     * @param startingX
     * @param startingY
     * @param spaceBetweenItems
     */
    public PauseState(int stateID, int startingX, int startingY, int spaceBetweenItems, PlayState ps) {
        super();
        this.stateID = stateID;
        this.startingX = startingX;
        this.startingY = startingY;
        this.spaceBetweenItems = spaceBetweenItems;
        this.guiContext = guiContext;
        this.play = ps;
    }

    /**
     * Tries to load images on Menu
     * @param gc
     * @param sbg
     */
    private void initMenu(GameContainer gc, StateBasedGame sbg) {
        pauseMenu = new Menu(startingX, startingY, spaceBetweenItems);

        // create images for each button
        try {
            playUs = new Image(playUnselected);
            playS = new Image(playSelected);
            restartUs = new Image(restartUnselected);
            restartS = new Image(restartSelected);
            quitUs = new Image(quitUnselected);
            quitS = new Image(quitSelected);
        } catch (SlickException ex) {
            ex.printStackTrace();
            return;
        }
        AnimatedButton play = new AnimatedButton(gc, sbg, playUs, playS, startingX, startingY, 1);  //should 1 be PLAY_STATE_ID?

        play.add(new ButtonAction() {
            public void perform() {
                /*currentState = STATES.PLAY;
                sbg.enterState(GauchoRunner.PLAY_STATE_ID);*/
            }
        });

        AnimatedButton restart = new AnimatedButton(gc, sbg, restartUs, restartS, startingX, startingY + spaceBetweenItems, 1, true);

        restart.add(new ButtonAction() {
            public void perform() {
                //play.restart();
            }
        });

        AnimatedButton quit = new AnimatedButton(gc, sbg, quitUs, quitS, startingX, startingY + 2 * spaceBetweenItems, 0);

        quit.add(new ButtonAction() {
            public void perform() {
                //gc.exit();
            }
        });

        pauseMenu.addItem(play);
        pauseMenu.addItem(restart);
        pauseMenu.addItem(quit);
    }

    /**
     * Gets state ID of menu
     * @return
     */
    public int getID() {
        return this.stateID;
    }

    /**
     * Initializes Menu background and buttons
     * @param gc
     * @param sbg
     * @throws SlickException
     */
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        try {

            bg = new Image(bgPath);
            initMenu(gc, sbg);
            //soundManager = new SoundManager();
            //soundManager.play();
        } catch (SlickException ex) {
            ex.printStackTrace();
            return;
        }
    }

    /**
     * Draws Menu background and buttons
     * @param gc
     * @param sbg
     * @param g
     */
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
        g.drawImage(bg, 0, 0);
        pauseMenu.render(gc, g);
    }

    /**
     * Updates the menu state
     * @param gc
     * @param sbg
     * @param id
     */
    public void update(GameContainer gc, StateBasedGame sbg, int id) {

    }
}
