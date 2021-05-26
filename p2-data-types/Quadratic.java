/* *****************************************************************************
 *  Description: Given command-line arguments b and c, print out the roots of
 *               x^2 + bx + c = 0. They are given by the quadratic formula
 *
 *                     (-b - Math.sqrt(b^2 - 4.0 * c)) / 2
 *                     (-b + Math.sqrt(b^2 - 4.0 * c)) / 2
 *
 *                     https://en.wikipedia.org/wiki/Quadratic_formula
 *
 *               When the discriminant is zero, print the single number
 *                    -b/2: both roots have this value.
 *               When the discriminant (b2 - 4c) is negative, print
 *                      There are no roots.
 *               When there are two roots, print both roots, the smaller one first.
 *
 *               > java Quadratic -1 -1
 *               -0.6180339887498949
 *               1.618033988749895
 *
 *               > java Quadratic 0 -2
 *               -1.4142135623730951
 *               1.4142135623730951
 *
 *               > java Quadratic 0 2
 *               There are no roots
 *
 *               > java Quadratic -4 4
 *               2.0
 *
 *               > java Quadratic -0.1 0.0025
 *               0.05
 *
 *               > java Quadratic 10 14
 *               -8.3166247903554
 *               -1.6833752096446002
 *
 *
 *               Because of floating-point inaccuracy, it's better to check if
 *               the discriminant is very close to zero, say within 10-6.
 *               You could use a condition like Math.abs(disc) < 1.0E-6
 *
 **************************************************************************** */

public class Quadratic {
    public static void main(String[] args) {
        // get command-line arguments b and c
        double b = ____________;
        double c = ____________;

        double discriminant = _____________;

        // case 1: discrimant == close to zero
        if (Math.abs(discriminant) ______) {
            System.out.println(-b / 2.0);
        }

        // case 2: negative discrimant
        else if (________________) {
            System.out.println("There are no roots");
        }

        // case 3: two roots
        else {
            double root1 = 
            double root2 = 
            System.out.println(root1);
            System.out.println(root2);
        }
    }
}
