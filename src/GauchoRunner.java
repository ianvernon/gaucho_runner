import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class GauchoRunner {
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
		}		
		Display.destroy();
	}
	
	public static void main(String[] argv) {
		GauchoRunner displayExample = new GauchoRunner();
		displayExample.start();
	}
}