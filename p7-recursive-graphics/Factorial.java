/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Takes an integer command-line argument n,
 *              and prints n! = 1 * 2 * ... * n to standard output.
 *
 * Examples:
 *              % java Factorial 0
 *              1
 *              % java Factorial 1
 *              1
 *              % java Factorial 5
 *              120
 *              % java Factorial 12
 *              479001600
 *              % java Factorial 20
 *              2432902008176640000
 *
 * Remarks:
 *             - Would overflow a long if n > 20
 *             - Need to use extended precision arithmetic to handle bigger
 *               factorials
 **************************************************************************** */

public class Factorial {

    // recursive method to find factorial
    // assumes n >= 0 and n <= 20
    public static int factorial(int n) {

        // base case
        if (n == 1)
            return 1;

        // reduction step
        return n * factorial(n - 1);
    }

    // main method
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(factorial(n));
    }
}
