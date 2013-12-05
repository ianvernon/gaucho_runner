import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

/** A class that implements positioning, rendering, and game logic updating */
public class InteractiveEntity implements Entity {
    /** Name of entity */
    protected String name;
    /** Graphic for entity */
    protected Image image;
    /** Position of entity */
    protected Vector2f position;

    /**
     * Initializes the name, graphic, and position of entity
     *
     * @param name     The name to be used with the entity
     * @param image    The image to be used with the entity
     * @param position The position associated with the entity
     */
    public InteractiveEntity(String name, Image image, Vector2f position) {
        this.name = name;
        this.image = image;
        this.position = position;
    }

    /**
     * Gets name of entity
     *
     * @return The name of an entity
     */
    public String getName() {
        return name;
    }

    /**
     * Gets position of entity
     *
     * @return The position of an entity
     */
    public Vector2f getPosition() {
        return position;
    }

    /**
     * Sets position of entity
     *
     * @param position The position to be set for the entity
     */
    public void setPosition(Vector2f position) {
        this.position = position;
    }

    /**
     * Draws entity
     *
     * @param graphics The graphics context to draw images on the screen
     */
    public void render(Graphics graphics) {
        image.draw(position.x, position.y);
    }

    /**
     * Updates location of entity
     *
     * @param gc    The game container that handles the game loop, fps recording and managing the input system
     * @param sbg   The current State Based Game
     * @param delta The time in milliseconds
     */
    public void update(GameContainer gc, StateBasedGame sbg, int delta) {

    }
}
