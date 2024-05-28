public class Board {
    private char[][] board;

    public Board() {
        board = new char[3][3];
    }

    public boolean isCellEmpty(int x, int y) {
        return board[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        board[x][y] = marker;
    }

    public boolean isFull() {
        int count = 0;
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
    public void print() { //Unbedingt überprüfen
        int count;
        for (int i = 0; i < 3; i++) {
            System.out.println("______\n");
            count = 0;
            for (int j = 0; j < 3; j++) {
                System.out.print("|");
                System.out.print(board[i][j]);
                count++;
                if (count == 3) {
                    System.out.print("|\n");
                }
            }
        }
        return;
    }
}
