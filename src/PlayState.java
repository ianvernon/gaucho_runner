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
 * To change this template use File | Settings | File Templates.
 */
public class PlayState extends BasicGameState{
    private TiledMap map;
    private Camera camera;
    private Player player;
    private final String MAPPATH = "res/map/DemoMap.tmx";
    private static AppGameContainer app;

    private int stateID;

    public PlayState(int stateID)
    {
        super();
        this.stateID = stateID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        Image playerImage = new Image("res/character/bike.png");
        Vector2f playerPos = new Vector2f(400, 300);
        Shape playerShape = new Rectangle(playerPos.x, playerPos.y, playerImage.getWidth(), playerImage.getHeight());
        playerShape.setLocation(playerPos);

        // load map
        try
        {
            map = new TiledMap(MAPPATH);
        }
        catch(SlickException ex)
        {
            System.out.println("BlockMap.BlockMap(): "
                    + "could not load: " + MAPPATH +  ": " + ex);
            ex.printStackTrace();
            return;

        }
        player = new Player("GauchoRunner", playerImage, playerPos, playerShape);


    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        map.render(0,0);
        player.render(g);
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
        //TODO: CAN THIS BE MORE EFFICIENT?
        Input input = gc.getInput();
        if (input.isKeyDown(Input.KEY_UP))
        {
            player.setPosition(new Vector2f(player.getPosition().getX(),player.getPosition().getY() - 5));
        }
        else if (input.isKeyDown(Input.KEY_DOWN))
        {
            player.setPosition(new Vector2f(player.getPosition().getX(),player.getPosition().getY() + 5));
        }
        else if (input.isKeyDown(Input.KEY_LEFT))
        {
            player.setPosition(new Vector2f(player.getPosition().getX() - 5,player.getPosition().getY()));
        }
        else if (input.isKeyDown(Input.KEY_RIGHT))
        {
            player.setPosition(new Vector2f(player.getPosition().getX()+5,player.getPosition().getY()));
        }
    }

    @Override
    public int getID() {
        return this.stateID;
    }
}
