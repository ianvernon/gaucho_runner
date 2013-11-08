import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;

/**
 * A class that renders images and runs collision detection algorithm
 */
public class CollidableInteractiveEntity extends InteractiveEntity implements Collidable {
    /**
     * The shape of the given object
     */
    private Shape collisionShape;

    /**
     * Constructor for a collidable entity
     * @param name
     * @param image
     * @param position
     * @param collisionShape
     */
    public CollidableInteractiveEntity(String name, Image image, Vector2f position, Shape collisionShape) {
        super(name, image, position);
        this.collisionShape = collisionShape;
    }

    /**
     * Returns the current collision shape of this object
     * @return
     */
    public Shape getNormalCollisionShape() {
        return collisionShape;
    }

    /**
     * Returns the collision shape of this object moved to its actual position
     * @return
     */
    public Shape getCollisionShape() {
        return collisionShape.transform(
                Transform.createTranslateTransform(position.x, position.y));
    }

    /**
     * Draws shape
     * @param graphics
     */
    public void render(Graphics graphics) {
        // why doesn't this work!
        // MAYBE IT NEEDS TO BE OVERWRITTEN
        image.draw(position.x, position.y);

        //TODO: figure out what this does
        /*if (Settings.debug) {
            graphics.draw(getCollisionShape());  */

    }

    /**
     * Returns true if the collision shape of this object intersects
     * with the collision shape of the given object
     * @param collidable
     * @return
     */
    public boolean isCollidingWith(Collidable collidable) {
        return collidable.getCollisionShape().intersects(
                this.getCollisionShape());
    }
}
