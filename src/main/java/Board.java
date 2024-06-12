public class Board {
    private char[][] board;

    public Board() {
        board = new char[3][3];
        clear(); // Initialize the board with spaces
    }

    public boolean isCellEmpty(int x, int y) {
        return board[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        board[x][y] = marker;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /*
        -------
        |X| |O|
        | |X|X|
        |X|O|O|
        -------
     */
    public void print() { // unbedingt testen
        System.out.println("-------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
            System.out.println("-------");
        }
    }

    public char getCell(int x, int y) {
        return board[x][y];
    }
}
