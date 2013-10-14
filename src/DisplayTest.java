import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.Sys;

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
			Display.setTitle("Gauchoo Runner");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		lastFPS = getTime();

		while (!Display.isCloseRequested()) {
			updateFPS();
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}

	public static void main(String[] argv) {
		DisplayTest displayExample = new DisplayTest();
		displayExample.start();
	}
	public long getTime()
	{
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
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
