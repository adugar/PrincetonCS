public class CA {
    // stores length of cells array
    private int n;
    // stores values of all cells
    private int[] cells;
    // stores string of rules
    private String rules;

    // create a CA object with cells n, and a rules String. set
    // the middle cell to 1
    public CA(int n, String rules) {
        this.n = n;
        this.rules = rules;
        cells = new int[this.n + 2];
        cells[this.n / 2] = 1;
    }

    // for each cell, calculate the total value of the the numbers adjacent to
    // it in binary. then find the charAt in rules using the binary number.
    // copy over values of temp into cells
    public void step() {
        int[] temp = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            int before = 0;
            int middle = 0;
            int after = 0;
            if (cells[i - 1] == 1) {
                before = 4;
            }
            if (cells[i] == 1) {
                middle = 2;
            }
            if (cells[i + 1] == 1) {
                after = 1;
            }
            int binaryNumber = before + middle + after;
            String rulesValue = Character.toString(rules.charAt(binaryNumber));
            temp[i] = Integer.parseInt(rulesValue);
        }
        for (int i = 0; i < temp.length; i++) {
            cells[i] = temp[i];
        }
    }

    // loops through cells and prints " " if 0, and "*" if 1
    public String toString() {
        String s = "";
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == 0) {
                s += " ";
            }
            else {
                s += "*";
            }
        }
        return s;
    }

    // main method that takes cmd line arguments, creates CA, and runs it
    // based off the value of steps
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        int steps = Integer.parseInt(args[1]);
        String r = args[2];
        CA ca = new CA(size, r);
        StdOut.println(ca.toString());
        for (int i = 0; i < steps; i++) {
            ca.step();
            StdOut.println(ca.toString());
        }
    }
    // YOUR CODE HERE
}
