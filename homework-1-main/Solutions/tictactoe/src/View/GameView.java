package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameView {
    private JFrame frame;
    private JButton[][] buttons ;
    private JTextArea playerDisplay;

    public GameView() {
        buttons = new JButton[3][3];
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(300, 300));
        frame.setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        frame.add(boardPanel, BorderLayout.CENTER);

        playerDisplay = new JTextArea();
        frame.add(playerDisplay, BorderLayout.SOUTH);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(100, 100));
                boardPanel.add(buttons[i][j]);
            }
        }

        frame.setVisible(true);
    }

    public void setButtonListener(ActionListener listener) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
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

}
