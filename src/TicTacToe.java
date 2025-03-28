// use getRangedInt to get values between 1 and 3
// use getYNConfirm to see if the user wants to play again

import java.util.Scanner;


public class TicTacToe {

    // create 2D array here so that it's visible to all methods
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String [][] board = new String[ROW][COL];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // int rowMove = SafeInput.getRangedInt();
        // int colMove = SafeInput.getRangedInt();



    }

    // sets all board elements to a space
    private static void clearBoard() {
        for (int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++)
            {
                board[row][col] = " "; // make this cell a space
            }
        }
    }

    // displays the board
    private static void showBoard() {
        for (int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++)
            {
                board[row][col] = " "; // make this cell a space
            }
        }
    }
}