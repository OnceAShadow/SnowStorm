/*
package com.fap.Gigueliou.Entite.Creature.Monstre;

import java.util.List;
import com.fap.Gigueliou.Entite.Creature.Creature;
import com.fap.Gigueliou.Entite.Creature.Joueur.Joueur;
import com.fap.Gigueliou.Graphique.Ecran;
import com.fap.Gigueliou.Graphique.Sprite;
import com.fap.Gigueliou.Graphique.SpriteAnimee;
import com.fap.Gigueliou.Graphique.SpriteSheet;

public class FantomeSuiveur extends Creature{
	
	private SpriteAnimee AnimationHaut = new SpriteAnimee(SpriteSheet.MonstreFantomeHaut, 16, 16, 3);
	private SpriteAnimee AnimationDroite = new SpriteAnimee(SpriteSheet.MonstreFantomeDroite, 16, 16, 3);
	private SpriteAnimee AnimationBas = new SpriteAnimee(SpriteSheet.MonstreFantomeBas, 16, 16, 3);
	private SpriteAnimee AnimationGauche = new SpriteAnimee(SpriteSheet.MonstreFantomeGauche, 16, 16, 3);
	private SpriteAnimee SpriteAnimeeEnCours = AnimationBas;
	
	private double xAbsolu = 0;
	private double yAbsolu = 0;
	private double VitesseMouvement = 0.7;
	
	public FantomeSuiveur(int xInitiale, int yInitiale) {
		this.xActuelle = xInitiale * 16;
		this.yActuelle = yInitiale * 16 ;
		spriteEntite = Sprite.MonstreFantome;	
	}
	
	private void BougerFantomeSuiveur() {
		xAbsolu = 0;
		yAbsolu = 0;
		
		List<Joueur> JoueursAProximitee = niveau.SaisirJoueurs(this, 88);
		if (JoueursAProximitee.size() > 0) {
		
			Joueur joueur = JoueursAProximitee.get(0);
				
			if (xActuelle < joueur.SaisirXActuelle()) xAbsolu += VitesseMouvement;
			else if (xActuelle > joueur.SaisirXActuelle()) xAbsolu -= VitesseMouvement;	
		
			if (yActuelle < joueur.SaisirYActuelle()) yAbsolu += VitesseMouvement;
			else if (yActuelle > joueur.SaisirYActuelle()) yAbsolu -= VitesseMouvement;
		}
		
		if (xAbsolu !=0 || yAbsolu !=0) {
			Bouger(xAbsolu, yAbsolu);
			EnTrainBouger = true;
		} else {
			EnTrainBouger = false;
		}	
	}
	
	public void TickEntite() {
		BougerFantomeSuiveur();
		
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
	}

	public void RenduEntite(Ecran Ecran) {
		int xPrecision = 2;
		int yPrecision = 3;
		
		spriteEntite = SpriteAnimeeEnCours.SaisirSprite();
		Ecran.RenduCreature((int)(xActuelle - xPrecision), (int)(yActuelle - yPrecision), this);			
	}
}
*/