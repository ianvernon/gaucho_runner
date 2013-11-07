import org.newdawn.slick.GameContainer;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;


public class Camera {
    private TiledMap map;
    private int numTilesX, numTilesY;
    private int mapWidth, mapHeight;
    private int tileWidth, tileHeight;
    private GameContainer gc;
    private float cameraX, cameraY;
    Shape playerShape;

    public Camera(GameContainer gc, TiledMap map, Shape playerShape){
        this.map = map;

        this.numTilesX = map.getWidth();
        this.numTilesY = map.getHeight();

        this.tileWidth = map.getTileWidth();
        this.tileHeight = map.getTileHeight();

        this.mapWidth  = this.numTilesX * this.tileWidth;
        this.mapHeight = this.numTilesY * this.mapHeight;

        this.gc = gc;
        this.playerShape = playerShape;
    }

    public void centerOn(float x, float y){
        cameraX = x;
        cameraY = y - gc.getHeight() / 2f;

        if(cameraX < 0){
            cameraX = 0;
        }
        if(cameraX + gc.getWidth() > mapWidth){
//            cameraX = mapWidth - gc.getWidth();
            cameraX = 0;
        }

        if(cameraY < 0){
            cameraY = 0;
        }
        if(cameraY + gc.getHeight() > mapHeight){
//            cameraY = mapHeight - gc.getHeight();
            cameraY = 0;
        }
    }

    public void centerOn(float x, float y, float width, float height){
        this.centerOn(x + width / 2, y + height / 2);
    }

    //???
    public void centerOn(Shape shape){
        this.centerOn(shape.getCenterX(), shape.getCenterY());
    }

//    public void drawMap(Graphics g) {
//        this.drawMap(g, "", "");
//    }

    public void drawMap(int offsetX, int offsetY, Graphics g) {
        // TODO try to make this perform better
        // (remove draw string from here, etc)
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
            map.render(tileOffsetX + offsetX, tileOffsetY + offsetY, tileIndexX, tileIndexY , width, height);
        } catch (Exception e) {
            System.out.println("Camera.drawMap(): " + "could not draw: " + e);
        }

        // add time to upper right corner
//        g.drawString("time: " + time + " money: " + money,
//                width + (gc.getWidth() / 1.5f),
//                height);
    }

    public void translateGraphics(){
        gc.getGraphics().translate(-cameraX, -cameraY);
    }



//    public void renderFinish(GameContainer gc, StateBasedGame sbg, Graphics g){
//        g.setWorldClip(0, 0, 800, 600);
//    }

}
