/* *****************************************************************************
 *  Name: Armaan Dugar
 *  NetID: adugar
 *  Precept: P07
 *
 *  Partner Name: N/A
 *  Partner NetID: N/A
 *  Partner Precept: N/A
 **************************************************************************** */

Which partner is submitting the program files? Armaan Dugar

Final Programming Project: Atomic Nature of Matter

Hours to complete assignment (optional):


/**************************************************************************
 *  The input size n for BeadTracker is the product of the number of      *
 *  pixels per frame and the number of frames. What is the estimated      *
 *  running time (in seconds) of BeadTracker as a function of n?          *
 *  Justify your answer with empirical data and explain how you used it.  *
 *  Your answer should be of the form a*n^b where b is an integer.        *
 **************************************************************************/

I used the stopwatch object to measure the time between the start of
BeadTracker and the end
n               Time (seconds)
n = 10          .836
n = 20          1.29
n = 40          2.835
n = 80          3.718
n = 160         7.397

b = log_2((1.29/.836 + 2.835/1.29 + 3.718/2.835 + 7.397/3.718)/4)
= 0.815926009, almost 1

a = (0.836/10^2 + 1.29/20^2 + 2.835/40^2 + 3.718/80^2 + 7.397/160^2) / 5
= 0.00284535156

Using these values of n and their corresponding execution time, I get the
equation
0.00284535156*n^1

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

/**************************************************************************
 *  List any other comments here.                                         *
 **************************************************************************/

I have the timing correct for the BeadTracker, I'm not sure why the doubling
method isn't giving a correct estimate for the time it takes for a program
to run with n input size.
