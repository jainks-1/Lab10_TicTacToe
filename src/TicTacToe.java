// Kaden Jain 3/28/2024
// Tic Tac Toe program


import java.util.Scanner;

public class TicTacToe {

    // create 2D array here so that it's visible to all methods
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String [][] board = new String[ROW][COL];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // declare all variables
        boolean finished = false; // determines to quit or start a new game
        boolean playing = true; // remains true as long as there's no win or tie
        String player = "X";
        int moveCount = 0; // tracks if game can end
        int row, col;
        final int MOVES_FOR_WIN = 5; // indicates the least number of moves required for a win
        final int MOVES_FOR_TIE = 9; // can't tie unless all 9 moves have happened

        // main loop to play
        do{

            // start a new game - Clear the board and set the player to X (since X always moves first)
            player = "X";
            playing = true;
            moveCount = 0;
            clearBoard();

            // breaks when there's a win or a tie
            do{
                do {  // loop until the converted player coordinates are a valid move which is an empty space on the board
                    showBoard();
                    // Get the coordinates for the move which should be 1 – 3 for the row and col
                    System.out.println("Enter move for " + player);
                    row = SafeInput.getRangedInt(in, "Enter row #: ", 1, 3);
                    col = SafeInput.getRangedInt(in, "Enter column #: ", 1, 3);

                    // Convert the player move coordinates to the array indices which are 0 – 2 by subtracting 1
                    row--;
                    col--;
                } while (!isValidMove(row, col));

                // record the valid move on the board
                board[row][col] = player;

                // increment the move counter
                moveCount++;

                // if appropriate check for a win or a tie
                if (moveCount >= MOVES_FOR_WIN && isWin(player)) {
                    System.out.println("Player " + player + " Wins!");
                    showBoard();
                    playing = false;
                } else if (moveCount == MOVES_FOR_TIE && isTie()) {
                    System.out.println("There was a tie!");
                    showBoard();
                    playing = false;
                } else {
                    // Toggle the player (i.e. X becomes O, O becomes X)
                    player = (player.equals("X")) ? "O" : "X";
                }
            } while (playing);

            finished = SafeInput.getYNConfirm(in, "Are you done playing?: ");
        } while (!finished);
    }

    // sets all board elements to a space
    private static void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " "; // makes cell a space
            }
        }
    }

    // displays the board
    private static void showBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                System.out.print(" " + board[row][col] + " "); // Print cells content
                if (col < COL - 1) {
                    System.out.print("|"); // column lines
                }
            }
            System.out.println();
        }
    }

    // returns true if there is a space at the given proposed move coordinates
    private static boolean isValidMove (int row, int col) {
        if (!board[row][col].equals(" ")) {  // Check if the spot is already occupied
            System.out.println("That space is already taken. Please choose another.");
            return false;
        }
        return true;
    }

    private static boolean isWin(String player) {
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
    }

    private static boolean isColWin(String player) {
        for (int col = 0; col < COL; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (board[row][col].equals(" ")) {
                    return false;
                }
            }
        }
        return true; // Board is full = no winner
    }
}