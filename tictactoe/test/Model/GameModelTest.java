package Model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Model.GameModel;

public class GameModelTest {
    private GameModel gameModel;

    @Before
    public void setUp() {
        gameModel = new GameModel(); // Assumes default constructor is sufficient for tests.
    }

    @Test
    public void testSetMoveValid() {
        // Test a valid move
        assertTrue("Move should be placed", gameModel.setMove(0, 0));
        assertEquals("Cell should have player1 symbol", "X", gameModel.getCurrentPlayer());
    }

    @Test
    public void testSetMoveInvalid() {
        // Place a move
        gameModel.setMove(0, 0);
        // Try to place another move in the same spot
        assertFalse("Move should not be placed in the same spot", gameModel.setMove(0, 0));
    }


    @Test
    public void testSetMoveOutOfBounds() {
        // Attempt to place a move at an index equal to gridSize, which should be out of bounds
        System.out.println("Testing setMove with coordinates (" + gameModel.getGridSize() + ", 0)");
        boolean result1 = gameModel.setMove(gameModel.getGridSize(), 0);
        System.out.println("Expected false, got: " + result1);
        assertFalse("Move should not be placed out of bounds", result1);

        // Attempt to place a move at an index equal to gridSize on the y-axis, which should be out of bounds
        System.out.println("Testing setMove with coordinates (0, " + gameModel.getGridSize() + ")");
        boolean result2 = gameModel.setMove(0, gameModel.getGridSize());
        System.out.println("Expected false, got: " + result2);
        assertFalse("Move should not be placed out of bounds", result2);
    }

}

