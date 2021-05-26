public class Transform2D {

    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array) {
        double[] newArr = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }
        return newArr;
    }

    // Scales the polygon by the factor alpha.
    public static void scale(double[] x, double[] y, double alpha) {
        double[] cx = copy(x);
        double[] cy = copy(y);
        for (int i = 0; i < x.length; i++) {
            x[i] = cx[i] * alpha;
            y[i] = cy[i] * alpha;
        }
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy) {
        double[] cx = copy(x);
        double[] cy = copy(y);
        for (int i = 0; i < x.length; i++) {
            x[i] = cx[i] + dx;
            y[i] = cy[i] + dy;
        }
    }

    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotate(double[] x, double[] y, double theta) {
        double[] cx = copy(x);
        double[] cy = copy(y);
        double rad = Math.toRadians(theta);
        for (int i = 0; i < x.length; i++) {
            x[i] = (cx[i] * Math.cos(rad)) -
                    (cy[i] * Math.sin(rad));
            y[i] = (cy[i] * Math.cos(rad)) +
                    (cx[i] * Math.sin(rad));
        }
    }

    // Tests each of the API methods by directly calling them.
    public static void main(String[] args) {
        StdDraw.setScale(-5.0, +5.0);
        double[] x = { 0, 1, 1, 0 };
        double[] y = { 0, 0, 2, 1 };
        double[] cx = copy(x);
        double[] cy = copy(y);
        scale(cx, cy, 2.0);
        translate(cx, cy, 1.0, 2.0);
        rotate(cx, cy, 45.0);


    }
}
