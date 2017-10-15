package com.fap.Every_Beginning.Graphics.World.Tiles;

import com.fap.Every_Beginning.Graphics.Animations.ScreenDisplay;
import com.fap.Every_Beginning.Graphics.Animations.Sprite;

public class TileGrass extends Tile {
	
	
	public TileGrass(Sprite sprite) {
		super(sprite);
		
	}
	
	public void renderTile(int x, int y, ScreenDisplay screen) {
	//	System.out.println((x << 6) + "  ..  " +  "  ..  " + (y << 6));

		screen.renderTile(x << 6, y << 6, this);
		
	}

	public boolean solid() {
		return false;
	}

}
