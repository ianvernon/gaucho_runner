import org.newdawn.slick.*;


public class ProgressBar {
    private final int SX = 250;
    private final int SY = 0;
    private int startingX;
    private int startingY;
    private int progressPercentage;
    private Image playerProgress;
    private Image progressBar;

    public ProgressBar(int startingX, int startingY) {
        this.startingX = SX; // startingX;
        this.startingY = SY; // startingY;
        this.progressPercentage = startingX;
        init();
    }

    public void init() {
        try {
        playerProgress = new Image("res/misc/you.png");
        progressBar = new Image("res/misc/progress.png");
        } catch(SlickException e) {
            e.printStackTrace();
        }

    }

    public void update(int xPos, int mapWidth) {
       float decimalProgress = startingX + ((float)xPos/mapWidth * (float)(progressBar.getWidth()*.95));
       progressPercentage = (int) decimalProgress;
    }

    public void render() {
        progressBar.draw(startingX, startingY);
        playerProgress.draw(progressPercentage, 0);
    }
}
