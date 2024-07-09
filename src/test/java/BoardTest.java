import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testPlaceMarker() {
        // Positiver Test: Marker wird korrekt platziert
        board.place(0, 0, 'X');
        assertEquals('X', board.getCell(0, 0));
    }

    @Test
    public void testPlaceMarkerOccupiedCell() {
        // Negativer Test: Marker wird nicht auf eine bereits belegte Zelle platziert
        board.place(0, 0, 'X');
        board.place(0, 0, 'O');  // Sollte den Marker nicht überschreiben
        assertEquals('X', board.getCell(0, 0));
    }

    @Test
    public void testIsCellEmpty() {
        // Positiver Test: Zelle ist leer
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsCellNotEmpty() {
        // Negativer Test: Zelle ist nicht leer
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsFull() {
        // Positiver Test: Board ist voll
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testIsNotFull() {
        // Negativer Test: Board ist nicht voll
        board.place(0, 0, 'X');
        assertFalse(board.isFull());
    }

    @Test
    public void testClearBoard() {
        // Positiver Test: Board wird geleert
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testClearBoardNotEmpty() {
        // Negativer Test: Board wird geleert und Zelle ist nicht leer
        board.place(0, 0, 'X');
        board.clear();
        assertEquals(' ', board.getCell(0, 0));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPlaceMarkerInvalidPosition() {
        // Negativer Test: Platzieren eines Markers außerhalb des gültigen Bereichs
        board.place(3, 3, 'X');  // Sollte eine Ausnahme auslösen
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetCellInvalidPosition() {
        // Negativer Test: Abrufen einer Zelle außerhalb des gültigen Bereichs
        board.getCell(3, 3);  // Sollte eine Ausnahme auslösen
    }
}
