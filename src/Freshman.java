import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 * Created with IntelliJ IDEA.
 * User: ianvernon
 * Date: 11/17/13
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Freshman extends Enemy {
    public Freshman(String name, Image image, Vector2f position, Shape collisionShape, int speed)
    {
        super(name, image, position, collisionShape, speed);
    }
}
