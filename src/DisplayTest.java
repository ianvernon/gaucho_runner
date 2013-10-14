import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class DisplayTest {

	/** time at last frame */
	long lastFrame;
	/** frames per second */
	int fps;
	/** last fps time */
	long lastFPS;

	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.setTitle("Gaucho Runner");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		while (!Display.isCloseRequested()) {
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}

	public static void main(String[] argv) {
		DisplayTest displayExample = new DisplayTest();
		displayExample.start();
	}
	public void getTime()
	{
		return Sys.getTime() * 1000 / Sys.getTimeResolution();
	}

	public void updateFPS()
	{
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}
}