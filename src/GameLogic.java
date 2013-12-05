import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

import java.util.ArrayList;

/**
 * The logic behind the game that is run during PlayState
 */
public class GameLogic {
    /** The amount of time the player has been in PlayState in seconds */
    private int time;
    /** The number of lives the player starts with */
    private int STARTING_LIVES = 3;
    /** An array of lives the player has left */
    private ArrayList<Image> livesList;
    /** An array of all enemies in the game */
    private ArrayList<Enemy> enemyList;
    /** An array of all Powerups in the game */
    private ArrayList<Powerup> powerups;
    /** The number of enemies bounded to the top half of the road */
    private static int NUM_OF_TOPENEMIES = 50;
    /** The number of holes bounded to the top half of the road */
    private static int NUM_OF_TOPHOLES = 50;
    /** The number of enemies bounded to the bottom half of the road */
    private static int NUM_OF_BOTTOMENEMIES = 50;
    /** The number of holes bounded to the bottom half of the road */
    private static int NUM_OF_BOTTOMHOLES = 50;
    /** The amount of time the player has to complete the course */
    private static int TIME_TO_FINISH = 160;
    /** A number that holds number ranges to determine the type of enemy being called */
    private int enemyTypeInterval = 0;
    /** Top enemy interval counter */
    private int topE;
    /** Top hole interval counter */
    private int topH;
    /** Bottom enemy interval counter */
    private int bottomE;
    /** Bottom hole interval counter */
    private int bottomH;
    /** Total number of powerups in the game */
    private static int NUM_OF_POWERUPS = 20;
    /** Scoreboard holding scoring mechanics and board render */
    private Scoreboard scoreboard;
    /** Sees if the object is colliding with another */
    public boolean isColliding;
    /** Manages sound */
    SoundManager s;
    /** Sees if game should be ended */
    private boolean gameOver = false;
    /** The current amount of time left to complete the course */
    private int timeToFinish;

    /**
     * Game Logic Constructor
     */
    public GameLogic() {
        init();
    }

    /**
     * Initializes values in Game Logic
     */
    public void init() {
        livesList = new ArrayList<Image>();
        enemyList = new ArrayList<Enemy>();
        powerups = new ArrayList<Powerup>();
        scoreboard = new Scoreboard();
        isColliding = false;

        //sound jazz
        s = new SoundManager();

        try{
            s.init();
        }catch (SlickException e){
            e.printStackTrace();
        }

        //load the enemies
        int LOCATION = 550;

        //Initialize enemies
        try {
            //Top road bounded holes
            topH = 0;
            while(topH < NUM_OF_TOPHOLES) {
                Image freshmanImage = new Image("res/character/hole.png");

                int randomX;
                randomX = (int) (67500 * Math.random());

                int randomY = 0;
                while(randomY < 225 || randomY > 325) {
                    randomY = (int) (600*Math.random());
                }


                Vector2f freshmanPos = new Vector2f(randomX, randomY);
                Shape freshmanShape = new Rectangle(0, 0, freshmanImage.getWidth(), freshmanImage.getHeight());
                Freshman fresh = new Freshman("freshman" + enemyTypeInterval, freshmanImage, freshmanPos, freshmanShape, 3);
                for (int j = 0; j < enemyList.size(); j++) {
                    if(fresh.isCollidingWith(enemyList.get(j))) {
                        while (fresh.isCollidingWith(enemyList.get(j))) {
                            randomX = (int) (67500 * Math.random());

                            while(randomY < 225 || randomY > 325) {
                                randomY = (int) (600*Math.random());
                            }
                            Vector2f newPosition = new Vector2f(randomX,randomY);
                            fresh.setPosition(newPosition);
                        }
                    }
                }

                enemyList.add(enemyTypeInterval, fresh);
                enemyTypeInterval++;
                topH++;
            }

            //Top road bounded enemies
            topE = enemyTypeInterval;
            while(topE < (NUM_OF_TOPENEMIES + NUM_OF_TOPHOLES)) {

                Image freshmanImage = new Image("res/character/bike_reversed.png");

                int randomX;
                randomX = (int) (67500 * Math.random());

                int randomY = 0;
                while(randomY < 225 || randomY > 325) {
                    randomY = (int) (600*Math.random());
                }


                Vector2f freshmanPos = new Vector2f(randomX, randomY);
                Shape freshmanShape = new Rectangle(0, 0, freshmanImage.getWidth(), freshmanImage.getHeight());
                Freshman fresh = new Freshman("freshman" + enemyTypeInterval, freshmanImage, freshmanPos, freshmanShape, 3);

                for (int j = 0; j < enemyList.size(); j++) {
                    if(fresh.isCollidingWith(enemyList.get(j))) {
                        while (fresh.isCollidingWith(enemyList.get(j))) {
                            randomX = (int) (67500 * Math.random());

                            while(randomY < 225 || randomY > 325) {
                                randomY = (int) (600*Math.random());
                            }
                            Vector2f newPosition = new Vector2f(randomX,randomY);
                            fresh.setPosition(newPosition);
                        }
                    }
                }

                enemyList.add(enemyTypeInterval, fresh);

                enemyTypeInterval++;
                topE++;
            }

            //Bottom road bounded holes
            bottomH = enemyTypeInterval;
            while(bottomH < (NUM_OF_TOPENEMIES + NUM_OF_TOPHOLES + NUM_OF_BOTTOMENEMIES)) {
                Image freshmanImage = new Image("res/character/hole.png");

                int randomX;
                randomX = (int) (67500 * Math.random());

                int randomY = 0;
                while(randomY < 350 || randomY > 450) {
                    randomY = (int) (600*Math.random());
                }


                Vector2f freshmanPos = new Vector2f(randomX, randomY);
                Shape freshmanShape = new Rectangle(0, 0, freshmanImage.getWidth(), freshmanImage.getHeight());
                Freshman fresh = new Freshman("freshman" + enemyTypeInterval, freshmanImage, freshmanPos, freshmanShape, 3);
                for (int j = 0; j < enemyList.size(); j++) {
                    if(fresh.isCollidingWith(enemyList.get(j))) {
                        while (fresh.isCollidingWith(enemyList.get(j))) {
                            randomX = (int) (67500 * Math.random());

                            while(randomY < 225 || randomY > 325) {
                                randomY = (int) (600*Math.random());
                            }
                            Vector2f newPosition = new Vector2f(randomX,randomY);
                            fresh.setPosition(newPosition);
                        }
                    }
                }
                enemyList.add(new Freshman("freshman" + enemyTypeInterval, freshmanImage, freshmanPos, freshmanShape, 3));
                enemyTypeInterval++;
                bottomH++;
            }

            //Bottom road bounded enemies
            bottomE = enemyTypeInterval;
            while(bottomE < (NUM_OF_TOPENEMIES + NUM_OF_TOPHOLES + NUM_OF_BOTTOMENEMIES + NUM_OF_BOTTOMHOLES)) {
                Image freshmanImage = new Image("res/character/Freshman_2.png");

                int randomX;
                randomX = (int) (67500 * Math.random());

                int randomY = 0;
                while(randomY < 350 || randomY > 450) {
                    randomY = (int) (600*Math.random());
                }


                Vector2f freshmanPos = new Vector2f(randomX, randomY);
                Shape freshmanShape = new Rectangle(0, 0, freshmanImage.getWidth(), freshmanImage.getHeight());
                Freshman fresh = new Freshman("freshman" + enemyTypeInterval, freshmanImage, freshmanPos, freshmanShape, 3);
                for (int j = 0; j < enemyList.size(); j++) {
                    if(fresh.isCollidingWith(enemyList.get(j))) {
                        while (fresh.isCollidingWith(enemyList.get(j))) {
                            randomX = (int) (67500 * Math.random());

                            while(randomY < 225 || randomY > 325) {
                                randomY = (int) (600*Math.random());
                            }
                            Vector2f newPosition = new Vector2f(randomX,randomY);
                            fresh.setPosition(newPosition);
                        }
                    }
                }
                enemyList.add(new Freshman("freshman" + enemyTypeInterval, freshmanImage, freshmanPos, freshmanShape, 3));
                enemyTypeInterval++;
                bottomE++;
            }


        } catch (SlickException e) {
            e.printStackTrace();
        }

        try
        {
            for(int i = 0; i < NUM_OF_POWERUPS; i++)
            {
                int randomX;
                randomX = (int) (67500 * Math.random());

                int randomY = 0;
                while(randomY < 225 || randomY > 450) {
                    randomY = (int) (600*Math.random());
                }


                Image powerUpImage = new Image("res/character/ExtraLife.png");
                Vector2f powerUpPos = new Vector2f(randomX, randomY);
                Shape powerUpShape = new Rectangle(0, 0, powerUpImage.getWidth(), powerUpImage.getHeight());
                powerups.add(new ExtraLife("extraLife" + i, powerUpImage, powerUpPos, powerUpShape, 0, false));
                //LOCATION = LOCATION + 300;
            }
        }
        catch(SlickException ex)
        {
            ex.printStackTrace();
        }


        // initialize lives
        try {
            //scoreboard stuff, loads the image
            for (int i = 0; i < STARTING_LIVES; i++) {
                Image liveImage = new Image("res/misc/life.png");
                livesList.add(liveImage);
            }
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates game logic
     * @param speed pixels per frame which which the player is moving
     * @param isMoving sees if player is moving
     * @param player player object
     * @param delta time that has passed since start of game
     */
    public void update(int speed, boolean isMoving, Player player, int delta) {
        this.time += delta;

        //Translates enemy
        if (isMoving) {
            for (int i = 0; i < enemyList.size(); i++) {
                enemyList.get(i).setPosition(new Vector2f(enemyList.get(i).getPosition().getX() - speed, enemyList.get(i).getPosition().getY()));
            }
            for (int i = 0; i < powerups.size(); i++) {
                powerups.get(i).setPosition(new Vector2f(powerups.get(i).getPosition().getX() - speed, powerups.get(i).getPosition().getY()));
            }
        }
        else {
            //TODO fix this ian. please. :)
            for (int i = 0; i < enemyList.size(); i++) {
                enemyList.get(i).setPosition(new Vector2f(enemyList.get(i).getPosition().getX() - speed, enemyList.get(i).getPosition().getY()));
            }
            for (int i = 0; i < powerups.size(); i++) {
                powerups.get(i).setPosition(new Vector2f(powerups.get(i).getPosition().getX() - speed, powerups.get(i).getPosition().getY()));
            }
        }
        for (int i = 0; i < enemyList.size(); i++){
            if((i >= topH) && (i < topE) ) {
                enemyList.get(i).setPosition(new Vector2f(enemyList.get(i).getPosition().getX() - 5, enemyList.get(i).getPosition().getY()));
            }
            else if(i >= bottomH) {
            enemyList.get(i).setPosition(new Vector2f(enemyList.get(i).getPosition().getX() + 2, enemyList.get(i).getPosition().getY()));
            }
        }

        isColliding = false;
        //checks for lives and collisions
        for (int i = 0; i < enemyList.size(); i++) {
            //if (player.isCollidingWith(enemyList.get(i)) && !livesList.isEmpty()) {
            if (player.isCollidingWith(enemyList.get(i)) && !livesList.isEmpty()) {
                s.play("crash");
                if(i < topH) {
                    topH--;
                    topE--;
                    bottomH--;
                    bottomE--;
                }
                else if(i < topE) {
                    topE--;
                    bottomH--;
                    bottomE--;
                }
                else if(i < bottomH) {
                    bottomH--;
                    bottomE--;
                }
                else {
                    bottomE--;
                }
                System.out.println("Collision with" + enemyList.get(i).getName());
                livesList.remove(livesList.size() - 1);
                enemyList.remove(i);
                isColliding = true;
            } else {
                //go to end screen
            }

        }
        // check if interacting with powerup
        for(int i = 0; i < powerups.size(); i++)
        {
            if(player.isCollidingWith(powerups.get(i)) && !powerups.isEmpty())
            {
                System.out.println("Collision with" + powerups.get(i).getName());
                try
                {
                    s.play("powerup");
                    livesList.add(new Image("res/misc/life.png"));
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                powerups.get(i).utilize(player);
                powerups.remove(i);
            }
        }
        if (livesList.isEmpty()) {
//            g.drawString("No more lives!", 300, 50);
            //s.stop("theme");
            //gameOver = true;
        }
        if (timeToFinish <= 0) {
//            g.drawString("No more time!", 500, 50);
            s.stop("theme");
            gameOver = true;
        }

        scoreboard.update(livesList.size(), time, powerups.size());
    }

    /**
     * Renders the game in accordance with position updates as the game progresses
     * @param g the graphics context to draw images on the screen
     */
    public void render(Graphics g) {
        scoreboard.render(g);


        //render enemies
        for (int i = 0; i < enemyList.size(); i++) {
            enemyList.get(i).render(g);
//            g.draw(enemyList.get(i).getCollisionShape());
        }

        // render powerups

        for(int i = 0; i < powerups.size(); i++)
        {
            powerups.get(i).render(g);
//            g.draw(powerups.get(i).getCollisionShape());
        }

        //draws the lives

        g.drawString("Lives:", 10, 10);
        int location = 70;
        for (int i = 0; i < livesList.size(); i++) {
            livesList.get(i).draw(location, 10);
            location += livesList.get(i).getWidth() + 7; //the integer is the spacing between the images
        }


        //TODO replace this with the new image for the scoreboard background
        //timerBox.draw(2, 98);
        timeToFinish = TIME_TO_FINISH - time/1000;
        g.drawString("Time Left: " + timeToFinish + "s", 10, 47);




    }

    /**
     * Method call to see whether object is colliding with another
     * @return sees whether object is colliding with another
     */
    public boolean getIsColliding(){
        return isColliding;
    }

    /**
     * Method call to get score
     * @return score of player
     */
    int getScore()
    {
        return scoreboard.calculateScore();
    }

    /**
     * Method call to play sound
     * @param src name of sound to be played
     */
    public void playSound(String src){
        s.play(src);
    }

    /**
     *  Method call to stop sound
      * @param src name of sound to be stopped
     */
    public void stopSound(String src){
        s.stop(src);
    }

    /**
     * Method call to see whether game is over
     * @return sees if game is over
     */
    public boolean getGameOver(){
        return gameOver;
    }

}
