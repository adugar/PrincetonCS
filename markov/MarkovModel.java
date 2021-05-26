public class MarkovModel {

    private static final int ASCII = 128;
    // one-argument freq method
    private final ST<String, Integer> st;
    // two-argument freq method
    private final ST<String, int[]> st2;
    // storing the order
    private final int order;

    // creates a Markov model of order k for the specified text
    public MarkovModel(String text, int k) {
        String str = "";
        order = k;
        str += text + text.substring(0, k);
        st = new ST<String, Integer>();
        st2 = new ST<String, int[]>();
        for (int i = 0; i < str.length() - k; i++) {
            String kgram = str.substring(i, i + k);
            if (!st.contains(kgram)) {
                st.put(kgram, 0);
            }
            st.put(kgram, st.get(kgram) + 1);
        }
        for (int i = 0; i < str.length() - k; i++) {
            String kgram = str.substring(i, i + k);
            if (!st2.contains(kgram)) {
                st2.put(kgram, new int[ASCII]);
            }
            st2.get(kgram)[str.charAt(i + k)]++;
        }
    }

    // returns the order k of this Markov model
    public int order() {
        return order;
    }

    // returns a string representation of the Markov model (as described below)
    public String toString() {
        String result = "";
        for (String key : st2.keys()) {
            result += key + ": ";
            int[] frequency = st2.get(key);
            for (int i = 0; i < frequency.length; i++) {
                if (frequency[i] != 0) {
                    result += ((char) i) + " " + frequency[i] + " ";
                }
            }
            result += "\n";
        }
        return result;
    }

    // returns the number of times the specified kgram appears in the text
    public int freq(String kgram) {
        if (kgram.length() != order) {
            throw new IllegalArgumentException(
                    "kgram's length must equal order!");
        }
        if (st2.contains(kgram)) {
            return st.get(kgram);
        }
        return 0;
    }

    // returns the number of times the character c follows the specified
    // kgram in the text
    public int freq(String kgram, char c) {
        if (kgram.length() != order) {
            throw new IllegalArgumentException(
                    "kgram's length must equal order!");
        }
        if (st2.contains(kgram)) {
            return st2.get(kgram)[c];
        }
        return 0;
    }

    // returns a random character that follows the specified kgram in the text,
    // chosen with weight proportional to the number of times that character
    // follows the specified kgram in the text
    public char random(String kgram) {
        if (kgram.length() != order) {
            throw new IllegalArgumentException("kgram must be of length k!");
        }
        if (!st2.contains(kgram)) {
            throw new IllegalArgumentException("kgram is not in text!");
        }
        double[] probabilities = new double[ASCII];
        int total = freq(kgram);

        int[] all = st2.get(kgram);

        for (int i = 0; i < all.length; i++) {
            probabilities[i] = (double) freq(kgram, (char) i) / total;
        }
        return (char) StdRandom.discrete(probabilities);
    }

    // tests this class by directly calling all instance methods
    public static void main(String[] args) {
        String text1 = "gagggagaggcgagaaa";
        MarkovModel model1 = new MarkovModel(text1, 2);
        int gCounter = 0;
        int aCounter = 0;
        int i = 0;
        StdOut.println(model1.order());
        StdOut.println(model1.freq("ga"));
        while (i < 1000) {
            if (model1.random("ga") == 'g') {
                gCounter++;
            }
            else if (model1.random("ga") == 'a') {
                aCounter++;
            }
            i++;
        }
        StdOut.println("G: " + gCounter);
        StdOut.println("A: " + aCounter);

    }
}
