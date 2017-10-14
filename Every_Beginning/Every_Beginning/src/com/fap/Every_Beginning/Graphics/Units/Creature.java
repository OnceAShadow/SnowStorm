package com.fap.Every_Beginning.Graphics.Units;
import com.fap.Every_Beginning.Graphics.Animations.Ecran;

//import com.fap.Every_Beginning.Graphics.Units.Entite;
//import com.fap.Every_Beginning.Graphics.Projectiles.Projectile;
//import com.fap.Every_Beginning.Graphics.Projectiles.ProjectileGuerrier;

public abstract class Creature extends Entite {
	
	protected boolean EnTrainBouger = false;
	protected int PointVie, PointMagie, PointExperience;
	protected double PointVieMaximum, PointMagieMaximum, PointExperienceMaximum;
	protected double PointViePourcentage, PointMagiePourcentage, PointExperiencePourcentage;

	protected enum Direction {
		HAUT, DROITE, BAS, GAUCHE
	}
	
	protected Direction direction;

	protected void Bouger(double xAbsolu, double yAbsolu) {
		
		if (xAbsolu > 0) direction = Direction.DROITE;
		if (xAbsolu < 0) direction = Direction.GAUCHE;
		if (yAbsolu > 0) direction = Direction.HAUT;
		if (yAbsolu < 0) direction = Direction.BAS;
			
		while (xAbsolu != 0) {
			if (Math.abs(xAbsolu) > 1) {
				if (!CollisionCreatureTuile(Absolue(xAbsolu), yAbsolu)) {
					this.xActuelle += Absolue(xAbsolu);
				} 
				xAbsolu -= Absolue(xAbsolu);
			}	else {
				if (!CollisionCreatureTuile(Absolue(xAbsolu), yAbsolu)) {
					this.xActuelle += xAbsolu;
				} 
				xAbsolu = 0;
			}
		}
		while (yAbsolu != 0) {
			if (Math.abs(yAbsolu) > 1) {
				if (!CollisionCreatureTuile(xAbsolu, Absolue(yAbsolu))) {
					this.yActuelle += Absolue(yAbsolu);
				} 
				yAbsolu -= Absolue(yAbsolu);
			}	else {
				if (!CollisionCreatureTuile(xAbsolu, Absolue(yAbsolu))) {
					this.yActuelle += yAbsolu;
				} 
				yAbsolu = 0;
			}
		}
						
	}
	
	private int Absolue(double Valeur) {
		if (Valeur < 0) return -1;
		return 1;
	}
	
	public abstract void TickEntite();
	public abstract void RenduEntite(Ecran Ecran);
	
	protected void Attaquer(double xActuelle, double yActuelle, double DirectionAttaque) {
		//DirectionAttaque *= (180/Math.PI);
		Projectile ProjectileEnCours = new ProjectileGuerrier(xActuelle, yActuelle, DirectionAttaque);
		niveau.AjouterEntite(ProjectileEnCours);
	}

	private boolean CollisionCreatureTuile(double xAbsolu, double yAbsolu) {
		boolean Solide = false;
		for (int c = 0; c < 4; c++) {
			double xTemporaire = ((xActuelle + xAbsolu) - (c % 2) * 3) / 16;
			double yTemporaire = ((yActuelle + yAbsolu) - (c / 2) * 3) / 16;
			int xTemporaireInt = (int) Math.ceil(xTemporaire);
			int yTemporaireInt = (int) Math.ceil(yTemporaire);
		
			if (c % 2 == 0) xTemporaireInt = (int) Math.floor(xTemporaire);
			if (c / 2 == 0) yTemporaireInt = (int) Math.floor(yTemporaire);
			if (niveau.SaisirTuileHUB(xTemporaireInt, yTemporaireInt).Solide()) Solide = true;
		} 
		return Solide;
	}
}