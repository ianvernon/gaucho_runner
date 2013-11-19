import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/** A class that implements the state where the game is played */
public class PlayState extends BasicGameState {
    /** Map location */
    private final String MAP_PATH = "res/map/DemoMap2.tmx";
    /** Current x-position */
    int currentX = 0;
    /** Game map */
    private TiledMap map;
    /** Camera that moves the map */
    private Camera camera;
    /** User-controlled object */
    private Player player;
    /** State ID of the playable game */
    private int stateID;
    /** The shortest time possible to move the width of the screen once in seconds */
    private int secondsPerWindow = 2;
    private ProgressBar progBar;
    private boolean IS_MOVING = false;
    private GameLogic logic;

    /**
     * Sets game to playable state
     *
     * @param stateID
     */
    public PlayState(int stateID) {
        super();
        this.stateID = stateID;
    }

    /**
     * Sets the player graphic, position, shape, and loads the map
     *
     * @param gc
     * @param sbg
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        Image playerImage = new Image("res/character/bike.png");
        Vector2f playerPos = new Vector2f(50, 300);
        Shape playerShape = new Rectangle(0, 0, playerImage.getWidth(), playerImage.getHeight());

        //load map
        map = new TiledMap(MAP_PATH);
        camera = new Camera(gc, this.map);
        // add player and progress bar to map
        player = new Player("GauchoRunner", playerImage, playerPos, playerShape, 5);
        progBar = new ProgressBar(250, 20);
        logic = new GameLogic();

    }

    /**
     * Draws map and player and displays time in seconds
     *
     * @param gc
     * @param sbg
     * @param g
     * @throws SlickException
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        camera.drawMap(0, 0);
        player.render(g);
        g.draw(player.getCollisionShape());

        progBar.update(currentX, camera.mapWidth);
        progBar.render();

        //Scoreboard
        g.setColor(Color.blue);
        g.fillRoundRect(0, 0, 225, 100, 10);
        g.setColor(Color.white);

        logic.render(g);
    }

    /**
     * Updates time, player position, and camera location
     *
     * @param gc
     * @param sbg
     * @param delta
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        int eventsPerSecond;
        int windowsPerMap;


        //camera.centerOn(player.getCollisionShape());

        //checks to make sure it does not divide by zero
        if (gc.getFPS() == 0) {
            eventsPerSecond = 60;
        } else {
            eventsPerSecond = gc.getFPS();
        }

        //Sets the number of windows per map
        windowsPerMap = (camera.mapWidth - 800) / (40 * camera.tileWidth);

        int speed = camera.mapWidth / (eventsPerSecond * secondsPerWindow * windowsPerMap);
        Input input = gc.getInput();

        //
        if (input.isKeyDown(Input.KEY_UP)) {
            player.setPosition(new Vector2f(player.getPosition().getX(), player.getPosition().getY() - player.getSpeed()));
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            player.setPosition(new Vector2f(player.getPosition().getX(), player.getPosition().getY() + player.getSpeed()));
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            currentX = currentX + speed;
            // TODO:  PLACEHOLDER - FIX THIS
            IS_MOVING = true;
        } else {
            IS_MOVING = false;
        }

        // Check bounds
        if (player.getPosition().getY() < 90) {
            player.setPosition(new Vector2f(player.getPosition().getX(), 90));
        } else if (player.getPosition().getY() > 450) {
            player.setPosition(new Vector2f(player.getPosition().getX(), 450));
        }

        /*if(player.isCollidingWith(freshman))
        {
            System.out.println("Oh no: collision with freshman");
        }
        if(player.isCollidingWith(freshman2))
        {
            System.out.println("Oh no: collision with freshman2");
        } */

        /*player.update(gc, sbg, i);
       freshman.update(gc, sbg, i);
       freshman2.update(gc, sbg, i);
          */
        //player.getCollisionShape().setLocation(player.getPosition());
        logic.update(speed, IS_MOVING, player, delta);
        camera.centerOn(currentX, 0);
        camera.translateGraphics();
    }

    /**
     * Gets state ID of the play state
     *
     * @return
     */
    @Override
    public int getID() {
        return this.stateID;
    }
}
