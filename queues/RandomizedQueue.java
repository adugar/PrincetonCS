/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Description:  RandomizedQueue implementation using arrays
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    // size of array
    private int size;
    // stores the random queue
    private Item[] randomQueue;

    // construct an empty randomized queue
    public RandomizedQueue() {
        size = 0;
        randomQueue = (Item[]) new Object[1];
    }

    // resizes array given what the new size should be
    private void resize(int newSize) {
        Item[] newArray = (Item[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = randomQueue[i];
        }
        randomQueue = newArray;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Can't add a null item.");
        }
        if (size == randomQueue.length) {
            if (size == 0) {
                resize(1);
                randomQueue[size++] = item;
            }
            else {
                resize(size * 2);
                randomQueue[size++] = item;
            }
        }
        else {
            randomQueue[size++] = item;
        }
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty.");
        }
        int randomIndex = StdRandom.uniform(size);
        Item item = randomQueue[randomIndex];
        size--;
        randomQueue[randomIndex] = randomQueue[size];
        randomQueue[size] = null;
        if (size == randomQueue.length / 4) {
            resize(randomQueue.length / 2);
        }
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty.");
        }
        return randomQueue[StdRandom.uniform(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }

    // random queue iterator class, called by iterator() method
    private class RandomQueueIterator implements Iterator<Item> {
        // storing current index to be returned
        private int index;
        // initalizing copied array
        private final int[] copiedArray;

        // constructor creating and randomizing array
        public RandomQueueIterator() {
            copiedArray = new int[size];
            for (int i = 0; i < size; i++) {
                copiedArray[i] = i;
            }
            index = 0;
            StdRandom.shuffle(copiedArray);
        }

        public void remove() {
            throw new UnsupportedOperationException("Not supported.");
        }

        public boolean hasNext() {
            return index < copiedArray.length;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more items to return.");
            }
            Item item = randomQueue[copiedArray[index]];
            index++;
            return item;
        }

    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.enqueue(28);
        StdOut.println(rq.dequeue());
        StdOut.println("Is empty?: " + rq.isEmpty());
        rq.enqueue(223);
        StdOut.println("Size: " + rq.size());
        StdOut.println("Random sample: " + rq.sample());
        for (int i : rq) {
            StdOut.println(i);
        }
    }
}
