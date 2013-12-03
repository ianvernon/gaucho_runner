import org.newdawn.slick.*;


public class Scoreboard {

    private int score = 0;
    private int numOfLives;
    private int timeFinished;
    private int numOfPowerUps;
    private int TIME_ALLOWED = 180;


    public Scoreboard() {

    }

    public void update(int sizeOfLivesList, int secondsToComplete, int sizeOfPowerUpsList) {
        setNumOfLives(sizeOfLivesList);
        setTimeFinished(secondsToComplete);
        setNumOfPowerUps(sizeOfPowerUpsList);
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRoundRect(0, 0, 225, 100, 10);
        g.setColor(Color.white);
//        g.drawString("Score: " + score, 650, 550);

    }

    public void setNumOfLives(int value) {
        this.numOfLives = value;
    }

    public int getNumOfLives() {
        return numOfLives;
    }

    public void setTimeFinished(int value) {
         this.timeFinished = value;
    }

    public int getTimeFinished() {
        return timeFinished;
    }

    public void setNumOfPowerUps(int value) {
        this.numOfPowerUps = value;

    }

    public int getNumOfPowerUps() {
        return numOfPowerUps;
    }

    public int calculateScore() {

        score += numOfLives * 500;
        score += ((TIME_ALLOWED - timeFinished)*(TIME_ALLOWED - timeFinished));
        score += numOfPowerUps * 50;

        return score;
    }
}
