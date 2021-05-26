public class Blob {
    // Center of x coordinates
    private double avgX;
    // Center of y coordinates
    private double avgY;
    // Number of pixels
    private int pixels;

    //  creates an empty blob
    public Blob() {
        avgX = 0.0;
        avgY = 0.0;
        pixels = 0;
    }

    //  adds pixel (x, y) to this blob
    public void add(int x, int y) {
        double totalX = avgX * pixels + x;
        double totalY = avgY * pixels + y;
        pixels++;
        avgX = totalX / pixels;
        avgY = totalY / pixels;
    }

    //  number of pixels added to this blob
    public int mass() {
        return pixels;
    }

    //  Euclidean distance between the center of masses of the two blobs
    public double distanceTo(Blob that) {
        return Math.sqrt(Math.pow(that.avgX - this.avgX, 2) +
                                 Math.pow(that.avgY - this.avgY, 2));
    }

    //  string representation of this blob
    public String toString() {
        return String.format("%2d (%8.4f, %8.4f)", mass(), avgX, avgY);
    }

    public static void main(String[] args) {
        Blob b = new Blob();
        b.add(200, 50);
        b.add(20, 150);
        b.add(110, 70);
        b.add(50, 90);
        StdOut.println(b.mass());
        StdOut.println(b);

        Blob b2 = new Blob();
        b2.add(150, 60);
        b2.add(200, 70);
        b2.add(80, 120);
        b2.add(30, 200);

        StdOut.println(b.distanceTo(b2));
    }   //  tests this class by directly calling all instance methods
}
