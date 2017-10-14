
package com.fap.Every_Beginning.Graphics.Animations;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {
	private String Path;

	public final int DIMENSIONSPRITESHEET;
	public final int WIDTH_SPRITE, HEIGHT_SPRITE;
	private int WidthSpriteSheet, HeightSpriteSheet;
	public int[] PixelsSpriteSheet;
	/*
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
	*/
	
	
	private Sprite[] Sprites;
	
	public SpriteSheet(SpriteSheet SpSheet, int x, int y, int WidthSpriteSheet, int HeightSpriteSheet, int DimensionSprite) {
		int xx = x * DimensionSprite;
		int yy = y * DimensionSprite;
		int Width = WidthSpriteSheet * DimensionSprite;
		int Height = HeightSpriteSheet * DimensionSprite;
		
		if (WidthSpriteSheet == HeightSpriteSheet) DIMENSIONSPRITESHEET = WidthSpriteSheet;
		else DIMENSIONSPRITESHEET = -1;
		
		WIDTH_SPRITE = Width;
		HEIGHT_SPRITE = Height;
		PixelsSpriteSheet = new int[Width * Height];
		
		for (int y0 = 0; y0 < Height; y0++) {
			int yPosition = yy + y0;
			for (int x0 = 0; x0 < Width; x0++) {
				int xPosition = xx + x0;
				
				PixelsSpriteSheet[x0 + y0 * Width] = SpSheet.PixelsSpriteSheet[xPosition + yPosition * SpSheet.WIDTH_SPRITE];
								
			}
		}
		
		int Frame = 0;
		Sprites = new Sprite[WidthSpriteSheet * HeightSpriteSheet];
		
		for (int yAbsolu = 0; yAbsolu < HeightSpriteSheet; yAbsolu++) {
			for (int xAbsolu = 0; xAbsolu < WidthSpriteSheet; xAbsolu++) {
				int[] PixelsSprite = new int[DimensionSprite * DimensionSprite];
				for (int y1 = 0; y1 < DimensionSprite; y1++) {
					for (int x1 = 0; x1 < DimensionSprite; x1++) {
			 
						PixelsSprite[x1 + y1 * DimensionSprite] = PixelsSpriteSheet[(x1 + xAbsolu * DimensionSprite) + (y1 + yAbsolu * DimensionSprite) * WIDTH_SPRITE];
											
					}
				}	 
				Sprite sprite = new Sprite(PixelsSprite, DimensionSprite, DimensionSprite);	
				Sprites[Frame++] = sprite;
			}
		}	
	}
/*
	public SpriteSheet(String Path, int WidthSpriteSheet, int HeightSpriteSheet) {
		this.Path = Path;
		DIMENSIONSPRITESHEET = - 1;
		this.WidthSpriteSheet = WidthSpriteSheet;
		this.HeightSpriteSheet = HeightSpriteSheet;
		PixelsSpriteSheet = new int[WidthSpriteSheet * HeightSpriteSheet];
		LoadSpriteSheet();
	}*/

	public Sprite[] GetSprites() {
		return Sprites;
	}

	public int GetLargeurSpriteSheet() {
		return WidthSpriteSheet;
	}
	
	public int GetSpriteSheet() {
		return HeightSpriteSheet;
	}
	
	public int[] GetPixels() {
		return PixelsSpriteSheet;
	}
	
	private void LoadSpriteSheet() {
		try {
			System.out.println("Chargement" + Path);
			BufferedImage ImageSpriteSheet = ImageIO.read(SpriteSheet.class.getResource(Path));
			System.out.println("Reussi" + Path);
			
			WidthSpriteSheet = ImageSpriteSheet.getWidth();
			HeightSpriteSheet = ImageSpriteSheet.getHeight();
			PixelsSpriteSheet = new int[WidthSpriteSheet * HeightSpriteSheet];
			ImageSpriteSheet.getRGB(0, 0, WidthSpriteSheet, HeightSpriteSheet, PixelsSpriteSheet, 0, WidthSpriteSheet);
		} 	catch (IOException e) {
				e.printStackTrace();
		}
			catch (Exception e) {
				System.err.println("Rater");
		}
	}
}
