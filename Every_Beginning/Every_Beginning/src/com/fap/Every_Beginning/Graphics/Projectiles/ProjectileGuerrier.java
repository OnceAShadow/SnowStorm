/*
package com.fap.Gigueliou.Entite.Projectile;

import com.fap.Gigueliou.Entite.GenerateurEntite.GenerateurParticule;
import com.fap.Gigueliou.Graphique.Ecran;
import com.fap.Gigueliou.Graphique.Sprite;

public class ProjectileGuerrier extends Projectile {
	public static final int CADENCE_DE_TIR = 5;
	private int DimensionEntite = 11;
	private int xDecallageCollision = 7;
	private int yDecallageCollision = 9;
		
	public ProjectileGuerrier(double xActuelle, double yActuelle, double DirectionAttaque) {
		super(xActuelle, yActuelle, DirectionAttaque);
		VitesseProjectile = 4;
		PorteeAttaque = 500;
		DommageProjectile = 15;
		SpriteProjectile = Sprite.Rotationner(Sprite.ProjectileGuerrier2, AngleDeTir);
						
		xEnCours = VitesseProjectile * Math.cos(AngleDeTir);
		yEnCours = VitesseProjectile * Math.sin(AngleDeTir);			
	}
	
	public void TickEntite() {
		if (niveau.CollisionEntiteTuile((int) (xActuelle + xEnCours), (int) (yActuelle + yEnCours), DimensionEntite, xDecallageCollision, yDecallageCollision)) {
			niveau.AjouterEntite(new GenerateurParticule((int) xActuelle, (int) yActuelle, 56, 30, niveau));			
			Retirer();
		}
		BougerProjectile();
	}

	protected void BougerProjectile() {
		xActuelle += xEnCours; 
		yActuelle += yEnCours;
		
		if (DistanceParcourueProjectile() > PorteeAttaque) Retirer();	
	}
	
	private double DistanceParcourueProjectile() {
		double DistanceParcourueProjectile = 0;
		DistanceParcourueProjectile = Math.sqrt(Math.abs(((XORIGINE - xActuelle) * (XORIGINE - xActuelle)) + ((YORIGINE - yActuelle) *(YORIGINE - yActuelle))));
		return DistanceParcourueProjectile;
	
	}
	
	public void RenduEntite(Ecran Ecran) {
		// System.out.println(AngleDeTir);
		int xPrecisionProjectile = -6;
		int yPrecisionProjectile = -4;
		Ecran.RenduProjectile((int) (xActuelle + xPrecisionProjectile), (int) (yActuelle +  yPrecisionProjectile), this) ;
	}	
}
*/