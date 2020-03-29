package paint;

public class Point {
    private int X;
    private int Y;

    public Point(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public int xpos() {
        return this.X;
    }

    public int ypos() {
        return this.Y;
    }
}
