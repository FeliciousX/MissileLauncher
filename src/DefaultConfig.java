/**
 * User: FeliciousX
 * Date: 5/24/13
 * Time: 12:18 PM
 *
 * Default configuration is set here on a static class
 */
public class DefaultConfig {
    private static final int WINNING_SCORE = 100;
    private static final int TARGET_HEALTH = 100;
    private static final int PLAYER_HEALTH = 1;
    private static final int LEVEL_INTERVAL = 20;
    private static final int MISSILE_POWER = 50;
    private static final int MISSILE_SPEED = 5;

    public static int getWinningScore() {
        return WINNING_SCORE;
    }

    public static int getTargetHealth() {
        return TARGET_HEALTH;
    }

    public static int getPlayerHealth() {
        return PLAYER_HEALTH;
    }

    public static int getLevelInterval() {
        return LEVEL_INTERVAL;
    }

    public static int getMissilePower() {
        return MISSILE_POWER;
    }

    public static int getMissileSpeed() {
        return MISSILE_SPEED;
    }
}
