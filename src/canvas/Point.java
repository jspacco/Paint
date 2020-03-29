package canvas;

import java.awt.*;

public class Point {
    private paint.Point point;
    private paint.Brush brush;

    public Point(paint.Point point, paint.Brush brush) {
        this.point = point;
        this.brush = brush;
    }

    public Point(Point p) {
        this.point = new paint.Point(p.xpos(), p.ypos());
        this.brush = new paint.Brush(p.size(), p.color());
    }

    public Color color() {
        return this.brush.color();
    }

    public int size() {
        return this.brush.size();
    }

    public int xpos() {
        return this.point.xpos();
    }

    public int ypos() {
        return this.point.ypos();
    }
}
