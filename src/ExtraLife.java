import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 * Created with IntelliJ IDEA.
 * User: ianvernon
 * Date: 11/19/13
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class ExtraLife extends Powerup {

    public ExtraLife(String name, Image image, Vector2f position, Shape collisionShape, int speed, boolean isPickedUp) {
        super(name, image, position, collisionShape, speed, isPickedUp);
    }
    public void utilize(Player p)
    {
        p.addLife();
        isPickedUp = true;
    }
    public boolean isPickedUp()
    {
        return isPickedUp;
    }
}
