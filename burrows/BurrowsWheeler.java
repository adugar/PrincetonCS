/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Implements BurrowsWheeler API. For inversetransform(), I used
 *  key-indexed counting as explained and implemented in the String Sorts
 *  lecture.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {
    // stores size of alphabet
    private static final int R = 256;

    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    public static void transform() {
        String str = BinaryStdIn.readString();
        CircularSuffixArray csa = new CircularSuffixArray(str);
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (csa.index(i) == 0) {
                BinaryStdOut.write(i);
                break;
            }
        }
        for (int i = 0; i < len; i++) {
            BinaryStdOut.write(str.charAt((csa.index(i) + len - 1) % len));
        }
        BinaryStdOut.flush();
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        char[] t = BinaryStdIn.readString().toCharArray();
        int len = t.length;
        int[] next = new int[len];
        int[] count = new int[R + 1];
        // from key-indexed counting demo slide:
        // https://www.cs.princeton.edu/courses/archive/spring19/cos226/
        // lectures/51StringSorts.pdf
        // count frequencies
        for (int i = 0; i < len; i++) {
            count[t[i] + 1]++;
        }
        // compute cumulates
        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }
        // move items
        for (int i = 0; i < len; i++) {
            next[count[t[i]]++] = i;
        }
        // copy back
        for (int i = 0; i < len; i++) {
            first = next[first];
            BinaryStdOut.write(t[first]);
        }
        BinaryStdOut.flush();
    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if (args[0].equals("+")) {
            inverseTransform();
        }
        else {
            transform();
        }
    }

}
