import java.util.Scanner;

public class TicTacToe {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] board = new char[3][3];
        char player = '○';
        int row, col;
        boolean playing = true;

        // Initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '－';
            }
        }

        // Game loop
        while (playing) {
            // Print board
            System.out.println("現在の盤面:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            // Get player input
            System.out.println("Player " + player + ", enter row and column (1-3): ");
            row = input.nextInt() - 1;
            col = input.nextInt() - 1;

            // Check if move is valid
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != '－') {
                System.out.println("Invalid move, try again.");
                continue;
            }

            // Make move
            board[row][col] = player;

            // Check for win
            if (board[0][0] == player && board[0][1] == player && board[0][2] == player ||
                board[1][0] == player && board[1][1] == player && board[1][2] == player ||
                board[2][0] == player && board[2][1] == player && board[2][2] == player ||
                board[0][0] == player && board[1][0] == player && board[2][0] == player ||
                board[0][1] == player && board[1][1] == player && board[2][1] == player ||
                board[0][2] == player && board[1][2] == player && board[2][2] == player ||
                board[0][0] == player && board[1][1] == player && board[2][2] == player ||
                board[0][2] == player && board[1][1] == player && board[2][0] == player) {
                System.out.println("Player " + player + " の勝ちです!");
                playing = false;
            }

            // Check for tie
            boolean tie = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == '－') {
                        tie = false;
                    }
                }
            }
            if (tie) {
                System.out.println("引き分け.");
                playing = false;
            }

            // Switch player
            if (player == '○') {
                player = '×';
            } else {
                player = '○';
            }
        }

        input.close();
    }
}
