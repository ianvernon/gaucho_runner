/**
 * Created with IntelliJ IDEA.
 * User: ianvernon
 * Date: 11/4/13
 * Time: 10:46 PM
 * To change this template use File | Settings | File Templates.
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;

public class CollidableInteractiveEntity extends InteractiveEntity implements Collidable {

    private Shape collisionShape;

    public CollidableInteractiveEntity(String name, Image image, Vector2f position, Shape collisionShape)
    {
        super(name, image, position);
        this.collisionShape = collisionShape;
    }
    public Shape getNormalCollisionShape()
    {
       return collisionShape;
    }

    public Shape getCollisionShape()
    {
        return collisionShape.transform(
                Transform.createTranslateTransform(position.x, position.y));
    }
    public void render(Graphics graphics) {
        image.draw(position.x, position.y);

        //TODO: figure out what this does
        /*if (Settings.debug) {
            graphics.draw(getCollisionShape());  */

    }
    public boolean isCollidingWith(Collidable collidable) {
        return collidable.getCollisionShape().intersects(
                this.getCollisionShape());
    }
}
