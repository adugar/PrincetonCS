/*******************************************************************************
 *
 *  This is a template file for RingBuffer.java. It lists the constructors
 *  and methods you need to implement, along with descriptions of what they're
 *  supposed to do.
 *
 *  Note: it won't compile until you fill in the constructors and methods
 *        (or at least commment out the ones whose return type is non-void).
 *
 ******************************************************************************/

public class RingBuffer {
    // YOUR INSTANCE VARIABLES HERE
    // stores the ring buffer
    private double[] rBuffer;
    // stores the capacity
    private final int cap;
    // initializing vairables that store first, last, and size of buffer
    private int first = 0, last = 0, size = 0;


    // creates an empty ring buffer with the specified capacity
    public RingBuffer(int capacity) {
        // YOUR CODE HERE
        rBuffer = new double[capacity];
        cap = capacity;
    }

    // return the capacity of this ring buffer
    public int capacity() {
        // YOUR CODE HERE
        return cap;
    }

    // return number of items currently in this ring buffer
    public int size() {
        // YOUR CODE HERE
        return size;
    }

    // is this ring buffer empty (size equals zero)?
    public boolean isEmpty() {
        // YOUR CODE HERE
        return this.size() == 0;
    }

    // is this ring buffer full (size equals capacity)?
    public boolean isFull() {
        // YOUR CODE HERE
        return this.size() == cap;
    }

    // adds item x to the end of this ring buffer
    public void enqueue(double x) {
        // YOUR CODE HERE
        if (this.isFull()) {
            throw new RuntimeException("The ring buffer is full.");
        }
        rBuffer[last] = x;
        last++;
        if (last == cap) {
            last = 0;
        }
        size++;
    }

    // deletes and returns the item at the front of this ring buffer
    public double dequeue() {
        // YOUR CODE HERE
        if (this.isEmpty()) {
            throw new RuntimeException("The ring buffer is empty.");
        }
        double temp = rBuffer[first];
        first++;
        if (first == cap) {
            first = 0;
        }
        size--;
        return temp;
    }

    // returns the item at the front of this ring buffer
    public double peek() {
        // YOUR CODE HERE
        if (isEmpty()) {
            throw new RuntimeException("The ring buffer is empty.");
        }
        return rBuffer[first];
    }

    // tests and calls every instance method in this class
    public static void main(String[] args) {
        // YOUR CODE HERE
        RingBuffer rb = new RingBuffer(2);
        StdOut.println(rb.isEmpty());
        rb.enqueue(3.0);
        StdOut.println(rb.peek());
        rb.enqueue(5.0);
        StdOut.println(rb.peek());
        rb.dequeue();
        StdOut.println(rb.peek());
        StdOut.println(rb.capacity());
        StdOut.println(rb.isFull());
        StdOut.println(rb.isEmpty());
        StdOut.println(rb.size());
    }

}
