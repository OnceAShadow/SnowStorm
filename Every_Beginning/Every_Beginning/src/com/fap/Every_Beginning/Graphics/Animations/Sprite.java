/*
package com.fap.Gigueliou.Graphique;

public class Sprite {

	public final int DIMENSIONSPRITE;
	private int x, y;
	public int LargeurSprite, HauteurSprite;
	public int[] PixelsSprite;
	protected SpriteSheet spriteSheet;
	
	// SpritesMateriel
	public static Sprite TuileVide = new Sprite(16, 0x5D3F97);
	public static Sprite HUBGazon1 = new Sprite(16, 0, 0, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBGazon2 = new Sprite(16, 0, 1, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBGazon3 = new Sprite(16, 0, 2, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBGazon4 = new Sprite(16, 0, 3, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBGazon5 = new Sprite(16, 0, 4, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBGazon6 = new Sprite(16, 0, 5, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBGazon7 = new Sprite(16, 0, 6, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBGazon8 = new Sprite(16, 0, 7, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBGazon9 = new Sprite(16, 1, 0, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBGazon10 = new Sprite(16, 1, 1, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBGazon11 = new Sprite(16, 1, 2, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBGazon12 = new Sprite(16, 1, 3, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBGazon13 = new Sprite(16, 1, 6, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBGazon14 = new Sprite(16, 1, 7, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBSable = new Sprite(16, 4, 0, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBEau1 = new Sprite(16, 2, 0, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBEau2 = new Sprite(16, 2, 1, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBEau3 = new Sprite(16, 2, 2, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBEau4 = new Sprite(16, 2, 3, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBEau5 = new Sprite(16, 2, 4, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBEau6 = new Sprite(16, 2, 5, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBEau7 = new Sprite(16, 2, 6, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBEau8 = new Sprite(16, 2, 7, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBEau9 = new Sprite(16, 3, 0, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBEau10 = new Sprite(16, 2, 1, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBEau11 = new Sprite(16, 2, 2, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBEau12 = new Sprite(16, 2, 3, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBLave = new Sprite(16, 4, 1, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBNeige = new Sprite(16, 5, 0, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBRoche = new Sprite(16, 6, 0, SpriteSheet.TuilesNiveauHUB);
	
	public static Sprite HUBPatio1 = new Sprite(16, 8, 0, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio2 = new Sprite(16, 9, 0, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio3 = new Sprite(16, 10, 0, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio4 = new Sprite(16, 11, 0, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio5 = new Sprite(16, 12, 0, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio6 = new Sprite(16, 13, 0, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio7 = new Sprite(16, 14, 0, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio8 = new Sprite(16, 15, 0, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio9 = new Sprite(16, 8, 1, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio10 = new Sprite(16, 9, 1, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio11 = new Sprite(16, 10, 1, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio12 = new Sprite(16, 11, 1, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio13 = new Sprite(16, 12, 1, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio14 = new Sprite(16, 13, 1, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio15 = new Sprite(16, 14, 1, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio16 = new Sprite(16, 15, 1, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio17 = new Sprite(16, 8, 2, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio18 = new Sprite(16, 9, 2, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio19 = new Sprite(16, 10, 2, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio20 = new Sprite(16, 11, 2, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio21 = new Sprite(16, 12, 2, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio22 = new Sprite(16, 13, 2, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio23 = new Sprite(16, 14, 2, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio24 = new Sprite(16, 15, 2, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio25 = new Sprite(16, 8, 3, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio26 = new Sprite(16, 9, 3, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio27 = new Sprite(16, 10, 3, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio28 = new Sprite(16, 11, 3, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio29 = new Sprite(16, 12, 3, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio30 = new Sprite(16, 13, 3, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio31 = new Sprite(16, 14, 3, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio32 = new Sprite(16, 15, 3, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio33 = new Sprite(16, 8, 4, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio34 = new Sprite(16, 9, 4, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio35 = new Sprite(16, 10, 4, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio36 = new Sprite(16, 11, 4, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio37 = new Sprite(16, 12, 4, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio38 = new Sprite(16, 13, 4, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio39 = new Sprite(16, 14, 4, SpriteSheet.TuilesNiveauHUB);
	public static Sprite HUBPatio40 = new Sprite(16, 15, 4, SpriteSheet.TuilesNiveauHUB);
	
	// Sprites Joueur
	public static Sprite JoueurGuerrierNord1 = new Sprite(32, 2, 0, SpriteSheet.TuilesHeros);
	public static Sprite JoueurGuerrierNord2 = new Sprite(32, 2, 1, SpriteSheet.TuilesHeros);
	public static Sprite JoueurGuerrierNord3 = new Sprite(32, 2, 2, SpriteSheet.TuilesHeros);
	public static Sprite JoueurGuerrierEst1 = new Sprite(32, 1, 0, SpriteSheet.TuilesHeros);
	public static Sprite JoueurGuerrierEst2 = new Sprite(32, 1, 1, SpriteSheet.TuilesHeros);
	public static Sprite JoueurGuerrierEst3 = new Sprite(32, 1, 2, SpriteSheet.TuilesHeros);
	public static Sprite JoueurGuerrierSud1 = new Sprite(32, 0, 0, SpriteSheet.TuilesHeros);
	public static Sprite JoueurGuerrierSud2 = new Sprite(32, 0, 1, SpriteSheet.TuilesHeros);
	public static Sprite JoueurGuerrierSud3 = new Sprite(32, 0, 2, SpriteSheet.TuilesHeros);
	public static Sprite JoueurGuerrierOuest1 = new Sprite(32, 3, 0, SpriteSheet.TuilesHeros);
	public static Sprite JoueurGuerrierOuest2 = new Sprite(32, 3, 1, SpriteSheet.TuilesHeros);
	public static Sprite JoueurGuerrierOuest3 = new Sprite(32, 3, 2, SpriteSheet.TuilesHeros);
	public static Sprite JoueurMiniGuerrier = new Sprite(16, 0, 13, SpriteSheet.TuilesHeros);
	public static Sprite JoueurMiniArcher = new Sprite(16, 1, 13, SpriteSheet.TuilesHeros);
	public static Sprite JoueurMiniVoleur = new Sprite(16, 0, 14, SpriteSheet.TuilesHeros);
	public static Sprite JoueurMiniMage = new Sprite(16, 1, 14, SpriteSheet.TuilesHeros);
	public static Sprite JoueurPetiteArmee = new Sprite(32, 0, 6, SpriteSheet.TuilesHeros);
	
	// Sprites Armes
	public static Sprite ProjectileGuerrier1 = new Sprite(16, 0, 0, SpriteSheet.TuilesArmes);
	public static Sprite ProjectileGuerrier2 = new Sprite(16, 1, 0, SpriteSheet.TuilesArmes);
	public static Sprite ProjectileGuerrier3 = new Sprite(16, 0, 1, SpriteSheet.TuilesArmes);
	
	// Sprites Particules	
	public static Sprite Particules1 = new Sprite(3, 0xFFAAAAAA);
	
	// Sprites Monstres
	public static Sprite MonstreFantome = new Sprite(16, 0, 0, SpriteSheet.MonstreFantomeBas);
	
	// Sprites NPC
	public static Sprite NPCPapillon = new Sprite(12, 0, 0, SpriteSheet.NPCPapillonMouvement);
	public static Sprite NPCLapin = new Sprite(12, 0, 0, SpriteSheet.NPCLapinBas);
	
	protected Sprite(SpriteSheet SpriteSheet, int LargeurSprite, int HauteurSprite) {
		
		this.LargeurSprite = LargeurSprite;
		this.HauteurSprite = HauteurSprite;
		this.spriteSheet = SpriteSheet;
	
		// cest la meme syntaxe que : DIMENSIONSPRITE = (LargeurSprite == HauteurSprite) ? LargeurSprite : -1;
		if (LargeurSprite == HauteurSprite) DIMENSIONSPRITE = LargeurSprite;
		else DIMENSIONSPRITE = -1;	
	}
		
	public Sprite(int DimensionSprite, int x, int y, SpriteSheet spriteSheet) {
		DIMENSIONSPRITE = DimensionSprite;
		this.LargeurSprite = DimensionSprite;
		this.HauteurSprite = DimensionSprite;
		PixelsSprite = new int[LargeurSprite * HauteurSprite];
		this.x = x * DIMENSIONSPRITE;
		this.y = y * DIMENSIONSPRITE;
		this.spriteSheet = spriteSheet;
		ChargementSprite();		
	}

	public Sprite(int LargeurSprite, int HauteurSprite, int Couleur) {
		DIMENSIONSPRITE = - 1;
		this.LargeurSprite = LargeurSprite;
		this.HauteurSprite = HauteurSprite;
		PixelsSprite = new int[LargeurSprite * HauteurSprite];
		DefinirCouleur(Couleur);
	}
	
	public Sprite(int DimensionSprite, int Couleur) {
		DIMENSIONSPRITE = DimensionSprite;
		this.LargeurSprite = DimensionSprite;
		this.HauteurSprite = DimensionSprite;
		PixelsSprite = new int[LargeurSprite * HauteurSprite];
		DefinirCouleur(Couleur);
	}

	public Sprite(int[] PixelsSprite, int LargeurSprite, int HauteurSprite) {
		if (LargeurSprite == HauteurSprite) DIMENSIONSPRITE = LargeurSprite;
		else DIMENSIONSPRITE = -1;
		this.LargeurSprite = LargeurSprite;
		this.HauteurSprite = HauteurSprite;
		this.PixelsSprite = new int[PixelsSprite.length];
		for (int i = 0; i < PixelsSprite.length; i++) {
			this.PixelsSprite[i] = PixelsSprite[i];
		}			
	}
	
	public static Sprite Rotationner(Sprite sprite, double Angle) {
		return new Sprite(Rotation(sprite.PixelsSprite, sprite.LargeurSprite, sprite.HauteurSprite, Angle), sprite.LargeurSprite, sprite.HauteurSprite);
	}
	
	public static int[] Rotation(int[] Pixels, int Largeur, int Hauteur, double Angle) {
		int[] Resultat = new int[Largeur * Hauteur];
		
		double nx_x = RotationX(-Angle, 1.0, 0.0);
		double nx_y = RotationY(-Angle, 1.0, 0.0);
		double ny_x = RotationX(-Angle, 0.0, 1.0);
		double ny_y = RotationY(-Angle, 0.0, 1.0);
		
		double x0 = RotationX(- Angle, - Largeur / 2.0, - Hauteur / 2.0) + Largeur / 2.0;
		double y0 = RotationY(- Angle, - Largeur / 2.0, - Hauteur / 2.0) + Hauteur / 2.0;
		
		for (int y = 0; y < Hauteur; y++) {
			double x1 = x0;
			double y1 = y0;
			
			for (int x = 0; x < Largeur; x++) {
				int xx = (int) x1;
				int yy = (int) y1;
				int Couleur = 0;
				
				if (xx < 0 || xx >= Largeur || yy < 0 || yy >= Hauteur) Couleur = 0xFFFF00FF;
				else {
					Couleur = Pixels[xx + yy * Largeur];
				}
				
			//	System.out.println("Couleur : " + Couleur);
			//	System.out.println("Alpha : " + ALPHA_COULEUR1);
				
				Resultat[x + y * Largeur] = Couleur;
				x1 += nx_x;
				y1 += nx_y;		
			}
			x0 += ny_x;
			y0 += ny_y;
		}
		return Resultat;	
	}
	
	private static double RotationX(double Angle, double x, double y) {
		double cos = Math.cos(Angle - Math.PI /1.67);
		double sin = Math.sin(Angle - Math.PI /1.67);
		double Resultat = x * cos + y * -sin;
		return Resultat;
	}
	
	private static double RotationY(double Angle, double x, double y) {
		double cos = Math.cos(Angle - Math.PI /1.14);
		double sin = Math.sin(Angle - Math.PI /1.14);
		double Resultat = x * sin + y * cos;
		return Resultat;
	}
	
	public static Sprite[] Separer(SpriteSheet Sheet) {
		int QuantiteSprite = ((Sheet.SaisirLargeurSpriteSheet() * Sheet.SaisirHauteurSpriteSheet()) / (Sheet.LARGEUR_SPRITE * Sheet.HAUTEUR_SPRITE));
		Sprite[] Sprites = new Sprite[QuantiteSprite];
		int SpriteEnCours = 0;
		int[] PixelsEnCours = new int[Sheet.LARGEUR_SPRITE * Sheet.HAUTEUR_SPRITE];
		
		for (int yPosition = 0; yPosition < Sheet.SaisirHauteurSpriteSheet() / Sheet.HAUTEUR_SPRITE; yPosition++) {
			for (int xPosition = 0; xPosition < Sheet.SaisirLargeurSpriteSheet() / Sheet.LARGEUR_SPRITE; xPosition++) {
				
				for (int yEnCours = 0; yEnCours < Sheet.HAUTEUR_SPRITE; yEnCours++){
					for (int xEnCours = 0; xEnCours < Sheet.LARGEUR_SPRITE; xEnCours++){
						int xDecallage = (xEnCours + xPosition * Sheet.LARGEUR_SPRITE);
						int yDecallage = (yEnCours + yPosition * Sheet.HAUTEUR_SPRITE);
						PixelsEnCours[xEnCours + yEnCours * Sheet.LARGEUR_SPRITE] = Sheet.SaisirPixels()[xDecallage + yDecallage * Sheet.SaisirLargeurSpriteSheet()];				
					}
				}
				
				Sprites[SpriteEnCours] = new Sprite(PixelsEnCours, Sheet.LARGEUR_SPRITE, Sheet.HAUTEUR_SPRITE);
				SpriteEnCours++;
			}
		}	
		return Sprites;
	}

	private void DefinirCouleur(int Couleur) {
		for(int i = 0; i < LargeurSprite * HauteurSprite; i++) {
			PixelsSprite[i] = Couleur;
		}
	}
	
	public int SaisirLargeurSprite() {
		return LargeurSprite;
	}
	
	public int SaisirHauteurSprite() {
		return HauteurSprite;
	}
	
	private void ChargementSprite() {
		for (int y = 0; y < LargeurSprite; y++) {
			for (int x =0; x < LargeurSprite; x++) {
				PixelsSprite[x + y * LargeurSprite] = spriteSheet.PixelsSpriteSheet[(x + this.x) + (y + this.y) * spriteSheet.LARGEUR_SPRITE];
				
			}
		}
	}	
}
*/