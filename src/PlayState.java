import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 * User: James Thompson
 * Date: 11/5/13
 * Time: 2:43 PM
 *
 */
public class PlayState extends BasicGameState{
    private TiledMap map;
    private Camera camera;
    private Player player;
    private final String MAP_PATH = "res/map/DemoMap2.tmx";
    int time = 0;
    int currentX = 0;

    private int stateID;

    public PlayState(int stateID){
        super();
        this.stateID = stateID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        Image playerImage = new Image("res/character/bike.png");
        Vector2f playerPos = new Vector2f(50, 300);
        Shape playerShape = new Rectangle(playerPos.x, playerPos.y, playerImage.getWidth(), playerImage.getHeight());
        playerShape.setLocation(playerPos);

        // load map
        map = new TiledMap(MAP_PATH);
        camera = new Camera(gc, map, playerShape);
        player = new Player("GauchoRunner", playerImage, playerPos, playerShape);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        camera.drawMap(0,0);
        player.render(g);
        g.drawString("Time : " + time/1000, 10, 100);

//        camera.render(gc, sbg, g);
//        if(app.getGraphics() == null)
//        {
//            System.out.println("GRAPHICS ARE NULL");
//        }
//        else
//        {
//            player.render(app.getGraphics());
//        }
//        camera.renderFinish(gc, sbg, g);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        time += i;
        //camera.centerOn(player.getCollisionShape());

        //TODO: CAN THIS BE MORE EFFICIENT?
        Input input = gc.getInput();
        System.out.println(player.getPosition().getX());
        if (input.isKeyDown(Input.KEY_UP)){
            player.setPosition(new Vector2f(player.getPosition().getX(),player.getPosition().getY() - 5));
        }
        else if (input.isKeyDown(Input.KEY_DOWN)){
            player.setPosition(new Vector2f(player.getPosition().getX(),player.getPosition().getY() + 5));
        }
        if (input.isKeyDown(Input.KEY_RIGHT)){
            currentX = currentX + 5;
            camera.centerOn(currentX,0);
            camera.translateGraphics();
        }
    }

    @Override
    public int getID() {
        return this.stateID;
    }
}
