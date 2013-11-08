import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.*;
import java.io.InputStream;

/**
 * A class that loads a font resource and makes it available for rendering
 */
public class FontManager {
    /** The font that gets used in the game*/
    private TrueTypeFont font;
    /** Smooths out fonts */
    private boolean antiAlias = false;

    /**
     * Tries to load the font from given resource
     */
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

    /**
     * Render font
     * @param x
     * @param y
     * @param str
     * @param color
     */
    public void render(int x, int y, String str, int color) {
        Color.white.bind();
        font.drawString(x, y, str, Color.white);
    }
}
