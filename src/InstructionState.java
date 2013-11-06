import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created with IntelliJ IDEA.
 * User: James
 * Date: 11/5/13
 * Time: 10:36 PM
 *
 */
public class InstructionState extends BasicGameState {
    private Menu instructionsMenu;
    private int stateID;
    private int startingX = 50;
    private int startingY = 450;
    private int spaceBetweenItems = 131;
    private final String quitSelected = "res/menu/QuitButton.png";
    private final String quitUnselected = "res/menu/QuitButtonSelected.png";
    private Image backUs, backS;

    InstructionState(int stateID){
        super();
        this.stateID = stateID;
    }

    public void init(GameContainer gc, StateBasedGame sbg){
            initMenu(gc, sbg);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("Instructions", 100, 100);
        instructionsMenu.render(gc, g);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

    }

    @Override
    public int getID() {
        return stateID;
    }

    private void initMenu(GameContainer gc, StateBasedGame sbg)
    {
        instructionsMenu = new Menu(startingX, startingY, spaceBetweenItems);

        // create images for each button
        try{
            backUs = new Image(quitUnselected);
            backS = new Image(quitSelected);
        }catch(SlickException ex){
            ex.printStackTrace();
            return;
        }
        AnimatedButton play = new AnimatedButton(gc, sbg, backUs, backS, startingX, startingY, 0);

        play.add(new ButtonAction()
        {
            public void perform()
            {
                /*currentState = STATES.PLAY;
                sbg.enterState(GauchoRunner.PLAYSTATEID);*/
            }
        }
        );

        instructionsMenu.addItem(play);

    }
}
