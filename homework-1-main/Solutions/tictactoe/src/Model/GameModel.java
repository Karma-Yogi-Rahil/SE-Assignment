package Model;

public class GameModel {
    private String[][] board;
    private String currentPlayer;

    public GameModel() {
        board = new String[3][3];
        currentPlayer = "X"; // X starts by default
        resetBoard();
    }

    // Resets the game board by clearing all cells
    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = null;
            }
        }
        currentPlayer = "X"; // Reset player to X
    }

    // Attempt to make a move at the specified location
    public boolean setMove(int x, int y) {
        if (board[x][y] == null) { // Check if the cell is empty
            board[x][y] = currentPlayer;
            return true;
        }
        return false;
    }

    // Check if there is a winner or the game ends in a draw
    public String checkWinner() {
        // Check rows and columns for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != null && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]))
                return board[i][0];
            if (board[0][i] != null && board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]))
                return board[0][i];
        }

        // Check diagonals for a win
        if (board[0][0] != null && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))
            return board[0][0];
        if (board[0][2] != null && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]))
            return board[0][2];

        // Check for draw
        if (isDraw()) {
            return "Draw";
        }

        return null; // No winner yet
    }

    // Check if the game is a draw
    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    return false; // If any cell is null, the game is not a draw
                }
            }
        }
        return true; // All cells are filled and no winner, it's a draw
    }

    // Switches the current player from X to O, or O to X
    public void switchPlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    // Get the current player
    public String getCurrentPlayer() {
        return currentPlayer;
    }
}
