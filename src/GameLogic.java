import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

import java.util.ArrayList;


public class GameLogic {

    private int time;
    private int STARTING_LIVES = 3;
    private ArrayList<Image> livesList;
    private ArrayList<Enemy> enemyList;
    private int NUM_OF_ENEMIES = 10;
    private Image timerBox;


    public GameLogic() {
        init();
    }

    public void init() {
        livesList = new ArrayList<Image>();
        enemyList = new ArrayList<Enemy>();

        try {
            timerBox = new Image("res/misc/TimerBackground.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }

        //load the enemies
        int LOCATION = 550;

        try {
            for (int i = 0; i < NUM_OF_ENEMIES; i++) {
                Image freshmanImage = new Image("res/character/Freshman.png");
                Vector2f freshmanPos = new Vector2f(LOCATION, 300);
                Shape freshmanShape = new Rectangle(0, 0, freshmanImage.getWidth(), freshmanImage.getHeight());
                enemyList.add(new Freshman("freshman" + i, freshmanImage, freshmanPos, freshmanShape, 3));
                LOCATION = LOCATION + 300;
            }
        } catch (SlickException e) {
            e.printStackTrace();
        }

        // initialize lives
        try {
            //scoreboard stuff, loads the image
            for (int i = 0; i < STARTING_LIVES; i++) {
                Image liveImage = new Image("res/misc/heart.png");
                livesList.add(liveImage);
            }
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void update(int speed, boolean isMoving, Player player, int delta) {
        this.time += delta;

        //Translates enemy
        if (isMoving) {
            for (int i = 0; i < enemyList.size(); i++) {
                enemyList.get(i).setPosition(new Vector2f(enemyList.get(i).getPosition().getX() - speed, 300));
            }
        }

        //checks for lives and collisions
        for (int i = 0; i < enemyList.size(); i++) {
            //if (player.isCollidingWith(enemyList.get(i)) && !livesList.isEmpty()) {
            if (player.isCollidingWith(enemyList.get(i)) && !livesList.isEmpty()) {
                System.out.println("Collision with" + enemyList.get(i).getName());
                livesList.remove(livesList.size() - 1);
                enemyList.remove(i);
            } else {
                //go to end screen
            }

        }

    }

    public void render(Graphics g) {
        //render enemies
        for (int i = 0; i < enemyList.size(); i++) {
            enemyList.get(i).render(g);
            g.draw(enemyList.get(i).getCollisionShape());
        }

        //draws the lives

        g.drawString("Lives:", 10, 10);
        int location = 70;
        for (int i = 0; i < livesList.size(); i++) {
            livesList.get(i).draw(location, 10);
            location += livesList.get(i).getWidth() + 7; //the integer is the spacing between the images
        }


        if (livesList.isEmpty()) {
            g.drawString("No more lives!", 300, 50);
        }

        //TODO replace this with the new image for the scoreboard background
        //timerBox.draw(2, 98);
        g.drawString("Time: " + time / 1000 + "s", 10, 47);


        if (time / 1000 >= 15) {
            g.drawString("No more time!", 500, 50);
        }
    }

}
