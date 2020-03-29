package canvas;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Canvas {
    private List<Point> currentLine;
    private List<List<Point>> lines;

    public Canvas() {
        this.lines = new LinkedList<>();
    }

    public List<List<Point>> lines() {
        return this.lines;
    }
    public List<Point> currentLine() {
        return this.currentLine;
    }

    public void drawLine(Point p) {
        if (this.currentLine == null) {
            this.currentLine = new ArrayList<Point>();
        }
        currentLine.add(p);
    }

    public void endLine() {
        this.lines.add(currentLine);
        this.currentLine = null;
    }

}
