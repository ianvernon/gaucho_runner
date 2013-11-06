import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ianvernon
 * Date: 11/5/13
 * Time: 11:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class Menu {
    private ArrayList<MouseOverArea> items;
    private int startingX;
    private int startingY;
    private int spaceBetweenItems;

    public Menu(int startingX,int startingY, int spaceBetweenItems)
    {
        this.items = new ArrayList<MouseOverArea>();
        this.startingX = startingX;
        this.startingY = startingY;
        this.spaceBetweenItems = spaceBetweenItems;
    }

    public void addItem(GUIContext container, String name, Image normalImage, Image mouseOverImage, ComponentListener listener)
    {
        // create new MouseOverArea based on input
        // get Y of last item in the list - so we can set the Y position of the next menu item
        // in relation to it
        int finalItemY;
        if(items.size() == 0)
        {
            finalItemY = startingY;
        }
        else
        {
            finalItemY = items.get(items.size()-1).getY();
        }
        items.add(new MouseOverArea(container, normalImage, startingX, finalItemY + spaceBetweenItems/*, listener*/));
        // set mouseOver image to be image that appears when button mousedOver for button just added in list
        items.get(items.size()-1).setMouseOverImage(mouseOverImage);
    }

    public void render(GUIContext gc, Graphics g)
    {
        for(MouseOverArea area : items)
        {
            area.render(gc, g);
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i)
    {
       /* for(MouseOverArea area : items)
        {
            if(area.isMouseOver())
            {

            }
        }   */
    }
        /*
        Input input = gc.getInput();

        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();
        boolean mouseClicked = input.isMousePressed(Input.MOUSE_LEFT_BUTTON);

        boolean downKeyPressed = input.isKeyPressed(Input.KEY_DOWN);
        boolean upKeyPressed = input.isKeyPressed(Input.KEY_UP);
        boolean enterKeyPressed = input.isKeyPressed(Input.KEY_ENTER);

        for (int j = 0; j < items.size(); j++)
        {
            AbstractMenuItem menuItem = items.get(j);
            // only apply mouse input if mouse moved or was clicked
            // (otherwise keyboard input does not work)
            if ((mouseX != oldMouseX && mouseY != oldMouseY) || mouseClicked) {
                menuItem.applyMouseInput(mouseX, mouseY,
                        mouseClicked, i, gc, sbg);
            }

            // keyboard input:
            if (downKeyPressed && menuItem.isSelected()) {
                menuItem.unSelect();
                selectNext(j);
                return;

            } else if (upKeyPressed && menuItem.isSelected()) {
                menuItem.unSelect();
                selectPrevious(j);
                return;

            } else if (enterKeyPressed && menuItem.isSelected()) {
                menuItem.execute(gc, sbg);

            }
        }
    }         */



}
