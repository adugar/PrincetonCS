/* This program takes two command-line arguments, a name and
 * an age. It prints how old that person will be next year. By
 * doing this exercise, you will learn the difference between +
 * for concatenation and + for addition.
 *
 * Examples:
 * > java NextYear Alice 19
 * Next year Alice will be 20 years old.
 * > java NextYear FatherTime 999
 * Next year FatherTime will be 1000 years old.
 **/

public class NextYear {
    public static void main(String[] args) {
       

        // Modify NameAge.java. Use Integer.parseInt() to store the
        // age as an integer and output: Next year [NAME] will be [AGE+1]
        // years old.
        int nextAge = Integer.parseInt(args[1]) + 1;
        System.out.println("Next year " + args[0] + " will be " + nextAge + " years old.");

    }
}
