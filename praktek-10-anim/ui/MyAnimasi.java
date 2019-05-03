package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyAnimasi extends JPanel
        implements ActionListener {

    private final int WIDTH = 350;
    private final int HEIGHT = 350;
    private final int INIT_X = 0;
    private final int INIT_Y = 0;
    private int x, y;
    private Image image;
    private Timer timer;

    public MyAnimasi() {
        initUI();
    }

    private void initUI() {
        setBackground(Color.blue);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        x = INIT_X;
        y = INIT_Y;
        loadGambar();

        timer = new Timer(25, this);
        timer.start();
    }

    private void loadGambar() {
        ImageIcon icon = new ImageIcon("img/star.png");
        image = icon.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gambar(g);
    }

    private void gambar(Graphics g) {
        g.drawImage(image, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        x++; y++;
        if(x > WIDTH) {
            x = INIT_X;
            y = INIT_Y;
        }
        repaint();
    }
}