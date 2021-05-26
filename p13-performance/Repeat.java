/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Four methods, each of which produce a string of n
 * consecutive x's. (e.g., x, xx, xxx, xxxx)
 *
 * Note: Run this on the command line to get the correct results.
 *
 * Example: java-introcs -Xint Repeat 25000
 **************************************************************************** */

public class Repeat {

        // Experiment 1: returns a String of n consecutive x's
    public static String repeat1(int n) {
        String s = "";
        for (int i = 0; i < n; i++)
            s = s + "x";
        return s;
    }

        // Experiment 1: returns a String of n consecutive x's
    public static String repeat2(int n) {
        char[] temp = new char[n];
        for (int i = 0; i < n; i++)
            temp[i] = 'x';
        return new String(temp);
    }

        // Experiment 1: returns a String of n consecutive x's
    public static String repeat3(int n) {
        if (n == 0) return "";
        else if (n == 1) return "x";
        else return repeat3(n / 2) + repeat3(n - (n / 2));
    }


        // Experiment 1: returns a String of n consecutive x's
    public static String repeat4(int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++)
            sb.append("x");
        return sb.toString();
    }


        // Main client for running experiments
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        double startTime, endTime;
        String nConsecutiveExes;

                // experiment 1 - comment this one out to try others experiments
        startTime = System.currentTimeMillis();
        nConsecutiveExes = repeat1(n);
        endTime = System.currentTimeMillis();
        StdOut.println("Elapsed time for repeat1() = " +
                       (endTime - startTime) / 1000 + "s");

                // experiment 2
        startTime = System.currentTimeMillis();
        nConsecutiveExes = repeat2(n);
        endTime = System.currentTimeMillis();
        StdOut.println("Elapsed time for repeat2() = " +
                       (endTime - startTime) / 1000 + "s");


                // experiment 3
        startTime = System.currentTimeMillis();
        nConsecutiveExes = repeat3(n);
        endTime = System.currentTimeMillis();
        StdOut.println("Elapsed time for repeat3() = " +
                       (endTime - startTime) / 1000 + "s");


                // experiment 4
        startTime = System.currentTimeMillis();
        nConsecutiveExes = repeat4(n);
        endTime = System.currentTimeMillis();
        StdOut.println("Elapsed time for repeat4() = " +
                       (endTime - startTime) / 1000 + "s");
    }
}
