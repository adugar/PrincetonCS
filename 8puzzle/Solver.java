/* *****************************************************************************
 *  Name:    Armaan Dugar
 *  NetID:   adugar
 *  Precept: P05
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Solves 8 puzzle using A* search. Uses a search node class
 *  and priority queues. Adds all moves required to solve puzzle to a Stack
 *  so the solution can easily be printed. Tests all methods in the main
 *  method.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {

    // search node class with compareTo
    private class SearchNode implements Comparable<SearchNode> {
        // stores board
        private final Board b;
        // stores parent search node
        private final SearchNode sn;
        // stores number of moves
        private final int moves;
        // stores priority
        private final int prio;

        // constructor for search node, initializes variables
        public SearchNode(Board b, int moves, SearchNode node) {
            this.b = b;
            this.sn = node;
            int manhattan = b.manhattan();
            this.moves = moves;
            this.prio = moves + manhattan;
        }

        // compares this search node to that based on Manhattan/Hamming
        // priority function
        public int compareTo(SearchNode that) {
            return this.prio - that.prio;
        }

        // returns previous search node
        public SearchNode getSn() {
            return sn;
        }

        // board getter method
        public Board getBoard() {
            return b;
        }

        // getter method for moves
        public int getMoves() {
            return moves;
        }
    }

    // stores solution stack
    private final Stack<Board> solution;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException("Board can't be null!");
        }
        if (!initial.isSolvable()) {
            throw new IllegalArgumentException("Board can't be solved!");
        }
        // priority queue
        MinPQ<SearchNode> pq = new MinPQ<>();
        pq.insert(new SearchNode(initial, 0, null));
        solution = new Stack<Board>();
        while (true) {
            SearchNode minNode = pq.delMin();
            Board boardOfMinNode = minNode.getBoard();
            // if solved, add all moves to the stack
            if (boardOfMinNode.isGoal()) {
                SearchNode answer = minNode;
                while (answer != null) {
                    solution.push(answer.getBoard());
                    answer = answer.getSn();
                }
                break;
            }
            int moves = minNode.getMoves();
            for (Board b : boardOfMinNode.neighbors()) {
                if (moves != 0 && b.equals(minNode.getSn().getBoard())) {
                    continue;
                }
                pq.insert(new SearchNode(b, moves + 1, minNode));
            }
        }
    }

    // min number of moves to solve initial board
    public int moves() {
        return solution.size() - 1;
    }

    // sequence of boards in a shortest solution
    public Iterable<Board> solution() {
        return solution;
    }

    // test client (see below)
    public static void main(String[] args) {
        In in = new In(args[0]);
        int size = in.readInt();
        int[][] tiles = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tiles[i][j] = in.readInt();
            }
        }
        Board b = new Board(tiles);
        Solver s = new Solver(b);
        if (!b.isSolvable()) {
            StdOut.println("Unsolvable puzzle");
        }
        else {
            StdOut.println("Minimum number of moves = " + s.moves());
            for (Board solutionBoard : s.solution()) {
                StdOut.println(solutionBoard);
            }
        }
    }

}
