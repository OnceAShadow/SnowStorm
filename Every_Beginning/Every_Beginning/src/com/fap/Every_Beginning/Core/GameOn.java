package com.fap.Every_Beginning.Core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

import com.fap.Every_Beginning.Graphics.Animations.ScreenDisplay;

public class GameOn extends Canvas implements Runnable {

    private static int widthResolution = 800;
    private static int heightResolution = 600;
    private static int widthFrame = widthResolution;
    private static int heightFrame = heightResolution;

    protected JFrame frame;
    private Thread thread;
    private ScreenDisplay screen;
    private boolean running;

    private BufferedImage imageInFrame = new BufferedImage(widthFrame, heightFrame, BufferedImage.TYPE_INT_RGB);
    private int[] pixelsInFrame = ((DataBufferInt) imageInFrame.getRaster().getDataBuffer()).getData();

    public GameOn () {
        Dimension frameResolution = new Dimension(widthFrame, heightFrame);
        setPreferredSize(frameResolution);

        screen = new ScreenDisplay(widthResolution, heightResolution);
        frame = new JFrame();
        frame.setResizable(false);

        Keeper.createWorld("/LevelStart.png", this);
    }

    public synchronized void startGame() {
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public void run() {
        long clock1Sec = System.currentTimeMillis();
        requestFocus();

        while(running) {
            Keeper.gameTickUp();
            Keeper.drawWorld();

            if (System.currentTimeMillis() - clock1Sec > 1000) {
                clock1Sec += 1000;
                frame.setTitle(Keeper.gameTitle + "    |     " + "Fps: " + Keeper.getFPS() + " , Tps: " + Keeper.getTPS()
                        + ", TotalTicks: " + Keeper.getTotalTicks());
                Keeper.resetFPS();
            }
        }

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void renderOnScreen() {
        BufferStrategy BufferStrategy = getBufferStrategy();
        if (BufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }
        screen.clear();
        //level.renderLevel(16, 16, screen);

        for (int i = 0; i < pixelsInFrame.length; i++) {
            pixelsInFrame[i] = screen.pixelsScreen[i];
        }

        Graphics graphics = BufferStrategy.getDrawGraphics();
        graphics.setColor(new Color(0xFF00FF));
        graphics.fillRect(0, 0, widthFrame, heightFrame);

        graphics.drawImage(imageInFrame, 0, 0, widthFrame, heightFrame, null);
        graphics.dispose();
        BufferStrategy.show();
    }
}
