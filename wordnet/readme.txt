/* *****************************************************************************
 *  Name:     Armaan Dugar
 *  NetID:    adugar
 *  Precept:  P05
 *
 *  Partner Name:
 *  Partner NetID:
 *  Partner Precept:
 *
 *  Hours to complete assignment (optional):
 *
 **************************************************************************** */

Programming Assignment 6: WordNet


/* *****************************************************************************
 *  Describe concisely the data structure(s) you used to store the
 *  information in synsets.txt. Why did you make this choice?
 **************************************************************************** */
I used Symboltables to store the information in synsets.txt because
it guarentees linear performance for search, inserting, and deleting.


/* *****************************************************************************
 *  Describe concisely the data structure(s) you used to store the
 *  information in hypernyms.txt. Why did you make this choice?
 **************************************************************************** */
I used a Digraph to store hypernyms.txt data because it represented the
relationships between words in a convenient graph.


/* *****************************************************************************
 *  Describe concisely the algorithm you use in the constructor of
 *  ShortestCommonAncestor to check if the digraph is a rooted DAG.
 *  What is the order of growth of the worst-case running times of
 *  your algorithm? Express your answer as a function of the
 *  number of vertices V and the number of edges E in the digraph.
 *  (Do not use other parameters.) Use Big Theta notation to simplify
 *  your answer.
 **************************************************************************** */

Description:
First, I checked if it had a directed cycle using the hasCycle() method in the
DirectedCycle class. If it did, I knew it wasn't a rooted DAG and through an
error. Then, I checked if it had any outdegrees by going through all the
vertices and verifying that only one vertice had one outdegree.


Order of growth of running time:
Checking for directed cycle: V + E
Going through all vertices : V
BigO(V + E)


/* *****************************************************************************
 *  Describe concisely your algorithm to compute the shortest common ancestor
 *  in ShortestCommonAncestor. For each method, give the order of growth of
 *  the best- and worst-case running times. Express your answers as functions
 *  of the number of vertices V and the number of edges E in the digraph.
 *  (Do not use other parameters.) Use Big Theta notation to simplify your
 *  answers.
 *
 *  If you use hashing, assume the uniform hashing assumption so that put()
 *  and get() take constant time per operation.
 *
 *  Be careful! If you use a BreadthFirstDirectedPaths object, don't forget
 *  to count the time needed to initialize the marked[], edgeTo[], and
 *  distTo[] arrays.
 **************************************************************************** */

Description:
First, I created two different BreadthFirstDirectedPath objects. One for vertice
v, and one for vertice w. Then, I went through each vertice and checked if the
BFDP had a path to both of those vertices. If it did, and the length was less
than the least length found so far, then I made that the current lowest length
and got the id. After it explored all the vertices, it returned the ancestorId.

                                 running time
method                  best case            worst case
--------------------------------------------------------
length()               3V + 2E              3V + 2E

ancestor()             3V + 2E              3V + 2E

lengthSubset()         4V + 2E              4V + 2E

ancestorSubset()       4V + 2E              4V + 2E



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
