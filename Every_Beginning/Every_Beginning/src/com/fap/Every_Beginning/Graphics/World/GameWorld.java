package com.fap.Every_Beginning.Graphics.World;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameWorld {

    private int widthLevel;
    private int heightLevel;
    private int[] levelTiles;

    public GameWorld(String path) {
        loadLevel(path);
    }

    private void loadLevel(String path) {
        try {
            BufferedImage worldTiles = ImageIO.read(LevelWorld.class.getResource(path));
            widthLevel = worldTiles.getWidth();
            heightLevel = worldTiles.getHeight();
            levelTiles = new int[widthLevel * widthLevel];
            worldTiles.getRGB(0, 0, widthLevel, heightLevel, levelTiles, 0, widthLevel);
        } catch (IOException e) {
        }
    }
}
