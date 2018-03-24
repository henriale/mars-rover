public class Plateau {
    private int height;
    private int width;

    public Plateau(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public boolean isCoordinatesOutOfBounds(int x, int y) {
        return x > width || x < 0 || y > height || y < 0;
    }
}
