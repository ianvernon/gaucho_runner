import org.newdawn.slick.geom.Shape;

/**
 * An interface that collision properties for screen objects
 */
public interface Collidable {

    Shape getCollisionShape();

    boolean isCollidingWith(Collidable collidable);
}
