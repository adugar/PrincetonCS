public class BeadFinder {
    // stores blobs that mean minimum luminance
    private boolean[][] meetsMinLum;
    // picture height
    private final int height;
    // picture width
    private final int width;
    // Stack storing blobs
    private final Stack<Blob> blobs;

    //  finds all blobs in the specified picture using luminance threshold tau
    public BeadFinder(Picture picture, double tau) {
        height = picture.height();
        width = picture.width();
        meetsMinLum = new boolean[height][width];
        blobs = new Stack<Blob>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (Luminance.intensity(picture.get(j, i)) >= tau) {
                    meetsMinLum[i][j] = true;
                }
                else meetsMinLum[i][j] = false;
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (meetsMinLum[i][j]) {
                    Blob b = new Blob();
                    dfs(i, j, b);
                    blobs.push(b);
                }
            }
        }
    }

    // recursive depth first search
    private void dfs(int x, int y, Blob b) {
        if (x >= height || y >= width) return;
        if (x < 0 || y < 0) return;
        if (!meetsMinLum[x][y]) return;
        meetsMinLum[x][y] = false;
        b.add(y, x);
        dfs(x + 1, y, b);
        dfs(x - 1, y, b);
        dfs(x, y + 1, b);
        dfs(x, y - 1, b);
    }

    //  returns all beads (blobs with >= min pixels)
    public Blob[] getBeads(int min) {
        Blob[] allBlobs = new Blob[blobs.size()];
        int counter = 0;
        for (Blob b : blobs) {
            if (b.mass() >= min) {
                allBlobs[counter] = b;
                counter++;
            }
        }
        int beadsCounter = 0;
        for (int i = 0; i < allBlobs.length; i++) {
            if (allBlobs[i] != null) {
                beadsCounter++;
            }
        }
        Blob[] finalBlobs = new Blob[beadsCounter];
        int finalCounter = 0;
        for (Blob bl : blobs) {
            if (bl.mass() >= min) {
                finalBlobs[finalCounter] = bl;
                finalCounter++;
            }
        }
        return finalBlobs;
    }

    public static void main(String[] args) {
        int minMass = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        Picture p = new Picture(args[2]);
        BeadFinder bf = new BeadFinder(p, tau);
        for (int i = 0; i < bf.getBeads(minMass).length; i++) {
            StdOut.println(bf.getBeads(minMass)[i]);
        }
    }
}
