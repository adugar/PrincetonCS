/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Implements Autocomplete class
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Autocomplete {
    // stores all the terms that are passed as an argument in the constructor
    private final Term[] terms;

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        if (terms == null) {
            throw new IllegalArgumentException("Terms can't be null!");
        }
        this.terms = new Term[terms.length];
        // stores length of term array
        int length = terms.length;
        for (int i = 0; i < length; i++) {
            if (terms[i] == null) {
                throw new IllegalArgumentException("Term can't be null!");
            }
            this.terms[i] = terms[i];
        }
        Arrays.sort(this.terms);
    }

    // Returns all terms that start with the given prefix, in
    // descending order of weight.
    public Term[] allMatches(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix can't be null");
        }
        Term t = new Term(prefix, 0);
        int firstSpot = BinarySearchDeluxe.firstIndexOf(
                this.terms,
                t, Term.byPrefixOrder(prefix.length()));
        int lastSpot = BinarySearchDeluxe.lastIndexOf(
                this.terms,
                t, Term.byPrefixOrder(prefix.length()));
        int size = numberOfMatches(prefix);
        Term[] temp = new Term[size];
        if (firstSpot == -1 || lastSpot == -1) {
            return new Term[0];
        }
        for (int i = 0; i < size; i++) {
            temp[i] = terms[firstSpot + i];
        }
        Arrays.sort(temp, Term.byReverseWeightOrder());
        return temp;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix can't be null");
        }
        if (prefix.length() == 0) {
            return this.terms.length;
        }
        Term t = new Term(prefix, 0);
        int firstSpot = BinarySearchDeluxe.firstIndexOf(
                this.terms,
                t, Term.byPrefixOrder(prefix.length()));
        if (firstSpot == -1) {
            return 0;
        }
        int lastSpot = BinarySearchDeluxe.lastIndexOf(
                this.terms,
                t, Term.byPrefixOrder(prefix.length()));
        return lastSpot - firstSpot + 1;
    }

    // unit testing (required)
    public static void main(String[] args) {
        Term[] terms = {
                new Term("alex", 10), new Term("alexa", 1),
                new Term("armaan", 5), new Term("arthur", 5)
        };
        Autocomplete ac = new Autocomplete(terms);
        Term[] output = ac.allMatches("a");
        StdOut.println(ac.numberOfMatches("a"));
        for (Term t : output) {
            StdOut.println(t);
        }
    }

}
