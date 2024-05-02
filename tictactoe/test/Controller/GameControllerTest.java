package Controller;

import Model.GameModel;
import View.GameView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.JButton;

public class GameControllerTest {

    private GameController gameController;
    private Model.GameModel gameModel;
    private View.GameView gameView;

    @Before
    public void setUp() {
        gameModel = new GameModel();
        gameView = new GameView();
        gameController = new GameController(gameModel, gameView);
    }

    @Test
    public void testHandleButtonClick_ValidMove() {
        JButton[][] buttons = gameView.getButtons();

        // Perform a valid move on the first button
        JButton clickedButton = buttons[0][0];
        clickedButton.doClick(); // Simulate a button click

        // Check if the move was set correctly
        Assert.assertEquals("X", clickedButton.getText());
        Assert.assertEquals("O", gameModel.getCurrentPlayer()); // Player should switch after the move
        Assert.assertEquals("Current player: O", gameView.getPlayerDisplayText()); // Player display should update
    }

    @Test
    public void testHandleButtonClick_InvalidMove() {
        JButton[][] buttons = gameView.getButtons();

        // Perform a valid move on the first button
        JButton clickedButton = buttons[0][0];
        clickedButton.doClick(); // Simulate a button click

        // Try to perform another move on the same button
        clickedButton.doClick(); // Simulate another button click

        // Check if the move was not set (button text should remain the same)
        Assert.assertEquals("X", clickedButton.getText()); // Button text should not change
        Assert.assertEquals("O", gameModel.getCurrentPlayer()); // Player should not switch
        Assert.assertEquals("Current player: O", gameView.getPlayerDisplayText()); // Player display should remain the same
    }


}
