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
        assertEquals('X', game.getCurrentPlayer().getMarker());
    }

    @Test
    public void testSwitchCurrentPlayer() {
        game.switchCurrentPlayer();
        assertEquals('O', game.getCurrentPlayer().getMarker());
        game.switchCurrentPlayer();
        assertEquals('X', game.getCurrentPlayer().getMarker());
    }

    @Test
    public void testHasWinnerInRow() {
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'X');
        game.getBoard().place(0, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerInColumn() {
        game.getBoard().place(0, 0, 'O');
        game.getBoard().place(1, 0, 'O');
        game.getBoard().place(2, 0, 'O');
        game.switchCurrentPlayer();  // Ensure current player matches placed marker
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerInDiagonal() {
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(1, 1, 'X');
        game.getBoard().place(2, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testDraw() {
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
}
