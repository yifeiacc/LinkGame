package Game;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by baiyinshuo on 16/9/22.
 */
public class PlacementTest {
    @Test
    public void orderIndependent() throws Exception {
        Random r = new Random();
        Placement p1 = new Placement();
        Placement p2 = new Placement();
        int n = 10;
        for (int i = 0; i < n; i++) {
            String placement = TestUtility.PLACEMENTS[r.nextInt(TestUtility.PLACEMENTS.length)];
            String shuffled = TestUtility.shufflePlacement(placement);
            p1.clear();
            p2.clear();
            for (int j = 0; j < placement.length() / 3; j++) {
                Piece piece = Piece.get(placement.substring(j * 3 + 1, j * 3 + 3));
                assertTrue("Piece should be placed successfully, but not",
                        p1.placePiece(piece, placement.charAt(j * 3) - 'A'));
            }
            for (int j = 0; j < shuffled.length() / 3; j++) {
                Piece piece = Piece.get(shuffled.substring(j * 3 + 1, j * 3 + 3));
                assertTrue("Piece should be placed successfully, but not",
                        p2.placePiece(piece, shuffled.charAt(j * 3) - 'A'));
            }
            assertTrue("Placement should be order-independent, but not",
                    p1.equals(p2));
        }
    }

    // placePiece, removePiece and isCompleted are tested
    @Test
    public void placeThenRemove() throws Exception {
        Placement placement = new Placement();
        Random r = new Random();
        int n = 10;
        for (int i = 0; i < n; i++) {
            String p = TestUtility.PLACEMENTS[r.nextInt(TestUtility.PLACEMENTS.length)];
            for (int j = 0; j < p.length() / 3; j++) {
                String pieceStr = p.substring(j * 3 + 1, j * 3 + 3);
                Piece piece = Piece.get(pieceStr);
                assertTrue("Piece should be placed successfully, but not",
                        placement.placePiece(piece, p.charAt(j * 3) - 'A'));
            }
            assertTrue("The placement should be completed, but not", placement.isCompleted());
            for (int j = 0; j < p.length() / 3; j++) {
                Piece piece = Piece.get(p.substring(j * 3 + 1, j * 3 + 3));
                assertTrue("Piece should be removed successfully, but not",
                        placement.removePiece(piece));
            }
        }
    }

    @Test
    public void flipTest() throws Exception {
        Placement placement = new Placement();
        placement.placePiece(Piece.get("AA"), 3);
        assertTrue(placement.flipPiece(Piece.get("AA")));
        assertFalse(placement.flipPiece(Piece.get("AA")));
    }
}