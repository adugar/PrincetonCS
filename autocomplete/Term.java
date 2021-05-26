/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P07
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Implements term.java. EDIT THIS!!!
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {
    // stores query as a string
    private final String query;
    // stores weight as a long
    private final long weight;

    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        if (query == null) {
            throw new IllegalArgumentException("Query can't be null!");
        }
        if (weight < 0) {
            throw new IllegalArgumentException("Weight can't be negative.");
        }
        this.query = query;
        this.weight = weight;

    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        return new ReverseWeightOrder();
    }

    private static class ReverseWeightOrder implements Comparator<Term> {
        public int compare(Term a, Term b) {
            long difference = b.weight - a.weight;
            if (difference == 0) {
                return 0;
            }
            else if (difference < 0) {
                return -1;
            }
            else {
                return 1;
            }

        }
    }

    // Compares the two terms in lexicographic order,
    // but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        if (r < 0) {
            throw new IllegalArgumentException("R can't be negative.");
        }
        return new PrefixOrder(r);
    }

    private static class PrefixOrder implements Comparator<Term> {
        // stores length of prefix given by r
        private final int prefixLength;

        // initializes prefixLength to size entered by user
        private PrefixOrder(int r) {
            prefixLength = r;
        }

        public int compare(Term a, Term b) {
            int maxLengthA;
            int maxLengthB;
            StringBuilder aStr = new StringBuilder("");
            StringBuilder bStr = new StringBuilder("");

            if (a.query.length() > prefixLength) {
                maxLengthA = prefixLength;
            }
            else {
                maxLengthA = a.query.length();
            }

            if (b.query.length() > prefixLength) {
                maxLengthB = prefixLength;
            }
            else {
                maxLengthB = b.query.length();
            }

            for (int i = 0; i < maxLengthA; i++) {
                aStr.append(a.query.charAt(i));
            }

            for (int i = 0; i < maxLengthB; i++) {
                bStr.append(b.query.charAt(i));
            }
            return aStr.toString().compareTo(bStr.toString());
        }
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return this.query.compareTo(that.query);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return this.weight + "\t" + this.query;
    }

    // unit testing (required)
    public static void main(String[] args) {
        Term t1 = new Term("CTATCGT", 7);
        Term t2 = new Term("CAG", 4);
        Term[] arrayTerm = new Term[2];
        arrayTerm[0] = t1;
        arrayTerm[1] = t2;
        StdOut.println(t1);
        StdOut.println(t1.compareTo(t2));
        Arrays.sort(arrayTerm, Term.byReverseWeightOrder());
        StdOut.println("Reverse Weight Order: ");
        for (Term t : arrayTerm) {
            StdOut.println(t.query);
        }

        Arrays.sort(arrayTerm, Term.byPrefixOrder(1));
        StdOut.println("Prefix Order: ");
        for (Term t : arrayTerm) {
            StdOut.println(t.query);
        }
    }

}
