package Game;


/**
 * Created by yifei on 16/9/15.
 * Instead of using an array of boolean, using a byte to record which
 * slot has been occupied. This is much more efficient then using array
 * because there is no indexing / allocating operations any more instead we can
 * use bitwise operations instead. Also it is space-efficient.
 */
public class Peg {
    public static final int nSlots = 7;
    // use 7 bits to indicate whether each slot is occupied
    // from low to high:
    // 0 ~ 5 : A, B, ..., F
    // 6 : center
    private byte slots = 0;
    // each peg has 7 slots around it
    // 6 for rings and 1 for ball, 6 surrounding and 1 in the central

    private static final int nRow = 4;
    private static final int nCol = 6;
    // used by method getNeighbour
    // for line 1 and 3
    private static final int[][] odd_line_offsets = {
            {0, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}
    };
    // for line 0 and 2
    private static final int[][] even_line_offsets = {
            {0, -1}, {-1, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, -1}
    };
    private static final int[][] neighbourLookup = new int[nRow * nCol][nSlots - 1];

    static {
        for (int position = 0; position < nRow * nCol; position++) {
            int row = position / Peg.nCol;
            int col = position % Peg.nCol;
            int[][] offset = (row % 2 == 0 ? Peg.even_line_offsets : Peg.odd_line_offsets);
            for (int i = 0; i < Peg.nSlots - 1; i++) {
                int row_offset = offset[i][0];
                int col_offset = offset[i][1];
                if (row + row_offset < 0 || row + row_offset >= Peg.nRow
                        || col + col_offset < 0 || col + col_offset >= Peg.nCol) {
                    neighbourLookup[position][i] = -1;
                } else {
                    neighbourLookup[position][i]
                            = (row + row_offset) * Peg.nCol + (col + col_offset);
                }
            }
        }
    }

    public Peg() {
        // no need to initialize again
        // this.slots = 0;
    }

    // will *NOT* check if range of index is valid
    public boolean isOccupied(int index) {
        return (this.slots & (1 << index)) != 0;
    }

    // setTo == true:  occupy the slot
    // setTo == false: release the slot
    public boolean setOccupy(int index, boolean setTo) {
        if (this.isOccupied(index) == setTo) {
            // setTo == true -> to occupy -> the slot should not be occupied already
            // setTo == false -> to release -> should already be occupied
            return false;
        } else {
            // just need to revert slot-th bits
            // note that 1 ^ 1 = 0, 0 ^ 1 = 1, which means a ^ 1 = ~a
            // and 1 ^ 0 = 1, 0 ^ 0 = 0, which means a ^ 0 = a
            // so we just need to perform slot ^ (00001000)2 to revert 4th bit
            this.slots ^= (1 << index);
            return true;
        }
    }

    public boolean occupy(Component component) {
        // thanks to the similar representations of Peg and Component
        // we are able to check whether a component can be placed
        // and place it if valid
        byte componentByte = component.getByte();
        // we know that if a ^ 1 = ~a, for any a \in {0, 1}
        // so this.slots ^ componentByte will revert all bits at the positions
        // where it is 1 in componentByte
        // if it is valid to place a component then all those bits (in slots)
        // reverted just now will be 1 now. vice versa.
        // That means if we revert these bits and get the same result with directly
        // setting these bits to 1, the component is able to be placed on the peg
        // otherwise not valid.
        // So all we need to do is to check whether
        // this.slots ^ componentByte == this.slots | componentByte
        // holds. If this holds, the placement is valid for the component and peg
        // and we should update this.slots to this.slots | componentByte.
        // Otherwise it is invalid to place and we should directly return false.
        if ((this.slots ^ componentByte) == (this.slots | componentByte)) {
            this.slots |= componentByte;
            return true;
        } else {
            return false;
        }
    }

    public boolean free(Component component) {
        // similar to `occupy` method
        // the difference is,
        // in occupy method, we check if the result of reverting is same as
        // that of directly setting bits to 1
        // in this free method, we need to check if the reverting version is same
        // as directly setting bits to 0
        // so we need to use
        // this.slots & ( ~componentByte )
        // to set bits to 0
        // this is the only difference, other parts are totally same
        byte componentByte = component.getByte();
        if ((this.slots ^ componentByte) == (this.slots & ~componentByte)) {
            this.slots &= ~componentByte;
            return true;
        } else {
            return false;
        }
    }

    public static int[] getNeighbour(int pos) {
        return neighbourLookup[pos];
    }

    @Override
    public int hashCode() {
        return this.slots;
    }

    @Override
    public String toString() {
        return String.format("Peg with occupation: %s. Hash: %s",
                Integer.toBinaryString(this.slots), this.hashCode());
    }

    @Override
    public Peg clone() {
        Peg newPeg = new Peg();
        newPeg.slots = this.slots;
        return newPeg;
    }
}
