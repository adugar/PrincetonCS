/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Plots an n-by-n red and black checkerboard. 
 *              Lower-left square is red.                    (Ex. 1.5.18) 
 * 
 * Execution:   java-introcs Checkerboard n 
 *
 **************************************************************************** */
public class Checkerboard {

    public static void main(String[] args) {

        // declaration and initialization - How big?
        int n = _______________;
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);

        // Draw from lower left, up and across.
        // i is the index for the x value; j is the index for y.
        for (int i = 0; i < n; i++) {
            for (int j = 0; ______; _____) {
                if (((i + j) % 2) == 0)
                    StdDraw.setPenColor(StdDraw.RED);
                else
                    StdDraw.________(________);

                // draw filled square centered at ___, ___ with radius 0.5
                StdDraw.filledSquare(i + ____, j + ____, 0.5);
            }
        }
    }
}
