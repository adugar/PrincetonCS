/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: 
 *
 *  A program with cubic running time. Reads in n integers
 *  and counts the number of triples that sum to exactly 0.
 *
 * > java-introcs -Xint ThreeSum < 1Kints.txt
 * elapsed time = 3.267
 * 0
 * > java-introcs -Xint ThreeSum < 2Kints.txt
 * elapsed time = 26.21
 *
 * > java-introcs Generator 1000 | java-introcs -Xint ThreeSum -Xint 
 * elapsed time = 3.314
 * 0
 *
 *  Limitations
 *  -----------
 *     - we ignore integer overflow
 *
 *  Program 4.1.1
 **************************************************************************** */

public class ThreeSum {

    // print distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static void printAll(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
    } 

    // return number of distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    } 

    public static void main(String[] args)  { 
        int[] a = StdIn.readAllInts();
        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    } 
} 
