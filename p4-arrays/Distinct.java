/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 * 
 * Description: Distinct takes n integers as input and outputs true
 * if all the inputs have different values, false otherwise.
 *
 * Examples:
 * > java Distinct 11 23 -7 0 99 5 42
 * true
 * > java Distinct 2 4 6 3 6
 * false
 * > java Distinct -3 -2 -1 -0 3 2 1 0 
 * false 
 *
 * Note: The last one is false because the integer -0 equals integer 0.
 **************************************************************************** */

public class Distinct {
    public static void main(String[] args) {

        // n is the number of command-line arguments 
        int n = args.length;    
         
        // convert each arg and store them in an array of integers
        int[] values = new int[n];
        for (int i = 0; i < n; i++)
            values[i] = Integer.parseInt(args[i]);
        
        // are all of the pairs examined so far distinct?
        boolean result = true;

        // we'll examine each values[i] in the array 
        for (int i = 0; i < n; i++) {
            // we'll examine values[j] for each other j
            for (int j = i + 1; j < n; j++) {
                // are they different or not?
                if (values[i] == values[j]) {
                    result = false;
                }
            }
        }
         
        System.out.println(result);
    }
}
