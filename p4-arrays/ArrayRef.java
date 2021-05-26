/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *  
 * Description: What does this program print?
 **************************************************************************** */

public class ArrayRef {
    public static void main(String[] args) {
        
        // what value does each element get initialized to?
        int[] a = new int[4];
        int[] b = new int[4];
        
        // what will be printed here? why?
        if (a == b) { System.out.println("equal"); }
        else        { System.out.println("not equal"); }
        
        // what does this statement do?
        b = a;
        
        // what will be printed here? why?
        if (a == b) { System.out.println("equal"); }
        else        { System.out.println("not equal"); }
        
        // does assigning a[3] change b[3]?
        a[3] = 100;
        System.out.println("a[3] = " + a[3]); // this is 100
        System.out.println("b[3] = " + b[3]); // is this 0 or 100?
    }
}
