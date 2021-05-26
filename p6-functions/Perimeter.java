/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Calculates the perimeter of a triangle whose 
 *              coordinates are (0, 0), (xA, yA), and (xB, yB), 
 *              where xA1, yA, xB, and yB
 *              are integer commmand-line arguments.
 *
 *              Example:
 *              > java Perimeter 0 3 4 0
 *              12.0
 * 
 **************************************************************************** */

public class Perimeter {
   
    // computes the square function
    public static int square(int x) {
        return x * x;
    }
   
    // Euclidean distance between origin and (x, y)
    public static double hypotenuse(int x, int y) {
        // distance = Math.sqrt(x * x) + (y * y))
        double sum = square(x);
        sum += square(y);
        return Math.sqrt(sum);
    }
   
    // first method to execute
    public static void main(String[] args) {
        int xA = Integer.parseInt(args[0]);
        int yA = Integer.parseInt(args[1]);
        int xB = Integer.parseInt(args[2]);
        int yB = Integer.parseInt(args[3]);

        double perimeter = 0;
        // length of side AB
        perimeter += hypotenuse(xA - xB, yA - yB);  
        // length of side OA
        perimeter += hypotenuse(xA, yA);

        // length of side OB
        perimeter += hypotenuse(xB, yB);            
        StdOut.println(perimeter);
    }
}
