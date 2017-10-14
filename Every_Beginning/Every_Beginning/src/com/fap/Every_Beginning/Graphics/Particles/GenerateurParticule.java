/*
package com.fap.Gigueliou.Entite.GenerateurEntite;

import com.fap.Gigueliou.Entite.Particule.Particule;
import com.fap.Gigueliou.Niveau.Niveau;

public class GenerateurParticule extends GenerateurEntite{

	private int DureeDeVie;
	
	public GenerateurParticule(int xPosition, int yPosition,int DureeDeVie, int QuantiteEntite, Niveau Niveau) {
		super(xPosition, yPosition, TypeEntite.PARTICULE, QuantiteEntite, Niveau);
		this.DureeDeVie= DureeDeVie;
		for (int i = 0; i < QuantiteEntite; i++) {
			niveau.AjouterEntite(new Particule(xPosition, yPosition, DureeDeVie));
		}	
	}
}
*/