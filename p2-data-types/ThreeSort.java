/* **************************************************************************
 * Description: Reads three integer command line arguments and prints
 * them in ascending order.
 *
 * Hint: Don't use conditionals for this; use Math.min() and Math.max().
 *
 * Example:
 * % java ThreeSort 17 50 33
 * 17
 * 33
 * 50                                       (This is Book Exercise 1.2.34.)
 **************************************************************************** */


public class ThreeSort {
    public static void main(String[] args) {

        // command-line input
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        // compute the order
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int middle = a + b + c - min - max;




        // output in ascending order
        System.out.println(min);
        System.out.println(middle);
        System.out.println(max);
    }
}
