/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Implements SeamCarver API using topological search. I used
 *  helper methods. One helped calculated the energy and the other checked
 *  that seams passed as parameters to removeVerticalSeam() and
 *  removeHorizontalSeam() were valid. This reduced code repition.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdOut;

import java.awt.Color;

public class SeamCarver {
    // stores the picture
    private Picture pic;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (picture == null) {
            throw new IllegalArgumentException("Picture can't be null!");
        }
        pic = new Picture(picture);
    }

    // current picture
    public Picture picture() {
        return pic;
    }

    // width of current picture
    public int width() {
        return pic.width();
    }

    // height of current picture
    public int height() {
        return pic.height();
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        if (x < 0 || x > width() - 1 || y < 0 || y > height() - 1) {
            throw new IllegalArgumentException("Arguments are out of bounds.");
        }
        Color xRight = picture().get((x + 1) % width(), y);
        Color xLeft = picture().get((x + width() - 1) % width(), y);
        Color yUp = picture().get(x, ((y + height() - 1) % height()));
        Color yDown = picture().get(x, (y + 1) % height());
        return Math.sqrt(xGradient(xRight, xLeft) + yGradient(yUp, yDown));
    }

    // calculates x gradient
    private double xGradient(Color right, Color left) {
        return (Math.pow(right.getRed() - left.getRed(), 2) +
                Math.pow(right.getBlue() - left.getBlue(), 2) +
                Math.pow(right.getGreen() - left.getGreen(), 2));
    }

    // calculates y gradient
    private double yGradient(Color up, Color down) {
        return (Math.pow(up.getRed() - down.getRed(), 2) +
                Math.pow(up.getBlue() - down.getBlue(), 2) +
                Math.pow(up.getGreen() - down.getGreen(), 2));
    }

    // transposes picture -- switches x and y values
    private void transpose() {
        Picture transposed = new Picture(height(), width());
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                transposed.set(i, j, pic.get(j, i));
            }
        }
        pic = transposed;
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        double[][] energy = new double[width()][height()];
        double[][] minDist = new double[width()][height()];
        int[][] edgeTo = new int[width()][height()];
        for (int i = 0; i < width(); i++) {
            for (int j = 0; j < height(); j++) {
                energy[i][j] = energy(i, j);
                if (j == 0) {
                    minDist[i][j] = energy[i][j];
                }
                else {
                    minDist[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
        for (int i = 1; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                double min = minDist[j][i - 1];
                int col = j;
                if (j != 0) {
                    if (minDist[j - 1][i - 1] < min) {
                        min = minDist[j - 1][i - 1];
                        col = j - 1;
                    }
                }
                if (j != width() - 1) {
                    if (minDist[j + 1][i - 1] < min) {
                        min = minDist[j + 1][i - 1];
                        col = j + 1;
                    }
                }
                if (min + energy[j][i] < minDist[j][i]) {
                    edgeTo[j][i] = col;
                    minDist[j][i] = energy[j][i] + min;
                }
            }
        }
        double leastLastRow = Double.POSITIVE_INFINITY;
        int index = 0;
        for (int j = 0; j < width(); j++) {
            if (minDist[j][height() - 1] < leastLastRow) {
                leastLastRow = minDist[j][height() - 1];
                index = j;
            }
        }
        int[] seam = new int[height()];
        for (int i = height() - 1; i > -1; i--) {
            seam[i] = index;
            index = edgeTo[index][i];
        }
        return seam;
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        transpose();
        int[] horizontalSeam = findVerticalSeam();
        transpose();
        return horizontalSeam;
    }


    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        if (seam == null) {
            throw new IllegalArgumentException("Seam can't be null!");
        }
        if (seam.length != width()) {
            throw new IllegalArgumentException("Seam length must equal width!");
        }
        checkValid(seam, false);
        transpose();
        removeVerticalSeam(seam);
        transpose();
    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {
        if (seam == null) {
            throw new IllegalArgumentException("Seam can't be null!");
        }
        if (seam.length != height()) {
            throw new IllegalArgumentException("Seam length must equal height!");
        }
        checkValid(seam, true);
        Picture p = new Picture(width() - 1, height());
        for (int i = 0; i < p.height(); i++) {
            for (int j = 0; j < seam[i]; j++) {
                p.set(j, i, pic.get(j, i));
            }
            for (int k = seam[i]; k < p.width(); k++) {
                p.set(k, i, pic.get(k + 1, i));
            }
        }
        pic = p;
    }

    // checks if seam is valid using conditions stated in assignment
    private void checkValid(int[] seam, boolean isVertical) {
        if (isVertical) {
            if (width() <= 1) {
                throw new IllegalArgumentException("Width must "
                                                           + "be greater than 1");
            }
            for (int i = 0; i < height(); i++) {
                if (seam[i] > width() - 1 || seam[i] < 0) {
                    throw new IllegalArgumentException("Seam element is out "
                                                               + "of bounds");
                }
                if (i != 0 && Math.abs(seam[i] - seam[i - 1]) > 1) {
                    throw new IllegalArgumentException("Adjacent elements "
                                                               + "differ by "
                                                               + "more than 1.");
                }
            }
        }
        else {
            if (height() <= 1) {
                throw new IllegalArgumentException("Height must "
                                                           + "be greater than 1");
            }
            for (int i = 0; i < width(); i++) {
                if (seam[i] > height() - 1 || seam[i] < 0) {
                    throw new IllegalArgumentException("Seam element is out "
                                                               + "of bounds");
                }
                if (i != 0 && Math.abs(seam[i] - seam[i - 1]) > 1) {
                    throw new IllegalArgumentException("Adjacent elements differ"
                                                               + " by more "
                                                               + "than 1.");
                }
            }
        }
    }

    //  unit testing (required)
    public static void main(String[] args) {
        Picture p = new Picture(args[0]);
        SeamCarver sc = new SeamCarver(p);
        sc.picture().show();
        int removeVert = Integer.parseInt(args[1]);
        int removeHor = Integer.parseInt(args[2]);
        StdOut.println("Initial Width: " + sc.picture().width());
        StdOut.println("Initial Height: " + sc.picture().height());
        StdOut.println("Energy at (5, 5): " + sc.energy(5, 5));
        for (int i = 0; i < removeVert; i++) {
            int[] vertSeam = sc.findVerticalSeam();
            sc.removeVerticalSeam(vertSeam);
        }
        for (int i = 0; i < removeHor; i++) {
            int[] horSeam = sc.findHorizontalSeam();
            sc.removeHorizontalSeam(horSeam);
        }
        StdOut.println("Final Width: " + sc.picture().width());
        StdOut.println("Final Height: " + sc.picture().height());
        sc.picture().show();
        /* USED FOR TESTING
        Picture p = SCUtility.randomPicture(Integer.parseInt(args[0]),
                                            Integer.parseInt(args[1]));
        Stopwatch sw = new Stopwatch();
        SeamCarver sc = new SeamCarver(p);
        sc.removeVerticalSeam(sc.findVerticalSeam());
        sc.removeHorizontalSeam(sc.findHorizontalSeam());
        StdOut.println("Elapsed time: " + sw.elapsedTime());
        */
    }

}
