package com.fap.Every_Beginning.Graphics.World.Tiles;

import com.fap.Every_Beginning.Graphics.Animations.Sprite;

public class Tile {

    public int x;
    public int y;
    public Sprite sprite;
    public int phySpec;

    public static Tile tile_G = new Tile(Sprite.spriteG);
    public static Tile tile_H = new Tile(Sprite.spriteR);
    
    
    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }
}