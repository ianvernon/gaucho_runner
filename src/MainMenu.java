import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class MainMenu {
	private FontManager title;
	private FontManager title2;
	TextureBox bird;
	SoundManager soundManager;
	long lastFPS;
	int FPS;
	//translate along the x-axis
	float translate_x = 0;

	public int start() {
		initGL(800, 600);
		init();

		lastFPS = (Sys.getTime() * 1000) / Sys.getTimerResolution();	//frame rate stuff

		while (true) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

			if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
				bird.update(-5, 0);
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
				bird.update(0, 5);
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
				bird.update(5, 0);
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
				bird.update(0, -5);
			}

			render();
			updateFPS();
			
			Display.update();
			Display.sync(100);

			if (Display.isCloseRequested() || Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
				Display.destroy();
				soundManager.destroy();

				System.out.println(">> Main Menu: Done");
				return 0;
			}
		}
	}

	private void initGL(int width, int height) {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle("Gaucho Runner");
			Display.create();
			Display.setVSyncEnabled(true); // stops the tearing of images when
											// moving
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glClearColor(0.0f, 0.f, 0.2f, 0.0f); // background color

		// enable alpha blending?
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glViewport(0, 0, width, height);

		// GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		

	}

	// Initialize resources
	public void init() {
		title = new FontManager();
		soundManager = new SoundManager("res/Testarossa.wav");
		bird = new TextureBox(400 - 128, 300, "res/bike.png");

		title2 = new FontManager();


		
		title.init();
		title2.init();
		soundManager.init();
		bird.init();

		soundManager.play();
	}

	public void render() {	
		//translate the background
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
//		GL11.glPushMatrix();
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			translate_x -= 1;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			translate_x += 1;
		}
		
//		System.out.println(">> Translate: " + translate_x);

		GL11.glTranslated(translate_x, 0, 0);
//		GL11.glPopMatrix();
		
		
		bird.render();
		title.render(100, 100, "Gaucho Runner", 0);
	}

	public void updateFPS() {
		long currentTime = (Sys.getTime() * 1000) / Sys.getTimerResolution();
		if (currentTime - lastFPS > 1000) {
			Display.setTitle("Gaucho Runner FPS: " + FPS);
			FPS = 0;
			lastFPS += 1000;
		}
		FPS++;
	}
}
