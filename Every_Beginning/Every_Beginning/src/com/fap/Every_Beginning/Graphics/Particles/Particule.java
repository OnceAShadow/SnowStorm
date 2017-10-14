/*
package com.fap.Gigueliou.Entite.Particule;

import com.fap.Gigueliou.Entite.Entite;
import com.fap.Gigueliou.Graphique.Ecran;
import com.fap.Gigueliou.Graphique.Sprite;

public class Particule extends Entite{
	
	private Sprite SpriteParticule;
	private int DureeDeVie;
	private int Temps = 0;
	
	protected double xAbsolu, yAbsolu, zAbsolu; 
	protected double xActuelleDouble, yActuelleDouble, zActuelleDouble;
	
	
	public Particule(int xPosition, int yPosition, int DureeDeVie){
		this.xActuelle = xPosition;
		this.yActuelle = yPosition;
		this.xActuelleDouble = xPosition;
		this.yActuelleDouble = yPosition;
		this.DureeDeVie = DureeDeVie + ALEATOIRE.nextInt(20) - 10;
		SpriteParticule = Sprite.Particules1;
		
		this.xAbsolu = ALEATOIRE.nextGaussian();
		
		this.yAbsolu = ALEATOIRE.nextGaussian();
		this.zActuelleDouble= ALEATOIRE.nextFloat() + 2.0 ;
		
	}
		
	public void TickEntite() {
		Temps++;
		if(Temps > 10000) Temps = 0;
		if (Temps > DureeDeVie) Retirer();
		
		zAbsolu -= 0.1;
		if (zActuelleDouble < 0) {
		zActuelleDouble = 0;
		zAbsolu *= -0.6; 
		xAbsolu *= 0.4;
		yAbsolu *= 0.4;
		
		}
		BougerParticule((xActuelleDouble + xAbsolu), (yActuelleDouble + yAbsolu) + (zActuelleDouble + zAbsolu));	
	}
	
	private void BougerParticule(double xPosition, double yPosition) {
		if (CollisionParticuleTuile(xPosition, yPosition)) {
			this.xAbsolu *= -0.5;
			this.yAbsolu *= -0.5;
			this.zAbsolu *= -0.5;
			
		}
		this.xActuelleDouble += xAbsolu;
		this.yActuelleDouble += yAbsolu;
		this.zActuelleDouble += zAbsolu;
	}
	
	public boolean CollisionParticuleTuile(double xActuelle, double yActuelle) {
		boolean Solide = false;
		for (int c = 0; c < 4; c++) {
			double xTemporaire = (xActuelle - c % 2 * 16) / 16;
			double yTemporaire = (yActuelle - c / 2 * 16) / 16;
			
			int xTemporaireInt = (int) Math.ceil(xTemporaire);
			int yTemporaireInt = (int) Math.ceil(yTemporaire);
					
			if (c % 2 == 0) xTemporaireInt = (int) Math.floor(xTemporaire);
			if (c / 2 == 0) yTemporaireInt = (int) Math.floor(yTemporaire);
		
			if (niveau.SaisirTuileHUB(xTemporaireInt, yTemporaireInt).Solide()) Solide = true;
		}return Solide;
	}

	public void RenduEntite(Ecran Ecran) {
		int xPrecisionParticule = 0, yPrecisionParticule = 0;
		int xPrecisionParticuleCollision = 1, yPrecisionParticuleCollision = 1;
		
		Ecran.RenduSprite(((int) xActuelleDouble) - xPrecisionParticule - xPrecisionParticuleCollision, ((int)yActuelleDouble) - yPrecisionParticule - yPrecisionParticuleCollision - (int) zActuelleDouble, SpriteParticule, true); 
	}	
}
*/