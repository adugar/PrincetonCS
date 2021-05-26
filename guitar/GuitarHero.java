public class GuitarHero {
    public static void main(String[] args) {

        // create two guitar strings, for concert A and concert C
        double CONCERT_A = 440.0;
        String keyboardString = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] guitar = new GuitarString[keyboardString.length()];
        for (int i = 0; i < keyboardString.length(); i++) {
            guitar[i] = new GuitarString(CONCERT_A * Math.pow(
                    2, ((double) (i - 24) / 12)));
        }
        // the main input loop
        Keyboard keyboard = new Keyboard();
        while (true) {

            // check if the user has played a key; if so, process it
            if (keyboard.hasNextKeyPlayed()) {
                char key = keyboard.nextKeyPlayed();
                int index = keyboardString.indexOf(key);
                if (index >= 0) guitar[index].pluck();
            }
            double sample = 0;
            // compute the superposition of samples
            for (int i = 0; i < keyboardString.length(); i++) {
                sample += guitar[i].sample();
            }

            // play the sample on standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for (int i = 0; i < keyboardString.length(); i++) {
                guitar[i].tic();
            }
        }
    }
}
