/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Example program to declare and initialize two Stopwatch objects.
 *              Then swap them by merely swapping the reference names.
 *
 **************************************************************************** */


public class PlayTime {
    public static void main(String[] args) {
        Stopwatch watchOne = new Stopwatch();

        // waste time so it is large enough to be measurable
        for (int i = 0; i < 1e8; i++) ;

        Stopwatch watchTwo = new Stopwatch();

        // waste time so it is large enough to be measurable
        for (int i = 0; i < 1e8; i++) ;

        // right now, watchOne is older
        StdOut.println("watchOne " + watchOne.elapsedTime());
        StdOut.println("watchTwo " + watchTwo.elapsedTime());

        Stopwatch watchTmp = watchOne;
        watchOne = watchTwo;
        watchTwo = watchTmp;

        // swapped! now watchTwo is the older one
        // e.g. watchTwo.elapsedTime() returns a value
        // (slightly) larger than watchOne.elapsedTime()
        StdOut.println("watchOne " + watchOne.elapsedTime());
        StdOut.println("watchTwo " + watchTwo.elapsedTime());
    }
}
