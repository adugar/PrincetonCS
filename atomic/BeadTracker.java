public class BeadTracker {
    public static void main(String[] args) {
        // values from command line
        Stopwatch sw = new Stopwatch();
        int minMass = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        double delta = Double.parseDouble(args[2]);
        // starting at i = 3 b/c 0, 1, and 2 are for above variables ^^
        for (int i = 3; i < args.length - 1; i++) {
            BeadFinder bf1 = new BeadFinder(new Picture(args[i]), tau);
            BeadFinder bf2 = new BeadFinder(new Picture(args[i + 1]), tau);
            // identifies the beads (using the specified values for min and tau)
            // in each image (using BeadFinder)
            Blob[] beads1 = bf1.getBeads(minMass);
            Blob[] beads2 = bf2.getBeads(minMass);
            for (Blob b : beads2) {
                double smallest = Double.POSITIVE_INFINITY;
                for (Blob b2 : beads1) {
                    double distance = b.distanceTo(b2);
                    // making sure distance is no longer than delta
                    if (distance <= delta && distance < smallest) {
                        smallest = distance;
                    }
                }
                if (smallest <= delta) {
                    StdOut.printf("%.4f", smallest);
                    StdOut.println();
                }
            }
        }
        StdOut.println("Time: " + sw.elapsedTime());
    }
}
