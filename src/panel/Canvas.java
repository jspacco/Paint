package panel;

import canvas.Point;
import paint.Brush;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel implements MouseMotionListener, MouseListener {
    canvas.Canvas paintCanvas = new canvas.Canvas();
    ArrayList<Brush> brushes = new ArrayList<>();
    Brush selectedBrush;

    public Canvas(int width, int height, Color c, int size) {
        this.selectedBrush = new Brush(size, c);
        this.setPreferredSize(new Dimension(width, height));

        this.setBackground(Color.white);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void changeBrushColor(Color c) {
        this.selectedBrush = new Brush(this.selectedBrush.size(), c);
    }

    public void changeBrushSize(int size) {
        System.out.println(size);
        this.selectedBrush = new Brush(size, this.selectedBrush.color());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        List<List<Point>> lines = new ArrayList<>();
        lines.addAll(paintCanvas.lines());

        if(paintCanvas.currentLine() != null)
            lines.add(paintCanvas.currentLine());

        for (List<Point> line : lines) {
            for (int i = 0; i < line.size() - 1; i++) {
                Point p1 = line.get(i);
                Point p2 = line.get(i + 1);
                g.setColor(p1.color());
                Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(p1.size()));
                g.drawLine(p1.xpos(), p1.ypos(), p2.xpos(), p2.ypos());
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        paint.Point point = new paint.Point(e.getX(), e.getY());
        canvas.Point canvasPoint = new canvas.Point(point, selectedBrush);
        paintCanvas.drawLine(canvasPoint);
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) { }


    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) {
        paint.Point point = new paint.Point(e.getX(), e.getY());
        canvas.Point canvasPoint = new canvas.Point(point, selectedBrush);
        paintCanvas.drawLine(canvasPoint);
        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        paintCanvas.endLine();
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
