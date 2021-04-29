package canvas;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Canvas {
    private List<BrushPoint> currentLine;
    private List<List<BrushPoint>> lines;

    public Canvas() {
        this.lines = new LinkedList<>();
    }

    public List<List<BrushPoint>> lines() {
        return this.lines;
    }
    public List<BrushPoint> currentLine() {
        return this.currentLine;
    }

    public void drawLine(BrushPoint p) {
        if (this.currentLine == null) {
            this.currentLine = new ArrayList<BrushPoint>();
        }
        currentLine.add(p);
    }

    public void endLine() {
        this.lines.add(currentLine);
        this.currentLine = null;
    }
    
    public List<List<BrushPoint>> getLines() {
    	return lines;
    }

}
