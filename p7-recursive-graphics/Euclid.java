/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Reads two command-line arguments p and q and computes the
 *                greatest common divisor of p and q using Euclid's algorithm.
 *
 **************************************************************************** */

public class Euclid {

    // recursive implementation
    public static int gcd(int p, int q) {
        // base case

        // reductive step
    }

    // non-recursive implementation
    public static int gcd2(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        // get command-line arguments
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);

        // compute the GCD of p & q using recursive method
        int d1 = gcd(p, q);

        // compute the GCD of p & q using non-recursive method
        int d2 = gcd2(p, q);

        // test - print results
        StdOut.println("gcd(" + p + ", " + q + ") = " + d1);
        StdOut.println("gcd(" + p + ", " + q + ") = " + d2);
    }
}
