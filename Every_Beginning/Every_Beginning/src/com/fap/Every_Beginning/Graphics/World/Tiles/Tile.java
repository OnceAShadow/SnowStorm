package com.fap.Every_Beginning.Graphics.World.Tiles;

import com.fap.Every_Beginning.Core.GameOn;
import com.fap.Every_Beginning.Graphics.Animations.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Tile {

    public int x;
    public int y;
    public Sprite sprite;
    public int phySpec;

    BufferedImage imageInTile;
    int[] pixelsInTile;
    Graphics graphics;

    public Tile(Sprite sprite) {
        this.sprite = sprite;
        imageInTile = new BufferedImage(sprite.widthSprite, sprite.heightSprite, BufferedImage.TYPE_INT_RGB);
        pixelsInTile = ((DataBufferInt) imageInTile.getRaster().getDataBuffer()).getData();
    }
    
    public int getPhySpec() {
    	return phySpec;
    }

    public void drawTile(int x, int y, GameOn game) {
        imageInTile.getGraphics().drawImage(imageInTile, x * sprite.widthSprite, y * sprite.heightSprite, sprite.widthSprite,  sprite.heightSprite,  null);
    }
}