package Controller;

import Model.GameModel;
import View.GameView;

import javax.swing.text.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class GameController {
    private GameModel model;
    private GameView view;





    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;

        // Set up the listener for all buttons
        this.view.setButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();  // Cast the source to a JButton
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (view.getButtons()[i][j] == clickedButton) {
                            if (model.setMove(i, j)) {  // Update the model if the move is valid
                                clickedButton.setText(model.getCurrentPlayer());  // Set the text to the current player's mark
                                if (model.checkWinner() != null) {  // Check if there is a winner
                                    view.updatePlayerDisplay("Winner: " + model.getCurrentPlayer());
                                    disableButtons();  // Optional: Disable all buttons if the game is over
                                } else if (model.isDraw()) {
                                    view.updatePlayerDisplay("Game ends in a draw");
                                    disableButtons();  // Optional: Disable all buttons if the game is a draw
                                } else {
                                    model.switchPlayer();  // Switch the turn to the next player
                                    view.updatePlayerDisplay("Current player: " + model.getCurrentPlayer());
                                }
                            }
                            return;  // Exit the loops and method once the button is found and handled
                        }
                    }
                }
            }
        });
    }


    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                view.getButtons()[i][j].setEnabled(false);
            }
        }
    }




}
