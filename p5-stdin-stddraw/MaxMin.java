/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Reads integers from standard input and prints the maximum
 *              and minimum of those values to standard output.  Assume there
 *              is at least one integer.
 *
 * Compilation:  javac-introcs MaxMin.java
 * Execution:    java-introcs MaxMin
 *   -- input required from standard input
 *   -- use Ctrl-d (Mac) or Ctrl-z <enter> (Windows) for EOF
 *
 *  % java-introcs MaxMin
 *  23 45 17 56 32
 *  89 10 53 32 34
 *  16
 *  Ctrl-d / Ctrl-z <enter>
 *  maximum = 89, minimum = 10               (This is book exercise 1.5.1.)
 **************************************************************************** */


public class MaxMin {
    public static void main(String[] args) {

        // first value read initializes min and max
        System.out.println("Hello");
        int max = StdIn.readInt();
        int min = StdIn.readInt();

        // read in the data, keep track of min and max
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();

            max = Math.max(value, max);
            min = Math.min(value, min);
        }

        // output
        StdOut.println("max = " + max + "   min = " + min);
    }
}
