import java.util.Random;

/**
 * User: FeliciousX
 * Date: 5/22/13
 * Time: 2:29 AM
 *
 * Target class defines the bombs.
 */
public class Target {
    private static final int DIAMETER = 60;

    private int xPos, yPos, speed, health;

    public Target(int level)
    {
        this.health = Assign2.getTargetHealth();


        Random ran = new Random();
        this.yPos = 0;
        this.xPos = ran.nextInt(MissilePanel.MAX_WIDTH - Target.DIAMETER);
        this.speed = ran.nextInt(level) + 1;

    }

    public static int getDiameter() {
        return DIAMETER;
    }

    public int getHealth() {
        return this.health;
    }

    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return  this.yPos;
    }

    public void damage(int power) {
        this.health -= power;
    }

    public void move() {
        this.yPos += this.speed;
    }
}
