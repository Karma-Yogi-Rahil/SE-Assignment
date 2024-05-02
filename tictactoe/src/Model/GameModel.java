package Model;

import Config.ConfigLoader;  // Ensure you have the ConfigLoader class in the right package

public class GameModel {
    private String[][] board;
    private String currentPlayer;
    private final String player1Symbol;
    private final String player2Symbol;
    private final int gridSize;

    public GameModel() {
        this.gridSize = ConfigLoader.getIntProperty("grid.size");
        this.player1Symbol = ConfigLoader.getProperty("player1.symbol");
        this.player2Symbol = ConfigLoader.getProperty("player2.symbol");
        this.board = new String[gridSize][gridSize];
        this.currentPlayer = player1Symbol;  // Start with player 1
        resetBoard();
    }

    // In GameModel.java
    public int getGridSize() {
        return this.gridSize;
    }


    // Resets the game board by clearing all cells
    public void resetBoard() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                board[i][j] = null;
            }
        }
        currentPlayer = player1Symbol;  // Reset to player 1
    }

    // Attempt to make a move at the specified location
    public boolean setMove(int x, int y) {
        if (x < 0 || x >= gridSize || y < 0 || y >= gridSize) {
            return false; // Out of bounds
        }

        if (board[x][y] == null) {  // Check if the cell is empty
            board[x][y] = currentPlayer;
            return true;
        }
        return false;
    }

    // Check if there is a winner or the game ends in a draw
    public String checkWinner() {
        // Check rows and columns for a win
        for (int i = 0; i < gridSize; i++) {
            if (board[i][0] != null && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]))
                return board[i][0];
            if (board[0][i] != null && board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]))
                return board[0][i];
        }

        // Check diagonals for a win
        if (board[0][0] != null && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))
            return board[0][0];
        if (board[2][0] != null && board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2]))
            return board[2][0];

        // Check for draw
        if (isDraw()) {
            return "Draw";
        }

        return null; // No winner yet
    }

    // Check if the game is a draw
    public boolean isDraw() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (board[i][j] == null) {
                    return false;  // If any cell is null, the game is not a draw
                }
            }
        }
        return true;  // All cells are filled and no winner, it's a draw
    }

    // Switches the current player from X to O, or O to X
    public void switchPlayer() {
        currentPlayer = currentPlayer.equals(player1Symbol) ? player2Symbol : player1Symbol;
    }

    // Get the current player
    public String getCurrentPlayer() {
        return currentPlayer;
    }
}
