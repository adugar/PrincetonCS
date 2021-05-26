public class PictureCA {
    public static void main(String[] args) {
        Picture p = new Picture(255, 511);
        String r = args[0];
        CA ca = new CA(511, r);
        for (int i = 0; i < 254; i++) {
            ca.step();
            for (int j = 0; j < 511; j++) {
                if (ca.toString().charAt(j) == '*') {
                    p.setRGB(i, j, 0);
                }
            }
        }
        p.show();
    }
}
