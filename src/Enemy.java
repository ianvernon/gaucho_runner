import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/** A class that defines enemy objects and NPCs that the player must avoid */
public abstract class Enemy extends CollidableInteractiveEntity {
    public Enemy(String name, Image image, Vector2f position, Shape collisionShape, int speed) {
        super(name, image, position, collisionShape, speed);
    }

}
