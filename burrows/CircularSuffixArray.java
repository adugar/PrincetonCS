/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Implements CircularSuffixArray API. Uses SuffixArrayX
 *  from the algs4 library with a few changes to make it usable for a circular
 *  array.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class CircularSuffixArray {
    // length of string
    private final int length;
    // suffix array
    private final SuffixArrayX sa;

    /* @citation Adapted from: https://algs4.cs.princeton.edu/63suffix/SuffixArrayX.java.html
     * Accessed 4/28/2020.
     */
    private class SuffixArrayX {
        private final char[] text;
        private final int[] index;
        private final int len; // number of characters in text

        public SuffixArrayX(String text) {
            this.text = text.toCharArray();
            len = text.length();
            this.index = new int[len];
            for (int i = 0; i < len; i++) {
                index[i] = i;
            }

            sort(0, len - 1, 0);
        }

        // 3-way string quicksort lo..hi starting at dth character
        private void sort(int lo, int hi, int d) {
            if (hi <= lo || d >= len) {
                return;
            }
            int lt = lo;
            int gt = hi;
            // changed for circular suffix array
            char v = text[(index[lo] + d) % len];
            int i = lo + 1;
            while (i <= gt) {
                // changed for circular suffix array
                char t = text[(index[i] + d) % len];
                if (t < v) {
                    exch(lt++, i++);
                }
                else if (t > v) {
                    exch(i, gt--);
                }
                else {
                    i++;
                }
            }

            sort(lo, lt - 1, d);
            sort(lt, gt, d + 1);
            sort(gt + 1, hi, d);
        }

        private void exch(int i, int j) {
            int swap = index[i];
            index[i] = index[j];
            index[j] = swap;
        }

        public int index(int i) {
            if (i < 0 || i >= len) {
                throw new IllegalArgumentException("Parameters are out of bounds!");
            }
            return index[i];
        }
    }

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Can't have null argument!");
        }

        length = s.length();
        sa = new SuffixArrayX(s);
    }

    // length of s
    public int length() {
        return length;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i >= length) {
            throw new IllegalArgumentException("Argument out of bounds!");
        }

        return sa.index(i);
    }

    // unit testing (required)
    public static void main(String[] args) {
        String s = "ABRACADABRA!";
        CircularSuffixArray circularSuffix = new CircularSuffixArray(s);
        StdOut.println("Length: " + circularSuffix.length());
        for (int i = 0; i < s.length(); i++) {
            System.out.print(circularSuffix.index(i) + " ");
        }
    }
}
