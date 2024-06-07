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
        char marker = currentPlayer.getMarker();
        for (int i = 0; i < 3; i++) {
            // Check rows and columns
            if ((board.getCell(i, 0) == marker && board.getCell(i, 1) == marker && board.getCell(i, 2) == marker) ||
                    (board.getCell(0, i) == marker && board.getCell(1, i) == marker && board.getCell(2, i) == marker)) {
                return true;
            }
        }
        // Check diagonals
        return (board.getCell(0, 0) == marker && board.getCell(1, 1) == marker && board.getCell(2, 2) == marker) ||
                (board.getCell(0, 2) == marker && board.getCell(1, 1) == marker && board.getCell(2, 0) == marker);
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}