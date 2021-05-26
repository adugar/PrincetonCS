// Please do not attempt Part 2 until you have submitted your solution to Part 1.
// You cannot get credit for Part 1 unless your solution to Part 1 COMPILES AND IS CORRECT.
// There is no partial credit for Part 2.

public class BestSlidingMatch {
    public static int similarity(String a, String b) {
        // YOUR CODE HERE
        int N = Math.min(a.length(), b.length());
        // initialize counter that will count number of similar characters
        int counter = 0;
        for (int i = 0; i < N; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                counter++; // increment counter if equal
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        // REPLACE THE ABOVE WITH YOUR CODE
        // AFTER GETTING similarity() WORKING
        // initialize cmd line argument variable, stringMax variable and max.
        String input = args[0];
        String stringMax = "";
        int max = 0;
        while (!StdIn.isEmpty()) {
            String next = StdIn.readString();
            int simValue = similarity(input, next);
            // if simValue is greater than the max, set both next
            // and simValue equal to max and stringMax.
            if (simValue > max) {
                max = simValue;
                stringMax = next;
            }
        }
        if (max == 0) { // If there is no max, then only print 0
            StdOut.println("0");
        }
        // If there is a max, print both the max and the string
        // associated with it
        else {
            StdOut.println("Answer: " + max + " " + stringMax);
        }
    }
}
