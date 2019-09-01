package SetGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public static void testInitialize() {
        Game g = new Game();
        assertEquals(Game.board.size(), 12);
    }

    public static void main(String[] args) {
        testInitialize();
    }
}