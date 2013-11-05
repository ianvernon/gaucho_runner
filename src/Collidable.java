/**
 * Created with IntelliJ IDEA.
 * User: ianvernon
 * Date: 11/4/13
 * Time: 10:31 PM
 * To change this template use File | Settings | File Templates.
 */

import org.newdawn.slick.geom.Shape;

public interface Collidable {
    Shape getNormalCollisionShape();
    Shape getCollisionShape();
    boolean isCollidingWith(Collidable collidable);
}
