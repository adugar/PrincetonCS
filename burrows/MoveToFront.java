/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Implements MoveToFront API using LinkedLists to remove
 *  and add elements. BinaryStdIn and BinaryStdOut are used for input
 *  and printing.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

import java.util.LinkedList;

public class MoveToFront {
    // stores number of ASCII characters
    private static final int R = 256;

    // apply move-to-front encoding, reading from stdin and writing to stdout
    public static void encode() {
        LinkedList<Character> ascii = new LinkedList<Character>();
        for (int i = 0; i < R; i++) {
            ascii.add((char) i);
        }
        while (!BinaryStdIn.isEmpty()) {
            char c = BinaryStdIn.readChar();
            int index = ascii.indexOf(c);
            BinaryStdOut.write(index, 8);
            ascii.remove(index);
            ascii.addFirst(c);
        }
        BinaryStdOut.flush();
    }

    // apply move-to-front decoding, reading from stdin and writing to stdout
    public static void decode() {

        LinkedList<Character> ascii = new LinkedList<Character>();
        for (int i = 0; i < R; i++) {
            ascii.add((char) i);
        }
        while (!BinaryStdIn.isEmpty()) {
            int index = BinaryStdIn.readChar();
            char c = ascii.remove(index);
            BinaryStdOut.write(c);
            ascii.addFirst(c);
        }
        BinaryStdOut.close();
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].equals("+")) {
            decode();
        }
        else {
            encode();
        }
    }

}
