package panel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import canvas.BrushPoint;
import canvas.Canvas;
//import canvas.Point;
import paint.Brush;

public class Panel extends JPanel implements MouseMotionListener, MouseListener {
    Canvas paintCanvas = new Canvas();
    ArrayList<Brush> brushes = new ArrayList<>();
    Brush selectedBrush;

    public Panel(int width, int height, Color c, int size) {
        this.selectedBrush = new Brush(size, c);
        this.setPreferredSize(new Dimension(width, height));

        this.setBackground(Color.white);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.requestFocus();
        
			
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
        Graphics2D g2d = (Graphics2D) g;

        List<List<BrushPoint>> lines = new ArrayList<>();
        lines.addAll(paintCanvas.lines());

        if(paintCanvas.currentLine() != null)
            lines.add(paintCanvas.currentLine());

        for (List<BrushPoint> line : lines) {
            for (int i = 0; i < line.size() - 1; i++) {
                BrushPoint p1 = line.get(i);
                BrushPoint p2 = line.get(i + 1);
                g.setColor(p1.color());
                
                g2d.setStroke(new BasicStroke(p1.size()));
                g.drawLine(p1.xpos(), p1.ypos(), p2.xpos(), p2.ypos());
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point point = new Point(e.getX(), e.getY());
        canvas.BrushPoint canvasPoint = new canvas.BrushPoint(point, selectedBrush);
        paintCanvas.drawLine(canvasPoint);
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) { }


    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) {
        canvas.BrushPoint canvasPoint = new canvas.BrushPoint(e.getPoint(), selectedBrush);
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
