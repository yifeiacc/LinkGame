package Game;

import java.util.*;

/**
 * Created by yifei on 16/9/15.
 * Class Placement and PiecePlacement
 * A Placement instance represents the status of a placement.
 * A placement instance contains the following status:
 * *      1. The status of all pegs on the board. Positions & vacant slots around pegs
 * *      2. Pieces that are already placed on the board,
 * including which piece is placed at which position
 * Two Placements are equal to each other
 * *  iff.
 * same pieces are placed at same positions in two placements;
 * the order in which pieces are placed dose not matter.
 * This can be guaranteed by storing all pieces in an ordered structure.
 */
public class Placement {
    private HashMap<Integer, Peg> pegs;
    // TreeSet is an ordered structure with no duplicated elements
    private TreeSet<PiecePlacement> piecePlaced;
    private static int MAX_PEGS = 24;

    public Placement() {
        this.piecePlaced = new TreeSet<>();
        this.pegs = new HashMap<>();
    }

    public Placement(String placement) {
        this.piecePlaced = new TreeSet<>();
        this.pegs = new HashMap<>();
        List<String> S = new ArrayList<>();
        for (int i = 0; i < placement.length() / 3; i++) {
            S.add(placement.substring(i * 3, i * 3 + 3)); // split string placement to pieces
        }
        for (int i = 0; i < S.size(); i++) {
            this.placePiece(Piece.get(S.get(i).substring(1, 3)), S.get(i).toCharArray()[0] - 'A'); // add piece to Placement
        }
    }

    // this method is to get the piece that haven't been placed
    public TreeSet<Character> pieceNotPlace() {
        TreeSet<Character> str = new TreeSet<>();
        for (int i = 0; i < 12; i++) {
            str.add((char) (i + 'A'));
        }
        for (PiecePlacement piecePlacement : this.piecePlaced) {
            str.remove(piecePlacement.getPlacementString().charAt(1));
        }
        return str;
    }

    // a refined version of pieceNotPlaced, used only in getSuccessor
    private char getNextToPlace() {
        HashSet<Character> placed = new HashSet<>();
        for (PiecePlacement p : this.piecePlaced) {
            placed.add(p.getPlacementString().charAt(1));
        }
        char c;
        for (c = 'A'; c <= 'L'; c++) {
            if (!placed.contains(c)) {
                break;
            }
        }
        return c;
    }

    // find out where a certain piece is placed
    // -1 will be returned if `piece` is not placed
    // NOTE that a piece in different orientations
    // will be considered as different Pieces
    private int wherePiecePlaced(Piece piece) {
        int origin = -1;
        for (PiecePlacement placement : this.piecePlaced) {
            if (placement.getPlacementString().substring(1, 3).equals(piece.getPieceID())) {
                origin = placement.getPlacementString().charAt(0) - 'A';
                break;
            }
        }
        return origin;
    }

    // this method should only called by placePiece and removePiece
    // the process of placing and removing a piece are quite similar
    // the only difference is to occupy a slot of a peg or to release it
    // setTo is used to indicate this
    private boolean placePiece(Piece piece, int origin, boolean setTo) {
        if (origin < 0 || origin >= MAX_PEGS) {
            return false;
        }
        // check origin position
        Peg center = this.pegs.get(origin);
        // clone it to avoid changing old peg
        center = (center == null ? new Peg() : center.clone());
        if (!(setTo ? center.occupy(piece.getCenter()) : center.free(piece.getCenter()))) {
            return false;
        }
        // find out which pegs the piece will also occupy
        int[] positions = {-1, -1};
        Component[] components = {null, null};
        int[] positionLookup = Peg.getNeighbour(origin);
        int j = 0;
        for (int i = 0; i < 6; i++) {
            Component pieceComponent = piece.getComponent(i);
            if (pieceComponent != null) {
                if (positionLookup[i] < 0 || positionLookup[i] >= MAX_PEGS) {
                    return false;
                }
                positions[j] = positionLookup[i];
                components[j] = pieceComponent;
                j++;
            }
        }
        // ... and for each component, check if it can occupy the peg
        Peg[] newPegs = {null, null};
        j = 0;
        for (int i = 0; i < 2; i++) {
            Peg newPeg = this.pegs.get(positions[i]);
            newPeg = (newPeg == null ? new Peg() : newPeg.clone());
            // if the component successfully occupy the peg, keep the peg instance
            if (setTo ? newPeg.occupy(components[i]) : newPeg.free(components[i])) {
                newPegs[j] = newPeg;
                j++;
            } else {
                return false;
            }
        }

        // now the piece has successfully occupy the pegs
        // update the hash map
        this.pegs.put(origin, center);
        this.pegs.put(positions[0], newPegs[0]);
        this.pegs.put(positions[1], newPegs[1]);
        return true;
    }

    // place a piece
    // if the piece can be placed successfully(which means no conflict),
    // the state will be updated and true will be returned;
    // otherwise nothing will be changed and false will be returned
    public boolean placePiece(Piece piece, int origin) {
        if (!this.placePiece(piece, origin, true)) {
            return false;
        } else {
            this.piecePlaced.add(new PiecePlacement(piece, origin));
            return true;
        }
    }

    // return values are similar to placePiece method
    // the placement is guaranteed to be valid,
    // which means a slot peg will never occupied by more that 1 piece
    // thus it is save to directly release slots the releasing piece is occupying
    public boolean removePiece(Piece piece) {
        int origin = wherePiecePlaced(piece);
        if (origin < 0) {
            return false;
        }
        if (!this.placePiece(piece, origin, false)) {
            return false;
        } else {
            this.piecePlaced.remove(new PiecePlacement(piece, origin));
            return true;
        }
    }

    public boolean rotatePiece(Piece piece, boolean counterClockwise) {
        Piece rotated = Piece.getRotated(piece, counterClockwise);
        Placement shadow = this.clone();
        int origin = wherePiecePlaced(piece);
        if (shadow.removePiece(piece)) {
            if (shadow.placePiece(rotated, origin)) {
                this.removePiece(piece);
                this.placePiece(rotated, origin);
                return true;
            } else return false;
        } else return false;
    }

    public boolean flipPiece(Piece piece) {
        Piece rotated = Piece.getFlipped(piece);
        Placement shadow = this.clone();
        int origin = wherePiecePlaced(piece);
        if (shadow.removePiece(piece)) {
            if (shadow.placePiece(rotated, origin)) {
                this.removePiece(piece);
                this.placePiece(rotated, origin);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isCompleted() {
        // a placement is completed
        // <==>
        // all pegs have been fully occupied
        // <==>
        // 12 pieces are successfully placed
        return this.piecePlaced.size() == ('L' - 'A' + 1);  // + 1: close interval
    }

    public int size() {
        return this.piecePlaced.size();
    }

    public void clear() {
        this.piecePlaced.clear();
        this.pegs.clear();
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        // a placement can be determined by a set of PiecePlacement
        // the PiecePlacements is stored in an ordered TreeSet
        // thus the ID of a placement becomes independent to the order in which
        // the pieces are placed
        String s = "";
        for (PiecePlacement p : this.piecePlaced) {
            s += p.toString();
        }
        return s;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Placement && this.hashCode() == other.hashCode();
    }

    @Override
    public Placement clone() {
        Placement newPlacement = new Placement();
        for (int i : this.pegs.keySet()) {
            newPlacement.pegs.put(i, this.pegs.get(i).clone());
        }
        for (PiecePlacement piecePlacement : this.piecePlaced) {
            PiecePlacement p = piecePlacement.clone();
            newPlacement.piecePlaced.add(p);
        }
        return newPlacement;
    }
    // this method is to get all next possible Placement.

    public List<Placement> getsuss() {
        List<Placement> result = new LinkedList<>();
        Placement tem = this.clone();
//        char nextPiece = this.pieceNotPlace().first();
        char nextPiece = this.getNextToPlace();
        Piece[] nextToPlace = Piece.PiecePool[nextPiece - 'A'];
        for (Piece piece : nextToPlace) {
            for (int i = 0; i < 24; i++) {
                if (((piece.canPlace & (1 << i)) != 0)
                        && tem.placePiece(piece, i)) {
                    result.add(tem.clone());
                    tem.removePiece(piece);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {

        Placement a = new Placement();
        a.placePiece(Piece.get("AA"), 1);
        a.placePiece(Piece.get("BA"), 7);
        System.out.println(a.getsuss());
        Placement x = new Placement();
        assert x.placePiece(Piece.get("JK"), 'I' - 'A');
        assert x.piecePlaced.size() == 1;
        assert !x.placePiece(Piece.get("JK"), 'I' - 'A');
        assert x.piecePlaced.size() == 1;
        assert x.removePiece(Piece.get("JK"));
        assert x.piecePlaced.size() == 0;
        assert !x.removePiece(Piece.get("JK"));
        assert x.piecePlaced.size() == 0;
        Placement y = new Placement();
        y.placePiece(Piece.get("EA"), 'O' - 'A');
        y.placePiece(Piece.get("LH"), 'N' - 'A');
//        y.placePiece(Piece.get("CA"), 'C' - 'A');
    }
}

/**
 * piece + placed -> PiecePlacement
 */
class PiecePlacement implements Comparable<PiecePlacement> {
    private Piece piece;
    private int origin;
    private String placementString = null;

    PiecePlacement(Piece toPlace, int origin) {
        this.piece = toPlace;
        this.origin = origin;
    }

    String getPlacementString() {
        if (this.placementString == null) {
            this.placementString =
                    (char) (this.origin + 'A') + this.piece.getPieceID();
        }
        return this.placementString;
    }

    @Override
    public int compareTo(PiecePlacement other) {
        // the order of two PiecePlacement is defined as the alphabet order of
        // their string representations
        return this.getPlacementString().compareTo(other.getPlacementString());
    }

    @Override
    public int hashCode() {
        return this.getPlacementString().hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof PiecePlacement && this.hashCode() == other.hashCode();
    }

    @Override
    public String toString() {
        // a PiecePlacement can be determined by these three chars
        return this.getPlacementString();
    }

    @Override
    public PiecePlacement clone() {
        return new PiecePlacement(this.piece, this.origin);
    }
}
