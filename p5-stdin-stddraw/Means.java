/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:   Write a program Means that takes a command-line input N and
 *                 then reads in N double values from standard input. It should
 *                 print out several means (averages) of the numbers, which we
 *                 define below:
 *                  let x1, x2, ... xN denote the numbers.
 *                     the arithmetic mean is (x1 + x2 + ... + xN) / N
 *                     the geometric mean is (x1 * x2 * ... * xN) ^ (1/N)
 *                     the harmonic mean is N/(1/x1 + 1/x2 + ... + 1/xN)
 *
 *                 Print all three of these means out. In order that the means
 *                 are well-defined, you may assume the inputs are positive. We
 *                 will provide the output format for you to round to three
 *                 decimal places.
 *
 *                 For example, java Means 5 with standard input
 *                    1.0 2.0 3.0 4.0 5.0
 *                 outputs
 *                     Arithmetic mean: 3.000
 *                     Geometric mean: 2.605
 *                     Harmonic mean: 2.190
 *                 
 *                 Use Math.pow to compute the exponent.
 *
 **************************************************************************** */

public class Means {
    public static void main(String[] args) {

        // get n from command-line
        int n = Integer.parseInt(args[0]);

        // initialize sums
        double sum = 0;          // running sum
        double prod = ___;       // running product
        double recipsum = ___;   // running sum of reciprocals

        // input data and compute values
        for (int i = 0; i < n; i++) {
     
        }

                // set the means
        double arithmetic = sum / n;
        double geometric = Math.pow(prod, 1.0 / n);
        double harmonic = n / recipsum;

                // print the values
        StdOut.printf("Arithmetic mean: %.3f\n", arithmetic);
        StdOut.printf("Geometric mean: %.3f\n", geometric);
        StdOut.printf("Harmonic mean: %.3f\n", harmonic);
    }

}
