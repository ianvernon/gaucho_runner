import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The class that displays final screen after player finishes or dies
 */
public class EndPlayState extends BasicGameState {
    private int score;
    private int stateID;
    private boolean lose;
    private Image bg;

    EndPlayState(int stateID, int score, boolean lose){
        super();
        this.stateID = stateID;
        this.score = score;
        this.lose = lose;
    }


    @Override
    public void init(GameContainer c, StateBasedGame sbg) throws SlickException {

    }

    @Override
    public void render(GameContainer c, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("Score: " + score, 350, 400);
        g.drawImage(bg, 0, 0);

    }

    @Override
    public void update(GameContainer c, StateBasedGame game, int delta) throws SlickException {
        // TODO Auto-generated method stub

    }

    @Override
    public int getID() {
        return this.stateID;
    }

    public void enter(GameContainer gc, StateBasedGame sbg) {
        System.out.println("Entering EndPlayState");
        try{
            if(lose){
                bg = new Image("res/menu/Lose.png");
            }
            else{
                bg = new Image("res/menu/Win.png");
            }

        }catch(SlickException e){
            e.printStackTrace();
        }
    }
}
