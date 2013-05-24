/**
 * User: FeliciousX
 * Date: 5/23/13
 * Time: 4:45 PM
 *
 * Player class defines a player.
 */
public class Player implements Comparable<Player> {

    private String name;
    private int health;
    private int score;
    private boolean win;

    // Player level determines the difficulty of the game
    private int level;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.level = 1;
        this.health = Assign2.getPlayerHealth();
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
        this.level = 1;
        this.health = Assign2.getPlayerHealth();
    }

    public Player() {
        this.name = "Anonymous";
        this.score = 0;
        this.level = 1;
        this.health = Assign2.getPlayerHealth();
    }

    @Override
    public int compareTo(Player other) {
        return other.getScore() - this.score;
    }
    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isWin() {
        return this.win;
    }

    public int getHealth() {
        return this.health;
    }

    public void damage() {
        this.health--;
    }

    public int getScore() {
        return this.score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + "," + this.score;
    }
}
