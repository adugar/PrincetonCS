/* *****************************************************************************
 *  Description:  Write a program to help you feed your friends at a pizza party.
 *                There will be one command-line argument, the pizza's radius.
 *                The area of the pizza is the square of the side length times
 *                pi (use Math.PI). Assuming that each person needs to eat
 *                100 cm^2 of pizza, compute the number of people you can feed,
 *                rounded down to the nearest integer. For example,
 *                *
 *                > java PizzaCalculator 10
 *                3
 *
 *                (The area will be 314.15cm^2, so 3 is the correct output.)
 *
 *                Hint: use an explicit typecast at the end.
 *
 *
 **************************************************************************** */

public class PizzaCalculator {
    public static void main(String[] args) {

        double PERSONAL_AREA = 100;                  // in square cm
        double radius = Double.parseDouble(args[0]); // radius of pizza

        // compute the area
        double area = _________

        // cast to int rounds down:
        int people = ________

        // output
        System.out.println(people);
    }
}
