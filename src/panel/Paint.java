package panel;

import javax.swing.*;
import java.awt.*;

import java.util.List;
import java.util.ArrayList;

public class Paint {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    private  List<Color> colors;
    private int[] sizes;
    private Options optionsPanel;
    private Panel canvasPanel;
    private final int WIDTH = 600;
    private final int HEIGHT = 400;

    public Paint(List<Color> colors, int[] sizes) {
        this.colors = colors;
        this.sizes = sizes;

        int canvasWidth = (WIDTH * 8)/10;
        int optionsWidth = WIDTH - canvasWidth;

        this.canvasPanel = new Panel(
                canvasWidth,
                HEIGHT,
                colors.get(0),
                sizes[0]);
        this.optionsPanel = new Options(
                this,
                optionsWidth,
                HEIGHT,
                colors,
                sizes);

        this.panel = new JPanel();
        this.panel.setSize(WIDTH, HEIGHT);
        this.panel.setBackground(new Color(247, 250, 252));
        this.panel.add(canvasPanel);
        this.panel.add(optionsPanel);


        this.frame.add(this.panel);
        this.frame.setSize(new Dimension(WIDTH, HEIGHT));
        this.frame.setVisible(true);
        this.frame.pack();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    void changeColor(Color color) {
        this.canvasPanel.changeBrushColor(color);
    }

    void changeSize(int size) {
        this.canvasPanel.changeBrushSize(size);
    }

    public static void main(String[] args) {

        List<Color> colors = new ArrayList<>();
        colors.add(Color.BLACK);
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);

        int[] sizes = new int[]{3, 6, 9, 12};

        Paint p = new Paint(colors, sizes);

    }
}
