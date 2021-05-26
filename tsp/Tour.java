public class Tour {
    // create Node class
    private class Node {
        // stores coordinates
        private Point p;
        // represents next node
        private Node next;
    }

    // First node of circularly linked list
    private final Node first = new Node();

    // creates an empty tour
    public Tour() {
        first.p = null;
        first.next = first;
    }

    // creates the 4-point tour a->b->c->d->a (for debugging)
    public Tour(Point a, Point b, Point c, Point d) {
        Node second = new Node();
        Node third = new Node();
        Node fourth = new Node();
        first.p = a;
        first.next = second;
        second.p = b;
        second.next = third;
        third.p = c;
        third.next = fourth;
        fourth.p = d;
        fourth.next = first;
    }

    // returns the number of points in this tour
    public int size() {
        if (first.p == null) return 0;
        int counter = 1;
        Node n = first;
        while (!n.next.equals(first) && counter != 0) {
            counter++;
            n = n.next;
        }
        return counter;
    }

    // returns the length of this tour
    public double length() {
        if (first.p == null) return 0;
        double distance = 0.0;
        Node n = first;
        Node n2 = first.next;
        while (!n.next.equals(first)) {
            distance += n.p.distanceTo(n2.p);
            n = n.next;
            n2 = n2.next;
        }
        distance += n.p.distanceTo(n2.p);
        return distance;
    }

    // returns a string representation of this tour
    public String toString() {
        if (first.p == null) return "";
        StringBuilder sb = new StringBuilder();
        Node n = first;
        while (!n.next.equals(first)) {
            sb.append(n.p.toString() + "\n");
            n = n.next;
        }
        sb.append(n.p.toString() + "\n");
        return sb.toString();
    }

    // draws this tour to standard drawing
    public void draw() {
        if (first.p == null) return;
        Node n = first;
        Node n2 = first.next;
        while (!n.next.equals(first)) {
            n.p.drawTo(n2.p);
            n = n.next;
            n2 = n2.next;
        }
        n.p.drawTo(n2.p);
    }

    // inserts p using the nearest neighbor heuristic
    public void insertNearest(Point p) {
        if (size() == 0) {
            first.next = first;
            first.p = p;
            return;
        }
        double distanceBetweenNode;
        double minimumDistance = Double.POSITIVE_INFINITY;
        Node nearestN = null;
        Node n = first;
        do {
            distanceBetweenNode = n.p.distanceTo(p);
            if (distanceBetweenNode < minimumDistance) {
                nearestN = n;
                minimumDistance = distanceBetweenNode;
            }
            n = n.next;
        } while (!n.equals(first));
        Node newNode = new Node();
        newNode.p = p;
        newNode.next = nearestN.next;
        nearestN.next = newNode;
    }

    // inserts p using the smallest increase heuristic
    public void insertSmallest(Point p) {
        if (size() == 0) {
            first.next = first;
            first.p = p;
            return;
        }
        double leastDist;
        double minimumDistance = Double.POSITIVE_INFINITY;
        Node nearestN = null;
        Node n = first;
        do {
            leastDist = n.p.distanceTo(p) + n.next.p.distanceTo(p);
            leastDist = leastDist - n.p.distanceTo(n.next.p);
            if (leastDist < minimumDistance) {
                nearestN = n;
                minimumDistance = leastDist;
            }
            n = n.next;
        } while (!n.equals(first));
        Node newNode = new Node();
        newNode.p = p;
        newNode.next = nearestN.next;
        nearestN.next = newNode;
    }

    // tests this class by directly calling all constructors and instance methods
    public static void main(String[] args) {

        // define 4 points that are the corners of a square
        Point a = new Point(345.0, 250.0);
        Point b = new Point(432.5, 234.4);
        Point c = new Point(234.6, 412.5);
        Point d = new Point(453.4, 512.2);

        // create the tour a -> b -> c -> d -> a
        Tour squareTour = new Tour(a, b, c, d);

        // print the size to standard output
        int size = squareTour.size();
        StdOut.println("Number of points = " + size);
        double length = squareTour.length();
        StdOut.println("Tour length = " + length);
        StdOut.println(squareTour);
        squareTour.insertNearest(d);
        squareTour.insertSmallest(d);
        StdDraw.setXscale(0, 600);
        StdDraw.setYscale(0, 600);

        squareTour.draw();
    }
}
