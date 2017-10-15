package com.fap.Every_Beginning.Graphics.Units.Creature;

import com.fap.Every_Beginning.Graphics.Animations.ScreenDisplay;
import com.fap.Every_Beginning.Graphics.Units.Entite;
//import com.fap.Every_Beginning.Graphics.Projectiles.Projectile;
//import com.fap.Every_Beginning.Graphics.Projectiles.ProjectileGuerrier;

public abstract class Creature extends Entite {
	
	protected boolean walking = false;
	protected int hp, mp, xp;
	protected double hpMax, mpMax, xpMax;
	protected double hpPercent, mpPercent, xpPercent;

	protected enum Direction {
		UP, RIGHT, DOWN, LEFT
	}
	
	protected Direction direction;

	protected void move(double xAbsolu, double yAbsolu) {
		
		if (xAbsolu > 0) direction = Direction.RIGHT;
		if (xAbsolu < 0) direction = Direction.LEFT;
		if (yAbsolu > 0) direction = Direction.UP;
		if (yAbsolu < 0) direction = Direction.DOWN;
			
		while (xAbsolu != 0) {
			if (Math.abs(xAbsolu) > 1) {
				if (!collisionCreatureTuile(absolue(xAbsolu), yAbsolu)) {
					this.currentX += absolue(xAbsolu);
				} 
				xAbsolu -= absolue(xAbsolu);
			}	else {
				if (!collisionCreatureTuile(absolue(xAbsolu), yAbsolu)) {
					this.currentX += xAbsolu;
				} 
				xAbsolu = 0;
			}
		}
		while (yAbsolu != 0) {
			if (Math.abs(yAbsolu) > 1) {
				if (!collisionCreatureTuile(xAbsolu, absolue(yAbsolu))) {
					this.currentY += absolue(yAbsolu);
				} 
				yAbsolu -= absolue(yAbsolu);
			}	else {
				if (!collisionCreatureTuile(xAbsolu, absolue(yAbsolu))) {
					this.currentY += yAbsolu;
				} 
				yAbsolu = 0;
			}
		}
						
	}
	
	private int absolue(double Valeur) {
		if (Valeur < 0) return -1;
		return 1;
	}
	
	public abstract void tickEntity();
	public abstract void RenderEntity(ScreenDisplay screen);
	
	protected void Attaquer(double currentX, double currentY, double attackDirection) {
		//DirectionAttaque *= (180/Math.PI);
//		Projectile ProjectileEnCours = new ProjectileGuerrier(xActuelle, yActuelle, DirectionAttaque);
//		niveau.AjouterEntite(ProjectileEnCours);
	}

	private boolean collisionCreatureTuile(double xAbsolu, double yAbsolu) {
		boolean solid = false;
		/*
		for (int c = 0; c < 4; c++) {
			double xTemporaire = ((xActuelle + xAbsolu) - (c % 2) * 3) / 16;
			double yTemporaire = ((yActuelle + yAbsolu) - (c / 2) * 3) / 16;
			int xTemporaireInt = (int) Math.ceil(xTemporaire);
			int yTemporaireInt = (int) Math.ceil(yTemporaire);
		
			if (c % 2 == 0) xTemporaireInt = (int) Math.floor(xTemporaire);
			if (c / 2 == 0) yTemporaireInt = (int) Math.floor(yTemporaire);
			if (niveau.SaisirTuileHUB(xTemporaireInt, yTemporaireInt).Solide()) Solide = true;
		} 
		 */
		return solid;
	}
}