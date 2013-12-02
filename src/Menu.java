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
     * @param gc
     * @param sbg
     * @param normalImage
     * @param mouseOverImage
     * @param x
     * @param y
     * @param stateID
     */
    public void addItem(GameContainer gc, StateBasedGame sbg, Image normalImage, Image mouseOverImage, int x, int y,
                        int stateID) {
        // create new MouseOverArea based on input
        // get Y of last item in the list - so we can set the Y position of the next menu item
        // in relation to it
        /*int itemY;
        if (items.size() == 0) {
            itemY = startingY;
        } else {
            itemY = items.get(items.size() - 1).getY();
        }*/
        items.add(new AnimatedButton(gc, sbg, normalImage, mouseOverImage, x, y, stateID));
    }

    /**
     * Adds animated button
     * @param button
     */
    public void addItem(AnimatedButton button) {
        items.add(button);
    }

    /**
     * Draws animated buttons
     * @param gc
     * @param g
     */
    public void render(GUIContext gc, Graphics g) {
        for (AnimatedButton button : items) {
            button.render(gc, g);
        }
    }

    /**
     * Updates buttons
     * @param gc
     * @param sbg
     * @param i
     */
    public void update(GameContainer gc, StateBasedGame sbg, int i) {
        //TODO: see if this is needed
    }

    /**
     * Returns number of animated buttons
     * @return
     */
    public int listSize() {
        return this.items.size();
    }

    /**
     * Time to revive the buttons
     */
    public void enter() {
        for (AnimatedButton b : items){
            b.setAlive(true);
        }
    }

    /**
     * Time to kill the buttons
     */
    public void leave() {
        for (AnimatedButton b : items){
            b.setAlive(false);
        }
    }
}
