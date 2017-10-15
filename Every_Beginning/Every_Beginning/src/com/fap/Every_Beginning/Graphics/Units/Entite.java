package com.fap.Every_Beginning.Graphics.Units;

import com.fap.Every_Beginning.Graphics.Animations.ScreenDisplay;
import com.fap.Every_Beginning.Graphics.Animations.Sprite;
import com.fap.Every_Beginning.Graphics.World.Level;

public class Entite {

	protected double currentX, currentY;
	private boolean isRemoved = false;
	protected Level level;
	protected Sprite spriteEntity;
	
	public Entite() {
	}
	
	public Entite(int xPosition, int yPosition, Sprite sprite) {
		this.currentX = xPosition;
		this.currentY = yPosition;
		this.spriteEntity = sprite;
	}
	
	public void tickEntity() {
	}
	
	public void renderEntity(ScreenDisplay screen) {
		if (spriteEntity != null) screen.renderSprite((int) currentX, (int) currentY, spriteEntity, true);
	}
	
	public void retirer() {
		isRemoved = true;
	}
	
	public Sprite saisirSprite() {
		return spriteEntity;
	}
	
	public double saisirXActuelle() {
		return currentX;
	}
	
	public double saisirYActuelle() {
		return currentY;
	}

	public boolean isRemoved() {
		return isRemoved;
	}
	
	public void initialiser(Level level) {
		this.level = level;
	}
}