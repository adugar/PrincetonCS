/*******************************************************************************
 *
 *  This is a template file for GuitarString.java. It lists the constructors
 *  and methods you need, along with descriptions of what they're supposed
 *  to do.
 *
 *  Note: it won't compile until you fill in the constructors and methods
 *        (or at least commment out the ones whose return type is non-void).
 *
 ******************************************************************************/

public class GuitarString {
    // YOUR INSTANCE VARIABLES HERE
    // Variable that holds the ringbuffer
    private final RingBuffer guitarString;

    // creates a guitar string of the specified frequency,
    // using sampling rate of 44,100
    public GuitarString(double frequency) {
        // YOUR CODE HERE
        guitarString = new RingBuffer((int) Math.ceil(44100 / frequency));
        while (!guitarString.isFull()) {
            guitarString.enqueue(0);
        }
    }

    // creates a guitar string whose size and initial values are given by
    // the specified array
    public GuitarString(double[] init) {
        // YOUR CODE HERE
        guitarString = new RingBuffer(init.length);
        for (int i = 0; i < init.length; i++) {
            guitarString.enqueue(init[i]);
        }
    }

    // returns the number of samples in the ring buffer
    public int length() {
        // YOUR CODE HERE
        return guitarString.size();
    }

    // plucks the guitar string (by replacing the buffer with white noise)
    public void pluck() {
        // YOUR CODE HERE
        for (int i = 0; i < guitarString.size(); i++) {
            guitarString.dequeue();
            guitarString.enqueue(StdRandom.uniform() - 0.5);
        }
    }

    // advances the Karplus-Strong simulation one time step
    public void tic() {
        // YOUR CODE HERE
        double deq = guitarString.dequeue();
        double enq = guitarString.peek();
        guitarString.enqueue((0.5 * (deq + enq)) * 0.996);
    }

    // returns the current sample
    public double sample() {
        // YOUR CODE HERE
        return guitarString.peek();
    }


    // tests and calls every constructor and instance method in this class
    public static void main(String[] args) {
        double[] samples = {
                0.2, 0.4, 0.5, 0.3, -0.2, 0.4, 0.3, 0.0,
                -0.1, -0.3
        };
        GuitarString testString = new GuitarString(samples);
        int m = testString.length();
        testString.pluck();
        for (int i = 0; i < m; i++) {
            double sample = testString.sample();
            StdOut.printf("%6d %8.4f\n", i, sample);
            testString.tic();

        }
    }

}
