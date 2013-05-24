import javax.swing.*;
import java.awt.*;

/**
 * User: FeliciousX
 * Date: 5/21/13
 * Time: 4:45 PM
 *
 * Simple JPanel that shows updates about the current status of the game.
 * Score and level
 */
public class StatusPanel extends JPanel {
    private static final int MAX_HEIGHT = 30;
    private static final int MAX_LENGTH = 600;

    private JLabel level, score;
    private Player player;

    public StatusPanel(Player player) {
        super();
        this.player = player;
        this.setPreferredSize(new Dimension(MAX_LENGTH, MAX_HEIGHT));
        this.setLayout(new FlowLayout());

        this.displayTextFields();
        this.setVisible(false);
    }

    public void displayTextFields() {
        JLabel healthLabel = new JLabel("Level:");
        healthLabel.setHorizontalAlignment(JLabel.RIGHT);

        level = new JLabel("" + player.getLevel());

        JLabel scoreLabel = new JLabel("Targets destroyed:");
        scoreLabel.setHorizontalAlignment(JLabel.RIGHT);

        score = new JLabel("0");

        healthLabel.setPreferredSize(new Dimension(70, MAX_HEIGHT));
        level.setPreferredSize(new Dimension(200, MAX_HEIGHT));
        scoreLabel.setPreferredSize(new Dimension(200, MAX_HEIGHT));
        score.setPreferredSize(new Dimension(70, MAX_HEIGHT));

        this.add(healthLabel);
        this.add(level);
        this.add(scoreLabel);
        this.add(score);
    }

    public void update() {
        this.score.setText("" + player.getScore());
        this.level.setText("" + player.getLevel());
    }
}
