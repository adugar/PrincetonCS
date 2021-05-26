/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Implements WordNet class using symbol tables and the
 *  ShortestCommonAncestor class.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;
import java.util.Set;

public class WordNet {
    // symbol table that stores synset and index
    private final ST<Integer, String> synsets;
    // symbol table that stores is and nouns
    private final ST<String, Set<Integer>> nouns;
    // stores SCA class
    private ShortestCommonAncestor sca;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null || hypernyms == null) {
            throw new IllegalArgumentException("Constructor arguments can't be null!");
        }
        this.synsets = new ST<>();
        this.nouns = new ST<>();
        makeSynsets(synsets);
        int sizeSyn = this.synsets.size();
        makeDigraph(hypernyms, sizeSyn);
    }

    // initializes synsets
    private void makeSynsets(String synset) {
        In synsetFile = new In(synset);
        while (synsetFile.hasNextLine()) {
            String[] line = synsetFile.readLine().split(",");
            synsets.put(Integer.valueOf(line[0]), line[1]);
            for (String noun : line[1].split((" "))) {
                Set<Integer> li = nouns.get(noun);
                if (li == null) {
                    li = new HashSet<>();
                }
                li.add(Integer.valueOf(line[0]));
                nouns.put(noun, li);
            }
        }
        synsetFile.close();
    }

    // initializes hypernyms
    private void makeDigraph(String hypernym, int size) {

        Digraph digraph = new Digraph(size);
        In hypernymFile = new In(hypernym);
        while (hypernymFile.hasNextLine()) {
            String[] line = hypernymFile.readLine().split(",");
            int synset = Integer.parseInt(line[0]);
            for (int i = 1; i < line.length; i++) {
                digraph.addEdge(synset, Integer.parseInt(line[i]));
            }
        }
        sca = new ShortestCommonAncestor(digraph);
    }

    // all WordNet nouns
    public Iterable<String> nouns() {
        return nouns.keys();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Argument can't be null!");
        }
        return nouns.contains(word);
    }

    // a synset (second field of synsets.txt) that is a shortest common ancestor
    // of noun1 and noun2 (defined below)
    public String sca(String noun1, String noun2) {
        if (noun1 == null || noun2 == null || !isNoun(noun1) || !isNoun(noun2)) {
            throw new IllegalArgumentException("Argument can't be null!");
        }
        Set<Integer> idNoun1 = nouns.get(noun1);
        Set<Integer> idNoun2 = nouns.get(noun2);
        int id = sca.ancestorSubset(idNoun1, idNoun2);
        return synsets.get(id);
    }

    // distance between noun1 and noun2 (defined below)
    public int distance(String noun1, String noun2) {
        if (noun1 == null || noun2 == null || !isNoun(noun1) || !isNoun(noun2)) {
            throw new IllegalArgumentException("Argument can't be null!");
        }
        Set<Integer> idNoun1 = nouns.get(noun1);
        Set<Integer> idNoun2 = nouns.get(noun2);
        return sca.lengthSubset(idNoun1, idNoun2);
    }

    // unit testing (required)
    public static void main(String[] args) {
        WordNet wn = new WordNet("synsets3.txt", "hypernyms.txt");
        StdOut.println(wn.nouns());
        StdOut.println(wn.isNoun("word"));
        StdOut.println(wn.isNoun("wsdfsdfewrord"));
        StdOut.println(wn.sca("word", "head"));
        StdOut.println(wn.distance("word", "head"));
    }

}
