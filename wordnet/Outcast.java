/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Implements Outcast API using WordNet and
 *  ShortestCommonAncestor classes
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Outcast {
    // stores wordnet
    WordNet wn;

    // constructor takes a WordNet object
    public Outcast(WordNet wordnet) {
        this.wn = wordnet;
    }

    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns) {
        int maxSoFar = 0;
        String toReturn = null;
        for (String noun : nouns) {
            int currentDist = 0;
            for (String nounB : nouns) {
                if (!noun.equals(nounB)) {
                    currentDist += wn.distance(noun, nounB);
                }
            }
            if (currentDist > maxSoFar) {
                toReturn = noun;
                maxSoFar = currentDist;
            }
        }
        return toReturn;
    }

    // test client (see below)
    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println(args[t] + ": " + outcast.outcast(nouns));
        }
    }
}
