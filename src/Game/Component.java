package Game;

/**
 * Created by yifei on 16/9/29.
 * Inspired by how we represent a Peg, we use the similar way to represent
 * a component of a piece. Same as Peg, a component is divided into 7 parts,
 * 6 for circle and 1 for central ball. By using the same representation as Peg,
 * it will be quite efficient to determine where a component can be placed on a
 * peg. Difference between rings and balls is eliminated in this abstract
 * representation because all we need to consider is how it will act when placed
 * on a peg. Rotation and flip are completed by circular shifts and bitwise swaps
 * respectively.
 */
public class Component {
    // similar to Peg
    // 6 for a ring and 1 for central ball
    private static final int nParts = 7;
    // 0 ~ 6 bits indicate if there is something at correspond position
    // 0 ~ 5 : circle
    // 6 : central ball
    private byte parts = 0;

    public Component(String description) {
        if (description.charAt(0) == 'R') {
            // construct a ring
            // first set to a full ring
            this.parts = 0b00111111;
            // then set the parts correspond to gaps to 0
            for (char c : description.substring(1).toCharArray()) {
                // for example gap is at D
                // then we will set this.parts to 0b00110111
                // first c = 'D' and c - 'A' is 4
                // 1 << (c - 'A')   is 0b00001000
                // ~(1 << (c - 'A') is 0b11110111
                // perform bitwise and will force 4th bit to zero, no matter what it was
                this.parts &= ~(1 << (c - 'A'));
            }
        } else if (description.charAt(0) == 'B') {
            // first construct a ball
            this.parts = 0b01000000;
            // then there is one (or two) connections for a ball
            // set these bits to 1
            for (char c : description.substring(1).toCharArray()) {
                // perform bitwise or will force some certain bits to one
                this.parts |= (1 << (c - 'A'));
            }
        } else {
            // this should not be reached
            // give a warning in stderr rather than throw an exception
            // this may help with performance
            System.err.println("Unexpected description for a component: " + description);
        }
    }

    public void rotateClockwise() {
        // when perform a rotation on a component
        // we just need to rotate part 0 to 5
        // the central part will not change obviously
        // the connection of a ball can be considered as the gap of a ring
        // thus all we need is to perform a circular right shift on 0 ~ 5 low bits (clockwise)
        // or a circular left shift on 0 ~ 5 for counter clockwise rotation
        // circular bitwise shift (left shift for example):
        // parts = 0b abcdefgh
        // parts & 0b00111111 -> 0b00cdefgh (denote as x)
        // x << 1  ->  0b0cdefgh0
        // x >> 5  ->  0b0000000c
        // (x << 1) | (x >> 5) & 0b00111111 ->  0b00defghc
        // (parts & 0b11000000)  ->  0b ab000000
        // (parts & 0b11000000) | (((x << 1) | (x >> 5)) & 0b00111111)
        // -> 0b ab defghc
        // a circular left shift is correspond to a clockwise rotation
        byte x = (byte) (this.parts & 0b00111111);
        this.parts = (byte) ((this.parts & 0b11000000) | (((x << 1) | (x >> 5)) & 0b00111111));
    }

    public void rotateCounterClockwise() {
        // this is similar to clockwise version
        // the difference is a counter-clockwise corresponds to a circular right shift
        // just swap 1 and 5 in clockwise version and it will work
        // parts = 0b abcdefgh
        // parts & 0b00111111 -> 0b00cdefgh (denote as x)
        // x >> 1  ->  0b000cdefg
        // x << 5  ->  0bfgh00000
        // (x << 1) | (x >> 5) & 0b00111111 ->  0b00hcdefg
        // (parts & 0b11000000)  ->  0b ab000000
        // (parts & 0b11000000) | (((x << 1) | (x >> 5)) & 0b00111111)
        // -> 0b ab hcdefg
        byte x = (byte) (this.parts & 0b00111111);
        this.parts = (byte) ((this.parts & 0b11000000) | (((x >> 1) | (x << 5)) & 0b00111111));
    }

    public void flip() {
        // again, when flip a component, we do not need to consider the central part
        // also part 0 and part 3 (the left most part and the right most part) will stay still
        // thus 1 <-> 5 and 2 <-> 4 is all we need to do
        // first swap bit 1 and bit 5
        this.parts = swapBits(this.parts, (byte) 1, (byte) 5);
        // then bit 2 and 4
        this.parts = swapBits(this.parts, (byte) 2, (byte) 4);
    }

    private byte swapBits(byte x, byte i, byte j) {
        // swap the i-th and j-th bits in x (i, j = 0, 1, ...)
        // first we need to check if i-th bit and j-th bit are different
        // (x & (1 << i) >>> i) is the i-th bit in x (shifted to position 0)
        // (x & (1 << j) >>> j) is the j-th bit in x (shifted to position 0)
        // XOR is 1 iff. these two bits are different
        // if so, just revert i-th and j-th bits in x respectively
        // if they are equal, just return x
        // to revert i-th bit in x:
        // set x to x ^ (1 << i)
        if ((((x & (1 << i)) >>> i) ^ ((x & (1 << j)) >>> j)) == 1) {
            x ^= (1 << i);
            x ^= (1 << j);
        }
        return x;
    }

    public byte getByte() {
        return this.parts;
    }

    /**
     * Just for grammar purpose. Used in clone method
     */
    public Component() {
    }

    @Override
    public Component clone() {
        Component c = new Component();
        c.parts = this.parts;
        return c;
    }

    @Override
    public String toString() {
        return Integer.toBinaryString(this.parts);
    }
}

