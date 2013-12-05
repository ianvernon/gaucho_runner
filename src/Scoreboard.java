import org.newdawn.slick.*;

/**
 * A class that holds the score and renders player information
 */
public class Scoreboard {
    /** Score of player */
    private int score = 0;
    /** Number of lives the player has */
    private int numOfLives;
    /** Amount of time the game has been played for */
    private int timeFinished;
    /** Number of PowerUps the player has */
    private int numOfPowerUps;
    /** Time allowed for course completion */
    private int TIME_ALLOWED = 160;

    /**
     * Default Scoreboard constructor
     */
    public Scoreboard() {

    }

    /**
     * Updates logic behind scoreboard
     * @param sizeOfLivesList number of lives the player has left
     * @param secondsToComplete seconds with which the player has completed the course
     * @param sizeOfPowerUpsList number of powerups the player has
     */
    public void update(int sizeOfLivesList, int secondsToComplete, int sizeOfPowerUpsList) {
        setNumOfLives(sizeOfLivesList);
        setTimeFinished(secondsToComplete);
        setNumOfPowerUps(sizeOfPowerUpsList);
    }

    /**
     * Renders scoreboard
     * @param g the graphics context to draw images on the screen
     */
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRoundRect(0, 0, 225, 100, 10);
        g.setColor(Color.white);

    }

    /**
     * Method call to set the number of lives of the player
     * @param value number of lives to be set to the player
     */
    public void setNumOfLives(int value) {
        this.numOfLives = value;
    }

    /**
     * Method call that sets time to finish course
     * @param value time to finish course
     */
    public void setTimeFinished(int value) {
         this.timeFinished = value;
    }

    /**
     * Method call that sets the number of powerups
     * @param value number of powerups
     */
    public void setNumOfPowerUps(int value) {
        this.numOfPowerUps = value;

    }

    /**
     * Calculates score
     * @return score of player
     */
    public int calculateScore() {

        score += numOfLives * 500;
        score += ((TIME_ALLOWED - timeFinished)*(TIME_ALLOWED - timeFinished));
        score += numOfPowerUps * 50;

        return score;
    }
}
