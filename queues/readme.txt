/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Hours to complete assignment (optional): 3.5
 *
 **************************************************************************** */

Programming Assignment 2: Deques and Randomized Queues


/* *****************************************************************************
 *  Explain briefly how you implemented the randomized queue and deque.
 *  Which data structure did you choose (array, linked list, etc.)
 *  and why?
 **************************************************************************** */
I chose to use a linked list to implement the deque. When adding and removing
items to the front or end of the deque, the nature of linked lists allowed that
to be easily done. I created a before and after node in the Node class which
helped since I had to do two different variations for adding and removing items.

I used an array for the randomized queue because it made it easier to pick a
random index from. It also made it easy to shuffle the queue. Resizing the array
wasn't too difficult and I made a helper method to do it.

/* *****************************************************************************
 *  How much memory (in bytes) do your data types use to store n items
 *  in the worst case? Use the 64-bit memory cost model from Section
 *  1.4 of the textbook and use tilde notation to simplify your answer.
 *  Briefly justify your answers and show your work.
 *
 *  Do not include the memory for the items themselves (as this
 *  memory is allocated by the client and depends on the item type)
 *  or for any iterators, but do include the memory for the references
 *  to the items (in the underlying array or linked list).
 **************************************************************************** */

Randomized Queue:   ~  8n  bytes

This uses 8n bytes of memory because of the array references which use 8 bytes
of memory each. We don't know the type of item in the array so we can't
calculate that.

Deque:              ~  48n  bytes

The nodes use 48n bytes of memory, where n is the number of nodes. 16 for overhead, 8 for
the reference to previous, and another 8 for the reference to after. Since item
is generic, we don't know how much memory that will take. The reference to it is
8 bytes. The last 8 comes from the reference to the RandomizedQueue. The int
size adds another 8 bytes but that is removed when simplfying.



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
I don't think it was as interesting as Percolation, but I see why
this assignment was important to do.
