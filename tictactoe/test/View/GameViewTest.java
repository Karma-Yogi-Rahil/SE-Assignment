package View;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class GameViewTest {

    private GameView gameView;

    @Before
    public void setUp() {
        // Mock grid size as 3 for simplicity
        gameView = new GameView();
    }

    @Test
    public void testSetButtonListener() {
        // Create a simple implementation of ActionListener
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Do nothing for the test
            }
        };

        // Call setButtonListener with the ActionListener implementation
        gameView.setButtonListener(actionListener);

        // Retrieve buttons from GameView
        JButton[][] buttons = gameView.getButtons();

        // Verify that the ActionListener is added to each button
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                JButton button = buttons[i][j];
                // Get the registered ActionListeners and verify that the ActionListener is added
                ActionListener[] actionListeners = button.getActionListeners();
                Assert.assertEquals(1, actionListeners.length);
                Assert.assertEquals(actionListener, actionListeners[0]);
            }
        }
    }
}
