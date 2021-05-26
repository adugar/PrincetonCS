/* *****************************************************************************
 *  Name:     Armaan Dugar
 *  NetID:    adugar
 *  Precept:  P05
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Hours to complete assignment (optional): 5
 *
 **************************************************************************** */

Programming Assignment 7: Seam Carving


/* *****************************************************************************
 *  Describe concisely your algorithm to find a horizontal (or vertical)
 *  seam.
 **************************************************************************** */
(Vertical seam)I use topological sort to find the shortest path to each pixel.
I first initialized all values except the top row to infinity in the minDist[][]
array. I then went through the three parent pixels and found which of the three
was the least and updated the minDist[] and edgeTo[] arrays accordingly. After
finding those, I worked the bottom up and traced the seam, inserting the
values into an array.


/* *****************************************************************************
 *  Describe what makes an image suitable to the seam-carving approach
 *  (in terms of preserving the content and structure of the original
 *  image, without introducing visual artifacts). Describe an image that
 *  would not work well.
 **************************************************************************** */
What makes an image suitable for this appraoch is images with similar colors
near each other, but distinct colors elsewhere. For example, in the
chameleon picture, the chameleon is a distinct green while the rest of the image
is brown, so the chameleon "stands out". If the entire image is comprised of
homogenous colors, it won't work well.


/* *****************************************************************************
 *  Perform computational experiments to estimate the running time to reduce
 *  a W-by-H image by one column and one row (i.e., one call each to
 *  findVerticalSeam(), removeVerticalSeam(), findHorizontalSeam(), and
 *  removeHorizontalSeam()). Use a "doubling" hypothesis, where you
 *  successively increase either W or H by a constant multiplicative
 *  factor (not necessarily 2).
 *
 *  To do so, fill in the two tables below. Each table must have 5-10
 *  data points, ranging in time from around 0.25 seconds for the smallest
 *  data point to around 30 seconds for the largest one.
 **************************************************************************** */

(keep W constant)
 W = 1000
 multiplicative factor (for H) = 3.9

 H           time (seconds)      ratio       log ratio
------------------------------------------------------
150         .279
585         .459                1.645       .365
2281        1.356               2.954       .795
8897        6.148               4.533       1.11
34701       29.111              4.73        1.14


(keep H constant)
 H = 1000
 multiplicative factor (for W) = 3.9

 W           time (seconds)      ratio       log ratio
------------------------------------------------------
150         .321
585         .544                1.694        .387
2281        1.458               2.68         .724
8897        5.945               4.077        1.03
34701       27.115              4.560        1.11



/* *****************************************************************************
 *  Using the empirical data from the above two tables, give a formula
 *  (using tilde notation) for the running time (in seconds) as a function
 *  of both W and H, such as
 *
 *       ~ 5.3*10^-8 * W^5.1 * H^1.5
 *
 *  Recall that with tilde notation, you include both the coefficient
 *  and exponents of the leading term (but not lower-order terms).
 *  Round each coefficient and exponent to two significant digits.
 **************************************************************************** */


Running time (in seconds) to find and remove one horizontal seam and one
vertical seam, as a function of both W and H:


    ~  1.4*10^-7 * W^1.11 * H ^1.14
       _______________________________________




/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */
My Picture() method doesn't seam to work. When I do return new Picture(pic),
which I thought would work, the tests time out.

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
I think this assigment was really cool and felt like an actual real-life
application compared to something like WordNet.
