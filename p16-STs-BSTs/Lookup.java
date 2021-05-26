/* *****************************************************************************
 *  Name:
 *  NetID:
 *  Precept:
 *
 *  Data files:   https://introcs.cs.princeton.edu/java/44st/ip.csv
 *                https://introcs.cs.princeton.edu/java/44st/amino.csv
 *                https://introcs.cs.princeton.edu/java/44st/mktsymbols.csv
 *                https://introcs.cs.princeton.edu/java/44st/toplevel-domain.csv
 *                https://introcs.cs.princeton.edu/java/44st/elements.csv
 *
 *
 *
 *  Description:  Reads in a set of key-value pairs from a two-column CSV file
 *  specified on the command line; then, reads in keys from standard
 *  input and prints out corresponding values. Program 4.4.1
 *
 *  Execution:    java-introcs Lookup file.csv keyFieldColumn valFieldColumn
 *
 *  % java-introcs Lookup https://introcs.cs.princeton.edu/java/44st/ip.csv  0 1
 *  google.com
 *  64.233.167.99
 *
 *  % java-introcs Lookup https://introcs.cs.princeton.edu/java/44st/ip.csv  1 0
 *  64.233.167.99
 *  google.com
 *
 *
 **************************************************************************** */

public class Lookup {
    public static void main(String[] args) {
                // get CSV file
        In in = new In(args[0]);

                // column index of key field
        int keyField = Integer.parseInt(args[1]);

                // column index of value field
        int valField = Integer.parseInt(args[2]);

                // input the file - each line is an element in the database
        String[] database = in.readAllLines();

                // symbol table mapping String to String
        ST<String, String> st = new ST<String, String>();

                // parse the database, inserting the key-value pairs
        for (int i = 0; i < database.length; i++) {
                        // each line separated by commas - CSV
            System.out.println(database[i]);
            String[] tokens = database[i].split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            st.put(key, val);
        }

        // ask user for input - look up kep - print value
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (st.contains(s))
                StdOut.println(st.get(s));
            else
                StdOut.println("Not found");
        }
    }
}
