import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testGetMarker() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }

    @Test
    public void testToString() {
        Player player = new Player('X');
        assertEquals("Player{marker=X}", player.toString());
    }
}
