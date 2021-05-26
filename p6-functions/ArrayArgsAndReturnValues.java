/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Typical code for implementing functions with array
 *                arguments or return values.  Based on pp 207-210
 *
 *                Example:
 *
 *                > java-introcs ArrayArgsAndReturnValues
 *                4 1.0 2.0 3.0 4.0
 *                4 9.0 8.0 7.0 6.0
 *                Array a: 1.0, 2.0, 3.0, 4.0,
 *                Array b: 9.0, 8.0, 7.0, 6.0,
 *                The max value of array a: 4.0
 *                The max value of array b: 9.0
 *                The dot product of array a and b: 70.0
 *                Array a before exchange: 1.0 2.0 3.0 4.0
 *                Array a after exchange:  3.0 2.0 1.0 4.0
 *
 *
 **************************************************************************** */

public class ArrayArgsAndReturnValues {
    // from standard input, first read number of double values, n, and
    // then input n double values, storing in an array;
    // returns the array of values
    public static double[] readDouble() {
        // read n
        int n = StdIn.readInt();

        // create the array
        double[] values = _____

        // input n values into array
        for (int i = 0; i < n; i++)
            values[i] = _______

        // return the array
        ________
    }

    // output a double array to standard output
    public static _____ writeDouble() {
        for (___________)
            StdOut.print(___________);
        StdOut.println();
    }

    // find the maximum of the array values
    public static _____ max(double[] values) {

        // assume maximum is initially the smallest possible double
        double maximum = Double.NEGATIVE_INFINITY;

        // look at each value and compare
        for (int i = 0; i < values.length; i++)
            if (values[i] > maximum)
                maximum = values[i];
        return maximum;

    }

    // exchange the values of two elements in an array
    public static _____ exchange(double[] values, int i, int j) {
        ______________
    }

    // return the dot product of two equal sized arrays
    public static double dot(double[] a, double[] b) {
        _____________

    }

    // main client with test cases
    public static void main(String[] args) {
        // input two arrays - same size
        double[] a = readDouble();
        double[] b = readDouble();

        // continue of same size
        if (a.length == b.length) {

            // output the arrays
            StdOut.print("Array a: ");
            writeDouble(a);
            StdOut.print("Array b: ");
            writeDouble(b);

            // find and print the max
            StdOut.println("The max value of array a: " + max(a));
            StdOut.println("The max value of array b: " + max(b));

            // find and print the dot product
            StdOut.println("The dot product of array a and b: " + dot(a, b));

            // swap the first and third elements of array a
            StdOut.print("Array a before exchange: ");
            writeDouble(a);
            exchange(a, 0, 2);
            StdOut.print("Array a after exchange:  ");
            writeDouble(a);

        }

    }
}
