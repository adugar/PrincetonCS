/* *****************************************************************************
 *  Name:
 *  NetID:
 *  Precept:
 *
 *  Description:  Create a class to model intervals of the real line. Each
 *  interval has a minimum and a maximum, and contains all of the real numbers
 *  between its minimum and its maximum. (This kind of object has applications
 *  in geometry, scheduling, and text editing.) For example, the interval
 *  [3, 6] from 3 to 6 contains 3, π, 5, and 6, but it does not contain 6.21.
 *  (All intervals we deal with will include both endpoints.)
 *
 **************************************************************************** */

public class Interval {
    // instance variables
    double lo; // minimum value in this Interval
    double hi; // maximum value in this Interval

    // constructor
    public Interval(double lo, double hi) {
        if (hi < lo)
          throw ________

        // copy data from constructor parameters to instance vars
        ____;
        ____;
    }

    // text representation
    public String toString() {
        // if you want, use String.format("%.6e", ...);
        return String.format("[%.6e, %.6e]", lo, hi);
    }

    // other instance methods
    // is x in this interval?
    public boolean contains(double x) {
        return ________;
    }

    // do these intervals intersect?
    public boolean intersects(Interval other) {
        ___________;
    }

    // is other a subset of this interval?
    public boolean subsetOf(Interval other) {
        _________;
    }

    // use "this" to just reuse previous logic
    public boolean supersetOf(Interval other) {
        _________;
    }

    // test client
    public static void main(String[] args) {
        // counting years BCE to avoid negative signs
        Interval mesozoic = new Interval(66E6, 252E6);
        Interval jurassic = new Interval(145E6, 201E6);
        StdOut.println("The Mesozoic is " + mesozoic.toString());
        StdOut.println("The Jurassic is " + jurassic); // implicit toString
        StdOut.println(mesozoic.intersects(jurassic)); // true
        StdOut.println(jurassic.subsetOf(mesozoic));   // true
    }
}
