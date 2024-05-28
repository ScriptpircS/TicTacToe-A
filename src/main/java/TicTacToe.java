public class TicTacToe {
    private Player player1 = new Player('X');
    private Player player2 = new Player('O');
    private Player currentPlayer = player1;
    private Board board = new Board();

    public TicTacToe TicTacToe() {
        //???
        return TicTacToe.this;
    }

    public void start() {
        //Code-Magic um das Spiel zum laufen zu bringen
    }

    public void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean hasWinner() {
        //Boardlogik magisch umsetzen
        //Muss ein Symbol bis 3 Zählen in Zeile/Spalte/Diagonale
        //--> 3 Mal seperat überprüfen?
        return false;
    }
}
