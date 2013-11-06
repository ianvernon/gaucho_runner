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
    private ArrayList<AnimatedButton> items;
    private int startingX;
    private int startingY;
    private int spaceBetweenItems;

    public Menu(int startingX,int startingY, int spaceBetweenItems)
    {
        this.items = new ArrayList<AnimatedButton>();
        this.startingX = startingX;
        this.startingY = startingY;
        this.spaceBetweenItems = spaceBetweenItems;
    }

    public void addItem(GameContainer gc, GUIContext guiContext, StateBasedGame sbg, Image normalImage, Image mouseOverImage, int x, int y,
                        int stateID)
    {
        // create new MouseOverArea based on input
        // get Y of last item in the list - so we can set the Y position of the next menu item
        // in relation to it
        int itemY;
        if(items.size() == 0)
        {
            itemY = startingY;
        }
        else
        {
            itemY = items.get(items.size()-1).getY();
        }
        items.add(new AnimatedButton(gc, guiContext, sbg, normalImage, mouseOverImage, x, y, stateID));
    }

    public void addItem(AnimatedButton button)
    {
        items.add(button);
    }

    public void render(GUIContext gc, Graphics g)
    {
        for(AnimatedButton button : items)
        {
            button.render(gc, g);
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i)
    {
        //TODO: see if this is needed
    }

    public int listSize()
    {
        return this.items.size();
    }

}
