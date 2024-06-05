import java.util.Scanner;

public class TicTacToe {
    private Player player1 = new Player('X');
    private Player player2 = new Player('O');
    private Player currentPlayer = player1;
    private Board board = new Board();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        board.clear();
        currentPlayer = player1;
        play();
    }

    private void play() {
        while (!board.isFull()) {
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());
            makeMove();
            if (hasWinner()) {
                board.print();
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                return;
            }
            switchCurrentPlayer();
        }
        board.print();
        System.out.println("It's a draw!");
    }

    private void makeMove() {
        System.out.print("Enter row (0-2): ");
        int row = scanner.nextInt();
        System.out.print("Enter column (0-2): ");
        int col = scanner.nextInt();
        if (board.isCellEmpty(row, col)) {
            board.place(row, col, currentPlayer.getMarker());
        } else {
            System.out.println("That cell is already occupied! Try again.");
            makeMove();
        }
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean hasWinner() {
        // Implement logic to check for a winner
        return false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}