package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import Config.ConfigLoader;  // Ensure you have the ConfigLoader class

public class GameView {
    private JFrame frame;
    private JButton[][] buttons;
    private JTextArea playerDisplay;
    private int gridSize;  // Dynamic grid size

    public GameView() {
        // Load grid size from configuration file
        gridSize = ConfigLoader.getIntProperty("grid.size");

        buttons = new JButton[gridSize][gridSize];
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100 * gridSize, 100 * gridSize + 50);  // Adjust frame size based on grid size
        frame.setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(gridSize, gridSize));
        frame.add(boardPanel, BorderLayout.CENTER);

        playerDisplay = new JTextArea();
        frame.add(playerDisplay, BorderLayout.SOUTH);

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(100, 100));  // Standard button size
                boardPanel.add(buttons[i][j]);
            }
        }

        frame.setVisible(true);
    }

    public void setButtonListener(ActionListener listener) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                buttons[i][j].addActionListener(listener);
            }
        }
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    public void updatePlayerDisplay(String text) {
        playerDisplay.setText(text);
    }

    public String getPlayerDisplayText() {
        return playerDisplay.getText();
    }

}
