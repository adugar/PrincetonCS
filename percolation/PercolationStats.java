/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Description:  Tests and collects statistics for my Percolation class
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {

    // final storing value for confidence interval
    private static final double CONFIDENCE_INTERVAL = 1.96;
    // grid size
    private final int size;
    // number of trials
    private final int trialsCount;
    // storing results
    private double[] results;


    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Size of grid and number of "
                                                       + "trials can't be "
                                                       + "less than 0.");
        }
        size = n;
        trialsCount = trials;
        results = new double[trials];
        for (int x = 0; x < trials; x++) {
            Percolation p = new Percolation(size);
            int counter = 0;
            while (!p.percolates()) {
                int i = StdRandom.uniform(0, size);
                int j = StdRandom.uniform(0, size);
                if (!p.isOpen(i, j)) {
                    p.open(i, j);
                    counter++;
                }
            }
            results[x] = (double) counter / (size * size);
        }


    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return mean() - ((CONFIDENCE_INTERVAL * stddev())
                / Math.sqrt(trialsCount));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + ((CONFIDENCE_INTERVAL * stddev())
                / Math.sqrt(trialsCount));
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        Stopwatch sw = new Stopwatch();
        PercolationStats ps = new PercolationStats(n, trials);
        double time = sw.elapsedTime();
        StdOut.println("mean() = " + ps.mean());
        StdOut.println("stddev() = " + ps.stddev());
        StdOut.println("confidenceLow() = " + ps.confidenceLow());
        StdOut.println("confidenceHigh() = " + ps.confidenceHigh());
        StdOut.println("elapsed time = " + time);

    }

}
