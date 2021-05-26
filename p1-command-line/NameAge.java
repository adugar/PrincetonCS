/* This program reads two command-line arguments and prints both out
 * in a sentence. By doing this exercise you will learn the difference
 * between print() and println().
 *
 * Examples:
 * > java NameAge Alice 19
 * Alice is 19 years old.
 * > java NameAge FatherTime 999
 * FatherTime is 999 years old.
 */

public class NameAge {
    public static void main(String[] args) {


        // Modify HelloWorld.java to read a name and an age from
        // the command line (both handled as String arguments) and
        // output: [NAME] is [AGE] years old.
        System.out.println(args[0] + " is " + args[1] + " years old."); //args[0] is a name, args[1] is an age

    }
}
