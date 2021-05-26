/******************************************************************************
 *  Compilation:  javac ArrayStack.java
 *  Execution:    java ArrayStack < input.txt
 *
 *  Stack implementation with a resizing array.
 ******************************************************************************/

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<Item> implements Iterable<Item> {
    private Item[] a;         // array of items
    private int n;            // number of elements on stack


    // Initializes an empty stack.
    public ArrayStack() {
        a = (Item[]) new Object[2];
        n = 0;
    }

    // Is this stack empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // Returns the number of items in the stack.
    public int size() {
        return n;
    }


    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= n;
        a = Arrays.copyOf(a, capacity);
    }


    // Adds the item to this stack.
    public void push(Item item) {
        if (n == a.length) resize(2 * a.length);    // double size if necessary
        a[n++] = item;                            // add item
    }

    // Removes and returns the item most recently added to this stack.
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[n - 1];
        a[n - 1] = null;                              // to avoid loitering
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == a.length / 4) resize(a.length / 2);
        return item;
    }


    // Returns (but does not remove) the item most recently added to this stack.
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[n - 1];
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = n - 1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = a[i];
            i--;
            return item;
            // or, return a[i--]
        }
    }

    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<String>();

        for (int i = 0; i < args.length; i++)
            stack.push(args[i]);

        for (String str : stack)
            System.out.print(str + " ");
    }
}
