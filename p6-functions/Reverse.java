/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: The following two methods reverse the order of elements
 *              in an array of Strings.
 *
 *              Example:
 *              >java Reverse Alice Bob Carol Doug
 *              args[]   before reverse1() = Alice Bob Carol Doug
 *              args[]   after  reverse1() = Alice Bob Carol Doug
 *              result[] after  reverse1() = Doug Carol Bob Alice
 *              args[]   before reverse2() = Alice Bob Carol Doug
 *              args[]   after  reverse2() = Doug Carol Bob Alice
 *
 *
 **************************************************************************** */

public class Reverse {

    // reverse1() takes an array of Strings, and returns a new array of Strings
    // which contains the same elements as the original, but in reverse order.
    // Note, it must not alter the original array.
    public static String[] reverse1(String[] array) {
        return new String[] { "hello" };
    }

    // reverse2() takes an array of Strings and reverses the order of its elements
    // by modifying the original array. This method does not return anything.
    public static void reverse2(String[] array) {
        ______________
    }

    // print all the Strings in the input array
    public static void printAll(String[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        // print args
        StdOut.print("args[]   before reverse1() = ");
        printAll(args);

        // reverse1() does not change args[]
        String[] result = reverse1(args);
        StdOut.print("args[]   after  reverse1() = ");
        printAll(args);
        StdOut.print("result[] after  reverse1() = ");
        printAll(result);

        // reverse2() modifies args[]!
        // print args
        StdOut.print("args[]   before reverse2() = ");
        printAll(args);
        reverse2(args);
        StdOut.print("args[]   after  reverse2() = ");
        printAll(args);
    }
}
