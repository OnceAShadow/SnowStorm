
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
	
	
	
	public static SpriteSheet Tiles_Base = new SpriteSheet("/Textures/SpriteSheets/Tiles/TilesStarterKit.png", 256, 192, 64, 64);
	
	public static SpriteSheet Player_Base = new SpriteSheet("/Textures/SpriteSheets/Players/Player_Base/Player_Base.png", 256, 192, 64, 64);

	public static SpriteSheet Player_Base_Up = new SpriteSheet(Player_Base, 2, 0, 1, 3, 64, 64);
	public static SpriteSheet Player_Base_Left = new SpriteSheet(Player_Base, 3, 0, 1, 3, 64, 64);
	public static SpriteSheet Player_Base_Down = new SpriteSheet(Player_Base, 0, 0, 1, 3, 64, 64);
	public static SpriteSheet Player_Base_Right = new SpriteSheet(Player_Base, 1, 0, 1, 3, 64, 64);
	
	public static SpriteSheet Zombie_Base = new SpriteSheet("/Textures/SpriteSheets/Mobs/Zombie_Base/Zombie_Base.png", 256, 192, 64, 64);

	public static SpriteSheet Zombie_Base_Up = new SpriteSheet(Zombie_Base, 2, 0, 1, 3, 64, 64);
	public static SpriteSheet Zombie_Base_Left = new SpriteSheet(Zombie_Base, 3, 0, 1, 3, 64, 64);
	public static SpriteSheet Zombie_Base_Down = new SpriteSheet(Zombie_Base, 0, 0, 1, 3, 64, 64);
	public static SpriteSheet Zombie_Base_Right = new SpriteSheet(Zombie_Base, 1, 0, 1, 3, 64, 64);
	
		
	private Sprite[] Sprites;
	
	public SpriteSheet(SpriteSheet SpSheet, int x, int y, int AmountSpriteWidth, int AmountSpriteHeight, int DimensionSpriteWidth, int DimensionSpriteHeight) {
		int xx = x * DimensionSpriteWidth;
		int yy = y * DimensionSpriteHeight;
		int WidthSprite = AmountSpriteWidth * DimensionSpriteWidth;
		int HeightSprite = AmountSpriteHeight * DimensionSpriteHeight;
		
		if (AmountSpriteWidth == AmountSpriteHeight) DIMENSIONSPRITESHEET = AmountSpriteWidth;
		else DIMENSIONSPRITESHEET = -1;
		
		WIDTH_SPRITE = WidthSprite;
		HEIGHT_SPRITE = HeightSprite;
		PixelsSpriteSheet = new int[WidthSprite * HeightSprite];
		
		for (int y0 = 0; y0 < HeightSprite; y0++) {
			int yPosition = yy + y0;
			for (int x0 = 0; x0 < WidthSprite; x0++) {
				int xPosition = xx + x0;
			
				PixelsSpriteSheet[x0 + y0 * WidthSprite] = SpSheet.PixelsSpriteSheet[xPosition + yPosition * SpSheet.WIDTH_SPRITE];
							
			}
		}
	
		int Frame = 0;
		Sprites = new Sprite[AmountSpriteWidth * AmountSpriteHeight];
	
		for (int yAbsolu = 0; yAbsolu < AmountSpriteHeight; yAbsolu++) {
			for (int xAbsolu = 0; xAbsolu < AmountSpriteWidth; xAbsolu++) {
				int[] PixelsSprite = new int[DimensionSpriteWidth * DimensionSpriteHeight];
				for (int y1 = 0; y1 < DimensionSpriteHeight; y1++) {
					for (int x1 = 0; x1 < DimensionSpriteWidth; x1++) {
		 
						PixelsSprite[x1 + y1 * DimensionSpriteWidth] = PixelsSpriteSheet[(x1 + xAbsolu * DimensionSpriteWidth) + (y1 + yAbsolu * DimensionSpriteHeight) * WIDTH_SPRITE];
										
					}
				}	 
				Sprite sprite = new Sprite(PixelsSprite, DimensionSpriteWidth, DimensionSpriteHeight);	
				Sprites[Frame++] = sprite;
			}
		}	
		
		
	}

	public SpriteSheet(String Path, int WidthSpriteSheet, int HeightSpriteSheet, int WidthSprite, int HeightSprite) {
		this.Path = Path;
		DIMENSIONSPRITESHEET = - 1;
		this.WidthSpriteSheet = WidthSpriteSheet;
		this.HeightSpriteSheet = HeightSpriteSheet;
		WIDTH_SPRITE = WidthSprite;
		HEIGHT_SPRITE = HeightSprite;
		PixelsSpriteSheet = new int[WidthSpriteSheet * HeightSpriteSheet];
		LoadSpriteSheet();
	}

	public Sprite[] GetSprites() {
		return Sprites;
	}

	public int GetWidthSpriteSheet() {
		return WidthSpriteSheet;
	}
	
	public int GetHeightSpriteSheet() {
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
