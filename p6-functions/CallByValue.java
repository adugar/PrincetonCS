/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Demonstrates call by value for primitive types and reference
 *                types (e.g., arrays)
 *
 **************************************************************************** */

public class CallByValue {
    // function that takes an int as an argument and multiplies it by 2
    public static void method1(int a) {
        a = 2 * a;
    }

    // function that takes an int array as argument and multiples the
    // first element by 2 (assume at least one element in the array)
    public static void method2(int[] b) {
        b[0] = 2 * b[0];
    }

    // function that takes an int array as argument and changes the array
    // reference
    public static void method3(int[] b) {
        int n = b.length;
        b = new int[n];    // set argument to a new array
    }

    // main test client
    public static void main(String[] args) {

        // test method 1
        int x = 10;
        StdOut.println("Before method1, x = " + x);
        method1(x);
        StdOut.println("After  method1, x = " + x);


        // test method 2
        int[] y = new int[1];
        y[0] = 10;
        StdOut.println("Before method2, y[0] = " + y[0]);
        method2(y);
        StdOut.println("After  method2, y[0] = " + y[0]);

        // test method 3
        int[] z = new int[1];
        z[0] = 100;
        StdOut.println("Before method3, z[0] = " + z[0]);
        method3(z);
        StdOut.println("After  method3, z[0] = " + z[0]);

        // test method 1 using array z
        StdOut.println("Before method1, z[0] = " + z[0]);
        method1(z[0]);
        StdOut.println("After  method1, z[0] = " + z[0]);


    }
}
