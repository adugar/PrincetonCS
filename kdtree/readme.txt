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

Programming Assignment 5: Kd-Trees


/* *****************************************************************************
 *  Describe the Node data type you used to implement the
 *  2d-tree data structure.
 **************************************************************************** */
I used a node data type with four different parameters in the constructor. P,
type Point2D, stored the coordinates of the point. The value, v, stored the
value at that point. rect stored the rectangle for that point. Finally,
vertical stored whether the orientation for that point was vertical
or horizontal.
/* *****************************************************************************
 *  Describe your method for range search in a kd-tree.
 **************************************************************************** */
I start at the root and recursively search both sub trees. I only searched
the node and its subtrees if the query rectangle intersected the node's
rectangle.

/* *****************************************************************************
 *  Describe your method for nearest neighbor search in a kd-tree.
 **************************************************************************** */
I start at the root and recursively search both sub trees. I store the closest
point found so far in a variable called champion. I only search a node if it
might contain a point closer than the current champion. After pruning/searching
every node, I return the champion.

/* *****************************************************************************
 *  How many nearest-neighbor calculations can your PointST implementation
 *  perform per second for input1M.txt (1 million points), where the query
 *  points are random points in the unit square?
 *
 *  Fill in the table below, using one digit after the decimal point
 *  for each entry. Use at least 1 second of CPU time.
 *  (Do not count the time to read the points or to build the 2d-tree.)
 *
 *  Repeat the same question but with your KdTreeST implementation.
 *
 **************************************************************************** */


                 # calls to         /   CPU time     =   # calls to nearest()
                 client nearest()       (seconds)        per second
                ------------------------------------------------------
PointST:        3000                  1.1           = 2727.3

KdTreeST:       36321032              1.2           = 30267526.7

Note: more calls per second indicates better performance.


/* *****************************************************************************
 *  Did you fill out the mid-semester feedback form?
 *  If not, please do so now: https://forms.gle/72SRLDPmR49NJDM66
 **************************************************************************** */
Yes

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


/* *****************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 **************************************************************************** */
N/A



/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on  how helpful the class meeting was and on how much you learned
 * from doing the assignment, and whether you enjoyed doing it.
 **************************************************************************** */
I think this was the hardest assignment yet.
