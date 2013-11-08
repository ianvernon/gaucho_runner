import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.tiled.TiledMap;

/**
 * A class that implements side-scrolling functionality by holding the player a constant x position while translates the map behind it.
 */
public class Camera {
    /** the map used for our scene. */
    protected TiledMap map;
    /** the number of tiles in x-direction (width). */
    protected int numTilesX;
    /** the number of tiles in y-direction (height). */
    protected int numTilesY;
    /** the height of the map in pixel. */
    protected int mapHeight;
    /** the width of the map in pixel. */
    protected int mapWidth;
    /** the width of one tile of the map in pixel. */
    protected int tileWidth;
    /** the height of one tile of the map in pixel. */
    protected int tileHeight;
    /** the GameContainer, used for getting the size of the GameCanvas. */
    protected GameContainer gc;
    /** the x-position of our "camera" in pixel. */
    protected float cameraX;
    /** the y-position of our "camera" in pixel. */
    protected float cameraY;

    /**
     * Creates a new Camera instance that initializes Screen coordinate values
     * @param gc
     * @param map
     */
    public Camera(GameContainer gc, TiledMap map) {
        this.map = map;

        this.numTilesX = map.getWidth();
        this.numTilesY = map.getHeight();

        this.tileWidth = map.getTileWidth();
        this.tileHeight = map.getTileHeight();

        this.mapWidth = this.numTilesX * this.tileWidth;
        this.mapHeight = this.numTilesY * this.mapHeight;

        this.gc = gc;
    }

    /**
     * Centers the camera on the current x position of the player
     * @param x
     * @param y
     */
    public void centerOn(float x, float y) {
        cameraX = x;
        cameraY = y - gc.getHeight() / 2f;

        if (cameraX < 0) {
            cameraX = 0;
        }
        if (cameraX + gc.getWidth() > mapWidth) {
//            cameraX = mapWidth - gc.getWidth();
            cameraX = 0;
        }

        if (cameraY < 0) {
            cameraY = 0;
        }
        if (cameraY + gc.getHeight() > mapHeight) {
//            cameraY = mapHeight - gc.getHeight();
            cameraY = 0;
        }
    }

    /**
     * Draws the part of the map available on the screen
     * @param offsetX
     * @param offsetY
     */
    public void drawMap(int offsetX, int offsetY) {
        //calculate the offset to the next tile (needed by TiledMap.render())
        int tileOffsetX = (int) -(cameraX % tileWidth);
        int tileOffsetY = (int) -(cameraY % tileHeight);

        //calculate the index of the leftmost tile that is being displayed
        int tileIndexX = (int) (cameraX / tileWidth);
        int tileIndexY = (int) (cameraY / tileHeight);
        //finally draw the section of the map on the screen
        int width = (gc.getWidth() - tileOffsetX) / tileWidth + 1;
        int height = (gc.getHeight() - tileOffsetY) / tileWidth + 1;

        try {
            map.render(tileOffsetX + offsetX, tileOffsetY + offsetY, tileIndexX, tileIndexY, width, height);
        } catch (Exception e) {
            System.out.println("Camera.drawMap(): " + "could not draw: " + e);
        }
    }

    /**
     * Translates the current view of the map
     */
    public void translateGraphics() {
        gc.getGraphics().translate(-cameraX, -cameraY);
    }
}
