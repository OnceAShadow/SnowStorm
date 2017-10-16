package com.fap.Every_Beginning.Graphics.World.Tiles;

import com.fap.Every_Beginning.Graphics.Animations.Sprite;

public class Tile {

    public int x;
    public int y;
    public Sprite sprite;
    public int phySpec;



    
    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }
    
    public int getPhySpec() {
    	return phySpec;
    }
}