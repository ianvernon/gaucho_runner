import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that renders buttons and listens for mouse activity.
 */
public class AnimatedButton extends MouseOverArea {
    /** Checks to see if button is activated*/
    private boolean activated = false;
    /** Checks to see if new input is available*/
    private boolean lastMouseOver = false;
    /** The image that is displayed when no mouse is over the button*/
    private final Image normalImage;
    /** The image that is displayed when the mouse is over the button*/
    private final Image mouseOverImage;
    /** The id of the current state*/
    private int stateID;
    /** Used to enter game states*/
    private StateBasedGame sbg;
    /** An array list that contains actions for the buttons*/
    private final List<ButtonAction> actions = new ArrayList<ButtonAction>();
    /** Should we restart on entering the button's state ID */
    private boolean restart = false;
    private int assignedStateID;
    // assignedStateID assigns the button to be active in a specific state to solve button problem

    /** The constructor for the Animated Button class
     * @param guiContext the context in which GUI components are created / rendered (info about system - mouse cursor,
     *                   groups system properties that affect how program is run in terms of graphics / interaction w/ user)
     * @param sbg the current State Based Game this button is a part of
     * @param normalImage the image that is displayed at the start when mouse is not over button
     * @param mouseOverImage the image that is displayed when mouse is over this button
     * @param x position of this button on the screen
     * @param y position of this button on the screen
     * @param stateID the ID of the state that this button goes to when clicked on
     * @param assignedStateID the ID of the state that this button is active in. implemented due to fact that button
     *                          areas are still able to be clicked / activated even after changing state
     */
    public AnimatedButton(GUIContext guiContext, StateBasedGame sbg, Image normalImage, Image mouseOverImage, int x, int y, int stateID, int assignedStateID) {
        super(guiContext, normalImage, x, y);
        super.setMouseOverImage(mouseOverImage);
        super.setMouseDownImage(mouseOverImage);
        this.sbg = sbg;
        this.stateID = stateID;
        this.normalImage = normalImage;
        this.mouseOverImage = mouseOverImage;
        this.assignedStateID = assignedStateID;

    }

    /** The constructor for the Animated Button class
     * @param guiContext
     * @param sbg
     * @param normalImage
     * @param mouseOverImage
     * @param x
     * @param y
     * @param restart should we restart the PlayState?
     */
    public AnimatedButton(GUIContext guiContext, StateBasedGame sbg, Image normalImage, Image mouseOverImage, int x, int y, int stateID, boolean restart) {
        super(guiContext, normalImage, x, y);
        super.setMouseOverImage(mouseOverImage);
        super.setMouseDownImage(mouseOverImage);
        this.sbg = sbg;
        this.stateID = stateID;
        this.normalImage = normalImage;
        this.mouseOverImage = mouseOverImage;
        this.restart = restart;

    }

    /** Checks to see if the mouse has moved
     * @param oldx The old horizontal coordinate of the mouse
     * @param oldy The old vertical coordinate of the mouse
     * @param newx The new horizontal coordinate of the mouse
     * @param newy The new vertical coordinate of the mouse
     */
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        if (sbg.getCurrentStateID() == stateID) {
            if (isMouseOver() && !lastMouseOver && !isActivated()) {

                lastMouseOver = true;
            } else if (!isMouseOver()) {
                lastMouseOver = false;
            }
        }
        super.mouseMoved(oldx, oldy, newx, newy);
    }

    /** tells system whether button is activated
     *  @return activated whether button is activated or not */
    public boolean isActivated() {
        return activated;
    }

    /** sets this button to be activated or inactivated
     * @param b The true / false value whether button is activated */
    protected void setActivated(boolean b) {
        activated = b;
    }


    /** Checks to see if mouse has been clicked
     * @param button The index of the button (starting at 0)
     * @param x The x position of the mouse when the button was pressed
     * @param y The y position of the mouse when the button was pressed
     * @param clickCount The number of times the button was clicked
     * */
    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        if (isMouseOver()) {
            if (restart) {
                PlayState ps = (PlayState) sbg.getState(1);
                ps.restart();
            }
            if(sbg.getCurrentStateID() == assignedStateID)
            //{
               sbg.enterState(stateID, new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black, 1000));
            //}


        }
    }

    /**
     * Renders the button image
     * @param gc The context in which GUI components are created / rendered (info about system - mouse cursor,
     *                   groups system properties that affect how program is run in terms of graphics / interaction w/ user)
     * @param g  The graphics context to draw images on the screen
     */
    public void render(GUIContext gc, Graphics g) {
        if (activated) {
            g.drawImage(normalImage, this.getX(), this.getY());
            super.render(gc, g);
        } else {
            g.drawImage(mouseOverImage, this.getX(), this.getY());
            super.render(gc, g);
        }
    }

    /**
     * Adds a button action to this button
     * @param action Sets this action (thing button does) to the list of actions the button can do
     */
    public void add(ButtonAction action) {
        actions.add(action);
    }

}
