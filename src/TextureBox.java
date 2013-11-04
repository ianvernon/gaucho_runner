import java.io.IOException;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TextureBox {
	public int x, y;
	String src;
	Texture texture;

	public TextureBox(int x, int y, String src) {
		this.src = src;
		this.x = x;
		this.y = y;
	}

	// Initialize resources
	public void init() {
		// load PNG
		try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(src));
			System.out.println("Texture loaded: " + texture);
			System.out.println(">> Image width: " + texture.getImageWidth());
			System.out.println(">> Image height: " + texture.getImageHeight());
			System.out.println(">> Texture width: " + texture.getTextureWidth());
			System.out.println(">> Texture height: " + texture.getTextureHeight());
			System.out.println(">> Texture ID: " + texture.getTextureID());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update(int dx, int dy) {
		x += dx;
		y += dy;
		checkBounds();
	}

	// checks to see if the box has hit the side
	public void checkBounds() {
//		if (x < 0) {
//			x = 0;
//		} else if (x > Display.getWidth() - texture.getTextureWidth()) {
//			x = Display.getWidth() - texture.getTextureWidth();
//		}
		if (y < 0) {
			y = 0;
		} else if (y > Display.getHeight() - texture.getImageHeight()) {
			y = Display.getHeight() - texture.getImageHeight();
		}
	}

	public void render() {
		texture.bind();
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(x, y);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(x + texture.getTextureWidth(), y);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(x + texture.getTextureWidth(), y + texture.getTextureHeight());
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(x, y + texture.getTextureHeight());
		GL11.glEnd();
	}
}
