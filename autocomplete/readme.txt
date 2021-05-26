/* *****************************************************************************
 *  Name:    Armaan Duar
 *  NetID:   adugar
 *  Precept:  P05
 *
 *  Partner Name:       N/A
 *  Partner NetID:      N/A
 *  Partner Precept:    N/A
 *
 *  Hours to complete assignment (optional): 4
 *
 **************************************************************************** */

Programming Assignment 3: Autocomplete


/* *****************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  to find the first index of a key that equals the search key.
 **************************************************************************** */
First, I check if the array is empty. If it is, then I return -1. I then check
if the first index of the array is the key. If it is, I return 0. I then go
through the array, starting at the middle point and adjusting that value
based off if mid is greater than or less than the key. I return mid if the
value at array[mid] is equal to the key and if it is the first index that
is equal.


/* *****************************************************************************
 *  Identify which sorting algorithm (if any) that your program uses in the
 *  Autocomplete constructor and instance methods. Choose from the following
 *  options:
 *
 *    none, selection sort, insertion sort, mergesort, quicksort, heapsort
 *
 *  If you are using an optimized implementation, such as Arrays.sort(),
 *  select the principal algorithm.
 **************************************************************************** */

Autocomplete() : Arrays.sort(), TimSort

allMatches() : Arrays.sort(), TimSort

numberOfMatches() : None

/* *****************************************************************************
 *  How many compares (in the worst case) does each of the operations in the
 *  Autocomplete data type make, as a function of both the number of terms n
 *  and the number of matching terms m? Use Big Theta notation to simplify
 *  your answers.
 *
 *  Recall that with Big Theta notation, you should discard both the
 *  leading coefficients and lower-order terms, e.g., Theta(m^2 + m log n).
 **************************************************************************** */

Autocomplete(): Theta(n * lg(n))

allMatches(): Theta(m * lg(m) + lg (n))

numberOfMatches(): Theta (lg(n)), binary search




/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */
None

/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 **************************************************************************** */
None

/* *****************************************************************************
 *  Describe any serious problems you encountered.
 **************************************************************************** */
None

/* *****************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 **************************************************************************** */
None



/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 **************************************************************************** */

