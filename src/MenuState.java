import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.BasicGameState;

/**
 * Created with IntelliJ IDEA.
 * User: ianvernon
 * Date: 11/5/13
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuState extends BasicGameState {
    private Menu mainMenu;
    private int startingX;
    private int startingY;
    private int stateID;
    private int spaceBetweenItems;
    private final String playUnselected = "res/menu/PlayButton.png";
    private final String playSelected  = "res/menu/PlayButtonSelected.png";
    private final String instructionsUnselected = "res/menu/InstructionsButton.png";
    private final String instructionsSelected = "res/menu/InstructionsButtonSelected.png";
    private final String quitSelected = "res/menu/QuitButton.png";
    private final String quitUnselected = "res/menu/QuitButtonSelected.png";
    private final String bgPath = "res/menu/MenuBG.png";
    private Image bg, playUs, playS, instructionsUs, instructionsS, quitUs, quitS;
    private enum STATES
    {
        PLAY, INSTRUCTIONS
    }
    private STATES currentState;
    private GUIContext guiContext;

    public MenuState(int stateID, int startingX, int startingY, int spaceBetweenItems)
    {
        super();
        this.stateID = stateID;
        this.startingX = startingX;
        this.startingY = startingY;
        this.spaceBetweenItems = spaceBetweenItems;
        this.guiContext = guiContext;

    }

    private void initMenu(GameContainer gc,
                          StateBasedGame sbg)
    {
        mainMenu = new Menu(startingX, startingY, spaceBetweenItems);

        // create images for each button
        try
        {
            playUs = new Image(playUnselected);
            playS = new Image(playSelected);
            instructionsUs = new Image(instructionsUnselected);
            instructionsS = new Image(instructionsSelected);
            quitUs = new Image(quitUnselected);
            quitS = new Image(quitSelected);
        }
        catch(SlickException ex)
        {
            ex.printStackTrace();
            return;
        }
        AnimatedButton play = new AnimatedButton(gc, sbg, playUs, playS, startingX, startingY, 0);

        play.add(new ButtonAction()
        {
            public void perform()
            {
                /*currentState = STATES.PLAY;
                sbg.enterState(GauchoRunner.PLAYSTATEID);*/
            }
        }
        );

        AnimatedButton instructions = new AnimatedButton(gc, sbg, instructionsUs, instructionsS, startingX, startingY + spaceBetweenItems, 1);

        play.add(new ButtonAction()
        {
            public void perform()
            {

            }
        }

        );

        AnimatedButton quit = new AnimatedButton(gc, sbg, quitUs, quitS, startingX, startingY + 2*spaceBetweenItems, 2);

        quit.add(new ButtonAction()
        {
            public void perform()
            {
                //gc.exit();
            }
        }
        );

        mainMenu.addItem(play);
        mainMenu.addItem(instructions);
        mainMenu.addItem(quit);
    }
        public int getID()
    {
        return this.stateID;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        try
        {

            bg = new Image(bgPath);
            initMenu(gc, sbg);
        }
        catch(SlickException ex)
        {
            ex.printStackTrace();
            return;
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
    {
        g.drawImage(bg, 0, 0);
        mainMenu.render(gc, g);
    }
    public void update(GameContainer gc, StateBasedGame sbg, int id)
    {
       /* switch(currentState)
        {
            case PLAY:

                break;
            case INSTRUCTIONS:
                break;
        } */
    }
}