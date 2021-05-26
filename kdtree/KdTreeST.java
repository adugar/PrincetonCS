/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Implements KdTree API using nodes. The put, get, nearest, and
 *  range methods are written recursively.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StopwatchCPU;

public class KdTreeST<Value> {
    // stores root node
    private Node root;
    // stores size of kdtree
    private int size = 0;
    private int counter = 0;

    private class Node {
        // stores the point
        private Point2D point;
        // stores the value
        private Value value;
        // rectangle corresponding to this node
        private RectHV rect;
        // left subtree
        private Node left;
        // right subtree
        private Node right;
        // stores orientation, true if x coordinate, false if y coordinate
        private boolean vertical;

        // initiates node instance variables
        public Node(Point2D p, Value v, RectHV rect, boolean vertical) {
            this.point = p;
            this.value = v;
            this.rect = rect;
            this.vertical = vertical;
        }
    }

    // construct an empty symbol table of points
    public KdTreeST() {
        root = null;
    }

    // is the symbol table empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // number of points
    public int size() {
        return size;
    }

    // associate the value val with point p
    public void put(Point2D p, Value val) {
        if (p == null || val == null) {
            throw new IllegalArgumentException("Argument can't be null!");
        }
        root = put(null, root, p, val, true);
    }

    // helper method for public put method
    private Node put(Node parent, Node n, Point2D p, Value v, boolean vertical) {
        if (n == null) {
            size++;
            return new Node(p, v, newRect(parent, p, vertical), vertical);
        }
        if (n.point.equals(p)) {
            n.value = v;
            return n;
        }
        int comparison = comparePoints(p, n.point, n.vertical);
        if (comparison < 0) {
            n.left = put(n, n.left, p, v, !n.vertical);
        }
        else {
            n.right = put(n, n.right, p, v, !n.vertical);
        }
        return n;
    }

    // creates new RectHV, helper method
    private RectHV newRect(Node n, Point2D p, boolean vertical) {
        if (n == null) {
            return new RectHV(Double.NEGATIVE_INFINITY,
                              Double.NEGATIVE_INFINITY,
                              Double.POSITIVE_INFINITY,
                              Double.POSITIVE_INFINITY);
        }
        double comparison = comparePoints(p, n.point, !vertical);
        if (n.vertical) {
            if (comparison < 0) {
                return new RectHV(n.rect.xmin(), n.rect.ymin(), n.point.x(),
                                  n.rect.ymax());
            }
            else {
                return new RectHV(n.point.x(), n.rect.ymin(), n.rect.xmax(),
                                  n.rect.ymax());
            }
        }
        else {
            if (comparison < 0) {
                return new RectHV(n.rect.xmin(), n.rect.ymin(), n.rect.xmax(),
                                  n.point.y());
            }
            else {
                return new RectHV(n.rect.xmin(), n.point.y(), n.rect.xmax(),
                                  n.rect.ymax());
            }
        }
    }

    // compares two points given the orientation
    private int comparePoints(Point2D p1, Point2D p2, boolean orientation) {
        int toReturn;
        if (orientation) {
            toReturn = Double.compare(p1.x(), p2.x());
        }
        else {
            toReturn = Double.compare(p1.y(), p2.y());
        }
        return toReturn;
    }

    // value associated with point p
    public Value get(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Argument can't be null!");
        }
        return get(root, p);
    }

    // helper method for public get method
    private Value get(Node n, Point2D p) {
        if (n == null) {
            return null;
        }
        if (n.point.equals(p)) {
            return n.value;
        }
        int comparison = comparePoints(p, n.point, n.vertical);
        if (comparison < 0) {
            return get(n.left, p);
        }
        else {
            return get(n.right, p);
        }
    }

    // does the symbol table contain point p?
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Argument can't be null!");
        }
        return get(p) != null;
    }

    // all points in the symbol table
    public Iterable<Point2D> points() {
        Queue<Node> nodeQueue = new Queue<Node>();
        Queue<Point2D> point2DQueue = new Queue<Point2D>();
        if (root == null) {
            return point2DQueue;
        }
        nodeQueue.enqueue(root);
        while (!nodeQueue.isEmpty()) {
            Node current = nodeQueue.dequeue();
            point2DQueue.enqueue(current.point);
            if (current.left != null) {
                nodeQueue.enqueue(current.left);
            }
            if (current.right != null) {
                nodeQueue.enqueue(current.right);
            }
        }
        return point2DQueue;
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new IllegalArgumentException("Argument can't be null!");
        }
        Queue<Point2D> rangeRect = new Queue<Point2D>();
        range(root, rect, rangeRect);
        return rangeRect;
    }

    // helper method for public range method
    private void range(Node n, RectHV rect, Queue<Point2D> points) {
        if (n == null) {
            return;
        }
        if (rect.intersects(n.rect)) {
            if (rect.contains(n.point)) {
                points.enqueue(n.point);
            }
            range(n.left, rect, points);
            range(n.right, rect, points);
        }
    }

    // a nearest neighbor of point p; null if the symbol table is empty
    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Argument can't be null!");
        }
        if (root == null) {
            return null;
        }
        return nearest(p, root, root.point);
    }

    // helper method for nearest public method, champion is closest point
    // so far
    private Point2D nearest(Point2D p, Node n, Point2D champion) {
        counter++;
        if (n == null) {
            return champion;
        }
        if (n.rect.distanceSquaredTo(p) < champion.distanceSquaredTo(p)) {
            if (comparePoints(p, n.point, n.vertical) < 0) {
                champion = nearest(p, n.left, champion);
                champion = nearest(p, n.right, champion);
            }
            else {
                champion = nearest(p, n.right, champion);
                champion = nearest(p, n.left, champion);
            }
        }
        if (champion.distanceSquaredTo(p) > n.point.distanceSquaredTo(p)) {
            champion = n.point;
        }
        return champion;
    }

    public int getCounter() {
        return counter;
    }

    // unit testing (required)
    public static void main(String[] args) {
        KdTreeST<String> kdt = new KdTreeST<String>();
        kdt.put(new Point2D(0.25, 0.5), "A");
        kdt.put(new Point2D(1.0, 0.75), "B");
        kdt.put(new Point2D(2, 2), "C");
        kdt.put(new Point2D(3, 3), "D");
        kdt.put(new Point2D(8, 4), "E");
        kdt.put(new Point2D(7, 5), "F");
        kdt.put(new Point2D(6, 6), "G");
        kdt.put(new Point2D(4, 7), "H");
        kdt.put(new Point2D(0.25, 0.75), "I");
        StdOut.println(kdt.isEmpty()); // should be no
        StdOut.println(kdt.contains(new Point2D(8, 2)));
        for (Point2D point : kdt.points()) {
            StdOut.println(point);
        }
        StdOut.println(kdt.size());
        StdOut.println(kdt.get(new Point2D(0.25, 0.5)));
        RectHV testRect = new RectHV(0, 0, 5, 6);
        for (Point2D points : kdt.range(testRect)) {
            StdOut.println(points);
        }
        StdOut.println("Nearest point: " + kdt.nearest(new Point2D(5, 8)));
        String filename = args[0];
        In in = new In(filename);
        KdTreeST<Double> kdt1 = new KdTreeST<Double>();
        for (int i = 0; !in.isEmpty(); i++) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            kdt1.put(p, (double) i);
        }
        StopwatchCPU swcpu = new StopwatchCPU();
        for (int j = 0; j < 600000; j++) {
            double randomX = StdRandom.uniform(0.0, 1.0);
            double randomY = StdRandom.uniform(0.0, 1.0);
            kdt1.nearest(new Point2D(randomX, randomY));
        }
        StdOut.println("Counter: " + kdt1.getCounter());
        StdOut.println(swcpu.elapsedTime());
    }
}
