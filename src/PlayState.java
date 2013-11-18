import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import java.util.ArrayList;

/**
 * A class that implements the state where the game is played
 */
public class PlayState extends BasicGameState {
    /** Game map */
    private TiledMap map;
    /** Camera that moves the map */
    private Camera camera;
    /** User-controlled object */
    private Player player;
    /** Map location */
    private final String MAP_PATH = "res/map/DemoMap2.tmx";
    /** Time game has been in play state */
    int time = 0;
    /** Current x-position */
    int currentX = 0;
    /** State ID of the playable game */
    private int stateID;
    private Image timerBox;
    /** The shortest time possible to move the width of the screen once in seconds*/
    private int secondsPerWindow = 2;

    private ProgressBar progBar;

    public ArrayList<Image> livesList;

    private int STARTING_LIVES = 3;

    //TODO: PUT ENEMIES IN THIS ARRAYLIST
    private ArrayList<Enemy> enemies;

    private Enemy freshman;
    private Enemy freshman2;
    private Enemy freshman3;
    private Enemy freshman4;
    private Enemy freshman5;
    private Enemy freshman6;
    private Enemy freshman7;
    private Enemy freshman8;
    private Enemy freshman9;
    private Enemy freshman10;

    /**
     * Sets game to playable state
     * @param stateID
     */
    public PlayState(int stateID) {
        super();
        this.stateID = stateID;
    }

    /**
     * Sets the player graphic, position, shape, and loads the map
     * @param gc
     * @param sbg
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        Image playerImage = new Image("res/character/bike.png");
        Vector2f playerPos = new Vector2f(50, 300);
        Shape playerShape = new Rectangle(0,0, playerImage.getWidth(), playerImage.getHeight());
       // playerShape.setLocation(playerPos);
        livesList = new ArrayList<Image>();
        enemies = new ArrayList<Enemy>();

        //scoreboard stuff, loads the image
        for(int i = 0; i < 3; i++){
            Image liveImage = new Image("res/misc/heart.png");
            livesList.add(liveImage);
        }

        //load map
        map = new TiledMap(MAP_PATH);
        timerBox = new Image("res/misc/TimerBackground.png");
        camera = new Camera(gc, this.map);
        // add player and progress bar to map
        player = new Player("GauchoRunner", playerImage, playerPos, playerShape, 5);
        progBar = new ProgressBar(250,20);

        Image freshmanImage = new Image("res/character/Freshman.png");
        Vector2f freshmanPos = new Vector2f(550, 300);
        Shape freshmanShape = new Rectangle(0, 0, freshmanImage.getWidth(), freshmanImage.getHeight());
        freshman = new Freshman("freshman1", freshmanImage, freshmanPos, freshmanShape, 3);

        Image freshman2Image = new Image("res/character/Freshman.png");
        Vector2f freshman2Pos = new Vector2f(1350, 300);
        Shape freshman2Shape = new Rectangle(0, 0, freshman2Image.getWidth(), freshman2Image.getHeight());
        freshman2 = new Freshman("freshman2", freshman2Image, freshman2Pos, freshman2Shape, 3);

        Image freshman3Image = new Image("res/character/Freshman.png");
        Vector2f freshman3Pos = new Vector2f(2150, 300);
        Shape freshman3Shape = new Rectangle(0, 0, freshman3Image.getWidth(), freshman3Image.getHeight());
        freshman3 = new Freshman("freshman3", freshman3Image, freshman3Pos, freshman3Shape, 3);

        Image freshman4Image = new Image("res/character/Freshman.png");
        Vector2f freshman4Pos = new Vector2f(2950, 300);
        Shape freshman4Shape = new Rectangle(0, 0, freshman4Image.getWidth(), freshman4Image.getHeight());
        freshman4 = new Freshman("freshman4", freshman4Image, freshman4Pos, freshman4Shape, 3);

        Image freshman5Image = new Image("res/character/Freshman.png");
        Vector2f freshman5Pos = new Vector2f(3750, 300);
        Shape freshman5Shape = new Rectangle(0, 0, freshman5Image.getWidth(), freshman5Image.getHeight());
        freshman5 = new Freshman("freshman5", freshman5Image, freshman5Pos, freshman5Shape, 3);

        Image freshman6Image = new Image("res/character/Freshman.png");
        Vector2f freshman6Pos = new Vector2f(4550, 300);
        Shape freshman6Shape = new Rectangle(0, 0, freshman6Image.getWidth(), freshman6Image.getHeight());
        freshman6 = new Freshman("freshman6", freshman6Image, freshman6Pos, freshman6Shape, 3);

        Image freshman7Image = new Image("res/character/Freshman.png");
        Vector2f freshman7Pos = new Vector2f(5350, 300);
        Shape freshman7Shape = new Rectangle(0, 0, freshman7Image.getWidth(), freshman7Image.getHeight());
        freshman7 = new Freshman("freshman7", freshman7Image, freshman7Pos, freshman7Shape, 3);

        Image freshman8Image = new Image("res/character/Freshman.png");
        Vector2f freshman8Pos = new Vector2f(6150, 300);
        Shape freshman8Shape = new Rectangle(0, 0, freshman8Image.getWidth(), freshman8Image.getHeight());
        freshman8 = new Freshman("freshman8", freshman8Image, freshman8Pos, freshman8Shape, 3);

        Image freshman9Image = new Image("res/character/Freshman.png");
        Vector2f freshman9Pos = new Vector2f(6950, 300);
        Shape freshman9Shape = new Rectangle(0, 0, freshman9Image.getWidth(), freshman9Image.getHeight());
        freshman9 = new Freshman("freshman9", freshman9Image, freshman9Pos, freshman9Shape, 3);

        Image freshman10Image = new Image("res/character/Freshman.png");
        Vector2f freshman10Pos = new Vector2f(7750, 300);
        Shape freshman10Shape = new Rectangle(0, 0, freshman10Image.getWidth(), freshman10Image.getHeight());
        freshman10 = new Freshman("freshman10", freshman10Image, freshman10Pos, freshman10Shape, 3);

        //freshman.setPosition(new Vector2f(550, 300));
      //  freshman2.setPosition(new Vector2f(550, 300));


    }

    /**
     * Draws map and player and displays time in seconds
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
        freshman.render(g);
        g.draw(freshman.getCollisionShape());
        freshman2.render(g);
        g.draw(freshman2.getCollisionShape());
        freshman3.render(g);
        g.draw(freshman3.getCollisionShape());
        freshman4.render(g);
        g.draw(freshman4.getCollisionShape());
        freshman5.render(g);
        g.draw(freshman5.getCollisionShape());
        freshman6.render(g);
        g.draw(freshman6.getCollisionShape());
        freshman7.render(g);
        g.draw(freshman7.getCollisionShape());
        freshman8.render(g);
        g.draw(freshman8.getCollisionShape());
        freshman9.render(g);
        g.draw(freshman9.getCollisionShape());
        freshman10.render(g);
        g.draw(freshman10.getCollisionShape());

        progBar.update(currentX, camera.mapWidth);
        progBar.render();

        //Scoreboard
        g.setColor(Color.blue);
        g.fillRoundRect(0, 0, 225, 100, 10);
        g.setColor(Color.white);

        //TODO replace this with the new image for the scoreboard background
        //timerBox.draw(2, 98);
        g.drawString("Time: " + time / 1000 + "s", 10, 47);

        //draws the lives

        g.drawString("Lives:", 10, 10);
        int location = 70;
        for(int i = 0; i < livesList.size(); i++){
            livesList.get(i).draw(location, 10);
            location += livesList.get(i).getWidth() + 7; //the integer is the spacing between the images
        }




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

    /**
     * Updates time, player position, and camera location
     * @param gc
     * @param sbg
     * @param i
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        int eventsPerSecond;
        int windowsPerMap;
        time += i;
        //camera.centerOn(player.getCollisionShape());

        //checks to make sure it does not divide by zero
        if(gc.getFPS() == 0){
            eventsPerSecond = 60;
        }
        else{
            eventsPerSecond = gc.getFPS();
        }

        //Sets the number of windows per map
        windowsPerMap = (camera.mapWidth - 800) / ( 40 * camera.tileWidth);

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
           freshman.setPosition(new Vector2f(freshman.getPosition().getX()-speed, 300));
           freshman2.setPosition(new Vector2f(freshman2.getPosition().getX()-speed, 300));
            freshman3.setPosition(new Vector2f(freshman3.getPosition().getX()-speed, 300));
            freshman4.setPosition(new Vector2f(freshman4.getPosition().getX()-speed, 300));
            freshman5.setPosition(new Vector2f(freshman5.getPosition().getX()-speed, 300));
            freshman6.setPosition(new Vector2f(freshman6.getPosition().getX()-speed, 300));
            freshman7.setPosition(new Vector2f(freshman7.getPosition().getX()-speed, 300));
            freshman8.setPosition(new Vector2f(freshman8.getPosition().getX()-speed, 300));
            freshman9.setPosition(new Vector2f(freshman9.getPosition().getX()-speed, 300));
            freshman10.setPosition(new Vector2f(freshman10.getPosition().getX()-speed, 300));
        }

        // Check bounds
        if (player.getPosition().getY() < 90) {
            player.setPosition(new Vector2f(player.getPosition().getX(), 90));
        }
        else if(player.getPosition().getY() > 450) {
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
        camera.centerOn(currentX, 0);
        camera.translateGraphics();
    }

    /**
     * Gets state ID of the play state
     * @return
     */
    @Override
    public int getID() {
        return this.stateID;
    }
}
