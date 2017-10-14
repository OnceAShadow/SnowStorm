/*
package com.fap.Every_Beginning.Graphics.Animations;

import java.util.Random;
//import com.fap.Every_Beginning.Graphics.Animations.Entite.Creature.Creature;
//import com.fap.Gigueliou.Entite.Creature.Monstre.FantomeFeu;
//import com.fap.Gigueliou.Entite.Creature.Monstre.FantomeFutee;
//import com.fap.Gigueliou.Entite.Creature.Monstre.FantomeSuiveur;
//import com.fap.Every_Beginning.Graphics.Projectiles.Projectile;
//import com.fap.Every_Beginning.Graphics.Niveau.Tuile.Tuile;

public class Ecran {
	public int LargeurEcran, HauteurEcran;
	public int[] PixelsEcran;
	public int LargeurNiveau = 8;
	public int HauteurNiveau = 8;
	public int QuantiteTuilesNiveau = LargeurNiveau * HauteurNiveau;
	public int LargeurTuile = 16;
	public int HauteurTuile = 16;
	public int PlageLargeurNiveau = LargeurNiveau - 1;
	public int PlageHauteurNiveau = HauteurNiveau - 1;
	public int xDecallage, yDecallage;
	
	private final int ALPHA_COULEUR1 = 0xFFFF00FF;
	private final int ALPHA_COULEUR2 = 0xff7f007f;
	
	public int[] Tuiles = new int[LargeurNiveau * HauteurNiveau];
	private Random Aleatoire = new Random();
	
	public Ecran(int LargeurEcran, int HauteurEcran) {
		this.LargeurEcran = LargeurEcran;
		this.HauteurEcran = HauteurEcran;
		
		PixelsEcran = new int[LargeurEcran * HauteurEcran];
		
		
		for (int i = 0; i < QuantiteTuilesNiveau; i++) {
			Tuiles[i] = Aleatoire.nextInt(0xffffff);
		}
	}
	
	public void Liberer() {
			for (int i = 0; i < PixelsEcran.length; i++) {
			PixelsEcran[i] = 0;
		}
	}
	
	public void RenduEcran(int xDecallage, int yDecallage) {
	}
	
	public void RenduSpriteSheet(int xPosition, int yPosition, SpriteSheet SpriteSheet, boolean Fixee) {
		if (Fixee) {
			xPosition -= xDecallage;
			yPosition -= yDecallage;
		}
			
		for (int y = 0; y < SpriteSheet.HAUTEUR_SPRITE; y++) {
			int yAbsolu = y + yPosition;
			for (int x = 0; x < SpriteSheet.LARGEUR_SPRITE; x++) {
				int xAbsolu = x + xPosition;
				if (xAbsolu < 0 || xAbsolu >=  LargeurEcran || yAbsolu < 0 || yAbsolu >= HauteurEcran);
				PixelsEcran[xAbsolu + yAbsolu * LargeurEcran] = SpriteSheet.PixelsSpriteSheet[x + y * SpriteSheet.LARGEUR_SPRITE];			
			}
		}
	}
	
	public void RenduTexte(int xPosition, int yPosition, Sprite Sprite, boolean Fixee, int Couleur) {
		if (Fixee) {
			xPosition -= xDecallage;
			yPosition -= yDecallage;
		}
			
		for (int y = 0; y < Sprite.SaisirHauteurSprite(); y++) {
			int yAbsolu = y + yPosition;
			for (int x = 0; x < Sprite.GetWidthSprite(); x++) {
				int xAbsolu = x + xPosition;
				if (xAbsolu < 0 || xAbsolu >=  LargeurEcran || yAbsolu < 0 || yAbsolu >= HauteurEcran) continue;
				int Coul =  Sprite.PixelsSprite[x + y * Sprite.GetWidthSprite()];
				if (Coul  != ALPHA_COULEUR1 && Coul  != ALPHA_COULEUR2) {
				PixelsEcran[xAbsolu + yAbsolu * LargeurEcran] = Couleur;
				}
			}
		}
	}
	
	public void RenduSprite(int xPosition, int yPosition, Sprite Sprite, boolean Fixee) {
		if (Fixee) {
			xPosition -= xDecallage;
			yPosition -= yDecallage;
		}
			
		for (int y = 0; y < Sprite.SaisirHauteurSprite(); y++) {
			int yAbsolu = y + yPosition;
			for (int x = 0; x < Sprite.GetWidthSprite(); x++) {
				int xAbsolu = x + xPosition;
				if (xAbsolu < 0 || xAbsolu >=  LargeurEcran || yAbsolu < 0 || yAbsolu >= HauteurEcran) continue;
				int Couleur =  Sprite.PixelsSprite[x + y * Sprite.GetWidthSprite()];
				if (Couleur  != ALPHA_COULEUR1 && Couleur  != ALPHA_COULEUR2) {
				PixelsEcran[xAbsolu + yAbsolu * LargeurEcran] = Couleur;
				}
			}
		}
	}
	
	public void RenduTuile(int xPosition, int yPosition, Tuile Tuile) {
		xPosition -= xDecallage;
		yPosition -= yDecallage;
			
		for (int y = 0; y < Tuile.sprite.DIMENSIONSPRITE; y++) {
			int yAbsolu = y + yPosition;
			
			for (int x = 0; x < Tuile.sprite.DIMENSIONSPRITE; x++) {
				int xAbsolu = x + xPosition;
				if (xAbsolu < - 16 || xAbsolu >= LargeurEcran || yAbsolu < 0 || yAbsolu >= HauteurEcran) break;
				if (xAbsolu < 0) xAbsolu = 0;
				
				PixelsEcran[xAbsolu + yAbsolu * LargeurEcran] = Tuile.sprite.PixelsSprite[x + y * Tuile.sprite.DIMENSIONSPRITE];
			}
		}
	}
	
	public void RenduCreature(int xPosition, int yPosition, Creature Creature) {
		xPosition -= xDecallage;
		yPosition -= yDecallage;
			
		for (int y = 0; y < Creature.SaisirSprite().SaisirHauteurSprite(); y++) {
			int yAbsolu = y + yPosition;
			
			for (int x = 0; x < Creature.SaisirSprite().GetWidthSprite(); x++) {
				int xAbsolu = x + xPosition;
				if (xAbsolu < - Creature.SaisirSprite().GetWidthSprite() || xAbsolu >= LargeurEcran || yAbsolu < 0 || yAbsolu >= HauteurEcran) break;
				if (xAbsolu < 0) xAbsolu = 0;
				
				int Couleur = Creature.SaisirSprite().PixelsSprite[x + y * Creature.SaisirSprite().GetWidthSprite()];  
				if ((Creature instanceof FantomeSuiveur) && Couleur == 0xFFF30401) Couleur = 0xffE7EF00;
				if ((Creature instanceof FantomeFutee) && Couleur == 0xFFF30401) Couleur = 0xfFF9900;
				if ((Creature instanceof FantomeFeu) && Couleur == 0xFFF30401) Couleur = 0xfbb5058;
				
				if (Couleur  != ALPHA_COULEUR1) {
						PixelsEcran[xAbsolu + yAbsolu * LargeurEcran] = Couleur;
				}		
			}			
		}
	}
	
	public void RenduCreature(int xPosition, int yPosition, Sprite Sprite) {
		xPosition -= xDecallage;
		yPosition -= yDecallage;
			
		for (int y = 0; y < Sprite.SaisirHauteurSprite(); y++) {
			int yAbsolu = y + yPosition;
			
			for (int x = 0; x < Sprite.GetWidthSprite(); x++) {
				int xAbsolu = x + xPosition;
				if (xAbsolu < - Sprite.GetWidthSprite() || xAbsolu >= LargeurEcran || yAbsolu < 0 || yAbsolu >= HauteurEcran) break;
				if (xAbsolu < 0) xAbsolu = 0;
				
				int Couleur = Sprite.PixelsSprite[x + y * Sprite.GetWidthSprite()];
				if (Couleur  != ALPHA_COULEUR1) {
				PixelsEcran[xAbsolu + yAbsolu * LargeurEcran] = Couleur;
				}
			}
		}
	}
	
	public void RenduProjectile(int xPosition, int yPosition, Projectile Projectile) {
		xPosition -= xDecallage;
		yPosition -= yDecallage;
			
		for (int y = 0; y < Projectile.SaisirSpriteDimension(); y++) {
			int yAbsolu = y + yPosition;
			
			for (int x = 0; x < Projectile.SaisirSpriteDimension(); x++) {
				int xAbsolu = x + xPosition;
				if (xAbsolu < - Projectile.SaisirSpriteDimension() || xAbsolu >= LargeurEcran || yAbsolu < 0 || yAbsolu >= HauteurEcran) break;
				if (xAbsolu < 0) xAbsolu = 0;
				
				int Couleur = Projectile.SaisirSprite().PixelsSprite[x + y * Projectile.SaisirSprite().DIMENSIONSPRITE];
				if (Couleur != ALPHA_COULEUR1 && Couleur != ALPHA_COULEUR2) {
				PixelsEcran[xAbsolu + yAbsolu * LargeurEcran] = Couleur;
				}
			}
		}
	}
			
	public void DefinirDecallage(int xDecallage, int yDecallage) {
		this.xDecallage = xDecallage;
		this.yDecallage = yDecallage;
	}

	public void DessinerRectangle(int xPosition, int yPosition, int LargeurDebug, int HauteurDebug, int Couleur, boolean Fixee) {
		if (Fixee) {
			xPosition -= xDecallage;
			yPosition -= yDecallage;
		}
				
		for (int x = xPosition; x < xPosition + LargeurDebug; x++) {
			 if (x >= this.LargeurEcran || x < 0 || yPosition >= this.HauteurEcran) continue; 
			 if (yPosition > 0) PixelsEcran[x + yPosition * this.LargeurEcran] = Couleur; 
			 if (yPosition + HauteurDebug >= this.HauteurEcran) continue;
			 if (yPosition + HauteurDebug > 0) PixelsEcran[x + (yPosition + HauteurDebug) * this.LargeurEcran] = Couleur;
			 
		 }
		 
		 for (int y = yPosition; y <= yPosition + HauteurDebug; y++) {
			 if (xPosition >= this.LargeurEcran || y < 0 || y >= this.HauteurEcran) continue; 
			 if (xPosition > 0) PixelsEcran[xPosition + y * this.LargeurEcran] = Couleur;
			 if (xPosition + LargeurDebug >= this.LargeurEcran) continue;
			 if (xPosition + LargeurDebug > 0) PixelsEcran[(xPosition + LargeurDebug) + y * this.LargeurEcran] = Couleur;
			 
		 }	
	}
}
*/