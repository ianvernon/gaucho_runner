import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/** The enemy entity that sets up objects that will move across the screen */
public class Freshman extends Enemy {
    public Freshman(String name, Image image, Vector2f position, Shape collisionShape, int speed) {
        super(name, image, position, collisionShape, speed);
    }
}
