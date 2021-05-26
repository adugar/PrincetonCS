/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  The function eq() takes two integer array arguments and returns
 *                true if they have the same length and all corresponding pairs
 *                of integers are equal.
 *
 *                The function id() takes two integer array arguments and returns
 *                true if they are identical, i.e., the same array reference,
 *                false otherwise.
 *
 *                > java ArrayCompares
 *                true
 *                false
 *                true
 *                false
 *                true
 *                
 *                true
 *                false
 *                false
 *                false
 *                true
 *
 *                                      Based on ArrayEquals from Section 2.1
 *
 **************************************************************************** */


public class ArrayCompares {

    // return true if two integer arrays have same length and all
    // corresponding pairs of integers are equal
    public static boolean eq(int[] a, int[] b) {

        // same length?
        __________

        // check each corresponding pair
        __________

        // all elements must be equal
        __________
    }

    // return true if two integer arrays are the same array reference
    public static boolean id(int[] a, int[] b) {
        return a == b;
    }


    // test client
    public static void main(String[] args) {
        int[] a = { 3, 1, 4, 1, 5 };
        int[] b = { 3, 1, 4, 1 };
        int[] c = { 3, 1, 4, 1, 5 };
        int[] d = { 2, 7, 1, 8, 2 };
        int[] e = a;

        StdOut.println(eq(a, a));
        StdOut.println(eq(a, b));
        StdOut.println(eq(a, c));
        StdOut.println(eq(a, d));
        StdOut.println(eq(e, a));
        StdOut.println();
        StdOut.println(id(a, a));
        StdOut.println(id(a, b));
        StdOut.println(id(a, c));
        StdOut.println(id(a, d));
        StdOut.println(id(e, a));

    }
}
