import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getMarker() {
        Player player1 = new Player('X');
        Player player2 = new Player('Y');
        Player player3 = new Player('U');
        Player player4 = new Player('5');

        assertEquals('X', player1.getMarker());
        assertEquals('Y', player2.getMarker());
        assertEquals('U', player3.getMarker());
        assertEquals('5', player4.getMarker());
        assertNotEquals('X', player4.getMarker());
    }

    @Test
    void testToString() {
    }
}