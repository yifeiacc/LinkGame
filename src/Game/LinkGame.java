package Game;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 *  Modified by yifei on 16/9/27.
 * This class provides the text interface for the Link Game
 * <p>
 * The game is based directly on Smart Games' IQ-Link game
 * (http://www.smartgames.eu/en/smartgames/iq-link)
 */


public class LinkGame {
    /**
     * Determine whether a piece placement is well-formed according to the following:
     * - it consists of exactly three characters
     * - the first character is in the range A .. X
     * - the second character is in the range A .. L
     * - the third character is in the range A .. F if the second character is A, otherwise
     * in the range A .. L
     *
     * @param piecePlacement A string describing a piece placement
     * @return True if the piece placement is well-formed
     */
    static boolean isPiecePlacementWellFormed(String piecePlacement) {
        // Task 3: determine whether a piece placement is well-formed
        char[] placement = piecePlacement.toCharArray();
        if (placement.length != 3) return false;
        if (placement[0] < 'A' || placement[0] > 'X') return false;
        if (placement[1] < 'A' || placement[1] > 'L') return false;
        if (placement[1] == 'A') {
            if (placement[2] < 'A' || placement[2] > 'F') return false;
        } else {
            if (placement[2] < 'A' || placement[2] > 'L') return false;
        }
        return true;
    }

    /**
     * Determine whether a placement string is well-formed:
     * - it consists of exactly N three-character piece placements (where N = 1 .. 12);
     * - each piece placement is well-formed
     * - no piece appears more than once in the placement
     *
     * @param placement A string describing a placement of one or more pieces
     * @return True if the placement is well-formed
     */
    static boolean isPlacementWellFormed(String placement) {
        // Task 4: determine whether a placement is well-formed
        if (placement == null) {
            return false;
        }
        int nPiece = placement.length() / 3;
        if (nPiece < 1 || nPiece > 12 || nPiece * 3 != placement.length()) {
            return false;
        }
        boolean[] duplicated = new boolean[26];
        for (int i = 1; i < placement.length(); i += 3) {
            int peg = placement.charAt(i) - 'A';
            if (!isPiecePlacementWellFormed(placement.substring(i - 1, i + 2)) || duplicated[peg]) {
                return false;
            }
            duplicated[peg] = true;
        }
        return true;
    }

    /**
     * Return a array of peg locations according to which pegs the given piece placement touches.
     * The values in the array should be ordered according to the units that constitute the
     * piece.
     * The code needs to account for the origin of the piece, the piece shape, and the piece
     * orientation.
     *
     * @param piecePlacement A valid string describing a piece placement
     * @return An array of integers corresponding to the pegs which the piece placement touches,
     * listed in the normal order of units for that piece.   The value 0 corresponds to
     * peg 'A', 1 to peg 'B', etc.
     */
    static int[] getPegsForPiecePlacement(String piecePlacement) {
        // Task 6: determine the pegs touched by a piece placement
        // for line 1 and 3
        final int[][] odd_line_offsets = {
                {0, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}
        };
        // for line 0 and 2
        final int[][] even_line_offsets = {
                {0, -1}, {-1, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, -1}
        };
        int[] pegs = new int[3];
        int origin = piecePlacement.charAt(0) - 'A';
        int row = origin / 6, col = origin % 6;
        // find which one is the first
        Piece unRotated = Piece.get(piecePlacement.charAt(1) + "A");
        int cursor = 0;
        while (cursor < 6) {
            if (unRotated.getComponent(cursor) == null) {
                cursor++;
                continue;
            }
            break;
        }
        Piece piece = Piece.get(piecePlacement.substring(1, 3));
        int size = 6;
        pegs[1] = origin;
        int[][] offsets = (row % 2 == 0) ? even_line_offsets : odd_line_offsets;
        boolean first = true;
        int first_index, third_index;
        if (piecePlacement.charAt(2) - 'A' < 6) {
            first_index = 0;
            third_index = 2;
        } else {
            // flipped, first and third swapped
            first_index = 2;
            third_index = 0;
            cursor = (size - cursor) % size;
        }
        int checked = 0;
        while (checked < 2) {
            if (piece.getComponent(cursor) == null) {
                cursor++;
                continue;
            }
            int peg_row = row + offsets[cursor % size][0];
            int peg_col = col + offsets[cursor % size][1];
            int p = (peg_row < 0 || peg_row >= 4 || peg_col < 0 || peg_col >= 6) ?
                    -1 : peg_row * 6 + peg_col;
            if (first) {
                pegs[first_index] = p;
                first = false;
            } else {
                pegs[third_index] = p;
            }
            checked++;
            cursor++;
        }
        return pegs;
    }


    /**
     * Determine whether a placement is valid.  To be valid, the placement must be well-formed
     * and each piece must correctly connect with each other.
     *
     * @param placement A placement string
     * @return True if the placement is valid
     */
    static boolean isPlacementValid(String placement) {
        // Task 7: determine whether a placement is valid
        if (!LinkGame.isPlacementWellFormed(placement)) {
            return false;
        }
        Placement piecePlacement = new Placement();
        for (int i = 0; i < placement.length(); i += 3) {
            int origin = placement.charAt(i) - 'A';
            Piece piece = Piece.get(placement.substring(i + 1, i + 3));
            if (!piecePlacement.placePiece(piece, origin)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return an array of all solutions given a starting placement.
     *
     * @param placement A valid piece placement string.
     * @return An array of strings, each describing a solution to the game given the
     * starting point provied by placement.
     */
    static String[] getSolutions(String placement) {
        // Task 10: determine all solutions to the game, given a particular starting placement
        return getSolutions(placement, false);
    }

    // lazy mode returns only one solution, this lazy model is for gennerate hints
    public static String[] getSolutions(String placement, boolean lazy) {
        // using String placement to construct init Placement
        HashSet<Placement> L = new HashSet<>();
        Stack<Placement> PlacementStack = new Stack<>();
        if (placement.equals("")) {
            Placement begin1 = new Placement();
            PlacementStack.add(begin1);
        } else {
            Placement begin2 = new Placement(placement);
            PlacementStack.add(begin2);
        }

        // using DFS to search all the possible Placement
        while (PlacementStack.size() != 0) {
            Placement temp = PlacementStack.pop();
            if (temp.isCompleted()) {
                // System.out.println(temp);
                if (lazy) {
                    return new String[]{temp.toString()};
                }
                L.add(temp);
            } else {
                List<Placement> lists = temp.getsuss();
                PlacementStack.addAll(lists);
            }
        }
        // add result to a string arr
        String[] Sol = new String[L.size()];
        int i = 0;
        for (Placement plc : L) {
            Sol[i] = plc.toString();
            i++;
        }
        return Sol;
    }

    // load starting points
    public static String[][] startingList = new String[12][];
    static {
        try(BufferedReader br = new BufferedReader(new FileReader("starting.txt"))) {
            String line = br.readLine();
            int i = 1;
            ArrayList<String> starting = new ArrayList<>();
            while (line != null) {
                if (line.length() / 3 > i) {
                    LinkGame.startingList[i++] = starting.toArray(new String[0]);
                    starting = new ArrayList<>();
                }
                starting.add(line);
                line = br.readLine();
            }
        } catch (Exception e) {
            System.err.println("Error in read starting points");
            System.err.println(e);
        }
    }
//    public static String[][] startingList = StartingPoint.startList;

    public static String getStartingPoint(int difficulty) {
        // difficulty 0 - 7
        difficulty = difficulty < 0 ? 0 : difficulty;
        difficulty = difficulty > 7 ? 7 : difficulty;
        Random r = new Random();
        return startingList[10 - difficulty][r.nextInt(startingList[10 - difficulty].length)];
    }

    public static void main(String[] args) {
        for (String str : getSolutions("BGECBGGDFHKLJLHKAFKJALEFPFBSHBUCA")) {
            System.out.println(str);
        }
//        System.out.println(GenerateHits("BGECBGGDFHKLJLHKAFKJALEFPFBSHB"));
//
//        System.out.println(LinkGame.isPlacementValid("OEANLH"));
//        String start = args[0];
//        if (!isPlacementValid(start)) {
//            System.exit(1);
//        }
//        String[] allSolutions = getSolutions(start);
//        for (String s : allSolutions) {
//            System.out.println(s);
//        }
//        try {
//            PrintWriter writer = new PrintWriter("solutions" + start + ".txt", "UTF-8");
//            for (String s : allSolutions) {
//                writer.println(s);
//            }
//            writer.close();
//        } catch (Exception e) {
//            System.err.println(e);
//        }
    }
}
