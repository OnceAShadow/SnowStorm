/*
package com.fap.Gigueliou.Entite.Creature.Joueur;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.imageio.ImageIO;

import com.fap.Gigueliou.Jeu;
import com.fap.Gigueliou.Entite.Creature.Creature;
import com.fap.Gigueliou.Entite.Projectile.Projectile;
import com.fap.Gigueliou.Entite.Projectile.ProjectileGuerrier;
import com.fap.Gigueliou.Graphique.Ecran;
import com.fap.Gigueliou.Graphique.Sprite;
import com.fap.Gigueliou.Graphique.SpriteAnimee;
import com.fap.Gigueliou.Graphique.SpriteSheet;
import com.fap.Gigueliou.Graphique.InterfaceUtilisateur.IUBarreProgression;
import com.fap.Gigueliou.Graphique.InterfaceUtilisateur.IUBouton;
import com.fap.Gigueliou.Graphique.InterfaceUtilisateur.IUBoutonActionAuditeur;
import com.fap.Gigueliou.Graphique.InterfaceUtilisateur.IUBoutonAuditeur;
import com.fap.Gigueliou.Graphique.InterfaceUtilisateur.IUEtiquette;
import com.fap.Gigueliou.Graphique.InterfaceUtilisateur.IUGerant;
import com.fap.Gigueliou.Graphique.InterfaceUtilisateur.IUPaneau;
import com.fap.Gigueliou.Intrant.Clavier;
import com.fap.Gigueliou.Intrant.Souris;
import com.fap.Gigueliou.Utilitees.Vecteur2i;

public class Joueur extends Creature {
	
	private String Nom;
	private Clavier Touche;
	public Sprite SpriteJoueur;
	public boolean EnTrainBouger;

	private SpriteAnimee AnimationHaut = new SpriteAnimee(SpriteSheet.HerosGuerrierHaut, 32, 32, 3);
	private SpriteAnimee AnimationDroite = new SpriteAnimee(SpriteSheet.HerosGuerrierDroite, 32, 32, 3);
	private SpriteAnimee AnimationBas = new SpriteAnimee(SpriteSheet.HerosGuerrierBas, 32, 32, 3);
	private SpriteAnimee AnimationGauche = new SpriteAnimee(SpriteSheet.HerosGuerrierGauche, 32, 32, 3);
	private SpriteAnimee SpriteAnimeeEnCours = AnimationBas;

	private int CadenceDeTir = 0;	
	private int NiveauJoueur = 1;
	
	private int QuantitePotionVie = 500;
	private int QuantitePotionMagie = 600;
	private int QuantitePotionExperience = 700;
	String TexteQuantitePotionVie = String.valueOf(QuantitePotionVie);
	String TexteQuantitePotionMagie = String.valueOf(QuantitePotionMagie);
	String TexteQuantitePotionExperience = String.valueOf(QuantitePotionExperience);

	private int PotionVie1 = 10;
	private int PotionMagie1 = 10;
	private int PotionExperience1 = 10;
	private int CoutArme = 20;
	
	private double DoubleATronquer, DoubleTronquer;
	
	private IUGerant IU;
	private IUBarreProgression IUBarreVie;
	private IUBarreProgression IUBarreMagie;
	private IUBarreProgression IUBarreExperience;
	private IUBouton BoutonPotionVie;
	private IUBouton BoutonPotionMagie;
	private IUBouton BoutonPotionExperience;
	private IUBouton BoutonFermerJeu;
	private IUEtiquette EtiquetteQuantitePotionVie;
	private IUEtiquette EtiquetteQuantitePotionMagie;
	private IUEtiquette EtiquetteQuantitePotionExperience;

	BufferedImage ImageBouton = null;
	BufferedImage ImageFlottanteBouton = null;
	
	public Joueur(String Nom, Clavier Touche) {
		this.Nom = Nom;
		this.Touche = Touche;
		SpriteJoueur = Sprite.JoueurGuerrierSud1;
		SpriteAnimeeEnCours = AnimationBas;
		
	}
	
	public Joueur(String Nom, int xActuelle, int yActuelle, Clavier Touche) {
		this.Nom = Nom;
		this.xActuelle = xActuelle;
		this.yActuelle = yActuelle;
		this.Touche = Touche;
		SpriteJoueur = Sprite.JoueurGuerrierSud1;
		CadenceDeTir = ProjectileGuerrier.CADENCE_DE_TIR;
		this.PointVie = 100;
		this.PointVieMaximum = 100.0;
		this.PointViePourcentage = PointVie / PointVieMaximum;
		this.PointMagie = 100;
		this.PointMagieMaximum = 100.0;
		this.PointMagiePourcentage = PointMagie / PointMagieMaximum;
		this.PointExperience = 0;
		this.PointExperienceMaximum = 100.0;
		this.PointExperiencePourcentage = PointExperience / PointExperienceMaximum;

		IU = Jeu.SaisirGerant();
		IUPaneau PaneauCommun = (IUPaneau) new IUPaneau(new Vecteur2i(Jeu.SaisirLargeurResolutionAmplifie(), 0), new Vecteur2i(Jeu.SaisirLargeurIUALEcran(), Jeu.SaisirHauteurCadreJeuALEcran())).DefinirCouleur(0x4d555b);
		IU.AjouterPaneau(PaneauCommun);
		
		IUEtiquette EtiquetteNom = new IUEtiquette(new Vecteur2i((16 * Jeu.SaisirAmplification()) + 2, 250), Nom);
		EtiquetteNom.DefinirCouleur(0x684321);
		EtiquetteNom.DefinirPolice(new Font("Helvetica", Font.BOLD, 30));
		EtiquetteNom.DropShadow = true;
		PaneauCommun.AjouterComposante(EtiquetteNom);
		
		IUBarreVie = new IUBarreProgression(new Vecteur2i(15 * Jeu.SaisirAmplification(), 260), new Vecteur2i(46 * Jeu.SaisirAmplification(), 5 * Jeu.SaisirAmplification()));
		IUBarreVie.DefinirCouleur(0x8b959d);
		IUBarreVie.DefinirCouleurAvantPlan(new Color(0xC60800));
		PaneauCommun.AjouterComposante(IUBarreVie);
	
		IUEtiquette EtiquettePointVie = new IUEtiquette(new Vecteur2i(IUBarreVie.Position.x - 55, IUBarreVie.Position.y + 15), "PVie");
		EtiquettePointVie.DefinirCouleur(0xffffff);
		EtiquettePointVie.DefinirPolice(new Font("Helvetica", Font.PLAIN, 18));
		EtiquettePointVie.DropShadow = true;
		PaneauCommun.AjouterComposante(EtiquettePointVie);
		
		IUBarreMagie = new IUBarreProgression(new Vecteur2i(15 * Jeu.SaisirAmplification(), 286), new Vecteur2i(46 * Jeu.SaisirAmplification(), 5 * Jeu.SaisirAmplification()));
		IUBarreMagie.DefinirCouleur(0x8b959d);
		IUBarreMagie.DefinirCouleurAvantPlan(new Color(0x0131B4));
		PaneauCommun.AjouterComposante(IUBarreMagie);
		
		IUEtiquette EtiquettePointMagie = new IUEtiquette(new Vecteur2i(IUBarreMagie.Position.x - 55, IUBarreMagie.Position.y + 15), "PMag");
		EtiquettePointMagie.DefinirCouleur(0xffffff);
		EtiquettePointMagie.DefinirPolice(new Font("Helvetica", Font.PLAIN, 18));
		EtiquettePointMagie.DropShadow = true;
		PaneauCommun.AjouterComposante(EtiquettePointMagie);
		
		IUBarreExperience = new IUBarreProgression(new Vecteur2i(15 * Jeu.SaisirAmplification(), 312), new Vecteur2i(46 * Jeu.SaisirAmplification(), 5 * Jeu.SaisirAmplification()));
		IUBarreExperience.DefinirCouleur(0x8b959d);
		IUBarreExperience.DefinirCouleurAvantPlan(new Color(0xFCDC12));
		PaneauCommun.AjouterComposante(IUBarreExperience);
		
		IUEtiquette EtiquettePointExperience = new IUEtiquette(new Vecteur2i(IUBarreExperience.Position.x - 55, IUBarreExperience.Position.y + 15), "PExp");
		EtiquettePointExperience.DefinirCouleur(0xffffff);
		EtiquettePointExperience.DefinirPolice(new Font("Helvetica", Font.PLAIN, 18));
		EtiquettePointExperience.DropShadow = true;
		PaneauCommun.AjouterComposante(EtiquettePointExperience);
		
		IUEtiquette EtiquettePotion = new IUEtiquette(new Vecteur2i((1 * Jeu.SaisirAmplification()), 91 * Jeu.SaisirAmplification() - 2), "Potion");
		EtiquettePotion.DefinirCouleur(0x684321);
		EtiquettePotion.DefinirPolice(new Font("Helvetica", Font.BOLD, 20));
		EtiquettePotion.DropShadow = true;
		PaneauCommun.AjouterComposante(EtiquettePotion);
		
		BoutonPotionVie = new IUBouton(new Vecteur2i(5 * Jeu.SaisirAmplification() + 3, 98 * Jeu.SaisirAmplification()), new Vecteur2i (64, 64), false, true, new IUBoutonActionAuditeur() {
			public void Executer() {
				PotionVie();
				
			}
						
		});
		
		BoutonPotionVie.DefinirTexte("Vie");
		PaneauCommun.AjouterComposante(BoutonPotionVie);	
		
		EtiquetteQuantitePotionVie = new IUEtiquette(new Vecteur2i(((5 * Jeu.SaisirAmplification() + 3) + 2), ((98 * Jeu.SaisirAmplification()) + 64) - 2), TexteQuantitePotionVie);
		EtiquetteQuantitePotionVie.DefinirCouleur(0x000000);
		EtiquetteQuantitePotionVie.DefinirPolice(new Font("Helvetica", 0, 14));
		PaneauCommun.AjouterComposante(EtiquetteQuantitePotionVie);
		
		BoutonPotionMagie = new IUBouton(new Vecteur2i(26 * Jeu.SaisirAmplification() + 3, 98 * Jeu.SaisirAmplification()), new Vecteur2i (64, 64), false, true, new IUBoutonActionAuditeur() {
			public void Executer() {
				PotionMagie();	
			}	
		});
		
		BoutonPotionMagie.DefinirTexte("Magie");
		PaneauCommun.AjouterComposante(BoutonPotionMagie);	
		EtiquetteQuantitePotionMagie = new IUEtiquette(new Vecteur2i(((26 * Jeu.SaisirAmplification() + 3) + 2), ((98 * Jeu.SaisirAmplification()) + 64) - 2), TexteQuantitePotionMagie);
		EtiquetteQuantitePotionMagie.DefinirCouleur(0x000000);
		EtiquetteQuantitePotionMagie.DefinirPolice(new Font("Helvetica", 0, 14));
		PaneauCommun.AjouterComposante(EtiquetteQuantitePotionMagie);
		
		BoutonPotionExperience = new IUBouton(new Vecteur2i(47 * Jeu.SaisirAmplification() + 3, 98 * Jeu.SaisirAmplification()), new Vecteur2i (64, 64), false, true, new IUBoutonActionAuditeur() {
			public void Executer() {
				PotionExperience();
			}
			
		});
		
		BoutonPotionExperience.DefinirTexte("Exp");
		PaneauCommun.AjouterComposante(BoutonPotionExperience);	
		
		EtiquetteQuantitePotionExperience = new IUEtiquette(new Vecteur2i(((47 * Jeu.SaisirAmplification() + 3) + 2), ((98 * Jeu.SaisirAmplification()) + 64) - 2), TexteQuantitePotionExperience);
		EtiquetteQuantitePotionExperience.DefinirCouleur(0x000000);
		EtiquetteQuantitePotionExperience.DefinirPolice(new Font("Helvetica", 0, 14));
		PaneauCommun.AjouterComposante(EtiquetteQuantitePotionExperience);
		
		BoutonFermerJeu = new IUBouton(new Vecteur2i(Jeu.SaisirLargeurIUALEcran() - 34, Jeu.SaisirHauteurCadreJeuALEcran() - 34), new Vecteur2i (32, 32), false, true, new IUBoutonActionAuditeur() {
			public void Executer() {
				System.exit(0);
			}
		
		});
		
		BoutonFermerJeu.DefinirBoutonAuditeur(new IUBoutonAuditeur(){
			public void Appuyer(IUBouton Bouton) {
				super.Appuyer(Bouton);
				Bouton.ExecuterAction();
				Bouton.IgnorerProchainAppuyer();
			}
		});
		
		BoutonFermerJeu.DefinirTexte("Close");
		BoutonFermerJeu.BoutonNom.DefinirPolice(new Font("Helvetica", 1, 11));
		PaneauCommun.AjouterComposante(BoutonFermerJeu);	
		
		try {
			ImageBouton = ImageIO.read(new File("res/Textures/IU/IUImageBoutonFermerJeu.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ImageFlottanteBouton =  new BufferedImage(ImageBouton.getWidth(), ImageBouton.getHeight(), BufferedImage.TYPE_INT_ARGB);
		int[] PixelsImageFlottanteBouton = ((DataBufferInt)ImageFlottanteBouton.getRaster().getDataBuffer()).getData();

		for (int yyy = 0; yyy < ImageBouton.getHeight(); yyy++) {
			for (int xxx = 0; xxx < ImageBouton.getWidth(); xxx++) {
				PixelsImageFlottanteBouton[xxx + yyy * ImageFlottanteBouton.getWidth()] = ImageBouton.getRGB(xxx, yyy);
			}
		}
		
		for (int yy = 0; yy < ImageBouton.getHeight(); yy++) {
			for (int xx = 0; xx < ImageBouton.getWidth(); xx++) {
				int Couleur = PixelsImageFlottanteBouton[xx + yy * ImageFlottanteBouton.getWidth()];
				int r = (Couleur & 0xff0000) >> 16;
				int g = (Couleur & 0xff00) >> 8;
				int b = Couleur & 0xff;
				
				r += 50;
				g += 50;
				b += 50;
				
				Couleur &= 0xff000000;
				PixelsImageFlottanteBouton[xx + yy * ImageFlottanteBouton.getWidth()] = Couleur | r << 16 | g << 8 | b;
			}
		}
		
		IUBouton ImageBoutonFermerJeu = new IUBouton(new Vecteur2i(Jeu.SaisirLargeurIUALEcran() - 234, Jeu.SaisirHauteurCadreJeuALEcran() - 34), ImageBouton, false, true, new IUBoutonActionAuditeur() {
			public void Executer() {
				System.out.println("Action Executee");			
			}
		});
		ImageBoutonFermerJeu.DefinirBoutonAuditeur(new IUBoutonAuditeur() {
			public void Entree(IUBouton Bouton) {
				Bouton.DefinirImageBouton(ImageFlottanteBouton);
			}
				
			public void Sortie(IUBouton Bouton) {
				Bouton.DefinirImageBouton(ImageBouton);
			}
		});			
		PaneauCommun.AjouterComposante(ImageBoutonFermerJeu);
	}

	public void TickEntite() {
		// List<Entite> Entitees = niveau.SaisirEntitees(this, 60);
		// System.out.println(Entitees.size());
		// for (Entite lEntite : Entitees) {
		//	System.out.println(lEntite);
		//}
		
		if (EnTrainBouger) SpriteAnimeeEnCours.TickAnimation();
		else SpriteAnimeeEnCours.DefinirImageCadre(0);
		if (CadenceDeTir > 0) CadenceDeTir--;
		
		double xAbsolu = 0, yAbsolu = 0;
		double VitesseMouvement = 1.4;
		if (Touche.Haut) {
			yAbsolu -= VitesseMouvement; 
			SpriteAnimeeEnCours = AnimationHaut;
		}
		
		if (Touche.Droite) {
			xAbsolu += VitesseMouvement; 
			SpriteAnimeeEnCours = AnimationDroite;
		}
		
		if (Touche.Bas) {
			yAbsolu += VitesseMouvement; 
			SpriteAnimeeEnCours = AnimationBas;
		}
		
		if (Touche.Gauche) {
			xAbsolu -= VitesseMouvement; 	
			SpriteAnimeeEnCours = AnimationGauche;
		}
		
		if (xAbsolu !=0 || yAbsolu !=0) {
			Bouger(xAbsolu, yAbsolu);
			EnTrainBouger = true;
		} else {
			EnTrainBouger = false;
		}
		
		LibererProjectile();		
		TickAttaque();
		TickPotion();
	}
	
	public String SaisirNom() {
		return Nom;
	}

	private void LibererProjectile() {
		for (int i = 0; i < niveau.SaisirProjectiles().size(); i++) {
			Projectile ProjectileALiberer = niveau.SaisirProjectiles().get(i);
			if (ProjectileALiberer.EstRetiree()) niveau.SaisirProjectiles().remove(i);
		}
	}

	private void TickAttaque() {
		
		if (Souris.SaisirX() < Jeu.SaisirLargeurResolutionAmplifie()) {
			if (Souris.SaisirBouton() == 3 && CadenceDeTir <= 0 && Souris.SaisirAlternanceBoutonPresserRelacher() <= 1 && PointMagie >= CoutArme) {
				double DirectionX = (Souris.SaisirX() - (Jeu.SaisirLargeurCadreJeuALEcran()/2));
				double DirectionY = (Souris.SaisirY() - (Jeu.SaisirHauteurCadreJeuALEcran()/2));
				double DirectionAttaque = Math.atan2(DirectionY, DirectionX);
				
				Attaquer(xActuelle, yActuelle, DirectionAttaque);
				System.out.println(PointMagie);
				PointMagie = PointMagie - CoutArme; 
				System.out.println(PointMagie);
						
				CadenceDeTir = ProjectileGuerrier.CADENCE_DE_TIR;
				//if (Souris.AlternanceBoutonPresserRelacher <=5)
				Souris.AlternanceBoutonPresserRelacher++;
			}
		}	
		
	}
	
	private void TickPotion() {
		int Dommage = 5;
		
		if (Touche.Dommage) {
			if (PointVie - Dommage >= 0) {
				System.out.println(PointVie);
				PointVie = PointVie - Dommage;
				System.out.println(PointVie);
			}
		}
			
		if (Touche.PotionVie) {
			PotionVie();
		}
		
		if (Touche.PotionMagie) {
			PotionMagie();
		}

		if (Touche.PotionExperience) {
			PotionExperience();
		}
			
		PointViePourcentage = PointVie / PointVieMaximum;
		PointMagiePourcentage = PointMagie / PointMagieMaximum;
		PointExperiencePourcentage = PointExperience / PointExperienceMaximum;
	    		
		DoubleATronquer =  PointViePourcentage;
		DoubleTronquer = BigDecimal.valueOf(DoubleATronquer).setScale(6, RoundingMode.HALF_UP).doubleValue();
		IUBarreVie.DefinirProgression(DoubleTronquer);
		
		DoubleATronquer = PointMagiePourcentage;
		DoubleTronquer = BigDecimal.valueOf(DoubleATronquer).setScale(6, RoundingMode.HALF_UP).doubleValue();
		IUBarreMagie.DefinirProgression(DoubleTronquer);
		
		DoubleATronquer = PointExperiencePourcentage;
		DoubleTronquer = BigDecimal.valueOf(DoubleATronquer).setScale(6, RoundingMode.HALF_UP).doubleValue();
		IUBarreExperience.DefinirProgression(DoubleTronquer);
		
		TexteQuantitePotionVie = String.valueOf(QuantitePotionVie);
		TexteQuantitePotionMagie = String.valueOf(QuantitePotionMagie);
		TexteQuantitePotionExperience = String.valueOf(QuantitePotionExperience);

		EtiquetteQuantitePotionVie.DefinirTexte(TexteQuantitePotionVie);
		EtiquetteQuantitePotionMagie.DefinirTexte(TexteQuantitePotionMagie);
		EtiquetteQuantitePotionExperience.DefinirTexte(TexteQuantitePotionExperience);
	}

	private void PotionVie() {
		if (QuantitePotionVie > 0) {
			if (PointVie == PointVieMaximum) {
				System.out.println("Pas besoin de potion");
			} else {
				if (PointVie > PointVieMaximum - PotionVie1) {
					PointVie = (int)PointVieMaximum - PotionVie1; 
				}
				System.out.println(PointVie);
				PointVie = PointVie + PotionVie1;
				System.out.println(PointVie);
								
				QuantitePotionVie--;
				System.out.println(QuantitePotionVie);
			}
		}
	}	
		
    private void PotionMagie() {
    	if (QuantitePotionMagie > 0) {
    		if (PointMagie == PointMagieMaximum) {
				System.out.println("Pas besoin de potion");
			} else {
	    		if (PointMagie > PointMagieMaximum - PotionMagie1) {
					PointMagie = (int)PointMagieMaximum - PotionMagie1; 
					
				}
				System.out.println(PointMagie);
				PointMagie = PointMagie + PotionMagie1;
				System.out.println(PointMagie);
				QuantitePotionMagie--;
				System.out.println(QuantitePotionMagie);
			}
    	}
    }
	
	private void PotionExperience() {
		if (QuantitePotionExperience > 0) {
			System.out.println(PointExperience);
			PointExperience = PointExperience + PotionExperience1;
			if (PointExperience >= PointExperienceMaximum) {
				int PointExperienceResiduel = (int) (PointExperience - PointExperienceMaximum);
				PointExperience = 0;
				AugmenterNiveau(PointExperienceResiduel);
			}
			System.out.println(PointExperience);				
			QuantitePotionExperience--;
			System.out.println(QuantitePotionExperience);			
		}
	}
	
	private void AugmenterNiveau(int PointExperienceResiduel) {
		PointExperience = PointExperience + PointExperienceResiduel;
		PointExperienceMaximum = PointExperienceMaximum * 2;
		PointVieMaximum = PointVieMaximum + 20;
		PointMagieMaximum = PointMagieMaximum + 20;
		
		NiveauJoueur++;
	}

	public void RenduEntite(Ecran Ecran) {
		int xPrecisionJoueur = 10;
		int yPrecisionJoueur = 17;
				
		SpriteJoueur = SpriteAnimeeEnCours.SaisirSprite();
		Ecran.RenduCreature((int)(xActuelle - xPrecisionJoueur), (int)(yActuelle - yPrecisionJoueur), SpriteJoueur);
	}	
}
*/