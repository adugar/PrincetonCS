/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 * 
 * Description: Prints all the inputs in reverse order.
 *
 * Examples:
 * > java PrintReverse Alice Bob Carol Doug
 * Doug Carol Bob Alice
 * > java PrintReverse Seven Ate Nine
 * Nine Ate Seven
 **************************************************************************** */
 
public class PrintReverse {
    public static void main(String[] args) {

        // n is the number of command-line arguments 
        int n = args.length;

        // print in reverse order
        for (int i = (args.length - 1); i > 0; i--) {
            System.out.println(args[i]);
        }
        
        // print new line at the end
        System.out.println();
    }
}
