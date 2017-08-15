package Game;

/**
 * Created by yifei on 16/9/30.
 * * Modified by yifei on 16/10/2.
 * This Piece class will use the byte represented Component class
 * Each Piece contains an array of component (length of 7) and an ID (two chars)
 * The Piece class is designed under varied singleton.
 * All pieces (144 in total) will be initialized when the class is loaded
 * The get method will return a reference to a certain piece rather than create
 * a new one
 * Enum is not the best choice because there are too many pieces : (
 */
public class Piece {
    private String ID;
    private Component[] components;
    public int canPlace = 0;

    private static final int N = 7;
    private static final int nTypes = 12;
    static final Piece PiecePool[][] = new Piece[nTypes][nTypes];

    // initialize all pieces
    static {
        String[][] pieceDescription = new String[][]{
                {"AA", "RBC|6", "BD|0", "BA|3",},
                {"BA", "R|6", "BD|0", "RC|3",},
                {"CA", "R|6", "BD|0", "RB|3",},
                {"DA", "R|6", "BD|0", "RE|2",},
                {"EA", "R|6", "BD|0", "RA|2",},
                {"FA", "R|6", "BD|0", "RB|2",},
                {"GA", "RF|6", "BD|0", "BF|2",},
                {"HA", "R|6", "RB|0", "RC|2",},
                {"IA", "BAB|6", "BD|0", "RB|1",},
                {"JA", "BAB|6", "BD|0", "RA|1",},
                {"KA", "RE|6", "BD|0", "BE|1",},
                {"LA", "RE|6", "BD|0", "RD|1",},
        };
        int p = 0;
        for (String[] description : pieceDescription) {
            int i = 0;
            // piece A
            Piece piece = new Piece(description[0], description[1], description[2], description[3]);
            do {
                PiecePool[p][i] = piece;
                piece = piece.rotateClockwise();
            } while (++i < nTypes / 2);
            piece = piece.flip();
            do {
                PiecePool[p][i] = piece;
                piece = piece.rotateClockwise();
            } while (++i < nTypes);
            p++;
        }
    }

    static {
        Placement empty = new Placement();
        for (int i = 0; i < nTypes; i++) {
            for (int j = 0; j < nTypes; j++) {
                for (int k = 0; k < 24; k++) {
                    if (empty.placePiece(PiecePool[i][j], k)) {
                        PiecePool[i][j].canPlace |= (1 << k);
                        empty.removePiece(PiecePool[i][j]);
                    }
                }
            }
        }
    }

    private Piece(String ID, String c1, String c2, String c3) {
        this.components = new Component[Piece.N];
        for (int i = 0; i < components.length; i++) {
            components[i] = null;
        }
        this.ID = ID;
        String[] des;
        des = c1.split("\\|");
        this.components[Integer.parseInt(des[1])] = new Component(des[0]);
        des = c2.split("\\|");
        this.components[Integer.parseInt(des[1])] = new Component(des[0]);
        des = c3.split("\\|");
        this.components[Integer.parseInt(des[1])] = new Component(des[0]);
    }

    /**
     * This one is functioning as a private clone method
     */
    private Piece(Piece piece) {
        this.ID = piece.ID;
        this.components = new Component[Piece.N];
        for (int i = 0; i < Piece.N; i++) {
            if (piece.components[i] != null) {
                this.components[i] = piece.components[i].clone();
            }
        }
    }

    /**
     * Will create a new piece
     *
     * @return a new piece rotated clockwise
     */
    private Piece rotateClockwise() {
        Piece p = new Piece(this);
        char pieceName = this.ID.charAt(0);
        // first handle with ID
        int newOrientation = this.ID.charAt(1) - 'A';
        // then get ID after the rotation
        if (newOrientation >= 6) {
            newOrientation -= 6;
            newOrientation = (newOrientation + 1) % 6;
            newOrientation += 6;
        } else {
            newOrientation = (newOrientation + 1) % 6;
        }
        p.ID = String.format("%c%c", pieceName, (char) (newOrientation + 'A'));
        // then rotate components
        for (int i = 0; i < Piece.N; i++) {
            if (p.components[i] != null) {
                p.components[i].rotateClockwise();
            }
        }
        Component tmp = p.components[0];
        p.components[0] = p.components[5];
        p.components[5] = p.components[4];
        p.components[4] = p.components[3];
        p.components[3] = p.components[2];
        p.components[2] = p.components[1];
        p.components[1] = tmp;
        return p;
    }

    /**
     * Similar to clockwise
     *
     * @return a new piece rotated counter clockwise
     */
    private Piece rotateCounterClockwise() {
        Piece p = new Piece(this);
        char pieceName = this.ID.charAt(0);
        // first handle with ID
        int newOrientation = this.ID.charAt(1) - 'A';
        // then get ID after the rotation
        if (newOrientation >= 6) {
            newOrientation -= 6;
            newOrientation = (newOrientation - 1 + 6) % 6;
            newOrientation += 6;
        } else {
            newOrientation = (newOrientation - 1 + 6) % 6;
        }
        p.ID = String.format("%c%c", pieceName, (char) (newOrientation + 'A'));
        // then rotate components
        for (int i = 0; i < Piece.N; i++) {
            if (p.components[i] != null) {
                p.components[i].rotateCounterClockwise();
            }
        }
        Component tmp = p.components[0];
        p.components[0] = p.components[1];
        p.components[1] = p.components[2];
        p.components[2] = p.components[3];
        p.components[3] = p.components[4];
        p.components[4] = p.components[5];
        p.components[5] = tmp;
        return p;
    }

    /**
     * Return a new piece flipped
     *
     * @return a new piece flipped
     */
    private Piece flip() {
        char pieceName = this.ID.charAt(0);
        int oldOrientation = this.ID.charAt(1);
        Piece p = new Piece(this);
        int needToRotateBack =
                oldOrientation < 'G' ? oldOrientation - 'A' : oldOrientation - 'G';
        // first roll back to the A or G, counter clockwise
        for (int i = 0; i < needToRotateBack; i++) {
            p = p.rotateCounterClockwise();
        }
        // then flip
        for (Component c : p.components) {
            if (c != null) {
                c.flip();
            }
        }
        // and swap
        Component tmp = p.components[1];
        p.components[1] = p.components[5];
        p.components[5] = tmp;
        tmp = p.components[2];
        p.components[2] = p.components[4];
        p.components[4] = tmp;
        // update ID
        p.ID = String.format("%c%c", pieceName,
                (char) ((p.ID.charAt(1) - 'A' + 6) % 12) + 'A');
        // and rotate to correct piece
        for (int i = 0; i < needToRotateBack; i++) {
            p = p.rotateCounterClockwise();
        }
        return p;
    }

    public static Piece get(String piece) {
        return Piece.PiecePool[piece.charAt(0) - 'A'][piece.charAt(1) - 'A'];
    }

    public static Piece getRotated(Piece piece, boolean counterClockwise) {
        char pieceName = piece.ID.charAt(0);
        int newOrientation = piece.ID.charAt(1) - 'A';
        if (counterClockwise) {
            if (newOrientation < 6) {
                newOrientation = (newOrientation - 1 + 6) % 6;
            } else {
                newOrientation -= 6;
                newOrientation = (newOrientation - 1 + 6) % 6;
                newOrientation += 6;
            }
        } else {
            if (newOrientation < 6) {
                newOrientation = (newOrientation + 1) % 6;
            } else {
                newOrientation -= 6;
                newOrientation = (newOrientation + 1) % 6;
                newOrientation += 6;
            }
        }
        return Piece.get(String.format("%c%c", pieceName, (char) (newOrientation + 'A')));
    }

    public static Piece getFlipped(Piece piece) {
        char pieceName = piece.ID.charAt(0);
        int newOrientation = piece.ID.charAt(1) - 'A';
        int rotated = newOrientation % 6;
        if (rotated == 0) {
            newOrientation = (newOrientation + 6) % 12;
        } else {
            if (newOrientation < 6) {
                newOrientation = 12 - rotated;
            } else {
                newOrientation = 6 - rotated;
            }
        }
        return Piece.get(String.format("%c%c", pieceName, (char) (newOrientation + 'A')));
    }

    public String getPieceID() {
        return this.ID;
    }

    public Component getCenter() {
        return this.components[6];
    }

    public Component getComponent(int index) {
        return this.components[index];
    }

    @Override
    public String toString() {
        return this.ID;
    }

    public static void main(String[] args) {
//        Piece c = new Piece("AA||RBC|6||BD|0||BA|3");
    }
}
