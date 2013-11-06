import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;

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

    public MenuState(int stateID, int startingX, int startingY, int spaceBetweenItems)
    {
        super();
        this.stateID = stateID;
        this.startingX = startingX;
        this.startingY = startingY;
        this.spaceBetweenItems = spaceBetweenItems;

    }

    private void initMenu(GameContainer gc)
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
        //ComponentListener playListener = new ComponentListener()
        // TODO READ UP ON ACTIONLISTENERS
         /*
            @Override
            public void componentActivated(AbstractComponent abstractComponent) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
           */
        mainMenu.addItem(gc, "Play", playUs, playS);
        mainMenu.addItem(gc, "Instructions", instructionsUs, instructionsS);
        mainMenu.addItem(gc, "Quit", quitUs, quitS);
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
            initMenu(gc);
        }
        catch(SlickException ex)
        {
            ex.printStackTrace();
            return;
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
    {
        // put background image on screen
         g.drawImage(bg,0,0);
         g.drawImage(playUs, startingX, startingY);
         g.drawImage(instructionsUs, startingX, startingY + 131);
         g.drawImage(quitUs, startingX, startingY + 2*131);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta)
    {
        // what to do here
    }
}