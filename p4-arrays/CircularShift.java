/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Given an array of strings from the command-line:
 *                  - Copy the command-line arguments to a new array
 *                  - Print the new array
 *                  - Move each string one position later in the array, and move
 *                    the one at the end to the start.
 *                  - Print the array again
 *
 *                 > java CircularShift The quick brown fox jumps over the lazy dog
 *                 The quick brown fox jumps over the lazy dog
 *                 dog The quick brown fox jumps over the lazy
 *
 **************************************************************************** */

public class CircularShift {
    public static void main(String[] args) {
        int n = args.length; // for convenience

        // create the new array and copy
        String[] copy = new ___;
        for (int i = __; i < __; __)
            ____ = args[i];

        // print the copy
        System.out.println("Before shift:");
        for (int i = 0; i < n; i++)
            System.out.print(____ + " ");
        System.out.println();

        // Shift
        String temp = ____[_____];       // save the last one
        for (int i = ____; ____; ___)    // shift the remaining ones
            copy[___] = copy[___];
        ____ = temp;                     // set the first one

        // print the shifted array
        System.out.println("After shift:");
      

    }

}
