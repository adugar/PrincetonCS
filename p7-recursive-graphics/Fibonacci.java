/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Computes and prints the first n Fibonacci numbers.
 *
 *                F(n) = F(n-1) + F(n-2) for n >= 2, with F(0) = 0 and F(1) = 1
 *
 *                WARNING: this program is spectacularly inefficient and is meant
 *                to illustrate a performance bug, e.g., set n = 45.
 *
 *                > java Fibonacci 7
 *                1: 1
 *                2: 1
 *                3: 2
 *                4: 3
 *                5: 5
 *                6: 8
 *                7: 13
 *
 *                Remarks
 *                -------
 *                - The 93rd Fibonacci number would overflow a long, but this
 *                will take so long to compute with this function that we
 *                don't bother to check for overflow.
 *                - Book Section 2.3
 *
 **************************************************************************** */

public class Fibonacci {

    // compute fibonacci(n)
    public static long fibonacci(int n) {
        // base case
        if (____)
            return ___

        // reductive step
        else
            return ______;
    }

    // main method
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        for (int i = 1; i <= n; i++)
            StdOut.println(i + ": " + fibonacci(i));
    }

}
