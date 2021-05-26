/* *****************************************************************************
  * Name:
  * NetID:
  * Precept:
  *
  * Description: How many people do you need to ask until you find two
  * with the same birthday? Let's simulate!
  *
  * Note: In this program, birthdays are represented as integers 0-364,
  * where 0 = Jan 1.
  *
  * Examples:
  * > java Birthday
  * 22
  * > java Birthday
  * 29
  * > java Birthday
  * 28
  **************************************************************************** */


public class Birthday {
    public static void main(String[] args) {

        // this variable keeps track of the number of people we've asked so far
        int numPeople = 0;

        // this array will associate true or false with each possible birthday
        boolean[] seenBefore = new boolean[365];

        while (true) { // same as: while (1 < 2)

            // ask a person - so increment counter
            numPeople++;
            
            // to simulate, let's pick a birthday at random,
            // represented as an int between 0 and 364
            int dayNum = (int)(Math.random() * 364) + 1;

            // if we've seen this dayNum in a previous iteration,
            // leave the loop immediately
            if (seenBefore[dayNum]) break;

            // update seenBefore[], for future iterations of this loop
            seenBefore[dayNum] = true;

        }

        // so, how many people did you need to find two with the same birthday?
        System.out.println(numPeople);
    }
}
