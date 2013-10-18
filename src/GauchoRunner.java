import org.lwjgl.LWJGLException;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.*;
import org.lwjgl.*;


public class GauchoRunner {
	public static void main(String[] argv) {
		MainMenu mainMenu = new MainMenu();
		mainMenu.start();
	}
/*
	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.setTitle("Gaucho Runner");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		Box box = new Box(300, 300);
		
		// Initialize OpenGL to use a mode to create a window of x & y dimensions
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,800, 800, 0, 1, -1);
		
		// change mode to viewing the window
		glMatrixMode(GL_MODELVIEW);

		while (!Display.isCloseRequested()) {

		    // clears the display 
		    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		    glColor3f(0.5f, 0.5f, 1.0f);
		    if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
			{
			    box.update(-5, 0);
			}
		    
		    if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
			{
			    box.update(0, 5);
			}
		    if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
			{
			    box.update(5, 0);
			}
		    if(Keyboard.isKeyDown(Keyboard.KEY_UP))
			{
			    box.update(0, -5);
			}
		    box.draw();
		    
		    Display.update();
			Display.sync(60);
		}		
		Display.destroy();
	}
    
private static class Box{
	public int x, y;
	
	public Box(int x, int y)
	{
	    this.x = x;
	    this.y = y;
	}

	public void update(int dx, int dy)
	{
	    x += dx;
	    y += dy;
	    checkBounds();
	}
	//checks to see if the box has hit the side
	public void checkBounds(){
		if (x < 0){
			x = 0;
		}
		else if (x > 800 - 50){
			x = 800 - 50;
		}
		if(y < 0){
			y = 0;
		}
		else if (y > 800 - 50){
			y = 800 - 50;
		}
	}
	
	public void draw(){
	    glBegin(GL_QUADS);
	    glVertex2f(x, y);
	    glVertex2f(x+50, y);
	    glVertex2f(x+50, y+50);
	    glVertex2f(x, y+50);
	    glEnd();
	}
}
*/    
}