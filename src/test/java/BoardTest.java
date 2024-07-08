import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    public Board setup() { //Alternativ um nicht immer ein neues Board zu erstellen
        // X O X
        // O X O
        // O O O
        Board board = new Board();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i + j % 2 == 1) {
                    board.place(i,j,'X');
                } else {
                    board.place(i,j,'O');
                }
            }
        }
        return board;
    }

    @Test
    void when_isCellEmpty_then_should_return_false() {
        Board board = setup();

        boolean empty = board.isCellEmpty(1,1);

        assertFalse(empty);
    }

    @Test
    void when_isCellEmpty_then_should_return_true() {
        Board board = new Board();

        boolean empty = board.isCellEmpty(1,0);

        assertTrue(empty);
    }

    @Test
    void when_place_in_correct_position_then_should_return_true() {
        Board board = new Board();

        board.place(1,1,'X');
        board.place(0,2,'O');

        assertEquals('X', board.getCell(1,1));
        assertEquals('O', board.getCell(0,2));
    }

    @Test
    void when_place_in_wrong_position_then_should_throw_OutOfBoundsError() {
        Board board = new Board();

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> board.place(1,3,'X'));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> board.place(-1,2,'X'));
    }

    @Test
    void when_board_isFull_then_should_return_true() {
        Board board = setup();

        assertTrue(board.isFull());
    }

    @Test
    void when_board_isFull_then_should_return_false() {
        Board board = new Board();

        assertFalse(board.isFull());
    }

    @Test
    void clear() {
        Board board = setup();

        assertTrue(board.isFull());
        board.clear();
        assertFalse(board.isFull());
    }

    @Test
    void print() {
        Board board = setup();

        board.print();

        //assert
    }

    @Test
    void getCell() {
        Board board = setup();

        assertEquals('O', board.getCell(0,0));
        assertEquals('X', board.getCell(0,1));
        assertEquals('O', board.getCell(0,2));
        assertEquals('X', board.getCell(1,0));
        assertEquals('O', board.getCell(1,1));
        assertEquals('X', board.getCell(1,2));
        assertEquals('O', board.getCell(2,0));
        assertEquals('O', board.getCell(2,1));
        assertEquals('O', board.getCell(2,2));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> board.getCell(-1,-3));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> board.getCell(0,3));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> board.getCell(-1,2));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> board.getCell(2,-2));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> board.getCell(6,0));
    }
}
