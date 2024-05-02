package Controller;

import Model.GameModel;
import View.GameView;
import Config.ConfigLoader;  // Make sure to implement this class

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {
    private GameModel model;
    private GameView view;
    private int gridSize;  // Grid size is now configurable

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.gridSize = ConfigLoader.getIntProperty("grid.size");  // Load grid size from configuration

        // Set up the listener for all buttons
        this.view.setButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();  // Cast the source to a JButton
                for (int i = 0; i < gridSize; i++) {
                    for (int j = 0; j < gridSize; j++) {
                        if (view.getButtons()[i][j] == clickedButton) {
                            handleButtonClick(i, j, clickedButton);
                            return;  // Exit the loops and method once the button is found and handled
                        }
                    }
                }
            }
        });
    }

    private void handleButtonClick(int i, int j, JButton clickedButton) {
        if (model.setMove(i, j)) {  // Update the model if the move is valid
            clickedButton.setText(model.getCurrentPlayer());  // Set the text to the current player's mark
            String winner = model.checkWinner();  // Check if there is a winner or a draw
            if (winner != null) {  // There's a winner or a draw
                if (winner.equals("Draw")) {
                    view.updatePlayerDisplay("Game ends in a draw");
                } else {
                    view.updatePlayerDisplay("Winner: " + winner);
                }
                disableButtons();  // Disable all buttons if the game is over
            } else {
                model.switchPlayer();  // Switch the turn to the next player
                view.updatePlayerDisplay("Current player: " + model.getCurrentPlayer());
            }
        }
    }

    private void disableButtons() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                view.getButtons()[i][j].setEnabled(false);
            }
        }
    }
}
