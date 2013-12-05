import org.newdawn.slick.*;

/**
 * Progress counter image that keeps track of how much of the course the player has completed
 */
public class ProgressBar {
    /** Hard coded starting x-position pixel of scoreboard */
    private final int SX = 250;
    /** Hard coded starting y-position pixel of scoreboard */
    private final int SY = 0;
    /** Starting x-point of progress bar */
    private int startingX;
    /** Starting y-point of progress bar */
    private int startingY;
    /** Percentage of course created */
    private int progressPercentage;
    /** Image to indicate progress player has made through course */
    private Image playerProgress;
    /** Progress bar image */
    private Image progressBar;

    /**
     * Progress bar constructor
     * @param startingX starting x-position on progress bar
     * @param startingY starting y-position on progress bar
     */
    public ProgressBar(int startingX, int startingY) {
        this.startingX = SX; // startingX;
        this.startingY = SY; // startingY;
        this.progressPercentage = startingX;
        init();
    }

    /**
     * Progress bar initialization
     */
    public void init() {
        try {
        playerProgress = new Image("res/misc/you.png");
        progressBar = new Image("res/misc/progress.png");
        } catch(SlickException e) {
            e.printStackTrace();
        }

    }

    /**
     * Update progress bar
     * @param xPos x-position of player in pixels
     * @param mapWidth map length in pixels
     */
    public void update(int xPos, int mapWidth) {
       float decimalProgress = startingX + ((float)xPos/mapWidth * (float)(progressBar.getWidth()*.95));
       progressPercentage = (int) decimalProgress;
    }

    /**
     * Renders progress bar
     */
    public void render() {
        progressBar.draw(startingX, startingY);
        playerProgress.draw(progressPercentage, 0);
    }
}
