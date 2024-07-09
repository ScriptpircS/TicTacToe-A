import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeTest {

    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testInitialCurrentPlayer() {
        // Positiver Test: Initialer Spieler ist Player 1 ('X')
        assertEquals('X', game.getCurrentPlayer().getMarker());
    }

    @Test
    public void testSwitchCurrentPlayer() {
        // Positiver Test: Spielerwechsel funktioniert korrekt
        game.switchCurrentPlayer();
        assertEquals('O', game.getCurrentPlayer().getMarker());
        game.switchCurrentPlayer();
        assertEquals('X', game.getCurrentPlayer().getMarker());
    }

    @Test
    public void testHasWinnerInRow() {
        // Positiver Test: Überprüfung eines Gewinners in einer Reihe
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'X');
        game.getBoard().place(0, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerInColumn() {
        // Positiver Test: Überprüfung eines Gewinners in einer Spalte
        game.getBoard().place(0, 0, 'O');
        game.getBoard().place(1, 0, 'O');
        game.getBoard().place(2, 0, 'O');
        game.switchCurrentPlayer();  // Sicherstellen, dass der aktuelle Spieler dem gesetzten Marker entspricht
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerInDiagonal() {
        // Positiver Test: Überprüfung eines Gewinners in einer Diagonale
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(1, 1, 'X');
        game.getBoard().place(2, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testDraw() {
        // Negativer Test: Überprüfung eines Unentschiedens
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'O');
        game.getBoard().place(0, 2, 'X');
        game.getBoard().place(1, 0, 'X');
        game.getBoard().place(1, 1, 'O');
        game.getBoard().place(1, 2, 'X');
        game.getBoard().place(2, 0, 'O');
        game.getBoard().place(2, 1, 'X');
        game.getBoard().place(2, 2, 'O');
        assertFalse(game.hasWinner());
        assertTrue(game.getBoard().isFull());
    }

    @Test
    public void testInvalidMove() {
        // Negativer Test: Platzieren eines Markers auf einer bereits belegten Zelle
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 0, 'O');  // Versuch, auf derselben Zelle zu platzieren
        assertEquals('X', game.getBoard().getCell(0, 0));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testMakeMoveInvalidPosition() {
        // Negativer Test: Platzieren eines Markers außerhalb des gültigen Bereichs
        game.getBoard().place(3, 3, 'X');  // Sollte eine Ausnahme auslösen
    }

    @Test
    public void testMakeValidMove() {
        // Positiver Test: Platzieren eines Markers an einer gültigen Position
        game.getBoard().place(1, 1, 'X');
        assertEquals('X', game.getBoard().getCell(1, 1));
    }
}

