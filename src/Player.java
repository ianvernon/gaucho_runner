import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

import java.util.ArrayList;

/** A class that implements a user-controlled player. This class keeps track of lives and powerups obtained throughout the game */
public class Player extends CollidableInteractiveEntity {
    /** Current number of lives the player has */
    private int lives;
    /** An array list of powerups the player has obtained */
    private ArrayList<Powerup> powerups;

    /**
     * Initializes the player with three lives and zero power-ups
     *
     * @param name           The name of the player
     * @param image          The image to be used with the player
     * @param position       The current position of the player
     * @param collisionShape The hit box for the player
     */
    public Player(String name, Image image, Vector2f position, Shape collisionShape, int speed) {
        super(name, image, position, collisionShape, speed);
        this.lives = 3;
        this.powerups = new ArrayList<Powerup>();
    }

    /** Kills the player */
    public void kill() {
        this.lives = -1;
        powerups.clear();
    }

    /**
     * Checks if the player is alive
     *
     * @return True if there are still lives
     */
    public boolean isAlive() {
        return (this.lives >= 0);
    }

    /**
     * Adds a life to the player
     */
    public void addLife() {
        this.lives = lives + 1;
    }

}
