public class BestMatch {
    public static int similarity(String a, String b) {
        // YOUR CODE HERE
        int N = Math.min(a.length(), b.length());
        // initialize counter that will count number of similar characters
        int numMatches = 0;
        for (int i = 0; i < b.length() - a.length(); i++) {
            for (int j = 0; i < N; j++) {
                if (a.charAt(j + i) == b.charAt(j)) {
                    numMatches++; // increment counter if equal
                }
            }
        }
        return numMatches;
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
            StdOut.println(max + " " + stringMax);
        }

    }
}
