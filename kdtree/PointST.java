/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/a
 *
 *  Description:  Implements PointST class using the Red-Black Binary Search
 *  Tree structure.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StopwatchCPU;

public class PointST<Value> {
    int counter = 0;
    // Stores the BST
    private final RedBlackBST<Point2D, Value> bst;

    // construct an empty symbol table of points
    public PointST() {
        bst = new RedBlackBST<Point2D, Value>();
    }

    // is the symbol table empty?
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    // number of points
    public int size() {
        return bst.size();
    }

    // associate the value val with point p
    public void put(Point2D p, Value val) {
        if (p == null || val == null) {
            throw new IllegalArgumentException("Argument can't be null.");
        }
        bst.put(p, val);
    }

    // value associated with point p
    public Value get(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Argument can't be null.");
        }
        return bst.get(p);
    }

    // does the symbol table contain point p?
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Argument can't be null.");
        }
        return bst.contains(p);
    }

    // all points in the symbol table
    public Iterable<Point2D> points() {
        return bst.keys();
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new IllegalArgumentException("Argument can't be null.");
        }
        Queue<Point2D> q = new Queue<Point2D>();
        for (Point2D p : points()) {
            if (rect.contains(p)) {
                q.enqueue(p);
            }
        }
        return q;
    }

    // a nearest neighbor of point p; null if the symbol table is empty
    public Point2D nearest(Point2D p) {
        counter++;
        if (p == null) {
            throw new IllegalArgumentException("Argument can't be null.");
        }
        if (bst.isEmpty()) {
            return null;
        }
        Point2D toReturn = null;
        double minDistance = Double.POSITIVE_INFINITY;
        for (Point2D p2d : points()) {
            double distance = p.distanceSquaredTo(p2d);
            if ((distance < minDistance)) {
                minDistance = distance;
                toReturn = p2d;
            }
        }
        return toReturn;
    }

    public int getCounter() {
        return counter;
    }

    // unit testing (required)
    public static void main(String[] args) {
        PointST<Integer> pst = new PointST<Integer>();
        RectHV rhv = new RectHV(5, 0, 10, 8);
        pst.put(new Point2D(3, 4), 5);
        pst.put(new Point2D(6, 6), 10);
        pst.put(new Point2D(5, 1), 15);
        pst.put(new Point2D(9, 9), 8);
        pst.put(new Point2D(1, 7), 11);
        StdOut.println("Size: " + pst.size());
        StdOut.println("Is empty: " + pst.isEmpty());
        StdOut.println("Contains 1, 7: " + pst.contains(new Point2D(1, 7)));
        StdOut.println("Contains 2, 6: " + pst.contains(new Point2D(2, 6)));
        StdOut.println("Value at (9, 9): " + pst.get(new Point2D(9, 9)));
        for (Point2D p : pst.points()) {
            StdOut.println(p);
        }
        StdOut.println("Nearest point to 9, 9: " +
                               pst.nearest(new Point2D(9, 9)));
        StdOut.println("Points within rectangle: ");
        for (Point2D p : pst.range(rhv)) {
            StdOut.println(p);
        }

        String filename = args[0];
        In in = new In(filename);
        PointST<Double> kdt1 = new PointST<>();
        for (int i = 0; !in.isEmpty(); i++) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            kdt1.put(p, (double) i);
        }
        StopwatchCPU swcpu = new StopwatchCPU();
        for (int j = 0; j < 3000; j++) {
            double randomX = StdRandom.uniform(0.0, 1.0);
            double randomY = StdRandom.uniform(0.0, 1.0);
            kdt1.nearest(new Point2D(randomX, randomY));
        }
        StdOut.println("Counter: " + kdt1.getCounter());
        StdOut.println(swcpu.elapsedTime());

    }

}
