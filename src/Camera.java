import org.newdawn.slick.GameContainer;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Camera {
    private boolean init = false;

    private boolean focusView = false;
    private float focusX, focusY;

    private float offsetX, offsetY;
    private float scaleX, scaleY;
    private float rScaleX, rScaleY;

    public Camera(){
        scaleX = 1.0f;
        scaleY = 1.0f;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        if (init) return;
        init = true;
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        rScaleX = (1 / scaleX);
        rScaleY = (1 / scaleY);

        offsetX = offsetX + 4;


    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.translate(offsetX, offsetY);
        g.scale(scaleX, scaleY);

    }

    public void renderFinish(GameContainer gc, StateBasedGame sbg, Graphics g){
        g.resetTransform();
        g.setWorldClip(0, 0, 800, 600);
    }

}
