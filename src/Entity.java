import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Graphics;

/**
 * Created with IntelliJ IDEA.
 * User: ianvernon
 * Date: 11/4/13
 * Time: 10:28 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Entity {
    String getName();
    void setPosition(Vector2f pos);
    Vector2f getPosition();
    void render(Graphics g);
    void update(GameContainer g, StateBasedGame sbg, int delta);

}
