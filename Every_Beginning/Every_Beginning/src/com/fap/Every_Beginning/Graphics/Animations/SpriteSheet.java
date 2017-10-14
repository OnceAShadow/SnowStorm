
package com.fap.Every_Beginning.Graphics.Animations;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {
	private String Path;

	public final int DIMENSIONSPRITESHEET;
	public final int WIDTH_SPRITE, HEIGHT_SPRITE;
	private int LargeurSpriteSheet, HauteurSpriteSheet;
	public int[] PixelsSpriteSheet;
	
	public static SpriteSheet TuilesHeros = new SpriteSheet("/Textures/SpriteSheet/SpriteSheetHeros.png", 256);
	public static SpriteSheet TuilesArmes = new SpriteSheet("/Textures/SpriteSheet/SpriteSheetArmes.png", 256);
	public static SpriteSheet TuilesNiveauHUB = new SpriteSheet("/Textures/SpriteSheet/SpriteSheetNiveauHUB.png", 256);
	
	public static SpriteSheet HerosGuerrier = new SpriteSheet("/Textures/SpriteSheet/SpriteSheetHerosGuerrier.png", 128, 96);
	public static SpriteSheet HerosGuerrierHaut = new SpriteSheet(HerosGuerrier, 2, 0, 1, 3, 32);
	public static SpriteSheet HerosGuerrierGauche = new SpriteSheet(HerosGuerrier, 3, 0, 1, 3, 32);
	public static SpriteSheet HerosGuerrierBas = new SpriteSheet(HerosGuerrier, 0, 0, 1, 3, 32);
	public static SpriteSheet HerosGuerrierDroite = new SpriteSheet(HerosGuerrier, 1, 0, 1, 3, 32);
	
	public static SpriteSheet MonstreFantome = new SpriteSheet("/Textures/SpriteSheet/SpriteSheetMonstreFantome.png", 64, 48);
	public static SpriteSheet MonstreFantomeHaut = new SpriteSheet(MonstreFantome, 0, 0, 1, 3, 16);
	public static SpriteSheet MonstreFantomeDroite = new SpriteSheet(MonstreFantome, 1, 0, 1, 3, 16);
	public static SpriteSheet MonstreFantomeBas = new SpriteSheet(MonstreFantome, 2, 0, 1, 3, 16);
	public static SpriteSheet MonstreFantomeGauche = new SpriteSheet(MonstreFantome, 3, 0, 1, 3, 16);
	
	public static SpriteSheet NPCPapillon = new SpriteSheet("/Textures/SpriteSheet/SpriteSheetNPCPapillon.png", 48, 12);
	public static SpriteSheet NPCPapillonMouvement = new SpriteSheet(NPCPapillon, 0, 0, 4, 1, 12);
	
	public static SpriteSheet NPCLapin = new SpriteSheet("/Textures/SpriteSheet/SpriteSheetNPCLapin.png", 64, 48);
	public static SpriteSheet NPCLapinHaut = new SpriteSheet(NPCLapin, 0, 0, 1, 3, 16);
	public static SpriteSheet NPCLapinDroite = new SpriteSheet(NPCLapin, 1, 0, 1, 3, 16);
	public static SpriteSheet NPCLapinBas = new SpriteSheet(NPCLapin, 2, 0, 1, 3, 16);
	public static SpriteSheet NPCLapinGauche = new SpriteSheet(NPCLapin, 3, 0, 1, 3, 16);
	private Sprite[] Sprites;
	
	public SpriteSheet(SpriteSheet SpSheet, int x, int y, int LargeurSpriteSheet, int HauteurSpriteSheet, int DimensionSprite) {
		int xx = x * DimensionSprite;
		int yy = y * DimensionSprite;
		int Largeur = LargeurSpriteSheet * DimensionSprite;
		int Hauteur = HauteurSpriteSheet * DimensionSprite;
		
		if (LargeurSpriteSheet == HauteurSpriteSheet) DIMENSIONSPRITESHEET = LargeurSpriteSheet;
		else DIMENSIONSPRITESHEET = -1;
		
		WIDTH_SPRITE = Largeur;
		HEIGHT_SPRITE = Hauteur;
		PixelsSpriteSheet = new int[Largeur * Hauteur];
		
		for (int y0 = 0; y0 < Hauteur; y0++) {
			int yPosition = yy + y0;
			for (int x0 = 0; x0 < Largeur; x0++) {
				int xPosition = xx + x0;
				
				PixelsSpriteSheet[x0 + y0 * Largeur] = SpSheet.PixelsSpriteSheet[xPosition + yPosition * SpSheet.LARGEUR_SPRITE];
								
			}
		}
		
		int ImageCadre = 0;
		Sprites = new Sprite[LargeurSpriteSheet * HauteurSpriteSheet];
		
		for (int yAbsolu = 0; yAbsolu < HauteurSpriteSheet; yAbsolu++) {
			for (int xAbsolu = 0; xAbsolu < LargeurSpriteSheet; xAbsolu++) {
				int[] PixelsSprite = new int[DimensionSprite * DimensionSprite];
				for (int y1 = 0; y1 < DimensionSprite; y1++) {
					for (int x1 = 0; x1 < DimensionSprite; x1++) {
			 
						PixelsSprite[x1 + y1 * DimensionSprite] = PixelsSpriteSheet[(x1 + xAbsolu * DimensionSprite) + (y1 + yAbsolu * DimensionSprite) * WIDTH_SPRITE];
											
					}
				}	 
				Sprite sprite = new Sprite(PixelsSprite, DimensionSprite, DimensionSprite);	
				Sprites[ImageCadre++] = sprite;
			}
		}	
	}
<<<<<<< HEAD

=======
	
	public SpriteSheet(String CheminDAcces, int DimensionSpriteSheet) {
		this.CheminDAcces = CheminDAcces;
		DIMENSIONSPRITESHEET = DimensionSpriteSheet;
		WIDTH_SPRITE = DimensionSpriteSheet;
		HEIGHT_SPRITE = DimensionSpriteSheet;
		PixelsSpriteSheet = new int[DIMENSIONSPRITESHEET * DIMENSIONSPRITESHEET];
		ChargementSpriteSheet();
	}
	
>>>>>>> spritesheet 1
	public SpriteSheet(String CheminDAcces, int LargeurSpriteSheet, int HauteurSpriteSheet) {
		this.CheminDAcces = CheminDAcces;
		DIMENSIONSPRITESHEET = - 1;
		WIDTH_SPRITE = LargeurSpriteSheet;
		HEIGHT_SPRITE = HauteurSpriteSheet;
		PixelsSpriteSheet = new int[WIDTH_SPRITE * HEIGHT_SPRITE];
		ChargementSpriteSheet();
	}

	public Sprite[] SaisirSprites() {
		return Sprites;
	}

	public int SaisirLargeurSpriteSheet() {
		return LargeurSpriteSheet;
	}
	
	public int SaisirHauteurSpriteSheet() {
		return HauteurSpriteSheet;
	}
	
	public int[] SaisirPixels() {
		return PixelsSpriteSheet;
	}
	
	private void ChargementSpriteSheet() {
		try {
		//	System.out.println("Chargement" + CheminDAcces);
			BufferedImage ImageSpriteSheet = ImageIO.read(SpriteSheet.class.getResource(CheminDAcces));
		//	System.out.println("Reussi" + CheminDAcces);
			
			LargeurSpriteSheet = ImageSpriteSheet.getWidth();
			HauteurSpriteSheet = ImageSpriteSheet.getHeight();
			PixelsSpriteSheet = new int[LargeurSpriteSheet * HauteurSpriteSheet];
			ImageSpriteSheet.getRGB(0, 0, LargeurSpriteSheet, HauteurSpriteSheet, PixelsSpriteSheet, 0, LargeurSpriteSheet);
		} 	catch (IOException e) {
				e.printStackTrace();
		}
			catch (Exception e) {
				System.err.println("Rater");
		}
	}
}
*/