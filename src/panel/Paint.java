package panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;

public class Paint extends JFrame {
    

    private Options optionsPanel;
    private Panel canvasPanel;
    private final int WIDTH = 600;
    private final int HEIGHT = 400;

    public Paint(List<Color> colors, int[] sizes) {
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

        
        JPanel panel = new JPanel();
        panel.setSize(WIDTH, HEIGHT);
        panel.setBackground(new Color(247, 250, 252));
        panel.add(canvasPanel);
        panel.add(optionsPanel);
        
        this.setFocusable(true);
        
        this.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		System.out.println("key press: "+e.getKeyChar());
        		if (e.getKeyChar() == 'v') {
        			//System.out.println("number of lines: " +paintCanvas.getLines().size());
        		}
        	}
		});

        this.add(panel);
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
