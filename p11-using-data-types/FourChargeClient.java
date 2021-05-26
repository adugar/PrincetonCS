/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Program that takes a double value r from the command line, creates 
 * four Charge objects that are each distance r from the center of the unit square 
 * (.5, .5), and prints the potential at location (.25, .5) due to the combined 
 * four charges. All four charges should have unit positive charge.
 *
 * Uses Charge.java to compute the electric potential at a point.
 * 
 * Example:
 *   > java FourChargeClient 0.1
 *      total potential:
 *      1.5239509122751547E11
 *
 * Remark: This is Book Exercise 3.1.1.
 * 
 **************************************************************************** */
public class FourChargeClient {
    public static void main(String[] args) {

        // read in distance r from command line
        double r = Double.parseDouble(args[0]);

        // center of standard drawing window
        double cx = 0.5;
        double cy = 0.5;

        // construct four charges
        Charge c1 = new Charge(cx + r, cy,     1.0);  // east
        Charge c2 = _______________________________;  // south
        Charge c3 = _______________________________;  // west
        Charge c4 = _______________________________;  // north

        // compute all four potentials at (0.25, 0.5)
        double px = 0.25;
        double py = 0.5;
        double v1 = c1.potentialAt(______________);
        double v2 = ______________________________;
        double v3 = ______________________________;
        double v4 = ______________________________;

        // compute and output total potential
        double sum =  ____________________________;
        StdOut.println("total potential = " + sum);
    }
}
