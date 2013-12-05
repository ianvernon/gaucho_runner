import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/** The class that controls the extra lives. */
public class ExtraLife extends Powerup {
    /**
     * The constructor that sets up a power up
     *
     * @param name           The name of the extra life
     * @param image          The image to be displayed on the screen
     * @param position       The position of the power up
     * @param collisionShape The hit box for the power up
     * @param speed          The speed that the power up will be moving
     * @param isPickedUp     The boolean to see if the power up has been picked up
     */
    public ExtraLife(String name, Image image, Vector2f position, Shape collisionShape, int speed, boolean isPickedUp) {
        super(name, image, position, collisionShape, speed, isPickedUp);
    }

    /**
     * Adds a life and marks it as picked up
     *
     * @param p The current player entity
     */
    public void utilize(Player p) {
        p.addLife();
        isPickedUp = true;
    }
}
