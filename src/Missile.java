/**
 * User: FeliciousX
 * Date: 5/22/13
 * Time: 3:02 AM
 *
 * Missile class defines the missile object that is shot from the cannon.
 * It is a line drawn from 2 coordinate. (x1, y1) and (x2, y2)
 *
 */
public class Missile {

    private int speed, power;
    private double xPos, yPos, prevX, prevY, mouseX, mouseY;
    private boolean collided;

    public Missile(double mouseX, double mouseY) {
        this.setSpeed(Assign2.getMissileSpeed());
        this.setxPos(MissilePanel.MAX_WIDTH / 2);
        this.setyPos(MissilePanel.MAX_HEIGHT);
        this.setPrevX(xPos);
        this.setPrevY(yPos);
        this.setPower(Assign2.getMissilePower());
        this.mouseX = mouseX;
        this.mouseY = mouseY;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPrevY() {
        return (int) this.prevY;
    }

    public int getPrevX() {
        return (int) this.prevX;
    }

    public int getxPos() {
        return (int) this.xPos;
    }

    public int getyPos() {
        return (int) this.yPos;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getPower() {
        return this.power;
    }

    private void setSpeed(int speed) {
        this.speed = speed;
    }

    private void setxPos(double xPos) {
        this.xPos = xPos;
    }

    private void setyPos(double yPos) {
        this.yPos = yPos;
    }

    private void setPrevX(double prevX) {
        this.prevX = prevX;
    }

    private void setPrevY(double prevY) {
        this.prevY = prevY;
    }

    public boolean isCollided() {
        return this.collided;
    }

    public void setCollided(boolean collided) {
        this.collided = collided;
    }

    public void move() {
        // find gradient from equation  m = (y2 - y1) / (x2 - x1)
        double gradient = (MissilePanel.MAX_HEIGHT - mouseY) / ((MissilePanel.MAX_WIDTH / 2) - mouseX);
        // find yIntercept from equation y = mx + c
        double yIntercept = (MissilePanel.MAX_HEIGHT - gradient * (MissilePanel.MAX_WIDTH / 2));

        prevY = yPos;
        prevX = xPos;

        yPos -= speed;
        xPos = (yPos - yIntercept) / gradient;
    }


}
