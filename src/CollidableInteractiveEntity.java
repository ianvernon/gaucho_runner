import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A class that renders images and runs collision detection algorithm
 */
public class CollidableInteractiveEntity extends InteractiveEntity implements Collidable {
    /**
     * The shape of the given object
     */
    protected Shape collisionShape;
    protected int speed;

    /**
     * Constructor for a collidable entity
     * @param name
     * @param image
     * @param position
     * @param collisionShape
     */
    public CollidableInteractiveEntity(String name, Image image, Vector2f position, Shape collisionShape, int speed) {
        super(name, image, position);
        this.collisionShape = collisionShape;
        this.speed = speed;
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

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    /**
     * Draws shape
     * @param graphics
     */
    public void render(Graphics graphics) {
        // why doesn't this work!
        // MAYBE IT NEEDS TO BE OVERWRITTEN
        image.draw(position.x, position.y);
        //collisionShape.draw(collisionShape.getX(), collisionShape.getY());

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
    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
       // System.out.println("update for CollidableInteractiveEntity being called");
       //System.out.println(name + "collisionShape x: " + collisionShape.getX());
       //System.out.println(name + "collisionShape y: " + collisionShape.getY());
       // System.out.println(name + "position x: " + position.getX());
       // System.out.println(name + "position y: " + position.getY());
       // System.out.println();
        //collisionShape.setX(position.getX());
        //collisionShape.setY(position.getY());
        return;
    }
}
