/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Binary search deluxe implementation
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class BinarySearchDeluxe {

    // Returns the index of the first key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key,
                                         Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null) {
            throw new IllegalArgumentException("You can't have any null"
                                                       + "arguments");
        }
        // stores minimum index
        int min = 0;
        // stores maximum index
        int max = a.length - 1;
        if (a.length == 0) {
            return -1;
        }
        if (comparator.compare(key, a[min]) == 0) {
            return min;
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (comparator.compare(key, a[mid]) < 0) {
                max = mid - 1;
            }
            else if (comparator.compare(key, a[mid]) > 0) {
                min = mid + 1;
            }
            else {
                if (mid == 0) {
                    return mid;
                }
                else if (comparator.compare(key, a[mid - 1]) > 0) {
                    return mid;
                }
                else {
                    max = mid - 1;
                }
            }
        }
        return -1;
    }

    // Returns the index of the last key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null) {
            throw new IllegalArgumentException("You can't have any null"
                                                       + "arguments");
        }
        // stores minimum index
        int min = 0;
        // stores maximum index
        int max = a.length - 1;

        if (a.length == 0) {
            return -1;
        }

        if (comparator.compare(key, a[max]) == 0) {
            return max;
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (comparator.compare(key, a[mid]) < 0) {
                max = mid - 1;
            }
            else if (comparator.compare(key, a[mid]) > 0) {
                min = mid + 1;
            }
            else {
                if (mid == max) {
                    return mid;
                }
                else if (comparator.compare(key, a[mid + 1]) < 0) {
                    return mid;
                }
                else {
                    min = mid + 1;
                }
            }
        }
        return -1;
    }

    // unit testing (required)
    public static void main(String[] args) {
        String[] testArray = {
                "SDY", "SDY", "DSF", "SAD"
        };
        int firstIndex = BinarySearchDeluxe.firstIndexOf(
                testArray, "SDY", String.CASE_INSENSITIVE_ORDER);
        StdOut.println("First occurence: " + firstIndex);
        int lastIndex = BinarySearchDeluxe.lastIndexOf(
                testArray, "SDY", String.CASE_INSENSITIVE_ORDER);
        StdOut.println("Last occurence: " + lastIndex);


    }
}
