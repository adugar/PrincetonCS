/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Reads an image from a file, and displays the red, green,
 *              and blue components in three separate windows.
 *
 * Remark: This is Booksite Creative Exercise 3.1.60.
 *
 **************************************************************************** */

import java.awt.Color;

public class ColorSeparation {
    public static void main(String[] args) {

        // read the picture specified by command-line argument
        Picture picture = new Picture(args[0]);
        int width = picture.width();
        int height = picture.height();

        // create three empty pictures of the same dimension
        Picture pictureR = new Picture(width, height);  // R
        Picture pictureG = new Picture(width, height);  // G
        Picture pictureB = new Picture(width, height);  // B

        // separate colors
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {

                // color value of current pixel
                Color color = picture.get(col, row);

                int r = color.getRed();  // r
                int g = color.getGreen();  // g
                int b = color.getBlue();  // b

                pictureR.set(col, row, new Color(r, 0, 0));
                pictureG.set(col, row, new Color(0, g, 0));
                pictureB.set(col, row, new Color(0, 0, b));
            }
        }

        // display each picture in its own window
        pictureR.show();
        pictureG.show();
        pictureB.show();
    }
}
