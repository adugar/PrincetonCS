/* *****************************************************************************
 *  Name:     Armaan Dugar
 *  NetID:    adugar
 *  Precept:  P05
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Operating system: Mac OS
 *  Compiler: Java? javac 11.0.2
 *  Text editor / IDE: IntelliJ
 *
 *  Have you taken (part of) this course before: No
 *  Have you taken (part of) the Coursera course Algorithms, Part I or II: No
 *
 *  Hours to complete assignment (optional): 3
 *
 **************************************************************************** */

Programming Assignment 1: Percolation


/* *****************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates?
 **************************************************************************** */
I used a weighted quick union object to store the sets. I created two
extra variables, topLeft and bottomRight that stored the "virtual" top and
bottom values. I also created a 2d array of booleans that stored whether the
given indice was opened or not. The open function opens the given site and
then checks around the cell to see if it is open and valid to be opened.
I check to see if they percolate using the WeightedQuickUnionFind method
connected. The parameters I pass through them are the virtual top and bottom
variables that I intialized in the constructor.


/* *****************************************************************************
 *  Perform computational experiments to estimate the running time of
 *  PercolationStats.java for various values of n and T when implementing
 *  Percolation.java with QuickFindUF.java (not QuickUnionUF.java). Use a
 *  "doubling" hypothesis, where you successively increase either n or T by
 *  a constant multiplicative factor (not necessarily 2).
 *
 *  To do so, fill in the two tables below. Each table must have 5-10
 *  data points, ranging in time from around 0.25 seconds for the smallest
 *  data point to around 30 seconds for the largest one. Do not include
 *  data points that take less than 0.25 seconds.
 **************************************************************************** */

(keep T constant)
 T = 100
 multiplicative factor (for n) = 1.3

 n          time (seconds)       ratio         log ratio
--------------------------------------------------------
65          .26
85          .88                  3.29           4.53
111         3.37                 3.82           5.10
144         13.93                4.13           5.40
187         48.9                 3.51           4.79

b is about 5.

(keep n constant)
 n = 100
 multiplicative factor (for T) = 3.5

 T          time (seconds)       ratio         log ratio
--------------------------------------------------------
10         .22
35         .74                   3.25          .94
122        3.27                  4.41          1.18
429        9.39                  3.17          .92
1500       33.22                 3.53          1.01

b is about 1.

/* *****************************************************************************
 *  Using the empirical data from the above two tables, give a formula
 *  (using tilde notation) for the running time (in seconds) of
 *  PercolationStats.java as function of both n and T, such as
 *
 *       ~ 5.3*10^-8 * n^5.0 * T^1.5
 *
 *  Briefly explain how you determined the formula for the running time.
 *  Recall that with tilde notation, you include both the coefficient
 *  and exponents of the leading term (but not lower-order terms).
 *  Round each coefficient and exponent to two significant digits.
 **************************************************************************** */
T(n, T) = a(n^b)(T^c)
T(100, 1500) = 33.22 =  a * (100^5)(1500^1)
a = 2.21 x 10^-12

Formula: 2.21 x 10^-12(n^5)(T^1)

QuickFindUF running time (in seconds) as a function of n and T:

    ~   T(n, T) = 2.21*10^-12 * (n^5) * (T^1)
       _______________________________________



/* *****************************************************************************
 *  Repeat the previous two questions, but using WeightedQuickUnionUF
 *  (instead of QuickFindUF).
 **************************************************************************** */

(keep T constant)
 T = 100
 multiplicative factor = 1.7

 n          time (seconds)       ratio         log ratio
--------------------------------------------------------
150          .25
255          .646                2.58          1.78
433          2.075               3.21          2.19
737          6.44                3.10          2.13
1252         22.08               3.42          2.31

b is about 2.

(keep n constant)
 n = 100
 multiplicative factor = 3.5

 T          time (seconds)       ratio         log ratio
--------------------------------------------------------
250         .27
875         .78                  2.88          .84
3063        2.32                 2.97          .86
10719       7.79                 3.35          .96
37516       27.388               3.51          1.00

b is about 1.

T(n, T) = a(n^b)(T^c)
T(100, 37516) = 27.388 =  a * (100^2)(37516^1)
a = 7.300 x 10^-8


WeightedQuickUnionUF running time (in seconds) as a function of n and T:

    ~  T(n, T) = 7.300*10^-8 * (n^2) * (T^1)
       _______________________________________



/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */
None


/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 **************************************************************************** */
None

/* *****************************************************************************
 *  Describe any serious problems you encountered.
 **************************************************************************** */
None



/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 **************************************************************************** */
I think seeing the visualization was really cool.
