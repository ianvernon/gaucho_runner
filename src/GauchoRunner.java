import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class GauchoRunner extends StateBasedGame{
      public static final int MAINMENUSTATEID = 0;
      public static final int PLAYSTATEID = 1;
      private static AppGameContainer app;
//    private TiledMap map;
//    private Camera camera;
//    private Player player;
//    private final String MAPPATH = "res/map/DemoMap.tmx";


    public GauchoRunner(){
        super("Gaucho Runner");
        MenuState menuState = new MenuState(/* WAT */, MAINMENUSTATEID, 300, 180, 131);
        this.addState(menuState);
        PlayState playState = new PlayState(PLAYSTATEID);
        this.addState(playState);
        this.enterState(MAINMENUSTATEID);
    }

	public static void main(String[] argv) {

        try{
            app = new AppGameContainer(new GauchoRunner());
            app.setVSync(true);
            app.setTargetFrameRate(60);
            app.setDisplayMode(800,600, false);
            app.start();
        }
        catch(SlickException e){
            e.printStackTrace();
        }
	}
//    @Override
//    public void init(GameContainer container) throws SlickException
//    {
//           Image playerImage = new Image("res/character/bike.png");
//           Vector2f playerPos = new Vector2f(400, 300);
//           Shape playerShape = new Rectangle(playerPos.x, playerPos.y, playerImage.getWidth(), playerImage.getHeight());
//           playerShape.setLocation(playerPos);
//
//           // load map
//           try
//           {
//               map = new TiledMap(MAPPATH);
//           }
//           catch(SlickException ex)
//           {
//               System.out.println("BlockMap.BlockMap(): "
//                       + "could not load: " + MAPPATH +  ": " + ex);
//               ex.printStackTrace();
//               return;
//
//           }
//           player = new Player("GauchoRunner", playerImage, playerPos, playerShape);
//    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        //What does this do? must be here for StateBasedGame
    }

//    public void update(GameContainer container, int delta) throws SlickException
//    {
//
//        //TODO: CAN THIS BE MORE EFFICIENT?
//        Input input = container.getInput();
//        if (input.isKeyDown(Input.KEY_UP))
//        {
//           player.setPosition(new Vector2f(player.getPosition().getX(),player.getPosition().getY() - 5));
//        }
//        else if (input.isKeyDown(Input.KEY_DOWN))
//        {
//            player.setPosition(new Vector2f(player.getPosition().getX(),player.getPosition().getY() + 5));
//        }
//        else if (input.isKeyDown(Input.KEY_LEFT))
//        {
//            player.setPosition(new Vector2f(player.getPosition().getX() - 5,player.getPosition().getY()));
//        }
//        else if (input.isKeyDown(Input.KEY_RIGHT))
//        {
//            player.setPosition(new Vector2f(player.getPosition().getX()+5,player.getPosition().getY()));
//        }
//
//    }
//    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
//    {
//        map.render(0,0);
//        camera.render(container, sbg, g);
//        if(app.getGraphics() == null)
//        {
//            System.out.println("GRAPHICS ARE NULL");
//        }
//        else
//        {
//            player.render(app.getGraphics());
//        }
//        camera.renderFinish(container, sbg, g);
//
//    }
}