import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

/**
 * A class that sets up the menu by declaring and initializing
 * several animated button with which the player uses to enter
 * different game states
 */
public class Menu {
    /** An array list of animated buttons */
    private ArrayList<AnimatedButton> items;
    /** Starting x-position */
    private int startingX;
    /** Starting y-position */
    private int startingY;
    /** Space between animated buttons */
    private int spaceBetweenItems;

    /**
     * Initializes Menu
     *
     * @param startingX
     * @param startingY
     * @param spaceBetweenItems
     */
    public Menu(int startingX, int startingY, int spaceBetweenItems) {
        this.items = new ArrayList<AnimatedButton>();
        this.startingX = startingX;
        this.startingY = startingY;
        this.spaceBetweenItems = spaceBetweenItems;
    }

    /**
     * Adds animated button
     *
     * @param gc             The game container that handles the game loop, fps recording and managing the input system
     * @param sbg            The current State Based Game
     * @param normalImage    The image that is displayed when the mouse is not over the button
     * @param mouseOverImage The image that is displayed when the mouse is over the button
     * @param x              The x position of the button location
     * @param y              The y position of the button location
     * @param stateID        The ID of the state that this button goes to when clicked on
     */
    public void addItem(GameContainer gc, StateBasedGame sbg, Image normalImage, Image mouseOverImage, int x, int y,
                        int stateID) {
        // create new MouseOverArea based on input
        items.add(new AnimatedButton(gc, sbg, normalImage, mouseOverImage, x, y, stateID, sbg.getCurrentStateID()));
    }

    /**
     * Adds animated button
     *
     * @param button The button to be added to the list
     */
    public void addItem(AnimatedButton button) {
        items.add(button);
    }

    /**
     * Draws animated buttons
     *
     * @param gc The game container that handles the game loop, fps recording and managing the input system
     * @param g  The graphics context to draw images on the screen
     */
    public void render(GUIContext gc, Graphics g) {
        for (AnimatedButton button : items) {
            button.render(gc, g);
        }
    }

    /**
     * Returns number of animated buttons
     *
     * @return The size of the item list
     */
    public int listSize() {
        return this.items.size();
    }

    /** Time to revive the buttons */
    public void enter() {
    }

    /** Time to kill the buttons */
    public void leave() {
    }

}
