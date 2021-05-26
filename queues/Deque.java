/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Description:  Implements the deque data type using nodes.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    // size of deque
    private int size;
    // first item in deque
    private Node first;
    // last item in deque
    private Node last;

    private class Node {
        // stores the item of this node
        private Item item;
        // stores the node before
        private Node previous;
        // store the node after
        private Node next;
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add a null item.");
        }
        Node previousFirst = first;
        first = new Node();
        first.item = item;
        first.previous = null;
        first.next = previousFirst;
        if (size > 0) {
            previousFirst.previous = first;
            size++;
        }
        else {
            last = first;
            size++;
        }

    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add a null item.");
        }
        Node previousLast = last;
        last = new Node();
        last.next = null;
        last.item = item;
        last.previous = previousLast;
        if (previousLast != null) {
            previousLast.next = last;
        }
        else {
            first = last;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The deque is empty.");
        }
        Node previousFirst = first;
        first = first.next;
        if (first != null) {
            first.previous = null;
        }
        else {
            last = null;
        }
        size--;
        return previousFirst.item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("The deque is empty.");
        }
        Node previousLast = last;
        last = last.previous;
        if (last != null) {
            last.next = null;
        }
        else {
            first = null;
        }
        size--;
        return previousLast.item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // deque iterator class, called by iterator() method
    private class DequeIterator implements Iterator<Item> {
        // storing the current node
        private Node current = first;

        public void remove() {
            throw new UnsupportedOperationException("Not supported.");
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (current == null) {
                throw new NoSuchElementException("No more items to return.");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(5);
        deque.addFirst(2);
        StdOut.println(deque.removeFirst());
        deque.addLast(7);
        deque.addLast(3);
        StdOut.println(deque.removeLast());
        StdOut.println(deque.size());
        StdOut.println(deque.isEmpty());
        for (Integer i : deque) {
            StdOut.println(i);
        }
    }

}
