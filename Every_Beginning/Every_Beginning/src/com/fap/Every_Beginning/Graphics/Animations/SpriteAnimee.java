/*
package com.fap.Gigueliou.Graphique;

public class SpriteAnimee extends Sprite {
	private int ImageCadre = 0;
	private Sprite sprite;
	private int Cadence = 5;
	private int LongueurAnimation = -1;
	private int Temps = 0;
	
	public SpriteAnimee(SpriteSheet SpriteSheet, int LargeurSprite, int HauteurSprite, int LongueurAnimation) {
		super(SpriteSheet, LargeurSprite, HauteurSprite);
		this.LongueurAnimation = LongueurAnimation;
		sprite = SpriteSheet.SaisirSprites() [0];
		if (LongueurAnimation > SpriteSheet.SaisirSprites().length) System.err.println("Erreur!");
	}
	
	public void TickAnimation() {
		Temps++;
		if (Temps % Cadence == 0) {
			if (ImageCadre >= LongueurAnimation - 1) ImageCadre = 0;
			else ImageCadre++;
			sprite = spriteSheet.SaisirSprites()[ImageCadre];
		}
		// System.out.println(sprite + ", ImageCadre : " + ImageCadre);	
	}
		
	public Sprite SaisirSprite() {
		return sprite;
	}
	
	public void DefinirImageCadreCadence(int ImagesCadres) {
		Cadence = ImagesCadres;
	}

	public void DefinirImageCadre(int Index) {
		
		if (Index > spriteSheet.SaisirSprites().length - 1) {
			return;
		}
		sprite = spriteSheet.SaisirSprites()[Index];
	}	
}
*/