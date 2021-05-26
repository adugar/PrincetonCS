/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Implements Board using a two-dimensional array to store
 *  tiles. Determines if the puzzle is solvable and its neighbors. Tests
 *  all methods.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Board {

    // stores size of board
    private final int size;
    // stores array of tiles
    private int[][] tileBoard;
    // stores hamming distance
    private final int hammingDistance;
    // stores manhattan distance
    private int manhattanDistance;
    // stores row value of empty block
    private int emptyX;
    // stores col value of empty block
    private int emptyY;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        size = tiles.length;
        tileBoard = new int[size][size];
        int hammingCounter = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int tileValue = tiles[i][j];
                tileBoard[i][j] = tileValue;
                if (tileValue == 0) {
                    emptyX = i;
                    emptyY = j;
                }
                else {
                    // increases by horizontal
                    manhattanDistance += Math.abs((tileValue - 1) % size - j);
                    // increases by vertical distance
                    manhattanDistance += Math.abs((tileValue - 1) / size - i);
                }
                // increments hamming counter
                if (tileAt(i, j) != (i * size) + j + 1 && tileAt(i, j) != 0) {
                    hammingCounter++;
                }
            }
        }
        hammingDistance = hammingCounter;
    }

    // string representation of this board
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size + "\n");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(String.format("%2d ", tileAt(i, j)));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // tile at (row, col) or 0 if blank
    public int tileAt(int row, int col) {
        if (row < 0 || col < 0 || row > size() - 1 || col > size - 1) {
            throw new IllegalArgumentException("Your row and column bounds "
                                                       + "aren't valid!");
        }
        return Math.max(tileBoard[row][col], 0);
    }

    // board size n
    public int size() {
        return size;
    }

    // number of tiles out of place
    public int hamming() {
        return hammingDistance;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        return manhattanDistance;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board that = (Board) y;
        if (this.size() != that.size) return false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.tileAt(i, j) != that.tileAt(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // checks if new bounds will still be within the range of the 2D array
    private boolean isWithinBounds(int newI, int newJ) {
        if (newI < 0 || newJ < 0 || newI > size() - 1 || newJ > size() - 1) {
            return false;
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Stack<Board> boards = new Stack<Board>();
        // check box to the left
        if (isWithinBounds(emptyX - 1, emptyY)) {
            int temp = tileAt(emptyX - 1, emptyY);
            tileBoard[emptyX - 1][emptyY] = 0;
            tileBoard[emptyX][emptyY] = temp;
            boards.push(new Board(tileBoard));
            // undo the previous changes to return back to original state
            tileBoard[emptyX][emptyY] = 0;
            tileBoard[emptyX - 1][emptyY] = temp;
        }
        // check box under
        if (isWithinBounds(emptyX, emptyY - 1)) {
            int temp = tileAt(emptyX, emptyY - 1);
            tileBoard[emptyX][emptyY - 1] = 0;
            tileBoard[emptyX][emptyY] = temp;
            boards.push(new Board(tileBoard));
            // undo the previous changes to return back to original state
            tileBoard[emptyX][emptyY] = 0;
            tileBoard[emptyX][emptyY - 1] = temp;
        }
        // check box to the right
        if (isWithinBounds(emptyX + 1, emptyY)) {
            int temp = tileAt(emptyX + 1, emptyY);
            tileBoard[emptyX + 1][emptyY] = 0;
            tileBoard[emptyX][emptyY] = temp;
            boards.push(new Board(tileBoard));
            // undo the previous changes to return back to original state
            tileBoard[emptyX][emptyY] = 0;
            tileBoard[emptyX + 1][emptyY] = temp;
        }
        // check box above
        if (isWithinBounds(emptyX, emptyY + 1)) {
            int temp = tileAt(emptyX, emptyY + 1);
            tileBoard[emptyX][emptyY + 1] = 0;
            tileBoard[emptyX][emptyY] = temp;
            boards.push(new Board(tileBoard));
            // undo the previous changes to return back to original state
            tileBoard[emptyX][emptyY] = 0;
            tileBoard[emptyX][emptyY + 1] = temp;
        }
        return boards;
    }

    // is this board solvable?
    public boolean isSolvable() {
        int inversions = 0;
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                // check if it is the empty square
                if (i == emptyX && j == emptyY) {
                    continue;
                }
                for (int m = i; m < size(); m++) {
                    for (int n = 0; n < size(); n++) {
                        int value = tileAt(i, j);
                        if ((m == i && n <= j) || (m == emptyX && n == emptyY)) {
                            continue;
                        }
                        if (value > tileAt(m, n)) {
                            inversions++;
                        }
                    }
                }
            }
        }
        // when n is even, an n-by-n board is solvable if and only if the number
        // of inversions plus the row of the blank square is odd
        if (size() % 2 == 0) {
            return (((inversions + emptyX) % 2) != 0);
        }
        // when n is odd, an n-by-n board is solvable if and only if
        // its number of inversions is even
        else {
            return inversions % 2 == 0;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        int[][] tileArray = { { 8, 1, 3 }, { 4, 0, 2 }, { 7, 6, 5 } };
        int[][] tileArrayUnsolvable = { { 1, 2, 3 }, { 4, 5, 6 }, { 8, 7, 0 } };
        Board b = new Board(tileArray);
        Board b2 = new Board(tileArrayUnsolvable);
        StdOut.println("toString: " + b);
        StdOut.println("Size of board: " + b.size());
        StdOut.println("Tile at (1, 1): " + b.tileAt(1, 1));
        StdOut.println("Does b equal b2: " + b.equals(b2));
        StdOut.println("Hamming distance: " + b.hamming());
        StdOut.println("Manhattan distance: " + b.manhattan());
        StdOut.println("Is it solved: " + b.isGoal());
        StdOut.println("Is it solvable (should be yes): " + b.isSolvable());
        StdOut.println("Is it solvable (should be no): " + b2.isSolvable());

        for (Board bo : b.neighbors()) {
            StdOut.println(bo);
        }
    }
}

