public class Art {

    // When even, draw an outline of the circle with color red
    private static void drawOutline(double x, double y, double size) {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.circle(x, y, size / 2);
        StdDraw.circle(x, y, size / 2);
    }

    // When odd, draw a filled circle with color blue
    private static void drawCircle(double x, double y, double size) {
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledCircle(x, y, size / 2);
        StdDraw.filledCircle(x, y, size / 2);
    }

    // recursive function that checks if n is odd or even
    // if it is even, it draws an outline of a circle
    // if it is odd, it draws the filled circle
    // it recursively draws 4 different parts, each with reducing
    // size in either the y or x axis
    private static void drawRecursive(int n, double x, double y, double size) {
        if (n == 0) return;

        if (n % 2 != 0) {
            drawCircle(x, y, size);
        }
        else {
            drawOutline(x, y, size);
        }

        drawRecursive(n - 1, x - size / 2, y - size / 2, size / 2);
        drawRecursive(n - 1, x + size / 2, y - size / 2, size / 2);
        drawRecursive(n - 1, x - size / 2, y + size / 2, size / 2);
        drawRecursive(n - 1, x + size / 2, y + size / 2, size / 2);


    }


    // takes a command line integer n that calls a recursive function
    // that will create circles of order n.
    public static void main(String[] args) {
        StdDraw.setScale(-1, 2);
        int n = Integer.parseInt(args[0]);
        drawRecursive(n, 0.5, 0.5, 0.8);
    }
}
