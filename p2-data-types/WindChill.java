/* *****************************************************************************
 *  Description:  Your program will be given two command-line arguments:
 *                t, representing the temperature (in Fahrenheit), and v,
 *                representing the wind speed (in miles per hour). It should
 *                print the wind chill w using the following formula:
 *                  w = 35.74 + 0.6215 * t + (0.4275 * t − 35.75) * v^0.16
 *
 *                Use Math.pow to compute the exponent.
 *
 *                Source: National Weather Service
 *                https://www.weather.gov/ama/windchill
 *
 *                > java WindChill 20 40
 *                -0.9093161298099588
 *
 *                > java WindChill -10 40
 *                -42.69557456233983
 *
 **************************************************************************** */

public class WindChill {
    public static void main(String[] args) {

        // get command-line arguments
        double t = Double.parseDouble(_____); // temperature (F)
        double v = ____________;              // velocity of wind (mph)

        // careful to add all three * signs:
        double windChillTemp =  ________________;
         
        // print the result
        System.out.println(windChillTemp); // windchill (F)
        // Note - try using Math.round to produce more practical result
    }
}
