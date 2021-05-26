/* *****************************************************************************
 *  Name: Armaan Dugar
 *  NetID: adugar
 *  Precept: P07
 *
 *  Partner Name: n/a
 *  Partner NetID: n/a
 *  Partner Precept: n/a
 **************************************************************************** */

Which partner is submitting the program files?
Armaan Dugar
Programming Assignment 8: Traveling Salesperson Problem

Hours to complete assignment (optional): 3


/**********************************************************************
 *  Explain how you implemented the nearest insertion heuristic.      *
 **********************************************************************/
I implemented the nearest insertion heuristic by looping through each point and
checking if its distance from p was less than the current smallest distance. I
then created a new node and inserted it after the closest node.

/**********************************************************************
 *  Explain how you implemented the smallest insertion heuristic.     *
 *  It's sufficient to list only the differences between this         *
 *  heuristic and the nearest insertion heuristic.                    *
 **********************************************************************/
The difference here is that I had to consider the effect each "connection" had
on the total tour length. Say we have points A and B, and are adding C. I
calculated increase in tour length by doing the (AC + CB) - AB. I added the
two new segments between AC and CB, then subtracted by the original distance of
AB.


/**********************************************************************
 *  Explain why it's better to use a circularly linked list instead   *
 *  of an array.                                                      *
 **********************************************************************/
One main advantage is that linked lists are dynamic in size while arrays are of
fixed size once initialized. This helps when you need to add more points to a
linked list, which would be much more time consuming when using arrays.


/**********************************************************************
 *  Fill in the lengths computed by your heuristics.                  *
 **********************************************************************/

data file      nearest neighbor     smallest increase
-----------------------------------------------------
tsp10.txt         1566.1363             1655.7462
tsp100.txt        7389.9297             4887.2190
tsp1000.txt       27868.7106            17265.6282
usa13509.txt      77449.9794            45074.7769

/**********************************************************************
 *  Do two timing analyses. Estimate the running time (in seconds)    *
 *  of each heuristic as a function of n, using expressions of the    *
 *  form: a * n^b, where b is an integer.                             *
 *                                                                    *
 *  Explain how you determined each of your answers.                  *
 *                                                                    *
 *  To get your data points, run the two heuristics for n = 1,000,    *
 *  and repeatedly double n until the execution time exceeds 60       *
 *  seconds.                                                          *
 *                                                                    *
 *  You may use TSPTimer to help do this, as per the checklist.       *
 *  If you do so, execute it with the -Xint option. This turns off    *
 *  various compiler optimizations, which helps normalize and         *
 *  stabilize the timing data that you collect.                       *
 *                                                                    *
 *  (If n = 1,000 takes over 60 seconds, your code is too slow.       *
 *  See the checklist for a suggestion on how to fix it.)             *
 **********************************************************************/

n               nearest time           smallest time
------------------------------------------------------------
1000           .366                   .722
2000           1.516                  3.048
4000           5.71                   11.647
8000           22.342                 46.823

Nearest time: .000000366 * n^2
Smallest time: .000000722 * n^2
I knew "a" had to be the time at n = 1000 and I noticed the times grew
exponentially so I made b = 2 which showed exponential growth.

/**********************************************************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

Yes or no?

No

/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no?

No

/**********************************************************************
 *  List any other comments here.
 **********************************************************************/

https://www.cs.princeton.edu/courses/archive/spr11/cos233/www/lib/exe/fetch.php?media=precept_4.pdf
I used this to figure out how to do the insertSmallest heuristic
