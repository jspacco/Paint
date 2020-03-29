package paint;

import java.awt.*;

public class Brush {
    private int size;
    private Color color;

    public Brush(int size, Color color) {
        this.size = size;
        this.color = color;
    }

    public Color color() {
        return this.color;
    }

    public int size() {
        return this.size;
    }
}
