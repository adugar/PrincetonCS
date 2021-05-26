/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Description:  Percolation implementation
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    // stores size of grid
    private final int size;
    // top left index
    private final int topLeft;
    // bottom right index;
    private final int bottomRight;
    // WeightedQuickUnion object, 1d
    private final WeightedQuickUnionUF wqu;
    // Opened sites boolean array, 2d
    private boolean[][] openedSites;
    // counts number of open sites
    private int numberOfOpenSites;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Size of grid can't be 0.");
        }
        size = n;
        topLeft = 0;
        bottomRight = (n * n) + 1;
        wqu = new WeightedQuickUnionUF((n * n) + 2);
        openedSites = new boolean[size][size];
    }

    // validates coordinates given
    private void valid(int i, int j) {
        if (i > size - 1 || j > size - 1 || i < 0 || j < 0) {
            throw new IllegalArgumentException("Coordinates given are "
                                                       + "out of bounds");
        }
    }

    // boolean version of valid
    private boolean isValid(int i, int j) {
        return (i < size && j < size && i > -1 && j > -1);
    }

    // converts 2d index to 1d
    private int convert2dto1d(int i, int j) {
        return ((size) * (i)) + j + 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        valid(row, col);
        if (!isOpen(row, col)) {
            openedSites[row][col] = true;
            numberOfOpenSites++;
            int convertedIndex = convert2dto1d(row, col);
            if (row == 0) {
                wqu.union(convertedIndex, topLeft);
            }
            if (row == size - 1) {
                wqu.union(convertedIndex, bottomRight);
            }
            if (isValid(row - 1, col) && isOpen(row - 1, col)) {
                wqu.union(convertedIndex, convert2dto1d(row - 1, col));
            }
            if (isValid(row + 1, col) && isOpen(row + 1, col)) {
                wqu.union(convertedIndex, convert2dto1d(row + 1, col));
            }
            if (isValid(row, col - 1) && isOpen(row, col - 1)) {
                wqu.union(convertedIndex, convert2dto1d(row, col - 1));
            }
            if (isValid(row, col + 1) && isOpen(row, col + 1)) {
                wqu.union(convertedIndex, convert2dto1d(row, col + 1));
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        valid(row, col);
        return openedSites[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        valid(row, col);
        return wqu.connected(convert2dto1d(row, col), topLeft);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }


    // does the system percolate?
    public boolean percolates() {
        return wqu.connected(topLeft, bottomRight);
    }

    // unit testing (required)
    public static void main(String[] args) {
        Percolation p = new Percolation(2);
        p.open(0, 1);
        p.open(1, 1);
        StdOut.println(p.percolates());
        StdOut.println(p.isOpen(1, 1));
        StdOut.println(p.isFull(1, 1));
        StdOut.println(p.numberOfOpenSites());
    }

}
