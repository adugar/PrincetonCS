/* **************************************************************************
 * Description: Prints 25 stars, 5 per line.
 **************************************************************************** */

public class BuggyFivePerLine2 {
    public static void main(String[] args) {

        int i;

        for (i = 0; i < 25; i += 5) { // i = 0, 5, 10, ...

            for (int j = 0; j < 5; j++) { // j = 0, 1, 2, 3, 4
                System.out.print("* ");
            }

            System.out.println();
        }

        System.out.println("Printed " + i + " stars.");
    }
}
