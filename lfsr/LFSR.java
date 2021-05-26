public class LFSR {
    // seed from constructor
    private String str;
    // tap from constructor, it is always the same
    private final int t;
    // stores the lfsr
    private int[] lfsr;

    // creates an LFSR with the specified seed and tap
    public LFSR(String seed, int tap) {
        str = seed;
        t = tap;
        lfsr = new int[seed.length()];
        for (int i = 0; i < lfsr.length; i++) {
            lfsr[i] = Integer.parseInt(Character.toString(seed.charAt(i)));
        }
    }

    // returns the number of bits in the LFSR.
    public int length() {
        return lfsr.length;
    }

    // returns bit i as 0 or 1.
    public int bitAt(int i) {
        return lfsr[length() - i];

    }

    // returns a string representation of this LFSR
    public String toString() {
        String s = "";
        for (int i : lfsr) {
            s += i;
        }
        return s;
    }

    // simulates one step of this LFSR and return the new bit as 0 or 1
    public int step() {
        String old = str;
        int xor = bitAt(length()) ^ bitAt(t);
        str = old.substring(1) + Integer.toString(xor);
        for (int i = 0; i < lfsr.length; i++) {
            lfsr[i] = Integer.parseInt(Character.toString(str.charAt(i)));
        }
        return xor;
    }

    // simulates k steps of this LFSR and return the k bits as a k-bit integer
    public int generate(int k) {
        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp = temp * 2;
            temp += step();
        }
        return temp;
    }

    // tests this class by directly calling all instance methods
    public static void main(String[] args) {
        LFSR lfsr = new LFSR("01101000010100010000", 17);
        StdOut.println(lfsr);
        StdOut.println(lfsr.length());
        StdOut.println(lfsr.bitAt(1));
        StdOut.println(lfsr.toString());
        StdOut.println(lfsr.step());
        StdOut.println(lfsr.generate(5));
    }
}

