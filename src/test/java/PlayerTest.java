import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testGetMarker() {
        // Positiver Test: Korrekte Rückgabe des Markers
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }

    @Test
    public void testToString() {
        // Positiver Test: Korrekte Rückgabe des String-Repräsentation des Spielers
        Player player = new Player('X');
        assertEquals("Player{marker=X}", player.toString());
    }

    @Test
    public void testInvalidMarker() {
        // Negativer Test: Spieler mit ungültigem Marker
        Player player = new Player(' ');
        assertEquals(' ', player.getMarker());
    }

    @Test
    public void testMarkerNotEqual() {
        // Negativer Test: Marker ist nicht gleich
        Player player = new Player('X');
        assertNotEquals('O', player.getMarker());
    }
}
