package canvas;

import java.awt.Color;
import java.awt.Point;

import paint.Brush;

public class BrushPoint {
    private Point point;
    private Brush brush;

    public BrushPoint(Point point, Brush brush) {
        this.point = point;
        this.brush = brush;
    }

    public BrushPoint(BrushPoint p) {
        this.point = new Point(p.xpos(), p.ypos());
        this.brush = new Brush(p.size(), p.color());
    }

    public Color color() {
        return this.brush.color();
    }

    public int size() {
        return this.brush.size();
    }

    public int xpos() {
        return this.point.x;
    }

    public int ypos() {
        return this.point.y;
    }
}
