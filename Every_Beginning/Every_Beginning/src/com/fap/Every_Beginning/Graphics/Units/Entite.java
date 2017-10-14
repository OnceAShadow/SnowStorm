package com.fap.Gigueliou.Entite;

import java.util.Random;

import com.fap.Gigueliou.Graphique.Ecran;
import com.fap.Gigueliou.Graphique.Sprite;
import com.fap.Gigueliou.Niveau.Niveau;

public class Entite {

	protected double xActuelle, yActuelle;
	private boolean EstRetiree = false;
	protected Niveau niveau;
	protected final Random ALEATOIRE = new Random();
	protected Sprite spriteEntite;
	
	public Entite() {
		
	}
	
	public Entite(int xPosition, int yPosition, Sprite Sprite) {
		this.xActuelle = xPosition;
		this.yActuelle = yPosition;
		this.spriteEntite = Sprite;
		
	}
	
	public void TickEntite(){
		
	}
	
	public void RenduEntite(Ecran Ecran) {
		if (spriteEntite != null) Ecran.RenduSprite((int) xActuelle, (int) yActuelle, spriteEntite, true);
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
	
	public void Initialiser(Niveau Niveau) {
		this.niveau = Niveau;
			
	}
	
}
