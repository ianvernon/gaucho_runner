import org.newdawn.slick.*;


public class ProgressBar {

    private int startingX;
    private int startingY;
    private int progressPercentage;
    private Image playerProgress;
    private Image progressBar;

    public ProgressBar(int startingX, int startingY) {
        this.startingX = startingX;
        this.startingY = startingY;
        this.progressPercentage = startingX;
        init();
    }

    public void init() {
        try {
        playerProgress = new Image("res/misc/TrollFace.png");
        progressBar = new Image("res/misc/rainbow_flag.png");
        } catch(SlickException e) {
            e.printStackTrace();
        }

    }

    public void update(int xPos, int mapWidth) {
       float decimalProgress = startingX + ((float)xPos/mapWidth * progressBar.getWidth());
       progressPercentage = (int) decimalProgress;
    }

    public void render() {
        progressBar.draw(startingX, startingY);
        playerProgress.draw(progressPercentage, 0);
    }
}
