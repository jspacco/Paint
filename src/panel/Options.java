package panel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Options extends JPanel {
    private List<Color> colors;
    private int[] sizes;
    private ArrayList<JButton> sizeButtons;
    private ArrayList<JButton> colorButtons;
    private Color  bgColor = new Color(203, 213, 224);
    Paint parent;

    public Options(Paint parent, int width, int height, List<Color> colors, int[] sizes) {
        this.parent = parent;
        this.colors = colors;
        this.sizes = sizes;
        this.sizeButtons = new ArrayList<>();
        this.colorButtons = new ArrayList<>();

        JLabel sizeLabel = new JLabel("Sizes");
        JPanel sizesPanel = buildSizeButtons(width, 200);
        JLabel colorLabel = new JLabel("Colors");
        JPanel colorsPanel = buildColorButtons(width, 200);

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(bgColor);
        this.add(sizeLabel);
        this.add(sizesPanel);
        this.add(colorLabel);
        this.add(colorsPanel);
    }

    private JPanel buildSizeButtons(int width, int height) {
        JPanel sizesPanel = new JPanel();
        sizesPanel.setPreferredSize(new Dimension(width - 20, height));
        for(int size: sizes) {
            JButton btn = new JButton();
            btn.setPreferredSize(new Dimension(20, 20));
            btn.setText(size + "");
            sizesPanel.add(btn);
            this.sizeButtons.add(btn);
            btn.addActionListener(new SizeButtonListener());
        }
        sizesPanel.setBackground(bgColor);
        return sizesPanel;
    }

    private JPanel buildColorButtons(int width, int height) {
        JPanel colorsPanel = new JPanel();
        colorsPanel.setPreferredSize(new Dimension(width - 20, height));
        for(Color c: colors) {
            JButton btn = new JButton();
            btn.setPreferredSize(new Dimension(40, 20));
            btn.setBackground(c);
            btn.setOpaque(true);
            btn.setBorder(BorderFactory.createLineBorder(Color.white, 2));
            colorsPanel.add(btn);
            this.colorButtons.add(btn);
            btn.addActionListener(new ColorButtonListener());
        }
        colorsPanel.setBackground(bgColor);
        return colorsPanel;
    }


    private class SizeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            Options optionsPanel = (Options) source.getParent().getParent();
            optionsPanel.parent.changeSize(Integer.parseInt(source.getText()));
        }
    }

    private class ColorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            Options optionsPanel = (Options) source.getParent().getParent();
            optionsPanel.parent.changeColor(source.getBackground());
        }
    }
}
