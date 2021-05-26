/* *****************************************************************************
 *  Name:     Armaan Dugar
 *  NetID:    adugar
 *  Precept:  P05
 *
 *  Partner Name:     N/A
 *  Partner NetID:    N/A
 *  Partner Precept:  N/A
 *
 *  Hours to complete assignment (optional):
 *
 **************************************************************************** */

Programming Assignment 8: Burrows-Wheeler



/* *****************************************************************************
 *  List in table format which input files you used to test your program.
 *  Fill in columns for how long your program takes to compress and
 *  expand these instances (by applying BurrowsWheeler, MoveToFront,
 *  and Huffman in succession). Also, fill in the third column for
 *  the compression ratio (number of bytes in compressed message
 *  divided by the number of bytes in the message).
 *
 *  Use three significant digits for each entry.
 **************************************************************************** */

File     Compression Time (real)    Expansion time (real)      Compression ratio
------------------------------------------------------------------------
mobydick   1.32                      .811                      0.347
CS_bricks  0.416                     .401                      1.01

/* *****************************************************************************
 *  How long does your implementation of the Burrows-Wheeler data compression
 *  algorithm (BurrowsWheeler + MoveToFront + Huffman) take to compress and
 *  expand mobydick.txt? What is the compression ratio (number of bytes in
 *  compressed message divided by the number of bytes in the message)?
 *  Compare the results to that for running Huffman alone and GNU
 *  command-line utility Gzip.
 **************************************************************************** */

Algorithm       Compression time    Expansion time           Compression ratio
------------------------------------------------------------------------------
My program       1.32               .811                      .347
Huffman alone    .604               .358                      0.560 (667651 / 1191463)
gzip             .358               .078                      0.407

See the Checklist for Bash commands to compress/expand.


/* *****************************************************************************
 *  Give the order of growth of the running time of each of the 7
 *  methods as a function of the input size n and the alphabet size R
 *  both in practice (on typical English text inputs) and in theory
 *  (in the worst case), e.g., n, n + R, n log n, n log^2n n, n^2,
 *  or R n.
 *
 *  Include the time for sorting circular suffixes in Burrows-Wheeler
 *  transform().
 **************************************************************************** */

                                      typical            worst
---------------------------------------------------------------------
CircularSuffixArray constructor       n log n            n log n
BurrowsWheeler transform()            R + n              R + n
BurrowsWheeler inverseTransform()     R + n              R + n
MoveToFront encode()                  R + n              R n
MoveToFront decode()                  R + n              R n
Huffman compress()                    n + R log R        n + R log R
Huffman expand()                      n                  n





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
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it. Additionally, you may include any suggestions
 *  for what to change or what to keep (assignments or otherwise) in future
 *  semesters.
 **************************************************************************** */
N/A
