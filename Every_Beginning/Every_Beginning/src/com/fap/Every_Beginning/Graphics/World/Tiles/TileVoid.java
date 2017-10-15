package com.fap.Every_Beginning.Graphics.World.Tiles;

import com.fap.Every_Beginning.Graphics.Animations.ScreenDisplay;
import com.fap.Every_Beginning.Graphics.Animations.Sprite;

public class TileVoid extends Tile {

	public TileVoid(Sprite sprite) {
		super(sprite);
		
	}
	
	public void renderTile(int x, int y, ScreenDisplay screen) {
		
		screen.renderTile(x / 64, y / 64, this);
	}

	public boolean solid() {
		return true;
	}

}
