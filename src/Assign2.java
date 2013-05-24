import javax.swing.*;
import java.awt.*;

/**
 * User: FeliciousX
 * Date: 5/21/13
 * Time: 5:07 PM
 *
 * Assign2 is the main class that kick starts the whole program from the PSVM
 * Default configuration can be set here for future upgrade (If exists).
 */
public class Assign2 {
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private static int winningScore;
    private static int targetHealth;
    private static int playerHealth;
    private static int levelInterval;
    private static int missilePower;
    private static int missileSpeed;

    public static void main(String [] args) {
        getDefaultConfig();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                final int x = (SCREEN_SIZE.width - MainFrame.getMaxWidth()) / 2;
                final int y = (SCREEN_SIZE.height - MainFrame.getMaxHeight()) / 2;

                mainFrame.setLocation(x, y);
                mainFrame.setVisible(true);
            }
        });
    }

    public static Dimension getScreenSize() {
        return SCREEN_SIZE;
    }

    public static int getMissileSpeed() {
        return missileSpeed;
    }

    public static int getMissilePower() {
        return missilePower;
    }

    public static int getLevelInterval() {
        return levelInterval;
    }

    public static int getPlayerHealth() {
        return playerHealth;
    }

    public static int getTargetHealth() {
        return targetHealth;
    }

    public static int getWinningScore() {
        return winningScore;
    }

    private static void getDefaultConfig() {
        winningScore = DefaultConfig.getWinningScore();
        targetHealth = DefaultConfig.getTargetHealth();
        playerHealth = DefaultConfig.getPlayerHealth();
        levelInterval = DefaultConfig.getLevelInterval();
        missilePower = DefaultConfig.getMissilePower();
        missileSpeed = DefaultConfig.getMissileSpeed();
    }
}
