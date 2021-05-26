/* *****************************************************************************
 *  Name:     Armaan Dugar
 *  NetID:    adugar
 *  Precept:  P05
 *
 *  Partner Name: N/A
 *  Partner NetID: N/A
 *  Partner Precept: N/A
 *
 *  Hours to complete assignment (optional): 3
 *
 **************************************************************************** */

Programming Assignment 4: Slider Puzzle


/* *****************************************************************************
 *  Explain briefly how you represented the Board data type.
 **************************************************************************** */
I used a 2D array to store all the values in Board. I used separate variables
to store where the "0" value was. In the constructor, I also found the
hamming and manhattan values.



/* *****************************************************************************
 *  Explain briefly how you represented a search node
 *  (board + number of moves + previous search node).
 **************************************************************************** */
My search node had three parameters in the constructor. A board (Board), number
of moves (int), and the previous search node (SearchNode). From those, I
used the Board class to find the manhattan distance and added that to moves
to get the priority.




/* *****************************************************************************
 *  Explain briefly how you detected unsolvable puzzles.
 *
 *  What is the order of growth of the running time of your isSolvable()
 *  method in the worst case as function of the board size n? Use big Theta
 *  notation to simplify your answer, e.g., Theta(n log n) or Theta(n^3).
 **************************************************************************** */

Description:
I used the inversion method to determine the order of growth running time.
Whenever there were two tiles, i and j, where i < j but i appeared after
j, I incremented inversions. After counting the inversions, if the size
was even, then I added inversions to the row of the blank square. If that sum
was odd, it was solvable. If the size was odd, then if the number of inversions
was even, then it was solvable.


Order of growth of running time: Theta( n^4  )



/* *****************************************************************************
 *  For each of the following instances, give the minimum number of moves to
 *  solve the instance (as reported by your program). Also, give the amount
 *  of time your program takes with both the Hamming and Manhattan priority
 *  functions. If your program can't solve the instance in a reasonable
 *  amount of time (say, 5 minutes) or memory, indicate that instead. Note
 *  that your program may be able to solve puzzle[xx].txt even if it can't
 *  solve puzzle[yy].txt and xx > yy.
 **************************************************************************** */


                 min number          seconds
     instance     of moves     Hamming     Manhattan
   ------------  ----------   ----------   ----------
   puzzle28.txt  28           1.24          0.05
   puzzle30.txt  30           2.50          0.07
   puzzle32.txt  32           Heap space error 1.01
                              I tried adding
                              extra memory
   puzzle34.txt  34           ^^ (Same)     0.44
   puzzle36.txt  36           ^^ (Same)     3.64
   puzzle38.txt  38           ^^ (Same)     1.13
   puzzle40.txt  40           ^^ (Same)     1.23
   puzzle42.txt  42           ^^ (Same)     5.87



/* *****************************************************************************
 *  If you wanted to solve random 4-by-4 or 5-by-5 puzzles, which
 *  would you prefer: a faster computer (say, 2x as fast), more memory
 *  (say 2x as much), a better priority queue (say, 2x as fast),
 *  or a better priority function (say, one on the order of improvement
 *  from Hamming to Manhattan)? Why?
 **************************************************************************** */

I would have twice as much memory because while testing my program, running out
of heap space was my biggest issue while testing. Having the extra memory would
allow the priority queue to do more operations and not run out of memory.




/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */
N/A


/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 **************************************************************************** */
N/A




/* *****************************************************************************
 *  Describe any serious problems you encountered.
 **************************************************************************** */
N/A


/* *****************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 **************************************************************************** */
N/A






/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 **************************************************************************** */
N/A
