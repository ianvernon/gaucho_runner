import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.*;
import org.newdawn.slick.util.ResourceLoader;

public class FontTest {
	private TrueTypeFont font;
	private boolean antiAlias = false;

	public void init() {
		try {
			InputStream inputStream = ResourceLoader.getResourceAsStream("res/Coalition.ttf");

			Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont = awtFont.deriveFont(50f); // font size
			font = new TrueTypeFont(awtFont, antiAlias);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void render(int x, int y, String whatchars, int color) {
		Color.white.bind();
		font.drawString(x, y, whatchars, Color.white);
	}
}
