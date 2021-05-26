/**************************************************************************** 
 * Description: Simulate the roll of a fair six-sided die and print
 * the resulting number.
 *
 * Examples:
 * > java RollDie
 * 4
 * > java RollDie
 * 1 
 **************************************************************************** */

// TO DO: Use casting (like in RandomInt.java on page 33 of the textbook)
// to get a random integer between 1 and 6.

public class RollDie {
   public static void main(String[] args) {

       // how many sides does this die have?
      int SIDES = 6;

      // roll should be 1 through SIDES
      int roll = (int)(SIDES * Math.random() + 1);

      // print result
      System.out.println(roll);
   }
}
