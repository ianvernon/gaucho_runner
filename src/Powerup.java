import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 * A class that implements a screen object that gives advantageous conditions to the player when acquired in the game
 */
public abstract class Powerup extends CollidableInteractiveEntity {

    protected boolean isPickedUp;
    /**
     * Initializes powerup values
     * @param name name of powerup
     * @param image powerup image
     * @param position powerup position
     * @param collisionShape powerup shape for collision detection
     */
    public Powerup(String name, Image image, Vector2f position, Shape collisionShape, int speed, boolean isPickedUp) {
        super(name, image, position, collisionShape, speed);
        isPickedUp = false;
    }

    /**
     * Utilize function
     */
    public abstract void utilize(Player p);

}
