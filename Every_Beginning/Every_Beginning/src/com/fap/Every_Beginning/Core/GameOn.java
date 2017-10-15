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

    private static int screenWidth = 800;
    private static int screenHeight = 600;

    protected JFrame frame;
    private Thread thread;
    private ScreenDisplay screen;
    private boolean running;

    public GameOn () {
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        screen = new ScreenDisplay(screenWidth, screenHeight);
        frame = new JFrame();
        frame.setResizable(false);

        Keeper.createWorld("/LevelStart.png", this, frame, screen);
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
}