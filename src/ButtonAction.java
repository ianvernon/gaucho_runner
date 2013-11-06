import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created with IntelliJ IDEA.
 * User: ianvernon
 * Date: 11/5/13
 * Time: 7:59 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ButtonAction {
    public void perform(GameContainer gc, StateBasedGame sbg);
}
