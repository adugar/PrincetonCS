/* Draw a decreasing series of lines using recursion */

public class LineChart {
    static final double SHORTENING_FACTOR = 0.92;
    static final double SPACING_FACTOR = 0.01;

    public static void drawBar(double height, double x, double y) {
        // base case: height is too small, we stop
        if (height < 0.01) return;

        // draw line
        StdDraw.line(x, y, x, y + height);

        // recursive call
        drawBar(height * SHORTENING_FACTOR, x + SPACING_FACTOR, y);
    }

    public static void main(String[] args) {
        // call the drawBar with a starting heigh of 1.0 and beginning at (0, 0)
        drawBar(1.0, 0.0, 0);
        StdDraw.show();
    }
}
