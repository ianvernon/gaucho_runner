import org.newdawn.slick.GameContainer;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ianvernon
 * Date: 11/5/13
 * Time: 7:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnimatedButton extends MouseOverArea {
    private boolean activated = false;
    private boolean lastMouseOver = false;
    private final Image normalImage;
    private final Image mouseOverImage;
    private int stateID;
    private StateBasedGame sbg;
    private final List<ButtonAction> actions = new ArrayList<ButtonAction>();
    private GameContainer gc;

    public AnimatedButton(GameContainer gameContainer,GUIContext guiContext, StateBasedGame sbg, Image normalImage,Image mouseOverImage, int x, int y,
                         int stateID)
    {
        super(guiContext,normalImage, x, y);
        super.setMouseOverImage(mouseOverImage);
        super.setMouseDownImage(mouseOverImage);
        this.sbg = sbg;
        this.stateID = stateID;
        this.normalImage = normalImage;
        this.mouseOverImage = mouseOverImage;
        this.gc = gameContainer;

    }

    public void mouseMoved(int oldx, int oldy, int newx, int newy)
    {
        if (sbg.getCurrentStateID() == stateID)
        {
            if (isMouseOver() && !lastMouseOver && !isActivated())
            {

                lastMouseOver = true;
            }
            else if (!isMouseOver())
            {
                lastMouseOver = false;
            }
        }
        super.mouseMoved(oldx, oldy, newx, newy);
    }
    public boolean isActivated() {
        return activated;
    }

    protected void setActivated(boolean b) {
        activated = b;
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        if (isMouseOver() && sbg.getCurrentStateID() == stateID)
        {
            activated = !activated;
            for(ButtonAction action: actions)
            {
                action.perform(gc, sbg);
            }
        }
        super.mouseClicked(button, x, y, clickCount);
    }

    public void render(GUIContext gc, Graphics g) {
        if (activated) {
            g.drawImage(normalImage, this.getX(), this.getY());
            super.render(gc, g);
        } else {
            g.drawImage(mouseOverImage, this.getX(), this.getY());
            super.render(gc, g);
        }
    }

    public void add(ButtonAction action)
    {
        actions.add(action);
    }

}
