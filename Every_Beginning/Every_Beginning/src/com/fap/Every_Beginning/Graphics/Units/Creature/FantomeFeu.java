/*
package com.fap.Gigueliou.Entite.Creature.Monstre;

import java.util.List;
import com.fap.Gigueliou.Entite.Entite;
import com.fap.Gigueliou.Entite.Creature.Creature;
import com.fap.Gigueliou.Graphique.Ecran;
import com.fap.Gigueliou.Graphique.Sprite;
import com.fap.Gigueliou.Graphique.SpriteAnimee;
import com.fap.Gigueliou.Graphique.SpriteSheet;
import com.fap.Gigueliou.Niveau.Noeud;
import com.fap.Gigueliou.Utilitees.Vecteur2i;

public class FantomeFeu extends Creature {

	private SpriteAnimee AnimationHaut = new SpriteAnimee(SpriteSheet.MonstreFantomeHaut, 16, 16, 3);
	private SpriteAnimee AnimationDroite = new SpriteAnimee(SpriteSheet.MonstreFantomeDroite, 16, 16, 3);
	private SpriteAnimee AnimationBas = new SpriteAnimee(SpriteSheet.MonstreFantomeBas, 16, 16, 3);
	private SpriteAnimee AnimationGauche = new SpriteAnimee(SpriteSheet.MonstreFantomeGauche, 16, 16, 3);
	
	private SpriteAnimee SpriteAnimeeEnCours = AnimationBas;
	
	private double xAbsolu = 0;
	private double yAbsolu = 0;
	private double VitesseMouvement = 0.7;
	private List<Noeud> Chemin = null;
	private int Temps = 0;
	
	Entite EntiteAleatoire = null;
	
	public FantomeFeu(int xInitiale, int yInitiale) {
		this.xActuelle = xInitiale * 16;
		this.yActuelle = yInitiale * 16 ;
		spriteEntite = Sprite.MonstreFantome;	
	}
	
	private void BougerFantomeFeu() {
		xAbsolu = 0;
		yAbsolu = 0;
		
		int xJoueur = (int) niveau.SaisirJoueurSpecifique(0).SaisirXActuelle() ;
		int yJoueur = (int) niveau.SaisirJoueurSpecifique(0).SaisirYActuelle() ;
		
		Vecteur2i PointDepart = new Vecteur2i((int) (SaisirXActuelle() / 16), (int) (SaisirYActuelle() /16));
		Vecteur2i Objectif = new Vecteur2i(xJoueur / 16, yJoueur / 16);
		System.out.println(PointDepart.SaisirX() + ", " + PointDepart.SaisirY() + ", " + Objectif.SaisirX() + ", " + Objectif.SaisirY());
		
		if (Temps % 3 == 0) Chemin = niveau.TrouverChemin(PointDepart, Objectif);
		System.out.println(Chemin);
		if (Chemin != null) {
			if (Chemin.size() > 0) {
				Vecteur2i Vecteur = Chemin.get(Chemin.size() - 1).Tuile;
				if (xActuelle < (Vecteur.SaisirX() * 16)) xAbsolu++;
				if (xActuelle > (Vecteur.SaisirX() * 16)) xAbsolu--;
				if (yActuelle < (Vecteur.SaisirY() * 16)) yAbsolu++;
				if (yActuelle > (Vecteur.SaisirY() * 16)) yAbsolu--;		
			}
		}
		
		if (xAbsolu !=0 || yAbsolu !=0) {
			Bouger(xAbsolu, yAbsolu);
			EnTrainBouger = true;
		} else {
			EnTrainBouger = false;
		}	
	}

	public void TickEntite() {
		Temps++;
		System.out.println(Temps);
		//BougerFantomeFeu();
		
		if (EnTrainBouger) SpriteAnimeeEnCours.TickAnimation();
		else SpriteAnimeeEnCours.DefinirImageCadre(0);
		
		if (yAbsolu < 0) {
			SpriteAnimeeEnCours = AnimationHaut;
			direction = Direction.HAUT;
		}
		
		if (xAbsolu > 0) {
			SpriteAnimeeEnCours = AnimationDroite;
			direction = Direction.DROITE;
		}
		
		if (yAbsolu > 0) {
			SpriteAnimeeEnCours = AnimationBas;
			direction = Direction.BAS;
		}
		
		if (xAbsolu < 0) {
			SpriteAnimeeEnCours = AnimationGauche;
			direction = Direction.GAUCHE;
		}		
		if (Temps % 6 == 0 ) TirerAleatoire();
		if (Temps == 6000) Temps = 0;
	}

	private void TirerAleatoire() {
		if (Temps % (30 + ALEATOIRE.nextInt(91)) == 0) {
			List<Entite> Entitees = niveau.SaisirEntitees(this, 500);
			Entitees.add(niveau.SaisirJoueurClient());
			int Index = ALEATOIRE.nextInt(Entitees.size());
		
			EntiteAleatoire = Entitees.get(Index);
		}		
		
		if (EntiteAleatoire != null) {
			double xDirection = EntiteAleatoire.SaisirXActuelle() - xActuelle;
			double yDirection = EntiteAleatoire.SaisirYActuelle() - yActuelle;
			double DirectionTir = Math.atan2(yDirection, xDirection);
				
			Attaquer(xActuelle, yActuelle, DirectionTir);
		}	
	}


	private void TirerPlusProche() {
		List<Entite> Entitees = niveau.SaisirEntitees(this, 80);
		Entitees.add(niveau.SaisirJoueurClient());
		
		double DistanceMinimum = 0;
		Entite PlusProcheEntite = null;
		
		for (int i = 0; i < Entitees.size(); i++) {
			Entite EntiteEnCours = Entitees.get(i);
			double Distance = Vecteur2i.SaisirDistanceEntreVecteur(new Vecteur2i((int) xActuelle, (int) yActuelle), new Vecteur2i((int) EntiteEnCours.SaisirXActuelle(), (int) EntiteEnCours.SaisirYActuelle())); 
			if (i == 0 || Distance < DistanceMinimum) {
				DistanceMinimum = Distance;
				PlusProcheEntite = EntiteEnCours;
			}			
		}
	
		if (PlusProcheEntite != null) {
			double xDirection = PlusProcheEntite.SaisirXActuelle() - xActuelle;
			double yDirection = PlusProcheEntite.SaisirYActuelle() - yActuelle;
			double DirectionTir = Math.atan2(yDirection, xDirection);
			
			Attaquer(xActuelle, yActuelle, DirectionTir);
		}		
	}

	public void RenduEntite(Ecran Ecran) {
		int xPrecision = 2;
		int yPrecision = 3;
		
		spriteEntite = SpriteAnimeeEnCours.SaisirSprite();
	    //Debug.DessinerRectangle(Ecran, 26 * 16, 36 * 16, 100, 40, true);
		//Debug.DessinerRectangle(Ecran, 240, 130, 100, 40, false);
		
		Ecran.RenduCreature((int)(xActuelle - xPrecision), (int)(yActuelle - yPrecision), this);				
	}
}
*/