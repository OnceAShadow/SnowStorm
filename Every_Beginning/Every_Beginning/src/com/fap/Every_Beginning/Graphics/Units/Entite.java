package com.fap.Every_Beginning.Graphics.Units;

import com.fap.Every_Beginning.Graphics.Animations.ScreenDisplay;
import com.fap.Every_Beginning.Graphics.Animations.Sprite;
//import com.fap.Every_Beginning.Graphics.World.Niveau;

public class Entite {

	protected double xActuelle, yActuelle;
	private boolean EstRetiree = false;
	//protected Niveau niveau;
	protected Sprite spriteEntite;
	
	public Entite() {
	}
	
	public Entite(int xPosition, int yPosition, Sprite Sprite) {
		this.xActuelle = xPosition;
		this.yActuelle = yPosition;
		this.spriteEntite = Sprite;
	}
	
	public void TickEntite() {
	}
	
	public void RenduEntite(ScreenDisplay Screen) {
		if (spriteEntite != null) Screen.RenduSprite((int) xActuelle, (int) yActuelle, spriteEntite, true);
	}
	
	public void Retirer() {
		EstRetiree = true;
	}
	
	public Sprite SaisirSprite() {
		return spriteEntite;
	}
	
	public double SaisirXActuelle() {
		return xActuelle;
	}
	
	public double SaisirYActuelle() {
		return yActuelle;
	}

	public boolean EstRetiree() {
		return EstRetiree;
	}
	
//	public void Initialiser(Niveau Niveau) {
//		this.niveau = Niveau;
//	}
}