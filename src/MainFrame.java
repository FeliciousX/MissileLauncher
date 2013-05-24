import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * User: FeliciousX
 * Date: 5/21/13
 * Time: 3:20 PM
 *
 * MainFrame class is the frame that displays all the panel for the game.
 * That includes, the MissilePanel where the game is played,
 * Main Menu on top, and the Status Panel at the bottom.
 * Game is started when New Game on the MenuBar is selected.
 */
public class MainFrame extends JFrame {
    private static final int MAX_WIDTH = 607;
    private static final int MAX_HEIGHT = 583;

    private MissilePanel missilePanel;
    private StatusPanel statusPanel;
    private Container contentPane;

    private HighScore highScore;
    private Player player;

    public MainFrame() {
        this.setTitle("Missile Interceptor");
        this.setSize(MAX_WIDTH, MAX_HEIGHT);
        this.setResizable(false);

        MainMenu mainMenu = new MainMenu();
        this.setJMenuBar(mainMenu);

        highScore   = new HighScore();
        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
    }

    private void init() {
        contentPane.removeAll();
        statusPanel  = new StatusPanel(player);
        missilePanel = new MissilePanel(player, statusPanel, highScore);

        contentPane.add(missilePanel, BorderLayout.CENTER);
        contentPane.add(statusPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public static int getMaxWidth() {
        return MAX_WIDTH;
    }

    public static int getMaxHeight() {
        return MAX_HEIGHT;
    }

    private class MainMenu extends JMenuBar {

        public MainMenu() {

            JMenuItem newItem, exitItem, indexItem, aboutItem;
            JMenu fileMenu = new JMenu("File");
            fileMenu.setMnemonic('F');

            newItem = fileMenu.add(new HandleAction("New Game"));
            newItem.setMnemonic('N');

            exitItem = fileMenu.add(new HandleAction("Exit"));

            exitItem.setMnemonic('E');

            JMenu helpMenu = new JMenu("Help");
            helpMenu.setMnemonic('H');

            aboutItem = helpMenu.add(new HandleAction("About"));
            aboutItem.setMnemonic('A');
            helpMenu.add(aboutItem);

            indexItem = helpMenu.add(new HandleAction("Instruction"));
            indexItem.setMnemonic('I');
            helpMenu.add(indexItem);

            add(fileMenu);
            add(helpMenu);
        }

        private class HandleAction extends AbstractAction {
            public HandleAction(String name) { super(name); }

            @Override
            public void actionPerformed(ActionEvent event)
            {
                String action = getValue(Action.NAME).toString();

                if (action.equals("Exit"))
                    exitAction();
                else if (action.equals("New Game")) {
                    try {
                        newGameAction();
                    } catch (NullPointerException e) {
                        // Do nothing. User clicked Cancel. Wait for another command from user
                    }
                }
                else if (action.equals("About"))
                    aboutAction();
                else if (action.equals("Instruction"))
                    instructionAction();
            }

            private void exitAction() {
                System.exit(0);
            }

            // Starts the game
            private void newGameAction() throws NullPointerException {
                String name = JOptionPane.showInputDialog(null, "Enter your name: ", "", JOptionPane.INFORMATION_MESSAGE);

                if (name.equals("")) name = "Unknown";

                player = new Player(name);

                init();
                missilePanel.setVisible(true);
                statusPanel.setVisible(true);
                missilePanel.startGame();
            }
            private void aboutAction() {
                String about =
                        "<html><body><p align=\"center\">Author: Churchill Lee (FeliciousX)</p><br> " +
                        "<p align=\"center\">Email: 7436904@students.swinburne.edu.my</p></body></html>";
                JOptionPane.showMessageDialog(null, about, "About Me", JOptionPane.INFORMATION_MESSAGE);
            }
            private void instructionAction() {
                System.out.println(" selected.");
                String instruction =
                        "<html><body>" +
                                "<p>Click on File -> New Game to start the game!</p><br>" +
                                "<p>Use your mouse to control the cannon and mouse click to missiles at the falling bombs.</p><br>" +
                                "<p>Bombs take 2 hits to destroy.</p><br>" +
                                "<p>The level increases every 20 points.</p><br>" +
                                "<p>You only have 1 life. Missing 1 target will cause a game over.</p><br>" +
                                "<p>Score a total of 100 points to win!</p><br>" +
                        "</body></html>";

                JOptionPane.showMessageDialog(null, instruction, "Game Instruction", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
