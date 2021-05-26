public class Avogadro {
    public static void main(String[] args) {
        // constants and other variables used later in calculations
        final double RADIUS = 0.5e-6;
        final int ABSOLUTE_KELVIN = 297;
        final double VISCOSITY = 9.135e-4;
        final double GAS_CONSTANT = 8.31446;
        final double PIXEL_CONVERT = 0.000000175;
        double avogadro;
        double boltzmann;
        double constant = 0;
        int total = 0;

        while (!StdIn.isEmpty()) {
            constant += Math.pow(StdIn.readDouble() * PIXEL_CONVERT, 2);
            total++;
        }
        constant = constant / (2 * total);
        // Solving for k in the Stokes-Einstein equation
        boltzmann = (constant * 6 * Math.PI * VISCOSITY * RADIUS) /
                (ABSOLUTE_KELVIN);
        avogadro = GAS_CONSTANT / boltzmann;
        StdOut.printf("Boltzmann = %.4e", boltzmann);
        StdOut.print("\n");
        StdOut.printf("Avogadro  = %.4e", avogadro);
        StdOut.print("\n");
    }
}
