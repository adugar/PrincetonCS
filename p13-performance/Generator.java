/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: 
 *  Generate n random 32-bit ints and prints the resuts to
 *  standard output.
 *
 ******************************************************************************/

public class Generator {
    public static void main(String[] args) { 
        int n = Integer.parseInt(args[0]);
        for (int i = 0; i < n; i++) {
            int r = StdRandom.uniform(-500000000, 500000000);
            StdOut.println(r);
        }
    }

}
