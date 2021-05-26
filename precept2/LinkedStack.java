/******************************************************************************
 *  Compilation:  javac LinkedStack.java
 *  Execution:    java LinkedStack < input.txt
 *
 *  A generic stack, implemented using a singly linked list.
 *  Each stack element is of type Item.
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

// --- TODO [1]: Make LinkedStack implement the Iterable interface.
public class LinkedStack<Item> implements Iterable<Item> {
    private Node<Item> first;     // top of stack
    private int n;                // size of the stack

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    // Initializes an empty stack.
    public LinkedStack() {
        first = null;
        n = 0;
    }

    // Returns true if this stack is empty.
    public boolean isEmpty() {
        return first == null;
    }

    // Returns the number of items in this stack.
    public int size() {
        return n;
    }

    // Adds the item to this stack.
    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    // Removes and returns the item most recently added to this stack.
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }


    // Returns (but does not remove) the item most recently added to this stack.
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }


    // --- TODO [2]: implement method iterator() to return a LinkedIterator object
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }


    // --- TODO [3]: Create the private inner LinkedIterator class
    // --- TODO [4]: Make the class implement the Iterator interface
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current = first;
        // --- TODO : Add an instance variable to keep track of which
        //            element of the stack will be returned if next() is called.

        public LinkedIterator() {
            // --- TODO: Where should iteration start?
        }

        // --- TODO [5]: implement the hasNext() and next() methods
        public boolean hasNext() {
            // --- TODO: Are there more elements to return?
            return current != null;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();

            // --- TODO: Return the element pointed at by the instance variable.
            //           Advance the instance variable to the following element.
            Item i = current.item;
            current = current.next;
            return i;
        }

        // Not supported
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<String>();

        for (int i = 0; i < args.length; i++)
            stack.push(args[i]);

        // --- TODO [6]: Use a for-each loop to print the elements of the stack.
        for (String str : stack)
            System.out.print(str + " ");
    }
}

