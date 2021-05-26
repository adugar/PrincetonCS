/* *****************************************************************************
 *  Name:
 *  NetID:
 *  Precept:
 *
 *  Description: Counts the number of times each String has occurred.
 *
 *  % more duckduckgoose.txt
 *  duck duck goose
 *
 *  % java-introcs FrequencyTable < duckduckgoose.txt
 *  duck 2
 *  goose 1
 *
 *  Remarks:
 *   - This is book/booksite Exercise 4.4.45
 *   - Use with any text file
 *
 **************************************************************************** */

public class FrequencyTable {
    // Dependencies: ST.java (available on precepts page), StdIn, StdOut
    // maintain counts of all words seen so far
    // the key is the word and the value is the count
    private ST<String, Integer> st = new ST<String, Integer>();

    // NOTE! We have not provided a constuctor! But Java gives every class
    // a no-argument constructor by default. It only runs code above
    // (instance variable initialization).

    // add 1 to the frequency of this word
    public void increment(String word) {
        int count = frequencyOf(word);
        st.put(word, count + 1);
    }

    // what is the frequency of this word?
    public int frequencyOf(String word) {
        if (!st.contains(word)) return 0;  // if word is not in ST
        else return st.get(word);          // get word's count
    }

    // return string representation of frequency table
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // foreach loop goes through all keys in alphabetical order
        for (String word : st.keys()) {

            // print out the word and its frequency, separated by a space
            sb.append(frequencyOf(word) + " " + word + "\n");
        }
        return sb.toString();
    }

    // method used by client to count all words in StdIn
    public static void main(String[] args) {

        // build frequency table from words on standard input
        FrequencyTable freq = new FrequencyTable();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            freq.increment(word);
        }

        // print frequency table to standard output
        StdOut.println(freq);
    }
}
