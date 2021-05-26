public class TextGenerator {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        String text = StdIn.readAll();
        MarkovModel mm = new MarkovModel(text, k);
        String initialKgram = text.substring(0, k);
        StdOut.print(initialKgram);
        // using a stringbuilder for concatenation
        StringBuilder sb = new StringBuilder();
        char randomC;
        for (int i = 0; i < t - k; i++) {
            // generating random character using kgram
            randomC = mm.random(initialKgram);
            sb.append(randomC);
            initialKgram += randomC;
            // updating kgram to store last k characters
            initialKgram = initialKgram.substring(1);
        }
        StdOut.println(sb.toString());

    }
}
