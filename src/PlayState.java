import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

/** A class that implements the state where the game is played */
public class PlayState extends BasicGameState {
    /** Map location */
    private final String MAP_PATH = "res/map/fullmap.tmx";
    /** Current x-position */
    int currentX = 0;
    public static int speed = 5;
    /** Game map */
    private TiledMap map;
    /** Camera that moves the map */
    private Camera camera;
    /** User-controlled object */
    private Player player;
    /** State ID of the playable game */
    private int stateID;
    /** The shortest time possible to move the width of the screen once in seconds */
    private int secondsPerWindow = 1;
    private ProgressBar progBar;
    private boolean isMoving = false;
    private GameLogic logic;
    private boolean needsRestart = false;
    private long speedTime = 0;

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

        if(camera.cameraX > 67500) {
//            g.drawString("HEY YOU FINISHED THE GAME HEY HEY HEY HEY HEY hipHip[]!", 200, 300);
//            EndPlayState endPlayState = new EndPlayState(4, logic.getScore() );//4 = playstate
//            sbg.addState(endPlayState);
//            sbg.enterState(4, new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black, 1000));
            sbg.enterState(4);
        }

        progBar.update(currentX, camera.mapWidth);
        progBar.render();

        /*
        //Scoreboard
        g.setColor(Color.blue);
        g.fillRoundRect(0, 0, 225, 100, 10);
        g.setColor(Color.white);
        */

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

        if (needsRestart)
            this.restart(gc, sbg);

        //checks to make sure it does not divide by zero
        if (gc.getFPS() == 0) {
            eventsPerSecond = 60;
        } else {
            eventsPerSecond = gc.getFPS();
        }

        //Sets the number of windows per map
        windowsPerMap = (camera.mapWidth - 800) / (40 * camera.tileWidth);

//        int speed = camera.mapWidth / (eventsPerSecond * secondsPerWindow * windowsPerMap);
        Input input = gc.getInput();

        speedTime += delta;
        // Enter Pause Screen if user presses escape
        if (input.isKeyDown(Input.KEY_ESCAPE))
            sbg.enterState(3);

        if (input.isKeyDown(Input.KEY_UP)) {
            player.setPosition(new Vector2f(player.getPosition().getX(), player.getPosition().getY() - player.getSpeed()));
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            player.setPosition(new Vector2f(player.getPosition().getX(), player.getPosition().getY() + player.getSpeed()));
        }
        currentX = currentX + speed;

        if (input.isKeyDown(Input.KEY_LEFT)) {
            if (speedTime >= 100) {
                speedTime = 0;
                if (speed > 0) {
                    speed--;
                }
                System.out.println(speed);
            }
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            // TODO:  PLACEHOLDER - FIX THIS
            isMoving = true;
            if (speedTime >= 250) {
                speedTime = 0;
                if (speed < 100) {
                    speed++;
                }
                System.out.println(speed);
            }
        } else {
            isMoving = false;
        }
        // Check bounds
        if (player.getPosition().getY() < 150) {
            player.setPosition(new Vector2f(player.getPosition().getX(), 150));
        } else if (player.getPosition().getY() > 540) {
            player.setPosition(new Vector2f(player.getPosition().getX(), 540));
        }
        //check to see if player is on the dirt
        if((player.getPosition().getY() < 210) && (speed >= 3)) {
            speed = 3;
        } else if ((player.getPosition().getY() > 485) && (speed >= 3)){
            speed = 3;
        }


        logic.update(speed, isMoving, player, delta);
        //check to see if collision happened
        if(logic.getIsColliding()){
            speed = 3;
        }


        camera.centerOn(currentX, 0);
        camera.translateGraphics();
    }

    /** Restarts the game */
    public void restart() {
        //TODO: implement reset() methods in the following classes:
        //camera.reset();
        //player.reset();
        //logic.reset();
        //hud.reset();
        this.needsRestart = true;
    }

    /** Restarts the game ( using init() ) */
    public void restart(GameContainer gc, StateBasedGame sbg) {
        //TODO: implement init()-indepenent restart()
        try {
            this.init(gc, sbg);
        } catch (SlickException ex) {
            ex.printStackTrace();
            return;
        }
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
