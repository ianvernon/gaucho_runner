import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.SlickException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GauchoRunner extends BasicGame{

    public GauchoRunner(){
        super("Gaucho Runner");
    }

	public static void main(String[] argv) {
//		MainMenu mainMenu = new MainMenu();
//		mainMenu.start();
//		System.exit(0);

        try{
            AppGameContainer app = new AppGameContainer(new GauchoRunner());
            app.setDisplayMode(800,600, false);
            app.start();
        }
        catch(SlickException e){
            e.printStackTrace();
        }
	}
    @Override
    public void init(GameContainer container) throws SlickException
    {
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException
    {
    }

    public void render(GameContainer container, Graphics g) throws SlickException
    {
    }
}