*/
package com.fap.Gigueliou.Entite.GenerateurEntite;

import com.fap.Gigueliou.Entite.Entite;
import com.fap.Gigueliou.Niveau.Niveau;

public abstract class GenerateurEntite extends Entite{
	
	public enum TypeEntite {
		CREATURE, PARTICULE;
	}
	
	protected TypeEntite typeEntite;
	
	public GenerateurEntite(int xPosition, int yPosition, TypeEntite TypeEntite, int QuantiteEntite, Niveau Niveau) {
		Initialiser(Niveau);
		this.xActuelle = xPosition;
		this.yActuelle = yPosition;
		this.typeEntite = TypeEntite;
		
	}
}
*/