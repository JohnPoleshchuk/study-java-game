package org.example;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int originalTitleSize = 16;
    final int scale = 3;

    final int titleSize = originalTitleSize*scale;
    final int maxScreenCol = 20;
    final int maxScreenRow = 16;
    final int screenWidth = titleSize * maxScreenCol;
    final int screenHeight = titleSize * maxScreenRow;

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            update();

            repaint();
        }
    }
    public void update() {

    }
    public void paintComponent(Graphics G) {
        super.paintComponent(G);

        Graphics2D G2 = (Graphics2D) G;

        G2.setColor(Color.white);

        G2.fillRect(100, 100, titleSize, titleSize);

        G2.dispose();
    }
}
