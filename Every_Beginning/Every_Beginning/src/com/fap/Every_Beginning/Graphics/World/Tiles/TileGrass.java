package com.fap.Every_Beginning.Graphics.World.Tiles;

import com.fap.Every_Beginning.Graphics.Animations.ScreenDisplay;
import com.fap.Every_Beginning.Graphics.Animations.Sprite;

public class TileGrass extends Tile {

	public TileGrass(Sprite Sprite) {
		super(Sprite);
		
	}
	
	public void RenderTile(int x, int y, ScreenDisplay Screen) {
		Screen.RenderTile(x / 64, y / 64, this);
	}

	public boolean Solid() {
		return false;
	}

}
