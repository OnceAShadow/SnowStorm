package com.fap.Every_Beginning.Core;

import com.fap.Every_Beginning.Graphics.Animations.ScreenDisplay;
import com.fap.Every_Beginning.Graphics.World.GameWorld;

import javax.swing.*;

public class Keeper {

    public static String gameTitle = "Every Beginning";
    public static GameWorld gameWorld;

    private static int fps = 0;
    private static int tps = 0;
    private static int totalTicks = 0;
    private static String gameWorldPath = "";
    private static DrawSlave drawSlave;

    public static GameWorld createWorld(String path, GameOn game, JFrame frame, ScreenDisplay screen) {
        drawSlave = new DrawSlave(game, frame, screen);
        gameWorldPath = path;
        gameWorld = new GameWorld(gameWorldPath);

        return(gameWorld);
    }

    public static void gameTickUp() {
        fps++;
        tps++;
        totalTicks++;
    }

    public static void resetFPS() {
        fps = 0;
        tps = 0;
    }

    public static void drawWorld() {
        drawSlave.drawWorld();
    }

    public static int getFPS() {
        return fps;
    }

    public static int getTPS() {
        return tps;
    }

    public static int getTotalTicks() {
        return totalTicks;
    }

    public static String getGameWorldPath() {
        return getGameWorldPath();
    }

}