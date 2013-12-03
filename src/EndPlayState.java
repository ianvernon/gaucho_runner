import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.GameContainer;

/**
 * The class that displays final screen after player finishes or dies
 */
public class EndPlayState extends BasicGameState {
    private int score;
    private int stateID;
    private boolean lost;

    EndPlayState(int stateID, int score, boolean lost){
        super();
        this.stateID = stateID;
        this.score = score;
        this.lost = lost;
    }


    @Override
    public void init(GameContainer c, StateBasedGame sbg) throws SlickException {


    }

    @Override
    public void render(GameContainer c, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("Score: " + score, 650, 550);
    }

    @Override
    public void update(GameContainer c, StateBasedGame game, int delta) throws SlickException {
        // TODO Auto-generated method stub

    }

    @Override
    public int getID() {
        return this.stateID;
    }

}
