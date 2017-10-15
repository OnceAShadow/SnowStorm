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
import com.fap.Every_Beginning.Graphics.World.Level;

public class GameOn extends Canvas implements Runnable {

    private static int widthResolution = 800;
    private static int heightResolution = 600;
    private static int widthFrame = widthResolution;
    private static int heightFrame = heightResolution;

    protected  JFrame frame;
    private Thread thread;
    private ScreenDisplay screen;
    private Level level;
    private boolean running;

    private BufferedImage imageInFrame = new BufferedImage(widthFrame, heightFrame, BufferedImage.TYPE_INT_RGB);
    private int[] pixelsInFrame = ((DataBufferInt) imageInFrame.getRaster().getDataBuffer()).getData();

    public GameOn () {
        Dimension frameResolution = new Dimension(widthFrame, heightFrame);
        setPreferredSize(frameResolution);

        screen = new ScreenDisplay(widthResolution, heightResolution);
        frame = new JFrame();
        frame.setResizable(false);

        level = Keeper.createWordl("/LevelStart.png");
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

            tickGame();
            Keeper.gameTickUp();

            if (System.currentTimeMillis() - clock1Sec > 1000) {
                clock1Sec += 1000;
                frame.setTitle(Keeper.gameTitle + "    |     " + "Fps: " + Keeper.getFPS() + " , Tps: " + Keeper.getTPS()
                        + ", TotalTicks: " + Keeper.getTotalTicks());

                renderOnScreen();
                Keeper.resetFPS();
            }
        }

        Stop();
    }

    public void tickGame() {
        level.tickLevel();
    }

    public void renderOnScreen() {
        BufferStrategy BufferStrategy = getBufferStrategy();
        if (BufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();

        level.renderLevel(16, 16, screen);

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

    public synchronized void Stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
