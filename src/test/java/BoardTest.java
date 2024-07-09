import org.junit.Test;
import static org.junit.Assert.*;
public class BoardTest {

    @Test
    public void testIsCellEmpty() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlaceMarker() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertEquals('X', board.getCell(0, 0));
    }

    @Test
    public void testIsFull() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testClear() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

}
