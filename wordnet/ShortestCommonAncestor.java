/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Implements ShortestCommonAncestor. Checks if input entered
 *  is a rooted DAG.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ShortestCommonAncestor {
    // stores the digraph
    private Digraph digraph;

    // constructor takes a rooted DAG as argument
    public ShortestCommonAncestor(Digraph G) {
        if (G == null) {
            throw new IllegalArgumentException("Argument must be a digraph!");
        }
        DirectedCycle cycle = new DirectedCycle(G);
        if (cycle.hasCycle()) {
            throw new IllegalArgumentException("Argument must be a digraph!");
        }
        int zeroOutdegree = 0;
        for (int i = 0; i < G.V(); i++) {
            if (G.outdegree(i) == 0) {
                zeroOutdegree += 1;
            }
        }
        if (zeroOutdegree == 1) {
            this.digraph = new Digraph(G);
        }
        else {
            throw new IllegalArgumentException("Argument must be a digraph!");
        }
    }

    // validates inputs
    private boolean isntValid(int v, int w) {
        return (v < 0 || w < 0 || v > digraph.V() - 1 || w > digraph.V() - 1);
    }

    // length of shortest ancestral path between v and w
    public int length(int v, int w) {
        if (isntValid(v, w)) {
            throw new IllegalArgumentException("Given arguments are out of "
                                                       + "range.");
        }
        BreadthFirstDirectedPaths bfsv = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths bfsw = new BreadthFirstDirectedPaths(digraph, w);
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < digraph.V(); i++) {
            if (bfsv.hasPathTo(i) && bfsw.hasPathTo(i)) {
                if (bfsv.distTo(i) + bfsw.distTo(i) < minDistance) {
                    minDistance = bfsv.distTo(i) + bfsw.distTo(i);
                }
            }
        }
        return minDistance;
    }

    // a shortest common ancestor of vertices v and w
    public int ancestor(int v, int w) {
        if (isntValid(v, w)) {
            throw new IllegalArgumentException("Given arguments are out of "
                                                       + "range.");
        }
        BreadthFirstDirectedPaths bfsv = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths bfsw = new BreadthFirstDirectedPaths(digraph, w);
        int length = Integer.MAX_VALUE;
        int ancestorId = -1;
        for (int i = 0; i < digraph.V(); i++) {
            if (bfsv.hasPathTo(i) && bfsw.hasPathTo(i)) {
                if (bfsv.distTo(i) + bfsw.distTo(i) < length) {
                    length = bfsv.distTo(i) + bfsw.distTo(i);
                    ancestorId = i;
                }
            }
        }
        return ancestorId;
    }

    // length of shortest ancestral path of vertex subsets A and B
    public int lengthSubset(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        if (subsetA == null || subsetB == null) {
            throw new IllegalArgumentException("Argument can't be null!");
        }
        int shortest = Integer.MAX_VALUE;
        int sizeA = 0;
        int sizeB = 0;
        for (int i : subsetA) {
            sizeA++;
            for (int j : subsetB) {
                sizeB++;
                int len = length(i, j);
                if (len < shortest) {
                    shortest = len;
                }
            }
        }
        if (sizeA == 0 || sizeB == 0) {
            throw new IllegalArgumentException("Argument can't have 0 vertices.");
        }
        return shortest;
    }

    // a shortest common ancestor of vertex subsets A and B
    public int ancestorSubset(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        if (subsetA == null || subsetB == null) {
            throw new IllegalArgumentException("Argument can't be null!");
        }
        int id = Integer.MAX_VALUE;
        int distance = Integer.MAX_VALUE;
        int sizeA = 0;
        int sizeB = 0;
        for (int i : subsetA) {
            sizeA++;
            for (int j : subsetB) {
                sizeB++;
                int dist = length(i, j);
                if (dist < distance) {
                    distance = dist;
                    id = ancestor(i, j);
                }
            }
        }
        if (sizeA == 0 || sizeB == 0) {
            throw new IllegalArgumentException("Argument can't have 0 vertices.");
        }
        return id;
    }

    // unit testing (required)
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        ShortestCommonAncestor sca = new ShortestCommonAncestor(G);
        Queue<Integer> queueA = new Queue<Integer>();
        Queue<Integer> queueB = new Queue<Integer>();
        queueA.enqueue(4);
        // queueA.enqueue(5);
        // queueA.enqueue(11);
        // queueB.enqueue(5);
        queueB.enqueue(10);
        // queueB.enqueue(7);
        StdOut.println("SCA: " + sca.ancestorSubset(queueA, queueB));
        StdOut.println("Shortest length: " + sca.lengthSubset(queueA, queueB));
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length = sca.length(v, w);
            int ancestor = sca.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }

}
