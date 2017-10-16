package com.fap.Every_Beginning.Graphics.World;

import javax.imageio.ImageIO;

import com.fap.Every_Beginning.Graphics.Animations.Sprite;
import com.fap.Every_Beginning.Graphics.World.Tiles.Tile;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameWorld {                                                                             

    private int widthLevel;
    private int heightLevel;
    private Tile[] levelTiles;

    public static Tile tile_H = new Tile(Sprite.spriteR);
    public static Tile tile_G = new Tile(Sprite.spriteG);

    public GameWorld(String path) {
        loadLevel(path);
    }

    private void loadLevel(String path) {
        try {
        	System.out.println(path);
            BufferedImage worldTiles = ImageIO.read(LevelWorld.class.getResource(path));
            widthLevel = worldTiles.getWidth();
            heightLevel = worldTiles.getHeight();
            levelTiles = new Tile[widthLevel * heightLevel];
        	System.out.println(levelTiles.length);

            for (int i = 0; i < levelTiles.length; i++) {
                levelTiles[i].sprite = Sprite.spriteG;
            	levelTiles[i].phySpec = 2;
            }
        } catch (IOException e) {
        }
    }
    
    public int getWidthLevel() {
    	return widthLevel;
    }
    
    public int getHeightLevel() {
    	return heightLevel;
    }
    
    public Tile[] getTile() {
    	return levelTiles;
    }
}
