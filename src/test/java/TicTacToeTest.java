import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    private TicTacToe game;
    private Board board;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
        board = new Board();
    }


    //---------------------------Hier wurde von ChatGPT der Test der Methoden vorgeschlagen, doch es werden lauter private Methoden gebraucht
    @Test
    public void testSwitchCurrentPlayer() { //Private Methode --> Problem für Test
        Player initialPlayer = game.getCurrentPlayer();
        //game.switchCurrentPlayer();
        Player switchedPlayer = game.getCurrentPlayer();
        assertNotEquals(initialPlayer, switchedPlayer);
    }

    @Test
    public void testHasWinnerRows() { //Private Methode --> Problem für Test
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        //assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerColumns() { //Private Methode --> Problem für Test
        board.place(0, 0, 'O');
        board.place(1, 0, 'O');
        board.place(2, 0, 'O');
        //assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerDiagonals() { //Private Methode --> Problem für Test
        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');
        //assertTrue(game.hasWinner());
    }

    @Test
    public void testAskPlayAgainYes() { //Private Methode --> Problem für Test
        String input = "yes";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //assertTrue(game.askPlayAgain());
    }

    @Test
    public void testAskPlayAgainNo() { //Private Methode --> Problem für Test
        String input = "no";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //assertFalse(game.askPlayAgain());
    }

    @Test
    public void testMakeMoveValid() { //Private Methode --> Problem für Test
        String input = "0\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //game.makeMove();
        assertEquals('X', board.getCell(0, 0));
    }

    @Test
    public void testMakeMoveInvalid() { //Private Methode --> Problem für Test
        String input = "3\n3\n0\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //game.makeMove();
        assertEquals('X', board.getCell(0, 0));
    }
    //--------------- Ende der ChatGPT generierten Methoden

    //Normal ohne ChatGPT
    @Test
    void start() {
        TicTacToe ticTacToe = new TicTacToe();

        ticTacToe.start();

        //assertTrue(TicTacToe.getCell())
    }


}