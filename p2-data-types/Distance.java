/* **************************************************************************
 * Description: Prints the distance between (0, 0) and (x, y), where x and
 * y are integers, given as command line arguments.
 * 
 * Notes: In case you're rusty on the algebra, we determine this by the
 * Euclidean distance: distance = square root of (x squared + y squared).
 *
 * Example:
 * % java Distance 3 4                                  This is Booksite
 * Distance from (0, 0) to (3, 4) is 5.0.               Web Exercise 1.2.1.
 **************************************************************************** */

public class Distance {
    public static void main(String[] args) {

        // input point coordinates
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        // compute distance
        int x_distance = x * x;
        int y_distance = y * y;
        double total_distance = Math.sqrt((double)x_distance + y_distance);

        // output distance
        System.out.println(total_distance);
    }   
}
