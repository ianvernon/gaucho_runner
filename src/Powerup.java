import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;
/**
 * Created with IntelliJ IDEA.
 * User: ianvernon
 * Date: 11/4/13
 * Time: 11:09 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Powerup extends CollidableInteractiveEntity {


    public Powerup(String name, Image image, Vector2f position, Shape collisionShape)
    {
         super(name, image, position, collisionShape);
    }
    public abstract void utilize();

}
