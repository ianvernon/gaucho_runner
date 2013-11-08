import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A class that implements positioning, rendering, and game logic updating
 */
public class InteractiveEntity implements Entity {
    /** Name of entity */
    protected String name;
    /** Graphic for entity */
    protected Image image;
    /** Position of entity */
    protected Vector2f position;

    /**
     * Initializes the name, graphic, and position of entity
     * @param name
     * @param image
     * @param position
     */
    public InteractiveEntity(String name, Image image, Vector2f position) {
        this.name = name;
        this.image = image;
        this.position = position;
    }

    /**
     * Gets name of entity
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Gets position of entity
     * @return
     */
    public Vector2f getPosition() {
        return position;
    }

    /**
     * Sets position of entity
     * @param position
     */
    public void setPosition(Vector2f position) {
        this.position = position;
    }

    /**
     * Draws entity
     * @param graphics
     */
    public void render(Graphics graphics) {
        image.draw(position.x, position.y);
    }

    /**
     * Updates location of entity
     * @param gc
     * @param sbg
     * @param delta
     */
    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
        // implement later
        return;
    }
}
