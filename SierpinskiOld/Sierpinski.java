public class Sierpinski {

    // returns height of equilateral triangle when given one side length
    public static double height(double length) {
        return (length * Math.sqrt(3)) / 2;
    }

    // Draws a filled equilateral triangle given points (x, y) and side length
    // "length"
    public static void filledTriangle(double x, double y, double length) {
        double[] xNew = new double[3];
        double[] yNew = new double[3];
        xNew[0] = x - length / 2;
        xNew[1] = x + length / 2;
        xNew[2] = x;
        yNew[0] = height(1) * length + y;
        yNew[1] = yNew[0];
        yNew[2] = y;
        StdDraw.filledPolygon(xNew, yNew);
    }

    // Draws sierpinski triangle of order n with largest triangle having
    // a bottom vertex of (x, y) and sides of length "length"
    public static void sierpinski(int n, double x, double y, double length) {
        if (n == 0) {
            return;
        }
        filledTriangle(x, y, length);
        sierpinski(n - 1, x - length / 2, y, length / 2);
        sierpinski(n - 1, x + length / 2, y, length / 2);
        sierpinski(n - 1, x, y + height(1) * length, length / 2);
    }

    // Takes integer input of "n", draws a large triangle with side length
    // of 1 and then calls sierpinski triangle method with order n
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.line(0, 0, 1, 0);
        StdDraw.line(0.5, height(1), 0, 0);
        StdDraw.line(1, 0, 0.5, height(1));
        sierpinski(n, 0.5, 0, 0.5);
    }
}
