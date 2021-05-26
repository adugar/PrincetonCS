/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  n particles are attracted to the mouse; randomly
 *                rearrange when user clicks.
 *
 *                 % java SimpleAttractors 20
 *
 *                 Credits:  Jeff Traer-Bernstein
 *
 **************************************************************************** */


public class SimpleAttractors {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[] rx = ____________
        double[] ry = ____________
        double[] vx = ____________
        double[] vy = ____________
        double dt = 0.5;
        double mass = 1.0;
        double drag = 0.05;     // try changing this to 0.1 or 0.01 or even 0
        double attractionStrength = 0.01;

        // initialize the drawing area
        StdDraw.setPenColor(________);
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(__________);

        // do the animation
        while (true) {
            // if the mouse is pressed add some random velocity to all the particles
            if (StdDraw.isMousePressed()) {
                for (int i = 0; i < n; i++) {
                    vx[i] = 0.2 * Math.random() - 0.1;
                    vy[i] = 0.2 * Math.random() - 0.1;
                }
            }

            // clear all the forces
            double[] fx = __________
            double[] fy = __________

            // add attraction forces for attraction to the mouse
            for (int i = 0; i < n; i++) {
                double dx = StdDraw.mouseX() - rx[i];
                double dy = StdDraw.mouseY() - ry[i];
                fx[i] += attractionStrength * dx;
                fy[i] += attractionStrength * dy;
            }

            // add drag forces to all particles
            // drag is proportional to velocity in the opposite direction
            for (int i = 0; i < n; i++) {
                fx[i] += -drag * vx[i];
                fy[i] += -drag * vy[i];
            }

            // update positions
            // euler step
            for (int i = 0; i < n; i++) {
                vx[i] += fx[i] * dt / mass;
                vy[i] += fy[i] * dt / mass;
                rx[i] += vx[i] * dt;
                ry[i] += vy[i] * dt;
            }

            // set the background
            StdDraw.____________

            // draw a filled circle for each particle
            for (____________) {
                StdDraw.filledCircle(____________);
            }

            // show and pause
            StdDraw._____
            StdDraw._____
        }
    }
}
