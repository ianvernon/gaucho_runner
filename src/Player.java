/**
 * Created with IntelliJ IDEA.
 * User: ianvernon
 * Date: 11/4/13
 * Time: 10:57 PM
 * To change this template use File | Settings | File Templates.
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import java.util.ArrayList;


public class Player extends CollidableInteractiveEntity {

    private int lives;
    private ArrayList<Powerup> powerups;

    public Player(String name, Image image, Vector2f position, Shape collisionShape)
    {
        super(name, image, position, collisionShape);
        this.lives = 3;
        this.powerups = new ArrayList<Powerup>();
    }
    public void kill()
    {
        this.lives = -1;
        powerups.clear();
    }
    public boolean isAlive()
    {
        return (this.lives >= 0);
    }
}
