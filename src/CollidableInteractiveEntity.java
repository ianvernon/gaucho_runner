import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;

/** A class that renders images and runs collision detection algorithm */
public class CollidableInteractiveEntity extends InteractiveEntity implements Collidable {
    /** The shape of the given object */
    protected Shape collisionShape;
    protected int speed;

    /**
     * Constructor for a collidable entity
     *
     * @param name           The name of the new entity
     * @param image          The image to be drawn for the entity
     * @param position       The starting position of the entity
     * @param collisionShape The hit box of the entity
     */
    public CollidableInteractiveEntity(String name, Image image, Vector2f position, Shape collisionShape, int speed) {
        super(name, image, position);
        this.collisionShape = collisionShape;
        this.speed = speed;
    }

    /**
     * Returns The current collision shape of this object
     *
     * @return The collision normal shape
     */
    public Shape getNormalCollisionShape() {
        return collisionShape;
    }

    /**
     * Returns The collision shape of this object moved to its actual position
     *
     * @return The collision shape
     */
    public Shape getCollisionShape() {
        return collisionShape.transform(
                Transform.createTranslateTransform(position.x, position.y));
    }

    /**
     * Gets the speed of the entity
     * @return speed of the entity
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of the entity
     * @param speed The speed that is going to be set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Draws shape
     *
     * @param graphics The graphics context to draw images on the screen
     */
    public void render(Graphics graphics) {
        image.draw(position.x, position.y);
    }

    /**
     * Returns true if the collision shape of this object intersects
     * with the collision shape of the given object
     *
     * @param collidable The entity to see if it is colliding with
     * @return The collision shape
     */
    public boolean isCollidingWith(Collidable collidable) {
        return collidable.getCollisionShape().intersects(
                this.getCollisionShape());
    }
}
