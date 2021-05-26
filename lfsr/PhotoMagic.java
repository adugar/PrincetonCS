import java.awt.Color;

public class PhotoMagic {

    // returns a transformed copy of the specified picture, using the specified lfsr.
    public static Picture transform(Picture picture, LFSR lfsr) {
        int height = picture.height();
        int width = picture.width();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color col = picture.get(i, j);
                int red = col.getRed();
                int green = col.getGreen();
                int blue = col.getBlue();
                int newRed = lfsr.generate(8) ^ red;
                int newGreen = lfsr.generate(8) ^ green;
                int newBlue = lfsr.generate(8) ^ blue;
                Color newCol = new Color(newRed, newGreen, newBlue);
                picture.set(i, j, newCol);
            }
        }
        return picture;
    }

    // takes the name of an image file and a description of an lfsr as
    // command-line arguments;
    // displays a copy of the image that is "encrypted" using the LFSR.
    public static void main(String[] args) {
        Picture p = new Picture(args[0]);
        String seed = args[1];
        int tap = Integer.parseInt(args[2]);
        LFSR lfsr = new LFSR(seed, tap);
        Picture newPic = transform(p, lfsr);
        newPic.show();
    }
}
