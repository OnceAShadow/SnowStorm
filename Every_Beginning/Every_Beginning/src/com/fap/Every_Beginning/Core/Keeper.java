package com.fap.Every_Beginning.Core;

import com.fap.Every_Beginning.Graphics.World.Level;
import com.fap.Every_Beginning.Graphics.World.LevelWorld;

public class Keeper {

    public static String gameTitle = "Every Beginning";
    private static int fps = 0;
    private static int tps = 0;
    private static int totalTicks = 0;

    public static Level createWordl(String path) {
        return(new LevelWorld(path));
    }

    public static void gameTickUp() {
        fps++;
        tps++;
        totalTicks++;
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

    public static void resetFPS() {
        fps = 0;
        tps = 0;
    }
}
