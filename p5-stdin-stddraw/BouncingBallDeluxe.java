/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Upgraded version of BouncingBall.java, as seen in Lecture 4D.
 **************************************************************************** */

public class BouncingBallDeluxe {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // initial values for a single ball
        //double rx = 0.480, ry = 0.860;     // position, more complicated than this
        //double vx = 0.015, vy = 0.023;     // velocity - between .01 and .03
        double[] rx = new double[n];
        double[] ry = new double[n];

        for (int i = 0; i < n; i++) {
            rx[i] = 1.5 * Math.random() - .75;
            ry[i] = 1.5 * Math.random() - .75;
        }

        double[] vx = new double[n];
        double[] vy = new double[n];

        for (int i = 0; i < n; i++) {
            vx[i] = .015;
            vy[i] = .023;
        }
        double radius = 0.05;              // radius of image

        // initialize standard drawing
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // main animation loop
        while (true) { // wont be used
            for (int i = 0; i < n; i++) {
                // bounce off wall according to law of elastic collision
                if (Math.abs(rx[i] + vx[i]) + radius > 1.0) {
                    vx[i] = -vx[i];
                    StdAudio.play("pipebang.wav");
                }
                if (Math.abs(ry[i] + vy[i]) + radius > 1.0) {
                    vy[i] = -vy[i];
                    StdAudio.play("pipebang.wav");
                }
            }

            // update position - velocity is constant
            for (int i = 0; i < n; i++) {
                rx[i] = rx[i] + vx[i];
                ry[i] = ry[i] + vy[i];
            }

            // set the background to light gray
            StdDraw.clear(StdDraw.LIGHT_GRAY); // StdDraw.picture, not clear
            // draw ball on the screen
            for (int i = 0; i < n; i++) {
                StdDraw.picture(rx[i], ry[i], "TennisBall.png");
            }

            // display and pause for 20 ms
            StdDraw.show();  // double buffer is enabled
            StdDraw.pause(20);

        }
    }
}
