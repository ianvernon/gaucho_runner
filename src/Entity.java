import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

/**
 * An interface that provides positioning, rendering, and game logic updating
 */
public interface Entity {
    String getName();

    void setPosition(Vector2f pos);

    Vector2f getPosition();

    void render(Graphics g);

    void update(GameContainer g, StateBasedGame sbg, int delta);

}
