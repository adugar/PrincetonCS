/* *****************************************************************************
 *  Name:     Paul Erdős
 *  NetID:    erdos
 *  Precept:  P00
 *
 *  Partner Name:  Alfréd Rényi
 *  NetID:         renyi
 *  Precept:       P00
 *
 *  Compilation:  javac-algs4 ErdosRenyi.java
 *  Execution:    java-algs4 ErdosRenyi n trials
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class ErdosRenyi {

    // please add an appropriate comment here
    public static int count(int n) {
        int edges = 0;
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        while (uf.count() > 1) {
            int i = StdRandom.uniform(n);
            int j = StdRandom.uniform(n);
            uf.union(i, j);
            edges++;
        }
        return edges;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);          // number of vertices
        int trials = Integer.parseInt(args[1]);     // number of trials
        int[] edges = new int[trials];              // record statistics

        // repeat the experiment trials times (and time how long each takes)
        Stopwatch timer = new Stopwatch();
        for (int t = 0; t < trials; t++) {
            edges[t] = count(n);
        }
        double time = timer.elapsedTime();

        // report statistics
        StdOut.println("n            = " + n);
        StdOut.println("mean         = " + StdStats.mean(edges));
        StdOut.println("stddev       = " + StdStats.stddev(edges));
        StdOut.println("elapsed time = " + time);
    }
}
